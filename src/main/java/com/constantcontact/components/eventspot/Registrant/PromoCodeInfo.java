package com.constantcontact.components.eventspot.Registrant;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * PromoCodeInfo for the Events in Constant Contact.
 *
 * @author ConstantContact
 * @see EventSpotService
 */
public class PromoCodeInfo extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = -6903564287000317602L;

    /**
     * Discount type - either PERCENTAGE or AMOUNT
     */
    @JsonIgnore
    private String discountType;

    /**
     * Name for the promo code
     */
    @JsonIgnore
    private String codeName;

    /**
     * Redemption count
     */
    @JsonIgnore
    private Integer redemptionCount;

    /**
     * Discount scope - Is it for ITEMS or FEE
     */
    @JsonIgnore
    private String discountScope;

    /**
     * Discount amount
     */
    @JsonIgnore
    private Double discountAmount;

    /**
     * Discount percentage
     */
    @JsonIgnore
    private Integer discountPercent;

    /**
     * Code type for the promo code
     */
    @JsonIgnore
    private String codeType;

    /**
     * Get the name for the promo code.
     *
     * @return The {@link #codeName}
     */
    @JsonProperty("code_name")
    public String getCodeName() {
        return codeName;
    }

    /**
     * Get the Redemption count.
     *
     * @return The {@link #redemptionCount}
     */
    public Integer getRedemptionCount() {
        return redemptionCount;
    }

    /**
     * Get the payment type.
     *
     * @return The {@link #codeType}
     */
    @JsonProperty("code_type")
    public String getCodeType() {
        return codeType;
    }

    /**
     * Get the Discount amount.
     *
     * @return The {@link #discountAmount}
     */
    @JsonProperty("discount_amount")
    public Double getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Get the Discount percentage.
     *
     * @return The {@link #discountPercent}
     */
    @JsonProperty("discount_percent")
    public Integer getDiscountPercent() {
        return discountPercent;
    }

    /**
     * Get the Discount scope.
     *
     * @return The {@link #discountScope}
     */
    @JsonProperty("discount_scope")
    public String getDiscountScope() {
        return discountScope;
    }

    /**
     * Get the Discount type.
     *
     * @return The {@link #discountType}
     */
    @JsonProperty("discount_type")
    public String getDiscountType() {
        return discountType;
    }

    /**
     * Set the name for the promo code.
     *
     * @param codeName The guest count.
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    /**
     * Set the Redemption count.
     *
     * @param redemptionCount The Redemption count.
     */
    public void setRedemptionCount(Integer redemptionCount) {
        this.redemptionCount = redemptionCount;
    }

    /**
     * Set the code type.
     *
     * @param codeType The guest count.
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    /**
     * Set the guest count.
     *
     * @param discountAmount The discount amount.
     */
    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    /**
     * Set the Discount percentage.
     *
     * @param discountPercent The Discount percentage.
     */
    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    /**
     * Set the Discount scope.
     *
     * @param discountScope The Discount scope.
     */
    public void setDiscountScope(String discountScope) {
        this.discountScope = discountScope;
    }

    /**
     * Set the Discount type.
     *
     * @param discountType The Discount type.
     */
    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }


    /**
     * Discount type constants for the usage of {@link PromoCodeInfo} in Constant Contact
     *
     * @author ConstantContact
     */
    public static final class DiscountType {

        /**
         * PERCENT Discount type
         */
        public static final String PERCENT = "PERCENT";

        /**
         * AMOUNT Discount type
         */
        public static final String AMOUNT = "AMOUNT";

        /**
         * Default constructor.<br/>
         * Made private to prevent instantiation.<br/>
         * This is unreachable from the outside, since current class is used only as a repository for constants.
         */
        private DiscountType() {

        }
    }

    /**
     * Discount type constants for the usage of {@link PromoCodeInfo} in Constant Contact
     *
     * @author ConstantContact
     */
    public static final class DiscountScope {

        /**
         * AMOUNT Discount scope
         */
        public static final String FEE_LIST = "FEE_LIST";

        /**
         * ORDER_TOTAL Discount scope
         */
        public static final String ORDER_TOTAL = "ORDER_TOTAL";

        /**
         * Default constructor.<br/>
         * Made private to prevent instantiation.<br/>
         * This is unreachable from the outside, since current class is used only as a repository for constants.
         */
        private DiscountScope() {

        }
    }

    /**
     * Discount type constants for the usage of {@link PromoCodeInfo} in Constant Contact
     *
     * @author ConstantContact
     */
    public static final class CodeType {

        /**
         * ACCESS Code type
         */
        public static final String ACCESS = "ACCESS";

        /**
         * DISCOUNT Code type
         */
        public static final String DISCOUNT = "DISCOUNT";

        /**
         * Default constructor.<br/>
         * Made private to prevent instantiation.<br/>
         * This is unreachable from the outside, since current class is used only as a repository for constants.
         */
        private CodeType() {

        }
    }

    /**
     * Promocode Status constants for the usage of {@link PromoCodeInfo} in Constant Contact
     *
     * @author ConstantContact
     */
    public static final class Status {

        /**
         * LIVE status
         */
        public static final String LIVE = "LIVE";

        /**
         * PAUSED status
         */
        public static final String PAUSED = "PAUSED";

        /**
         * DEPLETED status
         */
        public static final String DEPLETED = "DEPLETED";

        /**
         * Default constructor.<br/>
         * Made private to prevent instantiation.<br/>
         * This is unreachable from the outside, since current class is used only as a repository for constants.
         */
        private Status() {

        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PromoCode [code_name=");
        builder.append(codeName);
        builder.append(", code_type=");
        builder.append(codeType);
        builder.append(", discount_amount=");
        builder.append(discountAmount);
        builder.append(", discount_percent=");
        builder.append(discountPercent);
        builder.append(", discount_scope=");
        builder.append(discountScope);
        builder.append(", discount_type=");
        builder.append(discountType);
        builder.append("]");

        return builder.toString();
    }

    /**
     * Default Constructor
     */
    public PromoCodeInfo() {
        super();
    }


}
