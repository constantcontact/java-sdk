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
public class ForwardReport extends BaseTrackingReport {
    @JsonProperty("forward_date")
    private Date _forwardDate;

    public ForwardReport() {
    }

    public Date getForwardDate() {
        return _forwardDate;
    }

    public void setForwardDate(Date forwardDate) {
        _forwardDate = forwardDate;
    }
}
