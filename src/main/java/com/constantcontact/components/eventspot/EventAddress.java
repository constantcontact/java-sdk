package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class EventAddress extends Component implements Serializable{


    private static final long serialVersionUID = -2135269145502543653L;


    /**
     * City
     */
    @JsonIgnore
    private String city;

    /**
     * Country
     */
    @JsonIgnore
    private String country;


    /**
     * Country Code
     */
    @JsonIgnore
    private String countryCode;


    /**
     * Latitude
     */
    @JsonIgnore
    private double latitude;

    /**
     * Longitude
     */
    @JsonIgnore
    private double longitude;

    /**
     * Line 1
     */
    @JsonIgnore
    private String line1;

    /**
     * Line 2
     */
    @JsonIgnore
    private String line2;

    /**
     * Line 3
     */
    @JsonIgnore
    private String line3;


    /**
     * Postal Code
     */
    @JsonIgnore
    private String postalCode;

    /**
     * State
     */
    @JsonIgnore
    private String state;

    /**
     * State Code
     */
    @JsonIgnore
    private String stateCode;


    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("latitude")
    public double getLatitude() {
        return latitude;
    }

    @JsonProperty("longitude")
    public double getLongitude() {
        return longitude;
    }

    @JsonProperty("line1")
    public String getLine1() {
        return line1;
    }

    @JsonProperty("line2")
    public String getLine2() {
        return line2;
    }

    @JsonProperty("line3")
    public String getLine3() {
        return line3;
    }

    @JsonProperty("postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state_code")
    public String getStateCode() {
        return stateCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
}
