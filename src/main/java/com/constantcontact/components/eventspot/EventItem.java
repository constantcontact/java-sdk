package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class EventItem extends Component implements Serializable {


    private static final long serialVersionUID = -8378476890004011128L;

    @JsonIgnore
    private String id;
    @JsonIgnore
    private List<EventItemAttribute> attributes;
    @JsonIgnore
    private Integer defaultQuantityAvailable;
    @JsonIgnore
    private Integer defaultQuantityTotal;
    @JsonIgnore
    private String description;
    @JsonIgnore
    private String name;
    @JsonIgnore
    private Integer perRegistrantLimit;
    @JsonIgnore
    private Double price;
    @JsonIgnore
    private boolean showQuantityAvailable;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("attributes")
    public List<EventItemAttribute> getAttributes() {
        return attributes;
    }

    @JsonProperty("default_quantity_available")
    public Integer getDefaultQuantityAvailable() {
        return defaultQuantityAvailable;
    }

    @JsonProperty("default_quantity_total")
    public Integer getDefaultQuantityTotal() {
        return defaultQuantityTotal;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("per_registrant_limit")
    public Integer getPerRegistrantLimit() {
        return perRegistrantLimit;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("show_quantity_available")
    public boolean isShowQuantityAvailable() {
        return showQuantityAvailable;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAttributes(List<EventItemAttribute> attributes) {
        this.attributes = attributes;
    }

    public void setDefaultQuantityAvailable(Integer defaultQuantityAvailable) {
        this.defaultQuantityAvailable = defaultQuantityAvailable;
    }

    public void setDefaultQuantityTotal(Integer defaultQuantityTotal) {
        this.defaultQuantityTotal = defaultQuantityTotal;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPerRegistrantLimit(Integer perRegistrantLimit) {
        this.perRegistrantLimit = perRegistrantLimit;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setShowQuantityAvailable(boolean showQuantityAvailable) {
        this.showQuantityAvailable = showQuantityAvailable;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("EventItem [");
        builder.append(" id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", description=");
        builder.append(description);
        builder.append(", attributes=");
        builder.append(attributes);
        builder.append(", default_quantity_available=");
        builder.append(defaultQuantityAvailable);
        builder.append(", default_quantity_total=");
        builder.append(defaultQuantityTotal);
        builder.append(", per_registrant_limit=");
        builder.append(perRegistrantLimit);
        builder.append(", price=");
        builder.append(price);
        builder.append(", show_quantity_available=");
        builder.append(showQuantityAvailable);
        builder.append("]");

        return builder.toString();
    }

    /**
     * Default constructor
     */

    public EventItem() {
        super();
    }
}
