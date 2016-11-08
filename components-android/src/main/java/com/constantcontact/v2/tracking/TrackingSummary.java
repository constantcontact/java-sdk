package com.constantcontact.v2.tracking;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class TrackingSummary implements Parcelable {
    @JsonProperty("unsubscribes")
    private int _unsubscribes;

    @JsonProperty("clicks")
    private int _clicks;

    @JsonProperty("opens")
    private int _opens;

    @JsonProperty("bounces")
    private int _bounces;

    @JsonProperty("sends")
    private int _sends;

    @JsonProperty("forwards")
    private int _forwards;

    @JsonProperty("spam_count")
    private int _spamCount;

    public TrackingSummary() {
    }

    public int getUnsubscribes() {
        return _unsubscribes;
    }

    public void setUnsubscribes(int unsubscribes) {
        _unsubscribes = unsubscribes;
    }

    public int getClicks() {
        return _clicks;
    }

    public void setClicks(int clicks) {
        _clicks = clicks;
    }

    public int getOpens() {
        return _opens;
    }

    public void setOpens(int opens) {
        _opens = opens;
    }

    public int getBounces() {
        return _bounces;
    }

    public void setBounces(int bounces) {
        _bounces = bounces;
    }

    public int getSends() {
        return _sends;
    }

    public void setSends(int sends) {
        _sends = sends;
    }

    public int getForwards() {
        return _forwards;
    }

    public void setForwards(int forwards) {
        _forwards = forwards;
    }

    public int getSpamCount() {
        return _spamCount;
    }

    public void setSpamCount(int spamCount) {
        _spamCount = spamCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_unsubscribes);
        dest.writeInt(_clicks);
        dest.writeInt(_opens);
        dest.writeInt(_bounces);
        dest.writeInt(_sends);
        dest.writeInt(_forwards);
        dest.writeInt(_spamCount);
    }

    protected TrackingSummary(Parcel in) {
        _unsubscribes = in.readInt();
        _clicks = in.readInt();
        _opens = in.readInt();
        _bounces = in.readInt();
        _sends = in.readInt();
        _forwards = in.readInt();
        _spamCount = in.readInt();
    }

    public static final Parcelable.Creator<TrackingSummary> CREATOR = new Parcelable.Creator<TrackingSummary>() {
        @Override
        public TrackingSummary createFromParcel(Parcel source) {
            return new TrackingSummary(source);
        }

        @Override
        public TrackingSummary[] newArray(int size) {
            return new TrackingSummary[size];
        }
    };
}
