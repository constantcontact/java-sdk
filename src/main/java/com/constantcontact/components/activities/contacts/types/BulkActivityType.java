package com.constantcontact.components.activities.contacts.types;

import com.constantcontact.components.activities.contacts.response.ContactsResponse;
import com.constantcontact.services.activities.IBulkActivitiesService;

/**
 * Contacts Bulk Activity Type possible values for the Bulk Activities in Constant Contact, as seen in {@link ContactsResponse#type}<br/>
 * These must be used when calling {@link IBulkActivitiesService#getDetailedStatusReport(String, String, String, String)}
 * 
 * @author ConstantContact
 * 
 */
public final class BulkActivityType {

	/**
	 * Bulk Activity Type for ADD_CONTACTS
	 */
	public static final String ADD_CONTACTS = "ADD_CONTACTS";

	/**
	 * Bulk Activity Type for REMOVE_CONTACTS_FROM_LISTS
	 */
	public static final String REMOVE_CONTACTS_FROM_LISTS = "REMOVE_CONTACTS_FROM_LISTS";

	/**
	 * Bulk Activity Type for CLEAR_CONTACTS_FROM_LISTS
	 */
	public static final String CLEAR_CONTACTS_FROM_LISTS = "CLEAR_CONTACTS_FROM_LISTS";

	/**
	 * Bulk Activity Type for EXPORT_CONTACTS
	 */
	public static final String EXPORT_CONTACTS = "EXPORT_CONTACTS";

	/**
	 * Default constructor.<br/>
	 * Made private to prevent instantiation.<br/>
	 * This is unreachable from the outside, since current class is used only as a repository for constants.
	 */
	private BulkActivityType() {
	}
}
