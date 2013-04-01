package com.constantcontact.components.emailcampaigns.activities;

/**
 * Class to store possible values for Email Activity Type for the Email Campaigns Service in Constant Contact.<br/>
 * These are read-only values and are returned by the tracking APIs.<br/>
 * A value from this class should be present where an <code>activityType</code> field is needed.
 * 
 * @author ConstantContact
 * 
 */
public final class EmailActivityType {

	/**
	 * Constant for the EMAIL_CLICK activity type.
	 */
	public static final String EMAIL_CLICK = "EMAIL_CLICK";

	/**
	 * Constant for the EMAIL_BOUNCE activity type.
	 */
	public static final String EMAIL_BOUNCE = "EMAIL_BOUNCE";

	/**
	 * Constant for the EMAIL_FORWARD activity type.
	 */
	public static final String EMAIL_FORWARD = "EMAIL_FORWARD";

	/**
	 * Constant for the EMAIL_OPEN activity type.
	 */
	public static final String EMAIL_OPEN = "EMAIL_OPEN";

	/**
	 * Constant for the EMAIL_SEND activity type.
	 */
	public static final String EMAIL_SEND = "EMAIL_SEND";

	/**
	 * Constant for the EMAIL_UNSUBSCRIBE activity type.
	 */
	public static final String EMAIL_UNSUBSCRIBE = "EMAIL_UNSUBSCRIBE";

	/**
	 * Default constructor.<br/>
	 * Made private to prevent instantiation.<br/>
	 * This is unreachable from the outside, since current class is used only as a repository for constants.
	 */
	private EmailActivityType() {
	}
}
