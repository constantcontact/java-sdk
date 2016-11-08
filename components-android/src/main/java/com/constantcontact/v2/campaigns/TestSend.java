package com.constantcontact.v2.campaigns;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class TestSend implements Parcelable {
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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(_emailAddresses);
        dest.writeInt(_format == null ? - 1 : _format.ordinal());
        dest.writeString(_personalMessage);
    }

    protected TestSend(Parcel in) {
        _emailAddresses = in.createStringArray();
        int tmp_format = in.readInt();
        _format = tmp_format == - 1 ? null : EmailFormat.values()[tmp_format];
        _personalMessage = in.readString();
    }

    public static final Parcelable.Creator<TestSend> CREATOR = new Parcelable.Creator<TestSend>() {
        @Override
        public TestSend createFromParcel(Parcel source) {
            return new TestSend(source);
        }

        @Override
        public TestSend[] newArray(int size) {
            return new TestSend[size];
        }
    };
}
