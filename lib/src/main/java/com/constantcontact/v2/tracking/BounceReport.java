package com.constantcontact.v2.tracking;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

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
}
