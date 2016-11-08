package com.constantcontact.v2.tracking;

import android.os.Parcel;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Date;

/**
 * @author ngalbrai
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "activity_type")
public class BounceReport extends BaseTrackingReport {
    @JsonProperty("bounce_code")
    private BounceCode _bounceCode;

    @JsonProperty("bounce_date")
    private Date _bounceDate;

    @JsonProperty("bounce_description")
    private String _bounceDescription;

    @JsonProperty("bounce_message")
    private String _bounceMessage;

    public BounceReport() {
    }

    public BounceCode getBounceCode() {
        return _bounceCode;
    }

    public void setBounceCode(BounceCode bounceCode) {
        _bounceCode = bounceCode;
    }

    public Date getBounceDate() {
        return _bounceDate;
    }

    public void setBounceDate(Date bounceDate) {
        _bounceDate = bounceDate;
    }

    public String getBounceDescription() {
        return _bounceDescription;
    }

    public void setBounceDescription(String bounceDescription) {
        _bounceDescription = bounceDescription;
    }

    public String getBounceMessage() {
        return _bounceMessage;
    }

    public void setBounceMessage(String bounceMessage) {
        _bounceMessage = bounceMessage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(_bounceCode == null ? - 1 : _bounceCode.ordinal());
        dest.writeLong(_bounceDate != null ? _bounceDate.getTime() : - 1);
        dest.writeString(_bounceDescription);
        dest.writeString(_bounceMessage);
    }

    protected BounceReport(Parcel in) {
        super(in);
        int tmp_bounceCode = in.readInt();
        _bounceCode = tmp_bounceCode == - 1 ? null : BounceCode.values()[tmp_bounceCode];
        long tmp_bounceDate = in.readLong();
        _bounceDate = tmp_bounceDate == - 1 ? null : new Date(tmp_bounceDate);
        _bounceDescription = in.readString();
        _bounceMessage = in.readString();
    }

    public static final Creator<BounceReport> CREATOR = new Creator<BounceReport>() {
        @Override
        public BounceReport createFromParcel(Parcel source) {
            return new BounceReport(source);
        }

        @Override
        public BounceReport[] newArray(int size) {
            return new BounceReport[size];
        }
    };
}
