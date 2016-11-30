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
}
