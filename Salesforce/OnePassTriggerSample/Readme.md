# Abstract

This is a demonstration of using the Sertifi E-Signing for Salesforce API to send an eContract from an Apex Trigger. Defined here is an Opportunity Trigger, on after update, along with an Apex Class with a static helper method to build and send an eContract when an Opportunity has changed to Closed/Won. Note, this code is written to demonstrate the Sertifi API call, and is not developed as a fully fledged production implementation (see inline comments).

The code builds sObjects for the main Sertifi records that comprise a signing/payment contract: EContract, EDocument, Signer, Payment; it also generates a demo PDF File (ContentDocument) and for each EDocument, a ContentDocumentLink which associates that File to the EDocument. The PDF File becomes the signing document which is presented for the signer to review and sign. The code fully builds each signing request in Salesforce, and finally sends the Id of each EContract record to the Sertifi method: ```Sertifi2_0.SertifiSFAPI.sendEContractToSertifi```.


# Prerequisites

- A Salesforce Org with Sertifi E-Signing installed, configured, and connected to a Sertifi portal.

- Your Sertifi Portal should be configured to push events to your Salesforce Org (Real Time Updates).

- For more information on the Salesforce/Sertifi integration consult our documentation: https://support.sertifi.com/Content/Integrations/Salesforce/Sertifi%20for%20Salesforce.htm



# Notes

- The Sertifi settings provides all the necessary parameters to call the Sertifi API to send the Econtract for signing.   

- If the settings are not correctly configured, the API will fail to invoke and thus, the econtracts will not be sent to be signed. Two parameters are required to call the Sertifi API to send the econtract for signing. This includes econtract ID and Sertifi settings (custom settings). 
- The API assumes that the econtract has the necessary document (edocument) and its associated file (in notes & attachments or files), as well as all necessary parameters configured in the Sertifi settings. 
- You can find below the method for calling the API. Do note that this API tries to makes a callout to Sertifi and thus marked in a future method with callout set as true. This callout transaction is performed asynchronously.

- Refer to the sample onepass code from the bitbucket for more details. Here is the link

     https://bitbucket.org/sertifi/samples/src/master/Salesforce/OnePassApexSample/OneCallCreateObjects/
