package com.constantcontact.v2.campaigns;

import android.os.Parcel;
import android.os.Parcelable;
import com.constantcontact.v2.tracking.TrackingSummary;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author woogienoogie
 */
@JsonFilter("RequestFilter")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Campaign implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelableArray(_clickThroughDetails, flags);
        dest.writeLong(_createdDate != null ? _createdDate.getTime() : - 1);
        dest.writeString(_emailContent);
        dest.writeString(_emailContentFormat);
        dest.writeString(_fromEmail);
        dest.writeString(_fromName);
        dest.writeString(_greetingName);
        dest.writeString(_greetingSalutations);
        dest.writeString(_greetingString);
        dest.writeString(_id);
        dest.writeByte(_isPermissionReminderEnabled ? (byte) 1 : (byte) 0);
        dest.writeByte(_isViewAsWebpageEnabled ? (byte) 1 : (byte) 0);
        dest.writeLong(_lastRunDate != null ? _lastRunDate.getTime() : - 1);
        dest.writeParcelable(_messageFooter, flags);
        dest.writeLong(_modifiedDate != null ? _modifiedDate.getTime() : - 1);
        dest.writeString(_name);
        dest.writeLong(_nextRunDate != null ? _nextRunDate.getTime() : - 1);
        dest.writeString(_permalinkUrl);
        dest.writeString(_permissionReminderText);
        dest.writeString(_replyToEmail);
        dest.writeParcelableArray(_sentToContactLists, flags);
        dest.writeInt(_status == null ? - 1 : _status.ordinal());
        dest.writeString(_styleSheet);
        dest.writeString(_subject);
        dest.writeString(_templateType);
        dest.writeString(_textContent);
        dest.writeParcelable(_trackingSummary, flags);
        dest.writeString(_viewAsWebPageLinkText);
        dest.writeString(_viewAsWebPageText);
    }

    protected Campaign(Parcel in) {
        _clickThroughDetails = in.createTypedArray(ClickThroughDetail.CREATOR);
        long tmp_createdDate = in.readLong();
        _createdDate = tmp_createdDate == - 1 ? null : new Date(tmp_createdDate);
        _emailContent = in.readString();
        _emailContentFormat = in.readString();
        _fromEmail = in.readString();
        _fromName = in.readString();
        _greetingName = in.readString();
        _greetingSalutations = in.readString();
        _greetingString = in.readString();
        _id = in.readString();
        _isPermissionReminderEnabled = in.readByte() != 0;
        _isViewAsWebpageEnabled = in.readByte() != 0;
        long tmp_lastRunDate = in.readLong();
        _lastRunDate = tmp_lastRunDate == - 1 ? null : new Date(tmp_lastRunDate);
        _messageFooter = in.readParcelable(MessageFooter.class.getClassLoader());
        long tmp_modifiedDate = in.readLong();
        _modifiedDate = tmp_modifiedDate == - 1 ? null : new Date(tmp_modifiedDate);
        _name = in.readString();
        long tmp_nextRunDate = in.readLong();
        _nextRunDate = tmp_nextRunDate == - 1 ? null : new Date(tmp_nextRunDate);
        _permalinkUrl = in.readString();
        _permissionReminderText = in.readString();
        _replyToEmail = in.readString();
        _sentToContactLists = in.createTypedArray(SentToContactList.CREATOR);
        int tmp_status = in.readInt();
        _status = tmp_status == - 1 ? null : CampaignStatus.values()[tmp_status];
        _styleSheet = in.readString();
        _subject = in.readString();
        _templateType = in.readString();
        _textContent = in.readString();
        _trackingSummary = in.readParcelable(TrackingSummary.class.getClassLoader());
        _viewAsWebPageLinkText = in.readString();
        _viewAsWebPageText = in.readString();
    }

    public static final Creator<Campaign> CREATOR = new Creator<Campaign>() {
        @Override
        public Campaign createFromParcel(Parcel source) {
            return new Campaign(source);
        }

        @Override
        public Campaign[] newArray(int size) {
            return new Campaign[size];
        }
    };
}
