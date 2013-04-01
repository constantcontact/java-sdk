package com.constantcontact.components.emailcampaigns.tracking.unsubscribes;

import java.io.Serializable;

import com.constantcontact.components.common.tracking.TrackingBase;
import com.constantcontact.components.generic.sources.UnsubscribeSource;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a single Email Campaign Tracking Unsubscribe for the Email Campaign Tracking Service in Constant Contact.<br/>
 * 
 * @see TrackingBase
 * 
 * @author ConstantContact
 * 
 */
public class EmailCampaignTrackingUnsubscribe extends TrackingBase implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -5192042209130076346L;

	@JsonIgnore
	private String unsubscribeSource;

	@JsonIgnore
	private String unsubscribeDate;

	@JsonIgnore
	private String unsubscribeReason;

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
	 * Get the Unsubscribe Date
	 * 
	 * @return The Unsubscribe Date
	 */
	@JsonProperty("unsubscribe_date")
	public String getUnsubscribeDate() {
		return unsubscribeDate;
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
	 * Set the Unsubscribe Source.<br/>
	 * You should not consider calling this, since Unsubscribe Source is a server-returned value.
	 * 
	 * @param unsubscribeSource The Unsubscribe Source
	 */
	public void setUnsubscribeSource(String unsubscribeSource) {
		this.unsubscribeSource = unsubscribeSource;
	}

	/**
	 * Set the Unsubscribe Date
	 * 
	 * @param unsubscribeDate The Unsubscribe Date
	 */
	public void setUnsubscribeDate(String unsubscribeDate) {
		this.unsubscribeDate = unsubscribeDate;
	}

	/**
	 * Set the Unsubscribe Reason
	 * 
	 * @param unsubscribeReason The Unsubscribe Reason
	 */
	public void setUnsubscribeReason(String unsubscribeReason) {
		this.unsubscribeReason = unsubscribeReason;
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignTrackingUnsubscribe() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailCampaignTrackingUnsubscribe [unsubscribeSource=");
		builder.append(unsubscribeSource);
		builder.append(", unsubscribeDate=");
		builder.append(unsubscribeDate);
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
