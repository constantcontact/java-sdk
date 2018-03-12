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
public enum ActivityType {
    // add the contacts to contact list(s) specified in the import file
    ADD_CONTACTS,
    // export contacts to a supported file type
    EXPORT_CONTACTS,
    // removes all contacts from the contactlist(s) specified in the import file
    CLEAR_CONTACTS_FROM_LISTS,
    // remove the contacts from the list(s), all specified in the import file
    REMOVE_CONTACT_FROM_LISTS
}
