package com.constantcontact.v2.library;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ngalbrai
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class FileUploadStatus implements Parcelable {
    @JsonProperty("status")
    protected FileStatus _status;

    @JsonProperty("description")
    protected String _description;

    @JsonProperty("file_id")
    protected long _id;

    public FileUploadStatus() {
    }

    public FileStatus getStatus() {
        return _status;
    }

    public void setStatus(FileStatus status) {
        _status = status;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_status == null ? - 1 : _status.ordinal());
        dest.writeString(_description);
        dest.writeLong(_id);
    }

    protected FileUploadStatus(Parcel in) {
        int tmp_status = in.readInt();
        _status = tmp_status == - 1 ? null : FileStatus.values()[tmp_status];
        _description = in.readString();
        _id = in.readLong();
    }

    public static final Parcelable.Creator<FileUploadStatus> CREATOR = new Parcelable.Creator<FileUploadStatus>() {
        @Override
        public FileUploadStatus createFromParcel(Parcel source) {
            return new FileUploadStatus(source);
        }

        @Override
        public FileUploadStatus[] newArray(int size) {
            return new FileUploadStatus[size];
        }
    };
}
