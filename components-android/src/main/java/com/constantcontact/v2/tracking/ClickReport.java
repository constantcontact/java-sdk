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
public class ClickReport extends BaseTrackingReport {
    @JsonProperty("click_date")
    private Date _clickDate;

    @JsonProperty("link_id")
    private String _linkId;

    @JsonProperty("link_uri")
    private String _linkUri;

    public ClickReport() {
    }

    public Date getClickDate() {
        return _clickDate;
    }

    public void setClickDate(Date clickDate) {
        _clickDate = clickDate;
    }

    public String getLinkId() {
        return _linkId;
    }

    public void setLinkId(String linkId) {
        _linkId = linkId;
    }

    public String getLinkUri() {
        return _linkUri;
    }

    public void setLinkUri(String linkUri) {
        _linkUri = linkUri;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeLong(_clickDate != null ? _clickDate.getTime() : - 1);
        dest.writeString(_linkId);
        dest.writeString(_linkUri);
    }

    protected ClickReport(Parcel in) {
        super(in);
        long tmp_clickDate = in.readLong();
        _clickDate = tmp_clickDate == - 1 ? null : new Date(tmp_clickDate);
        _linkId = in.readString();
        _linkUri = in.readString();
    }

    public static final Creator<ClickReport> CREATOR = new Creator<ClickReport>() {
        @Override
        public ClickReport createFromParcel(Parcel source) {
            return new ClickReport(source);
        }

        @Override
        public ClickReport[] newArray(int size) {
            return new ClickReport[size];
        }
    };
}
