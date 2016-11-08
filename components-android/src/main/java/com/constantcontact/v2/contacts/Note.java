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
public class Note implements Parcelable {
    @JsonProperty("created_date")
    protected Date _createdDate;

    @JsonProperty("id")
    protected String _id;

    @JsonProperty("modified_date")
    protected Date _modifiedDate;

    @JsonProperty("note")
    protected String _note;

    public Note() {
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

    public String getNote() {
        return _note;
    }

    public void setNote(String note) {
        _note = note;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(_createdDate != null ? _createdDate.getTime() : - 1);
        dest.writeString(_id);
        dest.writeLong(_modifiedDate != null ? _modifiedDate.getTime() : - 1);
        dest.writeString(_note);
    }

    protected Note(Parcel in) {
        long tmp_createdDate = in.readLong();
        _createdDate = tmp_createdDate == - 1 ? null : new Date(tmp_createdDate);
        _id = in.readString();
        long tmp_modifiedDate = in.readLong();
        _modifiedDate = tmp_modifiedDate == - 1 ? null : new Date(tmp_modifiedDate);
        _note = in.readString();
    }

    public static final Parcelable.Creator<Note> CREATOR = new Parcelable.Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel source) {
            return new Note(source);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };
}
