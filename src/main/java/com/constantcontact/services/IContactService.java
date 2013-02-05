package com.constantcontact.services;

import java.util.List;

import com.constantcontact.components.campaigns.Campaign;
import com.constantcontact.components.contacts.Contact;

/**
 * Interface for ContactService class.
 * 
 * @author ConstantContact
 *
 */
public interface IContactService extends IBaseService {
	/**
	 * Get an array of contacts.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param offset Offset.
	 * @param limit Limit.
	 * @return Returns a list of contacts.
	 */
	List<Contact> getContacts(String accessToken, Integer offset, Integer limit);
	
	/**
	 * Get contact details for a specific contact.
	 * @param accesToken Constant Contact OAuth2 access token.
	 * @param contactId Unique contact id.
	 * @return Returns a contact.
	 */
	Contact getContact(String accesToken, int contactId);
	
	/**
	 * Get contacts with a specified email address.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param email Contact email address to search for.
	 * @return Returns a list of contacts.
	 */
    List<Contact> getContactByEmail(String accessToken, String email);

    /**
     * Add a new contact to the Constant Contact account.
     * @param accessToken Constant Contact OAuth2 access token.
     * @param contact Contact to add.
     * @return Returns the newly created contact.
     */
    Contact addContact(String accessToken, Contact contact);

    /**
     * Delete contact details for a specific contact.
     * @param accessToken Constant Contact OAuth2 access token.
     * @param contactId Unique contact id.
     * @return Returns true if operation succeeded.
     */
    boolean deleteContact(String accessToken, int contactId);

    /**
     * Delete a contact from all contact lists.
     * @param accessToken Constant Contact OAuth2 access token.
     * @param contactId Contact id to be removed from lists.
     * @return Returns true if operation succeeded.
     */
    boolean deleteContactFromLists(String accessToken, int contactId);
    
    /**
     * Delete a contact from a specific contact list.
     * @param accessToken Constant Contact OAuth2 access token.
     * @param contactId Contact id to be removed.
     * @param listId ContactList to remove the contact from.
     * @return Returns true if operation succeeded.
     */
    boolean deleteContactFromList(String accessToken, int contactId, int listId);
    
    /**
     * Update contact details for a specific contact.
     * @param accessToken Constant Contact OAuth2 access token.
     * @param contact Contact to be updated.
     * @return Returns the updated contact.
     */
    Contact updateContact(String accessToken, Contact contact);
}
