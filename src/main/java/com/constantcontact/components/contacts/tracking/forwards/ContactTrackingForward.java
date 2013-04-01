package com.constantcontact.components.contacts.tracking.forwards;

import java.io.Serializable;

import com.constantcontact.components.common.tracking.TrackingBase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A single Contact Tracking Forward for the Contact Tracking Service in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class ContactTrackingForward extends TrackingBase implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -9059163527488525983L;

	@JsonIgnore
	private String forwardDate;

	/**
	 * Get the Forward Date
	 * 
	 * @return The Forward Date
	 */
	@JsonProperty("forward_date")
	public String getForwardDate() {
		return forwardDate;
	}

	/**
	 * Set the Forward Date
	 * 
	 * @param forwardDate The new Forward Date
	 */
	public void setForwardDate(String forwardDate) {
		this.forwardDate = forwardDate;
	}

	/**
	 * Default constructor.
	 */
	public ContactTrackingForward() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactTrackingForward [forwardDate=");
		builder.append(forwardDate);
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
