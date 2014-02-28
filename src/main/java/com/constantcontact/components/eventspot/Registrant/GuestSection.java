package com.constantcontact.components.eventspot.Registrant;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * GuestSection for the Events in Constant Contact.
 * 
 * @see EventSpotService
 * 
 * @author ConstantContact
 * 
 */
public class GuestSection extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
    private static final long serialVersionUID = -1307397204527317440L;

	/**
	 * Total number of guests.
	 */
    @JsonIgnore
    private Integer guestCount;

	/**
	 * Unique ID assigned to a guest.
	 */
    @JsonIgnore
    private String guestId;
		
	/**
	 * Field sections displayed.
	 */
    @JsonIgnore
    private String guestsInfo;
		
	/**
	 * Get the guest count.
	 *
	 * @return The {@link #guestCount}
	 */
    @JsonProperty("guest_count")
    public Integer getGuestCount() {
        return guestCount;
    }

    /**
     * Get the ID assigned to a guest.
     *
     * @return The {@link #guestId}
     */
    @JsonProperty("guest_id")
    public String getGuestId() {
        return guestId;
    }

    /**
     * Get the Field sections displayed.
     *
     * @return The {@link #guestsInfo}
     */
    @JsonProperty("guests_info")
    public String getGuestsInfo() {
        return guestsInfo;
    }


    /**
     * Get the guest count.
     *
     * @param guestCount  The guest count.
     */
    public void setGuestCount(Integer guestCount) {
        this.guestCount = guestCount;
    }

    /**
     * Set the ID assigned to a guest.
     *
     * @param guestId The guest count.
     */
    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    /**
     * Set the Field sections displayed.
     *
     * @param guestsInfo The Field sections.
     */
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
