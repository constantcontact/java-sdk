package com.constantcontact.components.emailcampaigns.tracking.sends;

import java.io.Serializable;

import com.constantcontact.components.common.tracking.TrackingBase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a single Email Campaign Tracking Send for the Email Campaign Tracking Service in Constant Contact.<br/>
 * 
 * @see TrackingBase
 * 
 * @author ConstantContact
 * 
 */
public class EmailCampaignTrackingSend extends TrackingBase implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -2157427833935660118L;

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
	 * @param sendDate The Send Date
	 */
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignTrackingSend() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailCampaignTrackingSend [sendDate=");
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
