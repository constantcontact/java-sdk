package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class EventUpdateStatus extends Component implements Serializable {

    private static final long serialVersionUID = -562327662253077313L;

    @JsonIgnore
    private String op;
    @JsonIgnore
    private String path;
    @JsonIgnore
    private String value;


    @JsonProperty("op")
    public String getOp() {
        return op;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public EventUpdateStatus(String value) {
        this.value = value;
        this.path = "#/status";
        this.op = "REPLACE";
    }
}
