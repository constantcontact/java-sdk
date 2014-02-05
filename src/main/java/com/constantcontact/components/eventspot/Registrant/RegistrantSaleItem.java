package com.constantcontact.components.eventspot.Registrant;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class RegistrantSaleItem extends Component implements Serializable {


    private static final long serialVersionUID = 815616620310855710L;

    @JsonIgnore
    private Float amount;
    @JsonIgnore
    private String id;
    @JsonIgnore
    private String promoType;
    @JsonIgnore
    private String name;
    @JsonIgnore
    private Integer quantity;
    @JsonIgnore
    private String type;
    @JsonIgnore
    private String feePeriodType;


    @JsonProperty("amount")
    public Float getAmount() {
        return amount;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("promo_type")
    public String getPromoType() {
        return promoType;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("fee_period_type")
    public String getFeePeriodType() {
        return feePeriodType;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPromoType(String promoType) {
        this.promoType = promoType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setType(String type) {
        this.type = type;
    }

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
