package com.constantcontact.services.contacts;

import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.IBaseService;

/**
 * Interface for {@link ContactService} class in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public interface IContactService extends IBaseService {

	/**
	 * Implements the get Contacts operation of the Contacts API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param offset Offset.
	 * @param limit Limit.
	 * @return A {@link ResultSet} of {@link Contact} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	ResultSet<Contact> getContacts(String accessToken, Integer offset, Integer limit) throws ConstantContactServiceException;

	/**
	 * Implements the get Contact operation of the Contacts API by calling the ConstantContact server side.
	 * 
	 * @param accesToken Constant Contact OAuth2 access token.
	 * @param contactId Unique contact id.
	 * @return Returns a {@link Contact} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	Contact getContact(String accesToken, String contactId) throws ConstantContactServiceException;

	/**
	 * Implements the get Contact By Email operation of the Contacts API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param email Contact email address to search for.
	 * @return Returns a {@link ResultSet} of {@link Contact} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	ResultSet<Contact> getContactByEmail(String accessToken, String email) throws ConstantContactServiceException;

	/**
	 * Implements the add Contact operation of the Contacts API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contact {@link Contact} to add.
	 * @return Returns the newly created {@link Contact} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	Contact addContact(String accessToken, Contact contact) throws ConstantContactServiceException;

	/**
	 * Implements the delete Contact operation of the Contacts API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contactId Unique contact id of the contact to delete.
	 * @return Returns true if operation succeeded; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	boolean deleteContact(String accessToken, String contactId) throws ConstantContactServiceException;

	/**
	 * Implements the delete Contact From Lists (all lists) operation of the Contacts API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contactId Contact id to be removed from all the lists.
	 * @return Returns true if operation succeeded; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	boolean deleteContactFromLists(String accessToken, String contactId) throws ConstantContactServiceException;

	/**
	 * Implements the delete Contact From List (a specific list) operation of the Contacts API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contactId Contact id to be removed.
	 * @param listId ContactList to remove the contact from.
	 * @return Returns true if operation succeeded; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	boolean deleteContactFromList(String accessToken, String contactId, String listId) throws ConstantContactServiceException;

	/**
	 * Implements the update Contact operation of the Contacts API by calling the ConstantContact server side.<br/>
	 * A specific contact is identified by its internal id.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contact {@link Contact} to be updated.
	 * @return Returns the updated {@link Contact} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	Contact updateContact(String accessToken, Contact contact) throws ConstantContactServiceException;
}
