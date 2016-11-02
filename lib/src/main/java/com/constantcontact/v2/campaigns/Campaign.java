package com.constantcontact.v2.campaigns;

import com.constantcontact.v2.tracking.TrackingSummary;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author woogienoogie
 */
@JsonFilter("RequestFilter")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Campaign implements Serializable {
    @JsonProperty("click_through_details")
    protected ClickThroughDetail[] _clickThroughDetails;

    @JsonProperty("created_date")
    protected Date _createdDate;

    @JsonProperty("email_content")
    protected String _emailContent;

    @JsonProperty("email_content_format")
    protected String _emailContentFormat;

    @JsonProperty("from_email")
    protected String _fromEmail;

    @JsonProperty("from_name")
    protected String _fromName;

    @JsonProperty("greeting_name")
    protected String _greetingName;

    @JsonProperty("greeting_salutations")
    protected String _greetingSalutations;

    @JsonProperty("greeting_string")
    protected String _greetingString;

    @JsonProperty("id")
    protected String _id;

    @JsonProperty("is_permission_reminder_enabled")
    protected boolean _isPermissionReminderEnabled;

    @JsonProperty("is_view_as_webpage_enabled")
    protected boolean _isViewAsWebpageEnabled;

    @JsonProperty("last_run_date")
    protected Date _lastRunDate;

    @JsonProperty("message_footer")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected MessageFooter _messageFooter;

    @JsonProperty("modified_date")
    protected Date _modifiedDate;

    @JsonProperty("name")
    protected String _name;

    @JsonProperty("next_run_date")
    protected Date _nextRunDate;

    @JsonProperty("permalink_url")
    protected String _permalinkUrl;

    @JsonProperty("permission_reminder_text")
    protected String _permissionReminderText;

    @JsonProperty("reply_to_email")
    protected String _replyToEmail;

    @JsonProperty("sent_to_contact_lists")
    protected SentToContactList[] _sentToContactLists;

    @JsonProperty("status")
    protected CampaignStatus _status;

    @JsonProperty("style_sheet")
    protected String _styleSheet;

    @JsonProperty("subject")
    protected String _subject;

    @JsonProperty("template_type")
    protected String _templateType;

    @JsonProperty("text_content")
    protected String _textContent;

    @JsonProperty("tracking_summary")
    protected TrackingSummary _trackingSummary;

    @JsonProperty("view_as_web_page_link_text")
    protected String _viewAsWebPageLinkText;

    @JsonProperty("view_as_web_page_text")
    protected String _viewAsWebPageText;

    /**
     * Class Creator
     */
    public Campaign() {
    }

    public ClickThroughDetail[] getClickThroughDetails() {
        return _clickThroughDetails;
    }

    public void setClickThroughDetails(ClickThroughDetail[] clickThroughDetails) {
        _clickThroughDetails = clickThroughDetails;
    }

    public Date getCreatedDate() {
        return _createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        _createdDate = createdDate;
    }

    public String getEmailContent() {
        return _emailContent;
    }

    public void setEmailContent(String emailContent) {
        _emailContent = emailContent;
    }

    public String getEmailContentFormat() {
        return _emailContentFormat;
    }

    public void setEmailContentFormat(String emailContentFormat) {
        _emailContentFormat = emailContentFormat;
    }

    public String getFromEmail() {
        return _fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        _fromEmail = fromEmail;
    }

    public String getFromName() {
        return _fromName;
    }

    public void setFromName(String fromName) {
        _fromName = fromName;
    }

    public String getGreetingName() {
        return _greetingName;
    }

    public void setGreetingName(String greetingName) {
        _greetingName = greetingName;
    }

    public String getGreetingSalutations() {
        return _greetingSalutations;
    }

    public void setGreetingSalutations(String greetingSalutations) {
        _greetingSalutations = greetingSalutations;
    }

    public String getGreetingString() {
        return _greetingString;
    }

    public void setGreetingString(String greetingString) {
        _greetingString = greetingString;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }

    public boolean isPermissionReminderEnabled() {
        return _isPermissionReminderEnabled;
    }

    public void setPermissionReminderEnabled(boolean isPermissionReminderEnabled) {
        _isPermissionReminderEnabled = isPermissionReminderEnabled;
    }

    public boolean isViewAsWebpageEnabled() {
        return _isViewAsWebpageEnabled;
    }

    public void setViewAsWebpageEnabled(boolean isViewAsWebpageEnabled) {
        _isViewAsWebpageEnabled = isViewAsWebpageEnabled;
    }

    public Date getLastRunDate() {
        return _lastRunDate;
    }

    public void setLastRunDate(Date lastRunDate) {
        _lastRunDate = lastRunDate;
    }

    public MessageFooter getMessageFooter() {
        return _messageFooter;
    }

    public void setMessageFooter(MessageFooter messageFooter) {
        _messageFooter = messageFooter;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public Date getNextRunDate() {
        return _nextRunDate;
    }

    public void setNextRunDate(Date nextRunDate) {
        _nextRunDate = nextRunDate;
    }

    public String getPermalinkUrl() {
        return _permalinkUrl;
    }

    public void setPermalinkUrl(String permalinkUrl) {
        _permalinkUrl = permalinkUrl;
    }

    public String getPermissionReminderText() {
        return _permissionReminderText;
    }

    public void setPermissionReminderText(String permissionReminderText) {
        _permissionReminderText = permissionReminderText;
    }

    public String getReplyToEmail() {
        return _replyToEmail;
    }

    public void setReplyToEmail(String replyToEmail) {
        _replyToEmail = replyToEmail;
    }

    public SentToContactList[] getSentToContactLists() {
        return _sentToContactLists;
    }

    public void setSentToContactLists(SentToContactList[] sentToContactLists) {
        _sentToContactLists = sentToContactLists;
    }

    public CampaignStatus getStatus() {
        return _status;
    }

    public void setStatus(CampaignStatus status) {
        _status = status;
    }

    public String getStyleSheet() {
        return _styleSheet;
    }

    public void setStyleSheet(String styleSheet) {
        _styleSheet = styleSheet;
    }

    public String getSubject() {
        return _subject;
    }

    public void setSubject(String subject) {
        _subject = subject;
    }

    public String getTemplateType() {
        return _templateType;
    }

    public void setTemplateType(String templateType) {
        _templateType = templateType;
    }

    public String getTextContent() {
        return _textContent;
    }

    public void setTextContent(String textContent) {
        _textContent = textContent;
    }

    public TrackingSummary getTrackingSummary() {
        return _trackingSummary;
    }

    public void setTrackingSummary(TrackingSummary trackingSummary) {
        _trackingSummary = trackingSummary;
    }

    public String getViewAsWebPageLinkText() {
        return _viewAsWebPageLinkText;
    }

    public void setViewAsWebPageLinkText(String viewAsWebPageLinkText) {
        _viewAsWebPageLinkText = viewAsWebPageLinkText;
    }

    public String getViewAsWebPageText() {
        return _viewAsWebPageText;
    }

    public void setViewAsWebPageText(String viewAsWebPageText) {
        _viewAsWebPageText = viewAsWebPageText;
    }
}
