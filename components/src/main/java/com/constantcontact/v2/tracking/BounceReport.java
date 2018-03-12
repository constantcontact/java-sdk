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
 * Do not let me check this in without adding a comment about the class.
 *
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BounceReport)) {
            return false;
        } else {
            BounceReport rhs = (BounceReport) obj;
            return new EqualsBuilder()
                    .append(getCampaignId(), rhs.getCampaignId())
                    .append(getContactId(), rhs.getContactId())
                    .append(getActivityType(), rhs.getActivityType())
                    .append(getEmailAddress(), rhs.getEmailAddress())
                    .append(_bounceCode, rhs.getBounceCode())
                    .append(_bounceDate, rhs.getBounceDate())
                    .append(_bounceDescription, rhs.getBounceDescription())
                    .append(_bounceMessage, rhs.getBounceMessage())
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
                .append(_bounceCode)
                .append(_bounceDate)
                .append(_bounceDescription)
                .append(_bounceMessage)
                .hashCode();
    }
}
