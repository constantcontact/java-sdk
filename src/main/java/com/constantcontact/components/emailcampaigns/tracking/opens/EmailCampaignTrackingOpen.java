package com.constantcontact.components.emailcampaigns.tracking.opens;

import java.io.Serializable;

import com.constantcontact.components.common.tracking.TrackingBase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a single Email Campaign Tracking Open for the Email Campaign Tracking Service in Constant Contact.<br/>
 * 
 * @see TrackingBase
 * 
 * @author ConstantContact
 */
public class EmailCampaignTrackingOpen extends TrackingBase implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 3883403546202204639L;

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
	 * @param openDate The Open Date
	 */
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignTrackingOpen() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailCampaignTrackingOpen [openDate=");
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
