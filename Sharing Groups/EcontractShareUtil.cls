public with sharing class EcontractShareUtil {
    
    private EcontractShareUtil() {}

    public static void copyBookingSharesToEcontract(List<Id> bookingIds) {
        // The Owner share is special, and we won't be
        // able to mirror it. EContracts will have their
        // own Owner based on whomever created the record.

        mirrorSharesOnEContract(
            [
                SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
                FROM nihrm__Booking__Share
                WHERE RowCause != 'Owner' AND ParentId IN :bookingIds
            ]
        );
    }

    public static void mirrorSharesOnEcontract(List<nihrm__Booking__Share> bookingShares) {
        // Construct a Map keyed by the Booking records,
        // with a List of each Share for that Booking record
        // as the value.

        Map<Id, List<nihrm__Booking__Share>> sharesByBookingId = new Map<Id, List<nihrm__Booking__Share>>();
        for (nihrm__Booking__Share b : bookingShares) {
            System.debug(b);
            List<nihrm__Booking__Share> shares = sharesByBookingId.get(b.ParentId);
            if (null == shares)
                shares = new List<nihrm__Booking__Share>();

            shares.add(b);
            sharesByBookingId.put(b.ParentId, shares);
        }

        // Find all of the EContract records that have
        // lookups to the Booking records that we found
        // Share records for.

        List<Sertifi2_0__TestContract__c> econtracts = [
            SELECT Id, sertifisem__Booking__c
            FROM Sertifi2_0__TestContract__c
            WHERE sertifisem__Booking__c IN :sharesByBookingId.keySet()
        ];

        // Loop over the eContracts and build a share
        // for each one that mirrors the Booking it relates to

        // You luck out a bit on the Salesforce implementation
        // of __Share objects. The system won't create duplicates,
        // and it won't error out if you try. It creates unique
        // records, and skips over or merges duplicates.

        List<Sertifi2_0__TestContract__Share> econShares = new List<Sertifi2_0__TestContract__Share>();

        for (Sertifi2_0__TestContract__c econ : econtracts) {
            List<nihrm__Booking__Share> parentBookingShares = sharesByBookingId.get(
                econ.sertifisem__Booking__c
            );
            for (nihrm__Booking__Share bookingShare : parentBookingShares) {
                // Everything the same as the Booking__Share,
                // except now the parent is an EContract

                econShares.add(
                    new Sertifi2_0__TestContract__Share(
                        ParentId = econ.Id,
                        UserOrGroupId = bookingShare.UserOrGroupId,
                        AccessLevel = bookingShare.AccessLevel,
                        RowCause = 'Manual'
                    )
                );
            }
        }

        insert econShares;
    }
}
