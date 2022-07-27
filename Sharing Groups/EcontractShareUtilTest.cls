@isTest
public with sharing class EcontractShareUtilTest {
    @testSetup
    static void go() {
        Id userProfileId = [SELECT Id FROM Profile WHERE Name = 'System Administrator' LIMIT 1].Id;

        List<User> users = new List<User>{
            new User(
                Alias = 'testUser',
                Email = 'testDataUser@sertifi.com',
                EmailEncodingKey = 'UTF-8',
                LastName = 'testDataUser',
                LanguageLocaleKey = 'en_US',
                LocaleSidKey = 'en_US',
                ProfileId = userProfileId,
                TimeZoneSidKey = 'America/Los_Angeles',
                UserName = 'testDataUser@sertifi.com'
            ),
            new User(
                Alias = 'srcUser',
                Email = 'sourceUser@sertifi.com',
                EmailEncodingKey = 'UTF-8',
                LastName = 'sourceUser',
                LanguageLocaleKey = 'en_US',
                LocaleSidKey = 'en_US',
                ProfileId = userProfileId,
                TimeZoneSidKey = 'America/Los_Angeles',
                UserName = 'sourceUser@sertifi.com'
            )
        };

        insert users;

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

        List<nihrm__Booking__c> bookings = new List<nihrm__Booking__c>{
            new nihrm__Booking__c(
                Name = 'Pizza Booking',
                nihrm__Location__c = property.Id,
                nihrm__Account__c = acct.Id,
                nihrm__BookingStatus__c = 'Prospect',
                nihrm__ArrivalDate__c = Date.today().addDays(5),
                nihrm__DepartureDate__c = Date.today().addDays(10),
                nihrm__AdditionalSalesManager__c = users[1].Id
            ),
            new nihrm__Booking__c(
                Name = 'Pizza Booking II',
                nihrm__Location__c = property.Id,
                nihrm__Account__c = acct.Id,
                nihrm__BookingStatus__c = 'Prospect',
                nihrm__ArrivalDate__c = Date.today().addDays(5),
                nihrm__DepartureDate__c = Date.today().addDays(10),
                nihrm__AdditionalSalesManager__c = users[1].Id
            ),
            new nihrm__Booking__c(
                Name = 'Pizza Booking III',
                nihrm__Location__c = property.Id,
                nihrm__Account__c = acct.Id,
                nihrm__BookingStatus__c = 'Prospect',
                nihrm__ArrivalDate__c = Date.today().addDays(5),
                nihrm__DepartureDate__c = Date.today().addDays(10)
            )
        };

        insert bookings;

        List<Sertifi2_0__TestContract__c> contracts = new List<Sertifi2_0__TestContract__c>{
            new Sertifi2_0__TestContract__c(
                Name = 'Pizza Contract',
                CurrencyIsoCode = 'USD',
                sertifisem__Booking__c = bookings[0].Id
            )
        };

        insert contracts;
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
            WHERE sertifisem__Booking__c = :booking.Id
        ];
        System.assertEquals(1, econs.size(), 'There should be only one EContract.');

        List<nihrm__Booking__Share> bookingShares = [
            SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
            FROM nihrm__Booking__Share
            WHERE ParentId = :booking.Id
        ];

        System.assertEquals(
            4,
            bookingShares.size(),
            'There should be four Share rules on Booking.'
        );

        // Make a set of all the User/Groups these shares refer to
        Set<Id> userOrGroupIds = new Set<Id>();

        for (nihrm__Booking__Share b : bookingShares)
            userOrGroupIds.add(b.UserOrGroupId);

        System.assertEquals(
            4,
            userOrGroupIds.size(),
            'userOrGroupIds should contain 2 Group and 2 User Ids.'
        );

        List<Sertifi2_0__TestContract__Share> econShares = [
            SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
            FROM Sertifi2_0__TestContract__Share
            WHERE ParentId = :econs[0].Id
        ];
        System.assertEquals(
            1,
            econShares.size(),
            'There should be one rule for the EContract - Owner.'
        );

        // Run the copy algorithm upon our test subject

        EcontractShareUtil.copyBookingSharesToEcontract(new List<Id>{ booking.Id });

        List<Sertifi2_0__TestContract__Share> econSharesAfter = [
            SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
            FROM Sertifi2_0__TestContract__Share
            WHERE ParentId = :econs[0].Id
        ];
        System.assertEquals(
            4,
            econSharesAfter.size(),
            'There should be four rules for the EContract now.'
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
            WHERE ParentId = :econs[0].Id
        ];
        System.assertEquals(
            4,
            econSharesAfterAfter.size(),
            'There should still be four rules for the EContract.'
        );
    }

    @isTest
    static void copyBookingSharingToEcontractAsBookingSourceUser() {
        User sourceUser = [SELECT Id FROM User WHERE alias = 'srcUser' LIMIT 1];

        nihrm__Booking__c booking = [
            SELECT Id, Name
            FROM nihrm__Booking__c
            WHERE Name = 'Pizza Booking II'
            LIMIT 1
        ];

        List<Sertifi2_0__TestContract__c> econs = [
            SELECT Id, Name
            FROM Sertifi2_0__TestContract__c
            WHERE sertifisem__Booking__c = :booking.Id
        ];
        System.assertEquals(0, econs.size(), 'There should be no EContracts to start.');

        List<nihrm__Booking__Share> bookingShares = [
            SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
            FROM nihrm__Booking__Share
            WHERE ParentId = :booking.Id
        ];
        System.assertEquals(
            4,
            bookingShares.size(),
            'There should be four Share rules on Booking.'
        );

        // Now, assume the role of this Source User. They
        // are not the owner on the Booking, but they have
        // a Share associated to it due to being listed in
        // the Booking Sources. Verify it's there.
        Sertifi2_0__TestContract__c econtract;

        System.runAs(sourceUser) {
            Boolean shareWithMyUser = false;
            for (nihrm__Booking__Share s : bookingShares) {
                if (s.UserOrGroupId == UserInfo.getUserId())
                    shareWithMyUser = true;
            }
            System.assert(shareWithMyUser);

            // Create a EContract as the Source User, so
            // that they are the Owner and have an Owner share
            econtract = new Sertifi2_0__TestContract__c(
                Name = 'Pizza Contract',
                CurrencyIsoCode = 'USD',
                sertifisem__Booking__c = booking.Id
            );
            insert econtract;

            List<Sertifi2_0__TestContract__Share> econShares = [
                SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
                FROM Sertifi2_0__TestContract__Share
                WHERE ParentId = :econtract.Id
            ];
            System.assertEquals(
                1,
                econShares.size(),
                'There should be one Owner Share for the EContract.'
            );

            // Run the copy algorithm upon our test subject

            EcontractShareUtil.copyBookingSharesToEcontract(new List<Id>{ booking.Id });
        }

        // Now check for Share records. There should be four total.
        // The sourceUser got an automatic Owner share, and that was
        // skipped when copyBookingSharesToEcontract ran. One share
        // each for the two Groups is also created, lastly the
        // Booking's Owner, a different User, gets access.

        List<Sertifi2_0__TestContract__Share> econSharesAfter = [
            SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
            FROM Sertifi2_0__TestContract__Share
            WHERE ParentId = :econtract.Id
        ];

        System.assertEquals(
            4,
            econSharesAfter.size(),
            'There should be four shares on EContract, as on Booking.'
        );
    }

    @isTest
    static void copyBookingSharingToEcontractOverExistingShares() {
        User sourceUser = [SELECT Id FROM User WHERE alias = 'srcUser' LIMIT 1];

        nihrm__Booking__c booking = [
            SELECT Id, Name
            FROM nihrm__Booking__c
            WHERE Name = 'Pizza Booking III'
            LIMIT 1
        ];

        List<nihrm__Booking__Share> bookingShares = [
            SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
            FROM nihrm__Booking__Share
            WHERE ParentId = :booking.Id
        ];

        // Now, assume the role of this Source User. They will
        // create the EContract so that they have the Owner Share.
        Sertifi2_0__TestContract__c econtract;

        System.runAs(sourceUser) {
            econtract = new Sertifi2_0__TestContract__c(
                Name = 'Pizza Contract III',
                CurrencyIsoCode = 'USD',
                sertifisem__Booking__c = booking.Id
            );
            insert econtract;
        }

        // Now, insert a Share record giving the current User
        // Read Only access on that EContract.

        Sertifi2_0__TestContract__Share readShare = new Sertifi2_0__TestContract__Share(
            ParentId = econtract.Id,
            UserOrGroupId = UserInfo.getUserId(),
            AccessLevel = 'Read',
            RowCause = 'Manual'
        );
        insert readShare;

        // Now when we run the method, it should update the
        // Read share to Edit, when it finds a Full Share on
        // the Booking.
        EcontractShareUtil.copyBookingSharesToEcontract(new List<Id>{ booking.Id });

        List<Sertifi2_0__TestContract__Share> econSharesAfter = [
            SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId
            FROM Sertifi2_0__TestContract__Share
            WHERE ParentId = :econtract.Id
        ];
        // EContract Shares should have one more than Booking
        // Shares. The sourceUser has a Share on Econ, but they
        // don't actually have any sharing on the original Booking.

        System.assertEquals(bookingShares.size() + 1,econSharesAfter.size());
        // And we should find a 'Edit' share with our own
        // User Id within them.
        Sertifi2_0__TestContract__Share myShare;
        for(Sertifi2_0__TestContract__Share sa :econSharesAfter) {
            if(sa.UserOrGroupId == UserInfo.getUserId())
                myShare = sa;
        }
        System.assertNotEquals(null, myShare);
        System.assertEquals('Edit', myShare.AccessLevel);
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
            WHERE sertifisem__Booking__c = :booking.Id
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
        Database.executeBatch(new EcontractShareUtilBatchable(), 1000);
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