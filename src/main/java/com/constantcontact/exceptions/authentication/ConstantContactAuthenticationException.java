package com.constantcontact.exceptions.authentication;

import com.constantcontact.exceptions.ConstantContactException;

/**
 * A Constant Contact Authentication Exception in ConstantContact.<br/>
 * Thrown when something went wrong in the authentication flow.
 * 
 * @author ConstantContact
 * 
 */
public class ConstantContactAuthenticationException extends ConstantContactException {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 6188199430151546992L;

	/**
	 * Default constructor.
	 */
	public ConstantContactAuthenticationException() {
		super();
	}

	/**
	 * Constructor for Constant Contact Authentication Exception
	 * 
	 * @param msg The message
	 */
	public ConstantContactAuthenticationException(String msg) {
		super(msg);
	}

	/**
	 * Constructor for Constant Contact Authentication Exception
	 * 
	 * @param msg The message
	 * @param cause The cause
	 */
	public ConstantContactAuthenticationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * Constructor for Constant Contact Authentication Exception
	 * 
	 * @param cause The cause
	 */
	public ConstantContactAuthenticationException(Throwable cause) {
		super(cause);
	}

	/**
	 * Copy Constructor for Constant Contact Authentication Exception
	 * 
	 * @param constantContactException The Constant Contact Exception
	 */
	public ConstantContactAuthenticationException(ConstantContactException constantContactException) {
		super(constantContactException);
	}
}
