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
}
