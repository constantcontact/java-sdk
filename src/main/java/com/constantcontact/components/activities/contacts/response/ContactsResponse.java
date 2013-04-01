package com.constantcontact.components.activities.contacts.response;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.constantcontact.components.activities.contacts.types.BulkActivityType;
import com.constantcontact.services.activities.BulkActivitiesService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contacts Response for the Bulk Activities in Constant Contact.<br/>
 * Used in the add, clear, export and remove operations.<br/>
 * 
 * @see BulkActivitiesService
 * 
 * @author ConstantContact
 * 
 */
public class ContactsResponse extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 5451405939022314032L;

	@JsonIgnore
	private String id;

	/**
	 * The type field, as returned by the server.
	 */
	@JsonIgnore
	private String type;

	@JsonIgnore
	private int errorCount;

	@JsonIgnore
	private int contactCount;

	/**
	 * @return The id.
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 * Get the type.
	 * 
	 * @return The type, as seen in {@link BulkActivityType}
	 */
	@JsonProperty("type")
	public String getType() {
		return type;
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
	public ContactsResponse() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactsResponse [id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append(", errorCount=");
		builder.append(errorCount);
		builder.append(", contactCount=");
		builder.append(contactCount);
		builder.append("]");
		return builder.toString();
	}
}
