package com.constantcontact.components.contacts.tracking.bounces;

import java.io.Serializable;

import com.constantcontact.components.contacts.tracking.TrackingContactsBase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contact Tracking Bounce for the Contact Tracking Service in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class ContactTrackingBounce extends TrackingContactsBase implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 6815895243641407999L;

	@JsonIgnore
	private String bounceDate;

	@JsonIgnore
	private String bounceDescription;

	@JsonIgnore
	private String bounceCode;

	@JsonIgnore
	private String bounceMessage;

	/**
	 * Get The Bounce Date
	 * 
	 * @return The Bounce Date
	 */
	@JsonProperty("bounce_date")
	public String getBounceDate() {
		return bounceDate;
	}

	/**
	 * Get The Bounce Description
	 * 
	 * @return The Bounce Description
	 */
	@JsonProperty("bounce_description")
	public String getBounceDescription() {
		return bounceDescription;
	}

	/**
	 * Get The Bounce Code
	 * 
	 * @return The Bounce Code
	 */
	@JsonProperty("bounce_code")
	public String getBounceCode() {
		return bounceCode;
	}

	/**
	 * Get the Bounce Message
	 * 
	 * @return The Bounce Message
	 */
	@JsonProperty("bounce_message")
	public String getBounceMessage() {
		return bounceMessage;
	}

	/**
	 * Set the Bounce Date
	 * 
	 * @param bounceDate The new Bounce Date
	 */
	public void setBounceDate(String bounceDate) {
		this.bounceDate = bounceDate;
	}

	/**
	 * Set the Bounce Description
	 * 
	 * @param bounceDescription The new Bounce Description
	 */
	public void setBounceDescription(String bounceDescription) {
		this.bounceDescription = bounceDescription;
	}

	/**
	 * Set the Bounce Code
	 * 
	 * @param bounceCode The new Bounce Code
	 */
	public void setBounceCode(String bounceCode) {
		this.bounceCode = bounceCode;
	}

	/**
	 * Set the Bounce Message
	 * 
	 * @param bounceMessage The new Bounce Message
	 */
	public void setBounceMessage(String bounceMessage) {
		this.bounceMessage = bounceMessage;
	}

	/**
	 * Default constructor.
	 */
	public ContactTrackingBounce() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactTrackingBounce [bounceDate=");
		builder.append(bounceDate);
		builder.append(", bounceDescription=");
		builder.append(bounceDescription);
		builder.append(", bounceCode=");
		builder.append(bounceCode);
		builder.append(", bounceMessage=");
		builder.append(bounceMessage);
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
