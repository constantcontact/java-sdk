package com.constantcontact.components.emailcampaigns;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a single Email Campaign Base for the Email Campaign Service in Constant Contact.<br/>
 * Response and Request classes extend this.
 * 
 * @author ConstantContact
 */
public abstract class EmailCampaignBase extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -6034275530457953351L;

	@JsonIgnore
	private String id;
	@JsonIgnore
	private String name;
	@JsonIgnore
	private String subject;
	@JsonIgnore
	private String fromName;
	@JsonIgnore
	private String fromEmail;
	@JsonIgnore
	private String replyToEmail;
	@JsonIgnore
	private String templateType;
	@JsonIgnore
	private String lastRunDate;
	@JsonIgnore
	private String nextRunDate;
	@JsonIgnore
	private String status;
	@JsonIgnore
	private boolean isPermissionReminderEnabled;
	@JsonIgnore
	private String permissionReminderText;
	@JsonIgnore
	private boolean isViewAsWebpageEnabled;
	@JsonIgnore
	private String viewAsWebPageText;
	@JsonIgnore
	private String viewAsWebPageLinkText;
	@JsonIgnore
	private String greetingSalutations;
	@JsonIgnore
	private String greetingName;
	@JsonIgnore
	private String greetingString;
	@JsonIgnore
	private String emailContent;
	@JsonIgnore
	private String textContent;
	@JsonIgnore
	private String styleSheet;
	@JsonIgnore
	private MessageFooter messageFooter;
	@JsonIgnore
	private boolean isVisibleInUi;
	@JsonIgnore
	private String emailContentFormat;
	@JsonIgnore
	private String lastSentDate;
	@JsonIgnore
	private String modifiedDate;
	@JsonIgnore
	private TrackingSummary trackingSummary;
	@JsonIgnore
	private List<SentToContactList> sentToContactLists;
	@JsonIgnore
	private String createdDate;
	@JsonIgnore
	private String archiveStatus;
	@JsonIgnore
	private String archiveUrl;

	/**
	 * Gets the template type.
	 * 
	 * @return The template type, as seen in {@link TemplateType}.
	 */
	@JsonProperty("template_type")
	public String getTemplateType() {
		return templateType;
	}

	/**
	 * Gets the email content.
	 * 
	 * @return The email content.
	 */
	@JsonProperty("email_content")
	public String getEmailContent() {
		return emailContent;
	}

	/**
	 * Get the Email Content Format
	 * 
	 * @return The Email Content Format, as seen in {@link EmailContentFormat}
	 */
	@JsonProperty("email_content_format")
	public String getEmailContentFormat() {
		return emailContentFormat;
	}

	/**
	 * Gets the email from.
	 * 
	 * @return The email from.
	 */
	@JsonProperty("from_email")
	public String getFromEmail() {
		return fromEmail;
	}

	/**
	 * Gets the name from.
	 * 
	 * @return The name from.
	 */
	@JsonProperty("from_name")
	public String getFromName() {
		return fromName;
	}

	/**
	 * Gets the greeting name.
	 * 
	 * @return The greeting name, as seen in {@link GreetingName}.
	 */
	@JsonProperty("greeting_name")
	public String getGreetingName() {
		return greetingName;
	}

	/**
	 * Gets the Greeting Salutations.
	 * 
	 * @return The Greeting Salutations.
	 */
	@JsonProperty("greeting_salutations")
	public String getGreetingSalutations() {
		return greetingSalutations;
	}

	/**
	 * Gets the greeting string.
	 * 
	 * @return The greeting string.
	 */
	@JsonProperty("greeting_string")
	public String getGreetingString() {
		return greetingString;
	}

	/**
	 * Gets the id.
	 * 
	 * @return The id.
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 * Gets the last run date.
	 * 
	 * @return The last run date.
	 */
	@JsonProperty("last_run_date")
	public String getLastRunDate() {
		return lastRunDate;
	}

	/**
	 * Get the Last Sent Date
	 * 
	 * @return The Last Sent Date
	 */
	@JsonProperty("last_sent_date")
	public String getLastSentDate() {
		return lastSentDate;
	}

	/**
	 * Get the Message Footer
	 * 
	 * @return The Message Footer
	 */
	@JsonProperty("message_footer")
	public MessageFooter getMessageFooter() {
		return messageFooter;
	}

	/**
	 * Get the Modified Date
	 * 
	 * @return The Modified Date
	 */
	@JsonProperty("modified_date")
	public String getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * Gets the name.
	 * 
	 * @return The name.
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * Gets the next run date.
	 * 
	 * @return The next run date.
	 */
	@JsonProperty("next_run_date")
	public String getNextRunDate() {
		return nextRunDate;
	}

	/**
	 * Gets the permission reminder text.
	 * 
	 * @return The permission reminder text.
	 */
	@JsonProperty("permission_reminder_text")
	public String getPermissionReminderText() {
		return permissionReminderText;
	}

	/**
	 * Gets the reply email address.
	 * 
	 * @return The reply email address.
	 */
	@JsonProperty("reply_to_email")
	public String getReplyToEmail() {
		return replyToEmail;
	}

	/**
	 * Gets the status.
	 * 
	 * @return The status, as seen in {@link Status}.
	 */
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	/**
	 * Get the Style Sheet
	 * 
	 * @return The Style Sheet
	 */
	@JsonProperty("style_sheet")
	public String getStyleSheet() {
		return styleSheet;
	}

	/**
	 * Gets the subject.
	 * 
	 * @return The subject.
	 */
	@JsonProperty("subject")
	public String getSubject() {
		return subject;
	}

	/**
	 * Gets the text content.
	 * 
	 * @return The text content.
	 */
	@JsonProperty("text_content")
	public String getTextContent() {
		return textContent;
	}

	/**
	 * Gets the View As Web Page Link Text.
	 * 
	 * @return The View As Web Page Link Text.
	 */
	@JsonProperty("view_as_web_page_link_text")
	public String getViewAsWebPageLinkText() {
		return viewAsWebPageLinkText;
	}

	/**
	 * Gets the view as web page text.
	 * 
	 * @return The view as web page text.
	 */
	@JsonProperty("view_as_web_page_text")
	public String getViewAsWebPageText() {
		return viewAsWebPageText;
	}

	/**
	 * Gets the is permission reminder enabled flag.
	 * 
	 * @return The is permission reminder enabled flag.
	 */
	@JsonProperty("is_permission_reminder_enabled")
	public boolean isPermissionReminderEnabled() {
		return isPermissionReminderEnabled;
	}

	/**
	 * Gets the is view as web page enabled flag.
	 * 
	 * @return The is view as web page enabled flag.
	 */
	@JsonProperty("is_view_as_webpage_enabled")
	public boolean isViewAsWebpageEnabled() {
		return isViewAsWebpageEnabled;
	}

	/**
	 * Get the is Visible In Ui flag.
	 * 
	 * @return The is Visible In Ui flag
	 */
	@JsonProperty("is_visible_in_ui")
	public boolean isVisibleInUi() {
		return isVisibleInUi;
	}

	/**
	 * Get the Tracking Summary
	 * 
	 * @return The Tracking Summary
	 */
	@JsonProperty("tracking_summary")
	public TrackingSummary getTrackingSummary() {
		return trackingSummary;
	}

	/**
	 * Get the Sent To Contact Lists
	 * 
	 * @return The Sent To Contact Lists
	 */
	@JsonProperty("sent_to_contact_lists")
	public List<SentToContactList> getSentToContactLists() {
		return sentToContactLists;
	}

	/**
	 * Get the Created Date
	 * 
	 * @return The Created Date
	 */
	@JsonProperty("created_date")
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * Get the Archive Status
	 * 
	 * @return The Archive Status, as seen in the {@link ArchiveStatus}
	 */
	@JsonProperty("archive_status")
	public String getArchiveStatus() {
		return archiveStatus;
	}

	/**
	 * Get the Archive Url
	 * 
	 * @return The Archive Url
	 */
	@JsonProperty("archive_url")
	public String getArchiveUrl() {
		return archiveUrl;
	}

	/**
	 * Sets the template type.
	 * 
	 * @param templateType The template type, as seen in {@link TemplateType}.
	 */
	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	/**
	 * Sets the email content.
	 * 
	 * @param emailContent The email content.
	 */
	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	/**
	 * Set the Email Content Format
	 * 
	 * @param emailContentFormat The Email Content Format, as seen in {@link EmailContentFormat}
	 */
	public void setEmailContentFormat(String emailContentFormat) {
		this.emailContentFormat = emailContentFormat;
	}

	/**
	 * Sets the email from.
	 * 
	 * @param fromEmail The email from.
	 */
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	/**
	 * Sets the name from.
	 * 
	 * @param fromName The name from.
	 */
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	/**
	 * Sets the greeting name.
	 * 
	 * @param greetingName The greeting name, as seen in {@link GreetingName}.
	 */
	public void setGreetingName(String greetingName) {
		this.greetingName = greetingName;
	}

	/**
	 * Sets the Greeting Salutations.
	 * 
	 * @param greetingSalutations The Greeting Salutations.
	 */
	public void setGreetingSalutations(String greetingSalutations) {
		this.greetingSalutations = greetingSalutations;
	}

	/**
	 * Sets the greeting string.
	 * 
	 * @param greetingString The greeting string.
	 */
	public void setGreetingString(String greetingString) {
		this.greetingString = greetingString;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id The id.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the last run date.
	 * 
	 * @param lastRunDate The last run date.
	 */
	public void setLastRunDate(String lastRunDate) {
		this.lastRunDate = lastRunDate;
	}

	/**
	 * Sets the last sent date.
	 * 
	 * @param lastSentDate The last sent date.
	 */
	public void setLastSentDate(String lastSentDate) {
		this.lastSentDate = lastSentDate;
	}

	/**
	 * Set the Message Footer
	 * 
	 * @param messageFooter The Message Footer
	 */
	public void setMessageFooter(MessageFooter messageFooter) {
		this.messageFooter = messageFooter;
	}

	/**
	 * Set the Modified Date
	 * 
	 * @param modifiedDate The Modified Date
	 */
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name The name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the next run date.
	 * 
	 * @param nextRunDate The next run date.
	 */
	public void setNextRunDate(String nextRunDate) {
		this.nextRunDate = nextRunDate;
	}

	/**
	 * Sets the permission reminder flag
	 * 
	 * @param isPermissionReminderEnabled The Permission Reminder Enabled flag
	 */
	public void setPermissionReminderEnabled(boolean isPermissionReminderEnabled) {
		this.isPermissionReminderEnabled = isPermissionReminderEnabled;
	}

	/**
	 * Sets the permission reminder text.
	 * 
	 * @param permissionReminderText The permission reminder text.
	 */
	public void setPermissionReminderText(String permissionReminderText) {
		this.permissionReminderText = permissionReminderText;
	}

	/**
	 * Sets the reply email address.
	 * 
	 * @param replyToEmail The reply email address.
	 */
	public void setReplyToEmail(String replyToEmail) {
		this.replyToEmail = replyToEmail;
	}

	/**
	 * Sets the status.
	 * 
	 * @param status The status, as seen in {@link Status}.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Set the Style Sheet
	 * 
	 * @param styleSheet The Style Sheet
	 */
	public void setStyleSheet(String styleSheet) {
		this.styleSheet = styleSheet;
	}

	/**
	 * Sets the subject.
	 * 
	 * @param subject The subject.
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Sets the text content.
	 * 
	 * @param textContent The text content.
	 */
	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	/**
	 * Sets the view as web page flag.
	 * 
	 * @param isViewAsWebpageEnabled The view as web page flag.
	 */
	public void setViewAsWebpageEnabled(boolean isViewAsWebpageEnabled) {
		this.isViewAsWebpageEnabled = isViewAsWebpageEnabled;
	}

	/**
	 * Gets the view page link.
	 * 
	 * @param viewAsWebPageLinkText The view page link.
	 */
	public void setViewAsWebPageLinkText(String viewAsWebPageLinkText) {
		this.viewAsWebPageLinkText = viewAsWebPageLinkText;
	}

	/**
	 * Sets the view page text.
	 * 
	 * @param viewAsWebPageText The view page text.
	 */
	public void setViewAsWebPageText(String viewAsWebPageText) {
		this.viewAsWebPageText = viewAsWebPageText;
	}

	/**
	 * Set the Visible In Ui flag
	 * 
	 * @param isVisibleInUi The Visible In Ui flag
	 */
	public void setVisibleInUi(boolean isVisibleInUi) {
		this.isVisibleInUi = isVisibleInUi;
	}

	/**
	 * Set the Tracking Summary
	 * 
	 * @param trackingSummary The Tracking Summary
	 */
	public void setTrackingSummary(TrackingSummary trackingSummary) {
		this.trackingSummary = trackingSummary;
	}

	/**
	 * Set the Sent To Contact Lists
	 * 
	 * @param sentToContactLists The Sent To Contact Lists
	 */
	public void setSentToContactLists(List<SentToContactList> sentToContactLists) {
		this.sentToContactLists = sentToContactLists;
	}

	/**
	 * Set the Created Date
	 * 
	 * @param createdDate The Created Date
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Set the Archive Status
	 * 
	 * @param archiveStatus The Archive Status, as seen in {@link ArchiveStatus}
	 */
	public void setArchiveStatus(String archiveStatus) {
		this.archiveStatus = archiveStatus;
	}

	/**
	 * Set the Archive Url
	 * 
	 * @param archiveUrl The Archive Url
	 */
	public void setArchiveUrl(String archiveUrl) {
		this.archiveUrl = archiveUrl;
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignBase() {
		super();
		messageFooter = new MessageFooter();
		trackingSummary = new TrackingSummary();
		sentToContactLists = new ArrayList<SentToContactList>();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailCampaignBase [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", subject=");
		builder.append(subject);
		builder.append(", fromName=");
		builder.append(fromName);
		builder.append(", fromEmail=");
		builder.append(fromEmail);
		builder.append(", replyToEmail=");
		builder.append(replyToEmail);
		builder.append(", templateType=");
		builder.append(templateType);
		builder.append(", lastRunDate=");
		builder.append(lastRunDate);
		builder.append(", nextRunDate=");
		builder.append(nextRunDate);
		builder.append(", status=");
		builder.append(status);
		builder.append(", isPermissionReminderEnabled=");
		builder.append(isPermissionReminderEnabled);
		builder.append(", permissionReminderText=");
		builder.append(permissionReminderText);
		builder.append(", isViewAsWebpageEnabled=");
		builder.append(isViewAsWebpageEnabled);
		builder.append(", viewAsWebPageText=");
		builder.append(viewAsWebPageText);
		builder.append(", viewAsWebPageLinkText=");
		builder.append(viewAsWebPageLinkText);
		builder.append(", greetingSalutations=");
		builder.append(greetingSalutations);
		builder.append(", greetingName=");
		builder.append(greetingName);
		builder.append(", greetingString=");
		builder.append(greetingString);
		builder.append(", emailContent=");
		builder.append(emailContent);
		builder.append(", textContent=");
		builder.append(textContent);
		builder.append(", styleSheet=");
		builder.append(styleSheet);
		builder.append(", messageFooter=");
		builder.append(messageFooter);
		builder.append(", isVisibleInUi=");
		builder.append(isVisibleInUi);
		builder.append(", emailContentFormat=");
		builder.append(emailContentFormat);
		builder.append(", lastSentDate=");
		builder.append(lastSentDate);
		builder.append(", modifiedDate=");
		builder.append(modifiedDate);
		builder.append(", trackingSummary=");
		builder.append(trackingSummary);
		builder.append(", sentToContactLists=");
		builder.append(sentToContactLists);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", archiveStatus=");
		builder.append(archiveStatus);
		builder.append(", archiveUrl=");
		builder.append(archiveUrl);
		builder.append(" ]\n");
		return builder.toString();
	}

	/**
	 * Greeting Name constants for the usage of {@link EmailCampaignBase} in Constant Contact.
	 * 
	 * @author ConstantContact
	 * 
	 */
	public static final class GreetingName {

		/**
		 * FIRST_NAME Greeting Name
		 */
		public static final String FIRST_NAME = "FIRST_NAME";
		/**
		 * LAST_NAME Greeting Name
		 */
		public static final String LAST_NAME = "LAST_NAME";
		/**
		 * FIRST_AND_LAST_NAME Greeting Name
		 */
		public static final String FIRST_AND_LAST_NAME = "FIRST_AND_LAST_NAME";
		/**
		 * NONE - no Greeting Name
		 */
		public static final String NONE = "NONE";

		/**
		 * Default constructor.<br/>
		 * Made private to prevent instantiation.<br/>
		 * This is unreachable from the outside, since current class is used only as a repository for constants.
		 */
		private GreetingName() {
		}
	}

	/**
	 * Status constants for the usage of {@link EmailCampaignBase} in Constant Contact.
	 * 
	 * @author ConstantContact
	 * 
	 */
	public static final class Status {

		/**
		 * DRAFT Status
		 */
		public static final String DRAFT = "DRAFT";
		/**
		 * RUNNING Status
		 */
		public static final String RUNNING = "RUNNING";
		/**
		 * SENT Status
		 */
		public static final String SENT = "SENT";
		/**
		 * SCHEDULED Status
		 */
		public static final String SCHEDULED = "SCHEDULED";

		/**
		 * Default constructor.<br/>
		 * Made private to prevent instantiation.<br/>
		 * This is unreachable from the outside, since current class is used only as a repository for constants.
		 */
		private Status() {
		}
	}

	/**
	 * Template Type constants for the usage of {@link EmailCampaignBase} in Constant Contact.
	 * 
	 * @author ConstantContact
	 * 
	 */
	public static final class TemplateType {

		/**
		 * STOCK Template Type
		 */
		public static final String STOCK = "STOCK";

		/**
		 * CUSTOM Template Type
		 */
		public static final String CUSTOM = "CUSTOM";

		/**
		 * Default constructor.<br/>
		 * Made private to prevent instantiation.<br/>
		 * This is unreachable from the outside, since current class is used only as a repository for constants.
		 */
		private TemplateType() {
		}
	}

	/**
	 * Email Content Format constants for the usage of {@link EmailCampaignBase} in Constant Contact
	 * 
	 * @author ConstantContact
	 * 
	 */
	public static final class EmailContentFormat {

		/**
		 * HTML Email Content Format
		 */
		public static final String HTML = "HTML";
		/**
		 * XHTML Email Content Format
		 */
		public static final String XHTML = "XHTML";

		/**
		 * Default constructor.<br/>
		 * Made private to prevent instantiation.<br/>
		 * This is unreachable from the outside, since current class is used only as a repository for constants.
		 */
		private EmailContentFormat() {
		}
	}

	/**
	 * Archive Status constants for the usage of {@link EmailCampaignBase} in Constant Contact
	 * 
	 * @author ConstantContact
	 * 
	 */
	public static final class ArchiveStatus {
		/**
		 * PENDING Archive Status
		 */
		public static final String PENDING = "PENDING";

		/**
		 * ARCHIVED Archive Status
		 */
		public static final String ARCHIVED = "ARCHIVED";

		/**
		 * Default constructor.<br/>
		 * Made private to prevent instantiation.<br/>
		 * This is unreachable from the outside, since current class is used only as a repository for constants.
		 */
		private ArchiveStatus() {
		}
	}
}
