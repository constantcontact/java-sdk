package com.constantcontact.auth.util;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import com.constantcontact.util.Config;
import com.constantcontact.util.ConfigurationManager;
import com.constantcontact.util.http.HttpProcessor;

/**
 * Processor for authentication http requests.
 * 
 * @author ConstantContact
 *
 */
public class AuthHttpProcessor {
	private static final String LOCATION_HEADER = "Location";
	private static final String LAST_REDIRECT_URL = "last_redirect_url";
	private CookieStore cookieContainer;
	
	/**
	 * Default class constructor.
	 */
	public AuthHttpProcessor() {
		cookieContainer = new BasicCookieStore();
	}
	
	/**
	 * Requests login page.
	 * @param loginUrl Url for login page.
	 */
	public void requestLoginPage(String loginUrl) {
		DefaultHttpClient client = new DefaultHttpClient();
		client.setCookieStore(cookieContainer);
		HttpGet get = new HttpGet(loginUrl);
		get.setHeader(HttpProcessor.USER_AGENT_HEADER, Config.HEADER_USER_AGENT);
		try {
			HttpResponse execute = client.execute(get);
			execute.getEntity();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		get.reset();
	}
	
	/**
	 * Submits authentication request.
	 * @return Redirect url after authentication.
	 */
	public String submitAuthenticationRequest() {
		DefaultHttpClient client = new DefaultHttpClient();
		client.setCookieStore(cookieContainer);
		String authUrl = buildAuthenticationUrl();
		HttpPost post = new HttpPost(authUrl);
		post.setHeader(HttpProcessor.ACCEPT_HEADER, Config.HEADER_ACCEPT);
		post.setHeader(HttpProcessor.HOST_HEADER, Config.Login.HOST);
		post.setHeader(HttpProcessor.USER_AGENT_HEADER, Config.HEADER_USER_AGENT);
		post.setHeader(HttpProcessor.CONTENT_TYPE_HEADER, Config.HEADER_CONTENT_TYPE);
		HttpResponse authResp;
		try {
			authResp = client.execute(post);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
 		Header locationHeader = authResp.getHeaders(LOCATION_HEADER)[0];
		String location = locationHeader.getValue();
		post.reset();
		return location;
	}
	
	/**
	 * Requests grand access url received after authentication request.
	 * @param grandAccessUrl grand access url after authentication request.
	 */
	public void requestGrandAccess(String grandAccessUrl) {
		DefaultHttpClient redirectClient = new DefaultHttpClient();
		redirectClient.setRedirectStrategy(new LaxRedirectStrategy());
		redirectClient.setCookieStore(cookieContainer);
		HttpPost redirectPost = new HttpPost(grandAccessUrl);
		redirectPost.setHeader(HttpProcessor.ACCEPT_HEADER, Config.HEADER_ACCEPT);
		redirectPost.setHeader(HttpProcessor.HOST_HEADER, Config.Auth.HOST);
		redirectPost.setHeader(HttpProcessor.USER_AGENT_HEADER, Config.HEADER_USER_AGENT);
		redirectPost.setHeader(HttpProcessor.CONTENT_TYPE_HEADER, Config.HEADER_CONTENT_TYPE);
		try {
			HttpResponse execute = redirectClient.execute(redirectPost);
			execute.getEntity();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		redirectPost.reset();
	}
	
	/**
	 * Requests authorization.
	 * @return Url with access token.
	 */
	public String requestAuthorization() {
		StringBuilder sb = new StringBuilder();
		sb.append(Config.Auth.BASE_URL);
		sb.append(Config.Auth.AUTHORIZATION_ENDPOINT);
		sb.append("?user_oauth_approval=true&preregistered_redirect_uri=");
		try {
			sb.append(URLEncoder.encode(ConfigurationManager.getAppSettings("RedirectURL"), Config.UTF_8));
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		String redirect = sb.toString();
		DefaultHttpClient client = new DefaultHttpClient();
		client.setRedirectStrategy(new LaxRedirectStrategy());
		client.setCookieStore(cookieContainer);
		HttpContext context = new BasicHttpContext();
		client.addResponseInterceptor(new HttpResponseInterceptor() {
			@Override
			public void process(HttpResponse response, HttpContext context) throws HttpException, IOException {
				if (response.containsHeader(LOCATION_HEADER)) {
					Header[] locations = response.getHeaders(LOCATION_HEADER);
					if (locations.length > 0) {
						context.setAttribute(LAST_REDIRECT_URL, locations[0].getValue());
					}
				}
			}
		});
		HttpPost post = new HttpPost(redirect);
		post.setHeader(HttpProcessor.ACCEPT_HEADER, Config.HEADER_ACCEPT);
		post.setHeader(HttpProcessor.HOST_HEADER, Config.Auth.HOST);
		post.setHeader(HttpProcessor.USER_AGENT_HEADER, Config.HEADER_USER_AGENT);
		post.setHeader(HttpProcessor.CONTENT_TYPE_HEADER, Config.HEADER_CONTENT_TYPE);
		try {
			HttpResponse execute = client.execute(post, context);
			execute.getEntity();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		String urlWitToken = (String) context.getAttribute(LAST_REDIRECT_URL);
		post.reset();
		return urlWitToken;
	}
	
	/**
	 * Builds authentication url.
	 * @return Authentication url
	 * @throws Exception If url parameters encoding is not supported
	 */
	private String buildAuthenticationUrl() {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append(Config.Login.BASE_URL);
			sb.append("?reauth=false");
			StringBuilder gotoUrlBuilder = new StringBuilder();
			gotoUrlBuilder.append(Config.Auth.BASE_URL).append(Config.Login.LOGIN_ENDPOINT).append("?response_type=")
			.append(Config.Auth.RESPONSE_TYPE_TOKEN);
			String gotoUrl = URLEncoder.encode(gotoUrlBuilder.toString(), Config.UTF_8);
			sb.append("&gotoUrl=").append(gotoUrl);
			sb.append("&cookiesEnabled=true");
			String login = URLEncoder.encode(ConfigurationManager.getAppSettings("Username"), Config.UTF_8);
			String password = URLEncoder.encode(ConfigurationManager.getAppSettings("Password"), Config.UTF_8);
			sb.append("&luser=").append(login).append("&lpass=").append(password);
			sb.append("&_remuser=on&_save=");
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		return sb.toString();
	}
}
