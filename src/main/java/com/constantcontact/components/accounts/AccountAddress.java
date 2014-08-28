package com.constantcontact.components.accounts;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Represents a single Account address for the usage of Account Service in Constant Contact.
 *
 * @see AccountService
 *
 * @author ConstantContact
 */
public class AccountAddress extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = 589231135142992430L;

    @JsonIgnore
    private String line1;
    @JsonIgnore
    private String line2;
    @JsonIgnore
    private String line3;
    @JsonIgnore
    private String city;
    @JsonIgnore
    private String state;
    @JsonIgnore
    private String stateCode;
    @JsonIgnore
    private String countryCode;
    @JsonIgnore
    private String postalCode;


    /**
     * Gets the state.
     *
     * @return The state.
     */
    @JsonIgnore
    public String getState() {
        return state;
    }

    /**
     * Sets the id.
     *
     * @param state The state
     */
    @JsonProperty("id")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the first address line.
     *
     * @return The first address line.
     */
    @JsonProperty("line1")
    public String getLine1() {
        return line1;
    }

    /**
     * Sets the first address line.
     *
     * @param line1 The first address line.
     */
    public void setLine1(String line1) {
        this.line1 = line1;
    }

    /**
     * Gets the second address line.
     *
     * @return The second address line.
     */
    @JsonProperty("line2")
    public String getLine2() {
        return line2;
    }

    /**
     * Sets the second address line.
     *
     * @param line2 The second address line.
     */
    public void setLine2(String line2) {
        this.line2 = line2;
    }

    /**
     * Gets the third address line.
     *
     * @return The third address line.
     */
    @JsonProperty("line3")
    public String getLine3() {
        return line3;
    }

    /**
     * Sets the third address line.
     *
     * @param line3 The third address line.
     */
    public void setLine3(String line3) {
        this.line3 = line3;
    }

    /**
     * Gets the city.
     *
     * @return The city.
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city The city.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state code.
     *
     * @return The state code.
     */
    @JsonProperty("state_code")
    public String getStateCode() {
        return stateCode;
    }

    /**
     * Sets the state code.
     *
     * @param stateCode The state code.
     */
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    /**
     * Gets the country code.
     *
     * @return The country code.
     */
    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the country code.
     *
     * @param countryCode The country code.
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Gets the postal code.
     *
     * @return The postal code.
     */
    @JsonProperty("postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code.
     *
     * @param postalCode The postal code.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Default constructor.
     */
    public AccountAddress() {
        super();
    }

    /**
     * Custom implementation for {@link Object#toString()}.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AccountAddress [line1=");
        builder.append(line1);
        builder.append(", line2=");
        builder.append(line2);
        builder.append(", line3=");
        builder.append(line3);
        builder.append(", city=");
        builder.append(city);
        builder.append(", state=");
        builder.append(state);
        builder.append(", stateCode=");
        builder.append(stateCode);
        builder.append(", countryCode=");
        builder.append(countryCode);
        builder.append(", postalCode=");
        builder.append(postalCode);
        builder.append("]");
        return builder.toString();
    }
}
