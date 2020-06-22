
# Extending UpdateNotifications

***

If you have a use case where leveraging Sertifi's event notifications is required to drive last-mile business logic that cannot be accomplished via workflow updates/lightning flow/process builder, extending Sertifi's UpdateNotifications interface may assist in quicker implementation.

## Table of Contents

* [Prerequisites](#markdown-header-introduction)
* [Implementation](#markdown-header-development-using-visual-studio-code)
* [References](#markdown-header-references)


***

## Prerequisites

1. Sertifi E-Sign for Salesforce.com managed package installed
2. No extension packages installed such as Sertifi E-Sign for Sales & Event Management, Sertifi for Salesforce CPQ, or Sertifi Billing - For Salesforce.
3. Custom settings field **UpdateMethodName** is unused
***

## Implementation

1. Create Apex Class
2. Extend Interface
    ```
    //Summary: This class extends Sertifi's UpdateNotifications to add additional logic when parsing EContractActivity 
    global with sharing class UpdateNotificationsHandler implements  Sertifi2_0.UpdateNotifications {
        public UpdateNotificationsHandler() {}
       
        //notifications recieved from the createActivity method from the base package
        public void ReceiveNotification(ID eContractId, ID eContractActivityId, string actbase, string actdetail){}
    ```
3. Add your custom logic within the ReceiveNotifications method
4. In Setup-->Custom Settings, add the name of your new Apex class to the field UpdateMethodName 

***

## References

Actbase messages and associated detail

| Activity Base  | Activity Detail |
| ------------- | ------------- |
| Signer Invited  | empty  |
| Signer accessed documents  | Name of document (e.g Sample Doc.pdf)  |
| Signer accessed room  | empty |
| Owner accessed room  | empty  |
| Signature received | Name of document (e.g Sample Doc.pdf)  |
| Document signed  | Name of document (e.g Sample Doc.pdf)  |
| Payment received  | Name of payment/authorization (e.g Check-in Auth)  |
| Payment refunded | Name of payment/authorization (e.g Initial Deposit) |
| Payment error | {Name of payment}. Reason: {Generic message}. ReasonProvided {Gateway provided error}. (e.g Initial Deposit. Reason: Card not accepted. Reason provided: Transaction declined by issuer. |