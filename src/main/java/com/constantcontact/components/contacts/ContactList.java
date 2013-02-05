package com.constantcontact.components.contacts;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactList extends Component implements Serializable {
	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 3334860242693406033L;

	@JsonIgnore private int id;
	@JsonIgnore private String status;
	
	/**
	 * Gets the id.
	 * @return The id.
	 */
	@JsonProperty("id")
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 * @param id <code>ContactList</code> id.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the status.
	 * @return The status.
	 */
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 * @param status The status.
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Class constructor.
	 */
	public ContactList() {
		
	}
}
