package com.constantcontact.v2.campaigns;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class TestSend implements Serializable {
    @JsonProperty("email_addresses")
    protected String[] _emailAddresses;

    @JsonProperty("format")
    protected EmailFormat _format;

    @JsonProperty("personal_message")
    protected String _personalMessage;

    public TestSend() {
    }

    public String[] getEmailAddresses() {
        return _emailAddresses;
    }

    public void setEmailAddresses(String[] emailAddresses) {
        _emailAddresses = emailAddresses;
    }

    public EmailFormat getFormat() {
        return _format;
    }

    public void setFormat(EmailFormat format) {
        _format = format;
    }

    public String getPersonalMessage() {
        return _personalMessage;
    }

    public void setPersonalMessage(String personalMessage) {
        _personalMessage = personalMessage;
    }
}
