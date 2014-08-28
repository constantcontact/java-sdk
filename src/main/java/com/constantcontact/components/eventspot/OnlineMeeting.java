package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * OnlineMeeting for the Events in Constant Contact.
 *
 * @author ConstantContact
 * @see EventSpotService
 */
public class OnlineMeeting extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = -8612322500899374587L;

    /**
     * Online meeting instructions, such as dial in number, password, etc
     */
    @JsonIgnore
    private String instructions;

    /**
     * Meeting ID, if any, for the meeting
     */
    @JsonIgnore
    private String providerMeetingId;

    /**
     * Specify the online meeting provider, such as WebEx
     */
    @JsonIgnore
    private String providerType;

    /**
     * URL for online meeting. REQUIRED if is_virtual_event is set to true.
     */
    @JsonIgnore
    private String url;

    /**
     * Get the name.
     *
     * @return The {@link #instructions}
     */
    @JsonProperty("instructions")
    public String getInstructions() {
        return instructions;
    }

    /**
     * Get the providerMeetingId.
     *
     * @return The {@link #providerMeetingId}
     */
    @JsonProperty("provider_meeting_id")
    public String getProviderMeetingId() {
        return providerMeetingId;
    }

    /**
     * Get the providerType.
     *
     * @return The {@link #providerType}
     */
    @JsonProperty("provider_type")
    public String getProviderType() {
        return providerType;
    }

    /**
     * Get the url.
     *
     * @return The {@link #url}
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * Set the instructions.
     *
     * @param instructions The instructions.
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    /**
     * Set the providerMeetingId.
     *
     * @param providerMeetingId The providerMeetingId.
     */
    public void setProviderMeetingId(String providerMeetingId) {
        this.providerMeetingId = providerMeetingId;
    }

    /**
     * Set the providerType.
     *
     * @param providerType The providerType.
     */
    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    /**
     * Set the url.
     *
     * @param url The url.
     */
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
