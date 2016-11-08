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
public class ForwardReport extends BaseTrackingReport {
    @JsonProperty("forward_date")
    private Date _forwardDate;

    public ForwardReport() {
    }

    public Date getForwardDate() {
        return _forwardDate;
    }

    public void setForwardDate(Date forwardDate) {
        _forwardDate = forwardDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeLong(_forwardDate != null ? _forwardDate.getTime() : - 1);
    }

    protected ForwardReport(Parcel in) {
        super(in);
        long tmp_forwardDate = in.readLong();
        _forwardDate = tmp_forwardDate == - 1 ? null : new Date(tmp_forwardDate);
    }

    public static final Creator<ForwardReport> CREATOR = new Creator<ForwardReport>() {
        @Override
        public ForwardReport createFromParcel(Parcel source) {
            return new ForwardReport(source);
        }

        @Override
        public ForwardReport[] newArray(int size) {
            return new ForwardReport[size];
        }
    };
}
