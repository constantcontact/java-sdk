package com.constantcontact.components.eventspot.Registrant;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class RegistrantSaleItem extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = 815616620310855710L;

    /**
     * Amount paid.
     */
    @JsonIgnore
    private Float amount;

    /**
     * Item ID.
     */
    @JsonIgnore
    private String id;

    /**
     * Promo type
     */
    @JsonIgnore
    private String promoType;

    /**
     * Name of the item.
     */
    @JsonIgnore
    private String name;

    /**
     * The quantity.
     */
    @JsonIgnore
    private Integer quantity;

    /**
     * The item type
     */
    @JsonIgnore
    private String type;

    /**
     * The fee period type
     */
    @JsonIgnore
    private String feePeriodType;

    /**
     * Get the amount.
     *
     * @return The {@link #amount}
     */
    @JsonProperty("amount")
    public Float getAmount() {
        return amount;
    }

    /**
     * Get the fee ID.
     *
     * @return The {@link #id}
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Get the promo type.
     *
     * @return The {@link #promoType}
     */
    @JsonProperty("promo_type")
    public String getPromoType() {
        return promoType;
    }

    /**
     * Get the total.
     *
     * @return The {@link #name}
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Get the quantity.
     *
     * @return The {@link #quantity}
     */
    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Get the type.
     *
     * @return The {@link #type}
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Get the fee period type.
     *
     * @return The {@link #feePeriodType}
     */
    @JsonProperty("fee_period_type")
    public String getFeePeriodType() {
        return feePeriodType;
    }

    /**
     * Set the amount.
     *
     * @param amount The amount.
     */
    public void setAmount(Float amount) {
        this.amount = amount;
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
     * Set the promo type.
     *
     * @param promoType The promo type.
     */
    public void setPromoType(String promoType) {
        this.promoType = promoType;
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
     * Set the quantity.
     *
     * @param quantity The quantity.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Set the type.
     *
     * @param type The type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Set the fee period type.
     *
     * @param feePeriodType The fee period type.
     */
    public void setFeePeriodType(String feePeriodType) {
        this.feePeriodType = feePeriodType;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("RegistrantSaleItem [");
        builder.append(" id=");
        builder.append(id);
        builder.append(", amount=");
        builder.append(amount);
        builder.append(", promo_type=");
        builder.append(promoType);
        builder.append(", name=");
        builder.append(name);
        builder.append(", quantity=");
        builder.append(quantity);
        builder.append(", type=");
        builder.append(type);
        builder.append(", fee_period_type=");
        builder.append(feePeriodType);
        builder.append("]");

        return builder.toString();
    }

    /**
     * Default constructor
     */

    public RegistrantSaleItem() {
        super();
    }
}
