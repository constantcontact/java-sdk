package com.constantcontact.components.eventspot.Registrant;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class PromoCodeInfo extends Component implements Serializable {

    //Todo documentation
    private static final long serialVersionUID = -6903564287000317602L;

    @JsonIgnore
    private String discountType;
    @JsonIgnore
    private String codeName;
    @JsonIgnore
    private Integer redemptionCount;
    @JsonIgnore
    private String discountScope;
    @JsonIgnore
    private Double discountAmount;
    @JsonIgnore
    private Integer discountPercent;
    @JsonIgnore
    private String codeType;

    @JsonProperty("code_name")
    public String getCodeName() {
        return codeName;
    }

    @JsonProperty("code_type")
    public String getCodeType() {
        return codeType;
    }

    @JsonProperty("discount_amount")
    public Double getDiscountAmount() {
        return discountAmount;
    }

    @JsonProperty("discount_percent")
    public Integer getDiscountPercent() {
        return discountPercent;
    }

    @JsonProperty("discount_scope")
    public String getDiscountScope() {
        return discountScope;
    }

    @JsonProperty("discount_type")
    public String getDiscountType() {
        return discountType;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public void setDiscountScope(String discountScope) {
        this.discountScope = discountScope;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public static final class DiscountType {
        public static final String PERCENT = "PERCENT";
        public static final String AMOUNT = "AMOUNT";
    }

    public static final class DiscountScope {
        public static final String FEE_LIST = "FEE_LIST";
        public static final String ORDER_TOTAL = "ORDER_TOTAL";
    }

    public static final class CodeType {
        public static final String ACCESS = "ACCESS";
        public static final String DISCOUNT = "DISCOUNT";
    }

    public static final class Status {
        public static final String LIVE = "LIVE";
        public static final String PAUSED = "PAUSED";
        public static final String DEPLETED = "DEPLETED";
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
