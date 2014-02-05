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

    private static final long serialVersionUID = 3579157740791488033L;

    @JsonIgnore
    private Double total;
    @JsonIgnore
    private String currencyType;
    @JsonIgnore
    private String orderDate;
    @JsonIgnore
    private String orderId;
    @JsonIgnore
    private List<RegistrantSaleItem> items;
    @JsonIgnore
    private List<RegistrantFee> fees;


    @JsonProperty("total")
    public Double getTotal() {
        return total;
    }

    @JsonProperty("currency_type")
    public String getCurrencyType() {
        return currencyType;
    }

    @JsonProperty("order_date")
    public String getOrderDate() {
        return orderDate;
    }

    @JsonProperty("order_id")
    public String getOrderId() {
        return orderId;
    }

    @JsonProperty("items")
    public List<RegistrantSaleItem> getItems() {
        return items;
    }

    @JsonProperty("fees")
    public List<RegistrantFee> getFees() {
        return fees;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setItems(List<RegistrantSaleItem> items) {
        this.items = items;
    }

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
