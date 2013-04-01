package com.constantcontact.components.generic.sources;

import com.constantcontact.components.contacts.tracking.unsubscribes.ContactTrackingUnsubscribe;
import com.constantcontact.components.emailcampaigns.tracking.unsubscribes.EmailCampaignTrackingUnsubscribe;

/**
 * Possible values for the Unsubscribe Source in {@link ContactTrackingUnsubscribe} and {@link EmailCampaignTrackingUnsubscribe} in Constant Contact.<br/>
 * 
 * @author ConstantContact
 * 
 */
public final class UnsubscribeSource {
	/**
	 * ACTION_BY_CUSTOMER Unsubscribe Source.
	 */
	public static final String ACTION_BY_CUSTOMER = "ACTION_BY_CUSTOMER";
	/**
	 * ACTION_BY_OWNER Unsubscribe Source.
	 */
	public static final String ACTION_BY_OWNER = "ACTION_BY_OWNER";

	/**
	 * Default constructor.<br/>
	 * Made private to prevent instantiation.<br/>
	 * This is unreachable from the outside, since current class is used only as a repository for constants.
	 */
	private UnsubscribeSource() {
	}
}