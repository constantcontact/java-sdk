package com.constantcontact.components.generic.response;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents Pagination info from a {@link ResultSet} in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class Pagination extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -6194730963581136990L;

	@JsonIgnore
	private String nextLink;

	/**
	 * Get the Next Link
	 * 
	 * @return The Next Link
	 */
	@JsonProperty("next_link")
	public String getNextLink() {
		return nextLink;
	}

	/**
	 * Set the Next Link
	 * 
	 * @param nextLink The Next Link
	 */
	public void setNextLink(String nextLink) {
		this.nextLink = nextLink;
	}

	/**
	 * Default constructor.
	 */
	public Pagination() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pagination [nextLink=");
		builder.append(nextLink);
		builder.append("]");
		return builder.toString();
	}
}
