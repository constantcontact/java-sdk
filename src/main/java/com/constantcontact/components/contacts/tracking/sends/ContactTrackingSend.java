package com.constantcontact.components.contacts.tracking.sends;

import java.io.Serializable;

import com.constantcontact.components.contacts.tracking.TrackingContactsBase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Contact Tracking Send for the Contact Tracking Service in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class ContactTrackingSend extends TrackingContactsBase implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -2261729199369884644L;

	@JsonIgnore
	private String sendDate;

	/**
	 * Get the Send Date
	 * 
	 * @return The Send Date
	 */
	@JsonProperty("send_date")
	public String getSendDate() {
		return sendDate;
	}

	/**
	 * Set the Send Date
	 * 
	 * @param sendDate The new value for Send Date
	 */
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	/**
	 * Default constructor.
	 */
	public ContactTrackingSend() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactTrackingSend [sendDate=");
		builder.append(sendDate);
		builder.append(", getContactId()=");
		builder.append(getContactId());
		builder.append(", getActivityType()=");
		builder.append(getActivityType());
		builder.append(", getCampaignId()=");
		builder.append(getCampaignId());
		builder.append(", getEmailAddress()=");
		builder.append(getEmailAddress());
		builder.append("]");
		return builder.toString();
	}
}
