package com.constantcontact.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Main Configuration structure in Constant Contact.
 *
 * @author ConstantContact
 */
public final class Config
{

    private static Config instance;
    private static final String CTCT_API_PROPERTIES = "ctct_api.properties";

    /**
     * Private Constructor
     */
    private Config()
    {
        loadProperties();
    }

<<<<<<< HEAD
        /**
         * API access URL.
         */
        public static final String BASE_URL = BASE_URL_HOST + "/" + "v2/";

        /**
         * Access a contact.
         */
        public static final String CONTACT = "contacts/%1$s";

        /**
         * Get all contacts.
         */
        public static final String CONTACTS = "contacts";

        /**
         * Get all lists.
         */
        public static final String LISTS = "lists";

        /**
         * Access a specified list.
         */
        public static final String LIST = "lists/%1$s";

        /**
         * Get the list of contacts from a list.
         */
        public static final String LIST_CONTACTS = "lists/%1$s/contacts";

        /**
         * Get contact lists.
         */
        public static final String CONTACT_LISTS = "contacts/%1$s/lists";

        /**
         * Get a list from contact lists.
         */
        public static final String CONTACT_LIST = "contacts/%1$s/lists/%2$s";

        /**
         * Get campaigns.
         */
        public static final String EMAILCAMPAIGNS = "emailmarketing/campaigns";

        /**
         * Access a campaign.
         */
        public static final String EMAILCAMPAIGN_ID = "emailmarketing/campaigns/%1$s";

        /**
         * Access a campaign. This is for PUT operations.
         */
        public static final String EMAILCAMPAIGNS_ID = "emailmarketing/campaigns/%1$s";

        /**
         * Get verified email addresses.
         */
        public static final String VERIFIEDEMAILADDRESSES = "account/verifiedemailaddresses";

        /**
         * Access a campaign schedule.
         */
        public static final String EMAILCAMPAIGNS_SCHEDULES_ID = "emailmarketing/campaigns/%1$s/schedules/%2$s";

        /**
         * Access all campaign schedules.
         */
        public static final String EMAILCAMPAIGNS_SCHEDULES_ID_ALL = "emailmarketing/campaigns/%1$s/schedules";

        /**
         * Access email campaign tracking reports summary for a given email campaign.
         */
        public static final String EMAILCAMPAIGNS_TRACKING_REPORTS_SUMMARY = "emailmarketing/campaigns/%1$s/tracking/reports/summary";

        /**
         * Access email campaign tracking bounces for a given email campaign.
         */
        public static final String EMAILCAMPAIGNS_TRACKING_BOUNCES = "emailmarketing/campaigns/%1$s/tracking/bounces";

        /**
         * Access email campaign tracking clicks for a given email campaign.
         */
        public static final String EMAILCAMPAIGNS_TRACKING_CLICKS = "emailmarketing/campaigns/%1$s/tracking/clicks";

        /**
         * Access email campaign tracking forwards for a given email campaign.
         */
        public static final String EMAILCAMPAIGNS_TRACKING_FORWARDS = "emailmarketing/campaigns/%1$s/tracking/forwards";

        /**
         * Access email campaign tracking opens for a given email campaign.
         */
        public static final String EMAILCAMPAIGNS_TRACKING_OPENS = "emailmarketing/campaigns/%1$s/tracking/opens";

        /**
         * Access email campaign tracking sends for a given email campaign.
         */
        public static final String EMAILCAMPAIGNS_TRACKING_SENDS = "emailmarketing/campaigns/%1$s/tracking/sends";

        /**
         * Access email campaign tracking unsubscribes for a given email campaign.
         */
        public static final String EMAILCAMPAIGNS_TRACKING_UNSUBSCRIBES = "emailmarketing/campaigns/%1$s/tracking/unsubscribes";

        /**
         * Access email campaign tracking clicks by link for a given email campaign.
         */
        public static final String EMAILCAMPAIGNS_TRACKING_CLICKS_BY_LINK = "emailmarketing/campaigns/%1$s/tracking/clicks/%2$s";

        /**
         * Access contact tracking reports summary for a given contact.
         */
        public static final String CONTACTS_TRACKING_REPORTS_SUMMARY = "contacts/%1$s/tracking/reports/summary";

        /**
         * Access contact tracking reports summary for a given contact.
         */
        public static final String CONTACTS_TRACKING_REPORTS_BY_CAMPAIGN_SUMMARY = "contacts/%1$s/tracking/reports/summaryByCampaign";

        /**
         * Access contact tracking activities for a given contact.
         */
        public static final String CONTACTS_TRACKING_ALL = "contacts/%1$s/tracking/";

        /**
         * Access contact tracking bounces for a given contact.
         */
        public static final String CONTACTS_TRACKING_BOUNCES = "contacts/%1$s/tracking/bounces";

        /**
         * Access contact tracking clicks for a given contact.
         */
        public static final String CONTACTS_TRACKING_CLICKS = "contacts/%1$s/tracking/clicks";

        /**
         * Access contact tracking forwards for a given contact.
         */
        public static final String CONTACTS_TRACKING_FORWARDS = "contacts/%1$s/tracking/forwards";

        /**
         * Access contact tracking opens for a given contact.
         */
        public static final String CONTACTS_TRACKING_OPENS = "contacts/%1$s/tracking/opens";

        /**
         * Access contact tracking sends for a given contact.
         */
        public static final String CONTACTS_TRACKING_SENDS = "contacts/%1$s/tracking/sends";

        /**
         * Access contact tracking unsubscribes for a given contact.
         */
        public static final String CONTACTS_TRACKING_UNSUBSCRIBES = "contacts/%1$s/tracking/unsubscribes";

        /**
         * Endpoint for the bulk contacts upload.
         */
        public static final String ACTIVITIES_ADD_CONTACTS = "activities/addcontacts";

        /**
         * Endpoint for the bulk contacts remove from lists.
         */
        public static final String ACTIVITIES_REMOVE_FROM_LISTS = "activities/removefromlists";

        /**
         * Endpoint for the bulk clear lists.
         */
        public static final String ACTIVITIES_CLEAR_LISTS = "activities/clearlists";

        /**
         * Endpoint for the bulk export contacts.
         */
        public static final String ACTIVITIES_EXPORT_CONTACTS = "activities/exportcontacts";

        /**
         * Endpoint for the bulk activities retrieve.
         */
        public static final String ACTIVITIES = "activities";
        public static final String ACTIVITY = "activities/%1$s";

        public static final String LIBRARY_INFO = "library/info";
        public static final String LIBRARY_FILES = "library/files";
        public static final String LIBRARY_FILES_BY_FOLDER = "library/folders/%1$s/files";
        public static final String LIBRARY_FOLDERS = "library/folders";

        public static final String LIBRARY_FOLDER = LIBRARY_FOLDERS + "/%1$s";
        public static final String LIBRARY_FOLDER_TRASH = LIBRARY_FOLDERS + "/trash/files";

        public static final String LIBRARY_FILE = LIBRARY_FILES + "/%1$s";
        public static final String LIBRARY_FILE_UPLOAD_STATUS = LIBRARY_FILES + "/uploadstatus/%1$s";

        public static final String LIBRARY_FILE_MOVE = "library/folders/%1$s/files";

        /**
         * Endpoint for the list of events.
         */
        public static final String EVENTS = "eventspot/events/";

        /**
         * Endpoint for accessing a single event.
         */
        public static final String EVENT_ID = EVENTS + "%1$s";

        /**
         * Endpoint for the list of event fees.
         */
        public static final String EVENT_FEES = EVENTS + "%1$s/fees";

        /**
         * Endpoint for accessing a single event fee.
         */
        public static final String EVENT_FEE_ID = EVENTS + "%1$s/fees/%2$s";

        /**
         * Endpoint for the list of the event's promocodes.
         */
        public static final String EVENT_PROMOCODES = EVENTS + "%1$s/promocodes/";

        /**
         * Endpoint for accessing a single event promocode.
         */
        public static final String EVENT_PROMOCODE_ID = EVENTS + "%1$s/promocodes/%2$s";

        /**
         * Endpoint for the list of event registrants.
         */
        public static final String EVENT_REGISTRANTS = EVENTS + "%1$s/registrants";

        /**
         * Endpoint for accessing a single event registrant.
         */
        public static final String EVENT_REGISTRANT_ID = EVENTS + "%1$s/registrants/%2$s";

        /**
         * Endpoint for the list of event items.
         */
        public static final String EVENT_ITEMS = EVENTS + "%1$s/items/";

        /**
         * Endpoint for accessing a single event item.
         */
        public static final String EVENT_ITEM_ID = EVENTS + "%1$s/items/%2$s";

        /**
         * Endpoint for the list of event item attributes.
         */
        public static final String EVENT_ITEM_ATTRIBUTES = EVENTS + "%1$s/items/%2$s/attributes";

        /**
         * Endpoint for accessing a event item attribute.
         */
        public static final String EVENT_ITEM_ATTRIBUTE_ID = EVENTS + "%1$s/items/%2$s/attributes/%3$s";

        /**
         * Endpoint for accessing the account info.
         */
        public static final String ACCOUNT_INFO = "account/info";

        /**
         * Default constructor.<br/>
         * Made private to prevent instantiation.<br/>
         * This is unreachable from the outside, since current class is used only as a repository for constants.
         */
        private Endpoints() {
=======
    /**
     * Singleton
     * 
     * @return
     */
    public static Config instance()
    {
        if (instance == null)
        {
            instance = new Config();
>>>>>>> 148a2af3efc1ccdc3b6e30fe3cf343c22cd07b9c
        }
        return instance;
    }

    private void loadProperties()
    {
        Properties prop = new Properties();
        InputStream input = null;

        try
        {

            input = Config.class.getClassLoader().getResourceAsStream(CTCT_API_PROPERTIES);

            if (input != null)
            {
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
            loginBaseUrl = prop.getProperty("constantcontact.api.login.baseurl");
            loginEndpoint = prop.getProperty("constantcontact.api.login.loginendpoint");
            loginHost = prop.getProperty("constantcontact.api.login.host");
            errorContactOrId = prop.getProperty("constantcontact.api.errors.contactorid");
            errorListOrId = prop.getProperty("constantcontact.api.errors.listorid");
            errorId = prop.getProperty("constantcontact.api.errors.id");
            errorStatus = prop.getProperty("constantcontact.api.errors.status");
            errorEmailCampaignScheduleNull = prop.getProperty("constantcontact.api.errors.emailcampaignschedulenull");
            errorBulkContactsRequestNull = prop.getProperty("constantcontact.api.errors.bulkcontactsrequestnull");
            errorBulkContactsListNull = prop.getProperty("constantcontact.api.errors.bulkcontactslistnull");
            errorFileNameNull = prop.getProperty("constantcontact.api.errors.filenamenull");
            errorFileNull = prop.getProperty("constantcontact.api.errors.filenull");
            errorFolderNull = prop.getProperty("constantcontact.api.errors.foldernull");
            errorFolderIdNull = prop.getProperty("constantcontact.api.errors.folderidnull");
            errorFileIdNull = prop.getProperty("constantcontact.api.errors.fileidnull");
            errorPaginationNull = prop.getProperty("constantcontact.api.errors.paginationnull");
            errorMyLibraryImageSourceNull = prop.getProperty("constantcontact.api.errors.mylibraryimagesourcenull");
            errorMyLibraryDescriptionNull = prop.getProperty("constantcontact.api.errors.mylibrarydescriptionnull");
            errorMyLibraryFileTypeNull = prop.getProperty("constantcontact.api.errors.mylibraryfiletypenull");
            errorEventId = prop.getProperty("constantcontact.api.errors.eventid");
            errorEventFeeId = prop.getProperty("constantcontact.api.errors.eventfeeid");
            errorEvent = prop.getProperty("constantcontact.api.errors.event");
            errorEventFee = prop.getProperty("constantcontact.api.errors.eventfee");
            errorPromocode = prop.getProperty("constantcontact.api.errors.promocode");
            errorPromocodeId = prop.getProperty("constantcontact.api.errors.promocodeid");
            errorRegistrantId = prop.getProperty("constantcontact.api.errors.registrantid");
            errorEventItemId = prop.getProperty("constantcontact.api.errors.eventitemid");
            errorEventItem = prop.getProperty("constantcontact.api.errors.eventitem");
            errorEventItemAttributeId = prop.getProperty("constantcontact.api.errors.eventitemattributeid");
            errorEventItemAttribute = prop.getProperty("constantcontact.api.errors.eventitemattribute");
            errorAccountInfo = prop.getProperty("constantcontact.api.errors.accountinfo");
            errorInvalidWebhook = prop.getProperty("constantcontact.api.errors.invalidwebhook");
            errorNoClientSecret = prop.getProperty("constantcontact.api.errors.noclientsecret");
            emailCampaignScheduleCreated = Integer.parseInt(prop.getProperty("constantcontact.api.httpcodes.emailcampaignschedulecreated"));
            headerAccept = prop.getProperty("constantcontact.api.headeraccept");
            headerContentType = prop.getProperty("constantcontact.api.headerContentType");
            headerUserAgent = prop.getProperty("constantcontact.api.headeruseragent");
            utf8 = prop.getProperty("constantcontact.api.utf8");

        }
        catch (IOException e)
        {
            throw new IllegalStateException("Cannot configure connection to Constant Contact", e);
        }
        finally
        {
            if (input != null)
            {
                try
                {
                    input.close();
                }
                catch (IOException ignoreMe)
                {

                }
            }
        }
    }

    /**
     * API access URL Host.
     */
    private String baseUrl;

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
    private String accountInfo;

    /**
     * The login base URL.
     */
    private String loginBaseUrl;

    /**
     * Login endpoint.
     */
    private String loginEndpoint;

    /**
     * Request host.
     */
    public String loginHost;

    /**
     * Contact or id error.
     */
    private String errorContactOrId;

    /**
     * List or id error.
     */
    private String errorListOrId;

    /**
     * Id error.
     */
    private String errorId;

    /**
     * Status error.
     */
    private String errorStatus;

    /**
     * EmailCampaignSchedule null error.
     */
    private String errorEmailCampaignScheduleNull;

    /**
     * Contacts Request null error.
     */
    private String errorBulkContactsRequestNull;

    /**
     * Contacts ListId null error.
     */
    private String errorBulkContactsListNull;

    /**
     * File Name null error.
     */
    private String errorFileNameNull;

    /**
     * File null error.
     */
    private String errorFileNull;

    /**
     * MyLibrary Folder null error;
     */
    private String errorFolderNull;

    /**
     * MyLibrary FolderId null error;
     */
    private String errorFolderIdNull;

    /**
     * MyLibrary FolderId null error;
     */
    private String errorFileIdNull;

    /**
     * Pagination null error
     */
    private String errorPaginationNull;

    private String errorMyLibraryImageSourceNull;

    private String errorMyLibraryDescriptionNull;

    private String errorMyLibraryFileTypeNull;

    /**
     * EventId null error;
     */
    private String errorEventId;

    /**
     * Event FeeId null error;
     */
    private String errorEventFeeId;

    /**
     * Event null error;
     */
    private String errorEvent;

    /**
     * Event Fee null error;
     */
    private String errorEventFee;

    /**
     * Promocode null error;
     */
    private String errorPromocode;

    /**
     * PromocodeId null error;
     */
    private String errorPromocodeId;

    /**
     * Event RegistrantId null error;
     */
    private String errorRegistrantId;

    /**
     * Event ItemId null error;
     */
    private String errorEventItemId;

    /**
     * Event Item null error;
     */
    private String errorEventItem;

    /**
     * Event Item AttributeId null error;
     */
    private String errorEventItemAttributeId;

    /**
     * Event Item Attribute null error;
     */
    private String errorEventItemAttribute;

    /**
     * Account Info null error;
     */
    private String errorAccountInfo;

    /**
     * Invalid Webhook error;
     */
    private String errorInvalidWebhook;

    /**
     * Client Secret null error;
     */
    private String errorNoClientSecret;

    private int emailCampaignScheduleCreated;

    /**
     * Accept header value.
     */
    private String headerAccept;

    /**
     * ContentType header value.
     */
    private String headerContentType;

    /**
     * UserAgent header value
     */
    private String headerUserAgent;

    /**
     * UTF-8
     */
    private String utf8;

    public String getBaseUrl()
    {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl)
    {
        this.baseUrl = baseUrl;
    }

    public String getContact()
    {
        return contact;
    }

    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public String getContacts()
    {
        return contacts;
    }

    public void setContacts(String contacts)
    {
        this.contacts = contacts;
    }

    public String getLists()
    {
        return lists;
    }

    public void setLists(String lists)
    {
        this.lists = lists;
    }

    public String getList()
    {
        return list;
    }

    public void setList(String list)
    {
        this.list = list;
    }

    public String getListContacts()
    {
        return listContacts;
    }

    public void setListContacts(String listContacts)
    {
        this.listContacts = listContacts;
    }

    public String getContactLists()
    {
        return contactLists;
    }

    public void setContactLists(String contactLists)
    {
        this.contactLists = contactLists;
    }

    public String getContactList()
    {
        return contactList;
    }

    public void setContactList(String contactList)
    {
        this.contactList = contactList;
    }

    public String getEmailCampaigns()
    {
        return emailCampaigns;
    }

    public void setEmailCampaigns(String emailCampaigns)
    {
        this.emailCampaigns = emailCampaigns;
    }

    public String getEmailCampaignId()
    {
        return emailCampaignId;
    }

    public void setEmailCampaignId(String emailCampaignId)
    {
        this.emailCampaignId = emailCampaignId;
    }

    public String getEmailCampaignsId()
    {
        return emailCampaignsId;
    }

    public void setEmailCampaignsId(String emailCampaignsId)
    {
        this.emailCampaignsId = emailCampaignsId;
    }

    public String getVerifiedEmailAddresses()
    {
        return verifiedEmailAddresses;
    }

    public void setVerifiedEmailAddresses(String verifiedEmailAddresses)
    {
        this.verifiedEmailAddresses = verifiedEmailAddresses;
    }

    public String getEmailCampaignsSchedulesId()
    {
        return emailCampaignsSchedulesId;
    }

    public void setEmailCampaignsSchedulesId(String emailCampaignsSchedulesId)
    {
        this.emailCampaignsSchedulesId = emailCampaignsSchedulesId;
    }

    public String getEmailCampaignsSchedulesIdAll()
    {
        return emailCampaignsSchedulesIdAll;
    }

    public void setEmailCampaignsSchedulesIdAll(String emailCampaignsSchedulesIdAll)
    {
        this.emailCampaignsSchedulesIdAll = emailCampaignsSchedulesIdAll;
    }

    public String getEmailCampaignsTrackingReportsSummary()
    {
        return emailCampaignsTrackingReportsSummary;
    }

    public void setEmailCampaignsTrackingReportsSummary(
            String emailCampaignsTrackingReportsSummary)
    {
        this.emailCampaignsTrackingReportsSummary = emailCampaignsTrackingReportsSummary;
    }

    public String getEmailCampaignsTrackingBounces()
    {
        return emailCampaignsTrackingBounces;
    }

    public void setEmailCampaignsTrackingBounces(
            String emailCampaignsTrackingBounces)
    {
        this.emailCampaignsTrackingBounces = emailCampaignsTrackingBounces;
    }

    public String getEmailCampaignsTrackingClicks()
    {
        return emailCampaignsTrackingClicks;
    }

    public void setEmailCampaignsTrackingClicks(String emailCampaignsTrackingClicks)
    {
        this.emailCampaignsTrackingClicks = emailCampaignsTrackingClicks;
    }

    public String getEmailCampaignsTrackingForwards()
    {
        return emailCampaignsTrackingForwards;
    }

    public void setEmailCampaignsTrackingForwards(
            String emailCampaignsTrackingForwards)
    {
        this.emailCampaignsTrackingForwards = emailCampaignsTrackingForwards;
    }

    public String getEmailCampaignsTrackingOpens()
    {
        return emailCampaignsTrackingOpens;
    }

    public void setEmailCampaignsTrackingOpens(String emailCampaignsTrackingOpens)
    {
        this.emailCampaignsTrackingOpens = emailCampaignsTrackingOpens;
    }

    public String getEmailCampaignsTrackingSends()
    {
        return emailCampaignsTrackingSends;
    }

    public void setEmailCampaignsTrackingSends(String emailCampaignsTrackingSends)
    {
        this.emailCampaignsTrackingSends = emailCampaignsTrackingSends;
    }

    public String getEmailCampaignsTrackingUnsubscribes()
    {
        return emailCampaignsTrackingUnsubscribes;
    }

    public void setEmailCampaignsTrackingUnsubscribes(
            String emailCampaignsTrackingUnsubscribes)
    {
        this.emailCampaignsTrackingUnsubscribes = emailCampaignsTrackingUnsubscribes;
    }

    public String getEmailCampaignsTrackingClicksByLink()
    {
        return emailCampaignsTrackingClicksByLink;
    }

    public void setEmailCampaignsTrackingClicksByLink(
            String emailCampaignsTrackingClicksByLink)
    {
        this.emailCampaignsTrackingClicksByLink = emailCampaignsTrackingClicksByLink;
    }

    public String getContactsTrackingReportsSummary()
    {
        return contactsTrackingReportsSummary;
    }

    public void setContactsTrackingReportsSummary(
            String contactsTrackingReportsSummary)
    {
        this.contactsTrackingReportsSummary = contactsTrackingReportsSummary;
    }

    public String getContactsTrackingReportsByCampaignSummary()
    {
        return contactsTrackingReportsByCampaignSummary;
    }

    public void setContactsTrackingReportsByCampaignSummary(
            String contactsTrackingReportsByCampaignSummary)
    {
        this.contactsTrackingReportsByCampaignSummary = contactsTrackingReportsByCampaignSummary;
    }

    public String getContactsTrackingAll()
    {
        return contactsTrackingAll;
    }

    public void setContactsTrackingAll(String contactsTrackingAll)
    {
        this.contactsTrackingAll = contactsTrackingAll;
    }

    public String getContactsTrackingBounces()
    {
        return contactsTrackingBounces;
    }

    public void setContactsTrackingBounces(String contactsTrackingBounces)
    {
        this.contactsTrackingBounces = contactsTrackingBounces;
    }

    public String getContactsTrackingClicks()
    {
        return contactsTrackingClicks;
    }

    public void setContactsTrackingClicks(String contactsTrackingClicks)
    {
        this.contactsTrackingClicks = contactsTrackingClicks;
    }

    public String getContactsTrackingForwards()
    {
        return contactsTrackingForwards;
    }

    public void setContactsTrackingForwards(String contactsTrackingForwards)
    {
        this.contactsTrackingForwards = contactsTrackingForwards;
    }

    public String getContactsTrackingOpens()
    {
        return contactsTrackingOpens;
    }

    public void setContactsTrackingOpens(String contactsTrackingOpens)
    {
        this.contactsTrackingOpens = contactsTrackingOpens;
    }

    public String getContactsTrackingSends()
    {
        return contactsTrackingSends;
    }

    public void setContactsTrackingSends(String contactsTrackingSends)
    {
        this.contactsTrackingSends = contactsTrackingSends;
    }

    public String getContactsTrackingUnsubscribes()
    {
        return contactsTrackingUnsubscribes;
    }

    public void setContactsTrackingUnsubscribes(String contactsTrackingUnsubscribes)
    {
        this.contactsTrackingUnsubscribes = contactsTrackingUnsubscribes;
    }

    public String getActivitiesAddContacts()
    {
        return activitiesAddContacts;
    }

    public void setActivitiesAddContacts(String activitiesAddContacts)
    {
        this.activitiesAddContacts = activitiesAddContacts;
    }

    public String getActivitiesRemoveFromLists()
    {
        return activitiesRemoveFromLists;
    }

    public void setActivitiesRemoveFromLists(String activitiesRemoveFromLists)
    {
        this.activitiesRemoveFromLists = activitiesRemoveFromLists;
    }

    public String getActivitiesClearLists()
    {
        return activitiesClearLists;
    }

    public void setActivitiesClearLists(String activitiesClearLists)
    {
        this.activitiesClearLists = activitiesClearLists;
    }

    public String getActivitiesExportContacts()
    {
        return activitiesExportContacts;
    }

    public void setActivitiesExportContacts(String activitiesExportContacts)
    {
        this.activitiesExportContacts = activitiesExportContacts;
    }

    public String getActivities()
    {
        return activities;
    }

    public void setActivities(String activities)
    {
        this.activities = activities;
    }

    public String getLibraryInfo()
    {
        return libraryInfo;
    }

    public void setLibraryInfo(String libraryInfo)
    {
        this.libraryInfo = libraryInfo;
    }

    public String getLibraryFiles()
    {
        return libraryFiles;
    }

    public void setLibraryFiles(String libraryFiles)
    {
        this.libraryFiles = libraryFiles;
    }

    public String getLibraryFilesByFolder()
    {
        return libraryFilesByFolder;
    }

    public void setLibraryFilesByFolder(String libraryFilesByFolder)
    {
        this.libraryFilesByFolder = libraryFilesByFolder;
    }

    public String getLibraryFolders()
    {
        return libraryFolders;
    }

    public void setLibraryFolders(String libraryFolders)
    {
        this.libraryFolders = libraryFolders;
    }

    public String getLibraryFolder()
    {
        return libraryFolder;
    }

    public void setLibraryFolder(String libraryFolder)
    {
        this.libraryFolder = libraryFolder;
    }

    public String getLibraryFolderTrash()
    {
        return libraryFolderTrash;
    }

    public void setLibraryFolderTrash(String libraryFolderTrash)
    {
        this.libraryFolderTrash = libraryFolderTrash;
    }

    public String getLibraryFile()
    {
        return libraryFile;
    }

    public void setLibraryFile(String libraryFile)
    {
        this.libraryFile = libraryFile;
    }

    public String getLibraryFileUploadStatus()
    {
        return libraryFileUploadStatus;
    }

    public void setLibraryFileUploadStatus(String libraryFileUploadStatus)
    {
        this.libraryFileUploadStatus = libraryFileUploadStatus;
    }

    public String getLibraryFileMove()
    {
        return libraryFileMove;
    }

    public void setLibraryFileMove(String libraryFileMove)
    {
        this.libraryFileMove = libraryFileMove;
    }

    public String getEvents()
    {
        return events;
    }

    public void setEvents(String events)
    {
        this.events = events;
    }

    public String getEventId()
    {
        return eventId;
    }

    public void setEventId(String eventId)
    {
        this.eventId = eventId;
    }

    public String getEventFees()
    {
        return eventFees;
    }

    public void setEventFees(String eventFees)
    {
        this.eventFees = eventFees;
    }

    public String getEventFeeId()
    {
        return eventFeeId;
    }

    public void setEventFeeId(String eventFeeId)
    {
        this.eventFeeId = eventFeeId;
    }

    public String getEventPromocodes()
    {
        return eventPromocodes;
    }

    public void setEventPromocodes(String eventPromocodes)
    {
        this.eventPromocodes = eventPromocodes;
    }

    public String getEventPromocodeId()
    {
        return eventPromocodeId;
    }

    public void setEventPromocodeId(String eventPromocodeId)
    {
        this.eventPromocodeId = eventPromocodeId;
    }

    public String getEventRegistrants()
    {
        return eventRegistrants;
    }

    public void setEventRegistrants(String eventRegistrants)
    {
        this.eventRegistrants = eventRegistrants;
    }

    public String getEventRegistrantId()
    {
        return eventRegistrantId;
    }

    public void setEventRegistrantId(String eventRegistrantId)
    {
        this.eventRegistrantId = eventRegistrantId;
    }

    public String getEventItems()
    {
        return eventItems;
    }

    public void setEventItems(String eventItems)
    {
        this.eventItems = eventItems;
    }

    public String getEventItemId()
    {
        return eventItemId;
    }

    public void setEventItemId(String eventItemId)
    {
        this.eventItemId = eventItemId;
    }

    public String getEventItemAttributes()
    {
        return eventItemAttributes;
    }

    public void setEventItemAttributes(String eventItemAttributes)
    {
        this.eventItemAttributes = eventItemAttributes;
    }

    public String getEventItemAttributeId()
    {
        return eventItemAttributeId;
    }

    public void setEventItemAttributeId(String eventItemAttributeId)
    {
        this.eventItemAttributeId = eventItemAttributeId;
    }

    public String getAccountInfo()
    {
        return accountInfo;
    }

    public void setAccountInfo(String accountInfo)
    {
        this.accountInfo = accountInfo;
    }

    public String getLoginBaseUrl()
    {
        return loginBaseUrl;
    }

    public void setLoginBaseUrl(String loginBaseUrl)
    {
        this.loginBaseUrl = loginBaseUrl;
    }

    public String getLoginEndpoint()
    {
        return loginEndpoint;
    }

    public void setLoginEndpoint(String loginEndpoint)
    {
        this.loginEndpoint = loginEndpoint;
    }

    public String getLoginHost()
    {
        return loginHost;
    }

    public void setLoginHost(String loginHost)
    {
        this.loginHost = loginHost;
    }

    public String getErrorContactOrId()
    {
        return errorContactOrId;
    }

    public void setErrorContactOrId(String errorContactOrId)
    {
        this.errorContactOrId = errorContactOrId;
    }

    public String getErrorListOrId()
    {
        return errorListOrId;
    }

    public void setErrorListOrId(String errorListOrId)
    {
        this.errorListOrId = errorListOrId;
    }

    public String getErrorId()
    {
        return errorId;
    }

    public void setErrorId(String errorId)
    {
        this.errorId = errorId;
    }

    public String getErrorStatus()
    {
        return errorStatus;
    }

    public void setErrorStatus(String errorStatus)
    {
        this.errorStatus = errorStatus;
    }

    public String getErrorEmailCampaignScheduleNull()
    {
        return errorEmailCampaignScheduleNull;
    }

    public void setErrorEmailCampaignScheduleNull(String errorEmailCampaignScheduleNull)
    {
        this.errorEmailCampaignScheduleNull = errorEmailCampaignScheduleNull;
    }

    public String getErrorBulkContactsRequestNull()
    {
        return errorBulkContactsRequestNull;
    }

    public void setErrorBulkContactsRequestNull(String errorBulkContactsRequestNull)
    {
        this.errorBulkContactsRequestNull = errorBulkContactsRequestNull;
    }

    public String getErrorBulkContactsListNull()
    {
        return errorBulkContactsListNull;
    }

    public void setErrorBulkContactsListNull(String errorBulkContactsListNull)
    {
        this.errorBulkContactsListNull = errorBulkContactsListNull;
    }

    public String getErrorFileNameNull()
    {
        return errorFileNameNull;
    }

    public void setErrorFileNameNull(String errorFileNameNull)
    {
        this.errorFileNameNull = errorFileNameNull;
    }

    public String getErrorFileNull()
    {
        return errorFileNull;
    }

    public void setErrorFileNull(String errorFileNull)
    {
        this.errorFileNull = errorFileNull;
    }

    public String getErrorFolderNull()
    {
        return errorFolderNull;
    }

    public void setErrorFolderNull(String errorFolderNull)
    {
        this.errorFolderNull = errorFolderNull;
    }

    public String getErrorFolderIdNull()
    {
        return errorFolderIdNull;
    }

    public void setErrorFolderIdNull(String errorFolderIdNull)
    {
        this.errorFolderIdNull = errorFolderIdNull;
    }

    public String getErrorFileIdNull()
    {
        return errorFileIdNull;
    }

    public void setErrorFileIdNull(String errorFileIdNull)
    {
        this.errorFileIdNull = errorFileIdNull;
    }

    public String getErrorPaginationNull()
    {
        return errorPaginationNull;
    }

    public void setErrorPaginationNull(String errorPaginationNull)
    {
        this.errorPaginationNull = errorPaginationNull;
    }

    public String getErrorMyLibraryImageSourceNull()
    {
        return errorMyLibraryImageSourceNull;
    }

    public void setErrorMyLibraryImageSourceNull(String errorMyLibraryImageSourceNull)
    {
        this.errorMyLibraryImageSourceNull = errorMyLibraryImageSourceNull;
    }

    public String getErrorMyLibraryDescriptionNull()
    {
        return errorMyLibraryDescriptionNull;
    }

    public void setErrorMyLibraryDescriptionNull(String errorMyLibraryDescriptionNull)
    {
        this.errorMyLibraryDescriptionNull = errorMyLibraryDescriptionNull;
    }

    public String getErrorMyLibraryFileTypeNull()
    {
        return errorMyLibraryFileTypeNull;
    }

    public void setErrorMyLibraryFileTypeNull(String errorMyLibraryFileTypeNull)
    {
        this.errorMyLibraryFileTypeNull = errorMyLibraryFileTypeNull;
    }

    public String getErrorEventId()
    {
        return errorEventId;
    }

    public void setErrorEventId(String errorEventId)
    {
        this.errorEventId = errorEventId;
    }

    public String getErrorEventFeeId()
    {
        return errorEventFeeId;
    }

    public void setErrorEventFeeId(String errorEventFeeId)
    {
        this.errorEventFeeId = errorEventFeeId;
    }

    public String getErrorEvent()
    {
        return errorEvent;
    }

    public void setErrorEvent(String errorEvent)
    {
        this.errorEvent = errorEvent;
    }

    public String getErrorEventFee()
    {
        return errorEventFee;
    }

    public void setErrorEventFee(String errorEventFee)
    {
        this.errorEventFee = errorEventFee;
    }

    public String getErrorPromocode()
    {
        return errorPromocode;
    }

    public void setErrorPromocode(String errorPromocode)
    {
        this.errorPromocode = errorPromocode;
    }

    public String getErrorPromocodeId()
    {
        return errorPromocodeId;
    }

    public void setErrorPromocodeId(String errorPromocodeId)
    {
        this.errorPromocodeId = errorPromocodeId;
    }

    public String getErrorRegistrantId()
    {
        return errorRegistrantId;
    }

    public void setErrorRegistrantId(String errorRegistrantId)
    {
        this.errorRegistrantId = errorRegistrantId;
    }

    public String getErrorEventItemId()
    {
        return errorEventItemId;
    }

    public void setErrorEventItemId(String errorEventItemId)
    {
        this.errorEventItemId = errorEventItemId;
    }

    public String getErrorEventItem() {
		return errorEventItem;
	}

	public void setErrorEventItem(String errorEventItem) {
		this.errorEventItem = errorEventItem;
	}

	public String getErrorEventItemAttributeId()
    {
        return errorEventItemAttributeId;
    }

    public void setErrorEventItemAttributeId(String errorEventItemAttributeId)
    {
        this.errorEventItemAttributeId = errorEventItemAttributeId;
    }

    public String getErrorEventItemAttribute()
    {
        return errorEventItemAttribute;
    }

    public void setErrorEventItemAttribute(String errorEventItemAttribute)
    {
        this.errorEventItemAttribute = errorEventItemAttribute;
    }

    public String getErrorAccountInfo()
    {
        return errorAccountInfo;
    }

    public void setErrorAccountInfo(String errorAccountInfo)
    {
        this.errorAccountInfo = errorAccountInfo;
    }

    public String getErrorInvalidWebhook()
    {
        return errorInvalidWebhook;
    }

    public void setErrorInvalidWebhook(String errorInvalidWebhook)
    {
        this.errorInvalidWebhook = errorInvalidWebhook;
    }

    public String getErrorNoClientSecret()
    {
        return errorNoClientSecret;
    }

    public void setErrorNoClientSecret(String errorNoClientSecret)
    {
        this.errorNoClientSecret = errorNoClientSecret;
    }

    public int getEmailCampaignScheduleCreated()
    {
        return emailCampaignScheduleCreated;
    }

    public void setEmailCampaignScheduleCreated(int emailCampaignScheduleCreated)
    {
        this.emailCampaignScheduleCreated = emailCampaignScheduleCreated;
    }

    public String getHeaderAccept()
    {
        return headerAccept;
    }

    public void setHeaderAccept(String headerAccept)
    {
        this.headerAccept = headerAccept;
    }

    public String getHeaderContentType()
    {
        return headerContentType;
    }

    public void setHeaderContentType(String headerContentType)
    {
        this.headerContentType = headerContentType;
    }

    public String getHeaderUserAgent()
    {
        return headerUserAgent;
    }

    public void setHeaderUserAgent(String headerUserAgent)
    {
        this.headerUserAgent = headerUserAgent;
    }

    public String getUtf8()
    {
        return utf8;
    }

    public void setUtf8(String utf8)
    {
        this.utf8 = utf8;
    }

}
