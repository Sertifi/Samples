public with sharing class EcontractShareUtil {

    public static void copyBookingSharesToEcontract(List<Id> bookingIds) {
        // The Owner share is special, and we won't be
        // able to mirror it. EContracts will have their
        // own Owner based on whomever created the record.

        mirrorSharesOnEContract(
            [
                SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
                FROM nihrm__Booking__Share
                // WHERE RowCause != 'Owner'
                WHERE IsDeleted = FALSE AND ParentId IN :bookingIds
            ]
        );
    }

    public static void mirrorSharesOnEcontract(List<nihrm__Booking__Share> bookingShares) {
        // Construct a Map keyed by the Booking records,
        // with a List of each Share for that Booking record
        // as the value.

        // Also build a list of the Ids of User/Groups in
        // order to look up User records later.

        Map<Id, List<nihrm__Booking__Share>> sharesByBookingId = new Map<Id, List<nihrm__Booking__Share>>();
        List<Id> userOrGroupIds = new List<Id>();
        for (nihrm__Booking__Share b : bookingShares) {
            userOrGroupIds.add(b.UserOrGroupId);

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

        List<Sertifi2_0__TestContract__Share> existingShares = [
            SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
            FROM Sertifi2_0__TestContract__Share
            WHERE IsDeleted = FALSE AND ParentId IN :econtracts
        ];

        // Map *these* out by their EContract Id.
        Map<Id, List<Sertifi2_0__TestContract__Share>> sharesByEcontractId = new Map<Id, List<Sertifi2_0__TestContract__Share>>();
        for (Sertifi2_0__TestContract__Share c : existingShares) {
            List<Sertifi2_0__TestContract__Share> shares = sharesByEcontractId.get(c.ParentId);
            if (null == shares)
                shares = new List<Sertifi2_0__TestContract__Share>();

            shares.add(c);
            sharesByEcontractId.put(c.ParentId, shares);
        }

        // Query User records for the UserOrGroupIds, and get their
        // IsActive Status. These are Map'd by Id to look up in the
        // loop over Booking shares.
        Map<Id, User> shareUsers = new Map<Id, User>(
            [SELECT Id, IsActive FROM User WHERE Id IN :userOrGroupIds]
        );

        // Loop over the eContracts and build a share
        // for each one that mirrors the Booking it relates to

        // You luck out a bit on the Salesforce implementation
        // of __Share objects. The system won't create duplicates,
        // and it won't error out if you try. It creates unique
        // records, and skips over or merges duplicates.

        List<Sertifi2_0__TestContract__Share> newEconShares = new List<Sertifi2_0__TestContract__Share>();
        List<Sertifi2_0__TestContract__Share> updateEconShares = new List<Sertifi2_0__TestContract__Share>();

        for (Sertifi2_0__TestContract__c econ : econtracts) {
            List<nihrm__Booking__Share> parentBookingShares = sharesByBookingId.get(
                econ.sertifisem__Booking__c
            );
            List<Sertifi2_0__TestContract__Share> econtractShares = sharesByEcontractId.get(
                econ.Id
            );

            for (nihrm__Booking__Share bookingShare : parentBookingShares) {
                // Check if existing shares refer to the same UserOrGroupId
                // If no conflicts are found, go ahead and add the Share record.
                // If conflicts are found, only if the new Share would be a
                // higher level of access than the existing, do we try and update
                // the existing.
                Boolean noConflicts = true;
                for (Sertifi2_0__TestContract__Share existingShare : econtractShares) {
                    if (existingShare.UserOrGroupId == bookingShare.UserOrGroupId) {
                        noConflicts = false;
                        if (
                            existingShare.AccessLevel == 'Read' &&
                            (bookingShare.AccessLevel == 'Edit' ||
                            bookingShare.AccessLevel == 'All')
                        ) {
                            existingShare.AccessLevel = 'Edit';
                            updateEconShares.add(existingShare);
                        }
                    }
                }

                // Check the UserOrGroupId against our User Map.
                // If the Id is in there, and the User is IsActive
                // false, mark the share for conflict.

                User bookingShareUser = shareUsers.get(bookingShare.UserOrGroupId);
                if(null != bookingShareUser && !bookingShareUser.IsActive)
                    noConflicts = false;

                // Everything the same as the Booking__Share,
                // except now the parent is an EContract. You
                // can't insert a Share with 'Full' Access, only
                // the special Owner share can have that. If we hit
                // one, mirror it as a Read/Write.

                if (noConflicts) {
                    newEconShares.add(
                        new Sertifi2_0__TestContract__Share(
                            ParentId = econ.Id,
                            UserOrGroupId = bookingShare.UserOrGroupId,
                            AccessLevel = 'All'.equalsIgnoreCase(bookingShare.AccessLevel)
                                ? 'Edit'
                                : bookingShare.AccessLevel,
                            RowCause = 'Manual'
                        )
                    );
                }
            }
        }

        for (Sertifi2_0__TestContract__Share es : newEconShares) {
            System.debug('New Share Attempt: ' + es);
        }

        List<Database.SaveResult> saveResults = Database.insert(newEconShares, false);
        saveResults.addAll(Database.update(updateEconShares, false));

        for (Database.SaveResult res : saveResults) {
            if (!res.isSuccess()) {
                for (Database.Error e : res.getErrors()) {
                    System.debug('Save Result ERROR on record Id ' + res.getId() + ': ' + e);
                }
            }
        }
    }
}
