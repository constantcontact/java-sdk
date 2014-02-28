package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * NotificationOptions for the Events in Constant Contact.
 *
 * @author ConstantContact
 * @see EventSpotService
 */
public class NotificationOptions extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = -4042120988221224734L;

    /**
     * Specifies the type of notifications sent to the contact email_address,
     * valid values: SO_REGISTRATION_NOTIFICATION - send notice for each registration (Default)
     */
    @JsonIgnore
    private String notificationType;

    /**
     * Set to true to send event notifications to the contact email_address, false for no notifications; Default is false
     */
    @JsonIgnore
    private boolean isOptedIn;

    /**
     * Get the isOptedIn.
     *
     * @return The {@link #isOptedIn}
     */
    @JsonProperty("is_opted_in")
    public boolean isOptedIn() {
        return isOptedIn;
    }

    /**
     * Get the notificationType.
     *
     * @return The {@link #notificationType}
     */
    @JsonProperty("notification_type")
    public String getNotificationType() {
        return notificationType;
    }

    /**
     * Set the isOptedIn.
     *
     * @param isOptedIn The isOptedIn.
     */
    public void setOptedIn(boolean isOptedIn) {
        this.isOptedIn = isOptedIn;
    }

    /**
     * Set the notificationType.
     *
     * @param notificationType The notificationType.
     */
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
