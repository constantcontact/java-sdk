package com.constantcontact.components.emailcampaigns.tracking.bounces;

import java.io.Serializable;

import com.constantcontact.components.common.tracking.TrackingBase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a single Email Campaign Tracking Bounce for the Email Campaign Tracking Service in Constant Contact.<br/>
 * 
 * @see TrackingBase
 * 
 * @author ConstantContact
 */
public class EmailCampaignTrackingBounce extends TrackingBase implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 6920759567154207286L;

	@JsonIgnore
	private String bounceDescription;

	@JsonIgnore
	private String bounceMessage;

	@JsonIgnore
	private String bounceCode;

	@JsonIgnore
	private String bounceDate;

	/**
	 * Get the Bounce Description
	 * 
	 * @return The Bounce Description
	 */
	@JsonProperty("bounce_description")
	public String getBounceDescription() {
		return bounceDescription;
	}

	/**
	 * Get The Bounce Message
	 * 
	 * @return The Bounce Message
	 */
	@JsonProperty("bounce_message")
	public String getBounceMessage() {
		return bounceMessage;
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
	 * Get the Bounce Date
	 * 
	 * @return The Bounce Date
	 */
	@JsonProperty("bounce_date")
	public String getBounceDate() {
		return bounceDate;
	}

	/**
	 * Set the Bounce Description
	 * 
	 * @param bounceDescription The Bounce Description
	 */
	public void setBounceDescription(String bounceDescription) {
		this.bounceDescription = bounceDescription;
	}

	/**
	 * Set the Bounce Message
	 * 
	 * @param bounceMessage The Bounce Message
	 */
	public void setBounceMessage(String bounceMessage) {
		this.bounceMessage = bounceMessage;
	}

	/**
	 * Set the Bounce Code
	 * 
	 * @param bounceCode The Bounce Code
	 */
	public void setBounceCode(String bounceCode) {
		this.bounceCode = bounceCode;
	}

	/**
	 * Set the Bounce Date
	 * 
	 * @param bounceDate The Bounce Date
	 */
	public void setBounceDate(String bounceDate) {
		this.bounceDate = bounceDate;
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignTrackingBounce() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailCampaignTrackingBounce [bounceDescription=");
		builder.append(bounceDescription);
		builder.append(", bounceMessage=");
		builder.append(bounceMessage);
		builder.append(", bounceCode=");
		builder.append(bounceCode);
		builder.append(", bounceDate=");
		builder.append(bounceDate);
		builder.append(", getActivityType()=");
		builder.append(getActivityType());
		builder.append(", getContactId()=");
		builder.append(getContactId());
		builder.append(", getCampaignId()=");
		builder.append(getCampaignId());
		builder.append(", getEmailAddress()=");
		builder.append(getEmailAddress());
		builder.append("]");
		return builder.toString();
	}
}
