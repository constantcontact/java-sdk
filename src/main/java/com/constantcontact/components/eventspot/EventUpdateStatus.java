package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * EventUpdateStatus for the Events in Constant Contact.
 *
 * @author ConstantContact
 * @see EventSpotService
 */
public class EventUpdateStatus extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = -562327662253077313L;

    /**
     * The operation to perform - only the REPLACE operation is supported
     */
    @JsonIgnore
    private String op;
    /**
     * Where in the object to perform it - only the path value "#/status" is allowed:
     */
    @JsonIgnore
    private String path;
    /**
     * The new value to write - only the values "ACTIVE" and "CANCELLED are allowed
     */
    @JsonIgnore
    private String value;

    /**
     * Get the operation.
     *
     * @return The {@link #op}
     */
    @JsonProperty("op")
    public String getOp() {
        return op;
    }

    /**
     * Get the path.
     *
     * @return The {@link #path}
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Get the value.
     *
     * @return The {@link #value}
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * Set the operation.
     *
     * @param op The operation.
     */
    public void setOp(String op) {
        this.op = op;
    }

    /**
     * Set the path.
     *
     * @param path The path.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Set the value.
     *
     * @param value The value.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Constructor
     *
     * @param value The new status value
     */
    public EventUpdateStatus(String value) {
        this.value = value;
        this.path = "#/status";
        this.op = "REPLACE";
    }
}
