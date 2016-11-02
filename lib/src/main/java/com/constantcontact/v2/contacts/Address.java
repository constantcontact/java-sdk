package com.constantcontact.v2.contacts;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author woogienoogie
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
}
