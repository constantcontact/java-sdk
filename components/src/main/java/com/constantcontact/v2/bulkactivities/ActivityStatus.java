/*
 * Copyright (c) 2016 Constant Contact, Inc. All Rights Reserved.
 * Boston, MA 02451, USA
 * Phone: (781) 472-8100
 * Fax: (781) 472-8101
 * This software is the confidential and proprietary information
 * of Constant Contact, Inc. created for Constant Contact, Inc.
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Constant Contact, Inc.
 */

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
