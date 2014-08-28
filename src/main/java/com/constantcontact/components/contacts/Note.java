package com.constantcontact.components.contacts;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Note info from a {@link Contact} for the Contact Service in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class Note extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 7311187758661669300L;

	@JsonIgnore
	private String id;

	@JsonIgnore
	private String note;

	@JsonIgnore
	private String createdDate;
	
	@JsonIgnore
	private String modifiedDate;

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
	 * @param id The id.
	 */
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the note content.
	 * 
	 * @return The note content.
	 */
	@JsonProperty("note")
	public String getNote() {
		return note;
	}

	/**
	 * Sets the note content.
	 * 
	 * @param note The note content.
	 */
	@JsonProperty("note")
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * Gets the datetime when note was created.
	 * 
	 * @return The datetime when note was created.
	 */
	@JsonProperty("created_date")
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the datetime when note was created.
	 * 
	 * @param createdDate The datetime wen note was created.
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Sets the datetime when note was created.
	 * 
	 * @param modifiedDate The datetime wen note was created.
	 */
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	/**
	 * Gets the datetime when note was last modified.
	 * 
	 * @return The datetime when note was last modified.
	 */
	@JsonProperty("modified_date")
	public String getModifiedDate() {
		return modifiedDate;
	}
	
	/**
	 * Default constructor.
	 */
	public Note() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Note [id=");
		builder.append(id);
		builder.append(", note=");
		builder.append(note);
		builder.append(", createdDate=");
		builder.append(createdDate);
        builder.append(", modifiedDate=");
        builder.append(modifiedDate);		
		builder.append("]");
		return builder.toString();
	}
}
