package com.constantcontact.authentication.util;

import java.io.IOException;
import java.net.URLEncoder;

import com.constantcontact.httpclient.Header;
import com.constantcontact.httpclient.HttpException;
import com.constantcontact.httpclient.HttpResponse;
import com.constantcontact.httpclient.HttpResponseInterceptor;
import com.constantcontact.httpclient.client.CookieStore;
import com.constantcontact.httpclient.client.methods.HttpGet;
import com.constantcontact.httpclient.client.methods.HttpPost;
import com.constantcontact.httpclient.impl.client.BasicCookieStore;
import com.constantcontact.httpclient.impl.client.DefaultHttpClient;
import com.constantcontact.httpclient.impl.client.LaxRedirectStrategy;
import com.constantcontact.httpclient.protocol.BasicHttpContext;
import com.constantcontact.httpclient.protocol.HttpContext;

import com.constantcontact.util.Config;
import com.constantcontact.util.http.HttpProcessor;

/**
 * Authentication Http Processor.<br/>
 * Uses the Apache HttpClient.
 * 
 * @author ConstantContact
 * 
 */
public class AuthenticationHttpProcessor {
	private static final String LOCATION_HEADER = "Location";
	private static final String LAST_REDIRECT_URL = "last_redirect_url";
	private CookieStore cookieContainer;

	/**
	 * Default class constructor.
	 */
	public AuthenticationHttpProcessor() {
		cookieContainer = new BasicCookieStore();
	}

	/**
	 * Requests login page.
	 * 
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
	 * 
	 * @param username
	 * @param password
	 * @return Redirect url after authentication.
	 */
	public String submitAuthenticationRequest(String username, String password) {
		DefaultHttpClient client = new DefaultHttpClient();
		client.setCookieStore(cookieContainer);
		String authUrl = buildAuthenticationUrl(username, password);

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
	 * 
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
	 * 
	 * @return Url with access token.
	 */
	public String requestAuthorization(String redirectUrl) {
		StringBuilder sb = new StringBuilder();
		sb.append(Config.Auth.BASE_URL);
		sb.append(Config.Auth.AUTHORIZATION_ENDPOINT);
		sb.append("?user_oauth_approval=true&preregistered_redirect_uri=");
		try {
			sb.append(URLEncoder.encode(redirectUrl, Config.UTF_8));
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
	 * 
	 * @param username
	 * @param password 
	 * @return Authentication url
	 * @throws Exception If url parameters encoding is not supported
	 */
	private String buildAuthenticationUrl(String username, String password) {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append(Config.Login.BASE_URL);
			sb.append("?reauth=false");
			StringBuilder gotoUrlBuilder = new StringBuilder();
			gotoUrlBuilder.append(Config.Auth.BASE_URL).append(Config.Login.LOGIN_ENDPOINT).append("?response_type=").append(Config.Auth.RESPONSE_TYPE_TOKEN);
			String gotoUrl = URLEncoder.encode(gotoUrlBuilder.toString(), Config.UTF_8);
			sb.append("&gotoUrl=").append(gotoUrl);
			sb.append("&cookiesEnabled=true");
			String user = URLEncoder.encode(username, Config.UTF_8);
			String pass = URLEncoder.encode(password, Config.UTF_8);
			
			sb.append("&luser=").append(user).append("&lpass=").append(pass);
			sb.append("&_remuser=on&_save=");
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		return sb.toString();
	}
}
