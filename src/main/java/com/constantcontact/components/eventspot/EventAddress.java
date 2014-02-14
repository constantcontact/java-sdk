package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class EventAddress extends Component implements Serializable{

    /**
     * Serial version unique identifier.
     */
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


    /**
     * Get Line 1
     *
     * @return The {@link #line1}
     */
    @JsonProperty("line1")
    public String getLine1() {
        return line1;
    }

    /**
     * Get Line 2
     *
     * @return The {@link #line2}
     */
    @JsonProperty("line2")
    public String getLine2() {
        return line2;
    }

    /**
     * Get Line 3
     *
     * @return The {@link #line3}
     */
    @JsonProperty("line3")
    public String getLine3() {
        return line3;
    }

    /**
     * Get the city.
     *
     * @return The {@link #city}
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * Get the state code.
     *
     * @return The {@link #stateCode}
     */
    @JsonProperty("state_code")
    public String getStateCode() {
        return stateCode;
    }

    /**
     * Get the country code.
     *
     * @return The {@link #countryCode}
     */
    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Get the postal code.
     *
     * @return The {@link #postalCode}
     */
    @JsonProperty("postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Get the country.
     *
     * @return The {@link #country}
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * Get the latitude.
     *
     * @return The {@link #latitude}
     */
    @JsonProperty("latitude")
    public double getLatitude() {
        return latitude;
    }

    /**
     * Get the longitude.
     *
     * @return The {@link #longitude}
     */
    @JsonProperty("longitude")
    public double getLongitude() {
        return longitude;
    }

    /**
     * Get the state.
     *
     * @return The {@link #state}
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * Set line 1
     *
     * @param line1 New value for {@link #line1}
     */
    public void setLine1(String line1) {
        this.line1 = line1;
    }

    /**
     * Set line 2
     *
     * @param line2 New value for {@link #line2}
     */
    public void setLine2(String line2) {
        this.line2 = line2;
    }

    /**
     * Set line 3
     *
     * @param line3 New value for {@link #line3}
     */
    public void setLine3(String line3) {
        this.line3 = line3;
    }

    /**
     * Set city
     *
     * @param city New value for {@link #city}
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Set State Code
     *
     * @param stateCode New value for {@link #stateCode}
     */
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    /**
     * Set Country Code
     *
     * @param countryCode New value for {@link #countryCode}
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Set Postal Code
     *
     * @param postalCode New value for {@link #postalCode}
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Set country
     *
     * @param country New value for {@link #country}
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Set latitude
     *
     * @param latitude New value for {@link #latitude}
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Set longitude
     *
     * @param longitude New value for {@link #longitude}
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Set state
     *
     * @param state New value for {@link #state}
     */
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("RegistrantSectionField [");
        builder.append(" city=");
        builder.append(city);
        builder.append(" country=");
        builder.append(country);
        builder.append(" country_code=");
        builder.append(countryCode);
        builder.append(" latitude=");
        builder.append(latitude);
        builder.append(" longitude=");
        builder.append(longitude);
        builder.append(" line1=");
        builder.append(line1);
        builder.append(" line2=");
        builder.append(line2);
        builder.append(" line3=");
        builder.append(line3);
        builder.append(" postal_code=");
        builder.append(postalCode);
        builder.append(" state=");
        builder.append(state);
        builder.append(" state_code=");
        builder.append(stateCode);
        builder.append("]");

        return builder.toString();
    }

    /**
     * Default constructor
     */
    public EventAddress() {
        super();
    }
}
