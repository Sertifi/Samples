public with sharing class EcontractShareUtilBatchable implements Database.Batchable<SObject> {

    private String query;

    // In this draft, we will always process *all* Share
    // records from all Bookings that have related EContracts

    public EcontractShareUtilBatchable() {
        this.query = 'SELECT Id, UserOrGroupId, AccessLevel, RowCause, ParentId';
        this.query += ' FROM nihrm__Booking__Share';
        this.query += ' WHERE RowCause != \'Owner\'';
        this.query += ' AND IsDeleted = false';
        this.query += ' AND ParentId IN';
        this.query += ' (SELECT sertifisem__Booking__c FROM Sertifi2_0__TestContract__c';
        this.query += ' WHERE sertifisem__Booking__c != null)';
    }
    
    public Database.QueryLocator start(Database.BatchableContext bc) {
        return Database.getQueryLocator(query);
    }

    public void execute(Database.BatchableContext bc, List<SObject> scope) {
        EcontractShareUtil.mirrorSharesOnEcontract((List<nihrm__Booking__Share>) scope);
    }

    public void finish(Database.BatchableContext bc) {
    }

}