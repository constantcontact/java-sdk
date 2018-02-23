package com.constantcontact.v2.bulkactivities;

/**
 */
public enum ActivityStatus {
    // the activity has been picked up from the queue and is running
    RUNNING,
    // the activity has completed without errors
    COMPLETE,
    // the activity was cancelled; activities can be cancelled using the product UI only
    CANCELLED,
    // errors occurred when the job was run
    ERROR,
    // initial state for an activity after it is created
    PENDING,
    // the activity has been retrieved and is in the queue to be run
    QUEUED,
    // the activity has not been created yet
    UNCONFIRMED
}
