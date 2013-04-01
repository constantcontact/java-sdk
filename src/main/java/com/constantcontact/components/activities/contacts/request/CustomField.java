package com.constantcontact.components.activities.contacts.request;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.constantcontact.services.activities.BulkActivitiesService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Custom Field for the Bulk Activities in Constant Contact.<br/>
 * Is present in {@link ContactData} as a List.
 * 
 * @see BulkActivitiesService
 * @author ConstantContact
 * 
 */
public class CustomField extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -4863424637566922051L;

	@JsonIgnore
	private String name;

	@JsonIgnore
	private String value;

	/**
	 * Get the name
	 * 
	 * @return The name
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * Get the value
	 * 
	 * @return The value
	 */
	@JsonProperty("value")
	public String getValue() {
		return value;
	}

	/**
	 * Set the name
	 * 
	 * @param name The new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set the value
	 * 
	 * @param value The new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Default constructor.
	 */
	public CustomField() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomField [name=");
		builder.append(name);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}
}
