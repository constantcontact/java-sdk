package com.constantcontact.components.emailcampaigns.tracking.forwards;

import java.io.Serializable;

import com.constantcontact.components.common.tracking.TrackingBase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a single Email Campaign Tracking Forward for the Email Campaign Tracking Service in Constant Contact.<br/>
 * 
 * @see TrackingBase
 * 
 * @author ConstantContact
 */
public class EmailCampaignTrackingForward extends TrackingBase implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 1510117010679324994L;

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
	 * @param forwardDate The Forward Date
	 */
	public void setForwardDate(String forwardDate) {
		this.forwardDate = forwardDate;
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignTrackingForward() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailCampaignTrackingForward [forwardDate=");
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
