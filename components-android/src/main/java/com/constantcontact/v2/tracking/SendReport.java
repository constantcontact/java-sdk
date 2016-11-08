package com.constantcontact.v2.tracking;

import android.os.Parcel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Date;

/**
 * @author woogienoogie
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "activity_type")
public class SendReport extends BaseTrackingReport {
    @JsonProperty("send_date")
    private Date _sendDate;

    public SendReport() {
    }

    public Date getSendDate() {
        return _sendDate;
    }

    public void setSendDate(Date sendDate) {
        _sendDate = sendDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeLong(_sendDate != null ? _sendDate.getTime() : - 1);
    }

    protected SendReport(Parcel in) {
        super(in);
        long tmp_sendDate = in.readLong();
        _sendDate = tmp_sendDate == - 1 ? null : new Date(tmp_sendDate);
    }

    public static final Creator<SendReport> CREATOR = new Creator<SendReport>() {
        @Override
        public SendReport createFromParcel(Parcel source) {
            return new SendReport(source);
        }

        @Override
        public SendReport[] newArray(int size) {
            return new SendReport[size];
        }
    };
}
