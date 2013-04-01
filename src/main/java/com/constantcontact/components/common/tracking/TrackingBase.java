package com.constantcontact.components.common.tracking;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.constantcontact.components.emailcampaigns.activities.EmailActivityType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Base class for all the Email Campaign Tracking classes used by the Email Campaign Tracking Service in Constant Contact.<br/>
 * Base class for all the Contact Tracking classes used by the Contact Tracking Service in Constant Contact.<br/>
 * It defines the common fields:
 * <ul>
 * <li>Contact Id</li>
 * <li>Activity Type</li>
 * <li>Campaign Id</li>
 * <li>Email Address</li>
 * </ul>
 * 
 * Each sub-class will come with a particular value for Activity Type, depending on the answer type.<br/>
 * Each sub-class will also add its own new fields, depending on the business logic.
 * 
 * @author ConstantContact
 * 
 */
public class TrackingBase extends Component implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7805521792484834466L;

	@JsonIgnore
	private String contactId;

	@JsonIgnore
	private String activityType;

	@JsonIgnore
	private String campaignId;

	@JsonIgnore
	private String emailAddress;

	/**
	 * Get the Contact Id
	 * 
	 * @return The Contact Id
	 */
	@JsonProperty("contact_id")
	public String getContactId() {
		return contactId;
	}

	/**
	 * Get the Activity Type field.<br/>
	 * Each sub-class will hold a different value, depending on its purpose.
	 * 
	 * @return The Activity Type, as seen in {@link EmailActivityType}
	 */
	@JsonProperty("activity_type")
	public String getActivityType() {
		return activityType;
	}

	/**
	 * Get the Campaign Id
	 * 
	 * @return The Campaign Id
	 */
	@JsonProperty("campaign_id")
	public String getCampaignId() {
		return campaignId;
	}

	/**
	 * Get the Email Address
	 * 
	 * @return The Email Address
	 */
	@JsonProperty("email_address")
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Set the Contact Id
	 * 
	 * @param contactId The Contact Id
	 */
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	/**
	 * Set the Activity Type.<br/>
	 * Shouldn't really call this, since it's a server-returned value.
	 * 
	 * @param activityType The Activity Type, as seen in {@link EmailActivityType}
	 */
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	/**
	 * Set the Campaign Id
	 * 
	 * @param campaignId The Campaign Id
	 */
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	/**
	 * Set the Email Address
	 * 
	 * @param emailAddress The Email Address
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Default constructor.
	 */
	public TrackingBase() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TrackingBase [contactId=");
		builder.append(contactId);
		builder.append(", activityType=");
		builder.append(activityType);
		builder.append(", campaignId=");
		builder.append(campaignId);
		builder.append(", emailAddress=");
		builder.append(emailAddress);
		builder.append("]");
		return builder.toString();
	}
}
