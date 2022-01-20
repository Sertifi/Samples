# Preconfiguration steps:

- Need to configure Sertifi's custom settings and setup portal.  
- First signer or second signer needs to be added to Sertifi custom settings.  
- Note & attachments doesn’t work if we are using lightning. It works only in classic. 
- Set a trigger on a custom object and send the econtract ID in the trigger. It is necessary to have the econtract id to trigger the API.  
- First Create the Custom Object and get its Id to be Mapped to Econtract (lookup field in Econtract)
- We are using 'Solicituds' as the custom object here but it can be any, but make sure we create a lookup to this custom Object in Econtract.
- The trigger code assumes that there is a checkbox field by API name Sertifi2_0__send_Sertifi_template_for_signature__c  , please create this  field or any other field to alter the trigger accordingly to send the Econtract for Signature based on the Custom Field logic on the Custom Object.

        Solicitud__c customObject = new Solicitud__c();
        customObject.Name ='Sample';
        insert customObject;

- Depending on the business usecase, creating an econtract & uploading documents can be done manually or with an automated code before calling the API.

- To create econtarct automatically. create all necessary objects required for sending.

```
Sertifi2_0__TestContract__c contract = new Sertifi2_0__TestContract__c(
    Name = 'Test Invites 1',
    Sertifi2_0__Message__c = 'Custom invite message',
    Sertifi2_0__Sign_Type__c = 'Electronically',
    Sertifi2_0__Opportunity__c = opportunityId,
    Sertifi2_0__Solicitud_lookup__c = customObject.Id,
 // Be aware about the above Lookup field which is present as lookup to Solicitud ( Custom object name we are using)
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
```

- At this point contract is ready to be sent. To send the contract, you have to execute the code mention in file SolicitudTriggerHandlerApexclassFile as a future call

# Scenarios :

- There can be multiple contracts. How to select which contract? (Logical usescases) 

# Type of document:

- It fetches document based on the default Sertifi settings which is from notes & attachments, but it can be fetched from files based upon the   Sertifi settings.  

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

    
Refer to the sample onepass code from the bitbucket for more details.Here is the link

        https://bitbucket.org/sertifi/samples/src/master/Salesforce/OnePassApexSample/OneCallCreateObjects/
