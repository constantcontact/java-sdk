package com.constantcontact;

import com.constantcontact.components.accounts.AccountInfo;
import com.constantcontact.components.accounts.VerifiedEmailAddress;
import com.constantcontact.components.activities.contacts.request.AddContactsRequest;
import com.constantcontact.components.activities.contacts.request.ClearListsRequest;
import com.constantcontact.components.activities.contacts.request.ExportContactsRequest;
import com.constantcontact.components.activities.contacts.request.RemoveContactsRequest;
import com.constantcontact.components.activities.contacts.response.ContactsResponse;
import com.constantcontact.components.activities.contacts.response.DetailedStatusReport;
import com.constantcontact.components.activities.contacts.response.SummaryReport;
import com.constantcontact.components.common.tracking.TrackingBase;
import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.contacts.ContactList;
import com.constantcontact.components.contacts.tracking.TrackingContactsBase;
import com.constantcontact.components.contacts.tracking.bounces.ContactTrackingBounce;
import com.constantcontact.components.contacts.tracking.clicks.ContactTrackingClick;
import com.constantcontact.components.contacts.tracking.forwards.ContactTrackingForward;
import com.constantcontact.components.contacts.tracking.opens.ContactTrackingOpen;
import com.constantcontact.components.contacts.tracking.reports.summary.ContactTrackingSummaryByCampaignReport;
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
import com.constantcontact.components.eventspot.*;
import com.constantcontact.components.eventspot.Registrant.Registrant;
import com.constantcontact.components.eventspot.Registrant.RegistrantDetails;
import com.constantcontact.components.generic.response.Pagination;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.components.library.file.FileType;
import com.constantcontact.components.library.file.ImageSource;
import com.constantcontact.components.library.file.MyLibraryFile;
import com.constantcontact.components.library.folder.MyLibraryFolder;
import com.constantcontact.components.library.folder.MyLibraryFolder.FolderSortOptions;
import com.constantcontact.components.library.info.MoveResults;
import com.constantcontact.components.library.info.MyLibrarySummary;
import com.constantcontact.components.library.info.UploadStatus;
import com.constantcontact.exceptions.ConstantContactException;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.pagination.PaginationHelperService;
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
import com.constantcontact.services.eventspot.EventSpotService;
import com.constantcontact.services.eventspot.IEventSpotService;
import com.constantcontact.services.library.IMyLibraryService;
import com.constantcontact.services.library.MyLibraryService;
import com.constantcontact.util.Config;
import com.constantcontact.util.http.MultipartBody;
import com.constantcontact.util.http.MultipartBuilder;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private IMyLibraryService myLibraryService;
    private IEventSpotService eventSpotService;
	private PaginationHelperService paginationHelperService;

	/**
	 * Custom Class constructor.<br/>
	 * Initializes all Services;
	 *
	 * @param apiKey The API key provided by Constant Contact.
	 * @param accessToken The access token provided by Constant Contact Authentication workflow.
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
		this.setMyLibraryService(new MyLibraryService());
        this.setEventSpotService(new EventSpotService());
		this.setPaginationHelperService(new PaginationHelperService());
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
     * Set the {@link MyLibraryService}
     *
     * @param myLibraryService The {@link MyLibraryService}
     */
    public void setMyLibraryService(IMyLibraryService myLibraryService) {
        this.myLibraryService = myLibraryService;
    }

    /**
     * Get the {@link MyLibraryService}
     *
     * @return The {@link MyLibraryService}
     */
    public IMyLibraryService getMyLibraryService() {
        return myLibraryService;
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

    /**
     * Get the {@link EventSpotService}
     *
     * @return The {@link EventSpotService}
     */
    public IEventSpotService getEventSpotService() {
        return eventSpotService;
    }

    /**
     * Set the {@link EventSpotService}
     *
     * @param eventSpotService The {@link EventSpotService}
     */
    public void setEventSpotService(IEventSpotService eventSpotService) {
        this.eventSpotService = eventSpotService;
    }

    /**
	 * Get the {@link PaginationHelperService}
	 *
	 * @return The {@link PaginationHelperService}
	 */
	public PaginationHelperService getPaginationHelperService(){
		return paginationHelperService;
	}

	/**
	 * Set the {@link PaginationHelperService}
	 *
	 * @param paginationHelperService The {@link PaginationHelperService}
	 */
	public void setPaginationHelperService(PaginationHelperService paginationHelperService) {
		this.paginationHelperService = paginationHelperService;
	}

	// ****************************************************************************//
	// END OF GETTERS AND SETTERS ************************************************//
	// ****************************************************************************//

	/**
	 * Get contacts API. <br/>
	 * Details in : {@link ContactService#getContacts(String, Integer, String)}
	 *
	 * @param limit The maximum number of results to return - can be null.
	 * @param modifiedSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
	 * 		   It will return only the contacts modified since the supplied date. <br/>
	 * 		   If you want to bypass this filter set modifiedSinceTimestamp to null.
	 * @param status Return only records with the given status. Does not support VISITOR or NON_SUBSCRIBER
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
	public ResultSet<Contact> getContacts(Integer limit, String modifiedSinceTimestamp, Contact.Status status) throws ConstantContactServiceException {

	    if (status != null && (status.equals(Contact.Status.VISITOR) || status.equals(Contact.Status.NON_SUBSCRIBER))){
	        throw new IllegalArgumentException(Config.instance().getErrorStatus() + " ACTIVE, OPTOUT, REMOVED, UNCONFIRMED.");
	    }

		return contactService.getContacts(this.getAccessToken(), limit, modifiedSinceTimestamp, status);
	}

	/**
	 * Get contacts API.<br/>
	 * Details in : {@link PaginationHelperService#getPage(Pagination)}
	 *
	 * @param pagination {@link Pagination} object.
	 *
	 * @return The contacts.
	 *
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
	public ResultSet<Contact> getContacts(Pagination pagination) throws ConstantContactServiceException,
	IllegalArgumentException {
		if(pagination == null) {
			throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
		}
		return getPaginationHelperService().getPage(this.getAccessToken(), pagination, Contact.class);
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
                String encodedEmail = null;
                try
                {
                        encodedEmail = URLEncoder.encode(email, "UTF-8");
                }
                catch(UnsupportedEncodingException ex)
                {
                        throw new IllegalStateException(ex);
                }
                return contactService.getContactByEmail(this.getAccessToken(), encodedEmail);
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
			throw new IllegalArgumentException(Config.instance().getErrorContactOrId());
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
			throw new IllegalArgumentException(Config.instance().getErrorContactOrId());
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
			throw new IllegalArgumentException(Config.instance().getErrorContactOrId());
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
			throw new IllegalArgumentException(Config.instance().getErrorContactOrId());
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
			throw new IllegalArgumentException(Config.instance().getErrorContactOrId());
		}
		if (list == null) {
			throw new IllegalArgumentException(Config.instance().getErrorListOrId());
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
			throw new IllegalArgumentException(Config.instance().getErrorContactOrId());
		}
		if (contact.getId() == null || !(contact.getId().length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
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
			throw new IllegalArgumentException(Config.instance().getErrorContactOrId());
		}
		if (contact.getId() == null || !(contact.getId().length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
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
			throw new IllegalArgumentException(Config.instance().getErrorListOrId());
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
	
	/**
    *
    * Update Contact List API.<br/>
    * Details in : {@link ContactListService#updateList(String, ContactList)}
    *
    * @param contact The {@link ContactList} to update.
    * @return The updated {@link ContactList} in case of success; an exception is thrown otherwise.
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

   public ContactList updateList(ContactList list) throws IllegalArgumentException, ConstantContactServiceException {
       if (list == null) {
           throw new IllegalArgumentException(Config.instance().getErrorListOrId());
       }
       if (list.getId() == null || !(list.getId().length() > 0)) {
           throw new IllegalArgumentException(Config.instance().getErrorId());
       }
       return contactListService.updateList(this.getAccessToken(), list);
   }
   
	/**
	 *
	 * Get Contacts From List API.<br/>
	 * Details in : {@link ContactListService#getContactsFromList(String, Integer, String)}
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
			throw new IllegalArgumentException(Config.instance().getErrorListOrId());
		}
		return contactListService.getContactsFromList(this.getAccessToken(), list.getId(), null, null);
	}

	/**
	 *
	 * Get Contacts From List API.<br/>
	 * Details in : {@link ContactListService#getContactsFromList(String, Integer, String)}
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
			throw new IllegalArgumentException(Config.instance().getErrorListOrId());
		}

		try {
			return contactListService.getContactsFromList(this.getAccessToken(), listId, null, null);
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		}
	}

	/**
	 *
	 * Get Contacts From List API.<br/>
	 * Details in : {@link ContactListService#getContactsFromList(String, Integer, String)}
	 *
	 * @param list The {@link ContactList} object.
	 * @param limit Maximum number of {@link Contact} objects returned. Default is 50. <br/>
	 * 				To bypass this filter set limit to null.
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
			throw new IllegalArgumentException(Config.instance().getErrorListOrId());
		}
		return contactListService.getContactsFromList(this.getAccessToken(), list.getId(), limit, modifiedSinceTimestamp);
	}

	/**
	 *
	 * Get Contacts From List API.<br/>
	 * Details in : {@link PaginationHelperService#getPage(Pagination)}
	 *
	 * @param pagination
	 *          {@link Pagination} for fetching next set of contacts.
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
	public ResultSet<Contact> getContactsFromList(Pagination pagination)
			throws IllegalArgumentException, ConstantContactServiceException {
		if (pagination == null) {
			throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
		}
		return getPaginationHelperService().getPage(this.getAccessToken(), pagination, Contact.class);
	}

	/**
	 *
	 * Get Email Campaigns API.<br/>
	 * Details in : {@link EmailCampaignService#getCampaigns(String, Integer, String)}
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

	/**
	 *
	 * Get Email Campaigns API.<br/>
	 * Details in : {@link PaginationHelperService#getPage(Pagination)}
	 *
	 * @param pagination
	 *          {@link Pagination} for fetching next set of campaigns.
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
	public ResultSet<EmailCampaignResponse> getEmailCampaigns(Pagination pagination) throws IllegalArgumentException,
			ConstantContactServiceException, IllegalArgumentException {
		if(pagination == null) {
			throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
		}
		return getPaginationHelperService().getPage(this.getAccessToken(), pagination, EmailCampaignResponse.class);
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		return emailCampaignService.addCampaign(this.getAccessToken(), emailCampaign);
	}
	
    /**
    *
    * Delete Email Campaign API.<br/>
    * Details in : {@link EmailCampaignService#deleteCampaign(String)}
    *
    * @param emailCampaignId The Email Campaign to delete
    * @return True in case of success; an exception is thrown otherwise.
    * @throws ConstantContactServiceException Thrown when :
    *             <ul>
    *             <li>something went wrong either on the client side;</li>
    *             <li>or an error message was received from the server side.</li>
    *             </ul>
    * <br/>
    *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
    *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
    */
	public boolean deleteEmailCampaign(String emailCampaignId) throws ConstantContactServiceException {
	    return emailCampaignService.deleteCampaign(this.getAccessToken(), emailCampaignId);
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
				throw new IllegalArgumentException(Config.instance().getErrorStatus() + VerifiedEmailAddress.Status.CONFIRMED + ", " + VerifiedEmailAddress.Status.CONFIRMED);
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		if (scheduleId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		if (scheduleId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		if (emailCampaignSchedule == null) {
			throw new IllegalArgumentException(Config.instance().getErrorEmailCampaignScheduleNull());
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		if (emailCampaignSchedule == null) {
			throw new IllegalArgumentException(Config.instance().getErrorEmailCampaignScheduleNull());
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		return emailCampaignTrackingService.getSummary(this.getAccessToken(), emailCampaignId, createdSinceTimestamp);
	}

	/**
	 *
	 * Get Email Campaign Tracking Bounces API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getBounces(String, String, Integer)}
	 *
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit - Null to use the default.
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		return emailCampaignTrackingService.getBounces(this.getAccessToken(), emailCampaignId, limit);
	}

	/**
	 *
	 * Get Email Campaign Tracking Bounces API.<br/>
	 * Details in : {@link PaginationHelperService#getPage(Pagination)}
	 *
	 * @param pagination
	 *          {@link Pagination} for fetching next set of data.
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
	public ResultSet<EmailCampaignTrackingBounce> getEmailCampaignTrackingBounces(Pagination pagination) throws ConstantContactServiceException,
	IllegalArgumentException {
		if (pagination == null) {
			throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
		}
		return getPaginationHelperService().getPage(this.getAccessToken(), pagination, EmailCampaignTrackingBounce.class);
	}

	/**
	 *
	 * Get Email Campaign Tracking Clicks API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getClicks(String, Integer, String)}
	 *
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit - Null to use the default.
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		return emailCampaignTrackingService.getClicks(this.getAccessToken(), emailCampaignId, limit, createdSinceTimestamp);
	}

	/**
	 *
	 * Get Email Campaign Tracking Clicks API.<br/>
	 * Details in : {@link PaginationHelperService#getPage(Pagination)}
	 *
	 * @param pagination
	 *          {@link Pagination} for fetching next set of data.
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
	public ResultSet<EmailCampaignTrackingClick> getEmailCampaignTrackingClicks(Pagination pagination) throws ConstantContactServiceException,
	IllegalArgumentException {

		if (pagination == null) {
			throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
		}
		return getPaginationHelperService().getPage(this.getAccessToken(), pagination, EmailCampaignTrackingClick.class);
	}

	/**
	 *
	 * Get Email Campaign Tracking Forwards API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getForwards(String, Integer, String)}
	 *
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit - Null to use the default.
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		return emailCampaignTrackingService.getForwards(this.getAccessToken(), emailCampaignId, limit, createdSinceTimestamp);
	}

	/**
	 *
	 * Get Email Campaign Tracking Forwards API.<br/>
	 * Details in : {@link PaginationHelperService#getPage(Pagination)}
	 *
	 * @param pagination
	 *          {@link Pagination} for fetching next set of data.
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
	public ResultSet<EmailCampaignTrackingForward> getEmailCampaignTrackingForwards(Pagination pagination)
			throws ConstantContactServiceException, IllegalArgumentException {

		if (pagination == null) {
			throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
		}
		return getPaginationHelperService().getPage(this.getAccessToken(), pagination, EmailCampaignTrackingForward.class);
	}

	/**
	 *
	 * Get Email Campaign Tracking Opens API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getOpens(String, Integer, String)}
	 *
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit - Null to use the default.
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		return emailCampaignTrackingService.getOpens(this.getAccessToken(), emailCampaignId, limit, createdSinceTimestamp);
	}

	/**
	 *
	 * Get Email Campaign Tracking Opens API.<br/>
	 * Details in : {@link PaginationHelperService#getPage(Pagination)}
	 *
	 * @param pagination
	 *          {@link Pagination} for fetching next set of data.
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
	public ResultSet<EmailCampaignTrackingOpen> getEmailCampaignTrackingOpens(Pagination pagination) throws ConstantContactServiceException,
	IllegalArgumentException {

		if (pagination == null) {
			throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
		}
		return getPaginationHelperService().getPage(this.getAccessToken(), pagination, EmailCampaignTrackingOpen.class);
	}

	/**
	 *
	 * Get Email Campaign Tracking Sends API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getSends(String, Integer, String)}
	 *
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit - Null to use the default.
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		return emailCampaignTrackingService.getSends(this.getAccessToken(), emailCampaignId, limit,
                createdSinceTimestamp);
	}

	/**
	 *
	 * Get Email Campaign Tracking Sends API.<br/>
	 * Details in : {@link PaginationHelperService#getPage(Pagination)}
	 *
	 * @param pagination
	 *          {@link Pagination} for fetching next set of data.
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
	public ResultSet<EmailCampaignTrackingSend> getEmailCampaignTrackingSends(Pagination pagination) throws ConstantContactServiceException,
	IllegalArgumentException {

		if (pagination == null) {
			throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
		}
		return getPaginationHelperService().getPage(this.getAccessToken(), pagination, EmailCampaignTrackingSend.class);
	}

	/**
	 *
	 * Get Email Campaign Tracking Unsubscribes API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getUnsubscribes(String, Integer, String)}
	 *
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit - Null to use the default.
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		return emailCampaignTrackingService.getUnsubscribes(this.getAccessToken(), emailCampaignId, limit, createdSinceTimestamp);
	}

	/**
	 *
	 * Get Email Campaign Tracking Unsubscribes API.<br/>
	 * Details in : {@link PaginationHelperService#getPage(Pagination)}
	 *
	 * @param pagination
	 *          {@link Pagination} for fetching next set of data.
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
	public ResultSet<EmailCampaignTrackingUnsubscribe> getEmailCampaignTrackingUnsubscribes(Pagination pagination)
			throws ConstantContactServiceException, IllegalArgumentException {

		if (pagination == null) {
			throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
		}
		return getPaginationHelperService().getPage(this.getAccessToken(), pagination, EmailCampaignTrackingUnsubscribe.class);
	}

	/**
	 * Get Email Campaign Tracking Clicks By Link API.<br/>
	 * Details in : {@link EmailCampaignTrackingService#getClicksByLinkId(String, String, Integer, String)}
	 *
	 * @param emailCampaignId The id field in Email Campaign
	 * @param linkId The link id
	 * @param limit The limit - Null to use the default.
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		return emailCampaignTrackingService.getClicksByLinkId(this.getAccessToken(), emailCampaignId, linkId, limit, createdSinceTimestamp);
	}

	/**
	 * Get Email Campaign Tracking Clicks By Link API.<br/>
	 * Details in : {@link PaginationHelperService#getPage(Pagination)}
	 *
	 * @param pagination
	 *          {@link Pagination} for fetching next set of data.
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
	public ResultSet<EmailCampaignTrackingClick> getEmailCampaignTrackingClicksByLink(Pagination pagination)
			throws ConstantContactServiceException, IllegalArgumentException {

		if (pagination == null) {
			throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
		}
		return getPaginationHelperService().getPage(this.getAccessToken(), pagination, EmailCampaignTrackingClick.class);
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		return contactTrackingService.getSummary(this.getAccessToken(), contactId, createdSinceTimestamp);
	}

	/**
     * Get Contact Tracking Summary By Campaign API.<br/>
     * Details in : {@link ContactTrackingService#getSummaryByCampaign(String, String, Long)}
     *
     * @param contactId The contact id.
     * @return A {@link List} of {@link ContactTrackingSummaryByCampaignReport} in case of success; an exception is thrown otherwise.
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
    public List<ContactTrackingSummaryByCampaignReport> getContactTrackingSummaryByCampaign(String contactId) throws IllegalArgumentException, ConstantContactServiceException {

        if (contactId == null || !(contactId.length() > 0)) {
            throw new IllegalArgumentException(Config.instance().getErrorId());
        }
        return contactTrackingService.getSummaryByCampaign(this.getAccessToken(), contactId);
    }

	/**
     *
     * Get Contact Tracking Activities API.<br/>
     * Details in : {@link ContactTrackingService#getActivities(String, Integer, String)}
     *
     * @param contactId The contact id.
     * @param limit The limit - Null to use the default.
     * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
     *         It will return only the clicks performed since the supplied date. <br/>
     *         If you want to bypass this filter, set createdSinceTimestamp to null.
     * @return A {@link ResultSet} of {@link TrackingContactsBase} in case of success; an exception is thrown otherwise.
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
	public ResultSet<? extends TrackingContactsBase> getContactTrackingActivities(String contactId, Integer limit, String createdSinceTimestamp) throws IllegalArgumentException, ConstantContactServiceException {
	    if (contactId == null || !(contactId.length() > 0)) {
	        throw new IllegalArgumentException(Config.instance().getErrorId());
	    }
	    return contactTrackingService.getActivities(this.getAccessToken(), contactId, limit, createdSinceTimestamp);
	}

	/**
     *
     * Get Contact Tracking Activities API.<br/>
     * Details in : {@link PaginationHelperService#getPage(Pagination)}
     *
     * @param pagination
     *          {@link Pagination} for fetching next set of data.
     * @return A {@link ResultSet} of {@link TrackingBase} in case of success; an exception is thrown otherwise.
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
    public ResultSet<TrackingContactsBase> getContactTrackingActivities(Pagination pagination) throws IllegalArgumentException, ConstantContactServiceException {
        if(pagination == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
        }
        return getPaginationHelperService().getPage(this.getAccessToken(), pagination, TrackingContactsBase.class);
    }

    /**
	 *
	 * Get Contact Tracking Bounces API.<br/>
	 * Details in : {@link ContactTrackingService#getBounces(String, String, Integer)}
	 *
	 * @param contactId The contact id.
	 * @param limit The limit - Null to use the default.
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		return contactTrackingService.getBounces(this.getAccessToken(), contactId, limit);
	}

	/**
	 *
	 * Get Contact Tracking Bounces API.<br/>
	 * Details in : {@link PaginationHelperService#getPage(Pagination)}
	 *
	 * @param pagination
	 *          {@link Pagination} for fetching next set of data.
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
	public ResultSet<ContactTrackingBounce> getContactTrackingBounces(Pagination pagination) throws IllegalArgumentException, ConstantContactServiceException {
		if(pagination == null) {
			throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
		}
		return getPaginationHelperService().getPage(this.getAccessToken(), pagination, ContactTrackingBounce.class);
	}

	/**
	 *
	 * Get Contact Tracking Clicks API.<br/>
	 * Details in : {@link ContactTrackingService#getClicks(String, Integer, String)}
	 *
	 * @param contactId The contact id.
	 * @param limit The limit - Null to use the default.
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		return contactTrackingService.getClicks(this.getAccessToken(), contactId, limit, createdSinceTimestamp);
	}

	/**
	 *
	 * Get Contact Tracking Clicks API.<br/>
	 * Details in : {@link PaginationHelperService#getPage(Pagination)}
	 *
	 * @param pagination
	 *          {@link Pagination} for fetching next set of data.
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
	public ResultSet<ContactTrackingClick> getContactTrackingClicks(Pagination pagination) throws IllegalArgumentException, ConstantContactServiceException {
		if(pagination == null) {
			throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
		}
		return getPaginationHelperService().getPage(this.getAccessToken(), pagination, ContactTrackingClick.class);
	}

	/**
	 *
	 * Get Contact Tracking Forwards API.<br/>
	 * Details in : {@link ContactTrackingService#getForwards(String, Integer, String)}
	 *
	 * @param contactId The contact id.
	 * @param limit The limit - Null to use the default.
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		return contactTrackingService.getForwards(this.getAccessToken(), contactId, limit, createdSinceTimestamp);
	}

	/**
	 *
	 * Get Contact Tracking Forwards API.<br/>
	 * Details in : {@link PaginationHelperService#getPage(Pagination)}
	 *
	 * @param pagination
	 *          {@link Pagination} for fetching next set of data.
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
	public ResultSet<ContactTrackingForward> getContactTrackingForwards(Pagination pagination) throws IllegalArgumentException, ConstantContactServiceException {
		if (pagination == null) {
			throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
		}
		return getPaginationHelperService().getPage(this.getAccessToken(), pagination, ContactTrackingForward.class);
	}

	/**
	 *
	 * Get Contact Tracking Opens API.<br/>
	 * Details in : {@link ContactTrackingService#getOpens(String, Integer, String)}
	 *
	 * @param contactId The contact id.
	 * @param limit The limit - Null to use the default.
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		return contactTrackingService.getOpens(this.getAccessToken(), contactId, limit, createdSinceTimestamp);
	}

	/**
	 *
	 * Get Contact Tracking Opens API.<br/>
	 * Details in : {@link PaginationHelperService#getPage(Pagination)}
	 *
	 * @param pagination
	 *          {@link Pagination} for fetching next set of data.
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
	public ResultSet<ContactTrackingOpen> getContactTrackingOpens(Pagination pagination) throws IllegalArgumentException, ConstantContactServiceException {
		if(pagination == null) {
			throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
		}
		return getPaginationHelperService().getPage(this.getAccessToken(), pagination, ContactTrackingOpen.class);
	}

	/**
	 *
	 * Get Contact Tracking Sends API.<br/>
	 * Details in : {@link ContactTrackingService#getSends(String, Integer, String)}
	 *
	 * @param contactId The contact id.
	 * @param limit The limit - Null to use the default.
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		return contactTrackingService.getSends(this.getAccessToken(), contactId, limit, createdSinceTimestamp);
	}

	/**
	 *
	 * Get Contact Tracking Sends API.<br/>
	 * Details in : {@link PaginationHelperService#getPage(Pagination)}
	 *
	 * @param pagination
	 *          {@link Pagination} for fetching next set of data.
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
	public ResultSet<ContactTrackingSend> getContactTrackingSends(Pagination pagination) throws IllegalArgumentException, ConstantContactServiceException {
		if(pagination == null) {
			throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
		}
		return getPaginationHelperService().getPage(this.getAccessToken(), pagination, ContactTrackingSend.class);
	}

	/**
	 *
	 * Get Contact Tracking Unsubscribes API.<br/>
	 * Details in : {@link ContactTrackingService#getUnsubscribes(String, Integer, String)}
	 *
	 * @param contactId The contact id.
	 * @param limit The limit - Null to use the default.
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
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		return contactTrackingService.getUnsubscribes(this.getAccessToken(), contactId, limit, createdSinceTimestamp);
	}

	/**
	 *
	 * Get Contact Tracking Unsubscribes API.<br/>
	 * Details in : {@link PaginationHelperService#getPage(Pagination)}
	 *
	 * @param pagination
	 *          {@link Pagination} for fetching next set of data.
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
	public ResultSet<ContactTrackingUnsubscribe> getContactTrackingUnsubscribes(Pagination pagination) throws IllegalArgumentException,
		ConstantContactServiceException {
		if(pagination == null) {
			throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
		}
		return getPaginationHelperService().getPage(this.getAccessToken(), pagination, ContactTrackingUnsubscribe.class);
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
			throw new IllegalArgumentException(Config.instance().getErrorBulkContactsRequestNull());
		}
		return bulkActivitiesService.addContacts(this.getAccessToken(), request);
	}

    /**
     *
     * Add Bulk Contacts API.<br/>
     * Details in : {@link BulkActivitiesService#addContacts(String, MultipartBody)}
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
	public ContactsResponse addBulkContactsMultipart(String fileName, File file, ArrayList<String> listIds) throws ConstantContactServiceException, IOException{

	    if (fileName == null || "".equals(fileName)){
	        throw new IllegalArgumentException(Config.instance().getErrorFileNameNull());
	    } else if (file == null){
	        throw new IllegalArgumentException(Config.instance().getErrorFileNull());
	    } else if (listIds == null){
            throw new IllegalArgumentException(Config.instance().getErrorBulkContactsListNull());
        }

	    Map<String,String> textParts = new HashMap<String,String>();
	    StringBuilder lists = new StringBuilder();

	    lists.append(listIds.remove(0));
	    for (String list : listIds){
	        lists.append(",");
	        lists.append(list);
	    }

	    textParts.put("lists", lists.toString());

	    InputStream fileStream = new FileInputStream(file);

	    MultipartBody request = MultipartBuilder.buildMultipartBody(textParts, fileName, fileStream);

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
			throw new IllegalArgumentException(Config.instance().getErrorBulkContactsRequestNull());
		}
		return bulkActivitiesService.removeContactsFromLists(this.getAccessToken(), request);
	}

	   /**
     *
     * Remove Bulk Contacts From Lists API.<br/>
     * Details in : {@link BulkActivitiesService#removeContactsFromLists(String, MultipartBody)}
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
    public ContactsResponse removeBulkContactsFromListsMultipart(String fileName, File file, ArrayList<String> listIds)
            throws ConstantContactServiceException, IOException {

        if (fileName == null || "".equals(fileName)) {
            throw new IllegalArgumentException(Config.instance().getErrorFileNameNull());
        }
        else if (file == null) {
            throw new IllegalArgumentException(Config.instance().getErrorFileNull());
        }
        else if (listIds == null) {
            throw new IllegalArgumentException(Config.instance().getErrorBulkContactsListNull());
        }

        Map<String, String> textParts = new HashMap<String, String>();
        StringBuilder lists = new StringBuilder();

        lists.append(listIds.remove(0));
        for (String list : listIds) {
            lists.append(",");
            lists.append(list);
        }

        textParts.put("lists", lists.toString());

        InputStream fileStream = new FileInputStream(file);

        MultipartBody request = MultipartBuilder.buildMultipartBody(textParts, fileName, fileStream);

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
			throw new IllegalArgumentException(Config.instance().getErrorBulkContactsRequestNull());
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
			throw new IllegalArgumentException(Config.instance().getErrorBulkContactsRequestNull());
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

	/**
	 * Retrieve My Library product information. <br />
	 * Details in : {@link MyLibraryService#getLibraryInfo(String)}
	 *
	 * @return The {@link MyLibrarySummary} for this account
	 * @throws ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
	public MyLibrarySummary getLibraryInfo() throws ConstantContactServiceException{
	    return myLibraryService.getLibraryInfo(this.getAccessToken());
	}

    /**
     * Retrieves the list of folders <br />
     * Details in : {@link MyLibraryService#getLibraryFolders(String, FolderSortOptions, Integer)}
     *
     * @param sortBy The method to sort by. See {@link FolderSortOptions}. Leave null to not use
     * @param limit The number of results to return. Leave null to use default.
     * @throws {@link ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @return The {@link ResultSet} of {@link MyLibraryFolder} Data
     */
	public ResultSet<MyLibraryFolder> getLibraryFolders(MyLibraryFolder.FolderSortOptions sortBy, Integer limit) throws ConstantContactServiceException{
	    return myLibraryService.getLibraryFolders(this.getAccessToken(), sortBy, limit);
	}

    /**
     * Retrieves the list of folders <br />
     * Details in : {@link MyLibraryService#getLibraryFolders(String, FolderSortOptions, Integer)}
     *
     * @param pagination The {@Pagination} to retrieve results for.
     * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
     *         The exception also contains a description of the cause.<br/>
     *         Error message is taken from one of the members of {@link Errors}
     * @throws {@link ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @return The {@link ResultSet} of {@link MyLibraryFolder} Data
     */
    public ResultSet<MyLibraryFolder> getLibraryFolders(Pagination pagination) throws ConstantContactServiceException, IllegalArgumentException{
        if (pagination == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
        }
        return getPaginationHelperService().getPage(this.getAccessToken(), pagination, MyLibraryFolder.class);
    }

    /**
     * Add Library Folder API.<br/>
     * Details in : {@link MyLibraryService#addLibraryFolder(String, MyLibraryFolder)}
     *
     * @param folder The {@link MyLibraryFolder} to add.
     * @return The added Folder.
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
	public MyLibraryFolder addLibraryFolder(MyLibraryFolder folder) throws ConstantContactServiceException, IllegalArgumentException{
	    if (folder == null){
	        throw new IllegalArgumentException(Config.instance().getErrorFolderNull());
	    }

	    return myLibraryService.addLibraryFolder(this.getAccessToken(),folder);

	}

    /**
     * Get Library Folder API.<br/>
     * Details in : {@link MyLibraryService#getLibraryFolder(String, String)}
     *
     * @param folderId The ID for the Folder to return.
     * @return The added {@link MyLibraryFolder}.
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
	public MyLibraryFolder getLibraryFolder(String folderId) throws ConstantContactServiceException, IllegalArgumentException{

	    if (folderId == null || folderId.trim().equals("")){
	        throw new IllegalArgumentException(Config.instance().getErrorFolderIdNull());
	    }

	    return myLibraryService.getLibraryFolder(this.getAccessToken(), folderId);
	}

    /**
     * Update Library Folder API.<br/>
     * Details in : {@link MyLibraryService#updateLibraryFolder(String, String, Boolean)}
     *
     * @param folderId The ID for the Folder to return.
     * @param includePayload If the result should be the updated Folder or NULL (defaults to true if left null)
     * @return The added {@link MyLibraryFolder}, or Null if includePayload was false.
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
    public MyLibraryFolder updateLibraryFolder(MyLibraryFolder folder, Boolean includePayload) throws ConstantContactServiceException, IllegalArgumentException {

        if (folder == null || folder.getId() == null || folder.getId().trim().equals("")){
            throw new IllegalArgumentException(Config.instance().getErrorFolderIdNull());
        }

        return myLibraryService.updateLibraryFolder(this.getAccessToken(), folder, includePayload);

    }

    /**
     * Delete Library Folder API.<br/>
     * Details in : {@link MyLibraryService#deleteLibraryFolder(String, String)}
     *
     * @param folderId The ID for the Folder to delete.
     * @return Void. Exceptions are raised on failures.
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
    public void deleteLibraryFolder(String folderId) throws ConstantContactServiceException, IllegalArgumentException {
        if (folderId == null || folderId.trim().equals("")){
            throw new IllegalArgumentException(Config.instance().getErrorFolderIdNull());
        }

        myLibraryService.deleteLibraryFolder(this.getAccessToken(), folderId);
    }

    /**
     * Retrieve Library Trash API.<br/>
     * Details in : {@link MyLibraryService#getLibraryTrash(String, MyLibraryFile.Type, MyLibraryFile.SortBy, Integer)}
     *
     * @param type - The type of files to return. Null for default.
     * @param sortBy - The way to sort results. Null for default
     * @param limit - The number of results to return per page.
     * @return A {@link ResultSet} of {@link MyLibraryFile} in case of success; an exception is thrown otherwise.
     * @throws ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
     */
    public ResultSet<MyLibraryFile> getLibraryTrash(MyLibraryFile.Type type, MyLibraryFile.SortBy sortBy, Integer limit) throws ConstantContactServiceException {
	    return myLibraryService.getLibraryTrash(this.getAccessToken(), type, sortBy, limit);
	}

    /**
     * Retrieve Library Trash API.<br/>
     *
     * @param pagination
     *          {@link Pagination} for fetching next set of data.
     * @return A {@link ResultSet} of {@link MyLibraryFile} in case of success; an exception is thrown otherwise.
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
    public ResultSet<MyLibraryFile> getLibraryTrash(Pagination pagination) throws ConstantContactServiceException, IllegalArgumentException {
        if(pagination == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
        }
        return getPaginationHelperService().getPage(this.getAccessToken(), pagination, MyLibraryFile.class);
    }

    /**
     * Delete Library Trash API.<br/>
     *
     * @return Void
     * @throws ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
     */
    public void deleteLibraryTrash() throws ConstantContactServiceException {
        myLibraryService.deleteLibraryTrash(this.getAccessToken());
        return;
    }

    /**
     * Retrieve Library Files API.<br/>
     * Details in : {@link MyLibraryService#getLibraryFiles(String, MyLibraryFile.Type, MyLibrary.Source, MyLibraryFile.SortBy, Integer)}
     *
     * @param type - The type of files to return. Null for default.
     * @param source - The source of the files. Null for default.
     * @param sortBy - The way to sort results. Null for default
     * @param limit - The number of results to return per page.
     * @return A {@link ResultSet} of {@link MyLibraryFile} in case of success; an exception is thrown otherwise.
     * @throws ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
     */
    public ResultSet<MyLibraryFile> getLibraryFiles(MyLibraryFile.Type type, ImageSource source, MyLibraryFile.SortBy sortBy, Integer limit)  throws ConstantContactServiceException{
        return myLibraryService.getLibraryFiles(this.getAccessToken(), type, source, sortBy, limit);
    }

    /**
     * Retrieve Library Files API.<br/>
     *
     * @param pagination
     *          {@link Pagination} for fetching next set of data.
     * @return A {@link ResultSet} of {@link MyLibraryFile} in case of success; an exception is thrown otherwise.
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
    public ResultSet<MyLibraryFile> getLibraryFiles(Pagination pagination) throws ConstantContactServiceException, IllegalArgumentException {
        if(pagination == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
        }
        return getPaginationHelperService().getPage(this.getAccessToken(), pagination, MyLibraryFile.class);
    }

    /**
     * Retrieve Library Files API.<br/>
     * Details in : {@link MyLibraryService#getLibraryFilesByFolder(String, MyLibraryFile.Type, MyLibrary.Source, MyLibraryFile.SortBy, Integer)}
     *
     * @param folderId - The library Folder Id
     * @param limit - The number of results to return per page.
     * @return A {@link ResultSet} of {@link MyLibraryFile} in case of success; an exception is thrown otherwise.
     * @throws ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
     */
    public ResultSet<MyLibraryFile> getLibraryFilesByFolder(String folderId, Integer limit)  throws ConstantContactServiceException{
        return myLibraryService.getLibraryFilesByFolder(this.getAccessToken(), folderId, limit);
    }

    /**
     * Retrieve Library Files API.<br/>
     *
     * @param pagination
     *          {@link Pagination} for fetching next set of data.
     * @return A {@link ResultSet} of {@link MyLibraryFile} in case of success; an exception is thrown otherwise.
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
    public ResultSet<MyLibraryFile> getLibraryFilesByFolder(Pagination pagination) throws ConstantContactServiceException, IllegalArgumentException {
        if(pagination == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
        }
        return getPaginationHelperService().getPage(this.getAccessToken(), pagination, MyLibraryFile.class);
    }

    /**
     * Get Library File API.<br/>
     * Details in : {@link MyLibraryService#getLibraryFile(String, String)}
     *
     * @param fileId The ID for the File to return.
     * @return The added {@link MyLibraryFile}.
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
    public MyLibraryFile getLibraryFile(String fileId) throws ConstantContactServiceException, IllegalArgumentException{

        if (fileId == null || fileId.trim().equals("")){
            throw new IllegalArgumentException(Config.instance().getErrorFileIdNull());
        }

        return myLibraryService.getLibraryFile(this.getAccessToken(), fileId);
    }

    /**
     * Update Library File API.<br/>
     * Details in : {@link MyLibraryService#updateLibraryFile(String, String, Boolean)}
     *
     * @param folderId The ID for the Folder to return.
     * @param includePayload If the result should be the updated Folder or NULL (defaults to true if left null)
     * @return The added {@link MyLibraryFile}, or Null if includePayload was false.
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
    public MyLibraryFile updateLibraryFile(MyLibraryFile file, Boolean includePayload) throws ConstantContactServiceException, IllegalArgumentException {

        if (file == null || file.getId() == null || file.getId().trim().equals("")){
            throw new IllegalArgumentException(Config.instance().getErrorFileIdNull());
        }

        return myLibraryService.updateLibraryFile(this.getAccessToken(), file, includePayload);

    }

    /**
     * Delete Library File API.<br/>
     * Details in : {@link MyLibraryService#deleteLibraryFile(String, String)}
     *
     * @param fileId The ID for the File to delete.
     * @return Void. Exceptions are raised on failures.
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
    public void deleteLibraryFile(String fileId) throws ConstantContactServiceException, IllegalArgumentException {
        if (fileId == null || fileId.trim().equals("")){
            throw new IllegalArgumentException(Config.instance().getErrorFileIdNull());
        }

        myLibraryService.deleteLibraryFile(this.getAccessToken(), fileId);
    }

    /**
     * Retrieves the Status of files uploaded to the Library <br />
     * Details in : {@link MyLibraryService#getLibraryFilesUploadStatus(String, String...)
     *
     * @param fileId A varargs list of fileIds to return results for.
     * @throws {@link ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
     *         The exception also contains a description of the cause.<br/>
     *         Error message is taken from one of the members of {@link Errors}
     * @return The {@link List} of {@link UploadStatus} Data
     */
    public List<UploadStatus> getLibraryFilesUploadStatus(String ... fileId) throws ConstantContactServiceException, IllegalArgumentException {

        if (fileId == null || fileId.length < 1){
            throw new IllegalArgumentException(Config.instance().getErrorFileIdNull());
        }

        return myLibraryService.getLibraryFilesUploadStatus(this.getAccessToken(), fileId);
    }

    /**
     * Moves files from one folder to another <br />
     * Details in : {@link MyLibraryService#moveLibraryFiles(String, String, String)
     *
     * @param folderId The folder to put the files in
     * @param fileIds The list of files to move
     * @throws {@link ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
     *         The exception also contains a description of the cause.<br/>
     *         Error message is taken from one of the members of {@link Errors}
     * @return The {@link List} of {@link MoveResults} Data
     */
    public List<MoveResults> moveLibraryFiles(String folderId, List<String> fileIds) throws ConstantContactServiceException, IllegalArgumentException {
        if (fileIds == null || fileIds.size() < 1){
            throw new IllegalArgumentException(Config.instance().getErrorFileIdNull());
        }

        StringBuilder body = new StringBuilder("[");
        body.append("\"").append(fileIds.get(0)).append("\"");
        for (int i=1;i<fileIds.size();i++){
            body.append(",").append("\"").append(fileIds.get(i)).append("\"");
        }
        body.append("]");

        return myLibraryService.moveLibraryFiles(this.getAccessToken(), folderId, body.toString());
    }

    /**
     * Adds a file to the library <br />
     * Details in {@link MyLibraryService#addLibraryFile(String, MultipartBody)}
     * @param file The file to upload
     * @param fileName The name to associate it with
     * @param description The description of the file.
     * @param fileType The {@link FileType} of the file
     * @param folderId The folder to upload it to
     * @param imageSource The {@link ImageSource} of the file
     * @return The fileId associated with the uploaded file
     * @throws {@link ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
     *         The exception also contains a description of the cause.<br/>
     *         Error message is taken from one of the members of {@link Errors}
     * @throws IOException if there is an issue with processing the file for upload.
     */
    public String addLibraryFile(File file, String fileName, String description, FileType fileType,
            String folderId, ImageSource imageSource) throws ConstantContactServiceException, IOException, IllegalArgumentException {
        if (fileName == null || "".equals(fileName)){
            throw new IllegalArgumentException(Config.instance().getErrorFileNameNull());
        } else if (file == null){
            throw new IllegalArgumentException(Config.instance().getErrorFileNull());
        } else if (folderId == null){
            throw new IllegalArgumentException(Config.instance().getErrorFolderIdNull());
        } else if (imageSource == null){
            throw new IllegalArgumentException(Config.instance().getErrorMyLibraryImageSourceNull());
        } else if (description == null){
            throw new IllegalArgumentException(Config.instance().getErrorMyLibraryDescriptionNull());
        } else if (fileType == null){
            throw new IllegalArgumentException(Config.instance().getErrorMyLibraryFileTypeNull());
        }

        Map<String,String> textParts = new HashMap<String,String>();

        textParts.put("description", description);
        textParts.put("file_type", fileType.toString());
        textParts.put("folder_id", folderId);
        textParts.put("source", imageSource.toString());

        InputStream fileStream = new FileInputStream(file);

        MultipartBody request = MultipartBuilder.buildMultipartBody(textParts, fileName, fileStream);

        return myLibraryService.addLibraryFile(this.getAccessToken(), request);
    }

	/**
	 * Get event API.<br/>
	 * Details in : {@link EventSpotService#getEvent(String, String)}
	 *
	 * @param eventId The the event id.
	 * @return The event.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
    public Event getEvent(String eventId) throws ConstantContactServiceException,
            IllegalArgumentException {
        return getEventSpotService().getEvent(getAccessToken(), eventId);
    }
	
	/**
	 * Get events API. <br/>
	 * Details in : {@link EventSpotService#getEvents(String, Integer)}
	 *
	 * @param limit The maximum number of results to return - can be null.
	 * @return The result set of events.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
    public ResultSet<Event> getEvents(Integer limit) throws ConstantContactServiceException,
            IllegalArgumentException {
        return getEventSpotService().getEvents(getAccessToken(), limit);
    }

    /**
     * Get events API.<br/>
     * Details in : {@link PaginationHelperService#getPage(Pagination)}
     *
     * @param pagination {@link Pagination} object.
     * @return The result set of events.
     * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
     * The exception also contains a description of the cause.<br/>
     * Error message is taken from one of the members of {@link Errors}
     * @throws ConstantContactServiceException Thrown when :
     *      <ul>
     *          <li>something went wrong either on the client side;</li>
     *          <li>or an error message was received from the server side.</li>
     *      </ul>
     *      <br/>
     * To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
     * Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
     */
    public ResultSet<Event> getEvents(Pagination pagination) throws ConstantContactServiceException,
            IllegalArgumentException {
        if (pagination == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
        }
        return getPaginationHelperService().getPage(this.getAccessToken(), pagination, Event.class);
    }
 	/**
 	 * Add events API.<br/>
 	 * Details in : {@link EventSpotService#addEvent(String, Event)}
 	 *
 	 * @param event The {@link Event} to add.
 	 * @return The added event.
 	 * @throws ConstantContactServiceException Thrown when :
 	 *             <ul>
 	 *             <li>something went wrong either on the client side;</li>
 	 *             <li>or an error message was received from the server side.</li>
 	 *             </ul>
 	 * <br/>
 	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
 	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
 	 */
    public Event addEvent(Event event) throws IllegalArgumentException, ConstantContactServiceException {
        if (event == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEvent());
        }
        return getEventSpotService().addEvent(getAccessToken(), event);
    }

	/**
	 *
	 * Update event API.<br/>
	 * Details in : {@link EventSpotService#updateEvent(String, Event)}
	 *	
	 * @param event	The event to update.
	 * @return The updated {@link Event} in case of success; an exception is thrown otherwise.
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
    public Event updateEvent(Event event) throws IllegalArgumentException, ConstantContactServiceException {
        if(event == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEvent());
        }
        return getEventSpotService().updateEvent(getAccessToken(), event);
    }
	
	/**
	 *
	 * Update event status API.<br/>
	 * Details in : {@link EventSpotService#updateEventStatus(String, String,String)}
	 *	
	 * @param eventId	The event to update.
	 * @param status	The event status.
	 * @return The updated {@link Event} in case of success; an exception is thrown otherwise.
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
    public boolean updateEventStatus(String eventId, String status)  throws IllegalArgumentException, ConstantContactServiceException {
        if(eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        return getEventSpotService().updateEventStatus(getAccessToken(), eventId, status);
    }
	
	/**
	 * Get event fees API. <br/>
	 * Details in : {@link EventSpotService#getEventFees(String, String)}
	 *
	 * @param eventId The event id.
	 * @return The list of event fees.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
    public List<EventFee> getEventFees(String eventId) throws IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        return getEventSpotService().getEventFees(getAccessToken(), eventId);
    }
	
 	/**
 	 * Add Event fee API.<br/>
 	 * Details in : {@link EventSpotService#addEventFee(String, String, EventFee)}
 	 *
	 * @param eventId	The event id.
 	 * @param eventFee	The {@link EventFee} to add.
 	 * @return The added event fee.
 	 * @throws ConstantContactServiceException Thrown when :
 	 *             <ul>
 	 *             <li>something went wrong either on the client side;</li>
 	 *             <li>or an error message was received from the server side.</li>
 	 *             </ul>
 	 * <br/>
 	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
 	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
 	 */
    public EventFee addEventFee(String eventId, EventFee eventFee) throws ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (eventFee == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventFee());
        }
        return getEventSpotService().addEventFee(getAccessToken(), eventId, eventFee);
    }
	
	/**
	 * Get event fee API.<br/>
	 * Details in : {@link EventSpotService#getEventFee(String, String, String)}
	 *
	 * @param eventId The event id.
	 * @param feeId The fee id.
	 * @return The event fee.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
    public EventFee getEventFee(String eventId, String feeId) throws IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (feeId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventFeeId());
        }
        return getEventSpotService().getEventFee(getAccessToken(), eventId, feeId);
    }
	
	/**
	 *
	 * Update event fee API.<br/>
	 * Details in : {@link EventSpotService#updateEventFee(String, String, EventFee)}
	 *	
	 * @param eventId	The event id.		
	 * @param eventFee	The {@link EventFee} to update.
	 * @return The updated {@link EventFee} in case of success; an exception is thrown otherwise.
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
    public EventFee updateEventFee(String eventId, EventFee eventFee) throws IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (eventFee == null || eventFee.getId() == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventFeeId());
        }
        return getEventSpotService().updateEventFee(getAccessToken(), eventId, eventFee);
    }
	
 	/**
 	 * Delete event fee API.<br/>
 	 * Details in : {@link EventSpotService#deleteEventFee(String, String, String)}
 	 * 
 	 * @param eventId The event id.
 	 * @param eventFee The {@link EventFee} to delete.
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
    public boolean deleteEventFee(String eventId, EventFee eventFee) throws IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (eventFee == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventFee());
        }
        if (eventFee.getId() == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventFeeId());
        }
        return getEventSpotService().deleteEventFee(getAccessToken(), eventId, eventFee.getId());
    }
	
 	/**
 	 * Delete event fee API.<br/>
 	 * Details in : {@link EventSpotService#deleteEventFee(String, String, String)}
 	 * 
 	 * @param eventId The event id.
 	 * @param eventFeeId The event fee id to delete.
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
    public boolean deleteEventFee(String eventId, String eventFeeId) throws IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (eventFeeId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventFeeId());
        }
        return getEventSpotService().deleteEventFee(getAccessToken(), eventId, eventFeeId);
    }

	/**
	 * Get event promocodes API. <br/>
	 * Details in : {@link EventSpotService#getEventPromocodes(String, String)}
	 *
	 * @eventId The event id.
	 * @return The list of event promocodes.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
    public List<Promocode> getEventPromocodes(String eventId) throws IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        return getEventSpotService().getEventPromocodes(getAccessToken(), eventId);
    }

 	/**
 	 * Add event promocode API.<br/>
 	 * Details in : {@link EventSpotService#addEventPromocode(String, String, Promocode)}
 	 *
	 * @param eventId	The event id.
 	 * @param promocode	The {@link Promocode} to add.
 	 * @return The added event promocode.
 	 * @throws ConstantContactServiceException Thrown when :
 	 *             <ul>
 	 *             <li>something went wrong either on the client side;</li>
 	 *             <li>or an error message was received from the server side.</li>
 	 *             </ul>
 	 * <br/>
 	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
 	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
 	 */
    public Promocode addEventPromocode(String eventId, Promocode promocode) throws IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (promocode == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPromocode());
        }
        return getEventSpotService().addEventPromocode(getAccessToken(), eventId, promocode);
    }
	
	/**
	 * Get event promocode API.<br/>
	 * Details in : {@link EventSpotService#getEventPromocode(String, String, String)}
	 *
	 * @param eventId The event id.
	 * @param promocodeId The promocode id.
	 * @return The event promocode.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
    public Promocode getEventPromocode(String eventId, String promocodeId) throws IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (promocodeId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPromocodeId());
        }
        return getEventSpotService().getEventPromocode(getAccessToken(), eventId, promocodeId);
    }
	
	/**
	 *
	 * Update event promocode API.<br/>
	 * Details in : {@link EventSpotService#updateEventPromocode(String, String, Promocode)}
	 *	
	 * @param eventId	The event id.		
	 * @param promocode	The {@link Promocode} to update.
	 * @return The updated {@link Promocode} in case of success; an exception is thrown otherwise.
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
    public Promocode updateEventPromocode(String eventId, Promocode promocode) throws IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (promocode == null || promocode.getId() == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPromocode());
        }
        return getEventSpotService().updateEventPromocode(getAccessToken(), eventId, promocode);
    }

 	/**
 	 * Delete event promocode API.<br/>
 	 * Details in : {@link EventSpotService#deleteEventPromocode(String, String, String)}
 	 * 
 	 * @param eventId The event id.
 	 * @param promocodeId The event promocode id to delete.
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
    public boolean deleteEventPromocode(String eventId, String promocodeId) throws  IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (promocodeId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPromocodeId());
        }
        return getEventSpotService().deleteEventPromocode(getAccessToken(), eventId, promocodeId);
    }
	
 	/**
 	 * Delete event promocode API.<br/>
 	 * Details in : {@link EventSpotService#deleteEventPromocode(String, String, String)}
 	 * 
 	 * @param eventId The event id.
 	 * @param promocode The event promocode id to delete.
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
    public boolean deleteEventPromocode(String eventId, Promocode promocode) throws IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (promocode == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPromocode());
        }
        if (promocode.getId() == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPromocodeId());
        }
        return getEventSpotService().deleteEventPromocode(getAccessToken(), eventId, promocode.getId());
    }

	/**
	 * Get event registrants API. <br/>
	 * Details in : {@link EventSpotService#getEventRegistrants(String, String, Integer)}
	 *
	 * @eventId The event id.
	 * @return The result set of event registrants.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
    public ResultSet<Registrant> getEventRegistrants(String eventId, Integer limit) throws IllegalArgumentException,
            ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        return getEventSpotService().getEventRegistrants(getAccessToken(), eventId, limit);
    }
	
    /**
     * Get event registrants API.<br/>
     * Details in : {@link PaginationHelperService#getPage(Pagination)}
     *
     * @param pagination {@link Pagination} object.
     * @return The result set of event registrants.
     * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
     * The exception also contains a description of the cause.<br/>
     * Error message is taken from one of the members of {@link Errors}
     * @throws ConstantContactServiceException Thrown when :
     *      <ul>
     *          <li>something went wrong either on the client side;</li>
     *          <li>or an error message was received from the server side.</li>
     *      </ul>
     *      <br/>
     * To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
     * Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
     */
    public ResultSet<Registrant> getEventRegistrants(String eventId, Pagination pagination) throws IllegalArgumentException,
            ConstantContactServiceException {
        if (pagination == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
        }
        return getPaginationHelperService().getPage(this.getAccessToken(), pagination, Registrant.class);
    }
	
	/**
	 * Get event registrant API.<br/>
	 * Details in : {@link EventSpotService#getEventRegistrant(String, String, String)}
	 *
	 * @param eventId The event id.
	 * @param registrantId The event registrant id.
	 * @return The event registrant {@link Registrant}.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
    public RegistrantDetails getEventRegistrant(String eventId, String registrantId) throws IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (registrantId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorRegistrantId());
        }
        return getEventSpotService().getEventRegistrant(getAccessToken(), eventId, registrantId);
    }
	
	/**
	 * Get event items API. <br/>
	 * Details in : {@link EventSpotService#getEventItems(String, String)}
	 *
	 * @param eventId The event id.
	 * @return The list of event items.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
    public List<EventItem> getEventItems(String eventId) throws IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        return getEventSpotService().getEventItems(getAccessToken(), eventId);
    }

	/**
	 * Get event item API.<br/>
	 * Details in : {@link EventSpotService#getEventItem(String, String, String)}
	 *
	 * @param eventId The event id.
	 * @param itemId The event item id.
	 * @return The event item {@link EventItem}.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
    public EventItem getEventItem(String eventId, String itemId) throws IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (itemId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItemId());
        }
        return getEventSpotService().getEventItem(getAccessToken(), eventId, itemId);
    }

 	/**
 	 * Add event item API.<br/>
 	 * Details in : {@link EventSpotService#addEventItem(String, String, EventItem)}
 	 *
	 * @param eventId	The event id.
 	 * @param item	The {@link EventItem} to add.
 	 * @return The added event item.
 	 * @throws ConstantContactServiceException Thrown when :
 	 *             <ul>
 	 *             <li>something went wrong either on the client side;</li>
 	 *             <li>or an error message was received from the server side.</li>
 	 *             </ul>
 	 * <br/>
 	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
 	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
 	 */
    public EventItem addEventItem(String eventId, EventItem item) throws IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (item == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItem());
        }
        return getEventSpotService().addEventItem(getAccessToken(), eventId, item);
    }

	/**
	 *
	 * Update event item API.<br/>
	 * Details in : {@link EventSpotService#updateEventItem(String, String, EventItem)}
	 *	
	 * @param eventId	The event id.		
	 * @param item	The {@link EventItem} to update.
	 * @return The updated {@link EventItem} in case of success; an exception is thrown otherwise.
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
    public EventItem updateEventItem(String eventId, EventItem item) throws IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (item == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItem());
        }
        if (item.getId() == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        return getEventSpotService().updateEventItem(getAccessToken(), eventId, item);
    }

 	/**
 	 * Delete event item API.<br/>
 	 * Details in : {@link EventSpotService#deleteEventItem(String, String, String)}
 	 * 
 	 * @param eventId The event id.
 	 * @param itemId The event item id to delete.
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
    public boolean deleteEventItem(String eventId, String itemId) throws IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (itemId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItemId());
        }
        return getEventSpotService().deleteEventItem(getAccessToken(), eventId, itemId);
    }
	
 	/**
 	 * Delete event item API.<br/>
 	 * Details in : {@link EventSpotService#deleteEventItem(String, String, String)}
 	 * 
 	 * @param eventId The event id.
 	 * @param item The event item id to delete.
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
    public boolean deleteEventItem(String eventId, EventItem item) throws IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (item == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItem());
        }
        if (item.getId() == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItemId());
        }
        return getEventSpotService().deleteEventItem(getAccessToken(), eventId, item.getId());
    }
	
	/**
	 * Get event item attributes API.<br/>
	 * Details in : {@link EventSpotService#getEventItemAttributes(String, String, String)}
	 *
	 * @param eventId The event id.
	 * @param itemId The event item id.
	 * @return The list of event item attributes {@link EventItemAttribute}.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
    public List<EventItemAttribute> getEventItemAttributes(String eventId, String itemId) throws IllegalArgumentException,
            ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (itemId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItemId());
        }
        return getEventSpotService().getEventItemAttributes(getAccessToken(), eventId, itemId);
    }

	/**
	 * Get event item attribute API.<br/>
	 * Details in : {@link EventSpotService#getEventItemAttribute(String, String, String, String)}
	 *
	 * @param eventId The event id.
	 * @param itemId The event item id.
	 * @param attributeId The event item attribute id.
	 * @return The event item attribute {@link EventItemAttribute}.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
    public EventItemAttribute getEventItemAttribute(String eventId, String itemId, String attributeId) throws IllegalArgumentException,
            ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (itemId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItemId());
        }
        if (attributeId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItemAttributeId());
        }
        return getEventSpotService().getEventItemAttribute(getAccessToken(), eventId, itemId, attributeId);
    }

	/**
 	 * Add event item attribute API.<br/>
 	 * Details in : {@link EventSpotService#addEventItemAttribute(String, String, String, EventItemAttribute)}
 	 *
	 * @param eventId	The event id.
	 * @param itemId The event item id.
 	 * @param itemAttribute	The {@link EventItemAttribute} to add.
 	 * @return The added event item attribute.
 	 * @throws ConstantContactServiceException Thrown when :
 	 *             <ul>
 	 *             <li>something went wrong either on the client side;</li>
 	 *             <li>or an error message was received from the server side.</li>
 	 *             </ul>
 	 * <br/>
 	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
 	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
 	 */
    public EventItemAttribute addEventItemAttribute(String eventId, String itemId, EventItemAttribute itemAttribute) throws
            IllegalArgumentException, ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (itemId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItemId());
        }
        if (itemAttribute == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItemAttribute());
        }
        return getEventSpotService().addEventItemAttribute(getAccessToken(), eventId, itemId, itemAttribute);
    }
	
	/**
	 *
	 * Update event item attribute API.<br/>
	 * Details in : {@link EventSpotService#updateEventItemAttribute(String, String, String, EventItemAttribute)}
	 *	
	 * @param eventId	The event id.
	 * @param itemId The event item id.
	 * @param itemAttribute	The {@link EventItemAttribute} to update.
	 * @return The updated {@link EventItemAttribute} in case of success; an exception is thrown otherwise.
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
    public EventItemAttribute updateEventItemAttribute(String eventId, String itemId, EventItemAttribute itemAttribute) throws
            IllegalArgumentException,
            ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (itemId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItemId());
        }
        if (itemAttribute == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItemAttribute());
        }
        return getEventSpotService().updateEventItemAttribute(getAccessToken(), eventId, itemId, itemAttribute);
    }

 	/**
 	 * Delete event item attribute API.<br/>
 	 * Details in : {@link EventSpotService#deleteEventItemAttribute(String, String, String, String)}
 	 * 
 	 * @param eventId The event id.
 	 * @param itemId The event item id.
 	 * @param itemAttributeId The event item attribute id to delete.
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
    public boolean deleteEventItemAttribute(String eventId, String itemId, String itemAttributeId) throws IllegalArgumentException,
            ConstantContactServiceException {
        if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (itemId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItemId());
        }
        if (itemAttributeId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItemAttributeId());
        }
        return getEventSpotService().deleteEventItemAttribute(getAccessToken(), eventId, itemId, itemAttributeId);
    }
	
	/**
	 * Get account info API.<br/>
	 * Details in : {@link AccountService#getAccountInfo(String)}
	 *
	 * @return The account info.
	 * @throws ConstantContactServiceException Thrown when :
	 *             <ul>
	 *             <li>something went wrong either on the client side;</li>
	 *             <li>or an error message was received from the server side.</li>
	 *             </ul>
	 * <br/>
	 *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
	 *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
	 */
    public AccountInfo getAccountInfo() throws  ConstantContactServiceException {
        return getAccountService().getAccountInfo(getAccessToken());
    }
	
	/**
	 *
	 * Update account info.<br/>
	 * Details in : {@link AccountService#updateAccountInfo(String, AccountInfo)}
	 *	
	 * @param accountInfo	The account information.
	 * @return The updated {@link AccountInfo} in case of success; an exception is thrown otherwise.
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
    public AccountInfo updateAccountInfo(AccountInfo accountInfo) throws IllegalArgumentException, ConstantContactServiceException {
		if(accountInfo == null) {
			throw new IllegalArgumentException(Config.instance().getErrorAccountInfo()); 
		}
        return getAccountService().updateAccountInfo(getAccessToken(), accountInfo);
    }
}
