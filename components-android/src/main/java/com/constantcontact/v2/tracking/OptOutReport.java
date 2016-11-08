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
public class OptOutReport extends BaseTrackingReport {
    @JsonProperty("unsubscribe_date")
    private Date _unsubscribeDate;

    @JsonProperty("unsubscribe_reason")
    private String _unsubscribeReason;

    @JsonProperty("unsubscribe_source")
    private UnsubscribeSource _unsubscribeSource;

    public OptOutReport() {
    }

    public Date getUnsubscribeDate() {
        return _unsubscribeDate;
    }

    public void setUnsubscribeDate(Date unsubscribeDate) {
        _unsubscribeDate = unsubscribeDate;
    }

    public String getUnsubscribeReason() {
        return _unsubscribeReason;
    }

    public void setUnsubscribeReason(String unsubscribeReason) {
        _unsubscribeReason = unsubscribeReason;
    }

    public UnsubscribeSource getUnsubscribeSource() {
        return _unsubscribeSource;
    }

    public void setUnsubscribeSource(UnsubscribeSource unsubscribeSource) {
        _unsubscribeSource = unsubscribeSource;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeLong(_unsubscribeDate != null ? _unsubscribeDate.getTime() : - 1);
        dest.writeString(_unsubscribeReason);
        dest.writeInt(_unsubscribeSource == null ? - 1 : _unsubscribeSource.ordinal());
    }

    protected OptOutReport(Parcel in) {
        super(in);
        long tmp_unsubscribeDate = in.readLong();
        _unsubscribeDate = tmp_unsubscribeDate == - 1 ? null : new Date(tmp_unsubscribeDate);
        _unsubscribeReason = in.readString();
        int tmp_unsubscribeSource = in.readInt();
        _unsubscribeSource = tmp_unsubscribeSource == - 1 ? null : UnsubscribeSource.values()[tmp_unsubscribeSource];
    }

    public static final Creator<OptOutReport> CREATOR = new Creator<OptOutReport>() {
        @Override
        public OptOutReport createFromParcel(Parcel source) {
            return new OptOutReport(source);
        }

        @Override
        public OptOutReport[] newArray(int size) {
            return new OptOutReport[size];
        }
    };
}
