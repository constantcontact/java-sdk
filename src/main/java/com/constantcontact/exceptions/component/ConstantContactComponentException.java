package com.constantcontact.exceptions.component;

import com.constantcontact.exceptions.ConstantContactException;

/**
 * A Constant Contact Component Exception in ConstantContact.<br/>
 * Thrown when something went wrong in the Component processing flow (conversion from and to JSON, etc).
 * 
 * @author ConstantContact
 * 
 */
public class ConstantContactComponentException extends ConstantContactException {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -218186850033468013L;

	/**
	 * Default constructor.
	 */
	public ConstantContactComponentException() {
		super();
	}

	/**
	 * Constructor for Constant Contact Component Exception
	 * 
	 * @param msg The message
	 */
	public ConstantContactComponentException(String msg) {
		super(msg);
	}

	/**
	 * Constructor for Constant Contact Component Exception
	 * 
	 * @param msg The message
	 * @param cause The cause
	 */
	public ConstantContactComponentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * Constructor for Constant Contact Component Exception
	 * 
	 * @param cause The cause
	 */
	public ConstantContactComponentException(Throwable cause) {
		super(cause);
	}

	/**
	 * Copy Constructor for Constant Contact Component Exception.<br/>
	 * Preserves the error info.
	 * 
	 * @param constantContactException The Constant Contact Exception
	 */
	public ConstantContactComponentException(ConstantContactException constantContactException) {
		super(constantContactException);
		this.setErrorInfo(constantContactException.getErrorInfo());
	}
}