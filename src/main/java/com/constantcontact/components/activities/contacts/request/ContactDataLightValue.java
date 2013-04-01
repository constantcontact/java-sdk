package com.constantcontact.components.activities.contacts.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.constantcontact.components.Component;
import com.constantcontact.services.activities.BulkActivitiesService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contact Data Light Value for the Bulk Activities in Constant Contact.<br/>
 * This class only contains the Emails list and is intended for use in Remove Contact operation only.
 * 
 * @see BulkActivitiesService
 * @author ConstantContact
 * 
 */
public class ContactDataLightValue extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 7977470190380411163L;

	@JsonIgnore
	private List<String> emailAddresses;

	/**
	 * Get the Email Addresses
	 * 
	 * @return The Email Addresses
	 */
	@JsonProperty("email_addresses")
	public List<String> getEmailAddresses() {
		return emailAddresses;
	}

	/**
	 * Set the Email Addresses
	 * 
	 * @param emailAddresses The new Email Addresses
	 */
	public void setEmailAddresses(List<String> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	/**
	 * Default constructor.
	 */
	public ContactDataLightValue() {
		super();
		setEmailAddresses(new ArrayList<String>());
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactDataLightValue [emailAddresses=");
		builder.append(emailAddresses);
		builder.append("]");
		return builder.toString();
	}
}
