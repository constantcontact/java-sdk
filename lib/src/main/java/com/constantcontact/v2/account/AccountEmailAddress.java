package com.constantcontact.v2.account;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

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
}
