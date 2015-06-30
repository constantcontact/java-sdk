package com.constantcontact.components.emailcampaigns;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Represents a single Email Campaign Request for the Email Campaign Service in Constant Contact.<br/>
 * Always use this class when creating a request, and not the base one!<br/>
 * The private inner fields are just the same as in {@link EmailCampaignBase}, but JSON annotations are different for the overwritten, hiding fields forbidden by the server.
 * 
 * @author ConstantContact
 * 
 */
public class EmailCampaignRequest extends EmailCampaignBase implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -770582603450175038L;

	/**
	 * Override of {@link EmailCampaignBase#getLastRunDate()} to hide it via JsonIgnore.<br/>
	 * Reason: server returns an error when this field appears in a request.
	 * 
	 * @return Call to parent method
	 */
	@Override
	@JsonIgnore
	public String getLastRunDate() {
		return super.getLastRunDate();
	}

	/**
	 * Override of {@link EmailCampaignBase#getId()} to hide it via JsonIgnore.<br/>
	 * Reason: server returns an error when this field appears in a request.
	 * 
	 * @return Call to parent method
	 */
	@Override
	@JsonIgnore
	public String getId() {
		return super.getId();
	}

	/**
	 * Override of {@link EmailCampaignBase#getNextRunDate()} to hide it via JsonIgnore.<br/>
	 * Reason: server returns an error when this field appears in a request.
	 * 
	 * @return Call to parent method
	 */
	@Override
	@JsonIgnore
	public String getNextRunDate() {
		return super.getNextRunDate();
	}

	/**
	 * Override of {@link EmailCampaignBase#getLastSentDate()} to hide it via JsonIgnore.<br/>
	 * Reason: server returns an error when this field appears in a request.
	 * 
	 * @return Call to parent method
	 */
	@Override
	@JsonIgnore
	public String getLastSentDate() {
		return super.getLastSentDate();
	}

	/**
	 * Override of {@link EmailCampaignBase#getModifiedDate()} to hide it via JsonIgnore.<br/>
	 * Reason: server returns an error when this field appears in a request.
	 * 
	 * @return Call to parent method
	 */
	@Override
	@JsonIgnore
	public String getModifiedDate() {
		return super.getModifiedDate();
	}
	
	/**
	 * Override of {@link EmailCampaignBase#getPermalinkUrl()} to hide it via JsonIgnore.<br/>
	 * Reason: server returns an error when this field appears in a request.
	 * 
	 * @return Call to parent method
	 */
	@Override
	@JsonIgnore
	public String getPermalinkUrl() {
		return super.getPermalinkUrl();
	}

	/**
	 * Override of {@link EmailCampaignBase#getSentToContactLists()} to hide it via JsonIgnore.<br/>
	 * Reason: server returns an error when this field appears in a request.
	 * 
	 * @return Call to parent method
	 */
	@Override
	public List<SentToContactList> getSentToContactLists() {
		return super.getSentToContactLists();
	}

	/**
	 * Override of {@link EmailCampaignBase#getCreatedDate()} to hide it via JsonIgnore.<br/>
	 * Reason: server returns an error when this field appears in a request.
	 * 
	 * @return Call to parent method
	 */
	@Override
	@JsonIgnore
	public String getCreatedDate() {
		return super.getCreatedDate();
	}

	/**
	 * Override of {@link EmailCampaignBase#isVisibleInUi()} to hide it via JsonIgnore.<br/>
	 * Reason: server returns an error when this field appears in a request.
	 * 
	 * @return Call to parent method
	 */
	@Override
	@JsonIgnore
	public boolean isVisibleInUi() {
		return super.isVisibleInUi();
	}

	/**
	 * Override of {@link EmailCampaignBase#getTrackingSummary()} to hide it via JsonIgnore.<br/>
	 * Reason: server returns an error when this field appears in a request.
	 * 
	 * @return Call to parent method
	 */
	@Override
	@JsonIgnore
	public TrackingSummary getTrackingSummary() {
		return super.getTrackingSummary();
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignRequest() {
		super();
	}

	/**
	 * Constructor to copy data field by field from a response to a request
	 * 
	 * @param response The Email Campaign Response to clone.
	 */
	public EmailCampaignRequest(EmailCampaignResponse response) {
		setId(response.getId());
		setName(response.getName());
		setSubject(response.getSubject());
		setFromName(response.getFromName());
		setFromEmail(response.getFromEmail());
		setReplyToEmail(response.getReplyToEmail());
		setTemplateType(response.getTemplateType());
		setLastRunDate(response.getLastRunDate());
		setNextRunDate(response.getNextRunDate());
		setStatus(response.getStatus());
		setPermissionReminderEnabled(response.isPermissionReminderEnabled());
		setPermissionReminderText(response.getPermissionReminderText());
		setViewAsWebpageEnabled(response.isViewAsWebpageEnabled());
		setViewAsWebPageText(response.getViewAsWebPageText());
		setViewAsWebPageLinkText(response.getViewAsWebPageLinkText());
		setGreetingSalutations(response.getGreetingSalutations());
		setGreetingName(response.getGreetingName());
		setGreetingString(response.getGreetingString());
		setEmailContent(response.getEmailContent());
		setTextContent(response.getTextContent());
		setStyleSheet(response.getStyleSheet());
		setMessageFooter(response.getMessageFooter());
		setVisibleInUi(response.isVisibleInUi());
		setEmailContentFormat(response.getEmailContentFormat());
		setLastSentDate(response.getLastSentDate());
		setModifiedDate(response.getModifiedDate());
		setTrackingSummary(response.getTrackingSummary());
		setSentToContactLists(response.getSentToContactLists());
		setCreatedDate(response.getCreatedDate());
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailCampaignRequest : ");
		builder.append(super.toString());
		return builder.toString();
	}
}
