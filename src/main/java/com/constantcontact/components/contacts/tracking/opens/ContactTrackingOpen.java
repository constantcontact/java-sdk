package com.constantcontact.components.contacts.tracking.opens;

import java.io.Serializable;

import com.constantcontact.components.contacts.tracking.TrackingContactsBase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Contact Tracking Open for the Contact Tracking Service in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class ContactTrackingOpen extends TrackingContactsBase implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 5137878309576373693L;

	@JsonIgnore
	private String openDate;

	/**
	 * Get the Open Date
	 * 
	 * @return The Open Date
	 */
	@JsonProperty("open_date")
	public String getOpenDate() {
		return openDate;
	}

	/**
	 * Set the Open Date
	 * 
	 * @param openDate The new Open Date
	 */
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	/**
	 * Default constructor.
	 */
	public ContactTrackingOpen() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactTrackingOpen [openDate=");
		builder.append(openDate);
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
