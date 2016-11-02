package com.constantcontact.v2.campaigns;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class CampaignSchedule implements Serializable {
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
}
