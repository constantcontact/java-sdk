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

package com.constantcontact.v2.contacts;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Address implements Serializable {
    @JsonProperty("address_type")
    protected AddressType _addressType;

    @JsonProperty("city")
    protected String _city;

    @JsonProperty("country_code")
    protected String _countryCode;

    @JsonProperty("id")
    protected String _id;

    @JsonProperty("line1")
    protected String _line1;

    @JsonProperty("line2")
    protected String _line2;

    @JsonProperty("line3")
    protected String _line3;

    @JsonProperty("postal_code")
    protected String _postalCode;

    @JsonProperty("state_code")
    protected String _stateCode;

    @JsonProperty("state")
    protected String _state;

    @JsonProperty("sub_postal_code")
    protected String _subPostalCode;

    public Address() {
    }

    public AddressType getAddressType() {
        return _addressType;
    }

    public void setAddressType(AddressType addressType) {
        _addressType = addressType;
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

    public void setCountryCode(String countryCode){
        _countryCode = countryCode;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }

    public String getLine1() {
        return _line1;
    }

    public void setLine1(String line1){
        _line1 = line1;
    }

    public String getLine2() {
        return _line2;
    }

    public void setLine2(String line2) {
        _line2 = line2;
    }

    public String getLine3() {
        return _line3;
    }

    public void setLine3(String line3) {
        _line3 = line3;
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

    public String getState() {
        return _state;
    }

    public void setState(String state) {
        _state = state;
    }

    public String getSubPostalCode() {
        return _subPostalCode;
    }

    public void setSubPostalCode(String subPostalCode) {
        _subPostalCode = subPostalCode;
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
                    .append(_addressType, rhs.getAddressType())
                    .append(_city, rhs.getCity())
                    .append(_countryCode, rhs.getCountryCode())
                    .append(_id, rhs.getId())
                    .append(_line1, rhs.getLine1())
                    .append(_line2, rhs.getLine2())
                    .append(_line3, rhs.getLine3())
                    .append(_postalCode, rhs.getPostalCode())
                    .append(_subPostalCode, rhs.getSubPostalCode())
                    .append(_stateCode, rhs.getStateCode())
                    .append(_state, rhs.getState())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_addressType)
                .append(_city)
                .append(_countryCode)
                .append(_id)
                .append(_line1)
                .append(_line2)
                .append(_line3)
                .append(_postalCode)
                .append(_subPostalCode)
                .append(_stateCode)
                .append(_state)
                .hashCode();
    }
}
