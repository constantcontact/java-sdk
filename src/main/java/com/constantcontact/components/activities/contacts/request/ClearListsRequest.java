package com.constantcontact.components.activities.contacts.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.constantcontact.components.Component;
import com.constantcontact.services.activities.BulkActivitiesService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clear Lists Request for the Bulk Activities in Constant Contact.
 * 
 * @see BulkActivitiesService
 * 
 * @author ConstantContact
 * 
 */
public class ClearListsRequest extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -2338680803946019508L;

	/**
	 * lists
	 */
	@JsonIgnore
	private List<String> lists;

	/**
	 * Get the lists.
	 * 
	 * @return The lists as a {@link List} of String , containing the list ids..
	 */
	@JsonProperty("lists")
	public List<String> getLists() {
		return lists;
	}

	/**
	 * Set the lists
	 * 
	 * @param lists New value for the lists.
	 */
	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	/**
	 * Default constructor.
	 */
	public ClearListsRequest() {
		super();
		this.setLists(new ArrayList<String>());
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClearListsRequest [lists=");
		builder.append(lists);
		builder.append("]");
		return builder.toString();
	}
}
