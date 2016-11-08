package com.constantcontact.v2.contacts;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class EmailAddress implements Parcelable {
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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_confirmStatus == null ? - 1 : _confirmStatus.ordinal());
        dest.writeString(_emailAddress);
        dest.writeString(_id);
        dest.writeLong(_optInDate != null ? _optInDate.getTime() : - 1);
        dest.writeInt(_optInSource == null ? - 1 : _optInSource.ordinal());
        dest.writeLong(_optOutDate != null ? _optOutDate.getTime() : - 1);
        dest.writeInt(_status == null ? - 1 : _status.ordinal());
    }

    protected EmailAddress(Parcel in) {
        int tmp_confirmStatus = in.readInt();
        _confirmStatus = tmp_confirmStatus == - 1 ? null : ConfirmStatus.values()[tmp_confirmStatus];
        _emailAddress = in.readString();
        _id = in.readString();
        long tmp_optInDate = in.readLong();
        _optInDate = tmp_optInDate == - 1 ? null : new Date(tmp_optInDate);
        int tmp_optInSource = in.readInt();
        _optInSource = tmp_optInSource == - 1 ? null : OptInSource.values()[tmp_optInSource];
        long tmp_optOutDate = in.readLong();
        _optOutDate = tmp_optOutDate == - 1 ? null : new Date(tmp_optOutDate);
        int tmp_status = in.readInt();
        _status = tmp_status == - 1 ? null : ContactStatus.values()[tmp_status];
    }

    public static final Parcelable.Creator<EmailAddress> CREATOR = new Parcelable.Creator<EmailAddress>() {
        @Override
        public EmailAddress createFromParcel(Parcel source) {
            return new EmailAddress(source);
        }

        @Override
        public EmailAddress[] newArray(int size) {
            return new EmailAddress[size];
        }
    };
}
