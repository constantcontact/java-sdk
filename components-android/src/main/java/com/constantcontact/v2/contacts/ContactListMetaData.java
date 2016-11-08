package com.constantcontact.v2.contacts;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class ContactListMetaData implements Parcelable {
    @JsonProperty("id")
    protected String _id;

    @JsonProperty("status")
    protected ContactListStatus _status;

    public ContactListMetaData() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }

    public ContactListStatus getStatus() {
        return _status;
    }

    public void setStatus(ContactListStatus status) {
        _status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof ContactListMetaData)) {
            return false;
        }

        ContactListMetaData rhs = (ContactListMetaData) o;
        return rhs.getId() != null && !rhs.getId().equals("") && rhs.getId().equals(_id) && rhs.getStatus().equals(_status);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_id);
        dest.writeInt(_status == null ? - 1 : _status.ordinal());
    }

    protected ContactListMetaData(Parcel in) {
        _id = in.readString();
        int tmp_status = in.readInt();
        _status = tmp_status == - 1 ? null : ContactListStatus.values()[tmp_status];
    }

    public static final Parcelable.Creator<ContactListMetaData> CREATOR = new Parcelable.Creator<ContactListMetaData>() {
        @Override
        public ContactListMetaData createFromParcel(Parcel source) {
            return new ContactListMetaData(source);
        }

        @Override
        public ContactListMetaData[] newArray(int size) {
            return new ContactListMetaData[size];
        }
    };
}
