@isTest
public with sharing class EcontractShareUtilTest {
    @testSetup
    static void go() {
        Id userProfileId = [SELECT Id FROM Profile WHERE Name = 'System Administrator' LIMIT 1].Id;

        User usr = new User(
            Alias = 'testUser',
            Email = 'testDataUser@sertifi.com',
            EmailEncodingKey = 'UTF-8',
            LastName = 'testDataUser',
            LanguageLocaleKey = 'en_US',
            LocaleSidKey = 'en_US',
            ProfileId = userProfileId,
            TimeZoneSidKey = 'America/Los_Angeles',
            UserName = 'testDataUser@sertifi.com'
        );
        insert usr;

        nihrm__Location__c property = new nihrm__Location__c();
        property.Name = 'Pizza Lords';
        property.nihrm__AddressLine1__c = '00 Caputo Ave';
        property.nihrm__City__c = 'La Puente';
        property.nihrm__StateProvince__c = 'CA';
        property.nihrm__PostalCode__c = '91774';
        property.nihrm__CountryCode__c = 'US';
        property.nihrm__SystemOfMeasurement__c = 'Standard';
        property.nihrm__TimeZone__c = 'GMT-06:00 Central Daylight Time (America/Chicago)';

        insert property;

        Account acct = new Account(Name = 'Pizza Lords', CurrencyIsoCode = 'USD');
        insert acct;

        nihrm__Booking__c booking = new nihrm__Booking__c();
        booking.Name = 'Pizza Booking';
        booking.nihrm__Location__c = property.Id;
        booking.nihrm__Account__c = acct.Id;
        booking.nihrm__BookingStatus__c = 'Prospect';
        booking.nihrm__ArrivalDate__c = Date.today().addDays(5);
        booking.nihrm__DepartureDate__c = Date.today().addDays(10);
        booking.nihrm__AdditionalSalesManager__c = usr.Id;

        insert booking;

        Sertifi2_0__TestContract__c econtract = new Sertifi2_0__TestContract__c();
        econtract.Name = 'Pizza Contract';
        econtract.CurrencyIsoCode = 'USD';
        econtract.sertifisem__Booking__c = booking.Id;

        insert econtract;
    }

    @isTest
    static void copyBookingSharingToEcontract() {
        nihrm__Booking__c booking = [
            SELECT Id, Name
            FROM nihrm__Booking__c
            WHERE Name = 'Pizza Booking'
            LIMIT 1
        ];

        List<Sertifi2_0__TestContract__c> econs = [
            SELECT Id, Name
            FROM Sertifi2_0__TestContract__c
        ];
        System.assertEquals(1, econs.size(), 'There should be only one EContract.');

        List<nihrm__Booking__Share> bookingShares = [
            SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
            FROM nihrm__Booking__Share
            WHERE RowCause != 'Owner' AND ParentId = :booking.Id
        ];

        System.assertEquals(
            3,
            bookingShares.size(),
            'There should be three Share rules on Booking.'
        );

        // Make a set of all the User/Groups these shares refer to
        Set<Id> userOrGroupIds = new Set<Id>();

        for (nihrm__Booking__Share b : bookingShares)
            userOrGroupIds.add(b.UserOrGroupId);

        System.assertEquals(
            3,
            userOrGroupIds.size(),
            'userOrGroupIds should contain 2 Group and 1 User Ids.'
        );

        List<Sertifi2_0__TestContract__Share> econShares = [
            SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
            FROM Sertifi2_0__TestContract__Share
            WHERE RowCause != 'Owner' AND ParentId = :econs[0].Id
        ];
        System.assertEquals(0, econShares.size(), 'There should be no rules for the EContract.');

        // Run the copy algorithm upon our test subject

        EcontractShareUtil.copyBookingSharesToEcontract(new List<Id>{ booking.Id });

        List<Sertifi2_0__TestContract__Share> econSharesAfter = [
            SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
            FROM Sertifi2_0__TestContract__Share
            WHERE RowCause != 'Owner' AND ParentId = :econs[0].Id
        ];
        System.assertEquals(
            3,
            econSharesAfter.size(),
            'There should be three rules for the EContract now.'
        );


        for (Sertifi2_0__TestContract__Share s : econSharesAfter) {
            System.assert(userOrGroupIds.remove(s.UserOrGroupId));
        }
        System.assertEquals(0, userOrGroupIds.size(), 'All userOrGroup Ids should be removed!');


        // Lastly, the kicker - run the method again and our
        // results shall be the same.

        EcontractShareUtil.copyBookingSharesToEcontract(new List<Id>{ booking.Id });

        List<Sertifi2_0__TestContract__Share> econSharesAfterAfter = [
            SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
            FROM Sertifi2_0__TestContract__Share
            WHERE RowCause != 'Owner' AND ParentId = :econs[0].Id
        ];
        System.assertEquals(
            3,
            econSharesAfterAfter.size(),
            'There should still be three rules for the EContract.'
        );
    }

    @isTest
    static void econtractShareUtilBatchableTest() {
        nihrm__Booking__c booking = [
            SELECT Id, Name
            FROM nihrm__Booking__c
            WHERE Name = 'Pizza Booking'
            LIMIT 1
        ];

        List<Sertifi2_0__TestContract__c> econs = [
            SELECT Id, Name
            FROM Sertifi2_0__TestContract__c
        ];
        System.assertEquals(1, econs.size(), 'There should be only one EContract.');

        List<nihrm__Booking__Share> bookingShares = [
            SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
            FROM nihrm__Booking__Share
            WHERE RowCause != 'Owner' AND ParentId = :booking.Id
        ];

        System.assertEquals(
            3,
            bookingShares.size(),
            'There should be three Share rules on Booking.'
        );

        // Make a set of all the User/Groups these shares refer to
        Set<Id> userOrGroupIds = new Set<Id>();

        for (nihrm__Booking__Share b : bookingShares)
            userOrGroupIds.add(b.UserOrGroupId);

        System.assertEquals(
            3,
            userOrGroupIds.size(),
            'userOrGroupIds should contain 2 Group and 1 User Ids.'
        );

        List<Sertifi2_0__TestContract__Share> econShares = [
            SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
            FROM Sertifi2_0__TestContract__Share
            WHERE RowCause != 'Owner' AND ParentId = :econs[0].Id
        ];
        System.assertEquals(0, econShares.size(), 'There should be no rules for the EContract.');


        Test.startTest();
        Database.executeBatch(new EcontractShareUtilBatchable(),1000);
        Test.stopTest();

        List<Sertifi2_0__TestContract__Share> econSharesAfter = [
            SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
            FROM Sertifi2_0__TestContract__Share
            WHERE RowCause != 'Owner' AND ParentId = :econs[0].Id
        ];
        System.assertEquals(
            3,
            econSharesAfter.size(),
            'There should be three rules for the EContract now.'
        );


        for (Sertifi2_0__TestContract__Share s : econSharesAfter) {
            System.assert(userOrGroupIds.remove(s.UserOrGroupId));
        }
        System.assertEquals(0, userOrGroupIds.size(), 'All userOrGroup Ids should be removed!');


        // Lastly, the kicker - run the method again and our
        // results shall be the same.

        EcontractShareUtil.copyBookingSharesToEcontract(new List<Id>{ booking.Id });

        List<Sertifi2_0__TestContract__Share> econSharesAfterAfter = [
            SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
            FROM Sertifi2_0__TestContract__Share
            WHERE RowCause != 'Owner' AND ParentId = :econs[0].Id
        ];
        System.assertEquals(
            3,
            econSharesAfterAfter.size(),
            'There should still be three rules for the EContract.'
        );
    }


}
