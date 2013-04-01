package com.constantcontact.components.contacts.tracking.unsubscribes;

import java.io.Serializable;

import com.constantcontact.components.common.tracking.TrackingBase;
import com.constantcontact.components.generic.sources.UnsubscribeSource;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Contact Tracking Unsubscribe for the Contact Tracking Service in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class ContactTrackingUnsubscribe extends TrackingBase implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -455189472338482853L;

	@JsonIgnore
	private String unsubscribeDate;

	/**
	 * The unsubscribeSource field.
	 */
	@JsonIgnore
	private String unsubscribeSource;

	/**
	 * 
	 */
	@JsonIgnore
	private String unsubscribeReason;

	/**
	 * Get the Unsubscribe Date
	 * 
	 * @return The Unsubscribe Date
	 */
	@JsonProperty("unsubscribe_date")
	public String getUnsubscribeDate() {
		return unsubscribeDate;
	}

	/**
	 * Get the Unsubscribe Source
	 * 
	 * @return The Unsubscribe Source, as seen in {@link UnsubscribeSource}
	 */
	@JsonProperty("unsubscribe_source")
	public String getUnsubscribeSource() {
		return unsubscribeSource;
	}

	/**
	 * Get the Unsubscribe Reason
	 * 
	 * @return The Unsubscribe Reason
	 */
	@JsonProperty("unsubscribe_reason")
	public String getUnsubscribeReason() {
		return unsubscribeReason;
	}

	/**
	 * Set the Unsubscribe Date
	 * 
	 * @param unsubscribeDate The new value for Unsubscribe Date
	 */
	public void setUnsubscribeDate(String unsubscribeDate) {
		this.unsubscribeDate = unsubscribeDate;
	}

	/**
	 * Set the Unsubscribe Source
	 * 
	 * @param unsubscribeSource The new value for Unsubscribe Source
	 */
	public void setUnsubscribeSource(String unsubscribeSource) {
		this.unsubscribeSource = unsubscribeSource;
	}

	/**
	 * Set the Unsubscribe Reason
	 * 
	 * @param unsubscribeReason The new value for Unsubscribe Reason
	 */
	public void setUnsubscribeReason(String unsubscribeReason) {
		this.unsubscribeReason = unsubscribeReason;
	}

	/**
	 * Default constructor.
	 */
	public ContactTrackingUnsubscribe() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactTrackingUnsubscribe [unsubscribeDate=");
		builder.append(unsubscribeDate);
		builder.append(", unsubscribeSource=");
		builder.append(unsubscribeSource);
		builder.append(", unsubscribeReason=");
		builder.append(unsubscribeReason);
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
