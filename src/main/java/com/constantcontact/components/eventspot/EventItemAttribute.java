package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class EventItemAttribute extends Component implements Serializable {


    private static final long serialVersionUID = -3314230862690288715L;

    @JsonIgnore
    private String id;
    @JsonIgnore
    private String name;
    @JsonIgnore
    private Integer quantityAvailable;
    @JsonIgnore
    private Integer quantityTotal;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("quantity_available")
    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    @JsonProperty("quantity_total")
    public Integer getQuantityTotal() {
        return quantityTotal;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public void setQuantityTotal(Integer quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("EventItemAttribute [");
        builder.append(" id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", quantity_available=");
        builder.append(quantityAvailable);
        builder.append(", quantity_total=");
        builder.append(quantityTotal);
        builder.append("]");

        return builder.toString();
    }

    /**
     * Default constructor
     */

    public EventItemAttribute() {
        super();
    }
}
