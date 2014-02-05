package com.constantcontact.components.eventspot.Registrant;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class PaymentSummary extends Component implements Serializable {


    private static final long serialVersionUID = 1493089046622067316L;

    @JsonIgnore
    private String paymentType;
    @JsonIgnore
    private String paymentStatus;
    @JsonIgnore
    private RegistrantOrder order;


    @JsonProperty("payment_type")
    public String getPaymentType() {
        return paymentType;
    }

    @JsonProperty("payment_status")
    public String getPaymentStatus() {
        return paymentStatus;
    }
    @JsonProperty("order")
    public RegistrantOrder getOrder() {
        return order;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setOrder(RegistrantOrder order) {
        this.order = order;
    }

    public static final class PaymentType {
        public static final String CHECK = "CHECK";
        public static final String DOOR = "DOOR";
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PaymentSummary [payment_type=");
        builder.append(paymentType);
        builder.append(", payment_status=");
        builder.append(paymentStatus);
        builder.append(", order=");
        builder.append(order);
        builder.append("]");

        return builder.toString();
    }

    /**
     * Default Constructor
     */
    public PaymentSummary() {
        super();
    }
}
