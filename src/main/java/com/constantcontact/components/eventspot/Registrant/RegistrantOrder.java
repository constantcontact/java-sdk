package com.constantcontact.components.eventspot.Registrant;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class RegistrantOrder extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = 3579157740791488033L;

    /**
     * The total.
     */
    @JsonIgnore
    private Double total;

    /**
     * Currency type used
     */
    @JsonIgnore
    private String currencyType;

    /**
     * Date and time the order was placed.
     */
    @JsonIgnore
    private String orderDate;

    /**
     * Order ID
     */
    @JsonIgnore
    private String orderId;

    /**
     * A List of sale item properties
     */
    @JsonIgnore
    private List<RegistrantSaleItem> items;

    /**
     * A list of fee properties.
     */
    @JsonIgnore
    private List<RegistrantFee> fees;

    /**
     * Get the total.
     *
     * @return The {@link #total}
     */
    @JsonProperty("total")
    public Double getTotal() {
        return total;
    }

    /**
     * Get the currency type.
     *
     * @return The {@link #currencyType}
     */
    @JsonProperty("currency_type")
    public String getCurrencyType() {
        return currencyType;
    }

    /**
     * Get the order date.
     *
     * @return The {@link #orderDate}
     */
    @JsonProperty("order_date")
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * Get the order ID.
     *
     * @return The {@link #orderId}
     */
    @JsonProperty("order_id")
    public String getOrderId() {
        return orderId;
    }

    /**
     * Get the items.
     *
     * @return The {@link #items}
     */
    @JsonProperty("items")
    public List<RegistrantSaleItem> getItems() {
        return items;
    }

    /**
     * Get the fees.
     *
     * @return The {@link #fees}
     */
    @JsonProperty("fees")
    public List<RegistrantFee> getFees() {
        return fees;
    }

    /**
     * Set the total.
     *
     * @param total The total.
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * Set the currency type.
     *
     * @param currencyType The currency type.
     */
    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    /**
     * Set the order date.
     *
     * @param orderDate The order date.
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Set the order ID.
     *
     * @param orderId The order ID.
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Set the items.
     *
     * @param items The items.
     */
    public void setItems(List<RegistrantSaleItem> items) {
        this.items = items;
    }

    /**
     * Set the fees.
     *
     * @param fees The fees.
     */
    public void setFees(List<RegistrantFee> fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RegistrantOrder [order_id=");
        builder.append(orderId);
        builder.append(", total=");
        builder.append(total);
        builder.append(", currency_type=");
        builder.append(currencyType);
        builder.append(", order_date=");
        builder.append(orderDate);
        builder.append(", items=");
        builder.append(items);
        builder.append(", fees=");
        builder.append(fees);
        builder.append("]");

        return builder.toString();
    }

    /**
     * Default Constructor
     */
    public RegistrantOrder() {
        super();
    }
}
