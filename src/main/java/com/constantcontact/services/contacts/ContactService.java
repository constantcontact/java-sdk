package com.constantcontact.services.contacts;

import com.constantcontact.components.Component;
import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.RawApiResponse;
import com.constantcontact.util.Config;
import com.constantcontact.util.ConstantContactExceptionFactory;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

/**
 * Service Layer Implementation for the Contact operations in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class ContactService extends BaseService implements IContactService {

	private String accessToken;
	private String apiKey;
	
  /**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * @param apiKey the apiKey to set
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

/**
   * Gets the contacts for the current user.<br/>
   * Implements the get Contacts operation of the Contacts API by calling the ConstantContact server side.
   * 
   * @param limit Limit.
   * @param modifiedSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
   * 		   It will return only the contacts modified since the supplied date. <br/>
   * 		   If you want to bypass this filter set modifiedSinceTimestamp to null.
   * @param status The status of contacts to return.
   * @return A {@link ResultSet} of {@link Contact} containing data as returned by the server on success; <br/>
   *         An exception is thrown otherwise.
   * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
   */

  public ResultSet<Contact> getContacts(Integer limit, String modifiedSinceTimestamp, Contact.Status status) throws ConstantContactServiceException {
    
	if (status != null && (status.equals(Contact.Status.VISITOR) || status.equals(Contact.Status.NON_SUBSCRIBER))){
	    throw new IllegalArgumentException(Config.instance().getErrorStatus() + " ACTIVE, OPTOUT, REMOVED, UNCONFIRMED.");
	}
	
    ResultSet<Contact> contacts = null;
    
    try {
      // Construct access URL
      String url = paginateUrl(String.format("%1$s%2$s", Config.instance().getBaseUrl(), Config.instance().getContacts()), limit);

      if(modifiedSinceTimestamp != null) {
        url = appendParam(url, "modified_since", modifiedSinceTimestamp);
      }
      if (status != null){
          url = appendParam(url, "status", status.toString());
      }

      // Get REST response
      RawApiResponse response = getRestClient().get(url);
      if (response.hasData()) {
        contacts = Component.resultSetFromJSON(response.getBody(), Contact.class);
      }
      if (response.isError()) {
          throw ConstantContactExceptionFactory.createServiceException(response, url);
      }
    } catch (ConstantContactServiceException e) {
      throw new ConstantContactServiceException(e);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return contacts;
  }

  /**
   * Gets a single contact for the current user, based on the contact id.<br/>
   * Implements the get Contact operation of the Contacts API by calling the ConstantContact server side.
   * 
   * @param contactId Unique contact id.
   * @return Returns a {@link Contact} containing data as returned by the server on success; <br/>
   *         An exception is thrown otherwise.
   * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
   */

  public Contact getContact(String contactId) throws ConstantContactServiceException {
    Contact contact = null;
    try {
      String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getContact(), contactId));

      RawApiResponse response = getRestClient().get(url);
      if (response.hasData()) {
        contact = Component.fromJSON(response.getBody(), Contact.class);
      }
      if (response.isError()) {
          throw ConstantContactExceptionFactory.createServiceException(response, url);
      }
    } catch (ConstantContactServiceException e) {
      throw new ConstantContactServiceException(e);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return contact;
  }

  /**
   * Gets one or more contacts for the current user, based on the contact email address.<br/>
   * Implements the get Contact By Email operation of the Contacts API by calling the ConstantContact server side.
   * 
   * @param email Contact email address to search for.
   * @return Returns a {@link ResultSet} of {@link Contact} containing data as returned by the server on success; <br/>
   *         An exception is thrown otherwise.
   * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
   */

  public ResultSet<Contact> getContactByEmail(String email) throws ConstantContactServiceException {
	  
	String encodedEmail = null;
	
    try
    {
            encodedEmail = URLEncoder.encode(email, "UTF-8");
    }
    catch(UnsupportedEncodingException ex)
    {
            throw new IllegalStateException(ex);
    }
    
    ResultSet<Contact> contacts = null;
    try {
      String url = String.format("%1$s%2$s?email=%3$s", Config.instance().getBaseUrl(), Config.instance().getContacts(), encodedEmail);

      RawApiResponse response = getRestClient().get(url);

      if (response.hasData()) {
        contacts = Component.resultSetFromJSON(response.getBody(), Contact.class);
      }
      if (response.isError()) {
          throw ConstantContactExceptionFactory.createServiceException(response, url);
      }
    } catch (ConstantContactServiceException e) {
      throw new ConstantContactServiceException(e);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return contacts;
  }

  /**
   * Adds a single contact for the current user.<br/>
   * Implements the add Contact operation of the Contacts API by calling the ConstantContact server side.
   * 
   * @param contact {@link Contact} to add.
   * @return Returns the newly created {@link Contact} containing data as returned by the server on success; <br/>
   *         An exception is thrown otherwise.
   * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
   */
  public Contact addContact(Contact contact, Boolean actionByVisitor) throws ConstantContactServiceException {
    Contact newContact = null;
    try {
      String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), Config.instance().getContacts());
      String json = contact.toJSON();

      if(actionByVisitor == true) {
        url = appendParam(url, "action_by", "ACTION_BY_VISITOR");
      }

      RawApiResponse response = getRestClient().post(url, json);
      if (response.hasData()) {
        newContact = Component.fromJSON(response.getBody(), Contact.class);
      }
      if (response.isError()) {
          throw ConstantContactExceptionFactory.createServiceException(response, url);
      }
    } catch (ConstantContactServiceException e) {
      throw new ConstantContactServiceException(e);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return newContact;
  }

  /**
   * Deletes a single contact for the current user, based on the contact id.<br/>
   * Implements the delete Contact operation of the Contacts API by calling the ConstantContact server side.
   * 
   * @param contactId Unique contact id of the contact to delete.
   * @return Returns true if operation succeeded; an exception is thrown otherwise.
   * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
   */


  public boolean deleteContact(String contactId) throws ConstantContactServiceException {
	  
	try {
		int nContactId = Integer.parseInt(contactId);
		if (nContactId < 1) {
			throw new NumberFormatException();
		}
	} catch (NumberFormatException e) {
		throw new IllegalArgumentException(Config.instance().getErrorContactOrId());
	}
    
	try {
      String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getContact(), contactId));

      RawApiResponse response = getRestClient().delete(url);
      if (response.isError()) {
          throw ConstantContactExceptionFactory.createServiceException(response, url);
      }
      return response.getStatusCode() == HttpURLConnection.HTTP_NO_CONTENT;
    } catch (ConstantContactServiceException e) {
      throw new ConstantContactServiceException(e);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
  }

  /**
   * Deletes a single contact from all the lists belonging the current user, based on the contact id.<br/>
   * The actual contact entity is not deleted using this call.<br>
   * Implements the delete Contact From Lists (all lists) operation of the Contacts API by calling the ConstantContact server side.
   * 
   * @param contactId Contact id to be removed from all the lists.
   * @return Returns true if operation succeeded; an exception is thrown otherwise.
   * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
   */


  public boolean deleteContactFromLists(String contactId) throws ConstantContactServiceException {
	  
	 if(contactId == null) {
		 throw new IllegalArgumentException(Config.instance().getErrorContactOrId());
	 }
	 
	 try {
		int nContactId = Integer.parseInt(contactId);
		if (nContactId < 1) {
			throw new NumberFormatException();
		}
	} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Config.instance().getErrorContactOrId());
	}
	  
    try {
      String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getContactLists(), contactId));
      RawApiResponse response = getRestClient().delete(url);
      if (response.isError()) {
          throw ConstantContactExceptionFactory.createServiceException(response, url);
      }
      return response.getStatusCode() == HttpURLConnection.HTTP_NO_CONTENT;
    } catch (ConstantContactServiceException e) {
      throw new ConstantContactServiceException(e);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
  }

  /**
   * Deletes a single contact from a single list belonging the current user, based on the contact id and the list id.<br/>
   * The actual contact entity is not deleted using this call.<br>
   * Implements the delete Contact From List (a specific list) operation of the Contacts API by calling the ConstantContact server side.
   * 
   * @param contactId Contact id to be removed.
   * @param listId ContactList to remove the contact from.
   * @return Returns true if operation succeeded; an exception is thrown otherwise.
   * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
   */


  public boolean deleteContactFromList(String contactId, String listId) throws ConstantContactServiceException {
	  
	try {
		int nContactId = Integer.parseInt(contactId);
		if (nContactId < 1) {
			throw new NumberFormatException();
		}
	} catch (NumberFormatException e) {
		throw new IllegalArgumentException(Config.instance().getErrorContactOrId());
	}
	try {
		int nListId = Integer.parseInt(listId);
		if (nListId < 1) {
			throw new NumberFormatException();
		}
	} catch (Exception e) {
		throw new IllegalArgumentException(Config.instance().getErrorListOrId());
	}
	
    try {
      String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getContactList(), contactId, listId));

      RawApiResponse response = getRestClient().delete(url);
      if (response.isError()) {
          throw ConstantContactExceptionFactory.createServiceException(response, url);
      }
      return response.getStatusCode() == HttpURLConnection.HTTP_NO_CONTENT;
    } catch (ConstantContactServiceException e) {
      throw new ConstantContactServiceException(e);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
  }

  /**
   * Updates a single contact for the current user, based on the contact id.<br/>
   * Implements the update Contact operation of the Contacts API by calling the ConstantContact server side.<br/>
   * A specific contact is identified by its internal id.
   *
   * @param contact {@link Contact} to be updated.
   * @return Returns the updated {@link Contact} containing data as returned by the server on success; <br/>
   *         An exception is thrown otherwise.
   * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
   */
  public Contact updateContact(Contact contact, Boolean actionByVisitor) throws ConstantContactServiceException {
	  
	if (contact == null) {
		throw new IllegalArgumentException(Config.instance().getErrorContactOrId());
	}
	if (contact.getId() == null || !(contact.getId().length() > 0)) {
		throw new IllegalArgumentException(Config.instance().getErrorId());
	}
	
    Contact updateContact = null;
    try {
      String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getContact(), contact.getId()));
      String json = contact.toJSON();

      if(actionByVisitor == true) {
        url = appendParam(url, "action_by", "ACTION_BY_VISITOR");
      }

      RawApiResponse response = getRestClient().put(url, json);
      if (response.hasData()) {
        updateContact = Component.fromJSON(response.getBody(), Contact.class);
      }
      if (response.isError()) {
          throw ConstantContactExceptionFactory.createServiceException(response, url);
      }
    } catch (ConstantContactServiceException e) {
      throw new ConstantContactServiceException(e);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return updateContact;
  }  
	

  /**
   * Default constructor.
   */
  public ContactService(String accessToken, String apiKey) {
    super(accessToken, apiKey);
    this.setAccessToken(accessToken);
    this.setApiKey(apiKey);
  }
}
