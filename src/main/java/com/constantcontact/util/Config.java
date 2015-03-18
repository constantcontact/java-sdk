package com.constantcontact.util;

import com.constantcontact.ConstantContact;

/**
 * Main Configuration structure in Constant Contact.
 *
 * @author ConstantContact
 */
public final class Config {

    private static Config instance;
    
    /**
     * SDK Version
     */
    private String ctctSdkVersion;
    
    /**
     * API access URL Host.
     */
    private String baseUrl = "https://api.constantcontact.com";

    public String getCtctSdkVersion() {
        return ctctSdkVersion;
    }

    public void setCtctSdkVersion(String ctctSdkVersion) {
        this.ctctSdkVersion = ctctSdkVersion;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    private Config() {
        Package aPackage = ConstantContact.class.getPackage();
        ctctSdkVersion = aPackage.getImplementationVersion();
    }

    /**
     * Singleton
     * @return
     */
    public static Config instance() {
        if (instance == null){
            instance = new Config();
        }
        return instance;
    }
    
    /**
     * Contains a list with all REST endpoints.
     *
     * @author ConstantContact
     */
    public static final class Endpoints {

        /**
         * Access a contact.
         */
        public static final String CONTACT = "/v2/contacts/%1$s";

        /**
         * Get all contacts.
         */
        public static final String CONTACTS = "/v2/contacts";

        /**
         * Get all lists.
         */
        public static final String LISTS = "/v2/lists";

        /**
         * Access a specified list.
         */
        public static final String LIST = "/v2/lists/%1$s";

        /**
         * Get the list of contacts from a list.
         */
        public static final String LIST_CONTACTS = "/v2/lists/%1$s/contacts";

        /**
         * Get contact lists.
         */
        public static final String CONTACT_LISTS = "/v2/contacts/%1$s/lists";

        /**
         * Get a list from contact lists.
         */
        public static final String CONTACT_LIST = "/v2/contacts/%1$s/lists/%2$s";

        /**
         * Get campaigns.
         */
        public static final String EMAILCAMPAIGNS = "/v2/emailmarketing/campaigns";

        /**
         * Access a campaign.
         */
        public static final String EMAILCAMPAIGN_ID = "/v2/emailmarketing/campaigns/%1$s";

        /**
         * Access a campaign. This is for PUT operations.
         */
        public static final String EMAILCAMPAIGNS_ID = "/v2/emailmarketing/campaigns/%1$s";

        /**
         * Get verified email addresses.
         */
        public static final String VERIFIEDEMAILADDRESSES = "/v2/account/verifiedemailaddresses";

        /**
         * Access a campaign schedule.
         */
        public static final String EMAILCAMPAIGNS_SCHEDULES_ID = "/v2/emailmarketing/campaigns/%1$s/schedules/%2$s";

        /**
         * Access all campaign schedules.
         */
        public static final String EMAILCAMPAIGNS_SCHEDULES_ID_ALL = "/v2/emailmarketing/campaigns/%1$s/schedules";

        /**
         * Access email campaign tracking reports summary for a given email campaign.
         */
        public static final String EMAILCAMPAIGNS_TRACKING_REPORTS_SUMMARY = "/v2/emailmarketing/campaigns/%1$s/tracking/reports/summary";

        /**
         * Access email campaign tracking bounces for a given email campaign.
         */
        public static final String EMAILCAMPAIGNS_TRACKING_BOUNCES = "/v2/emailmarketing/campaigns/%1$s/tracking/bounces";

        /**
         * Access email campaign tracking clicks for a given email campaign.
         */
        public static final String EMAILCAMPAIGNS_TRACKING_CLICKS = "/v2/emailmarketing/campaigns/%1$s/tracking/clicks";

        /**
         * Access email campaign tracking forwards for a given email campaign.
         */
        public static final String EMAILCAMPAIGNS_TRACKING_FORWARDS = "/v2/emailmarketing/campaigns/%1$s/tracking/forwards";

        /**
         * Access email campaign tracking opens for a given email campaign.
         */
        public static final String EMAILCAMPAIGNS_TRACKING_OPENS = "/v2/emailmarketing/campaigns/%1$s/tracking/opens";

        /**
         * Access email campaign tracking sends for a given email campaign.
         */
        public static final String EMAILCAMPAIGNS_TRACKING_SENDS = "/v2/emailmarketing/campaigns/%1$s/tracking/sends";

        /**
         * Access email campaign tracking unsubscribes for a given email campaign.
         */
        public static final String EMAILCAMPAIGNS_TRACKING_UNSUBSCRIBES = "/v2/emailmarketing/campaigns/%1$s/tracking/unsubscribes";

        /**
         * Access email campaign tracking clicks by link for a given email campaign.
         */
        public static final String EMAILCAMPAIGNS_TRACKING_CLICKS_BY_LINK = "/v2/emailmarketing/campaigns/%1$s/tracking/clicks/%2$s";

        /**
         * Access contact tracking reports summary for a given contact.
         */
        public static final String CONTACTS_TRACKING_REPORTS_SUMMARY = "/v2/contacts/%1$s/tracking/reports/summary";

        /**
         * Access contact tracking reports summary for a given contact.
         */
        public static final String CONTACTS_TRACKING_REPORTS_BY_CAMPAIGN_SUMMARY = "/v2/contacts/%1$s/tracking/reports/summaryByCampaign";

        /**
         * Access contact tracking activities for a given contact.
         */
        public static final String CONTACTS_TRACKING_ALL = "/v2/contacts/%1$s/tracking/";

        /**
         * Access contact tracking bounces for a given contact.
         */
        public static final String CONTACTS_TRACKING_BOUNCES = "/v2/contacts/%1$s/tracking/bounces";

        /**
         * Access contact tracking clicks for a given contact.
         */
        public static final String CONTACTS_TRACKING_CLICKS = "/v2/contacts/%1$s/tracking/clicks";

        /**
         * Access contact tracking forwards for a given contact.
         */
        public static final String CONTACTS_TRACKING_FORWARDS = "/v2/contacts/%1$s/tracking/forwards";

        /**
         * Access contact tracking opens for a given contact.
         */
        public static final String CONTACTS_TRACKING_OPENS = "/v2/contacts/%1$s/tracking/opens";

        /**
         * Access contact tracking sends for a given contact.
         */
        public static final String CONTACTS_TRACKING_SENDS = "/v2/contacts/%1$s/tracking/sends";

        /**
         * Access contact tracking unsubscribes for a given contact.
         */
        public static final String CONTACTS_TRACKING_UNSUBSCRIBES = "/v2/contacts/%1$s/tracking/unsubscribes";

        /**
         * Endpoint for the bulk contacts upload.
         */
        public static final String ACTIVITIES_ADD_CONTACTS = "/v2/activities/addcontacts";

        /**
         * Endpoint for the bulk contacts remove from lists.
         */
        public static final String ACTIVITIES_REMOVE_FROM_LISTS = "/v2/activities/removefromlists";

        /**
         * Endpoint for the bulk clear lists.
         */
        public static final String ACTIVITIES_CLEAR_LISTS = "/v2/activities/clearlists";

        /**
         * Endpoint for the bulk export contacts.
         */
        public static final String ACTIVITIES_EXPORT_CONTACTS = "/v2/activities/exportcontacts";

        /**
         * Endpoint for the bulk activities retrieve.
         */
        public static final String ACTIVITIES = "/v2/activities";

        public static final String LIBRARY_INFO = "/v2/library/info";
        public static final String LIBRARY_FILES = "/v2/library/files";
        public static final String LIBRARY_FILES_BY_FOLDER = "/v2/library/folders/%1$s/files";
        public static final String LIBRARY_FOLDERS = "/v2/library/folders";

        public static final String LIBRARY_FOLDER = LIBRARY_FOLDERS + "/%1$s";
        public static final String LIBRARY_FOLDER_TRASH = LIBRARY_FOLDERS + "/trash/files";

        public static final String LIBRARY_FILE = LIBRARY_FILES + "/%1$s";
        public static final String LIBRARY_FILE_UPLOAD_STATUS = LIBRARY_FILES + "/uploadstatus/%1$s";

        public static final String LIBRARY_FILE_MOVE = "/v2/library/folders/%1$s/files";

        /**
         * Endpoint for the list of events.
         */
        public static final String EVENTS = "/v2/eventspot/events/";

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
        public static final String ACCOUNT_INFO = "/v2/account/info";

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
         * This is unreachable from the outside, since current class is used only as a repository for constants.
         */
        private Login() {
        }
    }

    /**
     * Errors to be returned for various exceptions in the Constant Contact flow.
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
        public static final String NO_CLIENT_SECRET = "You must provide the client secret (via constructor or setClientSecret() ) corresponding to " +
                "your API   from Constant Contact";


        /**
         * Default constructor.<br/>
         * Made private to prevent instantiation.<br/>
         * This is unreachable from the outside, since current class is used only as a repository for constants.
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
         * This is unreachable from the outside, since current class is used only as a repository for constants.
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
