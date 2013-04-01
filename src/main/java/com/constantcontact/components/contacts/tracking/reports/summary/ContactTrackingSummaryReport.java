package com.constantcontact.components.contacts.tracking.reports.summary;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Contact Tracking Summary Report for the Contact Tracking Service in Constant Contact.<br/>
 * 
 * @author ConstantContact
 * 
 */
public class ContactTrackingSummaryReport extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -2794058141063868485L;

	@JsonIgnore
	private String unsubscribes;

	@JsonIgnore
	private String clicks;

	@JsonIgnore
	private String opens;

	@JsonIgnore
	private String bounces;

	@JsonIgnore
	private String sends;

	@JsonIgnore
	private String forwards;

	@JsonIgnore
	private String contactId;

	/**
	 * Get the number of Unsubscribes
	 * 
	 * @return The Unsubscribes
	 */
	@JsonProperty("unsubscribes")
	public String getUnsubscribes() {
		return unsubscribes;
	}

	/**
	 * Get the number of Clicks
	 * 
	 * @return The Clicks
	 */
	@JsonProperty("clicks")
	public String getClicks() {
		return clicks;
	}

	/**
	 * Get the number of Opens
	 * 
	 * @return The Opens
	 */
	@JsonProperty("opens")
	public String getOpens() {
		return opens;
	}

	/**
	 * Get the number of Bounces
	 * 
	 * @return The Bounces
	 */
	@JsonProperty("bounces")
	public String getBounces() {
		return bounces;
	}

	/**
	 * Get the number of Sends
	 * 
	 * @return The Sends
	 */
	@JsonProperty("sends")
	public String getSends() {
		return sends;
	}

	/**
	 * Get the number of Forwards
	 * 
	 * @return The Forwards
	 */
	@JsonProperty("forwards")
	public String getForwards() {
		return forwards;
	}

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
	 * Set the number of Unsubscribes
	 * 
	 * @param unsubscribes The new number of Unsubscribes
	 */
	public void setUnsubscribes(String unsubscribes) {
		this.unsubscribes = unsubscribes;
	}

	/**
	 * Set the number of Clicks
	 * 
	 * @param clicks The new number of clicks
	 */
	public void setClicks(String clicks) {
		this.clicks = clicks;
	}

	/**
	 * Set the number of Opens
	 * 
	 * @param opens The new number of opens
	 */
	public void setOpens(String opens) {
		this.opens = opens;
	}

	/**
	 * Set the number of Bounces
	 * 
	 * @param bounces The new number of Bounces
	 */
	public void setBounces(String bounces) {
		this.bounces = bounces;
	}

	/**
	 * Set the number of Sends
	 * 
	 * @param sends The new number of Sends
	 */
	public void setSends(String sends) {
		this.sends = sends;
	}

	/**
	 * Set the number of Forwards
	 * 
	 * @param forwards The new number of Forwards
	 */
	public void setForwards(String forwards) {
		this.forwards = forwards;
	}

	/**
	 * Set the contact id
	 * 
	 * @param contactId The new contact id
	 */
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	/**
	 * Default constructor.
	 */
	public ContactTrackingSummaryReport() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactTrackingSummaryReport [unsubscribes=");
		builder.append(unsubscribes);
		builder.append(", clicks=");
		builder.append(clicks);
		builder.append(", opens=");
		builder.append(opens);
		builder.append(", bounces=");
		builder.append(bounces);
		builder.append(", sends=");
		builder.append(sends);
		builder.append(", forwards=");
		builder.append(forwards);
		builder.append(", contactId=");
		builder.append(contactId);
		builder.append("]");
		return builder.toString();
	}
}
