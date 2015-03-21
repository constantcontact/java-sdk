package com.constantcontact.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Main Configuration structure in Constant Contact.
 *
 * @author ConstantContact
 */
public final class Config {

	private static Config instance;
	private static final String CTCT_API_PROPERTIES = "ctct_api.properties";

	/**
	 * Private Constructor
	 */
	private Config() {
		loadProperties();
	}

	/**
	 * Singleton
	 * 
	 * @return
	 */
	public static Config instance() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}

	private void loadProperties() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = Config.class.getClassLoader().getResourceAsStream(CTCT_API_PROPERTIES);

			if (input != null) {
				prop.load(input);
			}

			baseUrl = prop.getProperty("constantcontact.api.dest.baseurl");
			contact = prop.getProperty("constantcontact.api.contact");
			contacts = prop.getProperty("constantcontact.api.contacts");
			lists = prop.getProperty("constantcontact.api.lists");
			list = prop.getProperty("constantcontact.api.list");
			listContacts = prop.getProperty("constantcontact.api.listcontacts");
			contactLists = prop.getProperty("constantcontact.api.contactlists");
			contactList = prop.getProperty("constantcontact.api.contactlist");
			emailCampaigns = prop.getProperty("constantcontact.api.emailcampaigns");
			emailCampaignId = prop.getProperty("constantcontact.api.emailcampaignid");
			emailCampaignsId = prop.getProperty("constantcontact.api.emailcampaignsid");
			verifiedEmailAddresses = prop.getProperty("constantcontact.api.verifiedemailaddresses");
			emailCampaignsSchedulesId = prop.getProperty("constantcontact.api.emailcampaignsschedulesid");
			emailCampaignsSchedulesIdAll = prop.getProperty("constantcontact.api.emailcampaignsschedulesidall");
			emailCampaignsTrackingReportsSummary = prop.getProperty("constantcontact.api.emailcampaignstrackingreportssummary");
			emailCampaignsTrackingBounces = prop.getProperty("constantcontact.api.emailcampaignstrackingbounces");
			emailCampaignsTrackingClicks = prop.getProperty("constantcontact.api.emailcampaignstrackingclicks");
			emailCampaignsTrackingForwards = prop.getProperty("constantcontact.api.emailcampaignstrackingforwards");
			emailCampaignsTrackingOpens = prop.getProperty("constantcontact.api.emailcampaignstrackingopens");
			emailCampaignsTrackingSends = prop.getProperty("constantcontact.api.emailcampaignstrackingsends");
			emailCampaignsTrackingUnsubscribes = prop.getProperty("constantcontact.api.emailcampaignstrackingunsubscribes");
			emailCampaignsTrackingClicksByLink = prop.getProperty("constantcontact.api.emailcampaignstrackingclicksbylink");
			contactsTrackingReportsSummary = prop.getProperty("constantcontact.api.contactstrackingreportssummary");
			contactsTrackingReportsByCampaignSummary = prop.getProperty("constantcontact.api.contactstrackingreportsbycampaignsummary");
			contactsTrackingAll = prop.getProperty("constantcontact.api.contactstrackingall");
			contactsTrackingBounces = prop.getProperty("constantcontact.api.contactstrackingbounces");
			contactsTrackingClicks = prop.getProperty("constantcontact.api.contactstrackingclicks");
			contactsTrackingForwards = prop.getProperty("constantcontact.api.contactstrackingforwards");
			contactsTrackingOpens = prop.getProperty("constantcontact.api.contactstrackingopens");
			contactsTrackingSends = prop.getProperty("constantcontact.api.contactstrackingsends");
			contactsTrackingUnsubscribes = prop.getProperty("constantcontact.api.contactstrackingunsubscribes");
			activitiesAddContacts = prop.getProperty("constantcontact.api.activitiesaddcontacts");
			activitiesRemoveFromLists = prop.getProperty("constantcontact.api.activitiesremovefromlists");
			activitiesClearLists = prop.getProperty("constantcontact.api.activitiesclearlists");
			activitiesExportContacts = prop.getProperty("constantcontact.api.activitiesexportcontacts");
			activities = prop.getProperty("constantcontact.api.activities");
			libraryInfo = prop.getProperty("constantcontact.api.libraryinfo");
			libraryFiles = prop.getProperty("constantcontact.api.libraryfiles");
			libraryFilesByFolder = prop.getProperty("constantcontact.api.libraryfilesbyfolder");
			libraryFolders = prop.getProperty("constantcontact.api.libraryfolders");
			libraryFolder = getLibraryFolders() + prop.getProperty("constantcontact.api.libraryfolder");
			libraryFolderTrash = getLibraryFolders() + prop.getProperty("constantcontact.api.libraryfoldertrash");
			libraryFile = getLibraryFiles() + prop.getProperty("constantcontact.api.libraryfile");
			libraryFileUploadStatus = getLibraryFiles() + prop.getProperty("constantcontact.api.libraryfileuploadstatus");
			libraryFileMove = prop.getProperty("constantcontact.api.libraryfilemove");
			events = prop.getProperty("constantcontact.api.events");
			eventId = getEvents() + prop.getProperty("constantcontact.api.eventid");
			eventFees = getEvents() + prop.getProperty("constantcontact.api.eventfees");
			eventFeeId = getEvents() + prop.getProperty("constantcontact.api.eventfeeid");
			eventPromocodes = getEvents() + prop.getProperty("constantcontact.api.eventpromocodes");
			eventPromocodeId = getEvents() + prop.getProperty("constantcontact.api.eventpromocodeid");
			eventRegistrants = getEvents() + prop.getProperty("constantcontact.api.eventregistrants");
			eventRegistrantId = getEvents() + prop.getProperty("constantcontact.api.eventregistrantid");
			eventItems = getEvents() + prop.getProperty("constantcontact.api.eventitems");
			eventItemId = getEvents() + prop.getProperty("constantcontact.api.eventitemid");
			eventItemAttributes = getEvents() + prop.getProperty("constantcontact.api.eventitemattributes");
			eventItemAttributeId = getEvents() + prop.getProperty("constantcontact.api.eventitemattributeid");
			accountInfo = prop.getProperty("constantcontact.api.accountinfo");

		} catch (IOException e) {
			throw new IllegalStateException("Cannot configure connection to Constant Contact", e);
		}finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException ignoreMe) {

				}
			}
		}
	}

	/**
	 * API access URL Host.
	 */
	private String baseUrl = "https://api.constantcontact.com";
	
	/**
	 * Access a contact.
	 */
	private String contact;

	/**
	 * Get all contacts.
	 */
	private String contacts;

	/**
	 * Get all lists.
	 */
	private String lists;

	/**
	 * Access a specified list.
	 */
	private String list;

	/**
	 * Get the list of contacts from a list.
	 */
	private String listContacts;

	/**
	 * Get contact lists.
	 */
	private String contactLists;

	/**
	 * Get a list from contact lists.
	 */
	private String contactList;

	/**
	 * Get campaigns.
	 */
	private String emailCampaigns;

	/**
	 * Access a campaign.
	 */
	private String emailCampaignId;

	/**
	 * Access a campaign. This is for PUT operations.
	 */
	private String emailCampaignsId;

	/**
	 * Get verified email addresses.
	 */
	private String verifiedEmailAddresses;

	/**
	 * Access a campaign schedule.
	 */
	private String emailCampaignsSchedulesId;

	/**
	 * Access all campaign schedules.
	 */
	private String emailCampaignsSchedulesIdAll;

	/**
	 * Access email campaign tracking reports summary for a given email
	 * campaign.
	 */
	private String emailCampaignsTrackingReportsSummary;

	/**
	 * Access email campaign tracking bounces for a given email campaign.
	 */
	private String emailCampaignsTrackingBounces;

	/**
	 * Access email campaign tracking clicks for a given email campaign.
	 */
	private String emailCampaignsTrackingClicks;

	/**
	 * Access email campaign tracking forwards for a given email campaign.
	 */
	private String emailCampaignsTrackingForwards;

	/**
	 * Access email campaign tracking opens for a given email campaign.
	 */
	private String emailCampaignsTrackingOpens;

	/**
	 * Access email campaign tracking sends for a given email campaign.
	 */
	private String emailCampaignsTrackingSends;

	/**
	 * Access email campaign tracking unsubscribes for a given email campaign.
	 */
	private String emailCampaignsTrackingUnsubscribes;

	/**
	 * Access email campaign tracking clicks by link for a given email campaign.
	 */
	private String emailCampaignsTrackingClicksByLink;

	/**
	 * Access contact tracking reports summary for a given contact.
	 */
	private String contactsTrackingReportsSummary;

	/**
	 * Access contact tracking reports summary for a given contact.
	 */
	private String contactsTrackingReportsByCampaignSummary;

	/**
	 * Access contact tracking activities for a given contact.
	 */
	private String contactsTrackingAll;

	/**
	 * Access contact tracking bounces for a given contact.
	 */
	private String contactsTrackingBounces;

	/**
	 * Access contact tracking clicks for a given contact.
	 */
	private String contactsTrackingClicks;

	/**
	 * Access contact tracking forwards for a given contact.
	 */
	private String contactsTrackingForwards;

	/**
	 * Access contact tracking opens for a given contact.
	 */
	private String contactsTrackingOpens;

	/**
	 * Access contact tracking sends for a given contact.
	 */
	private String contactsTrackingSends;

	/**
	 * Access contact tracking unsubscribes for a given contact.
	 */
	private String contactsTrackingUnsubscribes;

	/**
	 * Endpoint for the bulk contacts upload.
	 */
	private String activitiesAddContacts;

	/**
	 * Endpoint for the bulk contacts remove from lists.
	 */
	private String activitiesRemoveFromLists;

	/**
	 * Endpoint for the bulk clear lists.
	 */
	private String activitiesClearLists;

	/**
	 * Endpoint for the bulk export contacts.
	 */
	private String activitiesExportContacts;

	/**
	 * Endpoint for the bulk activities retrieve.
	 */
	private String activities;

	private String libraryInfo;
	private String libraryFiles;
	private String libraryFilesByFolder;
	private String libraryFolders;

	private String libraryFolder;
	private String libraryFolderTrash;

	private String libraryFile;
	private String libraryFileUploadStatus;

	private String libraryFileMove;

	/**
	 * Endpoint for the list of events.
	 */
	private String events;

	/**
	 * Endpoint for accessing a single event.
	 */
	private String eventId;

	/**
	 * Endpoint for the list of event fees.
	 */
	private String eventFees;

	/**
	 * Endpoint for accessing a single event fee.
	 */
	private String eventFeeId;

	/**
	 * Endpoint for the list of the event's promocodes.
	 */
	private String eventPromocodes;

	/**
	 * Endpoint for accessing a single event promocode.
	 */
	private String eventPromocodeId;

	/**
	 * Endpoint for the list of event registrants.
	 */
	private String eventRegistrants;

	/**
	 * Endpoint for accessing a single event registrant.
	 */
	private String eventRegistrantId;

	/**
	 * Endpoint for the list of event items.
	 */
	private String eventItems;

	/**
	 * Endpoint for accessing a single event item.
	 */
	private String eventItemId;

	/**
	 * Endpoint for the list of event item attributes.
	 */
	private String eventItemAttributes;

	/**
	 * Endpoint for accessing a event item attribute.
	 */
	private String eventItemAttributeId;

	/**
	 * Endpoint for accessing the account info.
	 */
	private String accountInfo = "/v2/account/info";

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getLists() {
		return lists;
	}

	public void setLists(String lists) {
		this.lists = lists;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public String getListContacts() {
		return listContacts;
	}

	public void setListContacts(String listContacts) {
		this.listContacts = listContacts;
	}

	public String getContactLists() {
		return contactLists;
	}

	public void setContactLists(String contactLists) {
		this.contactLists = contactLists;
	}

	public String getContactList() {
		return contactList;
	}

	public void setContactList(String contactList) {
		this.contactList = contactList;
	}

	public String getEmailCampaigns() {
		return emailCampaigns;
	}

	public void setEmailCampaigns(String emailCampaigns) {
		this.emailCampaigns = emailCampaigns;
	}

	public String getEmailCampaignId() {
		return emailCampaignId;
	}

	public void setEmailCampaignId(String emailCampaignId) {
		this.emailCampaignId = emailCampaignId;
	}

	public String getEmailCampaignsId() {
		return emailCampaignsId;
	}

	public void setEmailCampaignsId(String emailCampaignsId) {
		this.emailCampaignsId = emailCampaignsId;
	}

	public String getVerifiedEmailAddresses() {
		return verifiedEmailAddresses;
	}

	public void setVerifiedEmailAddresses(String verifiedEmailAddresses) {
		this.verifiedEmailAddresses = verifiedEmailAddresses;
	}

	public String getEmailCampaignsSchedulesId() {
		return emailCampaignsSchedulesId;
	}

	public void setEmailCampaignsSchedulesId(String emailCampaignsSchedulesId) {
		this.emailCampaignsSchedulesId = emailCampaignsSchedulesId;
	}

	public String getEmailCampaignsSchedulesIdAll() {
		return emailCampaignsSchedulesIdAll;
	}

	public void setEmailCampaignsSchedulesIdAll(String emailCampaignsSchedulesIdAll) {
		this.emailCampaignsSchedulesIdAll = emailCampaignsSchedulesIdAll;
	}

	public String getEmailCampaignsTrackingReportsSummary() {
		return emailCampaignsTrackingReportsSummary;
	}

	public void setEmailCampaignsTrackingReportsSummary(
			String emailCampaignsTrackingReportsSummary) {
		this.emailCampaignsTrackingReportsSummary = emailCampaignsTrackingReportsSummary;
	}

	public String getEmailCampaignsTrackingBounces() {
		return emailCampaignsTrackingBounces;
	}

	public void setEmailCampaignsTrackingBounces(
			String emailCampaignsTrackingBounces) {
		this.emailCampaignsTrackingBounces = emailCampaignsTrackingBounces;
	}

	public String getEmailCampaignsTrackingClicks() {
		return emailCampaignsTrackingClicks;
	}

	public void setEmailCampaignsTrackingClicks(String emailCampaignsTrackingClicks) {
		this.emailCampaignsTrackingClicks = emailCampaignsTrackingClicks;
	}

	public String getEmailCampaignsTrackingForwards() {
		return emailCampaignsTrackingForwards;
	}

	public void setEmailCampaignsTrackingForwards(
			String emailCampaignsTrackingForwards) {
		this.emailCampaignsTrackingForwards = emailCampaignsTrackingForwards;
	}

	public String getEmailCampaignsTrackingOpens() {
		return emailCampaignsTrackingOpens;
	}

	public void setEmailCampaignsTrackingOpens(String emailCampaignsTrackingOpens) {
		this.emailCampaignsTrackingOpens = emailCampaignsTrackingOpens;
	}

	public String getEmailCampaignsTrackingSends() {
		return emailCampaignsTrackingSends;
	}

	public void setEmailCampaignsTrackingSends(String emailCampaignsTrackingSends) {
		this.emailCampaignsTrackingSends = emailCampaignsTrackingSends;
	}

	public String getEmailCampaignsTrackingUnsubscribes() {
		return emailCampaignsTrackingUnsubscribes;
	}

	public void setEmailCampaignsTrackingUnsubscribes(
			String emailCampaignsTrackingUnsubscribes) {
		this.emailCampaignsTrackingUnsubscribes = emailCampaignsTrackingUnsubscribes;
	}

	public String getEmailCampaignsTrackingClicksByLink() {
		return emailCampaignsTrackingClicksByLink;
	}

	public void setEmailCampaignsTrackingClicksByLink(
			String emailCampaignsTrackingClicksByLink) {
		this.emailCampaignsTrackingClicksByLink = emailCampaignsTrackingClicksByLink;
	}

	public String getContactsTrackingReportsSummary() {
		return contactsTrackingReportsSummary;
	}

	public void setContactsTrackingReportsSummary(
			String contactsTrackingReportsSummary) {
		this.contactsTrackingReportsSummary = contactsTrackingReportsSummary;
	}

	public String getContactsTrackingReportsByCampaignSummary() {
		return contactsTrackingReportsByCampaignSummary;
	}

	public void setContactsTrackingReportsByCampaignSummary(
			String contactsTrackingReportsByCampaignSummary) {
		this.contactsTrackingReportsByCampaignSummary = contactsTrackingReportsByCampaignSummary;
	}

	public String getContactsTrackingAll() {
		return contactsTrackingAll;
	}

	public void setContactsTrackingAll(String contactsTrackingAll) {
		this.contactsTrackingAll = contactsTrackingAll;
	}

	public String getContactsTrackingBounces() {
		return contactsTrackingBounces;
	}

	public void setContactsTrackingBounces(String contactsTrackingBounces) {
		this.contactsTrackingBounces = contactsTrackingBounces;
	}

	public String getContactsTrackingClicks() {
		return contactsTrackingClicks;
	}

	public void setContactsTrackingClicks(String contactsTrackingClicks) {
		this.contactsTrackingClicks = contactsTrackingClicks;
	}

	public String getContactsTrackingForwards() {
		return contactsTrackingForwards;
	}

	public void setContactsTrackingForwards(String contactsTrackingForwards) {
		this.contactsTrackingForwards = contactsTrackingForwards;
	}

	public String getContactsTrackingOpens() {
		return contactsTrackingOpens;
	}

	public void setContactsTrackingOpens(String contactsTrackingOpens) {
		this.contactsTrackingOpens = contactsTrackingOpens;
	}

	public String getContactsTrackingSends() {
		return contactsTrackingSends;
	}

	public void setContactsTrackingSends(String contactsTrackingSends) {
		this.contactsTrackingSends = contactsTrackingSends;
	}

	public String getContactsTrackingUnsubscribes() {
		return contactsTrackingUnsubscribes;
	}

	public void setContactsTrackingUnsubscribes(String contactsTrackingUnsubscribes) {
		this.contactsTrackingUnsubscribes = contactsTrackingUnsubscribes;
	}

	public String getActivitiesAddContacts() {
		return activitiesAddContacts;
	}

	public void setActivitiesAddContacts(String activitiesAddContacts) {
		this.activitiesAddContacts = activitiesAddContacts;
	}

	public String getActivitiesRemoveFromLists() {
		return activitiesRemoveFromLists;
	}

	public void setActivitiesRemoveFromLists(String activitiesRemoveFromLists) {
		this.activitiesRemoveFromLists = activitiesRemoveFromLists;
	}

	public String getActivitiesClearLists() {
		return activitiesClearLists;
	}

	public void setActivitiesClearLists(String activitiesClearLists) {
		this.activitiesClearLists = activitiesClearLists;
	}

	public String getActivitiesExportContacts() {
		return activitiesExportContacts;
	}

	public void setActivitiesExportContacts(String activitiesExportContacts) {
		this.activitiesExportContacts = activitiesExportContacts;
	}

	public String getActivities() {
		return activities;
	}

	public void setActivities(String activities) {
		this.activities = activities;
	}

	public String getLibraryInfo() {
		return libraryInfo;
	}

	public void setLibraryInfo(String libraryInfo) {
		this.libraryInfo = libraryInfo;
	}

	public String getLibraryFiles() {
		return libraryFiles;
	}

	public void setLibraryFiles(String libraryFiles) {
		this.libraryFiles = libraryFiles;
	}

	public String getLibraryFilesByFolder() {
		return libraryFilesByFolder;
	}

	public void setLibraryFilesByFolder(String libraryFilesByFolder) {
		this.libraryFilesByFolder = libraryFilesByFolder;
	}

	public String getLibraryFolders() {
		return libraryFolders;
	}

	public void setLibraryFolders(String libraryFolders) {
		this.libraryFolders = libraryFolders;
	}

	public String getLibraryFolder() {
		return libraryFolder;
	}

	public void setLibraryFolder(String libraryFolder) {
		this.libraryFolder = libraryFolder;
	}

	public String getLibraryFolderTrash() {
		return libraryFolderTrash;
	}

	public void setLibraryFolderTrash(String libraryFolderTrash) {
		this.libraryFolderTrash = libraryFolderTrash;
	}

	public String getLibraryFile() {
		return libraryFile;
	}

	public void setLibraryFile(String libraryFile) {
		this.libraryFile = libraryFile;
	}

	public String getLibraryFileUploadStatus() {
		return libraryFileUploadStatus;
	}

	public void setLibraryFileUploadStatus(String libraryFileUploadStatus) {
		this.libraryFileUploadStatus = libraryFileUploadStatus;
	}

	public String getLibraryFileMove() {
		return libraryFileMove;
	}

	public void setLibraryFileMove(String libraryFileMove) {
		this.libraryFileMove = libraryFileMove;
	}

	public String getEvents() {
		return events;
	}

	public void setEvents(String events) {
		this.events = events;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventFees() {
		return eventFees;
	}

	public void setEventFees(String eventFees) {
		this.eventFees = eventFees;
	}

	public String getEventFeeId() {
		return eventFeeId;
	}

	public void setEventFeeId(String eventFeeId) {
		this.eventFeeId = eventFeeId;
	}

	public String getEventPromocodes() {
		return eventPromocodes;
	}

	public void setEventPromocodes(String eventPromocodes) {
		this.eventPromocodes = eventPromocodes;
	}

	public String getEventPromocodeId() {
		return eventPromocodeId;
	}

	public void setEventPromocodeId(String eventPromocodeId) {
		this.eventPromocodeId = eventPromocodeId;
	}

	public String getEventRegistrants() {
		return eventRegistrants;
	}

	public void setEventRegistrants(String eventRegistrants) {
		this.eventRegistrants = eventRegistrants;
	}

	public String getEventRegistrantId() {
		return eventRegistrantId;
	}

	public void setEventRegistrantId(String eventRegistrantId) {
		this.eventRegistrantId = eventRegistrantId;
	}

	public String getEventItems() {
		return eventItems;
	}

	public void setEventItems(String eventItems) {
		this.eventItems = eventItems;
	}

	public String getEventItemId() {
		return eventItemId;
	}

	public void setEventItemId(String eventItemId) {
		this.eventItemId = eventItemId;
	}

	public String getEventItemAttributes() {
		return eventItemAttributes;
	}

	public void setEventItemAttributes(String eventItemAttributes) {
		this.eventItemAttributes = eventItemAttributes;
	}

	public String getEventItemAttributeId() {
		return eventItemAttributeId;
	}

	public void setEventItemAttributeId(String eventItemAttributeId) {
		this.eventItemAttributeId = eventItemAttributeId;
	}

	public String getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(String accountInfo) {
		this.accountInfo = accountInfo;
	}

	

	/**
	 * Login related configuration options in Constant Contact.<br/>
	 * These are used for the login part of the authentication flow.
	 *
	 * @author ConstantContact
	 */
	public static final class Login {
		/**
		 * The login base URL.
		 */
		public static final String BASE_URL = "https://login.constantcontact.com/login/";

		/**
		 * Login endpoint.
		 */
		public static final String LOGIN_ENDPOINT = "oauth/login";

		/**
		 * Request host.
		 */
		public static final String HOST = "login.constantcontact.com";

		/**
		 * Default constructor.<br/>
		 * Made private to prevent instantiation.<br/>
		 * This is unreachable from the outside, since current class is used
		 * only as a repository for constants.
		 */
		private Login() {
		}
	}

	/**
	 * Errors to be returned for various exceptions in the Constant Contact
	 * flow.
	 *
	 * @author ConstantContact
	 */
	public static final class Errors {

		/**
		 * Contact or id error.
		 */
		public static final String CONTACT_OR_ID = "Only an interger or Contact are allowed for this method.";

		/**
		 * List or id error.
		 */
		public static final String LIST_OR_ID = "Only an integer or ContactList are allowed for this method.";

		/**
		 * Id error.
		 */
		public static final String ID = "Only a numeric String is allowed for this method.";

		/**
		 * Status error.
		 */
		public static final String STATUS = "Status parameter must be one of the values: ";

		/**
		 * EmailCampaignSchedule null error.
		 */
		public static final String EMAIL_CAMPAIGN_SCHEDULE_NULL = "EmailCampaignSchedule parameter must not be null.";

		/**
		 * Contacts Request null error.
		 */
		public static final String BULK_CONTACTS_REQUEST_NULL = "ContactsRequest parameter must not be null.";

		/**
		 * Contacts ListId null error.
		 */
		public static final String BULK_CONTACTS_LIST_NULL = "ListIds parameter must not be null.";

		/**
		 * File Name null error.
		 */
		public static final String FILE_NAME_NULL = "FileName parameter must not be null.";

		/**
		 * File null error.
		 */
		public static final String FILE_NULL = "File parameter must not be null.";

		/**
		 * MyLibrary Folder null error;
		 */
		public static final String FOLDER_NULL = "Folder parameter must not be null";

		/**
		 * MyLibrary FolderId null error;
		 */
		public static final String FOLDER_ID_NULL = "FolderId parameter must not be null";

		/**
		 * MyLibrary FolderId null error;
		 */
		public static final String FILE_ID_NULL = "FileId parameter must not be null";

		/**
		 * Pagination null error
		 */
		public static final String PAGINATION_NULL = "Pagination parameter must not be null";

		public static final String MY_LIBRARY_IMAGE_SOURCE_NULL = "Image Source parameter must not be null";

		public static final String MY_LIBRARY_DESCRIPTION_NULL = "Description must not be null";

		public static final String MY_LIBRARY_FILE_TYPE_NULL = "File type must not be null";

		/**
		 * EventId null error;
		 */
		public static final String EVENT_ID = "EventId must not be null";

		/**
		 * Event FeeId null error;
		 */
		public static final String EVENT_FEE_ID = "EventFeeId must not be null";

		/**
		 * Event null error;
		 */
		public static final String EVENT = "Event must not be null";

		/**
		 * Event Fee null error;
		 */
		public static final String EVENT_FEE = "Event fee must not be null";

		/**
		 * Promocode null error;
		 */
		public static final String PROMOCODE = "Promocode must not be null";

		/**
		 * PromocodeId null error;
		 */
		public static final String PROMOCODE_ID = "PromocodeId must not be null";

		/**
		 * Event RegistrantId null error;
		 */
		public static final String REGISTRANT_ID = "RegistrantId must not be null";

		/**
		 * Event ItemId null error;
		 */
		public static final String EVENT_ITEM_ID = "ItemId must not be null";

		/**
		 * Event Item null error;
		 */
		public static final String EVENT_ITEM = "EventItem must not be null";

		/**
		 * Event Item AttributeId null error;
		 */
		public static final String EVENT_ITEM_ATTRIBUTE_ID = "AttributeId must not be null";

		/**
		 * Event Item Attribute null error;
		 */
		public static final String EVENT_ITEM_ATTRIBUTE = "Item Attribute must not be null";

		/**
		 * Account Info null error;
		 */
		public static final String ACCOUNT_INFO = "Account Info must not be null";

		/**
		 * Invalid Webhook error;
		 */
		public static final String INVALID_WEBHOOK = "Invalid Webhook. The x-ctct-hmac-sha256 does not correspond to message encryption.";

		/**
		 * Client Secret null error;
		 */
		public static final String NO_CLIENT_SECRET = "You must provide the client secret (via constructor or setClientSecret() ) corresponding to "
				+ "your API   from Constant Contact";

		/**
		 * Default constructor.<br/>
		 * Made private to prevent instantiation.<br/>
		 * This is unreachable from the outside, since current class is used
		 * only as a repository for constants.
		 */
		private Errors() {
		}
	}

	/**
	 * HTTP Return Codes in Constant Contact flow.
	 *
	 * @author ConstantContact
	 */
	public static final class HTTP_CODES {

		/**
		 * Code for 201 Campaign Schedule was successfully created
		 */
		public static final int EMAIL_CAMPAIGN_SCHEDULE_CREATED = 201;

		/**
		 * Default constructor.<br/>
		 * Made private to prevent instantiation.<br/>
		 * This is unreachable from the outside, since current class is used
		 * only as a repository for constants.
		 */
		private HTTP_CODES() {
		}
	}

	/**
	 * Accept header value.
	 */
	public static final String HEADER_ACCEPT = "text/html, application/xhtml+xml, */*";

	/**
	 * ContentType header value.
	 */
	public static final String HEADER_CONTENT_TYPE = "application/x-www-form-urlencoded";

	/**
	 * UserAgent header value
	 */
	public static final String HEADER_USER_AGENT = "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)";

	/**
	 * UTF-8
	 */
	public static final String UTF_8 = "UTF-8";

}
