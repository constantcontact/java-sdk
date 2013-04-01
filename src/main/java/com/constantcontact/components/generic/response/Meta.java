package com.constantcontact.components.generic.response;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents Meta info from a {@link ResultSet} in Constant Contact.<br/>
 * 
 * @author ConstantContact
 * 
 */
public class Meta extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -8506387545461982398L;

	@JsonIgnore
	private Pagination pagination;

	/**
	 * Get the Pagination
	 * @return The Pagination
	 */
	@JsonProperty("pagination")
	public Pagination getPagination() {
		return pagination;
	}

	/**
	 * Set the Pagination
	 * @param pagination The Pagination
	 */
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	/**
	 * Default constructor.
	 */
	public Meta() {
		super();
		pagination = new Pagination();
	}
	
	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Meta [pagination=");
		builder.append(pagination);
		builder.append("]");
		return builder.toString();
	}
}
