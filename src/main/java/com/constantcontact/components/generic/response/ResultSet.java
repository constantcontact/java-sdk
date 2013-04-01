package com.constantcontact.components.generic.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a generic Data Result Set in Constant Contact.<br/>
 * This will model search results in Constant Contact.<br/>
 * Uses a generic List to model the results node.<br/>
 * Widely used by all services.
 * 
 * @author ConstantContact
 * 
 */
public class ResultSet<T> extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 5167810855693534133L;

	@JsonIgnore
	private Meta meta;
	@JsonIgnore
	private List<T> results;

	/**
	 * Get the Meta
	 * 
	 * @return The Meta
	 */
	@JsonProperty("meta")
	public Meta getMeta() {
		return meta;
	}

	/**
	 * Get the Results
	 * 
	 * @return The Results
	 */
	@JsonProperty("results")
	public List<T> getResults() {
		return results;
	}

	/**
	 * Set the Meta data
	 * 
	 * @param meta The meta data
	 */
	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	/**
	 * Set the Results
	 * 
	 * @param results The Results
	 */
	public void setResults(List<T> results) {
		this.results = results;
	}

	/**
	 * This method is intended to allow the ResultSet class to be used close to a {@link List}.
	 * 
	 * @return The size of the inner list.
	 */
	public int size() {
		return results.size();
	}

	/**
	 * This method is intended to allow the ResultSet class to be used close to a {@link List}.
	 * 
	 * @param index The index inside the inner list;
	 * @return The element at the given position
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
	 */
	public T get(int index) throws IndexOutOfBoundsException {
		return results.get(index);
	}

	/**
	 * Default constructor.
	 */
	public ResultSet() {
		super();
		meta = new Meta();
		results = new ArrayList<T>(); // to avoid NullPointerException in some places
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResultSet [meta=");
		builder.append(meta);
		builder.append(",\n results=");
		builder.append(results);
		builder.append("]\n");
		return builder.toString();
	}
}
