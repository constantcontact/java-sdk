package com.constantcontact.auth;

import java.net.URLEncoder;
import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.constantcontact.auth.util.AuthHttpProcessor;
import com.constantcontact.util.Config;
import com.constantcontact.util.ConfigurationManager;


/**
 * Class that implements necessary functionality to obtain an access token from a user.
 * 
 * @author ConstantContact
 *
 */
public class CtcOAuth2 implements ICtcOAuth2 {
	/**
	 * Class constructor.
	 */
	public CtcOAuth2() {
		
	}
	
	/**
	 * Request the access token.
	 * @return Returns the access token.
	 */
	@Override
	public String getAccessToken() {
		AuthHttpProcessor httpProcessor = new AuthHttpProcessor();
		httpProcessor.requestLoginPage(getAuthorizationUrl(false));
		String grandAccessUrl = httpProcessor.submitAuthenticationRequest();
		httpProcessor.requestGrandAccess(grandAccessUrl);
		String urlWithToken = httpProcessor.requestAuthorization();
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
		formatUrlParam(formatter, "client_id=%1$s&", ConfigurationManager.getAppSettings("APIKey"));
		formatUrlParam(formatter, "client_secret=%1$s&", ConfigurationManager.getAppSettings("ConsumerSecret"));
		formatUrlParam(formatter, "code=%1$s&", code);
		formatUrlParam(formatter, "redirect_uri=%1$s", ConfigurationManager.getAppSettings("RedirectURL"));
		sb.append(formatter);
		return sb.toString();
	}

	/**
	 * Get the URL at which the user can authenticate and authorize the requesting application.
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
		formatUrlParam(formatter, "client_id=%1$s&", ConfigurationManager.getAppSettings("APIKey"));
		formatUrlParam(formatter, "redirect_uri=%1$s", ConfigurationManager.getAppSettings("RedirectURL"));
		sb.append(formatter);
		return sb.toString();
	}

	/**
	 * Encode values and writes it in <code>Formatter</code> according to format. 
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
