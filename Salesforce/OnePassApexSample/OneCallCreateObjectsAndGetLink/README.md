## This sample includes:

* One Visualforce Page file, ```ExampleGetlinkFlow.page```
* One Apex Class file, a controller for the Visualforce Page, ```ExampleGetlinkFlowController.cls```

## Purpose:

This demonstrates a three-step process using Sertifi's Salesforce API:
1. Create Sertifi SObjects representing a signing request (multiple DML operations)
1. Call ```SertifiSFAPI.sendtoSertifi``` (a web callout, therefore it must be separated from 1, and also a DML operation)
1. Call ```SertifiSFApi.getLink``` (a web callout, therefore it must be separated from 2)

Step one and two do DML operations. Step two and three do web callouts. The entire sequence can't be done in one Apex transaction due to platform limitations. See here for more information: [Callout Limits and Limitations](https://developer.salesforce.com/docs/atlas.en-us.apexcode.meta/apexcode/apex_callouts_timeouts.htm)

When you run the demo, each of the three steps is initiated by a button-click on the Visualforce page, which allows them to run in separate transactions.

**NOTE** This is intended as a demonstration only, it is not meant as a design template for applications.

## HOW-TO Use
Salesforce Documentation can be found here:
* [Visualforce Developer Guide](https://developer.salesforce.com/docs/atlas.en-us.pages.meta/pages/pages_intro_what_is_it.htm)
* [Apex Developer Guide](https://developer.salesforce.com/docs/atlas.en-us.apexcode.meta/apexcode/apex_dev_guide.htm)

### Prerequisites
You must have Sertifi's Salesforce package installed in your Org, and configured with 

#### To Install the Apex Class
1. Navigate to Setup -> Develop -> Apex Classes
1. Click New
1. Copy the content of ```ExampleGetlinkFlowController.cls``` and paste it into the Apex Class window
1. Replace the Opportunity Id on line 8 with a real Opportunity Id from your Org
1. Replace the email on line 9 with an email of your choosing. (This is signer.)
1. Click Save


#### To install the Visualforce Page
1. Navigate to Setup -> Develop -> Visualforce Pages
1. Click New
1. Enter the Label and Name ExampleGetlinkFlow
1. Copy the content of ```ExampleGetlinkFlow.page``` and paste it into the Visualforce Markup window (replace the entire contents)
1. Click Save
1. After clicking save, click the "Preview" button to access the page