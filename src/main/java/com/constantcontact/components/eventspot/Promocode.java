package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class Promocode extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = -6903564287000317602L;

    /**
     * Name of the promotional code visible to registrants, between 4 - 12 characters,
     * cannot contain spaces or special character (_ is OK); each code_name must be unique
     */
    @JsonIgnore
    private String codeName;

    /**
     * Type of promocode:
     *      ACCESS - applies to a specific fee with has_restricted_access = true,
     *          fee_list must include only a single fee_id. See Event Fees.
     *      DISCOUNT - when set to DISCOUNT, you must specify either a discount_percent or a discount_amount
     */
    @JsonIgnore
    private String codeType;

    /**
     * Specifies a fixed discount amount, minimum of 0.01, is required when code_type = DISCOUNT, but not using discount_percent
     */
    @JsonIgnore
    private Double discountAmount;

    /**
     * Specifies a discount percentage, from 1% - 100%, is required when code_type = DISCOUNT, but not using discount_amount
     */
    @JsonIgnore
    private Integer discountPercent;

    /**
     * Required when code_type = DISCOUNT;
     *      FEE_LIST - discount is applied only to those fees listed in the fee_ids array
     *      ORDER_TOTAL - discount is applied to the order total
     */
    @JsonIgnore
    private String discountScope;

    /**
     * Discount types:
     *      PERCENT - discount is a percentage specified by discount_percent
     *      AMOUNT - discount is a fixed amount, specified by discount_amount
     */
    @JsonIgnore
    private String discountType;

    /**
     * Identifies the fees to which the promocode applies
     */
    @JsonIgnore
    private List<String> feeIds;

    /**
     * Unique ID for the event promotional code
     */
    @JsonIgnore
    private String id;

    /**
     * When set to true, promocode cannot be redeemed; when false, promocode can be redeemed; default = false.
     */
    @JsonIgnore
    private boolean isPaused;

    /**
     * Number of promocodes available for redemption; -1 = unlimited.
     */
    @JsonIgnore
    private Integer quantityAvailable;

    /**
     * Total number of promocodes available for redemption; -1 = unlimited.
     */
    @JsonIgnore
    private Integer quantityTotal;

    /**
     * Number of promocodes that have been redeemed; starts at 0.
     */
    @JsonIgnore
    private Integer quantityUsed;

    /**
     * Status of the promocode
     */
    @JsonIgnore
    private String status;

    /**
     * Get the codeName.
     *
     * @return The {@link #codeName}
     */
    @JsonProperty("code_name")
    public String getCodeName() {
        return codeName;
    }

    /**
     * Get the codeType.
     *
     * @return The {@link #codeType}
     */
    @JsonProperty("code_type")
    public String getCodeType() {
        return codeType;
    }

    /**
     * Get the discountAmount.
     *
     * @return The {@link #discountAmount}
     */
    @JsonProperty("discount_amount")
    public Double getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Get the discountPercent.
     *
     * @return The {@link #discountPercent}
     */
    @JsonProperty("discount_percent")
    public Integer getDiscountPercent() {
        return discountPercent;
    }

    /**
     * Get the discountScope.
     *
     * @return The {@link #discountScope}
     */
    @JsonProperty("discount_scope")
    public String getDiscountScope() {
        return discountScope;
    }

    /**
     * Get the discountType.
     *
     * @return The {@link #discountType}
     */
    @JsonProperty("discount_type")
    public String getDiscountType() {
        return discountType;
    }

    /**
     * Get the feeIds.
     *
     * @return The {@link #feeIds}
     */
    @JsonProperty("fee_ids")
    public List<String> getFeeIds() {
        return feeIds;
    }

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
     * Get the isPaused.
     *
     * @return The {@link #isPaused}
     */
    @JsonProperty("is_paused")
    public boolean isPaused() {
        return isPaused;
    }

    /**
     * Get the quantityAvailable.
     *
     * @return The {@link #quantityAvailable}
     */
    @JsonProperty("quantity_available")
    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    /**
     * Get the quantityTotal.
     *
     * @return The {@link #quantityTotal}
     */
    @JsonProperty("quantity_total")
    public Integer getQuantityTotal() {
        return quantityTotal;
    }

    /**
     * Get the quantityTotal.
     *
     * @return The {@link #quantityTotal}
     */
    @JsonProperty("quantity_used")
    public Integer getQuantityUsed() {
        return quantityTotal;
    }

    /**
     * Get the status.
     *
     * @return The {@link #status}
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * Set the codeName.
     *
     * @param codeName The codeName.
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    /**
     * Set the codeType.
     *
     * @param codeType The codeType.
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    /**
     * Set the discountAmount.
     *
     * @param discountAmount The discountAmount.
     */
    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    /**
     * Set the discountPercent.
     *
     * @param discountPercent The discountPercent.
     */
    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    /**
     * Set the discountScope.
     *
     * @param discountScope The discountScope.
     */
    public void setDiscountScope(String discountScope) {
        this.discountScope = discountScope;
    }

    /**
     * Set the discountType.
     *
     * @param discountType The discountType.
     */
    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    /**
     * Set the feeIds.
     *
     * @param feeIds The feeIds.
     */
    public void setFeeIds(List<String> feeIds) {
        this.feeIds = feeIds;
    }

    /**
     * Set the email.
     *
     * @param id The id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set the isPaused.
     *
     * @param isPaused The isPaused.
     */
    public void setPaused(boolean isPaused) {
        this.isPaused = isPaused;
    }

    /**
     * Set the quantityAvailable.
     *
     * @param quantityAvailable The quantityAvailable.
     */
    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    /**
     * Set the quantityTotal.
     *
     * @param quantityTotal The quantityTotal.
     */
    public void setQuantityTotal(Integer quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    /**
     * Set the quantityUsed.
     *
     * @param quantityUsed The quantityUsed.
     */
    public void setQuantityUsed(Integer quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    /**
     * Set the status.
     *
     * @param status The status.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Discount type constants for the usage of {@link Promocode} in Constant Contact
     *
     * @author ConstantContact
     */
    public static final class DiscountType {

        /**
         * PERCENT - discount is a percentage specified by discount_percent
         */
        public static final String PERCENT = "PERCENT";
        /**
         * AMOUNT - discount is a fixed amount, specified by discount_amount
         */
        public static final String AMOUNT = "AMOUNT";

        /**
         * Default constructor.<br/>
         * Made private to prevent instantiation.<br/>
         * This is unreachable from the outside, since current class is used only as a repository for constants.
         */
        private DiscountType(){

        }
    }

    /**
     * Discount scope constants for the usage of {@link Promocode} in Constant Contact
     *
     * @author ConstantContact
     */
    public static final class DiscountScope {

        /**
         * FEE_LIST - discount is applied only to those fees listed in the fee_ids array
         */
        public static final String FEE_LIST = "FEE_LIST";

        /**
         * ORDER_TOTAL - discount is applied to the order total
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
     * Code type constants for the usage of {@link Promocode} in Constant Contact
     *
     * @author ConstantContact
     */
    public static final class CodeType {

        /**
         * ACCESS - applies to a specific fee with has_restricted_access = true,
         * fee_list must include only a single fee_id. See Event Fees.
         */
        public static final String ACCESS = "ACCESS";

        /**
         * DISCOUNT - when set to DISCOUNT, you must specify either a discount_percent or a discount_amount
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
     * Status constants for the usage of {@link Promocode} in Constant Contact
     *
     * @author ConstantContact
     */
    public static final class Status {

        /**
         * LIVE - promocode is available to be redeemed
         */
        public static final String LIVE = "LIVE";

        /**
         * PAUSED - promocode is not available for redemption
         */
        public static final String PAUSED = "PAUSED";

        /**
         * DEPLETED - no more promocodes remain, quantity_available = 0
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
        builder.append("PromoCode [id=");
        builder.append(id);
        builder.append(", code_name=");
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
        builder.append(", fee_ids=");
        builder.append(feeIds);
        builder.append(", is_paused=");
        builder.append(isPaused);
        builder.append(", quantity_available=");
        builder.append(quantityAvailable);
        builder.append(", quantity_total=");
        builder.append(quantityTotal);
        builder.append(", quantity_used=");
        builder.append(quantityUsed);
        builder.append(", status=");
        builder.append(status);
        builder.append("]");

        return builder.toString();
    }

    /**
     * Default Constructor
     */
    public Promocode(){
        super();
    }


}
