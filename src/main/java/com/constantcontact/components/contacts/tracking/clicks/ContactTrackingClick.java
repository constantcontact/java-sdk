package com.constantcontact.components.contacts.tracking.clicks;

import java.io.Serializable;

import com.constantcontact.components.contacts.tracking.TrackingContactsBase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A single Contact Tracking Click for the Contact Tracking Service in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class ContactTrackingClick extends TrackingContactsBase implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 3744540981693595318L;

	@JsonIgnore
	private String linkId;

	@JsonIgnore
	private String linkUri;

	@JsonIgnore
	private String clickDate;

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
	 * Get the Link Uri
	 * 
	 * @return The Link Uri
	 */
	@JsonProperty("link_uri")
	public String getLinkUri() {
		return linkUri;
	}

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
	 * Set the Link Id
	 * 
	 * @param linkId The new Link Id
	 */
	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	/**
	 * Set the Link Uri
	 * 
	 * @param linkUri The new Link Uri
	 */
	public void setLinkUri(String linkUri) {
		this.linkUri = linkUri;
	}

	/**
	 * Set the Click Date
	 * 
	 * @param clickDate The new Click Date
	 */
	public void setClickDate(String clickDate) {
		this.clickDate = clickDate;
	}

	/**
	 * Default constructor.
	 */
	public ContactTrackingClick() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactTrackingClick [linkId=");
		builder.append(linkId);
		builder.append(", linkUri=");
		builder.append(linkUri);
		builder.append(", clickDate=");
		builder.append(clickDate);
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
