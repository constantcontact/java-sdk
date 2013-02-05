package com.constantcontact.util;

import java.util.List;

/**
 * URL response class.
 * 
 * @author ConstantContact
 *
 */
public class CUrlResponse {
	private String body;
	private boolean error;
	private List<CUrlRequestError> info;
	private int statusCode;

	/**
	 * Class constructor
	 */
	public CUrlResponse() {
		error = false;
	}
	
	/**
	 * Requests body.
	 * @return Body.
	 */
	public String getBody() {
		return body;
	}
	
	/**
	 * Sets body.
	 * @param body Body.
	 */
	public void setBody(String body) {
		this.body = body;
	}
	
	/**
	 * Returns true if error occurs.
	 * @return True if error occurs.
	 */
	public boolean isError() {
		return error;
	}
	
	/**
	 * Sets error.
	 * @param error Error.
	 */
	public void setError(boolean error) {
		this.error = error;
	}
	
	/**
	 * Returns list of errors.
	 * @return List of errors.
	 */
	public List<CUrlRequestError> getInfo() {
		return info;
	}
	
	/**
	 * Sets list of errors.
	 * @param info List of errors.
	 */
	public void setInfo(List<CUrlRequestError> info) {
		this.info = info;
	}
	
	/**
	 * Returns true if valid data exists.
	 * @return True if valid data exists.
	 */
	public boolean hasData() {
		return !error && body != null & body.trim().length() > 0;
	}
	
	/**
	 * Gets response status code.
	 * @return Response status code.
	 */
	public int getStatusCode() {
		return statusCode;
	}
	
	/**
	 * Sets response status code.
	 * @param statusCode Response status code.
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
