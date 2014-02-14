package com.constantcontact.components.eventspot;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class PaymentAddress extends EventAddress implements Serializable {

    /**
     * This class is basically just a copy of EventAddress class.
     *
     * It is used only for naming purposes.
     */

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = 6456063989961603049L;


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("PaymentAddress [");
        builder.append(" city=");
        builder.append(getCity());
        builder.append(" country=");
        builder.append(getCountry());
        builder.append(" country_code=");
        builder.append(getCountryCode());
        builder.append(" latitude=");
        builder.append(getLatitude());
        builder.append(" longitude=");
        builder.append(getLongitude());
        builder.append(" line1=");
        builder.append(getLine1());
        builder.append(" line2=");
        builder.append(getLine2());
        builder.append(" line3=");
        builder.append(getLine3());
        builder.append(" postal_code=");
        builder.append(getPostalCode());
        builder.append(" state=");
        builder.append(getState());
        builder.append(" state_code=");
        builder.append(getStateCode());
        builder.append("]");

        return builder.toString();
    }

    /**
     * Default constructor
     */
    public PaymentAddress() {
        super();
    }
}
