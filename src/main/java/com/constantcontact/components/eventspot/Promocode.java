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

    //Todo documentation
    private static final long serialVersionUID = -6903564287000317602L;

    @JsonIgnore
    private String codeName;
    @JsonIgnore
    private String codeType;
    @JsonIgnore
    private Double discountAmount;
    @JsonIgnore
    private Integer discountPercent;
    @JsonIgnore
    private String discountScope;
    @JsonIgnore
    private String discountType;
    @JsonIgnore
    private List<String> feeIds;
    @JsonIgnore
    private String id;
    @JsonIgnore
    private boolean isPaused;
    @JsonIgnore
    private Integer quantityAvailable;
    @JsonIgnore
    private Integer quantityTotal;
    @JsonIgnore
    private Integer quantityUsed;
    @JsonIgnore
    private String status;


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

    @JsonProperty("fee_ids")
    public List<String> getFeeIds() {
        return feeIds;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("is_paused")
    public boolean isPaused() {
        return isPaused;
    }

    @JsonProperty("quantity_available")
    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    @JsonProperty("quantity_total")
    public Integer getQuantityTotal() {
        return quantityTotal;
    }

    @JsonProperty("quantity_used")
    public Integer getQuantityUsed() {
        return quantityUsed;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
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

    public void setFeeIds(List<String> feeIds) {
        this.feeIds = feeIds;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPaused(boolean isPaused) {
        this.isPaused = isPaused;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public void setQuantityTotal(Integer quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    public void setQuantityUsed(Integer quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Promocode [id=");
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
