package com.constantcontact.components.campaigns;

import java.io.Serializable;
import java.util.Date;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a single Campaign in Constant Contact.
 * 
 * @author ConstantContact
 */
public class Campaign extends Component implements Serializable {
	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 589231135142682430L;

	@JsonIgnore private String id;
	@JsonIgnore private String name;
	@JsonIgnore private String subject;
	@JsonIgnore private String fromName;
	@JsonIgnore private String fromEmail;
	@JsonIgnore private String replyToEmail;
	@JsonIgnore private String campaignType;
	@JsonIgnore private String createdDate;
	@JsonIgnore private Date lastSendDate;
	@JsonIgnore private Date lastEditDate;
	@JsonIgnore private Date lastRunDate;
	@JsonIgnore private Date nextRunDate;
	@JsonIgnore private String status;
	@JsonIgnore private String sharePageUrl;
	@JsonIgnore private boolean isPermissionReminderEnabled;
	@JsonIgnore private String permissionReminderText;
	@JsonIgnore private boolean isViewAsWebpageEnabled;
	@JsonIgnore private boolean viewAsWebPageText;
	@JsonIgnore private boolean viewAsWebPageLinkText;
	@JsonIgnore private String greetingSalutations;
	@JsonIgnore private String greetingName;
	@JsonIgnore private String greetingString;
	@JsonIgnore private String emailContent;
	@JsonIgnore private String textContent;
	
	/**
	 * Gets the id.
	 * @return The campaign id.
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 * @param id The campaign id.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 * @return The name.
	 */
	@JsonProperty("name")
    public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * @param name The name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the subject.
	 * @return The subject.
	 */
	@JsonProperty("subject")
    public String getSubject() {
		return subject;
	}

	/**
	 * Sets the subject.
	 * @param subject The subject.
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Gets the name from.
	 * @return The name from.
	 */
	@JsonProperty("from_name")
    public String getFromName() {
		return fromName;
	}

	/**
	 * Sets the name from.
	 * @param fromName The name from.
	 */
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	/**
	 * Gets the email from.
	 * @return The email from.
	 */
	@JsonProperty("from_email")
    public String getFromEmail() {
		return fromEmail;
	}

    /**
     * Sets the email from.
     * @param fromEmail The email from.
     */
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	/**
	 * Gets the reply email address.
	 * @return The reply email address.
	 */
	@JsonProperty("reply_to_email")
    public String getReplyToEmail() {
		return replyToEmail;
	}

	/**
	 * Sets the reply email address.
	 * @param replyToEmail The reply email address.
	 */
	public void setReplyToEmail(String replyToEmail) {
		this.replyToEmail = replyToEmail;
	}

	/**
	 * Gets the campaign type.
	 * @return The campaign type.
	 */
	@JsonProperty("campaign_type")
    public String getCampaignType() {
		return campaignType;
	}

    /**
     * Sets the campaign type.
     * @param campaignType The campaign type.
     */
	public void setCampaignType(String campaignType) {
		this.campaignType = campaignType;
	}

	/**
	 * Gets the creation date.
	 * @return The creation date.
	 */
	@JsonProperty("created_date")
    public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the creation date.
	 * @param createdDate The creation date.
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the last send date. 
	 * @return The last send date.
	 */
	@JsonProperty("last_send_date")
    public Date getLastSendDate() {
		return lastSendDate;
	}

    /**
     * Sets the last send date.
     * @param lastSendDate The last send date.
     */
	public void setLastSendDate(Date lastSendDate) {
		this.lastSendDate = lastSendDate;
	}

	/**
	 * Gets the last edit date.
	 * @return The last edit date.
	 */
	@JsonProperty("last_edit_date")
    public Date getLastEditDate() {
		return lastEditDate;
	}

	/**
	 * Sets the last edit date.
	 * @param lastEditDate The last edit date.
	 */
	public void setLastEditDate(Date lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

	/**
	 * Gets the last run date.
	 * @return The last run date.
	 */
	@JsonProperty("last_run_date")
    public Date getLastRunDate() {
		return lastRunDate;
	}

	/**
	 * Sets the last run date.
	 * @param lastRunDate The last run date.
	 */
	public void setLastRunDate(Date lastRunDate) {
		this.lastRunDate = lastRunDate;
	}

	/**
	 * Gets the next run date.
	 * @return The next run date.
	 */
	@JsonProperty("next_run_date")
    public Date getNextRunDate() {
		return nextRunDate;
	}

	/**
	 * Sets the next run date.
	 * @param nextRunDate The next run date.
	 */
	public void setNextRunDate(Date nextRunDate) {
		this.nextRunDate = nextRunDate;
	}

	/**
	 * Gets the status.
	 * @return The status.
	 */
	@JsonProperty("status")
    public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 * @param status The status.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

    /// <summary>
    /// Gets or sets the share page URL.
    /// </summary>
	/**
	 * Gets the share page URL.
	 * @return The share page URL.
	 */
	@JsonProperty("share_page_url")
    public String getSharePageUrl() {
		return sharePageUrl;
	}

    /**
     * Sets the share page URL.
     * @param sharePageUrl The share page URL.
     */
	public void setSharePageUrl(String sharePageUrl) {
		this.sharePageUrl = sharePageUrl;
	}

	/**
	 * Gets the permission reminder flag.
	 * @return The permission reminder flag.
	 */
	@JsonProperty("permission_reminder")
    public boolean isPermissionReminderEnabled() {
		return isPermissionReminderEnabled;
	}

	/**
	 * Sets the permission reminder flag
	 * @param isPermissionReminderEnabled
	 */
	public void setPermissionReminderEnabled(boolean isPermissionReminderEnabled) {
		this.isPermissionReminderEnabled = isPermissionReminderEnabled;
	}

	/**
	 * Gets the permission reminder text.
	 * @return The permission reminder text. 
	 */
	@JsonProperty("permission_reminder_text")
    public String getPermissionReminderText() {
		return permissionReminderText;
	}

    /**
     * Sets the permission reminder text.
     * @param permissionReminderText The permission reminder text.
     */
	public void setPermissionReminderText(String permissionReminderText) {
		this.permissionReminderText = permissionReminderText;
	}

	/**
	 * Gets the view as web page flag.
	 * @return The view as web page flag.
	 */
	@JsonProperty("view_as_web_page")
    public boolean isViewAsWebpageEnabled() {
		return isViewAsWebpageEnabled;
	}

	/**
	 * Sets the view as web page flag.
	 * @param isViewAsWebpageEnabled The view as web page flag.
	 */
	public void setViewAsWebpageEnabled(boolean isViewAsWebpageEnabled) {
		this.isViewAsWebpageEnabled = isViewAsWebpageEnabled;
	}

	/**
	 * Gets the view page text.
	 * @return The view page text.
	 */
	@JsonProperty("view_as_web_page_text")
    public boolean getViewAsWebPageText() {
		return viewAsWebPageText;
	}

	/**
	 * Sets the view page text.
	 * @param viewAsWebPageText The view page text.
	 */
	public void setViewAsWebPageText(boolean viewAsWebPageText) {
		this.viewAsWebPageText = viewAsWebPageText;
	}

	/**
	 * Gets the view page link.
	 * @return The view page link.
	 */
	@JsonProperty("view_as_web_page_link_text")
    public boolean getViewAsWebPageLinkText() {
		return viewAsWebPageLinkText;
	}

    /**
     * Gets the view page link.
     * @param viewAsWebPageLinkText The view page link.
     */
	public void setViewAsWebPageLinkText(boolean viewAsWebPageLinkText) {
		this.viewAsWebPageLinkText = viewAsWebPageLinkText;
	}

	/**
	 * Gets the greeting.
	 * @return The greeting.
	 */
	@JsonProperty("greetings_salutations")
    public String getGreetingSalutations() {
		return greetingSalutations;
	}

	/**
	 * Sets the greeting.
	 * @param greetingSalutations The greeting.
	 */
	public void setGreetingSalutations(String greetingSalutations) {
		this.greetingSalutations = greetingSalutations;
	}

	/**
	 * Gets the greeting name.
	 * @return The greeting name.
	 */
	@JsonProperty("greeting_name")
    public String getGreetingName() {
		return greetingName;
	}

	/**
	 * Sets the greeting name.
	 * @param greetingName The greeting name.
	 */
	public void setGreetingName(String greetingName) {
		this.greetingName = greetingName;
	}

	/**
	 * Gets the greeting string.
	 * @return The greeting string.
	 */
	@JsonProperty("greeting_string")
    public String getGreetingString() {
		return greetingString;
	}

	/**
	 * Sets the greeting string.
	 * @param greetingString The greeting string.
	 */
	public void setGreetingString(String greetingString) {
		this.greetingString = greetingString;
	}

	/**
	 * Gets the email content.
	 * @return The email content.
	 */
	@JsonProperty("email_content")
    public String getEmailContent() {
		return emailContent;
	}

	/**
	 * Sets the email content.
	 * @param emailContent The email content.
	 */
	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	/**
	 * Gets the text content.
	 * @return The text content.
	 */
	@JsonProperty("text_content")
    public String getTextContent() {
		return textContent;
	}

	/**
	 * Sets the text content.
	 * @param textContent The text content.
	 */
	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

    /**
     * Class constructor.
     */
    public Campaign() {
    	
    }

}
