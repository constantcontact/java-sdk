package com.constantcontact.components.webhook;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class BillingChangeNotification {

    @JsonIgnore
    private String url;

    @JsonIgnore
    private String eventType;

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("event_type")
    public String getEventType() {
        return eventType;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * Event type constants for billing change notification.
     */
    public static final class EventType {
        /**
         * Tier increase
         */
        public static final String TIER_INCREASE = "tier.increase";

        /**
         * Tier decrease.
         */
        public static final String TIER_DECREASE = "tier.decrease";

        /**
         * Default constructor.<br/>
         * Made private to prevent instantiation.<br/>
         * This is unreachable from the outside, since current class is used only as a repository for constants.
         */
        private EventType() {
        }
    }
}
