package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class NotificationOptions extends Component implements Serializable {

    private static final long serialVersionUID = -4042120988221224734L;

    @JsonIgnore
    private String notificationType;
    @JsonIgnore
    private boolean isOptedIn;

    @JsonProperty("is_opted_in")
    public boolean isOptedIn() {
        return isOptedIn;
    }

    @JsonProperty("notification_type")
    public String getNotificationType() {
        return notificationType;
    }

    public void setOptedIn(boolean isOptedIn) {
        this.isOptedIn = isOptedIn;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    /**
     * Default constructor.
     */
    public NotificationOptions() {
        super();
    }
}
