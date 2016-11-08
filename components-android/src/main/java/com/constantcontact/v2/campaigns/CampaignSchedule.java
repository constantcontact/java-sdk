package com.constantcontact.v2.campaigns;

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
public class CampaignSchedule implements Parcelable {
    @JsonProperty("id")
    protected String _id;

    @JsonProperty("scheduled_date")
    protected Date _scheduledDate;

    public CampaignSchedule() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }

    public Date getScheduledDate() {
        return _scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        _scheduledDate = scheduledDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_id);
        dest.writeLong(_scheduledDate != null ? _scheduledDate.getTime() : - 1);
    }

    protected CampaignSchedule(Parcel in) {
        _id = in.readString();
        long tmp_scheduledDate = in.readLong();
        _scheduledDate = tmp_scheduledDate == - 1 ? null : new Date(tmp_scheduledDate);
    }

    public static final Parcelable.Creator<CampaignSchedule> CREATOR = new Parcelable.Creator<CampaignSchedule>() {
        @Override
        public CampaignSchedule createFromParcel(Parcel source) {
            return new CampaignSchedule(source);
        }

        @Override
        public CampaignSchedule[] newArray(int size) {
            return new CampaignSchedule[size];
        }
    };
}
