package com.constantcontact.components.contacts;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Note extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 3334860242693403523L;
	@JsonIgnore private int id;
	@JsonIgnore private String content;
	@JsonIgnore private String createdDate;

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
	 * @param id The id.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the note content.
	 * @return The note content.
	 */
	@JsonProperty("note")
	public String getContent() {
		return content;
	}
	
	/**
	 * Sets the note content.
	 * @param content The note content.
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Gets the datetime when note was created.
	 * @return  The datetime when note was created.
	 */
	@JsonProperty("created_date")
	public String getCreatedDate() {
		return createdDate;
	}
	
	/**
	 * Sets the datetime when note was created.
	 * @param createdDate The datetime wen note was created.
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
}
