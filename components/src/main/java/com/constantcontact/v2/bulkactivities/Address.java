/*
 * Copyright (c) 2016 Constant Contact, Inc. All Rights Reserved.
 * Boston, MA 02451, USA
 * Phone: (781) 472-8100
 * Fax: (781) 472-8101
 * This software is the confidential and proprietary information
 * of Constant Contact, Inc. created for Constant Contact, Inc.
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Constant Contact, Inc.
 */

package com.constantcontact.v2.bulkactivities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * Address for a contact
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Address implements Serializable {

    @JsonProperty("city")
    protected String _city;

    @JsonProperty("country_code")
    protected String _countryCode;

    @JsonProperty("line1")
    protected String _line1;

    @JsonProperty("line2")
    protected String _line2;

    @JsonProperty("postal_code")
    protected String _postalCode;

    @JsonProperty("state_code")
    protected String _stateCode;


    /**
     * Class Creator
     */
    public Address() {
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String city) {
        _city = city;
    }

    public String getCountryCode() {
        return _countryCode;
    }

    public void setCountryCode(String countryCode) {
        _countryCode = countryCode;
    }

    public String getLine1() {
        return _line1;
    }

    public void setLine1(String line1) {
        _line1 = line1;
    }

    public String getLine2() {
        return _line2;
    }

    public void setLine2(String line2) {
        _line2 = line2;
    }

    public String getPostalCode() {
        return _postalCode;
    }

    public void setPostalCode(String postalCode) {
        _postalCode = postalCode;
    }

    public String getStateCode() {
        return _stateCode;
    }

    public void setStateCode(String stateCode) {
        _stateCode = stateCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Address)) {
            return false;
        } else {
            Address rhs = (Address) obj;
            return new EqualsBuilder()
                    .append(_city, rhs.getCity())
                    .append(_countryCode, rhs.getCountryCode())
                    .append(_line1, rhs.getLine1())
                    .append(_line2, rhs.getLine2())
                    .append(_postalCode, rhs.getPostalCode())
                    .append(_stateCode, rhs.getStateCode())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_city)
                .append(_countryCode)
                .append(_line1)
                .append(_line2)
                .append(_postalCode)
                .append(_stateCode)
                .hashCode();
    }
}
