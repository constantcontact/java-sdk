package com.constantcontact.util;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A single CUrl Request Error in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class CUrlRequestError extends Component implements Serializable {
	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -6549082824239495693L;

	@JsonIgnore
	private String errorKey;
	
	@JsonIgnore
	private String errorMessage;

	/**
	 * Default constructor.
	 */
	public CUrlRequestError() {
		super();
	}

	/**
	 * Gets the error errorKey.
	 * 
	 * @return The error errorKey.
	 */
	@JsonProperty("error_key")
	public String getErrorKey() {
		return errorKey;
	}

	/**
	 * Sets the error errorKey.
	 * 
	 * @param key The error errorKey.
	 */
	public void setErrorKey(String key) {
		this.errorKey = key;
	}

	/**
	 * Get the error errorMessage.
	 * 
	 * @return The error errorMessage.
	 */
	@JsonProperty("error_message")
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error errorMessage.
	 * 
	 * @param message The error errorMessage.
	 */
	public void setErrorMessage(String message) {
		this.errorMessage = message;
	}

	/**
	 * Constructor using the parameters
	 * 
	 * @param errorKey
	 * @param errorMessage
	 */
	public CUrlRequestError(String errorKey, String errorMessage) {
		super();
		this.errorKey = errorKey;
		this.errorMessage = errorMessage;
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nCUrlRequestError [errorKey=");
		builder.append(errorKey);
		builder.append(", errorMessage=");
		builder.append(errorMessage);
		builder.append("]");
		return builder.toString();
	}

}
