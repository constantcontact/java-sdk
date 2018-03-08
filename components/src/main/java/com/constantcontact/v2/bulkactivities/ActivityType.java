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
