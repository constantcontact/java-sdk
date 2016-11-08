package com.constantcontact.v2.contacts;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Comparator;
import java.util.Date;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class ContactList implements Parcelable {
    public static Comparator<ContactList> ListSizeComparator = new Comparator<ContactList>() {
        @Override
        public int compare(ContactList lhs, ContactList rhs) {
            if (lhs.getContactCount() > rhs.getContactCount()) return 1;
            if (lhs.getContactCount() < rhs.getContactCount()) return -1;
            return 0;
        }
    };

   @JsonProperty("contact_count")
    protected int _contactCount;

   @JsonProperty("created_date")
    protected Date _createdDate;

   @JsonProperty("id")
    protected String _id;

   @JsonProperty("modified_date")
    protected Date _modifiedDate;

   @JsonProperty("name")
    protected String _name;

   @JsonProperty("status")
    protected ContactListStatus _status;

    public ContactList() {
    }

    public int getContactCount() {
        return _contactCount;
    }

    public void setContactCount(int contactCount) {
        _contactCount = contactCount;
    }

    public Date getCreatedDate() {
        return _createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        _createdDate = createdDate;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public ContactListStatus getStatus() {
        return _status;
    }

    public void setStatus(ContactListStatus status) {
        _status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_contactCount);
        dest.writeLong(_createdDate != null ? _createdDate.getTime() : - 1);
        dest.writeString(_id);
        dest.writeLong(_modifiedDate != null ? _modifiedDate.getTime() : - 1);
        dest.writeString(_name);
        dest.writeInt(_status == null ? - 1 : _status.ordinal());
    }

    protected ContactList(Parcel in) {
        _contactCount = in.readInt();
        long tmp_createdDate = in.readLong();
        _createdDate = tmp_createdDate == - 1 ? null : new Date(tmp_createdDate);
        _id = in.readString();
        long tmp_modifiedDate = in.readLong();
        _modifiedDate = tmp_modifiedDate == - 1 ? null : new Date(tmp_modifiedDate);
        _name = in.readString();
        int tmp_status = in.readInt();
        _status = tmp_status == - 1 ? null : ContactListStatus.values()[tmp_status];
    }

    public static final Parcelable.Creator<ContactList> CREATOR = new Parcelable.Creator<ContactList>() {
        @Override
        public ContactList createFromParcel(Parcel source) {
            return new ContactList(source);
        }

        @Override
        public ContactList[] newArray(int size) {
            return new ContactList[size];
        }
    };
}
