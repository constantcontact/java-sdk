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

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = -8378476890004011128L;

    /**
     * The item unique ID
     */
    @JsonIgnore
    private String id;

    /**
     * A list of item attributes and options
     */
    @JsonIgnore
    private List<EventItemAttribute> attributes;

    /**
     * Number of items available for sale, displayed on the registration page if show_quantity_available = true.
     */
    @JsonIgnore
    private Integer defaultQuantityAvailable;

    /**
     * The total quantity of items offered for sale, minimum = 0, cannot leave blank. If the item has attributes,
     * the summation of the quantity_total for all attributes automatically overwrites the value you enter here.
     */
    @JsonIgnore
    private Integer defaultQuantityTotal;

    /**
     * The item description that is shown on the registration page
     */
    @JsonIgnore
    private String description;

    /**
     * Item name that is shown on the registration page
     */
    @JsonIgnore
    private String name;

    /**
     * The maximum quantity of this item that a registrant, as well as any of their guests, can purchase, minimum = 0,
     * cannot leave blank; value cannot be greater than the value of default_quantity_available
     */
    @JsonIgnore
    private Integer perRegistrantLimit;

    /**
     * The item cost, minimum = 0.00
     */
    @JsonIgnore
    private Double price;

    /**
     * If true, displays the remaining quantity of this item for purchase on the registration page
     */
    @JsonIgnore
    private boolean showQuantityAvailable;

    /**
     * Get the id.
     *
     * @return The {@link #id}
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Get the attributes.
     *
     * @return The {@link #attributes}
     */
    @JsonProperty("attributes")
    public List<EventItemAttribute> getAttributes() {
        return attributes;
    }

    /**
     * Get the defaultQuantityAvailable.
     *
     * @return The {@link #defaultQuantityAvailable}
     */
    @JsonProperty("default_quantity_available")
    public Integer getDefaultQuantityAvailable() {
        return defaultQuantityAvailable;
    }

    /**
     * Get the defaultQuantityTotal.
     *
     * @return The {@link #defaultQuantityTotal}
     */
    @JsonProperty("default_quantity_total")
    public Integer getDefaultQuantityTotal() {
        return defaultQuantityTotal;
    }

    /**
     * Get the description.
     *
     * @return The {@link #description}
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
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
     * Get the perRegistrantLimit.
     *
     * @return The {@link #perRegistrantLimit}
     */
    @JsonProperty("per_registrant_limit")
    public Integer getPerRegistrantLimit() {
        return perRegistrantLimit;
    }

    /**
     * Get the price.
     *
     * @return The {@link #price}
     */
    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    /**
     * Get the showQuantityAvailable.
     *
     * @return The {@link #showQuantityAvailable}
     */
    @JsonProperty("show_quantity_available")
    public boolean isShowQuantityAvailable() {
        return showQuantityAvailable;
    }


    /**
     * Set id
     *
     * @param id New value for {@link #id}
     */
    public void setId(String id) {
        this.id = id;
    }


    /**
     * Set attributes
     *
     * @param attributes New value for {@link #attributes}
     */
    public void setAttributes(List<EventItemAttribute> attributes) {
        this.attributes = attributes;
    }

    /**
     * Set defaultQuantityAvailable
     *
     * @param defaultQuantityAvailable New value for {@link #defaultQuantityAvailable}
     */
    public void setDefaultQuantityAvailable(Integer defaultQuantityAvailable) {
        this.defaultQuantityAvailable = defaultQuantityAvailable;
    }

    /**
     * Set defaultQuantityTotal
     *
     * @param defaultQuantityTotal New value for {@link #defaultQuantityTotal}
     */
    public void setDefaultQuantityTotal(Integer defaultQuantityTotal) {
        this.defaultQuantityTotal = defaultQuantityTotal;
    }

    /**
     * Set description
     *
     * @param description New value for {@link #description}
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set name
     *
     * @param name New value for {@link #name}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set perRegistrantLimit
     *
     * @param perRegistrantLimit New value for {@link #perRegistrantLimit}
     */
    public void setPerRegistrantLimit(Integer perRegistrantLimit) {
        this.perRegistrantLimit = perRegistrantLimit;
    }

    /**
     * Set price
     *
     * @param price New value for {@link #price}
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Set state
     *
     * @param showQuantityAvailable New value for {@link #showQuantityAvailable}
     */
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
