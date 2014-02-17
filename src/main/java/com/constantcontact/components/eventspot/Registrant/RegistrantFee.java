package com.constantcontact.components.eventspot.Registrant;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * RegistrantFee for the Events in Constant Contact.
 *
 * @author ConstantContact
 * @see EventSpotService
 */
public class RegistrantFee extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = -8056988911429307689L;

    /**
     * Unique ID for the event fee
     */
    @JsonIgnore
    private String id;

    /**
     * Amount paid
     */
    @JsonIgnore
    private Float amount;

    /**
     * Promo type
     */
    @JsonIgnore
    private String promoType;

    /**
     * Name of registrant or guest
     */
    @JsonIgnore
    private String name;

    /**
     * Number of items or guests.
     */
    @JsonIgnore
    private Integer quantity;

    /**
     * Type of fees
     */
    @JsonIgnore
    private String type;

    /**
     * Fee period type
     */
    @JsonIgnore
    private String feePeriodType;


    /**
     * Get the registrant id.
     *
     * @return The {@link #id}
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

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
     * Get the promo type.
     *
     * @return The {@link #promoType}
     */
    @JsonProperty("promo_type")
    public String getPromoType() {
        return promoType;
    }

    /**
     * Get the registrant's name.
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
     * Set the ID.
     *
     * @param id The ID.
     */
    public void setId(String id) {
        this.id = id;
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
        builder.append("RegistrantFee [id=");
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
     * Default Constructor
     */
    public RegistrantFee() {
        super();
    }
}
