*************************************************************************************************
*** Welcome to the Sertifi Event Notification Sample for the REST/JSON event listener option! ***
*************************************************************************************************

You should be able to run this project from Visual Studio using the default "IIS Express" debugger.

The "Controllers" folder contains the EventPushSubscriberController.cs file, which is where the method ReceiveNotification has been set up to receive a call from Sertifi's EventPush.
The "Models" folder contains the classes necessary to receive a notification from Sertifi's Event Push.  (Plus a generic Error object, because they're good to have.)

The EventPushService.postman_collection.json is an exported collection from a program called "Postman" that can be installed and used to test that this project is working.
(The port number after "localhost:" might differ and need to be updated. The "TestBase" call should return "Hello World!"  The "NotificationEvent" call should return a 'not implemented' message, at least until ReceiveNotification gets implemented.)

What is left for you is to implement the ReceiveNotification method and setup the project so that the URL set in Sertifi's Event Push correctly calls it.