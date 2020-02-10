## This sample includes:

* Two Apex snippets
    1. OneCallCreateObjects- creates all necessary objects required for sending.
    2. OneCallSendForSignature- uses our API call to send a complete contract to Sertifi for synchronization.

## Use cases:

* To create an automatic one-click button to send an Econtract.
* To automatically create objects and wait for approval before sending.
* To create triggers that fire off an Econtract for signature after a field is completed.

## Overview:
Before sending out a Sertifi request in background mode, you will need to generate and insert our package objects based on your use case.

## Building via custom objects
Creating and inserting each custom object is necessary when following this path.

#### EContract is the master object that holds relationships to other child objects within the package.
- Sertifi EContract: Sertifi2_0__TestContract__c
-- Name (String)
-- Sertifi2_0__Sign_Type__c (String): 'Electronically'
-- Sertifi2_0__Open__c (Int): Set value to amount of items for signature or payment (e.g 2 documents + 1 payment = 3)
-- Object Lookup (Id/String): If a standard object, use prebuilt field. If not, use Sertifi2_0__CustomLinkID__c (String)
-- Sertifi2_0__Settings__c (String): Name of your Custom Settings. Default recommendation is 'Settings'

#### Signer holds the relationship between a Contact Object and any associated EContracts. If you don't have a Contact record for a specific signer, create a placeholder Contact record with the email set to 'placeholder@sertifi.com'.
- Signer: Sertifi2_0__ContractContactJunction__c
-- Sertifi2_0__TestContract__c (Id): EContract lookup
-- Sertifi2_0__Signer_Order (Int): Order in which this specific signer should complete the request
--(Optional) Sertifi2_0__Email__c (String) = Overrides the email stored in the placeholder

#### An EContract must contain a least one EDocument with type Signature Document or a Payment for authorization/payment. You can attach multiple EDocuments, Payments, or just a singular Document/Payment.
- EDocument: Sertifi2_0__EDocument__c
-- Sertifi2_0__TestContract__c (Id): EContract lookup
-- Sertifi2_0__Name__c (String): Name of Document
-- Sertifi2_0__Document_Type__c (Picklist): Choose from 'Signing Document' or 'Reference Document'

- Payment: Sertifi2_0__Payment__c
-- Sertifi2_0__TestContract__c (Id): EContract lookup
-- Sertifi2_0__Name__c (String): Name of Payment
-- Sertifi2_0__Document_Type__c (Picklist): Choose from 'Signing Document' or 'Reference Document'
-- Sertifi2_0__Operation(Picklist): Payment type, choose from either 'Pay' or 'Authorize'
-- (Optional) Sertifi2__0__DueDate__c (Date): Due Date for Payment
-- (Optional) Sertifi2__0__Amount__c (Currency): Only required for payments
#### Once you have all the objects created, please use the below methods to generate the web service calls

- Sertifi2_0__SertifiSettings__c.getValues(String name)
-- Returns: Sertifi2_0__SertifiSettings__c object that matches the name parameter
-- Enter in the name of the custom settings to use
- @future Sertifi2_0.SertifiSFAPI.sendEContractToSertifi(ID EContractID, Sertifi2_0__SertifiSettings__c settings)
-- Returns: Result of callout as String
-- Place under separate @future method for async capabilities