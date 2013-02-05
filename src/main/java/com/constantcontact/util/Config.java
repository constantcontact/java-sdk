package com.constantcontact.util;

/**
 * Configuration structure.
 * 
 * @author ConstantContact
 *
 */
public final class Config {
	/**
	 * REST endpoints.
	 */
	public static final class Endpoints {
		/**
		 * API access URL.
		 */
		public static final String BASE_URL = "https://api.constantcontact.com/v2/";
		
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
		public static final String LIST ="lists/%1$s";
		
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
		public static final String CAMPAIGNS = "campaigns";
		
		/**
		 * Access a campaign.
		 */
		public static final String CAMPAIGN_ID = "campaigns/%1$s";
	}

	/**
	 * OAuth2 Authorization related configuration options.
	 */
    public static final class Auth {
    	/**
    	 * Authentication base URL.
    	 */
        public static final String BASE_URL = "https://oauth2.constantcontact.com/oauth2/";

        /**
         * Query code.
         */
        public static final String RESPONSE_TYPE_CODE = "code";

        /**
         * Query token.
         */
        public static final String RESPONSE_TYPE_TOKEN = "token";

        /**
         * Query authorization type.
         */
        public static final String AUTHORIZATION_CODE_GRANT_TYPE = "authorization_code";

        /**
         * Authorization endpoint.
         */
        public static final String AUTHORIZATION_ENDPOINT = "oauth/siteowner/authorize";

        /**
         * Token endpoint.
         */
        public static final String TOKEN_ENDPOINT = "oauth/token";

        /**
         * Request host.
         */
        public static final String HOST = "oauth2.constantcontact.com";
    }

    /**
     * Login related configuration options.
     */
    public static final class Login {
    	/**
    	 * Login base URL.
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
    }
    
    /**
     * Errors to be returned for various exceptions.
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
    
    public static final String UTF_8 = "UTF-8";
}
