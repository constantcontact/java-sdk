package com.constantcontact.v2.campaigns;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class CampaignPreview implements Parcelable {
    @JsonProperty("from_email")
    protected String _fromEmail;

    @JsonProperty("reply_to_email")
    protected String _replyTomail;

    @JsonProperty("subject")
    protected String _subject;

    @JsonProperty("preview_email_content")
    protected String _previewHtml;

    @JsonProperty("preview_text_content")
    protected String _previewText;

    public CampaignPreview() {
    }

    public String getFromEmail() {
        return _fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        _fromEmail = fromEmail;
    }

    public String getReplyTomail() {
        return _replyTomail;
    }

    public void setReplyTomail(String replyTomail) {
        _replyTomail = replyTomail;
    }

    public String getSubject() {
        return _subject;
    }

    public void setSubject(String subject) {
        _subject = subject;
    }

    public String getPreviewHtml() {
        return _previewHtml;
    }

    public void setPreviewHtml(String previewHtml) {
        _previewHtml = previewHtml;
    }

    public String getPreviewText() {
        return _previewText;
    }

    public void setPreviewText(String previewText) {
        _previewText = previewText;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_fromEmail);
        dest.writeString(_replyTomail);
        dest.writeString(_subject);
        dest.writeString(_previewHtml);
        dest.writeString(_previewText);
    }

    protected CampaignPreview(Parcel in) {
        _fromEmail = in.readString();
        _replyTomail = in.readString();
        _subject = in.readString();
        _previewHtml = in.readString();
        _previewText = in.readString();
    }

    public static final Parcelable.Creator<CampaignPreview> CREATOR = new Parcelable.Creator<CampaignPreview>() {
        @Override
        public CampaignPreview createFromParcel(Parcel source) {
            return new CampaignPreview(source);
        }

        @Override
        public CampaignPreview[] newArray(int size) {
            return new CampaignPreview[size];
        }
    };
}
