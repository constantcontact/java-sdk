package com.constantcontact.authentication.components;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import com.constantcontact.exceptions.authentication.ConstantContactAuthenticationException;
import com.constantcontact.util.Config;
import com.constantcontact.util.http.constants.ProcessorBase.HttpMethod;

/**
 * Models an Authentication Connection in Constant Contact. <br/>
 * Class to encapsulate the two connections needed during authentication flow.<br/>
 * Since authentication consists of a back and forward ping-pong between HTTPS and HTTP, two connections are needed: a secured one and a non-secured one.
 * 
 * @author ConstantContact
 * 
 */
public class AuthenticationConnection implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 1674894949966841107L;

	/**
	 * The secured connection instance.<br/>
	 * This will be non-null for the case when there is a connection over HTTPS.
	 */
	private HttpsURLConnection httpsConnection;

	/**
	 * The regular connection instance.<br/>
	 * This will be non-null for the case when there is a connection over HTTP.
	 */
	private HttpURLConnection httpConnection;

	/**
	 * The {@link AuthenticationConnectionType} instance.<br/>
	 * This will tell weather we are dealing with a secured or regular connection.
	 */
	private AuthenticationConnectionType authenticationConnectionType;

	/**
	 * User-Agent header.
	 */
	public static final String USER_AGENT_HEADER = "User-Agent";

	/**
	 * Connection header.
	 */
	public static final String CONNECTION_HEADER = "Connection";

	/**
	 * Connection header Keep-Alive value.
	 */
	public static final String CONNECTION_HEADER_KEEP_ALIVE = "Keep-Alive";

	/**
	 * Host header .
	 */
	public static final String HOST_HEADER = "Host";

	/**
	 * Class constructor.<br/>
	 * You are allowed to call only this one - the default constructor was made private to avoid usage.
	 * 
	 * @param urlParam The url.
	 * @param doConnectAfterOpen Connect After Open flag : tells if connection will be connected right after open, or left as it is.
	 * @param httpMethod The HTTP method
	 * @throws ConstantContactAuthenticationException When there is a problem in the authentication flow / server answered with an unexpected response.
	 */
	public AuthenticationConnection(String urlParam, boolean doConnectAfterOpen, HttpMethod httpMethod) throws ConstantContactAuthenticationException {
		try {
			URL serverAddress = new URL(urlParam);

			if (urlParam.toLowerCase().startsWith("https:")) {
				this.authenticationConnectionType = AuthenticationConnectionType.HTTPS;

				this.httpsConnection = (HttpsURLConnection) serverAddress.openConnection();
				this.httpsConnection.setInstanceFollowRedirects(false);

				this.httpConnection = null;
				setHeader(HOST_HEADER, serverAddress.getHost());
				setUserAgentHeader();
				setConnectionKeepAliveHeader();

				switch (httpMethod) {
				case GET:
					this.httpsConnection.setRequestMethod("GET");
					break;

				case POST:
					this.httpsConnection.setRequestMethod("POST");

					this.httpsConnection.setDoOutput(true);
					this.httpsConnection.setAllowUserInteraction(true);
					this.httpsConnection.setInstanceFollowRedirects(false);

					break;

				case DELETE:
					this.httpsConnection.setRequestMethod("DELETE");
					break;
				case PUT:
					this.httpsConnection.setRequestMethod("PUT");
					break;

				default:
					this.httpsConnection.setRequestMethod("GET");
					break;
				}

				if (doConnectAfterOpen) {
					this.httpsConnection.connect();
				}
			} else if (urlParam.toLowerCase().startsWith("http:")) {
				this.authenticationConnectionType = AuthenticationConnectionType.HTTP;

				this.httpConnection = (HttpURLConnection) serverAddress.openConnection();
				this.httpsConnection = null;
				setHeader(HOST_HEADER, serverAddress.getHost());
				setUserAgentHeader();
				setConnectionKeepAliveHeader();

				switch (httpMethod) {
				case GET:
					this.httpConnection.setRequestMethod("GET");
					break;

				case POST:
					this.httpConnection.setRequestMethod("POST");

					this.httpConnection.setDoOutput(true);
					this.httpConnection.setAllowUserInteraction(true);
					this.httpConnection.setInstanceFollowRedirects(false);

					break;

				case DELETE:
					this.httpConnection.setRequestMethod("DELETE");
					break;
				case PUT:
					this.httpConnection.setRequestMethod("PUT");
					break;

				default:
					this.httpConnection.setRequestMethod("GET");
					break;
				}
				if (doConnectAfterOpen) {
					this.httpConnection.connect();
				}
			} else {
				throw new ConstantContactAuthenticationException("Unknown Protocol. Only HTTP and HTTPS are allowed.");
			}
		} catch (Exception e) {
			throw new ConstantContactAuthenticationException(e);
		}
	}

	/**
	 * Default constructor ( is made private ).
	 */
	@SuppressWarnings("unused")
	private AuthenticationConnection() {

	}

	/**
	 * Get the value for {@link #httpsConnection}
	 * 
	 * @return The value for {@link #httpsConnection}
	 */
	public HttpsURLConnection getHttpsConnection() {
		return httpsConnection;
	}

	/**
	 * Get the value for {@link #httpConnection}
	 * 
	 * @return The value for {@link #httpConnection}
	 */
	public HttpURLConnection getHttpConnection() {
		return httpConnection;
	}

	/**
	 * Get the value for {@link #authenticationConnectionType}
	 * 
	 * @return The value for {@link #authenticationConnectionType}
	 */
	public AuthenticationConnectionType getAuthenticationConnectionType() {
		return authenticationConnectionType;
	}

	/**
	 * Set the value for {@link #httpsConnection}
	 * 
	 * @param httpsConnection The new value for {@link #httpsConnection}
	 */
	public void setHttpsConnection(HttpsURLConnection httpsConnection) {
		this.httpsConnection = httpsConnection;
	}

	/**
	 * Set the value for {@link #httpConnection}
	 * 
	 * @param httpConnection The new value for {@link #httpConnection}
	 */
	public void setHttpConnection(HttpURLConnection httpConnection) {
		this.httpConnection = httpConnection;
	}

	/**
	 * Set the value for {@link #authenticationConnectionType}
	 * 
	 * @param authenticationConnectionType The new value for {@link #authenticationConnectionType}
	 */
	public void setAuthenticationConnectionType(AuthenticationConnectionType authenticationConnectionType) {
		this.authenticationConnectionType = authenticationConnectionType;
	}

	/**
	 * Adds a new HTTP header, as indicated by the key and value pair.<br/>
	 * Will automatically choose the appropriate connection based on the built-in {@link #authenticationConnectionType}.
	 * 
	 * @param key The key
	 * @param value The value
	 */
	public void setHeader(String key, String value) {
		debug("setHeader", " >> key: " + key + ", value : " + value);
		if (AuthenticationConnectionType.HTTPS.equals(this.authenticationConnectionType)) {
			this.httpsConnection.setRequestProperty(key, value);
		} else {
			this.httpConnection.setRequestProperty(key, value);
		}
	}

	/**
	 * Set the User-Agent Header using a {@link #setHeader(String, String)} call.
	 */
	public void setUserAgentHeader() {
		setHeader(USER_AGENT_HEADER, Config.HEADER_USER_AGENT);
	}

	/**
	 * Set the Connection: Keep-Alive Header using a {@link #setHeader(String, String)} call.
	 */
	public void setConnectionKeepAliveHeader() {
		setHeader(CONNECTION_HEADER, CONNECTION_HEADER_KEEP_ALIVE);
	}

	/**
	 * Get the output stream attached to the open connection.<br/>
	 * Will automatically tell if it is HTTPS or HTTP connection based on the built-in {@link #authenticationConnectionType}.
	 * 
	 * @return The {@link OutputStream}
	 * @throws IOException
	 */
	public OutputStream getOutputStream() throws IOException {
		if (AuthenticationConnectionType.HTTPS.equals(this.authenticationConnectionType)) {
			return httpsConnection.getOutputStream();
		} else {
			return httpConnection.getOutputStream();
		}
	}

	/**
	 * Get the input stream attached to the open connection.<br/>
	 * Will automatically tell if it is HTTPS or HTTP connection based on the built-in {@link #authenticationConnectionType}.
	 * 
	 * @return The {@link InputStream}
	 * @throws IOException
	 */
	public InputStream getInputStream() throws IOException {
		if (AuthenticationConnectionType.HTTPS.equals(this.authenticationConnectionType)) {
			return httpsConnection.getInputStream();
		} else {
			return httpConnection.getInputStream();
		}
	}

	/**
	 * Get the errors input stream attached to the open connection.<br/>
	 * Will automatically tell if it is HTTPS or HTTP connection based on the built-in {@link #authenticationConnectionType}.
	 * 
	 * @return The {@link InputStream}
	 * @throws IOException
	 */
	public InputStream getErrorStream() throws IOException {
		if (AuthenticationConnectionType.HTTPS.equals(this.authenticationConnectionType)) {
			return httpsConnection.getErrorStream();
		} else {
			return httpConnection.getErrorStream();
		}
	}

	/**
	 * Get the URL attached to the open connection.<br/>
	 * Will automatically tell if it is HTTPS or HTTP connection based on the built-in {@link #authenticationConnectionType}.
	 * 
	 * @return The {@link URL}
	 */
	public URL getURL() {
		if (AuthenticationConnectionType.HTTPS.equals(this.authenticationConnectionType)) {
			return httpsConnection.getURL();
		} else {
			return httpConnection.getURL();
		}
	}

	/**
	 * Get the Header Fields attached to the open connection.<br/>
	 * Will automatically tell if it is HTTPS or HTTP connection based on the built-in {@link #authenticationConnectionType}.
	 * 
	 * @return The Header Fields
	 */
	public Map<String, List<String>> getHeaderFields() {
		if (AuthenticationConnectionType.HTTPS.equals(this.authenticationConnectionType)) {
			return httpsConnection.getHeaderFields();
		} else {
			return httpConnection.getHeaderFields();
		}
	}

	/**
	 * Get the Response Code from the open connection.<br/>
	 * Will automatically tell if it is HTTPS or HTTP connection based on the built-in {@link #authenticationConnectionType}.
	 * 
	 * @return The Response Code
	 */
	public int getResponseCode() throws IOException {
		if (AuthenticationConnectionType.HTTPS.equals(this.authenticationConnectionType)) {
			return httpsConnection.getResponseCode();
		} else {
			return httpConnection.getResponseCode();
		}
	}

	/**
	 * Disconnect the open connection.<br/>
	 * Will automatically tell if it is HTTPS or HTTP connection based on the built-in {@link #authenticationConnectionType}.
	 */
	public void disconnect() {
		if (AuthenticationConnectionType.HTTPS.equals(this.authenticationConnectionType)) {
			httpsConnection.disconnect();
		} else {
			httpConnection.disconnect();
		}
	}

	/**
	 * Set the Do Output flag for the open connection.<br/>
	 * Will automatically tell if it is HTTPS or HTTP connection based on the built-in {@link #authenticationConnectionType}.
	 * 
	 * @param dooutput
	 */
	public void setDoOutput(boolean dooutput) {
		if (AuthenticationConnectionType.HTTPS.equals(this.authenticationConnectionType)) {
			httpsConnection.setDoOutput(dooutput);
		} else {
			httpConnection.setDoOutput(dooutput);
		}
	}

	/**
	 * Set the Do Input flag for the open connection.<br/>
	 * Will automatically tell if it is HTTPS or HTTP connection based on the built-in {@link #authenticationConnectionType}.
	 * 
	 * @param doinput
	 */
	public void setDoInput(boolean doinput) {
		if (AuthenticationConnectionType.HTTPS.equals(this.authenticationConnectionType)) {
			httpsConnection.setDoInput(doinput);
		} else {
			httpConnection.setDoInput(doinput);
		}
	}

	/**
	 * Set the Allow User Interaction flag for the open connection.<br/>
	 * Will automatically tell if it is HTTPS or HTTP connection based on the built-in {@link #authenticationConnectionType}.
	 * 
	 * @param allowUserInteraction
	 */
	public void setAllowUserInteraction(boolean allowUserInteraction) {
		if (AuthenticationConnectionType.HTTPS.equals(this.authenticationConnectionType)) {
			httpsConnection.setAllowUserInteraction(allowUserInteraction);
		} else {
			httpConnection.setAllowUserInteraction(allowUserInteraction);
		}
	}

	/**
	 * Set the Instance Follow Redirects flag for the open connection.<br/>
	 * Will automatically tell if it is HTTPS or HTTP connection based on the built-in {@link #authenticationConnectionType}.
	 * 
	 * @param instanceFollowRedirects
	 */
	public void setInstanceFollowRedirects(boolean instanceFollowRedirects) {
		if (AuthenticationConnectionType.HTTPS.equals(this.authenticationConnectionType)) {
			httpsConnection.setInstanceFollowRedirects(instanceFollowRedirects);
		} else {
			httpConnection.setInstanceFollowRedirects(instanceFollowRedirects);
		}
	}

	/**
	 * Connects the open connection.<br/>
	 * Will automatically tell if it is HTTPS or HTTP connection based on the built-in {@link #authenticationConnectionType}.
	 * 
	 * @throws IOException
	 */
	public void connect() throws IOException {
		if (AuthenticationConnectionType.HTTPS.equals(this.authenticationConnectionType)) {
			httpsConnection.connect();
		} else {
			httpConnection.connect();
		}
	}

	/**
	 * Set the Fixed Length Streaming Mode
	 * 
	 * @param length
	 */
	public void setFixedLengthStreamingMode(int length) {
		if (AuthenticationConnectionType.HTTPS.equals(this.authenticationConnectionType)) {
			httpsConnection.setFixedLengthStreamingMode(length);
		} else {
			httpConnection.setFixedLengthStreamingMode(length);
		}
	}

	/**
	 * Gets the host where the connection is being made.
	 * 
	 * @return The host where the connection is being made.
	 */
	public String getHost() {
		if (AuthenticationConnectionType.HTTPS.equals(this.authenticationConnectionType)) {
			return httpsConnection.getURL().getHost();
		} else {
			return httpConnection.getURL().getHost();
		}
	}

	// TODO: development purpose only
	private static void debug(String s1, String s2) {
		// TODO: comment/uncomment depending on your need for debug
		// System.out.println("AuthenticationConnection : " + s1 + " : " + s2);
	}

}