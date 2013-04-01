package com.constantcontact.components.contacts;

/**
 * Address type constants for the Contact Service in Constant Contact.<br/>
 * Use this whenever an address type field is expected.<br/>
 * Most likely, will be for {@link Address#getAddressType()} and {@link Address#setAddressType(String)}
 * 
 * @author ConstantContact
 */
public final class AddressType {
	/**
	 * Personal Address Type.
	 */
	public static final String PERSONAL = "PERSONAL";

	/**
	 * Business Address Type.
	 */
	public static final String BUSINESS = "BUSINESS";

	/**
	 * Unknown Address Type.
	 */
	public static final String UNKNOWN = "UNKNOWN";

	/**
	 * Default constructor.<br/>
	 * Made private to prevent instantiation.<br/>
	 * This is unreachable from the outside, since current class is used only as a repository for constants.
	 */
	private AddressType() {
	}
}