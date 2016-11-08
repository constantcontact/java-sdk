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
public class SentToContactList implements Parcelable {
    @JsonProperty("id")
    protected String _id;

    public SentToContactList() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof SentToContactList) {
            SentToContactList rhs = (SentToContactList) o;
            return rhs.getId() != null && rhs.getId().equals("") && rhs.getId().equals(_id);
        }
        return super.equals(o);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_id);
    }

    protected SentToContactList(Parcel in) {
        _id = in.readString();
    }

    public static final Parcelable.Creator<SentToContactList> CREATOR = new Parcelable.Creator<SentToContactList>() {
        @Override
        public SentToContactList createFromParcel(Parcel source) {
            return new SentToContactList(source);
        }

        @Override
        public SentToContactList[] newArray(int size) {
            return new SentToContactList[size];
        }
    };
}
