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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ClickReport)) {
            return false;
        } else {
            ClickReport rhs = (ClickReport) obj;
            return new EqualsBuilder()
                    .append(getCampaignId(), rhs.getCampaignId())
                    .append(getContactId(), rhs.getContactId())
                    .append(getActivityType(), rhs.getActivityType())
                    .append(getEmailAddress(), rhs.getEmailAddress())
                    .append(_clickDate, rhs.getClickDate())
                    .append(_linkId, rhs.getLinkId())
                    .append(_linkUri, rhs.getLinkUri())
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
                .append(_clickDate)
                .append(_linkId)
                .append(_linkUri)
                .hashCode();
    }
}
