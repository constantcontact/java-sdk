package com.constantcontact.components.emailcampaigns.test;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Represents a single Email Campaign Preview for the Email Campaign Test Service in Constant Contact.<br/>
 *
 * @author ConstantContact
 */
public class EmailCampaignPreview extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = -6034275530457953351L;

    @JsonIgnore
    private String fromEmail;
    @JsonIgnore
    private String previewHtmlContent;
    @JsonIgnore
    private String previewTextContent;
    @JsonIgnore
    private String replyToEmail;
    @JsonIgnore
    private String subject;


    /**
     * Gets the email address the email campaign originated from
     *
     * @return The fromEmail field
     */
    @JsonProperty("from_email")
    public String getFromEmail() {
        return fromEmail;
    }

    /**
     * Gets the preview of the rendered HTML version of the email campaign message
     *
     * @return The previewHtmlContent.
     */
    @JsonProperty("preview_html_content")
    public String getPreviewHtmlContent() {
        return previewHtmlContent;
    }

    /**
     * Gets the preview of the text-only version of the email campaign message
     *
     * @return The previewHtmlConten
     */
    @JsonProperty("preview_text_content")
    public String getPreviewTextContent() {
        return previewTextContent;
    }

    /**
     * Gets the reply-to email address for the email campaign
     *
     * @return The replyToEmail
     */
    @JsonProperty("reply_to_email")
    public String getReplyToEmail() {
        return replyToEmail;
    }

    /**
     * Gets the subject line content for the message
     *
     * @return The subject
     */
    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the email from.
     *
     * @param fromEmail The email address the email campaign originated from.
     */
    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    /**
     * Sets the previewHtmlContent.
     *
     * @param previewHtmlContent The preview of the rendered HTML version of the email campaign message.
     */
    public void setPreviewHtmlContent(String previewHtmlContent) {
        this.previewHtmlContent = previewHtmlContent;
    }

    /**
     * Sets the previewTextContent.
     *
     * @param previewTextContent The preview of the text-only version of the email campaign message.
     */
    public void setPreviewTextContent(String previewTextContent) {
        this.previewTextContent = previewTextContent;
    }

    /**
     * Sets the replyToEmail.
     *
     * @param replyToEmail The reply-to email address for the email campaign.
     */
    public void setReplyToEmail(String replyToEmail) {
        this.replyToEmail = replyToEmail;
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
     * Default constructor.
     */
    public EmailCampaignPreview() {
        super();
    }

    /**
     * Custom implementation for {@link Object#toString()}.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EmailCampaignPreview [fromEmail=");
        builder.append(fromEmail);
        builder.append(", previewHtmlContent=");
        builder.append(previewHtmlContent);
        builder.append(", previewTextContent=");
        builder.append(previewTextContent);
        builder.append(", replyToEmail=");
        builder.append(replyToEmail);
        builder.append(", subject=");
        builder.append(subject);
        builder.append(" ]\n");
        return builder.toString();
    }

}
