package com.constantcontact.v2.tracking;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

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
}
