package com.constantcontact.components.activities.contacts.types;

/**
 * Possible values for Bulk Activity Status for the Bulk Activities in Constant Contact.<br/>
 * These must be used when calling {@link com.constantcontact.services.activities.BulkActivitiesService#getDetailedStatusReport(String, String, String, String)}
 * 
 * @author ConstantContact
 * 
 */
public final class BulkActivityStatus {
	/**
	 * Status constant for UNCONFIRMED
	 */
	public static final String UNCONFIRMED = "UNCONFIRMED";
	/**
	 * Status constant for PENDING
	 */
	public static final String PENDING = "PENDING";
	/**
	 * Status constant for QUEUED
	 */
	public static final String QUEUED = "QUEUED";
	/**
	 * Status constant for RUNNING
	 */
	public static final String RUNNING = "RUNNING";
	/**
	 * Status constant for COMPLETE
	 */
	public static final String COMPLETE = "COMPLETE";
	/**
	 * Status constant for ERROR
	 */
	public static final String ERROR = "ERROR";

	/**
	 * Default constructor.<br/>
	 * Made private to prevent instantiation.<br/>
	 * This is unreachable from the outside, since current class is used only as a repository for constants.
	 */
	private BulkActivityStatus() {
	}
}
