package com.constantcontact.webhooks.model;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class BillingChangeNotification extends Component implements Serializable {


    private static final long serialVersionUID = -3368453189086934424L;

    /**
     * Location of the detailed account billing plan information -
     * make a GET call to this URL to retrieve the account billing details.
     */
    @JsonIgnore
    private String url;

    /**
     * Type of event that triggered the webhook.
     */
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("BillingChangeNotification [url=");
        builder.append(url);
        builder.append(", event_type=");
        builder.append(eventType);
        builder.append("]");
        return builder.toString();
    }


    /**
     * Default constructor
     */
    public BillingChangeNotification() {
        super();
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
