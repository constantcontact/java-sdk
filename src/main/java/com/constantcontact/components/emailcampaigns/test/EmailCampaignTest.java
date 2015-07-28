package com.constantcontact.components.emailcampaigns.test;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Represents a single Email Campaign Test for the Email Campaign Test Service in Constant Contact.<br/>
 *
 * @author ConstantContact
 */
public class EmailCampaignTest extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = -6034275530457953351L;

    @JsonIgnore
    private List<String> emailAddresses;
    @JsonIgnore
    private String format;
    @JsonIgnore
    private String personalMessage;


    /**
     * Gets the email addresses to send the preview message to
     *
     * @return The fromEmail field
     */
    @JsonProperty("email_addresses")
    public List<String> getEmailAddresses() {
        return emailAddresses;
    }

    /**
     * Gets the format of the content that will be sent in the preview
     *
     * @return The format.
     */
    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    /**
     * Gets the message to include with the preview of the email campaign.
     * Could be similar to: I am testing out my next email marketing message.
     *
     * @return The personalMessage.
     */
    @JsonProperty("personal_message")
    public String getPersonalMessage() {
        return personalMessage;
    }

    /**
     * Sets the emailAddresses.
     *
     * @param emailAddresses The  email addresses to send the preview message to.
     */
    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    /**
     * Sets the format.
     *
     * @param format The format of the content that will be sent in the preview.
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Sets the personalMessage.
     *
     * @param personalMessage The message to include with the preview of the email campaign.
     */
    public void setPersonalMessage(String personalMessage) {
        this.personalMessage = personalMessage;
    }

    /**
     * Default constructor.
     */
    public EmailCampaignTest() {
        super();
    }

    /**
     * Custom implementation for {@link Object#toString()}.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EmailCampaignPreview [emailAddresses=");
        builder.append(emailAddresses);
        builder.append(", format=");
        builder.append(format);
        builder.append(", personalMessage=");
        builder.append(personalMessage);
        builder.append(" ]\n");
        return builder.toString();
    }

    /**
     * Format constants for the usage of {@link EmailCampaignTest} in Constant Contact.
     *
     * @author ConstantContact
     */
    public static final class Format {

        /**
         * HTML Status
         */
        public static final String HTML = "HTML";
        /**
         * TEXT Status
         */
        public static final String TEXT = "TEXT";
        /**
         * HTML_AND_TEXT Status
         */
        public static final String HTML_AND_TEXT = "HTML_AND_TEXT";

        /**
         * Default constructor.<br/>
         * Made private to prevent instantiation.<br/>
         * This is unreachable from the outside, since current class is used only as a repository for constants.
         */
        private Format() {
        }
    }

}
