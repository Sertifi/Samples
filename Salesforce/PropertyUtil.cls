public with sharing class PropertyUtil {

    /*
    * Copies Property's group to eContract object
    */
    public static void copyPropertySharingToEcontract() {
    
        // The Owner share is special, and we won't be able to mirror it. EContracts will have their
        // own Owner based on whomever created the record.

        List<nihrm__Location__Share> propertyShares = [
            SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
            FROM nihrm__Location__Share
            WHERE RowCause != 'Owner'
        ];

        if(propertyShares.isEmpty()) {
            System.debug('No changes made since no property groups exists.');
            return;
        }

        if(propertyShares.size() > 1000) {
            System.debug('No changes made since property groups exceed 1000 limit.');
            return;
        }

        // Construct a Map keyed by the Property records, with a List of each Share for that Property record
        // as the value.

        Map<Id, List<nihrm__Location__Share>> sharesByPropertyId = new Map<Id, List<nihrm__Location__Share>>();
        for (nihrm__Location__Share b : propertyShares) {
            System.debug(b);
            List<nihrm__Location__Share> shares = sharesByPropertyId.get(b.ParentId);
            if (null == shares)
                shares = new List<nihrm__Location__Share>();

            shares.add(b);
            sharesByPropertyId.put(b.ParentId, shares);
        }

        // Find all of the EContract records that have
        // lookups to the Booking records

        List<Sertifi2_0__TestContract__c> econtracts = [
            SELECT Id,sertifisem__Booking__r.nihrm__Location__c 
            FROM Sertifi2_0__TestContract__c 
            WHERE sertifisem__Booking__c != NULL
        ];

        // Loop over the eContracts and build a share
        // for each one that mirrors the Property it relates to

        // You luck out a bit on the Salesforce implementation
        // of __Share objects. The system won't create duplicates,
        // and it won't error out if you try. It creates unique
        // records, and skips over or merges duplicates.

        List<Sertifi2_0__TestContract__Share> econShares = new List<Sertifi2_0__TestContract__Share>();

        for (Sertifi2_0__TestContract__c econ : econtracts) {
            List<nihrm__Location__Share> parentPropertyShares = sharesByPropertyId.get(
                econ.sertifisem__Booking__r.nihrm__Location__c
            );

            for (nihrm__Location__Share propertyShare : parentPropertyShares) {
                // Everything the same as the nihrm__Location__Share,
                // except now the parent is an EContract

                econShares.add(
                    new Sertifi2_0__TestContract__Share(
                        ParentId = econ.Id,
                        UserOrGroupId = propertyShare.UserOrGroupId,
                        AccessLevel = propertyShare.AccessLevel,
                        RowCause = 'Manual'
                    )
                );
            }
        }

        insert econShares;
        System.Debug(econShares.size() + ' groups added to ' + econtracts.size() + ' eContracts.');
    }
}