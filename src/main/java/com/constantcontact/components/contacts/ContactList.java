package com.constantcontact.components.contacts;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Contacts List for the Contact Service in Constant Contact.<br/>
 * It may contain from one to many contacts.<br/>
 * Doesn't actually store any contacts! BUT each {@link Contact} has an internal reference to the list(s) it is a member of.<br>
 * That <i>"list of lists"</i> can be retrieved using {@link Contact#getLists()}
 * 
 * @author ConstantContact
 * 
 */
public class ContactList extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -3791849037551770792L;

	@JsonIgnore
	private String id;
	@JsonIgnore
	private String status;
	@JsonIgnore
	private String name;
	@JsonIgnore
	private int contactCount;
	@JsonIgnore
	private String createdDate;

	/**
	 * Gets the id.
	 * 
	 * @return The id.
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id <code>ContactList</code> id.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the status.
	 * 
	 * @return The status.
	 */
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 * 
	 * @param status The status.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get the Name
	 * 
	 * @return The Name
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	
	/**
	 * Get the creation date
	 * 
	 * @return The creation date
	 */
	@JsonProperty("created_date")
	public String getCreatedDate() {
		return createdDate;
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
	 * Set the name
	 * 
	 * @param name The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set the Contact Count
	 * 
	 * @param contactCount The Contact Count
	 */
	public void setContactCount(int contactCount) {
		this.contactCount = contactCount;
	}
	
	/**
	 * Set the creation date
	 * 
	 * @param createdDate The creation date
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Default constructor.
	 */
	public ContactList() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactList [id=");
		builder.append(id);
		builder.append(", status=");
		builder.append(status);
		builder.append(", name=");
		builder.append(name);
		builder.append(", contactCount=");
		builder.append(contactCount);
		builder.append("]");
		return builder.toString();
	}
}
