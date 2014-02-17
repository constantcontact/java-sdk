package com.constantcontact.components.accounts;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class AccountInfo extends Component implements Serializable {


    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = 4657041438169852269L;

    /**
     * Email address associated with the account owner
     */
    @JsonIgnore
    private String email;

    /**
     * The account owner's first name
     */
    @JsonIgnore
    private String firstName;

    /**
     * The account owner's last name
     */
    @JsonIgnore
    private String lastName;

    /**
     * Standard 2 letter ISO 3166-1 code of the country associated with the account owner
     */
    @JsonIgnore
    private String countryCode;

    /**
     * An array of organization street addresses; currently, only a single address is supported.
     * This is not a required attribute, but if you include organization_addresses in a PUT,
     * it must include the country_code, city, and line1 fields at minimum.
     */
    @JsonIgnore
    private List<AccountAddress> organizationAddresses;

    /**
     * Name of the organization associated with the account
     */
    @JsonIgnore
    private String organizationName;

    /**
     * Phone number associated with the account owner
     */
    @JsonIgnore
    private String phone;

    /**
     * 2 letter code for USA state or Canadian province ONLY,
     * available only if country_code = US or CA associated with the account owner
     */
    @JsonIgnore
    private String stateCode;

    /**
     * The time zone associated with the account
     */
    @JsonIgnore
    private String timeZone;

    /**
     * The URL of the Web site associated with the account
     */
    @JsonIgnore
    private String website;

    /**
     * Get the email.
     *
     * @return The {@link #email}
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * Get the firstName.
     *
     * @return The {@link #firstName}
     */
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the isGuestNameRequired.
     *
     * @return The {@link #lastName}
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the countryCode.
     *
     * @return The {@link #countryCode}
     */
    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Get the organizationAddresses.
     *
     * @return The {@link #organizationAddresses}
     */
    @JsonProperty("organization_addresses")
    public List<AccountAddress> getOrganizationAddresses() {
        return organizationAddresses;
    }

    /**
     * Get the organizationName.
     *
     * @return The {@link #organizationName}
     */
    @JsonProperty("organization_name")
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * Get the phone.
     *
     * @return The {@link #phone}
     */
    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    /**
     * Get the stateCode.
     *
     * @return The {@link #stateCode}
     */
    @JsonProperty("state_code")
    public String getStateCode() {
        return stateCode;
    }

    /**
     * Get the timeZone.
     *
     * @return The {@link #timeZone}
     */
    @JsonProperty("time_zone")
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * Get the website.
     *
     * @return The {@link #website}
     */
    @JsonProperty("website")
    public String getWebsite() {
        return website;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setOrganizationAddresses(List<AccountAddress> organizationAddresses) {
        this.organizationAddresses = organizationAddresses;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("AccountSummaryInfo [email=");
        builder.append(email);
        builder.append(", first_name=");
        builder.append(firstName);
        builder.append(", last_name=");
        builder.append(lastName);
        builder.append(", organization_addresses=");
        builder.append(organizationAddresses);
        builder.append(", organization_name=");
        builder.append(organizationName);
        builder.append(", phone=");
        builder.append(phone);
        builder.append(", state_code=");
        builder.append(stateCode);
        builder.append(", time_zone=");
        builder.append(timeZone);
        builder.append(", website=");
        builder.append(website);
        builder.append("]");
        return builder.toString();
    }

    /**
     * Default constructor
     */
    public AccountInfo(){
        super();
    }
}
