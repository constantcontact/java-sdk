package com.constantcontact.components.activities.contacts.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.constantcontact.components.Component;
import com.constantcontact.services.activities.BulkActivitiesService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Add Contacts Request for the Bulk Activities in Constant Contact.
 * 
 * @see BulkActivitiesService
 * 
 * @author ConstantContact
 * 
 */
public class AddContactsRequest extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -4159172466211912254L;

	/**
	 * Lists : contains the IDs for the lists in which the contacts should be added.
	 */
	@JsonIgnore
	private List<String> lists;

	/**
	 * The column names which will be sent.
	 */
	@JsonIgnore
	private List<String> columnNames;

	/**
	 * Actual List of {@link ContactData} to import.
	 */
	@JsonIgnore
	private List<ContactData> importData;

	/**
	 * Get the lists.
	 * 
	 * @return The {@link #lists}
	 */
	@JsonProperty("lists")
	public List<String> getLists() {
		return lists;
	}

	/**
	 * Get the column names.
	 * 
	 * @return The {@link #columnNames}
	 */
	@JsonProperty("column_names")
	public List<String> getColumnNames() {
		return columnNames;
	}

	/**
	 * Get the import data.
	 * 
	 * @return The {@link #importData}
	 */
	@JsonProperty("import_data")
	public List<ContactData> getImportData() {
		return importData;
	}

	/**
	 * Set the lists.
	 * 
	 * @param lists New value for the {@link #lists}
	 */
	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	/**
	 * Set the comlumn names.
	 * 
	 * @param columnNames New value for the {@link #columnNames}
	 */
	public void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}

	/**
	 * Set the import data.
	 * 
	 * @param importData New value for the {@link #importData}
	 */
	public void setImportData(List<ContactData> importData) {
		this.importData = importData;
	}

	/**
	 * Default constructor.
	 */
	public AddContactsRequest() {
		super();
		this.setImportData(new ArrayList<ContactData>());
		this.setLists(new ArrayList<String>());
		this.setColumnNames(new ArrayList<String>());
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddContactsRequest [lists=");
		builder.append(lists);
		builder.append(", columnNames=");
		builder.append(columnNames);
		builder.append(", importData=");
		builder.append(importData);
		builder.append("]");
		return builder.toString();
	}
}
