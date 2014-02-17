package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.constantcontact.exceptions.component.ConstantContactComponentException;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

/**
 * EventUpdateStatusRequest for the Events in Constant Contact.
 *
 * @author ConstantContact
 * @see EventSpotService
 */
public class EventUpdateStatusRequest extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = -562327662253077313L;

    /**
     * Wrapper for Event Status Request
     */
    @JsonIgnore
    private List<EventUpdateStatus> eventUpdateStatusList;

    /**
     * Get the eventUpdateStatusList.
     *
     * @return The {@link #eventUpdateStatusList}
     */
    public List<EventUpdateStatus> getEventUpdateStatusList() {
        return eventUpdateStatusList;
    }

    /**
     * Constructor
     *
     * @param eventUpdateStatusList The event status list
     */
    public EventUpdateStatusRequest(List<EventUpdateStatus> eventUpdateStatusList) {
        this.eventUpdateStatusList = eventUpdateStatusList;
    }

    /**
     * Override toJSON for obtaining the desired JSON format.
     * @return JSON string
     * @throws ConstantContactComponentException
     */
    @Override
    public String toJSON() throws ConstantContactComponentException {
        StringBuilder builder = new StringBuilder();

        builder.append("[");
        for (EventUpdateStatus eventUpdateStatus : eventUpdateStatusList) {
            builder.append(eventUpdateStatus.toJSON());
        }
        builder.append("]");

        return builder.toString();
    }
}
