This sample shows how to pass along zQuote information to the Sertifi room.

It includes- Two apex classes (one for testing, one custom VisualForce controller) and one VisualForce Page.

In order to use, please:

1. Create a custom field on the opportunity object named 'ElectronicPaymentMethodId'. Data type is 'Text', length is 64. If you would like to change the custom field name, you will also have to modify the Apex controller code to point to the custom field.

2. Create a custom button in the Opportunity object with the following settings.

Label: Sertifi Wizard
Name: Sertifi_Wizard
Display Type: Detail Page Button
Behavior: Display in existing window with sidebar
Content Source: URL

Button Syntax:
/apex/SendZQuoteFromOpp?oppID={!Opportunity.Id}&filename={!Opportunity.Name}