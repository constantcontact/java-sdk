package com.constantcontact.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A single CURL Response in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class CUrlResponse implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 5529285928376369495L;

	private String body;
	private boolean error;
	private List<CUrlRequestError> info;
	private int statusCode;

	/**
	 * Default constructor.
	 */
	public CUrlResponse() {
		super();
		error = false;
		info = new ArrayList<CUrlRequestError>();
	}

	/**
	 * Requests body.
	 * 
	 * @return Body.
	 */
	public String getBody() {
		return body;
	}

	/**
	 * Sets body.
	 * 
	 * @param body Body.
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * Returns true if error occurs.
	 * 
	 * @return True if error occurs.
	 */
	public boolean isError() {
		return error;
	}

	/**
	 * Sets error.
	 * 
	 * @param error DetailedStatusReportError.
	 */
	public void setError(boolean error) {
		this.error = error;
	}

	/**
	 * Returns list of errors.
	 * 
	 * @return List of errors.
	 */
	public List<CUrlRequestError> getInfo() {
		return info;
	}

	/**
	 * Sets list of errors.
	 * 
	 * @param info List of errors.
	 */
	public void setInfo(List<CUrlRequestError> info) {
		this.info = info;
	}

	/**
	 * Returns true if valid data exists.
	 * 
	 * @return True if valid data exists.
	 */
	public boolean hasData() {
		return !error && body != null & body.trim().length() > 0;
	}

	/**
	 * Gets response status code.
	 * 
	 * @return Response status code.
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets response status code.
	 * 
	 * @param statusCode Response status code.
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Custom implementation for {@link Object#toString()}. 
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CUrlResponse [body=");
		builder.append(body);
		builder.append(", error=");
		builder.append(error);
		builder.append(", info=");
		builder.append(info);
		builder.append(", statusCode=");
		builder.append(statusCode);
		builder.append("]");
		return builder.toString();
	}
}
