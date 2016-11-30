package com.constantcontact.v2.contacts;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author woogienoogie
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
}
