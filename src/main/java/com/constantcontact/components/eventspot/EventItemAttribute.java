package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class EventItemAttribute extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = -3314230862690288715L;

    /**
     * The attribute's Unique ID
     */
    @JsonIgnore
    private String id;

    /**
     * Attribute name, minimum length = 1, cannot leave blank
     */
    @JsonIgnore
    private String name;

    /**
     * Number of item attributes that are still available
     */
    @JsonIgnore
    private Integer quantityAvailable;

    /**
     * Number of item attributes offered, minimum = 0, cannot leave blank
     */
    @JsonIgnore
    private Integer quantityTotal;

    /**
     * Get the ID.
     *
     * @return The {@link #id}
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Get the name.
     *
     * @return The {@link #name}
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Get the quantityAvailable.
     *
     * @return The {@link #quantityAvailable}
     */
    @JsonProperty("quantity_available")
    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    /**
     * Get the quantityTotal.
     *
     * @return The {@link #quantityTotal}
     */
    @JsonProperty("quantity_total")
    public Integer getQuantityTotal() {
        return quantityTotal;
    }

    /**
     * Set the id.
     *
     * @param id The id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set the name.
     *
     * @param name The name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the quantityAvailable.
     *
     * @param quantityAvailable The quantityAvailable.
     */
    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    /**
     * Set the quantityTotal.
     *
     * @param quantityTotal The quantityTotal.
     */
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
