## This sample includes:

* Two Apex classes
    1. SendZQuoteFromOppController
    2. SendZQuoteFromOppControllerTest

* VisualForce page
    * SendZQuoteFromOpp

##To use this sample:
1. Create a custom button on the Opportunity object.

2. Enable the following settings:
    * Label - Sertifi Wizard
    * Name - Sertifi Wizard
    * Display Type – Detail Page Button
    * Behavior – Display in existing window with sidebar
    * Content Source – URL  

3. Enter the following syntax for the button:
    `/apex/SendZQuoteFromOpp?oppID={!Opportunity.Id}&filename={!Opportunity.Name}`

