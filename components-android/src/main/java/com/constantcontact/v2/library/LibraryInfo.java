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
public class LibraryInfo implements Parcelable {
    @JsonProperty("max_free_file_num")
    protected int _maxFreeFileNum;

    @JsonProperty("max_premium_space_limit")
    protected int _maxPremiumSpaceLimit;

    @JsonProperty("image_root")
    protected String _imageRoot;

    @JsonProperty("usage_summary")
    protected UsageSummary _usageSummary;

    @JsonProperty("max_upload_size_limit")
    protected int _maxUploadSizeLimit;

    public LibraryInfo() {
    }

    public int getMaxFreeFileNum() {
        return _maxFreeFileNum;
    }

    public void setMaxFreeFileNum(int maxFreeFileNum) {
        _maxFreeFileNum = maxFreeFileNum;
    }

    public int getMaxPremiumSpaceLimit() {
        return _maxPremiumSpaceLimit;
    }

    public void setMaxPremiumSpaceLimit(int maxPremiumSpaceLimit) {
        _maxPremiumSpaceLimit = maxPremiumSpaceLimit;
    }

    public String getImageRoot() {
        return _imageRoot;
    }

    public void setImageRoot(String imageRoot) {
        _imageRoot = imageRoot;
    }

    public UsageSummary getUsageSummary() {
        return _usageSummary;
    }

    public void setUsageSummary(UsageSummary usageSummary) {
        _usageSummary = usageSummary;
    }

    public int getMaxUploadSizeLimit() {
        return _maxUploadSizeLimit;
    }

    public void setMaxUploadSizeLimit(int maxUploadSizeLimit) {
        _maxUploadSizeLimit = maxUploadSizeLimit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_maxFreeFileNum);
        dest.writeInt(_maxPremiumSpaceLimit);
        dest.writeString(_imageRoot);
        dest.writeParcelable(_usageSummary, flags);
        dest.writeInt(_maxUploadSizeLimit);
    }

    protected LibraryInfo(Parcel in) {
        _maxFreeFileNum = in.readInt();
        _maxPremiumSpaceLimit = in.readInt();
        _imageRoot = in.readString();
        _usageSummary = in.readParcelable(UsageSummary.class.getClassLoader());
        _maxUploadSizeLimit = in.readInt();
    }

    public static final Parcelable.Creator<LibraryInfo> CREATOR = new Parcelable.Creator<LibraryInfo>() {
        @Override
        public LibraryInfo createFromParcel(Parcel source) {
            return new LibraryInfo(source);
        }

        @Override
        public LibraryInfo[] newArray(int size) {
            return new LibraryInfo[size];
        }
    };
}
