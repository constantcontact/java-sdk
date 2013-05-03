package com.constantcontact.components.emailcampaigns.tracking.clicks;

import java.io.Serializable;

import com.constantcontact.components.common.tracking.TrackingBase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a single Email Campaign Tracking Click for the Email Campaign Tracking Service in Constant Contact.<br/>
 * 
 * @see TrackingBase
 * 
 * @author ConstantContact
 */
public class EmailCampaignTrackingClick extends TrackingBase implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 7637743469586646792L;

	@JsonIgnore
	private String clickDate;

	@JsonIgnore
	private String linkId;
	
	@JsonIgnore
	private String createdSince;

	/**
	 * Get the Click Date
	 * 
	 * @return The Click Date
	 */
	@JsonProperty("click_date")
	public String getClickDate() {
		return clickDate;
	}

	/**
	 * Get the Link Id
	 * 
	 * @return The Link Id
	 */
	@JsonProperty("link_id")
	public String getLinkId() {
		return linkId;
	}
	
	/**
	 * Get the Created Since Date
	 * 
	 * @return The Created Since Date
	 */
	@JsonProperty("created_since")
	public String getCreatedSince() {
		return createdSince;
	}

	/**
	 * Set the Click Date
	 * 
	 * @param clickDate The Click Date
	 */
	public void setClickDate(String clickDate) {
		this.clickDate = clickDate;
	}

	/**
	 * Set the Link Id
	 * 
	 * @param linkId The Link Id
	 */
	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}
	

	/**
	 * Default constructor.
	 */
	public EmailCampaignTrackingClick() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailCampaignTrackingClick [clickDate=");
		builder.append(clickDate);
		builder.append(", linkId=");
		builder.append(linkId);
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
