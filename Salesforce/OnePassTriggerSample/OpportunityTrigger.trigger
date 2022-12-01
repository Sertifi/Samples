trigger OpportunityTrigger on Opportunity(before update) {
    OpportunityTriggerHandler.handleUpdate(Trigger.newMap, Trigger.oldMap);
}
