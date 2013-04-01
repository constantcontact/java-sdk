package com.constantcontact.components.emailcampaigns;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a single Sent to Contact List from {@link EmailCampaignBase} for the Email Campaign Service in Constant Contact.<br/>
 * 
 * @author ConstantContact
 */
public class SentToContactList extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 5085211762805808290L;

	@JsonIgnore
	private String id;

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
	 * Set the id
	 * 
	 * @param id The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Default constructor.
	 */
	public SentToContactList() {
		super();
	}

	/**
	 * Class constructor.<br/>
	 * Will set the id.
	 * 
	 * @param id The new id.
	 */
	public SentToContactList(String id) {
		setId(id);
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SentToContactList [id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
}
