package com.constantcontact.v2.tracking;

import android.os.Parcel;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Date;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "activity_type")
public class OpenReport extends BaseTrackingReport {
    @JsonProperty("open_date")
    private Date _openDate;

    public OpenReport() {
    }

    public Date getOpenDate() {
        return _openDate;
    }

    public void setOpenDate(Date openDate) {
        _openDate = openDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeLong(_openDate != null ? _openDate.getTime() : - 1);
    }

    protected OpenReport(Parcel in) {
        super(in);
        long tmp_openDate = in.readLong();
        _openDate = tmp_openDate == - 1 ? null : new Date(tmp_openDate);
    }

    public static final Creator<OpenReport> CREATOR = new Creator<OpenReport>() {
        @Override
        public OpenReport createFromParcel(Parcel source) {
            return new OpenReport(source);
        }

        @Override
        public OpenReport[] newArray(int size) {
            return new OpenReport[size];
        }
    };
}
