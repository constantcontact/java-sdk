package com.constantcontact.exceptions.service;

import com.constantcontact.exceptions.ConstantContactException;
import com.constantcontact.exceptions.component.ConstantContactComponentException;

/**
 * Constant Contact Service Exception : the Service-layer class for exceptions in ConstantContact.<br/>
 * Extends the base class, {@link ConstantContactException}<br/>
 * This is the exception being thrown from <b>ALL</b> the Service Layer methods.
 * 
 * @author ConstantContact
 */
public class ConstantContactServiceException extends ConstantContactException {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 2998821787106132436L;

	/**
	 * Response standard error message.
	 */
	public static final String RESPONSE_ERR_SERVICE = "Response came with errors from WebService. Please see error info.";

	/**
	 * Default constructor.
	 */
	public ConstantContactServiceException() {
		super();
	}

	/**
	 * Constructor for Constant Contact Service Exception.
	 * 
	 * @param msg The message
	 */
	public ConstantContactServiceException(String msg) {
		super(msg);
	}

	/**
	 * Constructor for Constant Contact Service Exception.
	 * 
	 * @param msg The message
	 * @param cause The cause
	 */
	public ConstantContactServiceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * Constructor for Constant Contact Service Exception.
	 * 
	 * @param cause The cause
	 */
	public ConstantContactServiceException(Throwable cause) {
		super(cause);
	}

	/**
	 * Dedicated Constructor : will also preserve the error info from the original {@link ConstantContactException}
	 * 
	 * @param constantContactException The {@link ConstantContactException} instance user to create a {@link ConstantContactServiceException}
	 */
	public ConstantContactServiceException(ConstantContactException constantContactException) {
		super(constantContactException);
		this.setErrorInfo(constantContactException.getErrorInfo());
	}

	/**
	 * Dedicated Constructor : will also preserve the error info from the original {@link ConstantContactComponentException}
	 * 
	 * @param constantContactComponentException
	 */
	public ConstantContactServiceException(ConstantContactComponentException constantContactComponentException) {
		super(constantContactComponentException);
		this.setErrorInfo(constantContactComponentException.getErrorInfo());
	}

}
