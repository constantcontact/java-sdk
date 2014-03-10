package com.constantcontact.components.eventspot.Registrant;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class RegistrantPromoCode extends Component implements Serializable {

    private static final long serialVersionUID = -572514180630845836L;

    @JsonIgnore
    private Double totalDiscount;

    @JsonIgnore
    private PromocodeInfo promocodeInfo;


    /**
     * Get the tota discount.
     *
     * @return The {@link #totalDiscount}
     */
    @JsonProperty("total_discount")
    public Double getTotalDiscount() {
        return totalDiscount;
    }

    /**
     * Get the promocode info.
     *
     * @return The {@link #promocodeInfo}
     */
    @JsonProperty("promo_code_info")
    public PromocodeInfo getPromocodeInfo() {
        return promocodeInfo;
    }

    /**
     * Set the total discount.
     *
     * @param totalDiscount The total discount.
     */
    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    /**
     * Set the promocode info.
     *
     * @param promocodeInfo The promocode info.
     */
    public void setPromocodeInfo(PromocodeInfo promocodeInfo) {
        this.promocodeInfo = promocodeInfo;
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RegistrantPromoCode [total_discount=");
        builder.append(totalDiscount);
        builder.append(", promo_code_info=");
        builder.append(promocodeInfo);
        builder.append("]");

        return builder.toString();
    }
}
