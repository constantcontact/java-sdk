/*
 * Copyright (c) 2016 Constant Contact, Inc. All Rights Reserved.
 * Boston, MA 02451, USA
 * Phone: (781) 472-8100
 * Fax: (781) 472-8101
 * This software is the confidential and proprietary information
 * of Constant Contact, Inc. created for Constant Contact, Inc.
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Constant Contact, Inc.
 */

package com.constantcontact.v2.campaigns;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CampaignPreview)) {
            return false;
        } else {
            CampaignPreview rhs = (CampaignPreview) obj;
            return new EqualsBuilder()
                    .append(_fromEmail, rhs.getFromEmail())
                    .append(_replyTomail, rhs.getReplyTomail())
                    .append(_subject, rhs.getSubject())
                    .append(_previewHtml, rhs.getPreviewHtml())
                    .append(_previewText, rhs.getPreviewText())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_fromEmail)
                .append(_replyTomail)
                .append(_subject)
                .append(_previewHtml)
                .append(_previewText)
                .hashCode();
    }
}
