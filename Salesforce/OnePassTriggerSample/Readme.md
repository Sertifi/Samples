# Preconfiguration steps:

- Need to configure Sertifi's custom settings and setup portal.  
- Set a trigger on a custom object and send the econtract ID in the trigger. It is necessary to have the econtract id to trigger the API.  
- First Create the Custom Object and get its Id to be Mapped to Econtract (lookup field in Econtract)
- We are using 'Candidate' as the custom object here but it can be any, but make sure we create a lookup to this custom Object in Econtract.
- The trigger code assumes that there is a checkbox field by API name Sertifi2_0__Send_Offer__c  , please create this  field or any other field to alter the trigger accordingly to send the   Econtract for Signature based on the Custom Field logic on the Custom Object.

        Candidate__c customObject = new Candidate__c();
        customObject.Name ='Sample';
        insert customObject;

- To create econtarct dynamically. create all necessary objects required for sending the econtract.
- Our sample triggercode shows how to  create econtract dynamically.

```
Sertifi2_0__TestContract__c contract = new Sertifi2_0__TestContract__c(
    Name = 'Test Invites 1',
    Sertifi2_0__Message__c = 'Custom invite message',
    Sertifi2_0__Sign_Type__c = 'Electronically',
    Sertifi2_0__Opportunity__c = opportunityId,
    Sertifi2_0__Candidate_lookup__c = customObject.Id,
 // Be aware about the above Lookup field which is present as lookup to Candidate ( Custom object name we are using)
    Sertifi2_0__Open__c = 1, 
 //Setting the custom object id so that contract is linked to the object mentioned in the custom settings
 //Sertifi2_0__CustomLinkID__c = 'custom object id',
    Sertifi2_0__Settings__c = 'Settings';
    insert contract;


Sertifi2_0__EDocument__c signDoc = new Sertifi2_0__EDocument__c(
    Sertifi2_0__TestContract__c = contract.id,
    Sertifi2_0__Name__c = 'Test doc',
    //Sertifi2_0__Sertifi_ID__c = 'qwerty',
    Sertifi2_0__Number_Signed__c = 0,
    Sertifi2_0__Document_Type__c = 'Signing Document');
insert signDoc;

//Creating test document on fly
String pdfContent = 'This is a test string';
Attachment attachmentPDF = new Attachment();
attachmentPdf.parentId = signDoc.id;
attachmentPdf.name = 'Generated.pdf';
attachmentPdf.body = blob.toPDF(pdfContent);
insert attachmentPDF;

Contact tempContact = [select id,name,email from Contact where email = 'placeholder@sertifi.com' LIMIT 1];
Sertifi2_0__ContractContactJunction__c signer = new Sertifi2_0__ContractContactJunction__c(
    Sertifi2_0__Contact__c = tempContact.id,
    Sertifi2_0__TestContract__c = contract.id,
    Sertifi2_0__Signer_Order__c = 1,
    Sertifi2_0__Level_Name__c = '1st Signer',
    Sertifi2_0__Email__c = signerEmail);
insert signer;

//Creating payment objects
Sertifi2_0__Payment__c payment = new Sertifi2_0__Payment__c();
payment.Name = 'Test Payment';
payment.Sertifi2_0__EContract__c = contract.id;
payment.Sertifi2_0__Amount__c = 10.25;
payment.Sertifi2_0__Operation__c = 'Pay', //Default is 'Pay', set to 'Authorize' for authorizations
payment.Sertifi2_0__DueDate__c = date.today().addDays(30); //expires after 30 days
insert payment;

//Creating additional parameters
Sertifi2_0__EContract_Parameter__c parameter = new Sertifi2_0__EContract_Parameter__c();
parameter.Sertifi2_0__EContract__c = contract.id;
parameter.Name = 'fileexternalid1';
parameter.Sertifi2_0__Value__c = 'file externalid data';
insert parameter;
```

- At this point contract is ready to be sent. To send the contract, you have to execute the code mention in file CandidateTriggerHandlerApexclassFile as a future call

# Type of document:

- It fetches document based on the default Sertifi settings which is from notes & attachments, but it can be fetched from files based upon the  Sertifi settings.  

#  Things should be included are

- Trigger on a specific object.  

- Which users can send the econtract?   

- An econtract needs to be created. 

- The Sertifi settings provides all the necessary parameters to call the Sertifi API to send the Econtract for signing.   

- If the settings are not correctly configured, the API will fail to invoke and thus, the econtracts will not be sent to be signed. Two parameters are required to call the Sertifi API to send the econtract for signing. This includes econtract ID and Sertifi settings (custom settings). 
- The API assumes that the econtract has the necessary document(edocument) and its associated file(in notes & attachments or files), as well as all necessary parameters configured in the Sertifi settings. 
- You can find below the method for calling the API. Do note that this API tries to makes a callout to Sertifi and thus marked in a future method with callout set as true. This callout transaction is performed asynchronously. Here's an example using the future method. 

```
@future(callout=true) 

    public static void callSertifi(Id econtractId){ 

         Sertifi2_0__SertifiSettings__c settings = Sertifi2_0__SertifiSettings__c.getValues('Settings'); // it do a callout to our sertifi API system

         string results = Sertifi2_0.SertifiSFAPI.sendEContractToSertifi(eContractId, settings); 
        
    }
```

- Refer to the sample onepass code from the bitbucket for more details. Here is the link

     https://bitbucket.org/sertifi/samples/src/master/Salesforce/OnePassApexSample/OneCallCreateObjects/
