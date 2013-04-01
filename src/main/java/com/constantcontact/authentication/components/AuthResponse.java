package com.constantcontact.authentication.components;

import java.io.Serializable;

/**
 * Models an Authentication Response in ConstantContact.
 * 
 * @author ConstantContact
 * 
 */
public class AuthResponse implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 3447886295340983638L;

	/**
	 * Status
	 */
	private int status;

	/**
	 * Redirect URL
	 */
	private String redirectUrl;

	/**
	 * Response Content
	 */
	private String responseContent;

	/**
	 * Get the status.
	 * 
	 * @return The status.
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Get the Redirect Url
	 * 
	 * @return The Redirect Url
	 */
	public String getRedirectUrl() {
		return redirectUrl;
	}

	/**
	 * Get the Response Content
	 * 
	 * @return The Response Content
	 */
	public String getResponseContent() {
		return responseContent;
	}

	/**
	 * Set the The status
	 * 
	 * @param status The new status.
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * Set the The redirect url
	 * 
	 * @param redirectUrl The new redirect url.
	 */
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	/**
	 * Set the The response content
	 * 
	 * @param responseContent The new response content.
	 */
	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}

	/**
	 * Default constructor.
	 */
	public AuthResponse() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AuthResponse [status=");
		builder.append(status);
		builder.append(", redirectUrl=");
		builder.append(redirectUrl);
		builder.append(", responseContent=");
		builder.append(responseContent);
		builder.append("]");
		return builder.toString();
	}
}
