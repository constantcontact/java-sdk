package com.constantcontact.components.activities.contacts.response;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Detailed Status Report Error for the Bulk Activities in Constant Contact.<br/>
 * Is present in {@link DetailedStatusReport} where it encapsulates both errors and warnings as lists.
 * 
 * @author ConstantContact
 * 
 */
public class DetailedStatusReportError extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 168527491944100077L;

	@JsonIgnore
	private String message;

	@JsonIgnore
	private int lineNumber;

	@JsonIgnore
	private String emailAddress;

	/**
	 * Get the Error Message, as it was returned from the server side
	 * 
	 * @return The Message
	 */
	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	/**
	 * Get the Line Number
	 * 
	 * @return The Line Number
	 */
	@JsonProperty("line_number")
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * Get the Email Address for which the error/warning occurred
	 * 
	 * @return The Email Address
	 */
	@JsonProperty("email_address")
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Set the Error Message
	 * 
	 * @param message The new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Set the Line Number
	 * 
	 * @param lineNumber The new LineNumber
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	/**
	 * Set the Email Address
	 * 
	 * @param emailAddress The new Email Address
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Default constructor.
	 */
	public DetailedStatusReportError() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DetailedStatusReportError [message=");
		builder.append(message);
		builder.append(", lineNumber=");
		builder.append(lineNumber);
		builder.append(", emailAddress=");
		builder.append(emailAddress);
		builder.append("]");
		return builder.toString();
	}

}
