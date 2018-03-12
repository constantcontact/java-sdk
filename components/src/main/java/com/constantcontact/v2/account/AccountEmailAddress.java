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

package com.constantcontact.v2.account;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class AccountEmailAddress implements Serializable {
    @JsonProperty("email_address")
    protected String _emailAddress;

    @JsonProperty("status")
    protected AccountEmailAddressStatus _status = AccountEmailAddressStatus.UNCONFIRMED;

    public AccountEmailAddress() {
    }

    public String getEmailAddress()
    {
        return _emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        _emailAddress = emailAddress;
    }

    public AccountEmailAddressStatus getStatus()
    {
        return _status;
    }

    public void setStatus(AccountEmailAddressStatus status)
    {
        _status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AccountEmailAddress)) {
            return false;
        } else {
            AccountEmailAddress rhs = (AccountEmailAddress) obj;
            return new EqualsBuilder()
                    .append(_emailAddress, rhs.getEmailAddress())
                    .append(_status, rhs.getStatus())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_emailAddress)
                .append(_status)
                .hashCode();
    }
}
