package com.constantcontact.components.emailcampaigns.schedules;

import java.io.Serializable;

import com.constantcontact.ConstantContact;
import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Email Campaign Schedule for the Email Campaign Schedule Service in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class EmailCampaignSchedule extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -7894919041579290495L;

	@JsonIgnore
	private String id;

	@JsonIgnore
	private String scheduledDate;

	/**
	 * Constructor using fields..
	 * 
	 * @param id
	 * @param scheduledDate
	 */
	public EmailCampaignSchedule(String id, String scheduledDate) {
		super();
		this.id = id;
		this.scheduledDate = scheduledDate;
	}

	/**
	 * Constructor using fields.<br/>
	 * Will set the {@link #id} field to null.<br/>
	 * Caller must manually set it to desired value after.<br/>
	 * Reason: please see {@link ConstantContact#addEmailCampaignSchedule(String, EmailCampaignSchedule)}
	 * 
	 * 
	 * @param scheduledDate
	 */
	public EmailCampaignSchedule(String scheduledDate) {
		super();
		this.id = null;
		this.scheduledDate = scheduledDate;
	}

	/**
	 * Default constructor.<br/>
	 * Will set the {@link #id} field to null.<br/>
	 * Caller must manually set it to desired value after.<br/>
	 * Reason: please see {@link ConstantContact#addEmailCampaignSchedule(String, EmailCampaignSchedule)}
	 */
	public EmailCampaignSchedule() {
		id = null;
	}

	/**
	 * Get the id
	 * 
	 * @return The id
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 * Get the Scheduled Date
	 * 
	 * @return The Scheduled Date
	 */
	@JsonProperty("scheduled_date")
	public String getScheduledDate() {
		return scheduledDate;
	}

	/**
	 * Set the Id
	 * 
	 * @param id The Id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Set the Scheduled Date
	 * 
	 * @param scheduledDate The Scheduled Date
	 */
	public void setScheduledDate(String scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailCampaignSchedule [id=");
		builder.append(id);
		builder.append(", scheduledDate=");
		builder.append(scheduledDate);
		builder.append("]");
		return builder.toString();
	}
}
