package com.constantcontact.components.contacts;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailAddress extends Component implements Serializable {
	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -2361771080992021527L;
	
	@JsonIgnore private String status;
	@JsonIgnore private String confirmStatus;
	@JsonIgnore private String optInSource;
	@JsonIgnore private String optInDate;
	@JsonIgnore private String optOutDate;
	@JsonIgnore private String emailAddress;
	
	/**
	 * Gets the status.
	 * @return The status.
	 */
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 * @param status The status.
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Gets the confirmation status.
	 * @return The confirmation status.
	 */
	@JsonProperty("confirm_status")
	public String getConfirmStatus() {
		return confirmStatus;
	}
	
	/**
	 * Sets the confirmation status.
	 * @param confirmStatus The confirmation status.
	 */
	public void setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}
	
	/**
	 * Gets the OPT source.
	 * @return The OPT source.
	 */
	@JsonProperty("opt_in_source")
	public String getOptInSource() {
		return optInSource;
	}
	
	/**
	 * Sets the OPT source.
	 * @param optInSource The OPT source.
	 */
	public void setOptInSource(String optInSource) {
		this.optInSource = optInSource;
	}
	
	/**
	 * Gets the OPT date.
	 * @return The OPT date.
	 */
	@JsonProperty("opt_in_date")
	public String getOptInDate() {
		return optInDate;
	}
	
	/**
	 * Sets the OPT date.
	 * @param optInDate The OPT date.  
	 */
	public void setOptInDate(String optInDate) {
		this.optInDate = optInDate;
	}
	
	/**
	 * Gets the OPT out date.
	 * @return The OPT out date.
	 */
	@JsonProperty("opt_out_date")
	public String getOptOutDate() {
		return optOutDate;
	}
	
	/**
	 * Sets the OPT out date.
	 * @param optOutDate The OPT out date.
	 */
	public void setOptOutDate(String optOutDate) {
		this.optOutDate = optOutDate;
	}
	
	/**
	 * Gets the email address.
	 * @return The email address.
	 */
	@JsonProperty("email_address")
	public String getEmailAddress() {
		return emailAddress;
	}
	
	/**
	 * Sets the email address.
	 * @param emailAddress The email address.
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	/**
	 * Class constructor.
	 */
	public EmailAddress() {
		
	}
	
	/**
	 * Class constructor.
	 * @param emailAddress
	 */
	public EmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Confirmation status constants.
	 */
    public static final class ConfirmStatus {
    	/**
    	 * Confirmed.
    	 */
        public final static String CONFIRMED = "CONFIRMED";

        /**
         * NoConfirmationRequired.
         */
        public final static String NO_CONFIRMATION_REQUIRED = "NO_CONFIRMATION_REQUIRED";

        /**
         * Unconfirmed.
         */
        public final static String UNCONFIRMED = "UNCONFIRMED";
    }

    /**
     * Option source constants.
     */
    public static final class OptInSource {
    	/**
    	 * ActionByVisitor.
    	 */
        public final static String ACTION_BY_VISITOR = "ACTION_BY_VISITOR";

        /**
         * ActionByOwner.
         */
        public final static String ACTION_BY_OWNER = "ACTION_BY_OWNER";
    }
}
