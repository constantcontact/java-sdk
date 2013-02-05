package com.constantcontact.services;

import java.util.List;

import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.contacts.ContactList;

/**
 * Interface for ListService class.
 * 
 * @author ConstantContact
 *
 */
public interface IListService extends IBaseService {
	/**
	 * Get lists within an account.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @return Returns a list of contact lists.
	 */
	List<ContactList> getLists(String accessToken);
	
	/**
	 * Add a new list.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param list Contact list.
	 * @return Returns the newly created list.
	 */
	ContactList addList(String accessToken, ContactList list);
	
	/**
	 * Get an individual contact list.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param listId List id.
	 * @return Returns a contact list.
	 */
	ContactList getList(String accessToken, int listId);
	
	/**
	 * Get all contacts from an individual list.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param listId List id to retrieve contacts for.
	 * @return Returns a list of contacts.
	 */
	List<Contact> getContactsFromList(String accessToken, int listId);
}
