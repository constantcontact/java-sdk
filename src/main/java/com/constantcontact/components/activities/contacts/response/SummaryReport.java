package com.constantcontact.components.activities.contacts.response;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.constantcontact.components.activities.contacts.types.BulkActivityStatus;
import com.constantcontact.components.activities.contacts.types.BulkActivityType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Summary Report for the Bulk Activities in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class SummaryReport extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 9146350464338804485L;

	@JsonIgnore
	private String id;

	@JsonIgnore
	private String type;

	@JsonIgnore
	private String status;

	@JsonIgnore
	private String startDate;

	@JsonIgnore
	private String finishDate;

	@JsonIgnore
	private String createdDate;

	@JsonIgnore
	private int errorCount;

	@JsonIgnore
	private int contactCount;

	/**
	 * Get the Id
	 * 
	 * @return The Id
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 * Get the type
	 * 
	 * @return The type, as seen in {@link BulkActivityType}
	 */
	@JsonProperty("type")
	public String getType() {
		return type;
	}

	/**
	 * Get the status
	 * 
	 * @return The status, as seen in {@link BulkActivityStatus}
	 */
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	/**
	 * Get The start date
	 * 
	 * @return The start date
	 */
	@JsonProperty("start_date")
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Get The Finish date
	 * 
	 * @return The Finish date
	 */
	@JsonProperty("finish_date")
	public String getFinishDate() {
		return finishDate;
	}

	/**
	 * Get The Created date
	 * 
	 * @return The Created date
	 */
	@JsonProperty("created_date")
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * Get the Error Count
	 * 
	 * @return The Error Count
	 */
	@JsonProperty("error_count")
	public int getErrorCount() {
		return errorCount;
	}

	/**
	 * Get the Contact Count
	 * 
	 * @return The Contact Count
	 */
	@JsonProperty("contact_count")
	public int getContactCount() {
		return contactCount;
	}

	/**
	 * Set the id
	 * 
	 * @param id The new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Set the type
	 * 
	 * @param type The new type, as seen in {@link BulkActivityType}
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Set the status
	 * 
	 * @param status The new status, as seen in {@link BulkActivityStatus}
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Set the Start Date
	 * 
	 * @param startDate The new Start Date
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * Set the Finish Date
	 * 
	 * @param finishDate The new Finish Date
	 */
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	/**
	 * Set the Created Date
	 * 
	 * @param createdDate The new Created Date
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Set the Error Count
	 * 
	 * @param errorCount The new Error Count
	 */
	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}

	/**
	 * Set the Contact Count
	 * 
	 * @param contactCount The new Contact Count
	 */
	public void setContactCount(int contactCount) {
		this.contactCount = contactCount;
	}

	/**
	 * Default constructor.
	 */
	public SummaryReport() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SummaryReport [id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append(", status=");
		builder.append(status);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", finishDate=");
		builder.append(finishDate);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", errorCount=");
		builder.append(errorCount);
		builder.append(", contactCount=");
		builder.append(contactCount);
		builder.append("]\n");
		return builder.toString();
	}
}
