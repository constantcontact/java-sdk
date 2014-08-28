package com.constantcontact.util.http.constants;


/**
 * 
 * Processor Constants in Constant Contact.<br/>
 * Added these in an interface only for a quicker way of access.
 * 
 * @author ConstantContact
 * 
 */
public interface ProcessorBase {

	/**
	 * Content-Type header.
	 */
	public static final String CONTENT_TYPE_HEADER = "Content-Type";

	/**
	 * Content-Length header.
	 */
	public static final String CONTENT_LENGTH_HEADER = "Content-Length";

	/**
	 * Accept header.
	 */
	public static final String ACCEPT_HEADER = "Accept";

	/**
	 * Authorization header.
	 */
	public final static String AUTHORIZATION_HEADER = "Authorization";

	/**
	 * constant for "application/json" content type
	 */
	public final static String JSON_CONTENT_TYPE = "application/json";

	/**
     * constant for "multipart/form-data" content type
     */
    public final static String MULTIPART_CONTENT_TYPE = "multipart/form-data";
    
    /**
     * The boundary we will use in our multipart requests
     */
    public final static String MULTIPART_BOUNDARY = "ihLgaHFfpPMsYLTKiwf4";
    
    /**
     * constant for boundary content type. Used with multipart after a semicolon
     */
    public final static String BOUNDARY_CONTENT_TYPE = "boundary=" + MULTIPART_BOUNDARY;
	
	/**
	 * A single Space
	 */
	public final static String SPACE = " ";

	/**
	 * Location header.
	 */
	public static final String LOCATION_HEADER = "Location";

	/**
	 * last_redirect_url parameter.
	 */
	public static final String LAST_REDIRECT_URL = "last_redirect_url";

	/**
	 * Cookie header.
	 */
	public static final String COOKIE_HEADER = "Cookie";

	/**
	 * Cookie2 header.
	 */
	public static final String COOKIE2_HEADER = "Cookie2";

	/**
	 * $Version=1 value.
	 */
	public static final String VERSION1_VALUE = "$Version=1";

	/**
	 * Host header.
	 */
	public static final String HOST_HEADER = "Host";

	/**
	 * User-Agent header.
	 */
	public static final String USER_AGENT_HEADER = "User-Agent";

	/**
	 * The allowed HTTP methods for the HTTP and HTTPS Processors.
	 * 
	 * @author ConstantContact
	 */
	public static enum HttpMethod {
		GET,
		POST,
		DELETE,
		PUT,
        PATCH
	}
	
	/**
     * The allowed ContentTypes
     * 
     * @author csciuto
     */
    public static enum ContentType {
        JSON(JSON_CONTENT_TYPE),
        FORM_DATA(MULTIPART_CONTENT_TYPE+";"+BOUNDARY_CONTENT_TYPE);
        
        private String stringVal;
        
        ContentType(String stringVal){
            this.stringVal = stringVal;
        }
        
        public String getStringVal(){
            return stringVal;
        }
    }
}