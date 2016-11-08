package com.constantcontact.v2.account;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class AccountEmailAddress implements Parcelable {
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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_emailAddress);
        dest.writeInt(_status == null ? - 1 : _status.ordinal());
    }

    protected AccountEmailAddress(Parcel in) {
        _emailAddress = in.readString();
        int tmp_status = in.readInt();
        _status = tmp_status == - 1 ? null : AccountEmailAddressStatus.values()[tmp_status];
    }

    public static final Creator<AccountEmailAddress> CREATOR = new Creator<AccountEmailAddress>() {
        @Override
        public AccountEmailAddress createFromParcel(Parcel source) {
            return new AccountEmailAddress(source);
        }

        @Override
        public AccountEmailAddress[] newArray(int size) {
            return new AccountEmailAddress[size];
        }
    };
}
