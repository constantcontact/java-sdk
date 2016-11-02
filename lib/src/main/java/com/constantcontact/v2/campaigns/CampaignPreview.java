package com.constantcontact.v2.campaigns;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class CampaignPreview implements Serializable {
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
}
