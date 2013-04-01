package com.constantcontact.components.activities.contacts.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.constantcontact.components.Component;
import com.constantcontact.components.activities.contacts.types.BulkActivityStatus;
import com.constantcontact.components.activities.contacts.types.BulkActivityType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Detailed Status Report for the Bulk Activities in Constant Contact.<br/>
 * 
 * @author ConstantContact
 * 
 */
public class DetailedStatusReport extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -5342613775085662072L;

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

	@JsonIgnore
	private List<DetailedStatusReportError> errors;

	@JsonIgnore
	private List<DetailedStatusReportError> warnings;

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
	 * Get the type
	 * 
	 * @return The type, as seen in {@link BulkActivityType}
	 */
	@JsonProperty("type")
	public String getType() {
		return type;
	}

	/**
	 * Get the Status
	 * 
	 * @return The Status, as seen in {@link BulkActivityStatus}
	 */
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	/**
	 * Get the Start Date
	 * 
	 * @return The Start Date
	 */
	@JsonProperty("start_date")
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Get the Finish Date
	 * 
	 * @return The Finish Date
	 */
	@JsonProperty("finish_date")
	public String getFinishDate() {
		return finishDate;
	}

	/**
	 * Get the Created Date
	 * 
	 * @return The Created Date
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
	 * Get the Errors
	 * 
	 * @return The Errors
	 */
	@JsonProperty("errors")
	public List<DetailedStatusReportError> getErrors() {
		return errors;
	}

	/**
	 * Get the Warnings
	 * 
	 * @return The Warnings
	 */
	@JsonProperty("warnings")
	public List<DetailedStatusReportError> getWarnings() {
		return warnings;
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
	 * @param type The new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Set the Status
	 * 
	 * @param status The new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Set the Errors
	 * 
	 * @param errors The new Errors
	 */
	public void setErrors(List<DetailedStatusReportError> errors) {
		this.errors = errors;
	}

	/**
	 * Set the Warnings
	 * 
	 * @param warnings The new Warnings
	 */
	public void setWarnings(List<DetailedStatusReportError> warnings) {
		this.warnings = warnings;
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
	public DetailedStatusReport() {
		super();
		this.setErrors(new ArrayList<DetailedStatusReportError>());
		this.setWarnings(new ArrayList<DetailedStatusReportError>());
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DetailedStatusReport [id=");
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
		builder.append(", errors=");
		builder.append(errors);
		builder.append(", warnings=");
		builder.append(warnings);
		builder.append("]");
		return builder.toString();
	}
}
