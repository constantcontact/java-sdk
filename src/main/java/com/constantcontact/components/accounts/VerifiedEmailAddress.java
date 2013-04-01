package com.constantcontact.components.accounts;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.constantcontact.services.accounts.AccountService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a single Verified Email Address for the usage of Account Service in Constant Contact.
 * 
 * @see AccountService
 * 
 * @author ConstantContact
 * 
 */
public class VerifiedEmailAddress extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 8453979505689978725L;

	/**
	 * Email Address
	 */
	@JsonIgnore
	private String emailAddress;

	/**
	 * Status
	 */
	@JsonIgnore
	private String status;

	/**
	 * Get the Email Address
	 * 
	 * @return The {@link #emailAddress}
	 */
	@JsonProperty("email_address")
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Get the Status
	 * 
	 * @return The {@link #status}
	 */
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	/**
	 * Set the Email Address.
	 * 
	 * @param emailAddress The new Email Address
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Set the status.
	 * 
	 * @param status The new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Default constructor.
	 */
	public VerifiedEmailAddress() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VerifiedEmailAddress [emailAddress=");
		builder.append(emailAddress);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * Status constants for a Verified Email Address.
	 */
	public static final class Status {
		/**
		 * Confirmed
		 */
		public static final String CONFIRMED = "CONFIRMED";

		/**
		 * Unconfirmed.
		 */
		public static final String UNCONFIRMED = "UNCONFIRMED";

		/**
		 * Default constructor.<br/>
		 * Made private to prevent instantiation.<br/>
		 * This is unreachable from the outside, since current class is used only as a repository for constants.
		 */
		private Status() {
		}
	}
}
