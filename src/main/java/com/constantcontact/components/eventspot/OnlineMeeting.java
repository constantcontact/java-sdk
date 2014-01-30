package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class OnlineMeeting extends Component implements Serializable {

    private static final long serialVersionUID = -8612322500899374587L;

    @JsonIgnore
    private String instructions;
    @JsonIgnore
    private String providerMeetingId;
    @JsonIgnore
    private String providerType;
    @JsonIgnore
    private String url;

    @JsonProperty("instructions")
    public String getInstructions() {
        return instructions;
    }

    @JsonProperty("provider_meeting_id")
    public String getProviderMeetingId() {
        return providerMeetingId;
    }

   // @JsonProperty("provider_type")
    public String getProviderType() {
        return providerType;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setProviderMeetingId(String providerMeetingId) {
        this.providerMeetingId = providerMeetingId;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Default constructor.
     */
    public OnlineMeeting() {
        super();
    }

}
