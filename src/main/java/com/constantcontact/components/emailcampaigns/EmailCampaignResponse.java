package com.constantcontact.components.emailcampaigns;

import java.io.Serializable;

/**
 * Represents a single Email Campaign Response for the Email Campaign Service in Constant Contact.<br/>
 * 
 * @author ConstantContact
 * 
 */
public class EmailCampaignResponse extends EmailCampaignBase implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -910224127055912862L;

	/**
	 * Creates a new Email Campaign Request starting from current object's fields.
	 * @return A new {@link EmailCampaignRequest} with all fields cloned from current object's fields.
	 */
	public EmailCampaignRequest toEmailCampaignRequest() {
		return new EmailCampaignRequest(this);
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignResponse() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailCampaignResponse : ");
		builder.append(super.toString());
		return builder.toString();
	}
}
