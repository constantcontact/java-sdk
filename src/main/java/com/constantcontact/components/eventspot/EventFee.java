package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class EventFee extends Component implements Serializable {

    //Todo documentation
    private static final long serialVersionUID = -1181642065396998128L;

    @JsonIgnore
    private String id;
    @JsonIgnore
    private String label;
    @JsonIgnore
    private Double fee;
    @JsonIgnore
    private Double earlyFee;
    @JsonIgnore
    private Double lateFee;
    @JsonIgnore
    private String feeScope;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("fee")
    public Double getFee() {
        return fee;
    }

    @JsonProperty("early_fee")
    public Double getEarlyFee() {
        return earlyFee;
    }

    @JsonProperty("late_fee")
    public Double getLateFee() {
        return lateFee;
    }

    @JsonProperty("fee_scope")
    public String getFeeScope() {
        return feeScope;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public void setEarlyFee(Double earlyFee) {
        this.earlyFee = earlyFee;
    }

    public void setLateFee(Double lateFee) {
        this.lateFee = lateFee;
    }

    public void setFeeScope(String feeScope) {
        this.feeScope = feeScope;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("EventFee [");
        builder.append(" id=");
        builder.append(id);
        builder.append(", label=");
        builder.append(label);
        builder.append(", fee=");
        builder.append(id);
        builder.append(", earlyFee=");
        builder.append(earlyFee);
        builder.append(", lateFee=");
        builder.append(lateFee);
        builder.append(", feeScope=");
        builder.append(feeScope);
        builder.append("]");

        return builder.toString();
    }

    public static final class Scopes {

        public static final String BOTH = "BOTH";
        public static final String REGISTRANTS = "REGISTRANTS";
        public static final String GUESTS = "GUESTS";
    }

    /**
     * Default Constructor
     */
    public EventFee() {
        super();
    }
}
