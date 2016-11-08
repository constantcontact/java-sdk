package com.constantcontact.v2.library;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author woogienoogie
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Folder implements Parcelable {
    @JsonProperty("id")
    protected String _id;

    @JsonProperty("name")
    protected String _name;

    @JsonProperty("level")
    protected int _level;

    @JsonProperty("children")
    protected Folder[] _children;

    @JsonProperty("item_count")
    protected int _itemCount;

    @JsonProperty("parent_id")
    protected String _parentId;

    @JsonProperty("modified_date")
    protected Date _modifiedDate;

    @JsonProperty("created_date")
    protected Date _createdDate;

    public Folder() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public int getLevel() {
        return _level;
    }

    public void setLevel(int level) {
        _level = level;
    }

    public Folder[] getChildren() {
        return _children;
    }

    public void setChildren(Folder[] children) {
        _children = children;
    }

    public int getItemCount() {
        return _itemCount;
    }

    public void setItemCount(int itemCount) {
        _itemCount = itemCount;
    }

    public String getParentId() {
        return _parentId;
    }

    public void setParentId(String parentId) {
        _parentId = parentId;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public Date getCreatedDate() {
        return _createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        _createdDate = createdDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_id);
        dest.writeString(_name);
        dest.writeInt(_level);
        dest.writeTypedArray(_children, flags);
        dest.writeInt(_itemCount);
        dest.writeString(_parentId);
        dest.writeLong(_modifiedDate != null ? _modifiedDate.getTime() : - 1);
        dest.writeLong(_createdDate != null ? _createdDate.getTime() : - 1);
    }

    protected Folder(Parcel in) {
        _id = in.readString();
        _name = in.readString();
        _level = in.readInt();
        _children = in.createTypedArray(Folder.CREATOR);
        _itemCount = in.readInt();
        _parentId = in.readString();
        long tmp_modifiedDate = in.readLong();
        _modifiedDate = tmp_modifiedDate == - 1 ? null : new Date(tmp_modifiedDate);
        long tmp_createdDate = in.readLong();
        _createdDate = tmp_createdDate == - 1 ? null : new Date(tmp_createdDate);
    }

    public static final Creator<Folder> CREATOR = new Creator<Folder>() {
        @Override
        public Folder createFromParcel(Parcel source) {
            return new Folder(source);
        }

        @Override
        public Folder[] newArray(int size) {
            return new Folder[size];
        }
    };
}
