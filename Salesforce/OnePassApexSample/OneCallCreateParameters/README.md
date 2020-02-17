## This sample includes:

* Two Apex snippets
    1. OneCallCreateObjects- creates all necessary objects required for sending.
    2. OneCallSendForSignature- uses our API call to send a complete contract to Sertifi for synchronization.

## Use cases:

* To create an automatic one-click button to send an Econtract.
* To automatically create objects and wait for approval before sending.
* To create triggers that fire off an Econtract for signature after a field is completed.

## Overview:
Before sending out a Sertifi request in background mode, you will need to generate and insert package objects based on the use case.

## Building via parameters
By taking advantage of our parameters, you can quickly build and send out a Sertifi EContract. This method is meant for more out of the box scenarios where access to specific fields are not necessary, as the creation of custom objects are done in the background. The two objects to become familiar with are Sertifi EContract and Sertifi EContract Parameter.

#### EContract is the master object that holds relationships to other child objects within the package.

*   Sertifi EContract: Sertifi2_0\__TestContract\__c  
    * Name (String)  
    * Sertifi2_0\__Sign_Type\__c (String): ‘Electronically’  
    * Sertifi2_0\__Open\__c (Int): Set value to amount of items for signature or payment (e.g 2 documents + 1 payment = 3)  
    * Object Lookup (Id/String): If a standard object, use prebuilt field. If not, use Sertifi2_0\__CustomLinkID\__c (String)  
    * Sertifi2_0\__Settings\__c (String): Name of your Custom Settings. Default recommendation is ‘Settings’
#### EContractParameter can complete all other necessary requirements (Adding at least one signer, attaching either a document or payment)
* Sertifi EContractParameter: Sertifi2_0\__EContract_Parameter\__c;
    * Name (String) = Name of the parameter E.g '1stsigner' (https://support.sertifi.com/Content/Integrations/Salesforce/Additional%20Resources/Creating%20a%20custom%20Sertifi%20button.htm?Highlight=custom%20button#Paramete)
    * Sertifi2_0\__EContract\__c (Id)= ID of the EContract;
    * Sertifi2_0\__Value\__c (String)= value associated with the corresponding parameter name e.g. If creating a signer, enter 'test@me.com'