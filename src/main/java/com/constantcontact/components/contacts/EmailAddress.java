package com.constantcontact.components.contacts;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Email Address info from a {@link Contact} for the Contact Service in Constant Contact.<br/>
 * 
 * @author ConstantContact
 * 
 */
public class EmailAddress extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -4207156837520974802L;
	
	@JsonIgnore
	private String id;
	
	@JsonIgnore
	private String status;

	@JsonIgnore
	private String confirmStatus;

	@JsonIgnore
	private String optInSource;

	@JsonIgnore
	private String optInDate;

	@JsonIgnore
	private String optOutDate;

	@JsonIgnore
	private String emailAddress;

	/**
	 * Gets the id.
	 * 
	 * @return The id.
	 */
	@JsonIgnore
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id <code>Contact</code> id
	 */
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}
	
	
	/**
	 * Gets the status.
	 * 
	 * @return The status.
	 */
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 * 
	 * @param status The status.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the confirmation status.
	 * 
	 * @return The confirmation status, as seen in {@link ConfirmStatus}.
	 */
	@JsonProperty("confirm_status")
	public String getConfirmStatus() {
		return confirmStatus;
	}

	/**
	 * Sets the confirmation status.
	 * 
	 * @param confirmStatus The confirmation status, as seen in {@link ConfirmStatus}.
	 */
	public void setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}

	/**
	 * Gets the opt in source.
	 * 
	 * @return The Opt in source, as seen in {@link OptInSource}.
	 */
	@JsonProperty("opt_in_source")
	public String getOptInSource() {
		return optInSource;
	}

	/**
	 * Sets the opt in source.
	 * 
	 * @param optInSource The opt in source, as seen in {@link OptInSource}.
	 */
	public void setOptInSource(String optInSource) {
		this.optInSource = optInSource;
	}

	/**
	 * Gets the OPT date.
	 * 
	 * @return The OPT date.
	 */
	@JsonProperty("opt_in_date")
	public String getOptInDate() {
		return optInDate;
	}

	/**
	 * Sets the OPT date.
	 * 
	 * @param optInDate The OPT date.
	 */
	public void setOptInDate(String optInDate) {
		this.optInDate = optInDate;
	}

	/**
	 * Gets the OPT out date.
	 * 
	 * @return The OPT out date.
	 */
	@JsonProperty("opt_out_date")
	public String getOptOutDate() {
		return optOutDate;
	}

	/**
	 * Sets the OPT out date.
	 * 
	 * @param optOutDate The OPT out date.
	 */
	public void setOptOutDate(String optOutDate) {
		this.optOutDate = optOutDate;
	}

	/**
	 * Gets the email address.
	 * 
	 * @return The email address.
	 */
	@JsonProperty("email_address")
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Sets the email address.
	 * 
	 * @param emailAddress The email address.
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Default constructor.
	 */
	public EmailAddress() {
		super();
	}

	/**
	 * Class constructor.<br/>
	 * Only sets the email address field.
	 * 
	 * @param emailAddress The email address field
	 */
	public EmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailAddress [status=");
		builder.append(status);
		builder.append(", confirmStatus=");
		builder.append(confirmStatus);
		builder.append(", optInSource=");
		builder.append(optInSource);
		builder.append(", optInDate=");
		builder.append(optInDate);
		builder.append(", optOutDate=");
		builder.append(optOutDate);
		builder.append(", emailAddress=");
		builder.append(emailAddress);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * Confirmation status constants for the usage of {@link EmailAddress}.
	 * 
	 * @author ConstantContact
	 */
	public static final class ConfirmStatus {
		/**
		 * Confirmed Status.
		 */
		public final static String CONFIRMED = "CONFIRMED";

		/**
		 * No Confirmation Required Status.
		 */
		public final static String NO_CONFIRMATION_REQUIRED = "NO_CONFIRMATION_REQUIRED";

		/**
		 * Unconfirmed Status.
		 */
		public final static String UNCONFIRMED = "UNCONFIRMED";

		/**
		 * Default constructor.<br/>
		 * Made private to prevent instantiation.<br/>
		 * This is unreachable from the outside, since current class is used only as a repository for constants.
		 */
		private ConfirmStatus() {
		}
	}

	/**
	 * Opt In Source constants for the usage of {@link EmailAddress}.
	 * 
	 * @author ConstantContact
	 * 
	 */
	public static final class OptInSource {
		/**
		 * Action By Visitor Opt In Source.
		 */
		public final static String ACTION_BY_VISITOR = "ACTION_BY_VISITOR";

		/**
		 * Action By Owner Opt In Source.
		 */
		public final static String ACTION_BY_OWNER = "ACTION_BY_OWNER";

		/**
		 * Default constructor.<br/>
		 * Made private to prevent instantiation.<br/>
		 * This is unreachable from the outside, since current class is used only as a repository for constants.
		 */
		private OptInSource() {
		}
	}
}
