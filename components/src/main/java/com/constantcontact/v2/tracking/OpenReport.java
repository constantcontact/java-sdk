package com.constantcontact.v2.tracking;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "activity_type")
public class OpenReport extends BaseTrackingReport {
    @JsonProperty("open_date")
    private Date _openDate;

    public OpenReport() {
    }

    public Date getOpenDate() {
        return _openDate;
    }

    public void setOpenDate(Date openDate) {
        _openDate = openDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof OpenReport)) {
            return false;
        } else {
            OpenReport rhs = (OpenReport) obj;
            return new EqualsBuilder()
                    .append(getCampaignId(), rhs.getCampaignId())
                    .append(getContactId(), rhs.getContactId())
                    .append(getActivityType(), rhs.getActivityType())
                    .append(getEmailAddress(), rhs.getEmailAddress())
                    .append(_openDate, rhs.getOpenDate())
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
                .append(_openDate)
                .hashCode();
    }
}
