package com.constantcontact.components.contacts;

/**
 * Contact lists status constants for the ContactList Service in Constant Contact.<br/>
 * Use this whenever a contact list status field is expected.<br/>
 * Most likely, will be for {@link ContactList#getStatus()} and {@link ContactList#setStatus(String)}
 * 
 * @author ConstantContact
 */
public final class ContactListStatus {
	/**
	 * ACTIVE ContactList Type.
	 * The list is visible to contacts to join, and visible to the account owner.
	 */
	public static final String ACTIVE = "ACTIVE";

	/**
	 * HIDDEN ContactList Type.
	 * List is not visible to contacts, but it is available to the account owner.
	 */
	public static final String HIDDEN = "HIDDEN";

	/**
	 * Default constructor.<br/>
	 * Made private to prevent instantiation.<br/>
	 * This is unreachable from the outside, since current class is used only as a repository for constants.
	 */
	private ContactListStatus() {
	}
}
