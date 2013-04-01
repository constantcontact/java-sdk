package com.constantcontact.components.activities.contacts.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.constantcontact.components.Component;
import com.constantcontact.services.activities.BulkActivitiesService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Remove Contacts Request for the Bulk Activities in Constant Contact.
 * 
 * @see BulkActivitiesService
 * @author ConstantContact
 * 
 */
public class RemoveContactsRequest extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 4272772734698990338L;

	@JsonIgnore
	private List<ContactDataLightValue> importData;

	@JsonIgnore
	private List<String> lists;

	/**
	 * Get the Import Data
	 * 
	 * @return The Import Data
	 */
	@JsonProperty("import_data")
	public List<ContactDataLightValue> getImportData() {
		return importData;
	}

	/**
	 * Get the Lists
	 * 
	 * @return The Lists
	 */
	@JsonProperty("lists")
	public List<String> getLists() {
		return lists;
	}

	/**
	 * Set the Import Data
	 * 
	 * @param importData The new Import Data
	 */
	public void setImportData(List<ContactDataLightValue> importData) {
		this.importData = importData;
	}

	/**
	 * Set the Lists
	 * 
	 * @param lists The new Lists
	 */
	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	/**
	 * Default constructor.
	 */
	public RemoveContactsRequest() {
		super();
		this.setImportData(new ArrayList<ContactDataLightValue>());
		this.setLists(new ArrayList<String>());
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RemoveContactsRequest [importData=");
		builder.append(importData);
		builder.append("]");
		return builder.toString();
	}
}
