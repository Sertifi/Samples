public with sharing class OpportunityTriggerHandler {
    /**
     * NOTE: This handler creates an EContract for each Closed/Won Opportunity,
     * then sends each EContract to the Sertifi API in a separate future call.
     * This implementation is, therefore, limited to 50 Closed/Won Opps per trigger
     * invocation, over which a Governor Limit Exception will be thrown by the platform.
     * This is done to simplify the implementation for example purposes. In a real
     * implementation, one could put the API call inside a Queueable class, which
     * then calls its self for each subsequent call. (Queueables can be chained in
     * this way indefinitely.)
     */
    public static void handleUpdate(Map<Id, Opportunity> newMap, Map<Id, Opportunity> oldMap) {
        /**
         * Sertifi App generates a 'placeholder' Contact the first time a sending is
         * initiated after install. This is used to attach signers to econtracts where
         * there is not a Contact record with that person's email.
         */
        final Id placeholderContactId = [
            SELECT Id
            FROM Contact
            WHERE Email = 'placeholder@sertifi.com'
            LIMIT 1
        ]
        ?.Id;

        /**
         * Create File by inserting ContentVersion. (Note the
         * associated ContentDocument will be automagically generated
         * by Salesforce.) In a real implementation you might have logic
         * to select the Id of a ContentVersion from some predefined list.
         */
        ContentVersion signingDocumentFile = new ContentVersion(
            Title = 'TEST_DOC',
            VersionData = Blob.toPdf('TEST_CONTENT'),
            PathOnClient = 'doc.pdf',
            IsMajorVersion = true
        );
        insert signingDocumentFile;

        Id contentDocumentId = [
            SELECT ContentDocumentId
            FROM ContentVersion
            WHERE Id = :signingDocumentFile.Id
            LIMIT 1
        ]
        ?.ContentDocumentId;

        List<Sertifi2_0__TestContract__c> contracts = new List<Sertifi2_0__TestContract__c>();
        List<Sertifi2_0__EDocument__c> documents = new List<Sertifi2_0__EDocument__c>();
        List<Sertifi2_0__ContractContactJunction__c> signers = new List<Sertifi2_0__ContractContactJunction__c>();
        List<Sertifi2_0__Payment__c> payments = new List<Sertifi2_0__Payment__c>();
        for (Opportunity newOpp : newMap.values()) {
            Opportunity oldOpp = oldMap.get(newOpp.Id);
            if ('Closed Won'.equals(newOpp.StageName) && (oldOpp.StageName != newOpp.StageName)) {
                contracts.add(
                    new Sertifi2_0__TestContract__c(
                        Name = newOpp.Name,
                        Sertifi2_0__Message__c = 'Your Invite Message Here',
                        Sertifi2_0__Sign_Type__c = 'Electronically',
                        Sertifi2_0__Opportunity__c = newOpp.Id,
                        Sertifi2_0__Open__c = 1,
                        Sertifi2_0__Settings__c = 'Settings'
                    )
                );
                documents.add(
                    new Sertifi2_0__EDocument__c(
                        Sertifi2_0__Name__c = 'Test doc',
                        Sertifi2_0__Number_Signed__c = 0,
                        Sertifi2_0__Document_Type__c = 'Signing Document'
                    )
                );
                signers.add(
                    new Sertifi2_0__ContractContactJunction__c(
                        Sertifi2_0__Contact__c = placeholderContactId,
                        Sertifi2_0__Signer_Order__c = 1,
                        Sertifi2_0__Level_Name__c = '1st Signer',
                        Sertifi2_0__Email__c = 'gstansill@sertifi.com'
                    )
                );
                payments.add(
                    new Sertifi2_0__Payment__c(
                        Name = 'Test Payment',
                        Sertifi2_0__Amount__c = 10.25,
                        Sertifi2_0__Operation__c = 'Pay',
                        Sertifi2_0__DueDate__c = Date.today().addDays(30)
                    )
                );
            }
        }
        insert contracts;
        for (Integer i = 0; i < contracts.size(); i++) {
            documents[i].Sertifi2_0__TestContract__c = contracts[i].Id;
            signers[i].Sertifi2_0__TestContract__c = contracts[i].Id;
            payments[i].Sertifi2_0__EContract__c = contracts[i].Id;
        }
        insert documents;
        insert signers;
        insert payments;
        /**
         * Here a link to the same ContentDocumentId is created for each EDocument,
         * thereby attaching that File as a signing document. More complex logic
         * could be used if one of several, or multiple, PDFs should be attached.
         */
        List<ContentDocumentLink> links = new List<ContentDocumentLink>();
        for (Sertifi2_0__EDocument__c doc : documents) {
            links.add(
                new ContentDocumentLink(
                    ContentDocumentId = contentDocumentId,
                    LinkedEntityId = doc.Id,
                    ShareType = 'I',
                    Visibility = 'AllUsers'
                )
            );
        }
        insert links;
        for (Sertifi2_0__TestContract__c contract : contracts) {
            callSertifi(contract.Id);
        }
    }
    /**
     * 'Settings' is the default name of Sertifi's App settings. Your implementation
     * may differ, or have multiple Settings.
     */
    @future(callout=true)
    private static void callSertifi(Id econtractId) {
        String results = Sertifi2_0.SertifiSFAPI.sendEContractToSertifi(
            eContractId,
            Sertifi2_0__SertifiSettings__c.getValues('Settings')
        );
        System.debug('The result is  ' + results);
    }
}