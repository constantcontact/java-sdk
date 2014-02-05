package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.constantcontact.exceptions.component.ConstantContactComponentException;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class EventUpdateStatusRequest extends Component implements Serializable {

    private static final long serialVersionUID = -562327662253077313L;

    @JsonIgnore
    private List<EventUpdateStatus> eventUpdateStatusList;

    public List<EventUpdateStatus> getEventUpdateStatusList() {
        return eventUpdateStatusList;
    }

    public EventUpdateStatusRequest(List<EventUpdateStatus> eventUpdateStatusList) {
        this.eventUpdateStatusList = eventUpdateStatusList;
    }

    @Override
    public String toJSON() throws ConstantContactComponentException {
        StringBuilder builder = new StringBuilder();

        builder.append("[");
        for (EventUpdateStatus eventUpdateStatus : eventUpdateStatusList) {
            builder.append(eventUpdateStatus.toJSON());
            //builder.append(",");
        }
        builder.append("]");

        return builder.toString();
    }
}
