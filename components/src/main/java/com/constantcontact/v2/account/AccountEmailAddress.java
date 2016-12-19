package com.constantcontact.v2.account;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * @author woogienoogie
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
