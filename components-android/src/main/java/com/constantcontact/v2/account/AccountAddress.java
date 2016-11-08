/*
 * Copyright (c) 2013-2014 Constant Contact, Inc. All Rights Reserved.
 * Boston, MA 02451, USA
 * Phone: (781) 472-8100
 * Fax: (781) 472-8101
 * This software is the confidential and proprietary information
 * of Constant Contact, Inc. created for Constant Contact, Inc.
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Constant Contact, Inc.
 */

package com.constantcontact.v2.account;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Account Address, which is part of the {@link AccountSummaryInformation}
 *
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class AccountAddress implements Parcelable {
    @JsonProperty("city")
    protected String _city;

    @JsonProperty("line1")
    protected String _line1;

    @JsonProperty("line2")
    @JsonInclude(Include.NON_EMPTY)
    protected String _line2;

    @JsonProperty("line3")
    @JsonInclude(Include.NON_EMPTY)
    protected String _line3;

    @JsonProperty("postal_code")
    protected String _postalCode;

    @JsonProperty("country_code")
    protected String _countryCode;

    @JsonProperty("state_code")
    @JsonInclude(Include.NON_EMPTY)
    protected String _stateCode;

    @JsonProperty("state")
    @JsonInclude(Include.NON_EMPTY)
    protected String _state;

    /**
     * Default constructor.
     */
    public AccountAddress() {
    }

    /**
     * Gets the city of the address.
     *
     * @return the city
     */
    public String getCity() {
        return _city;
    }

    /**
     * Sets the city field, which is required.
     *
     * @param city the city
     */
    public void setCity(String city) {
        _city = city;
    }

    /**
     * Gets line 1 of the address.
     *
     * @return the line 1
     */
    public String getLine1() {
        return _line1;
    }

    /**
     * Sets line 1 of the address, which is required.
     *
     * @param line1 the line 1
     */
    public void setLine1(String line1) {
        _line1 = line1;
    }

    /**
     * Gets line 2 of the address.
     *
     * @return the line 2
     */
    public String getLine2() {
        return _line2;
    }

    /**
     * Sets line 2 of the address. This is optional.
     *
     * @param line2 the line 2
     */
    public void setLine2(String line2) {
        _line2 = line2;
    }

    /**
     * Gets line 3 of the address.
     *
     * @return the line 3
     */
    public String getLine3() {
        return _line3;
    }

    /**
     * Sets line 3 of the address. This is optional.
     *
     * @param line3 the line 3
     */
    public void setLine3(String line3) {
        _line3 = line3;
    }

    /**
     * Gets the postal code of the address.
     *
     * @return the postal code
     */
    public String getPostalCode() {
        return _postalCode;
    }

    /**
     * Sets postal code.
     *
     * @param postalCode the postal code
     */
    public void setPostalCode(String postalCode) {
        _postalCode = postalCode;
    }

    /**
     * Gets country code.
     *
     * @return the country code
     * @see <a href="https://www.iso.org/obp/ui/#search">ISO 3166-1 code</a>
     */
    public String getCountryCode() {
        return _countryCode;
    }

    /**
     * Sets country code.
     *
     * @param countryCode the country code
     * @see <a href="https://www.iso.org/obp/ui/#search">ISO 3166-1 code</a>
     */
    public void setCountryCode(String countryCode) {
        _countryCode = countryCode;
    }

    /**
     * Gets state code.
     *
     * @return the state code
     */
    public String getStateCode() {
        return _stateCode;
    }

    /**
     * Sets the standard 2 letter abbreviation for the US state or Canadian province.
     * A data validation error occurs if state code is populated and country code is not US or CA.
     *
     * @param stateCode 2 letter state abbreviation
     */
    public void setStateCode(String stateCode) {
        _stateCode = stateCode;
    }

    /**
     * Gets the state or province for non US/CA states and provinces.
     *
     * @return the state
     */
    public String getState() {
        return _state;
    }

    /**
     * Sets name of the state or province for non US/CA states and provinces.
     *
     * @param state 50 character max name of state
     */
    public void setState(String state) {
        _state = state;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_city);
        dest.writeString(_line1);
        dest.writeString(_line2);
        dest.writeString(_line3);
        dest.writeString(_postalCode);
        dest.writeString(_countryCode);
        dest.writeString(_stateCode);
        dest.writeString(_state);
    }

    protected AccountAddress(Parcel in) {
        _city = in.readString();
        _line1 = in.readString();
        _line2 = in.readString();
        _line3 = in.readString();
        _postalCode = in.readString();
        _countryCode = in.readString();
        _stateCode = in.readString();
        _state = in.readString();
    }

    public static final Creator<AccountAddress> CREATOR = new Creator<AccountAddress>() {
        @Override
        public AccountAddress createFromParcel(android.os.Parcel source) {
            return new AccountAddress(source);
        }

        @Override
        public AccountAddress[] newArray(int size) {
            return new AccountAddress[size];
        }
    };
}
