package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class EventFee extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = -1181642065396998128L;


    /**
     * ID
     */
    @JsonIgnore
    private String id;

    /**
     * City
     */
    @JsonIgnore
    private String label;

    /**
     * The fee amount
     */
    @JsonIgnore
    private Double fee;

    /**
     * Fee for registrations that occur prior to the event's early_fee_date
     */
    @JsonIgnore
    private Double earlyFee;

    /**
     * City
     */
    @JsonIgnore
    private Double lateFee;

    /**
     * Specifies who the fee applies to
     */
    @JsonIgnore
    private String feeScope;

    /**
     * If true, fee is not visible, and is revealed only when registrant enters to
     * corresponding promocode with code_type = ACCESS; default is false.
     * See Promocode Collection for more information.
     */
    @JsonIgnore
    private boolean hasRestrictedAccess;

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
     * Get the label.
     *
     * @return The {@link #label}
     */
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    /**
     * Get the fee.
     *
     * @return The {@link #fee}
     */
    @JsonProperty("fee")
    public Double getFee() {
        return fee;
    }

    /**
     * Get the earlyFee.
     *
     * @return The {@link #earlyFee}
     */
    @JsonProperty("early_fee")
    public Double getEarlyFee() {
        return earlyFee;
    }

    /**
     * Get the lateFee.
     *
     * @return The {@link #lateFee}
     */
    @JsonProperty("late_fee")
    public Double getLateFee() {
        return lateFee;
    }

    /**
     * Get the feeScope.
     *
     * @return The {@link #feeScope}
     */
    @JsonProperty("fee_scope")
    public String getFeeScope() {
        return feeScope;
    }

    /**
     * Get the hasRestrictedAccess.
     *
     * @return The {@link #hasRestrictedAccess}
     */
    @JsonProperty("has_restricted_access")
    public boolean isHasRestrictedAccess() {
        return hasRestrictedAccess;
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
     * Set label
     *
     * @param label New value for {@link #label}
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Set fee
     *
     * @param fee New value for {@link #fee}
     */
    public void setFee(Double fee) {
        this.fee = fee;
    }

    /**
     * Set earlyFee
     *
     * @param earlyFee New value for {@link #earlyFee}
     */
    public void setEarlyFee(Double earlyFee) {
        this.earlyFee = earlyFee;
    }

    /**
     * Set lateFee
     *
     * @param lateFee New value for {@link #lateFee}
     */
    public void setLateFee(Double lateFee) {
        this.lateFee = lateFee;
    }

    /**
     * Set feeScope
     *
     * @param feeScope New value for {@link #feeScope}
     */
    public void setFeeScope(String feeScope) {
        this.feeScope = feeScope;
    }

    /**
     * Set hasRestrictedAccess
     *
     * @param hasRestrictedAccess New value for {@link #hasRestrictedAccess}
     */
    public void setHasRestrictedAccess(boolean hasRestrictedAccess) {
        this.hasRestrictedAccess = hasRestrictedAccess;
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
        builder.append(", has_restricted_access=");
        builder.append(hasRestrictedAccess);
        builder.append("]");

        return builder.toString();
    }

    /**
     * Fee scope constants for the usage of {@link EventFee} in Constant Contact
     *
     * @author ConstantContact
     */
    public static final class Scopes {
        /**
         * BOTH scope
         */
        public static final String BOTH = "BOTH";
        /**
         * REGISTRANTS scope
         */
        public static final String REGISTRANTS = "REGISTRANTS";
        /**
         * GUESTS scope
         */
        public static final String GUESTS = "GUESTS";

        /**
         * Default constructor.<br/>
         * Made private to prevent instantiation.<br/>
         * This is unreachable from the outside, since current class is used only as a repository for constants.
         */
        private Scopes() {

        }
    }

    /**
     * Default Constructor
     */
    public EventFee() {
        super();
    }
}
