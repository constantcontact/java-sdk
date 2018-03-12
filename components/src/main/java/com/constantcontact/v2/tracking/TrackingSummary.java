/*
 * Copyright (c) 2016 Constant Contact, Inc. All Rights Reserved.
 * Boston, MA 02451, USA
 * Phone: (781) 472-8100
 * Fax: (781) 472-8101
 * This software is the confidential and proprietary information
 * of Constant Contact, Inc. created for Constant Contact, Inc.
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Constant Contact, Inc.
 */

package com.constantcontact.v2.tracking;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class TrackingSummary implements Serializable {
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TrackingSummary)) {
            return false;
        } else {
            TrackingSummary rhs = (TrackingSummary) obj;
            return new EqualsBuilder()
                    .append(_unsubscribes, rhs.getUnsubscribes())
                    .append(_clicks, rhs.getClicks())
                    .append(_opens, rhs.getOpens())
                    .append(_bounces, rhs.getBounces())
                    .append(_sends, rhs.getSends())
                    .append(_forwards, rhs.getForwards())
                    .append(_spamCount, rhs.getSpamCount())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_unsubscribes)
                .append(_clicks)
                .append(_opens)
                .append(_bounces)
                .append(_sends)
                .append(_forwards)
                .append(_spamCount)
                .hashCode();
    }
}
