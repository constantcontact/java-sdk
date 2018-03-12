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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TestSend)) {
            return false;
        } else {
            TestSend rhs = (TestSend) obj;
            return new EqualsBuilder()
                    .append(_emailAddresses, rhs.getEmailAddresses())
                    .append(_format, rhs.getFormat())
                    .append(_personalMessage, rhs.getPersonalMessage())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_emailAddresses)
                .append(_format)
                .append(_personalMessage)
                .hashCode();
    }
}
