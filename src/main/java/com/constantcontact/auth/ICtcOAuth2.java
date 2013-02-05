package com.constantcontact.auth;

/**
 * Interface for OAuth2 class.
 * 
 * @author ConstantContact
 *
 */
public interface ICtcOAuth2 {
	
	/**
	 * Request the access token.
	 * @return Returns the access token.
	 */
	String getAccessToken();
	
	/**
	 * Get the URL to obtain an access token.
	 * @param code Code returned from Constant Contact after a user has granted access to their account.
	 * @return Returns and URL string.
	 */
	String getAccessTokenUrl(String code);
	
	/**
	 * Get the URL at which the user can authenticate and authorize the requesting application.
	 * @param server Whether or not to use OAuth2 server flow, alternative is client flow.
	 * @return Returns the authorization URL.
	 */
	String getAuthorizationUrl(boolean server);
}
