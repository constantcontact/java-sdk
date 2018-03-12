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

package com.constantcontact.v2.contacts;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class EmailAddress implements Serializable {
    @JsonProperty("confirm_status")
    protected ConfirmStatus _confirmStatus;

    @JsonProperty("email_address")
    protected String _emailAddress;

    @JsonProperty("id")
    protected String _id;

    @JsonProperty("opt_in_date")
    protected Date _optInDate;

    @JsonProperty("opt_in_source")
    protected OptInSource _optInSource;

    @JsonProperty("opt_out_date")
    protected Date _optOutDate;

    @JsonProperty("status")
    protected ContactStatus _status;

    public EmailAddress() {
    }

    public ConfirmStatus getConfirmStatus() {
        return _confirmStatus;
    }

    public void setConfirmStatus(ConfirmStatus confirmStatus) {
        _confirmStatus = confirmStatus;
    }

    public String getEmailAddress() {
        return _emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        _emailAddress = emailAddress;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }

    public Date getOptInDate() {
        return _optInDate;
    }

    public void setOptInDate(Date optInDate) {
        _optInDate = optInDate;
    }

    public OptInSource getOptInSource() {
        return _optInSource;
    }

    public void setOptInSource(OptInSource optInSource) {
        _optInSource = optInSource;
    }

    public Date getOptOutDate() {
        return _optOutDate;
    }

    public void setOptOutDate(Date optOutDate) {
        _optOutDate = optOutDate;
    }

    public ContactStatus getStatus() {
        return _status;
    }

    public void setStatus(ContactStatus status) {
        _status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EmailAddress)) {
            return false;
        } else {
            EmailAddress rhs = (EmailAddress) obj;
            return new EqualsBuilder()
                    .append(_confirmStatus, rhs.getConfirmStatus())
                    .append(_emailAddress, rhs.getEmailAddress())
                    .append(_id, rhs.getId())
                    .append(_optInDate, rhs.getOptInDate())
                    .append(_optInSource, rhs.getOptInSource())
                    .append(_optOutDate, rhs.getOptOutDate())
                    .append(_status, rhs.getStatus())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_confirmStatus)
                .append(_emailAddress)
                .append(_id)
                .append(_optInDate)
                .append(_optInSource)
                .append(_optOutDate)
                .append(_status)
                .hashCode();
    }
}
