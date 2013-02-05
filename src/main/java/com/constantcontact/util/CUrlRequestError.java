package com.constantcontact.util;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CUrlRequestError extends Component implements Serializable {
	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -6549082824239495693L;
	
	@JsonIgnore private String key;
	@JsonIgnore private String message;
	
	/**
	 * Class constructor.
	 */
	public CUrlRequestError() {
		
	}
	
	/**
	 * Gets the error key.
	 * @return The error key.
	 */
	@JsonProperty("error_key")
	public String getKey() {
		return key;
	}
	
	/**
	 * Sets the error key.
	 * @param key The error key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * Get the error message.
	 * @return The error message.
	 */
	@JsonProperty("error_message")
	public String getMessage() {
		return message;
	}
	
	/**
	 * Sets the error message.
	 * @param message The error message.
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
