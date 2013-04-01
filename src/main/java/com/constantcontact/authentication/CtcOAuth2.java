package com.constantcontact.authentication;

import java.net.URLEncoder;
import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.constantcontact.authentication.util.AuthenticationHttpProcessor;
import com.constantcontact.util.Config;
import com.constantcontact.util.ConfigurationManager;

/**
 * Access point for the implementation of OAuth2 made in {@link AuthenticationHttpProcessor}. <br/>
 * Provides functionality to obtain an OAuth2 access token for a user.<br/>
 * You should simply call one of the:
 * <ul>
 * <li> {@link #getAccessToken()} ;</li>
 * </ul> 
 * to trigger the OAuth2 authentication flow and obtain the token.
 * 
 * @author ConstantContact
 * 
 */
public class CtcOAuth2 implements ICtcOAuth2 {

	/**
	 * Default constructor.
	 * If no parameter is provided, the OAuth2 access token will be obtained based on {@link ConfigurationManager} through "app.config" file.
	 */
	public CtcOAuth2() {
		super();
		this.username = ConfigurationManager.getAppSettings("Username");
		this.password = ConfigurationManager.getAppSettings("Password");
		this.apiKey = ConfigurationManager.getAppSettings("APIKey");
		this.redirectUrl = ConfigurationManager.getAppSettings("RedirectURL");
	}

	/**
	 * Constructor with user and password.
	 * @param username
	 * @param password
	 */
	public CtcOAuth2(String username, String password, String apiKey, String redirectUrl) {
		super();
		this.username = username;
		this.password = password;
		this.apiKey = apiKey;
		this.redirectUrl = redirectUrl;
		
	}
	
	private String username;
	private String password;
	private String apiKey;
	private String redirectUrl;
		
	/**
	 * Request the access token using the old HttpClient approach.
	 * 
	 * @return Returns the access token.
	 */
	@Override
	public String getAccessToken() {

		AuthenticationHttpProcessor httpProcessor = new AuthenticationHttpProcessor();
		httpProcessor.requestLoginPage(getAuthorizationUrl(false));
		String grandAccessUrl = httpProcessor.submitAuthenticationRequest(this.username, this.password);
		httpProcessor.requestGrandAccess(grandAccessUrl);
		String urlWithToken = httpProcessor.requestAuthorization(this.redirectUrl);
		if (urlWithToken == null || urlWithToken.trim().length() == 0) {
			return null;
		}
		Pattern accessTokenPattern = Pattern.compile("access_token=[^&]+");
		Matcher matcher = accessTokenPattern.matcher(urlWithToken);
		String token = null;
		if (matcher.find()) {
			token = matcher.group();
			token = token.split("=")[1];
		}
		return token;
	}


	/**
	 * Get the URL to obtain an access token.
	 * 
	 * @param code Code returned from Constant Contact after a user has granted access to their account.
	 * @return Returns an URL string.
	 */
	@Override
	public String getAccessTokenUrl(String code) {
		StringBuilder sb = new StringBuilder();
		sb.append(Config.Auth.BASE_URL);
		sb.append(Config.Auth.TOKEN_ENDPOINT);
		Formatter formatter = new Formatter();
		formatUrlParam(formatter, "?grant_type=%1$s&", Config.Auth.AUTHORIZATION_CODE_GRANT_TYPE);
		formatUrlParam(formatter, "client_id=%1$s&", this.apiKey);
		//formatUrlParam(formatter, "client_secret=%1$s&", ConfigurationManager.getAppSettings("ConsumerSecret"));
		formatUrlParam(formatter, "code=%1$s&", code);
		formatUrlParam(formatter, "redirect_uri=%1$s", this.redirectUrl);
		sb.append(formatter);
		return sb.toString();
	}

	/**
	 * Get the URL at which the user can authenticate and authorize the requesting application.
	 * 
	 * @param server Whether or not to use OAuth2 server flow, alternative is client flow.
	 * @return Returns the authorization URL.
	 */
	@Override
	public String getAuthorizationUrl(boolean server) {
		StringBuilder sb = new StringBuilder();
		sb.append(Config.Auth.BASE_URL);
		sb.append(Config.Auth.AUTHORIZATION_ENDPOINT);
		Formatter formatter = new Formatter();
		formatUrlParam(formatter, "?response_type=%1$s&", (server) ? Config.Auth.RESPONSE_TYPE_CODE : Config.Auth.RESPONSE_TYPE_TOKEN);
		formatUrlParam(formatter, "client_id=%1$s&", this.apiKey);
		formatUrlParam(formatter, "redirect_uri=%1$s",this.redirectUrl);
		sb.append(formatter);
		return sb.toString();
	}

	/**
	 * Encode values and writes it in <code>Formatter</code> according to format.
	 * 
	 * @param formatter <code>Formatter</code> object to format value according to format parameter.
	 * @param format Format string
	 * @param value Url parameters value
	 */
	private void formatUrlParam(Formatter formatter, String format, String value) {
		try {
			String encoded = URLEncoder.encode(value, Config.UTF_8);
			formatter.format(format, encoded);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
}
