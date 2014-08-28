package com.constantcontact.components.eventspot.Registrant;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * PaymentSummary for the Events in Constant Contact.
 *
 * @author ConstantContact
 * @see EventSpotService
 */
public class PaymentSummary extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = 1493089046622067316L;

    /**
     * Payment type.
     */
    @JsonIgnore
    private String paymentType;

    /**
     * Status of the payment.
     */
    @JsonIgnore
    private String paymentStatus;

    /**
     * Order properties
     */
    @JsonIgnore
    private RegistrantOrder order;

    /**
     * PromoCode properties
     */
    @JsonIgnore
    private RegistrantPromoCode promoCode;

    /**
     * Get the payment type.
     *
     * @return The {@link #paymentType}
     */
    @JsonProperty("payment_type")
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * Get the payment status
     *
     * @return The {@link #paymentStatus}
     */
    @JsonProperty("payment_status")
    public String getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * Get the order properties
     *
     * @return The {@link #order}
     */
    @JsonProperty("order")
    public RegistrantOrder getOrder() {
        return order;
    }


    /**
     * Get the promocode properties.
     *
     * @return The {@link #promoCode}
     */
    @JsonProperty("promo_code")
    public RegistrantPromoCode getPromoCode() {
        return promoCode;
    }

    /**
     * Set the payment type.
     *
     * @param paymentType The payment type.
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * Set the payment status.
     *
     * @param paymentStatus The guest count.
     */
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * Set the order properties.
     *
     * @param order The order properties.
     */
    public void setOrder(RegistrantOrder order) {
        this.order = order;
    }

    /**
     * Set the promo code.
     *
     * @param promoCode Set the promo code.
     */
    public void setPromoCode(RegistrantPromoCode promoCode) {
        this.promoCode = promoCode;
    }


    /**
     * Payment type constants for the usage of {@link PaymentSummary} in Constant Contact
     *
     * @author ConstantContact
     */
    public static final class PaymentType {

        /**
         * CHECK Payment type
         */
        public static final String CHECK = "CHECK";

        /**
         * DOOR Payment type
         */
        public static final String DOOR = "DOOR";

        /**
         * Default constructor.<br/>
         * Made private to prevent instantiation.<br/>
         * This is unreachable from the outside, since current class is used only as a repository for constants.
         */
        private PaymentType(){

        }
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
        builder.append(", promo_code=");
        builder.append(promoCode);
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
