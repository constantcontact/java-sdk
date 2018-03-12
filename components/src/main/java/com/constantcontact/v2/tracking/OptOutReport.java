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
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof OptOutReport)) {
            return false;
        } else {
            OptOutReport rhs = (OptOutReport) obj;
            return new EqualsBuilder()
                    .append(getCampaignId(), rhs.getCampaignId())
                    .append(getContactId(), rhs.getContactId())
                    .append(getActivityType(), rhs.getActivityType())
                    .append(getEmailAddress(), rhs.getEmailAddress())
                    .append(_unsubscribeDate, rhs.getUnsubscribeDate())
                    .append(_unsubscribeReason, rhs.getUnsubscribeReason())
                    .append(_unsubscribeSource, rhs.getUnsubscribeSource())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getCampaignId())
                .append(getContactId())
                .append(getActivityType())
                .append(getEmailAddress())
                .append(_unsubscribeDate)
                .append(_unsubscribeReason)
                .append(_unsubscribeSource)
                .hashCode();
    }
}
