package com.constantcontact.v2.tracking;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "activity_type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ClickReport.class, name = "EMAIL_CLICK"),
        @JsonSubTypes.Type(value = OpenReport.class, name = "EMAIL_OPEN"),
        @JsonSubTypes.Type(value = BounceReport.class, name = "EMAIL_BOUNCE"),
        @JsonSubTypes.Type(value = OptOutReport.class, name = "EMAIL_UNSUBSCRIBE"),
        @JsonSubTypes.Type(value = SendReport.class, name = "EMAIL_SEND"),
        @JsonSubTypes.Type(value = ForwardReport.class, name = "EMAIL_FORWARD")
})
public class BaseTrackingReport implements Parcelable {
    @JsonProperty("activity_type")
    private TrackingReportType _activityType;

    @JsonProperty("campaign_id")
    private String _campaignId;

    @JsonProperty("contact_id")
    private String _contactId;

    @JsonProperty("email_address")
    private String _emailAddress;

    public BaseTrackingReport() {
    }

    public TrackingReportType getActivityType() {
        return _activityType;
    }

    public void setActivityType(TrackingReportType activityType) {
        _activityType = activityType;
    }

    public String getCampaignId() {
        return _campaignId;
    }

    public void setCampaignId(String campaignId) {
        _campaignId = campaignId;
    }

    public String getContactId() {
        return _contactId;
    }

    public void setContactId(String contactId) {
        _contactId = contactId;
    }

    public String getEmailAddress() {
        return _emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        _emailAddress = emailAddress;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_activityType == null ? - 1 : _activityType.ordinal());
        dest.writeString(_campaignId);
        dest.writeString(_contactId);
        dest.writeString(_emailAddress);
    }

    protected BaseTrackingReport(Parcel in) {
        int tmp_activityType = in.readInt();
        _activityType = tmp_activityType == - 1 ? null : TrackingReportType.values()[tmp_activityType];
        _campaignId = in.readString();
        _contactId = in.readString();
        _emailAddress = in.readString();
    }

}
