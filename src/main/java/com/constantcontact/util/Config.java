package com.constantcontact.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Main Configuration structure in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public final class Config {
  /**
   * Contains a list with all REST endpoints.
   * 
   * @author ConstantContact
   */
  public static final class Endpoints {

    /**
     * API access URL Host.
     */
    public static final String BASE_URL_HOST = "https://api.constantcontact.com";

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

    /**
     * Default constructor.<br/>
     * Made private to prevent instantiation.<br/>
     * This is unreachable from the outside, since current class is used only as a repository for constants.
     */
    private Endpoints() {
    }
  }

  /**
   * OAuth2 Authorization related configuration options. <br/>
   * These are used for the authorize part of the authentication flow.
   * 
   * @author ConstantContact
   */
  public static final class Auth {

    /**
     * Authentication base URL.
     */
    public static final String BASE_URL = "https://oauth2.constantcontact.com/oauth2/";

    /**
     * Query code. <br/>
     * This should be used in server-type authentication handshake.
     */
    public static final String RESPONSE_TYPE_CODE = "code";

    /**
     * Query token. <br/>
     * This should be used in client-type authentication handshake.<br/>
     * This is what we use.
     */
    public static final String RESPONSE_TYPE_TOKEN = "token";

    /**
     * Query authorization code grant type.
     */
    public static final String AUTHORIZATION_CODE_GRANT_TYPE = "authorization_code";

    /**
     * The authorization endpoint.
     */
    public static final String AUTHORIZATION_ENDPOINT = "oauth/siteowner/authorize";

    /**
     * The token fetch endpoint.
     */
    public static final String TOKEN_ENDPOINT = "oauth/token";

    /**
     * Request host.
     */
    public static final String HOST = "oauth2.constantcontact.com";

    /**
     * Default constructor.<br/>
     * Made private to prevent instantiation.<br/>
     * This is unreachable from the outside, since current class is used only as a repository for constants.
     */
    private Auth() {
    }
  }

  /**
   * Login related configuration options in Constant Contact.<br/>
   * These are used for the login part of the authentication flow.
   * 
   * @author ConstantContact
   * 
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
    public static final String ID = "Only an mumeric String is allowed for this method.";

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
     * Contacts File Name null error.
     */
    public static final String BULK_CONTACTS_FILE_NAME_NULL = "FileName parameter must not be null.";
    
    /**
     * Contacts File null error.
     */
    public static final String BULK_CONTACTS_FILE_NULL = "File parameter must not be null.";
    
    /**
     * Contacts ListId null error.
     */
    public static final String BULK_CONTACTS_LIST_NULL = "ListIds parameter must not be null.";
    
    /**
     * Pagination null error
     */
    public static final String PAGINATION_NULL = "Pagination parameter must not be null";
    
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
   * 
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

  /**
   * Collumn names in Constant Contact Activities flow.<br/>
   * 
   * These are used for {@link com.constantcontact.components.activities.contacts.request.ExportContactsRequest} and {@link com.constantcontact.components.activities.contacts.request.AddContactsRequest} requests in {@link com.constantcontact.services.activities.BulkActivitiesService}.
   * 
   * @author ConstantContact
   */

  public static final class COLUMN_NAMES {

    public static final String EMAIL = "EMAIL";

    public static final String FIRST_NAME = "FIRST NAME";

    public static final String MIDDLE_NAME = "MIDDLE NAME";

    public static final String LAST_NAME = "LAST NAME";

    public static final String JOB_TITLE = "JOB TITLE";

    public static final String COMPANY_NAME = "COMPANY NAME";

    public static final String WORK_PHONE = "WORK PHONE";

    public static final String HOME_PHONE = "HOME PHONE";

    public static final String ADDRESS1 = "ADDRESS LINE 1";

    public static final String ADDRESS2 = "ADDRESS LINE 2";

    public static final String ADDRESS3 = "ADDRESS LINE 3";

    public static final String CITY = "CITY";

    public static final String STATE = "STATE";

    public static final String STATE_PROVINCE = "US STATE/CA PROVINCE";

    public static final String COUNTRY = "COUNTRY";

    public static final String POSTAL_CODE = "ZIP/POSTAL CODE";

    public static final String SUB_POSTAL_CODE = "SUB ZIP/POSTAL CODE";

    public static final String CUSTOM_FIELD_1 = "CUSTOM FIELD 1";

    public static final String CUSTOM_FIELD_2 = "CUSTOM FIELD 2";

    public static final String CUSTOM_FIELD_3 = "CUSTOM FIELD 3";

    public static final String CUSTOM_FIELD_4 = "CUSTOM FIELD 4";

    public static final String CUSTOM_FIELD_5 = "CUSTOM FIELD 5";

    public static final String CUSTOM_FIELD_6 = "CUSTOM FIELD 6";

    public static final String CUSTOM_FIELD_7 = "CUSTOM FIELD 7";

    public static final String CUSTOM_FIELD_8 = "CUSTOM FIELD 8";

    public static final String CUSTOM_FIELD_9 = "CUSTOM FIELD 9";

    public static final String CUSTOM_FIELD_10 = "CUSTOM FIELD 10";

    public static final String CUSTOM_FIELD_11 = "CUSTOM FIELD 11";

    public static final String CUSTOM_FIELD_12 = "CUSTOM FIELD 12";

    public static final String CUSTOM_FIELD_13 = "CUSTOM FIELD 13";

    public static final String CUSTOM_FIELD_14 = "CUSTOM FIELD 14";

    public static final String CUSTOM_FIELD_15 = "CUSTOM FIELD 15";

    /**
     * Default constructor.<br/>
     * Made private to prevent instantiation.<br/>
     * This is unreachable from the outside, since current class is used only as a repository for constants.
     */
    private COLUMN_NAMES() {

    }

    /**
     * Gets all defined collumn names.
     * 
     * @return A List of String representing the list of all collumn names.
     */
    public static final List<String> getAllCollums() {
      List<String> columnList = new ArrayList<String>();
      columnList.add(EMAIL);
      columnList.add(FIRST_NAME);
      columnList.add(MIDDLE_NAME);
      columnList.add(LAST_NAME);
      columnList.add(JOB_TITLE);
      columnList.add(COMPANY_NAME);
      columnList.add(WORK_PHONE);
      columnList.add(HOME_PHONE);
      columnList.add(ADDRESS1);
      columnList.add(ADDRESS2);
      columnList.add(ADDRESS3);
      columnList.add(CITY);
      columnList.add(STATE);
      columnList.add(STATE_PROVINCE);
      columnList.add(COUNTRY);
      columnList.add(POSTAL_CODE);
      columnList.add(SUB_POSTAL_CODE);
      columnList.add(CUSTOM_FIELD_1);
      columnList.add(CUSTOM_FIELD_2);
      columnList.add(CUSTOM_FIELD_3);
      columnList.add(CUSTOM_FIELD_4);
      columnList.add(CUSTOM_FIELD_5);
      columnList.add(CUSTOM_FIELD_6);
      columnList.add(CUSTOM_FIELD_7);
      columnList.add(CUSTOM_FIELD_8);
      columnList.add(CUSTOM_FIELD_9);
      columnList.add(CUSTOM_FIELD_10);
      columnList.add(CUSTOM_FIELD_11);
      columnList.add(CUSTOM_FIELD_12);
      columnList.add(CUSTOM_FIELD_13);
      columnList.add(CUSTOM_FIELD_14);
      columnList.add(CUSTOM_FIELD_15);
      return columnList;
    }
  }

  /**
   * Default constructor.<br/>
   * Made private to prevent instantiation.<br/>
   * This is unreachable from the outside, since current class is used only as a repository for constants.
   */
  private Config() {
  }
}
