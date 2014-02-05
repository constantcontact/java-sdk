package com.constantcontact.components.eventspot.Registrant;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class GuestSection extends Component implements Serializable {


    private static final long serialVersionUID = -1307397204527317440L;

    @JsonIgnore
    private Integer guestCount;
    @JsonIgnore
    private String guestId;
    @JsonIgnore
    private String guestsInfo;

    @JsonProperty("guest_count")
    public Integer getGuestCount() {
        return guestCount;
    }

    @JsonProperty("guest_id")
    public String getGuestId() {
        return guestId;
    }

    @JsonProperty("guests_info")
    public String getGuestsInfo() {
        return guestsInfo;
    }

    public void setGuestCount(Integer guestCount) {
        this.guestCount = guestCount;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public void setGuestsInfo(String guestsInfo) {
        this.guestsInfo = guestsInfo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GuestSection [guest_id=");
        builder.append(guestId);
        builder.append(", guest_count=");
        builder.append(guestCount);
        builder.append(", guests_info=");
        builder.append(guestsInfo);
        builder.append("]");

        return builder.toString();
    }

    /**
     * Default Constructor
     */
    public GuestSection() {
        super();
    }
}
