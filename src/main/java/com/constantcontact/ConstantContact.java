package com.constantcontact;

import java.util.List;


import com.constantcontact.components.accounts.VerifiedEmailAddress;
import com.constantcontact.components.activities.contacts.request.AddContactsRequest;
import com.constantcontact.components.activities.contacts.request.ClearListsRequest;
import com.constantcontact.components.activities.contacts.request.ExportContactsRequest;
import com.constantcontact.components.activities.contacts.request.RemoveContactsRequest;
import com.constantcontact.components.activities.contacts.response.ContactsResponse;
import com.constantcontact.components.activities.contacts.response.DetailedStatusReport;
import com.constantcontact.components.activities.contacts.response.SummaryReport;
import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.contacts.ContactList;
import com.constantcontact.components.contacts.tracking.bounces.ContactTrackingBounce;
import com.constantcontact.components.contacts.tracking.clicks.ContactTrackingClick;
import com.constantcontact.components.contacts.tracking.forwards.ContactTrackingForward;
import com.constantcontact.components.contacts.tracking.opens.ContactTrackingOpen;
import com.constantcontact.components.contacts.tracking.reports.summary.ContactTrackingSummaryReport;
import com.constantcontact.components.contacts.tracking.sends.ContactTrackingSend;
import com.constantcontact.components.contacts.tracking.unsubscribes.ContactTrackingUnsubscribe;
import com.constantcontact.components.emailcampaigns.EmailCampaignBase;
import com.constantcontact.components.emailcampaigns.EmailCampaignRequest;
import com.constantcontact.components.emailcampaigns.EmailCampaignResponse;
import com.constantcontact.components.emailcampaigns.schedules.EmailCampaignSchedule;
import com.constantcontact.components.emailcampaigns.tracking.bounces.EmailCampaignTrackingBounce;
import com.constantcontact.components.emailcampaigns.tracking.clicks.EmailCampaignTrackingClick;
import com.constantcontact.components.emailcampaigns.tracking.forwards.EmailCampaignTrackingForward;
import com.constantcontact.components.emailcampaigns.tracking.opens.EmailCampaignTrackingOpen;
import com.constantcontact.components.emailcampaigns.tracking.reports.summary.EmailCampaignTrackingSummary;
import com.constantcontact.components.emailcampaigns.tracking.sends.EmailCampaignTrackingSend;
import com.constantcontact.components.emailcampaigns.tracking.unsubscribes.EmailCampaignTrackingUnsubscribe;
import com.constantcontact.components.generic.response.Pagination;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.ConstantContactException;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.accounts.AccountService;
import com.constantcontact.services.accounts.IAccountService;
import com.constantcontact.services.activities.BulkActivitiesService;
import com.constantcontact.services.activities.IBulkActivitiesService;
import com.constantcontact.services.contactlists.ContactListService;
import com.constantcontact.services.contactlists.IContactListService;
import com.constantcontact.services.contacts.ContactService;
import com.constantcontact.services.contacts.IContactService;
import com.constantcontact.services.contacts.tracking.ContactTrackingService;
import com.constantcontact.services.contacts.tracking.IContactTrackingService;
import com.constantcontact.services.emailcampaigns.EmailCampaignService;
import com.constantcontact.services.emailcampaigns.IEmailCampaignService;
import com.constantcontact.services.emailcampaigns.schedule.EmailCampaignScheduleService;
import com.constantcontact.services.emailcampaigns.schedule.IEmailCampaignScheduleService;
import com.constantcontact.services.emailcampaigns.tracking.EmailCampaignTrackingService;
import com.constantcontact.services.emailcampaigns.tracking.IEmailCampaignTrackingService;
import com.constantcontact.util.Config;
import com.constantcontact.util.Config.Errors;

/**
 * Main Constant Contact class.<br/>
 * This is meant to be used by users to access Constant Contact API functionality.<br/>
 * <ul>
 * <li>{@link ContactService}</li>
 * <li>{@link ContactListService}</li>
 * <li>{@link EmailCampaignService}</li>
 * <li>{@link AccountService}</li>
 * <li>{@link EmailCampaignScheduleService}</li>
 * <li>{@link EmailCampaignTrackingService}</li>
 * <li>{@link ContactTrackingService}</li>
 * <li>{@link BulkActivitiesService}</li>
 * </ul>
 * 
 * @author ConstantContact
 */
public class ConstantContact {

	private String accessToken;
	public static String API_KEY;
	
	private IContactService contactService;
	private IContactListService contactListService;
	private IEmailCampaignService emailCampaignService;
	private IAccountService accountService;
	private IEmailCampaignScheduleService emailCampaignScheduleService;
	private IEmailCampaignTrackingService emailCampaignTrackingService;
	private IContactTrackingService contactTrackingService;
	private IBulkActivitiesService bulkActivitiesService;
	
	/**
	 * Custom Class constructor.<br/>
	 * Initializes all Services and the OAuth token fetcher;
	 *
	 * @param apiKey The API key provided by Constant Contact.
	 * @param accessToken The The API key provided by Constant Contact Authentication workflow.
	 */
	public ConstantContact(String apiKey, String accessToken) {

		this.accessToken = accessToken;
		ConstantContact.API_KEY = apiKey;
		this.setContactService(new ContactService());
		this.setListService(new ContactListService());
		this.setEmailCampaignService(new EmailCampaignService());
		this.setAccountService(new AccountService());
		this.setEmailCampaignScheduleService(new EmailCampaignScheduleService());
		this.setEmailCampaignTrackingService(new EmailCampaignTrackingService());
		this.setContactTrackingService(new ContactTrackingService());
		this.setBulkActivitiesService(new BulkActivitiesService());
	}
	
	/**
	 * Get the access token.<br/>
	 * 
	 * @return The access token.
	 */
	public String getAccessToken() {
		return accessToken;
	}


	// ****************************************************************************//
	// GETTERS AND SETTERS ********************************************************//
	// ****************************************************************************//

	/**
	 * Get the Contact service.
	 * 
	 * @return The Contact service.
	 */
	public IContactService getContactService() {
		return contactService;
	}

	/**
	 * Set the Contact service.
	 * 
	 * @param contactService The Contact service.
	 */
	public void setContactService(IContactService contactService) {
		this.contactService = contactService;
	}

	/**
	 * Get the List service.
	 * 
	 * @return The List service.
	 */
	public IContactListService getListService() {
		return contactListService;
	}

	/**
	 * Set the List service.
	 * 
	 * @param contactListService The List service.
	 */
	public void setListService(IContactListService contactListService) {
		this.contactListService = contactListService;
	}

	/**
	 * Set the {@link EmailCampaignService}
	 * 
	 * @param emailCampaignService The {@link EmailCampaignService}
	 */
	public void setEmailCampaignService(IEmailCampaignService emailCampaignService) {
		this.emailCampaignService = emailCampaignService;
	}

	/**
	 * Get the {@link EmailCampaignService}
	 * 
	 * @return The {@link EmailCampaignService}
	 */
	public IEmailCampaignService getEmailCampaignService() {
		return emailCampaignService;
	}

	/**
	 * Set the {@link AccountService}
	 * 
	 * @param accountService The {@link AccountService}
	 */
	public void setAccountService(IAccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * Get the {@link AccountService}
	 * 
	 * @return The {@link AccountService}
	 */
	public IAccountService getAccountService() {
		return accountService;
	}

	/**
	 * Set the {@link EmailCampaignScheduleService}
	 * 
	 * @param emailCampaignScheduleService The {@link EmailCampaignScheduleService}
	 */
	public void setEmailCampaignScheduleService(IEmailCampaignScheduleService emailCampaignScheduleService) {
		this.emailCampaignScheduleService = emailCampaignScheduleService;
	}

	/**
	 * Get the {@link EmailCampaignScheduleService}
	 * 
	 * @return The {@link EmailCampaignScheduleService}
	 */
	public IEmailCampaignScheduleService getEmailCampaignScheduleService() {
		return emailCampaignScheduleService;
	}

	/**
	 * Set the {@link EmailCampaignTrackingService}
	 * 
	 * @param emailCampaignTrackingSummaryService The {@link EmailCampaignTrackingService}
	 */
	public void setEmailCampaignTrackingService(IEmailCampaignTrackingService emailCampaignTrackingSummaryService) {
		this.emailCampaignTrackingService = emailCampaignTrackingSummaryService;
	}

	/**
	 * Get the {@link EmailCampaignTrackingService}
	 * 
	 * @return The {@link EmailCampaignTrackingService}
	 */
	public IEmailCampaignTrackingService getEmailCampaignTrackingService() {
		return emailCampaignTrackingService;
	}

	/**
	 * Set the {@link ContactTrackingService}
	 * 
	 * @param contactTrackingService The {@link ContactTrackingService}
	 */
	public void setContactTrackingService(IContactTrackingService contactTrackingService) {
		this.contactTrackingService = contactTrackingService;
	}

	/**
	 * Get the {@link ContactTrackingService}
	 * 
	 * @return The {@link ContactTrackingService}
	 */
	public IContactTrackingService getContactTrackingService() {
		return contactTrackingService;
	}

	/**
	 * Set the {@link BulkActivitiesService}
	 * 
	 * @param bulkActivitiesService The {@link BulkActivitiesService}
	 */
	public void setBulkActivitiesService(IBulkActivitiesService bulkActivitiesService) {
		this.bulkActivitiesService = bulkActivitiesService;
	}

	/**
	 * Get the {@link BulkActivitiesService}
	 * 
	 * @return The {@link BulkActivitiesService}
	 */
	public IBulkActivitiesService getBulkActivitiesService() {
		return bulkActivitiesService;
	}

	// ****************************************************************************//
	// END OF GETTERS AND SETTERS ************************************************//
	// ****************************************************************************//

	/**
	 * Get contacts API.<br/>
	 * Details in : {@link ContactService#getContacts(String, Integer, Integer, String)}
	 * 
	 * @param offset The offset
	 * @param limit The limit
	 * @param modifiedSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the contacts modified since the supplied date. <br/>
	 * 		   If you want to bypass this filter set modifiedSinceTimestamp to null.
	 * @return The contacts.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<Contact> getContacts(Integer limit, String modifiedSinceTimestamp) throws ConstantContactServiceException {
		return contactService.getContacts(this.getAccessToken(), limit, modifiedSinceTimestamp);
	}
	/**
	 * Get contacts API.<br/>
	 * Details in : {@link ContactService#getContacts(String, Integer, Integer, String)}
	 * 
	 * @param modifiedSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the contacts modified since the supplied date. <br/>
	 * 		   If you want to bypass this filter set modifiedSinceTimestamp to null.
	 * 
	 * @return The contacts.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<Contact> getContacts(String modifiedSinceTimestamp) throws ConstantContactServiceException {
		return contactService.getContacts(this.getAccessToken(), null, modifiedSinceTimestamp);
	}
	
	/**
	 * Get contacts API.<br/>
	 * Details in : {@link ContactService#getContacts(String, Integer, Integer, String)}
	 * 
	 * @param pagination {@link Pagination} object.
	 *            
	 * @param modifiedSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the contacts modified since the supplied date. <br/>
	 * 		   If you want to bypass this filter set modifiedSinceTimestamp to null.
	 * 
	 * @return The contacts.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<Contact> getContacts(Pagination pagination, String modifiedSinceTimestamp) throws ConstantContactServiceException {
		return contactService.getContactsFromPage(this.getAccessToken(), pagination, modifiedSinceTimestamp);
	}


	/**
	 * Get contact API.<br/>
	 * Details in : {@link ContactService#getContact(String, String)}
	 * 
	 * @param contactId The contact id.
	 * @return The contact.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public Contact getContact(String contactId) throws ConstantContactServiceException {
		return contactService.getContact(this.getAccessToken(), contactId);
	}

	/**
	 * Get Contact By Email API.<br/>
	 * Details in : {@link ContactService#getContactByEmail(String, String)}
	 * 
	 * @param email The email address.
	 * @return A {@link ResultSet} of {@link Contact}.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<Contact> getContactByEmail(String email) throws ConstantContactServiceException {
		return contactService.getContactByEmail(this.getAccessToken(), email);
	}

	/**
	 * Add Contact API.<br/>
	 * Details in : {@link ContactService#addContact(String, Contact, Boolean)}
	 * 
	 * @param contact The {@link Contact} to add.
	 * @return The added contact.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public Contact addContact(Contact contact, Boolean actionByVisitor) throws ConstantContactServiceException {
		return contactService.addContact(this.getAccessToken(), contact, actionByVisitor.booleanValue());
	}
	
	/**
	 * Add Contact API.<br/>
	 * Details in : {@link ContactService#addContact(String, Contact, Boolean)}
	 * 
	 * @param contact The {@link Contact} to add.
	 * @return The added contact.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	
	public Contact addContact(Contact contact) throws ConstantContactServiceException {
		return contactService.addContact(this.getAccessToken(), contact, false);
	}

	/**
	 * Delete Contact API.<br/>
	 * Details in : {@link #deleteContact(String)}
	 * 
	 * @param contact The contact to delete.
	 * @return true in case of success, an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public boolean deleteContact(Contact contact) throws IllegalArgumentException, ConstantContactServiceException {
		if (contact == null) {
			throw new IllegalArgumentException(Config.Errors.CONTACT_OR_ID);
		}
		return deleteContact(contact.getId());
	}

	/**
	 * Delete Contact API.<br/>
	 * Details in : {@link ContactService#deleteContact(String, String)}
	 * 
	 * @param contactId The contact id.
	 * @return true in case of success, an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public boolean deleteContact(String contactId) throws IllegalArgumentException, ConstantContactServiceException {
		try {
			int nContactId = Integer.parseInt(contactId);
			if (nContactId < 1) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Config.Errors.CONTACT_OR_ID);
		}
		return contactService.deleteContact(this.getAccessToken(), contactId);
	}

	/**
	 * Delete Contact From Lists API.<br/>
	 * Details in : {@link ContactService#deleteContactFromLists(String, String)}
	 * 
	 * @param contactId The contact id.
	 * @return true in case of success, an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public boolean deleteContactFromLists(String contactId) throws IllegalArgumentException, ConstantContactServiceException {
		try {
			int nContactId = Integer.parseInt(contactId);
			if (nContactId < 1) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Config.Errors.CONTACT_OR_ID);
		}
		return contactService.deleteContactFromLists(this.getAccessToken(), contactId);
	}

	/**
	 * Delete Contact From Lists API.<br/>
	 * Details in : {@link ContactService#deleteContactFromLists(String, String)}
	 * 
	 * @param contact The Contact to delete. Match is done on id.
	 * @return true in case of success, an exception is thrown otherwise.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public boolean deleteContactFromLists(Contact contact) throws ConstantContactServiceException {
		if (contact == null) {
			throw new IllegalArgumentException(Config.Errors.CONTACT_OR_ID);
		}
		return contactService.deleteContactFromLists(this.getAccessToken(), contact.getId());
	}

	/**
	 * Delete Contact From List API.<br/>
	 * Details in : {@link ContactService#deleteContactFromList(String, String, String)}
	 * 
	 * @param contact The {@link Contact}
	 * @param list The {@link ContactList}
	 * @return true in case of success, an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public boolean deleteContactFromList(Contact contact, ContactList list) throws IllegalArgumentException, ConstantContactServiceException {
		if (contact == null) {
			throw new IllegalArgumentException(Config.Errors.CONTACT_OR_ID);
		}
		if (list == null) {
			throw new IllegalArgumentException(Config.Errors.LIST_OR_ID);
		}
		return contactService.deleteContactFromList(this.getAccessToken(), contact.getId(), list.getId());
	}

	/**
	 * Delete Contact From List API.<br/>
	 * Details in : {@link ContactService#deleteContactFromList(String, String, String)}
	 * 
	 * @param contactId The contact id.
	 * @param listId The list id.
	 * @return true in case of success, an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public boolean deleteContactFromList(String contactId, String listId) throws IllegalArgumentException, ConstantContactServiceException {
		try {
			int nContactId = Integer.parseInt(contactId);
			if (nContactId < 1) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Config.Errors.CONTACT_OR_ID);
		}
		try {
			int nListId = Integer.parseInt(listId);
			if (nListId < 1) {
				throw new NumberFormatException();
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(Config.Errors.LIST_OR_ID);
		}

		return contactService.deleteContactFromList(this.getAccessToken(), contactId, listId);
	}

	/**
	 * 
	 * Update Contact API.<br/>
	 * Details in : {@link ContactService#updateContact(String, Contact, Boolean)}
	 * 
	 * @param contact The {@link Contact} to update.
	 * @return The updated {@link Contact} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public Contact updateContact(Contact contact) throws IllegalArgumentException, ConstantContactServiceException {
		if (contact == null) {
			throw new IllegalArgumentException(Config.Errors.CONTACT_OR_ID);
		}
		if (contact.getId() == null || !(contact.getId().length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return contactService.updateContact(this.getAccessToken(), contact, false);
	}
	
	/**
	 * 
	 * Update Contact API.<br/>
	 * Details in : {@link ContactService#updateContact(String, Contact, Boolean)}
	 * 
	 * @param contact The {@link Contact} to update.
	 * @return The updated {@link Contact} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	
	public Contact updateContact(Contact contact, Boolean actionByVisitor) throws IllegalArgumentException, ConstantContactServiceException {
		if (contact == null) {
			throw new IllegalArgumentException(Config.Errors.CONTACT_OR_ID);
		}
		if (contact.getId() == null || !(contact.getId().length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return contactService.updateContact(this.getAccessToken(), contact, actionByVisitor.booleanValue());
	}

	/**
	 * Get Contact Lists API.<br/>
	 * Details in : {@link ContactListService#getLists(String, String)}
	 * 
	 * @param modifiedSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the contact lists modified since the supplied date. <br/>
	 * 		   If you want to bypass this filter set modifiedSinceTimestamp to null.
	 * 
	 * @return The Contact Lists in case of success; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public List<ContactList> getLists(String modifiedSinceTimestamp) throws ConstantContactServiceException {
		return contactListService.getLists(this.getAccessToken(), modifiedSinceTimestamp);
	}

	/**
	 * 
	 * Get Contact List API.<br/>
	 * Details in : {@link ContactListService#getList(String, String)}
	 * 
	 * @param listId The List id
	 * @return A {@link ContactList} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ContactList getList(String listId) throws IllegalArgumentException, ConstantContactServiceException {
		try {
			int nListId = Integer.parseInt(listId);
			if (nListId < 1) {
				throw new NumberFormatException();
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(Config.Errors.LIST_OR_ID);
		}

		return contactListService.getList(this.getAccessToken(), listId);
	}

	/**
	 * Add Contact List API.<br/>
	 * Details in : {@link ContactListService#addList(String, ContactList)}
	 * 
	 * @param list The {@link ContactList} to add.
	 * @return The added {@link ContactList} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ContactList addList(ContactList list) throws IllegalArgumentException, ConstantContactServiceException {
		try {
			return contactListService.addList(this.getAccessToken(), list);
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		}
	}
	// TODO change doc
	/**
	 * 
	 * Get Contacts From List API.<br/>
	 * Details in : {@link ContactListService#getContactsFromList(String, String)}
	 * 
	 * @param list The {@link ContactList} for which to lookup contacts.
	 * @return A {@link ResultSet} of {@link Contact} containing data as returned by the server on success; <br/>
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<Contact> getContactsFromList(ContactList list) throws IllegalArgumentException, ConstantContactServiceException {
		if (list == null) {
			throw new IllegalArgumentException(Config.Errors.LIST_OR_ID);
		}
		return contactListService.getContactsFromList(this.getAccessToken(), list.getId(), null, null);
	}

	/**
	 * 
	 * Get Contacts From List API.<br/>
	 * Details in : {@link ContactListService#getContactsFromList(String, String)}
	 * 
	 * @param listId The id of the {@link ContactList}
	 * @return A {@link ResultSet} of {@link Contact} containing data as returned by the server on success; <br/>
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<Contact> getContactsFromList(String listId) throws IllegalArgumentException, ConstantContactServiceException {
		try {
			int nListId = Integer.parseInt(listId);
			if (nListId < 1) {
				throw new NumberFormatException();
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(Config.Errors.LIST_OR_ID);
		}

		try {
			return contactListService.getContactsFromList(this.getAccessToken(), listId, null, null);
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		}
	}
	//TODO change doc
	/**
	 * 
	 * Get Contacts From List API.<br/>
	 * Details in : {@link ContactListService#getContactsFromList(String, String)}
	 * 
	 * @param listId The id of the {@link ContactList}
	 * @return A {@link ResultSet} of {@link Contact} containing data as returned by the server on success; <br/>
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<Contact> getContactsFromList(ContactList list, Integer limit, String modifiedSinceTimestamp) throws IllegalArgumentException,
	ConstantContactServiceException {
		if (list == null) {
			throw new IllegalArgumentException(Config.Errors.LIST_OR_ID);
		}
		return contactListService.getContactsFromList(this.getAccessToken(), list.getId(), limit, modifiedSinceTimestamp);
	}
	
	//TODO change doc
	/**
	 * 
	 * Get Contacts From List API.<br/>
	 * Details in : {@link ContactListService#getContactsFromList(String, String)}
	 * 
	 * @return A {@link ResultSet} of {@link Contact} containing data as returned by the server on success; <br/>
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<Contact> getContactsFromList(Pagination pagination, String modifiedSinceTimestamp)
			throws IllegalArgumentException, ConstantContactServiceException {
		if (pagination == null) {
			throw new IllegalArgumentException(Config.Errors.PAGINATION_NULL);
		}
		return contactListService.getContactsFromListAtPage(this.getAccessToken(), pagination, modifiedSinceTimestamp);
	}
	
	//TODO change doc
	/**
	 * 
	 * Get Email Campaigns API.<br/>
	 * Details in : {@link EmailCampaignService#getCampaigns(String, Integer, Integer, String)}
	 * 
	 * @return A {@link ResultSet} of {@link EmailCampaignResponse} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<EmailCampaignResponse> getEmailCampaigns() throws IllegalArgumentException, ConstantContactServiceException {
		return emailCampaignService.getCampaigns(this.getAccessToken(), null, null);
	}

	/**
	 * 
	 * Get Email Campaigns API.<br/>
	 * Details in : {@link EmailCampaignService#getCampaigns(String, Integer, String)}
	 * 
	 * @param limit The limit
	 * @param modifiedSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the email campaigns modified since the supplied date. <br/>
	 * 		   If you want to bypass this filter set modifiedSinceTimestamp to null.
	 * 
	 * @return A {@link ResultSet} of {@link EmailCampaignResponse} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<EmailCampaignResponse> getEmailCampaigns(Integer limit, String modifiedSinceTimestamp) throws IllegalArgumentException,
	ConstantContactServiceException {
		return emailCampaignService.getCampaigns(this.getAccessToken(), limit, modifiedSinceTimestamp);
	}
	//TODO change documentation
	/**
	 * 
	 * Get Email Campaigns API.<br/>
	 * Details in : {@link EmailCampaignService#getCampaigns(String, Integer, String)}
	 * 
	 * @param limit The limit
	 * @param modifiedSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the email campaigns modified since the supplied date. <br/>
	 * 		   If you want to bypass this filter set modifiedSinceTimestamp to null.
	 * 
	 * @return A {@link ResultSet} of {@link EmailCampaignResponse} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<EmailCampaignResponse> getEmailCampaigns(Pagination pagination, String modifiedSinceTimestamp) throws IllegalArgumentException,
			ConstantContactServiceException {
		return emailCampaignService.getCampaignsFromPage(this.getAccessToken(), pagination, modifiedSinceTimestamp);
	}

	/**
	 * 
	 * Get Email Campaign API.<br/>
	 * Details in : {@link EmailCampaignService#getCampaign(String, String)}
	 * 
	 * @param campaignId The id of the Email Campaign
	 * @return An {@link EmailCampaignResponse} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public EmailCampaignResponse getEmailCampaign(String campaignId) throws IllegalArgumentException, ConstantContactServiceException {
		if (campaignId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return emailCampaignService.getCampaign(this.getAccessToken(), campaignId);

	}

	/**
	 * 
	 * Update Email Campaign API.<br/>
	 * Details in : {@link EmailCampaignService#updateCampaign(String, EmailCampaignRequest)}
	 * 
	 * @param emailCampaign The {@link EmailCampaignRequest} which we want to update. Match is done on id.
	 * @return An {@link EmailCampaignResponse} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public EmailCampaignResponse updateEmailCampaign(EmailCampaignRequest emailCampaign) throws IllegalArgumentException, ConstantContactServiceException {
		if (emailCampaign == null || !(emailCampaign.getId().length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return emailCampaignService.updateCampaign(this.getAccessToken(), emailCampaign);
	}

	/**
	 * 
	 * Add Email Campaign API.<br/>
	 * Details in : {@link EmailCampaignService#addCampaign(String, EmailCampaignRequest)}
	 * 
	 * @param emailCampaign The {@link EmailCampaignRequest} to add.
	 * @return An {@link EmailCampaignResponse} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public EmailCampaignResponse addEmailCampaign(EmailCampaignRequest emailCampaign) throws IllegalArgumentException, ConstantContactServiceException {
		if (emailCampaign == null) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return emailCampaignService.addCampaign(this.getAccessToken(), emailCampaign);
	}

	/**
	 * 
	 * Get Verified Email Addresses API.<br/>
	 * Details in : {@link AccountService#getVerifiedEmailAddresses(String, String)}
	 * 
	 * @param status The status
	 * @return A {@link List} of {@link VerifiedEmailAddress} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public List<VerifiedEmailAddress> getVerifiedEmailAddresses(String status) throws IllegalArgumentException, ConstantContactServiceException {
		if (status != null && status.length() > 0) {
			if (!status.equals(VerifiedEmailAddress.Status.CONFIRMED) && !status.equals(VerifiedEmailAddress.Status.UNCONFIRMED))
				throw new IllegalArgumentException(Config.Errors.STATUS + VerifiedEmailAddress.Status.CONFIRMED + ", " + VerifiedEmailAddress.Status.CONFIRMED);
		}
		return accountService.getVerifiedEmailAddresses(this.getAccessToken(), status);
	}

	/**
	 * 
	 * Get Email Campaign Schedules API.<br/>
	 * Details in : {@link EmailCampaignScheduleService#getSchedules(String, String)}
	 * 
	 * @param campaignId The id of the Email Campaign.
	 * @return A {@link List} of {@link EmailCampaignSchedule} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public List<EmailCampaignSchedule> getEmailCampaignSchedules(String campaignId) throws IllegalArgumentException, ConstantContactServiceException {

		if (campaignId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}

		return emailCampaignScheduleService.getSchedules(this.getAccessToken(), campaignId);
	}

	/**
	 * 
	 * Get Email Campaign Schedule API.<br/>
	 * Details in : {@link EmailCampaignScheduleService#getSchedule(String, String, String)}
	 * 
	 * @param campaignId The id of the Email Campaign.
	 * @param scheduleId The id of the Schedule.
	 * @return An {@link EmailCampaignSchedule} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public EmailCampaignSchedule getEmailCampaignSchedule(String campaignId, String scheduleId) throws IllegalArgumentException,
			ConstantContactServiceException {

		if (campaignId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		if (scheduleId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}

		return emailCampaignScheduleService.getSchedule(this.getAccessToken(), campaignId, scheduleId);
	}

	/**
	 * 
	 * Delete Email Campaign Schedule API.<br/>
	 * Details in : {@link EmailCampaignScheduleService#deleteSchedule(String, String, String)}
	 * 
	 * @param campaignId The id of the Email Campaign.
	 * @param scheduleId The id of the Schedule.
	 * @return true in case of success, an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public boolean deleteEmailCampaignSchedule(String campaignId, String scheduleId) throws IllegalArgumentException, ConstantContactServiceException {
		if (campaignId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		if (scheduleId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}

		return emailCampaignScheduleService.deleteSchedule(this.getAccessToken(), campaignId, scheduleId);
	}

	/**
	 * 
	 * Add Email Campaign Schedule API.<br/>
	 * Details in : {@link EmailCampaignScheduleService#addSchedule(String, String, EmailCampaignSchedule)}
	 * 
	 * @param campaignId The id of the Email Campaign for which we need to add a new Schedule.
	 * @param emailCampaignSchedule The {@link EmailCampaignSchedule} instance to be added. <br/>
	 *            The inner {@link EmailCampaignSchedule#id} field must be set to null. Reason: WebService will set it.
	 * @return An {@link EmailCampaignSchedule} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public EmailCampaignSchedule addEmailCampaignSchedule(String campaignId, EmailCampaignSchedule emailCampaignSchedule) throws IllegalArgumentException,
			ConstantContactServiceException {

		if (campaignId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		if (emailCampaignSchedule == null) {
			throw new IllegalArgumentException(Config.Errors.EMAIL_CAMPAIGN_SCHEDULE_NULL);
		}
		return emailCampaignScheduleService.addSchedule(this.getAccessToken(), campaignId, emailCampaignSchedule);
	}

	/**
	 * 
	 * Update Email Campaign Schedule API.<br/>
	 * Details in : {@link EmailCampaignScheduleService#updateSchedule(String, String, String, EmailCampaignSchedule)}
	 * 
	 * @param emailCampaignId The campaign id (id field in {@link EmailCampaignBase})
	 * @param scheduleId The schedule id (id field in {@link EmailCampaignSchedule})
	 * @param emailCampaignSchedule The {@link EmailCampaignSchedule} instance to update. <br/>
	 *            The inner {@link EmailCampaignSchedule#id} field must be set to null.
	 * @return An instance of the updated {@link EmailCampaignSchedule} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public EmailCampaignSchedule updateEmailCampaignSchedule(String emailCampaignId, String scheduleId, EmailCampaignSchedule emailCampaignSchedule)
			throws IllegalArgumentException, ConstantContactServiceException {

		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		if (emailCampaignSchedule == null) {
			throw new IllegalArgumentException(Config.Errors.EMAIL_CAMPAIGN_SCHEDULE_NULL);
		}
		return emailCampaignScheduleService.updateSchedule(this.getAccessToken(), emailCampaignId, scheduleId, emailCampaignSchedule);
	}

	/**
	 * 
	 * Get Email Campaign Tracking Summary API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getSummary(String, String, String)}
	 * 
	 * @param emailCampaignId id field in Email Campaign
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the summary since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return An {@link EmailCampaignTrackingSummary} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public EmailCampaignTrackingSummary getEmailCampaignTrackingSummary(String emailCampaignId, String createdSinceTimestamp) throws IllegalArgumentException,
			ConstantContactServiceException {

		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return emailCampaignTrackingService.getSummary(this.getAccessToken(), emailCampaignId, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Email Campaign Tracking Bounces API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getBounces(String, String, Integer)}
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingBounce} in case of success; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 */
	public ResultSet<EmailCampaignTrackingBounce> getEmailCampaignTrackingBounces(String emailCampaignId) throws ConstantContactServiceException,
			IllegalArgumentException {

		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return getEmailCampaignTrackingBounces(emailCampaignId, null);
	}

	/**
	 * 
	 * Get Email Campaign Tracking Bounces API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getBounces(String, String, Integer)}
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingBounce} in case of success; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 */
	public ResultSet<EmailCampaignTrackingBounce> getEmailCampaignTrackingBounces(String emailCampaignId, Integer limit)
			throws ConstantContactServiceException, IllegalArgumentException {

		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return emailCampaignTrackingService.getBounces(this.getAccessToken(), emailCampaignId, limit);
	}

	/**
	 * 
	 * Get Email Campaign Tracking Clicks API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getClicks(String, String, Integer, String)}
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the clicks performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingClick} in case of success; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 */
	public ResultSet<EmailCampaignTrackingClick> getEmailCampaignTrackingClicks(String emailCampaignId, String createdSinceTimestamp) throws ConstantContactServiceException,
			IllegalArgumentException {
		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return getEmailCampaignTrackingClicks(emailCampaignId, null, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Email Campaign Tracking Clicks API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getClicks(String, String, Integer, String)}
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the clicks performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingClick} in case of success; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 */
	public ResultSet<EmailCampaignTrackingClick> getEmailCampaignTrackingClicks(String emailCampaignId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException,
			IllegalArgumentException {

		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return emailCampaignTrackingService.getClicks(this.getAccessToken(), emailCampaignId, limit, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Email Campaign Tracking Forwards API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getForwards(String, String, Integer, String)}
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the forwards performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingForward} in case of success; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 */
	public ResultSet<EmailCampaignTrackingForward> getEmailCampaignTrackingForwards(String emailCampaignId, String createdSinceTimestamp) throws ConstantContactServiceException,
			IllegalArgumentException {
		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return getEmailCampaignTrackingForwards(emailCampaignId, null, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Email Campaign Tracking Forwards API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getForwards(String, String, Integer, String)}
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the forwards performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingForward} in case of success; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 */
	public ResultSet<EmailCampaignTrackingForward> getEmailCampaignTrackingForwards(String emailCampaignId, Integer limit, String createdSinceTimestamp)
			throws ConstantContactServiceException, IllegalArgumentException {

		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return emailCampaignTrackingService.getForwards(this.getAccessToken(), emailCampaignId, limit, createdSinceTimestamp);
	}

	/**
	 * Get Email Campaign Tracking Opens API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getOpens(String, String, Integer, String)}
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the opens performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingOpen} in case of success; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 */
	public ResultSet<EmailCampaignTrackingOpen> getEmailCampaignTrackingOpens(String emailCampaignId, String createdSinceTimestamp) throws ConstantContactServiceException,
			IllegalArgumentException {
		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return getEmailCampaignTrackingOpens(emailCampaignId, null, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Email Campaign Tracking Opens API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getOpens(String, String, Integer, String)}
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the opens performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingOpen} in case of success; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 */
	public ResultSet<EmailCampaignTrackingOpen> getEmailCampaignTrackingOpens(String emailCampaignId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException,
			IllegalArgumentException {

		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return emailCampaignTrackingService.getOpens(this.getAccessToken(), emailCampaignId, limit, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Email Campaign Tracking Sends API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getSends(String, String, Integer, String)}
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the sends performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingSend} in case of success; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 */
	public ResultSet<EmailCampaignTrackingSend> getEmailCampaignTrackingSends(String emailCampaignId, String createdSinceTimestamp) throws ConstantContactServiceException,
			IllegalArgumentException {
		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return getEmailCampaignTrackingSends(emailCampaignId, null, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Email Campaign Tracking Sends API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getSends(String, String, Integer, String)}
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the sends performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingSend} in case of success; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 */
	public ResultSet<EmailCampaignTrackingSend> getEmailCampaignTrackingSends(String emailCampaignId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException,
			IllegalArgumentException {

		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return emailCampaignTrackingService.getSends(this.getAccessToken(), emailCampaignId, limit, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Email Campaign Tracking Unsubscribes API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getUnsubscribes(String, String, Integer, String)}
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the unsubcribes performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingUnsubscribe} in case of success; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 */
	public ResultSet<EmailCampaignTrackingUnsubscribe> getEmailCampaignTrackingUnsubscribes(String emailCampaignId, String createdSinceTimestamp) throws ConstantContactServiceException,
			IllegalArgumentException {
		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return getEmailCampaignTrackingUnsubscribes(emailCampaignId, null, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Email Campaign Tracking Unsubscribes API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getUnsubscribes(String, String, Integer, String)}
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the unsubscribes performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingUnsubscribe} in case of success; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 */
	public ResultSet<EmailCampaignTrackingUnsubscribe> getEmailCampaignTrackingUnsubscribes(String emailCampaignId, Integer limit, String createdSinceTimestamp)
			throws ConstantContactServiceException, IllegalArgumentException {

		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return emailCampaignTrackingService.getUnsubscribes(this.getAccessToken(), emailCampaignId, limit, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Email Campaign Tracking Clicks By Link API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getClicksByLinkId(String, String, String, Integer, String)}
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @param linkId The link id
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the clicks performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingClick} in case of success; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 */
	public ResultSet<EmailCampaignTrackingClick> getEmailCampaignTrackingClicksByLink(String emailCampaignId, String linkId, String createdSinceTimestamp)
			throws ConstantContactServiceException, IllegalArgumentException {
		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return emailCampaignTrackingService.getClicksByLinkId(this.getAccessToken(), emailCampaignId, linkId, null, createdSinceTimestamp);
	}

	/**
	 * Get Email Campaign Tracking Clicks By Link API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getClicksByLinkId(String, String, String, Integer, String)}
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @param linkId The link id
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the clicks performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingClick} in case of success; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 */
	public ResultSet<EmailCampaignTrackingClick> getEmailCampaignTrackingClicksByLink(String emailCampaignId, String linkId, Integer limit, String createdSinceTimestamp)
			throws ConstantContactServiceException, IllegalArgumentException {

		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return emailCampaignTrackingService.getClicksByLinkId(this.getAccessToken(), emailCampaignId, linkId, limit, createdSinceTimestamp);
	}

	/**
	 * Get Contact Tracking Summary API.<br/>
	 * Details in : {@link ContactTrackingService#getSummary(String, String, String)}
	 * 
	 * @param contactId The contact id.
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the summary since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ContactTrackingSummaryReport} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ContactTrackingSummaryReport getContactTrackingSummary(String contactId, String createdSinceTimestamp) throws IllegalArgumentException, ConstantContactServiceException {

		if (contactId == null || !(contactId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return contactTrackingService.getSummary(this.getAccessToken(), contactId, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Contact Tracking Bounces API.<br/>
	 * Details in : {@link ContactTrackingService#getBounces(String, String, Integer)}
	 * 
	 * @param contactId The contact id.
	 * @return A {@link ResultSet} of {@link ContactTrackingBounce} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<ContactTrackingBounce> getContactTrackingBounces(String contactId) throws IllegalArgumentException, ConstantContactServiceException {
		if (contactId == null || !(contactId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return contactTrackingService.getBounces(this.getAccessToken(), contactId, null);
	}

	/**
	 * 
	 * Get Contact Tracking Bounces API.<br/>
	 * Details in : {@link ContactTrackingService#getBounces(String, String, Integer)}
	 * 
	 * @param contactId The contact id.
	 * @param limit The limit
	 * @return A {@link ResultSet} of {@link ContactTrackingBounce} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<ContactTrackingBounce> getContactTrackingBounces(String contactId, Integer limit) throws IllegalArgumentException,
			ConstantContactServiceException {
		if (contactId == null || !(contactId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return contactTrackingService.getBounces(this.getAccessToken(), contactId, limit);
	}
	
	//TODO change doc
	public ResultSet<ContactTrackingBounce> getContactTrackingBounces(Pagination pagination) throws IllegalArgumentException, ConstantContactServiceException {
		if(pagination == null) {
			throw new IllegalArgumentException(Config.Errors.PAGINATION_NULL);			
		}
		return contactTrackingService.getBouncesByPage(this.getAccessToken(), pagination);
	}

	/**
	 * 
	 * Get Contact Tracking Clicks API.<br/>
	 * Details in : {@link ContactTrackingService#getClicks(String, String, Integer, String)}
	 * 
	 * @param contactId The contact id.
	 * @return A {@link ResultSet} of {@link ContactTrackingClick} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<ContactTrackingClick> getContactTrackingClicks(String contactId, String createdSinceTimestamp) throws IllegalArgumentException, ConstantContactServiceException {
		if (contactId == null || !(contactId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return getContactTrackingClicks(contactId, null, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Contact Tracking Clicks API.<br/>
	 * Details in : {@link ContactTrackingService#getClicks(String, String, Integer, String)}
	 * 
	 * @param contactId The contact id.
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the clicks performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link ContactTrackingClick} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<ContactTrackingClick> getContactTrackingClicks(String contactId, Integer limit, String createdSinceTimestamp) throws IllegalArgumentException,
			ConstantContactServiceException {
		if (contactId == null || !(contactId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return contactTrackingService.getClicks(this.getAccessToken(), contactId, limit, createdSinceTimestamp);
	}
	
	//TODO change doc
	public ResultSet<ContactTrackingClick> getContactTrackingClicks(Pagination pagination, String createdSinceTimestamp) throws IllegalArgumentException, ConstantContactServiceException {
		if(pagination == null) {
			throw new IllegalArgumentException(Config.Errors.PAGINATION_NULL);			
		}
		return contactTrackingService.getClicksByPage(this.getAccessToken(), pagination, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Contact Tracking Forwards API.<br/>
	 * Details in : {@link ContactTrackingService#getForwards(String, String, Integer, String)}
	 * 
	 * @param contactId The contact id.
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the forwards performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link ContactTrackingForward} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<ContactTrackingForward> getContactTrackingForwards(String contactId, String createdSinceTimestamp) throws IllegalArgumentException, ConstantContactServiceException {
		if (contactId == null || !(contactId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return contactTrackingService.getForwards(this.getAccessToken(), contactId, null, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Contact Tracking Forwards API.<br/>
	 * Details in : {@link ContactTrackingService#getForwards(String, String, Integer, String)}
	 * 
	 * @param contactId The contact id.
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the forwards performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link ContactTrackingForward} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<ContactTrackingForward> getContactTrackingForwards(String contactId, Integer limit, String createdSinceTimestamp) throws IllegalArgumentException,
			ConstantContactServiceException {
		if (contactId == null || !(contactId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return contactTrackingService.getForwards(this.getAccessToken(), contactId, limit, createdSinceTimestamp);
	}
	
	//TODO change docs
	public ResultSet<ContactTrackingForward> getContactTrackingForwards(Pagination pagination, String createdSinceTimestamp) throws IllegalArgumentException, ConstantContactServiceException {
		if (pagination == null) {
			throw new IllegalArgumentException(Config.Errors.PAGINATION_NULL);
		}
		return contactTrackingService.getForwardsByPage(this.getAccessToken(), pagination, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Contact Tracking Opens API.<br/>
	 * Details in : {@link ContactTrackingService#getOpens(String, String, Integer, String)}
	 * 
	 * @param contactId The contact id.
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the opens performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link ContactTrackingOpen} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<ContactTrackingOpen> getContactTrackingOpens(String contactId, String createdSinceTimestamp) throws IllegalArgumentException, ConstantContactServiceException {
		if (contactId == null || !(contactId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return contactTrackingService.getOpens(this.getAccessToken(), contactId, null, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Contact Tracking Opens API.<br/>
	 * Details in : {@link ContactTrackingService#getOpens(String, String, Integer, String)}
	 * 
	 * @param contactId The contact id.
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the opens performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link ContactTrackingOpen} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<ContactTrackingOpen> getContactTrackingOpens(String contactId, Integer limit, String createdSinceTimestamp) throws IllegalArgumentException,
			ConstantContactServiceException {
		if (contactId == null || !(contactId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return contactTrackingService.getOpens(this.getAccessToken(), contactId, limit, createdSinceTimestamp);
	}
	//TODO change docs
	public ResultSet<ContactTrackingOpen> getContactTrackingOpens(Pagination pagination, String createdSinceTimestamp) throws IllegalArgumentException, ConstantContactServiceException {
		if(pagination == null) {
			throw new IllegalArgumentException(Config.Errors.PAGINATION_NULL);
		}
		return contactTrackingService.getOpensByPage(this.getAccessToken(), pagination, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Contact Tracking Sends API.<br/>
	 * Details in : {@link ContactTrackingService#getSends(String, String, Integer, String)}
	 * 
	 * @param contactId The contact id.
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the sends performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link ContactTrackingSend} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<ContactTrackingSend> getContactTrackingSends(String contactId, String createdSinceTimestamp) throws IllegalArgumentException, ConstantContactServiceException {
		if (contactId == null || !(contactId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return contactTrackingService.getSends(this.getAccessToken(), contactId, null, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Contact Tracking Sends API.<br/>
	 * Details in : {@link ContactTrackingService#getSends(String, String, Integer, String)}
	 * 
	 * @param contactId The contact id.
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the sends performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link ContactTrackingSend} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<ContactTrackingSend> getContactTrackingSends(String contactId, Integer limit, String createdSinceTimestamp) throws IllegalArgumentException,
			ConstantContactServiceException {
		if (contactId == null || !(contactId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return contactTrackingService.getSends(this.getAccessToken(), contactId, limit, createdSinceTimestamp);
	}
	
	//TODO change docs
	public ResultSet<ContactTrackingSend> getContactTrackingSends(Pagination pagination, String createdSinceTimestamp) throws IllegalArgumentException, ConstantContactServiceException {
		if(pagination == null) {
			throw new IllegalArgumentException(Config.Errors.PAGINATION_NULL);
		}
		return contactTrackingService.getSendsByPage(this.getAccessToken(), pagination, createdSinceTimestamp);
	}
	/**
	 * 
	 * Get Contact Tracking Unsubscribes API.<br/>
	 * Details in : {@link ContactTrackingService#getUnsubscribes(String, String, Integer, String)}
	 * 
	 * @param contactId The contact id.
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the unsubscribes performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link ContactTrackingUnsubscribe} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<ContactTrackingUnsubscribe> getContactTrackingUnsubscribes(String contactId, String createdSinceTimestamp) throws IllegalArgumentException,
			ConstantContactServiceException {
		if (contactId == null || !(contactId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return contactTrackingService.getUnsubscribes(this.getAccessToken(), contactId, null, createdSinceTimestamp);
	}

	/**
	 * 
	 * Get Contact Tracking Unsubscribes API.<br/>
	 * Details in : {@link ContactTrackingService#getUnsubscribes(String, String, Integer, String)}
	 * 
	 * @param contactId The contact id.
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the unsubscribes performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link ContactTrackingUnsubscribe} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ResultSet<ContactTrackingUnsubscribe> getContactTrackingUnsubscribes(String contactId, Integer limit, String createdSinceTimestamp) throws IllegalArgumentException,
			ConstantContactServiceException {
		if (contactId == null || !(contactId.length() > 0)) {
			throw new IllegalArgumentException(Config.Errors.ID);
		}
		return contactTrackingService.getUnsubscribes(this.getAccessToken(), contactId, limit, createdSinceTimestamp);
	}
	
	//TODO change docs
	public ResultSet<ContactTrackingUnsubscribe> getContactTrackingUnsubscribes(Pagination pagination, String createdSinceTimestamp) throws IllegalArgumentException,
		ConstantContactServiceException {
		if(pagination == null) {
			throw new IllegalArgumentException(Config.Errors.PAGINATION_NULL);
		}
		return contactTrackingService.getUnsubscribesByPage(this.getAccessToken(), pagination, createdSinceTimestamp);
	}
	
	/**
	 * 
	 * Add Bulk Contacts API.<br/>
	 * Details in : {@link BulkActivitiesService#addContacts(String, AddContactsRequest)}
	 * 
	 * @param request The {@link AddContactsRequest}
	 * @return A {@link ContactsResponse} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ContactsResponse addBulkContacts(AddContactsRequest request) throws IllegalArgumentException, ConstantContactServiceException {
		if (request == null) {
			throw new IllegalArgumentException(Config.Errors.BULK_CONTACTS_REQUEST_NULL);
		}
		return bulkActivitiesService.addContacts(this.getAccessToken(), request);
	}

	/**
	 * 
	 * Remove Bulk Contacts From Lists API.<br/>
	 * Details in : {@link BulkActivitiesService#removeContactsFromLists(String, RemoveContactsRequest)}
	 * 
	 * @param request A {@link RemoveContactsRequest}
	 * @return A {@link ContactsResponse} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ContactsResponse removeBulkContactsFromLists(RemoveContactsRequest request) throws IllegalArgumentException, ConstantContactServiceException {
		if (request == null) {
			throw new IllegalArgumentException(Config.Errors.BULK_CONTACTS_REQUEST_NULL);
		}
		return bulkActivitiesService.removeContactsFromLists(this.getAccessToken(), request);
	}

	/**
	 * 
	 * Clear Bulk Contacts Lists API.<br/>
	 * Details in : {@link BulkActivitiesService#clearLists(String, ClearListsRequest)}
	 * 
	 * @param request A {@link ClearListsRequest}
	 * @return A {@link ContactsResponse} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ContactsResponse clearBulkContactsLists(ClearListsRequest request) throws IllegalArgumentException, ConstantContactServiceException {
		if (request == null) {
			throw new IllegalArgumentException(Config.Errors.BULK_CONTACTS_REQUEST_NULL);
		}
		return bulkActivitiesService.clearLists(this.getAccessToken(), request);
	}

	/**
	 * 
	 * Export Bulk Contacts API.<br/>
	 * Details in : {@link BulkActivitiesService#exportContacts(String, ExportContactsRequest)}
	 * 
	 * @param request A {@link ExportContactsRequest}
	 * @return A {@link ContactsResponse} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public ContactsResponse exportBulkContacts(ExportContactsRequest request) throws IllegalArgumentException, ConstantContactServiceException {
		if (request == null) {
			throw new IllegalArgumentException(Config.Errors.BULK_CONTACTS_REQUEST_NULL);
		}
		return bulkActivitiesService.exportContacts(this.getAccessToken(), request);
	}

	/**
	 * 
	 * Get Bulk Summary Report API.<br/>
	 * Details in : {@link BulkActivitiesService#getSummaryReport(String)}
	 * 
	 * @return A {@link List} of {@link SummaryReport} in case of success; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public List<SummaryReport> getBulkSummaryReport() throws ConstantContactServiceException {

		return bulkActivitiesService.getSummaryReport(this.getAccessToken());
	}

	/**
	 * 
	 * Get Bulk Detailed Status Report API.<br/>
	 * Details in : {@link BulkActivitiesService#getDetailedStatusReport(String, String, String, String)}
	 * 
	 * @param status The status
	 * @param type The type
	 * @param id The id
	 * @return A {@link List} of {@link DetailedStatusReport} in case of success; an exception is thrown otherwise.
	 * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
	 *             The exception also contains a description of the cause.<br/>
	 *             Error message is taken from one of the members of {@link Errors}
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public List<DetailedStatusReport> getBulkDetailedStatusReport(String status, String type, String id) throws IllegalArgumentException,
			ConstantContactServiceException {
		return bulkActivitiesService.getDetailedStatusReport(this.getAccessToken(), status, type, id);
	}
}
