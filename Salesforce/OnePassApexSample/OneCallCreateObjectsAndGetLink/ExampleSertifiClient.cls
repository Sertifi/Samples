// EXAMPLE
// This demonstrates a three-step process:
// Create SOjbects in Salesforce representing a Sertifi signing
// Use Sertifi's Salesforce API to create the Folder in your Sertifi Portal
// Use Sertifi's Salesforce API to retrieve a payment link
// Step one and two do DML operations. Step two and three do web callouts.
// The entire sequence can't be done in one Apex transaction due
// to platform limitations.
// https://developer.salesforce.com/docs/atlas.en-us.apexcode.meta/apexcode/apex_callouts_timeouts.htm


public with sharing class ExampleSertifiClient {

    // This example uses an Opportunity as the parent record
    // for EContract. It is also possible to use other Objects.
    // This assumes the signer email is known, and uses the
    // Sertifi placeholder Contact record.

    String opportunityId = 'OPPORTUNITY_ID';
    String signerEmail = 'enter@your.email.here';
    Sertifi2_0__TestContract__c contract;
    Sertifi2_0__Payment__c payment;
    String link = 'Not yet retrieved';

    public Sertifi2_0__TestContract__c getContract() {
        if(null == contract)
            return new Sertifi2_0__TestContract__c();

        return [
            SELECT Id, CreatedDate, Sertifi2_0__Settings__c, Sertifi2_0__ContractID__c
            FROM Sertifi2_0__TestContract__c
            WHERE Id = :contract.Id
            LIMIT 1
        ];
    }

    public Sertifi2_0__Payment__c getPayment() {
        if(null == payment)
            return new Sertifi2_0__Payment__c();
            
        return [
            SELECT Id, CreatedDate, Sertifi2_0__Econtract__r.Sertifi2_0__ContractID__c, Sertifi2_0__SertifiId__c
            FROM Sertifi2_0__Payment__c
            WHERE Id = :payment.Id
            LIMIT 1
        ];
    }

    public String getLink() {
        return this.link;
    }

    // Create the SObjects in Salesforce that represent an EContract
    public void createObjects() {
        contract = new Sertifi2_0__TestContract__c(
            Name = 'Test Invites 1',
            Sertifi2_0__Message__c = 'Custom invite message',
            Sertifi2_0__Sign_Type__c = 'Electronically',
            Sertifi2_0__Opportunity__c = opportunityId,
            Sertifi2_0__Open__c = 1,
            Sertifi2_0__Settings__c = 'Settings'
        );
        insert contract;

        // (If you have a real Contact record for the end user,
        // that works as well.)

        Contact tempContact = [
            SELECT id, name, email
            FROM Contact
            WHERE email = 'placeholder@sertifi.com'
            LIMIT 1
        ];

        Sertifi2_0__ContractContactJunction__c signer = new Sertifi2_0__ContractContactJunction__c(
            Sertifi2_0__Contact__c = tempContact.id,
            Sertifi2_0__TestContract__c = contract.id,
            Sertifi2_0__Signer_Order__c = 1,
            Sertifi2_0__Level_Name__c = '1st Signer',
            Sertifi2_0__Email__c = signerEmail
        );
        insert signer;

        //Creating payment object
        payment = new Sertifi2_0__Payment__c();
        payment.Name = 'Test Payment';
        payment.Sertifi2_0__EContract__c = contract.id;
        payment.Sertifi2_0__Amount__c = 10.25;
        payment.Sertifi2_0__Operation__c = 'Pay';
        payment.Sertifi2_0__DueDate__c = date.today().addDays(30); //expires after 30 days
        insert payment;
    }

    // Send the EContract to the Sertifi API, using our Salesforce API
    // This populates both the EContract and the Payment with the Sertifi
    // Ids that are required to form a GetLink request.
    public void sendToSertifi() {
        Sertifi2_0.SertifiSFAPI.sendEContractToSertifi(
            contract.Id,
            Sertifi2_0__SertifiSettings__c.getValues(contract.Sertifi2_0__Settings__c)
        );
    }

    // Create the actual Link request. Note the GetLinkType
    // Enum is global in our package; you can view the other
    // link types available.
    public void getPaymentLink() {
        // Requery the Payment record to get the Sertifi ID
        // of it and its parent EContract.
        payment = [
            SELECT Id, Sertifi2_0__SertifiID__c, Sertifi2_0__EContract__r.Sertifi2_0__ContractID__c
            FROM Sertifi2_0__Payment__c
            WHERE Id = :payment.Id
            LIMIT 1
        ];

        Sertifi2_0.GetLinkParameter getLinkParam = new GetLinkParameter();
        getLinkParam.fileId = payment.Sertifi2_0__EContract__r.Sertifi2_0__ContractID__c;
        getLinkParam.documentId = '';
        getLinkParam.PaymentId = payment.Sertifi2_0__SertifiID__c;
        getLinkParam.SignerEmail = signerEmail;
        getLinkParam.linkType = GetLinkType.SECUREPAYMENTLINK;

        Sertifi2_0.GetLinkRequest request = new Sertifi2_0.GetLinkRequest();
        request.LinkParameters = new List<Sertifi2_0.GetLinkParameter>{ getLinkParam };
        request.SettingsName = contract.Sertifi2_0__Settings__c;

        //Make the call
        Sertifi2_0.GetLinkResponse response = Sertifi2_0.SertifiSFAPI.GetLink(request);

        String paymentPageLink = response.Results[0].Link;

        //It is probably a good idea to check for errors
        if (response.Results[0].Error != null)
            this.link = 'Error retrieving landing page link: ' + response.Results[0].Error;
        else
            this.link = paymentPagelink;
    }
}
