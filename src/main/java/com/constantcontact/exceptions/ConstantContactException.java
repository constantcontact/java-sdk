package com.constantcontact.exceptions;

import com.constantcontact.util.RawApiRequestError;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for custom exceptions in ConstantContact.<br/>
 * Each layer will extend this to add needed extras.<br/>
 * It stores the regular stuff from {@link Exception} and a customized list of {@link RawApiRequestError} which is populated only when needed.
 * 
 * @author ConstantContact
 */
public class ConstantContactException extends Exception {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -1948722619574065731L;

	/**
	 * Custom list of {@link RawApiRequestError}
	 */
	private List<RawApiRequestError> rawApiRequestErrorInfo;

    /**
     * HTTP status code retrieved from Constant Contact.
     */
    private int httpStatusCode;

    /**
	 * Default constructor.<br/>
	 * Sets the Error Info to an empty ArrayList.
	 */
	public ConstantContactException() {
		super();
		this.rawApiRequestErrorInfo = new ArrayList<RawApiRequestError>();
	}

	/**
	 * Constructor for {@link ConstantContactException}
	 * 
	 * @param msg The message
	 */
	public ConstantContactException(String msg) {
		super(msg);
		this.rawApiRequestErrorInfo = null;
	}

	/**
	 * Constructor for {@link ConstantContactException}
	 * 
	 * @param msg The message
	 * @param cause The cause
	 */
	public ConstantContactException(String msg, Throwable cause) {
		super(msg, cause);
		this.rawApiRequestErrorInfo = null;
	}

	/**
	 * Constructor for {@link ConstantContactException}
	 * 
	 * @param cause The cause
	 */
	public ConstantContactException(Throwable cause) {
		super(cause);
		this.rawApiRequestErrorInfo = null;
	}
	
	/**
	 * Dedicated Constructor : will also preserve the error info from the original {@link ConstantContactException}
	 * @param constantContactException The {@link ConstantContactException} instance user to create a {@link ConstantContactException}
	 */
	public ConstantContactException( ConstantContactException constantContactException) {
		super(constantContactException);
		this.setErrorInfo(constantContactException.getErrorInfo());
        this.setHttpStatusCode(constantContactException.getHttpStatusCode());
	}

	/**
	 * Setter for the error info list. <br/>
	 * This MUST be called after constructor if an error list is needed.
	 * 
	 * @param errorInfo The Error info.
	 */
	public void setErrorInfo(List<RawApiRequestError> errorInfo) {
		this.rawApiRequestErrorInfo = errorInfo;
	}

	/**
	 * Getter for the error info.
	 * 
	 * @return The error info
	 */
	public List<RawApiRequestError> getErrorInfo() {
		return rawApiRequestErrorInfo;
	}

	/**
	 * Checks to see if current instance of {@link ConstantContactException} has error info attached to it.
	 * 
	 * @return True if current instance of {@link ConstantContactException} has error info attached to it.
	 */
	public boolean hasErrorInfo() {
		return rawApiRequestErrorInfo != null && rawApiRequestErrorInfo.size() > 0;
	}


    /**
     * Get the HTTP status code.
     * @return httpsStatusCode
     */
    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    /**
     * Set the HTTP status code.
     * @param httpStatusCode
     */
    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }
}
