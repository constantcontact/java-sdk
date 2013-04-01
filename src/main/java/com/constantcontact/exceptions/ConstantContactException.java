package com.constantcontact.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.constantcontact.util.CUrlRequestError;

/**
 * Base class for custom exceptions in ConstantContact.<br/>
 * Each layer will extend this to add needed extras.<br/>
 * It stores the regular stuff from {@link Exception} and a customized list of {@link CUrlRequestError} which is populated only when needed.
 * 
 * @author ConstantContact
 */
public class ConstantContactException extends Exception {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -1948722619574065731L;

	/**
	 * Custom list of {@link CUrlRequestError}
	 */
	private List<CUrlRequestError> errorInfo;

	/**
	 * Default constructor.<br/>
	 * Sets the Error Info to an empty ArrayList.
	 */
	public ConstantContactException() {
		super();
		this.errorInfo = new ArrayList<CUrlRequestError>();
	}

	/**
	 * Constructor for {@link ConstantContactException}
	 * 
	 * @param msg The message
	 */
	public ConstantContactException(String msg) {
		super(msg);
		this.errorInfo = null;
	}

	/**
	 * Constructor for {@link ConstantContactException}
	 * 
	 * @param msg The message
	 * @param cause The cause
	 */
	public ConstantContactException(String msg, Throwable cause) {
		super(msg, cause);
		this.errorInfo = null;
	}

	/**
	 * Constructor for {@link ConstantContactException}
	 * 
	 * @param cause The cause
	 */
	public ConstantContactException(Throwable cause) {
		super(cause);
		this.errorInfo = null;
	}
	
	/**
	 * Dedicated Constructor : will also preserve the error info from the original {@link ConstantContactException}
	 * @param constantContactException The {@link ConstantContactException} instance user to create a {@link ConstantContactException}
	 */
	public ConstantContactException( ConstantContactException constantContactException) {
		super(constantContactException);
		this.setErrorInfo(constantContactException.getErrorInfo());
	}

	/**
	 * Setter for the error info list. <br/>
	 * This MUST be called after constructor if an error list is needed.
	 * 
	 * @param errorInfo The Error info.
	 */
	public void setErrorInfo(List<CUrlRequestError> errorInfo) {
		this.errorInfo = errorInfo;
	}

	/**
	 * Getter for the error info.
	 * 
	 * @return The error info
	 */
	public List<CUrlRequestError> getErrorInfo() {
		return errorInfo;
	}

	/**
	 * Checks to see if current instance of {@link ConstantContactException} has error info attached to it.
	 * 
	 * @return True if current instance of {@link ConstantContactException} has error info attached to it.
	 */
	public boolean hasErrorInfo() {
		return errorInfo != null && errorInfo.size() > 0;
	}
}
