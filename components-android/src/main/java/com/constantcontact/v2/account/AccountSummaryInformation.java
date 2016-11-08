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
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class AccountSummaryInformation implements Parcelable {
    @JsonProperty("country_code")
    protected String _countryCode;

    @JsonProperty("email")
    protected String _email;

    @JsonProperty("first_name")
    protected String _firstName;

    @JsonProperty("last_name")
    protected String _lastName;

    @JsonProperty("organization_name")
    protected String _organizationName;

    @JsonProperty("company_logo")
    protected String _companyLogo;

    @JsonProperty("phone")
    protected String _phone;

    @JsonProperty("state_code")
    protected String _stateCode;

    @JsonProperty("time_zone")
    protected String _timeZone;

    @JsonProperty("website")
    protected String _website;

    @JsonProperty("organization_addresses")
    protected AccountAddress[] _organizationAddresses;

    public AccountSummaryInformation() {
    }

    public String getCountryCode() {
        return _countryCode;
    }

    public void setCountryCode(String countryCode) {
        _countryCode = countryCode;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public String getOrganizationName() {
        return _organizationName;
    }

    public void setOrganizationName(String organizationName) {
        _organizationName = organizationName;
    }

    public String getCompanyLogo() {
        return _companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        _companyLogo = companyLogo;
    }

    public String getPhone() {
        return _phone;
    }

    public void setPhone(String phone) {
        _phone = phone;
    }

    public String getStateCode() {
        return _stateCode;
    }

    public void setStateCode(String stateCode) {
        _stateCode = stateCode;
    }

    public String getTimeZone() {
        return _timeZone;
    }

    public void setTimeZone(String timeZone) {
        _timeZone = timeZone;
    }

    public String getWebsite() {
        return _website;
    }

    public void setWebsite(String website) {
        _website = website;
    }

    public AccountAddress[] getOrganizationAddresses() {
        return _organizationAddresses;
    }

    public void setOrganizationAddresses(AccountAddress[] organizationAddresses) {
        _organizationAddresses = organizationAddresses;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_countryCode);
        dest.writeString(_email);
        dest.writeString(_firstName);
        dest.writeString(_lastName);
        dest.writeString(_organizationName);
        dest.writeString(_companyLogo);
        dest.writeString(_phone);
        dest.writeString(_stateCode);
        dest.writeString(_timeZone);
        dest.writeString(_website);
        dest.writeTypedArray(_organizationAddresses, flags);
    }

    protected AccountSummaryInformation(Parcel in) {
        _countryCode = in.readString();
        _email = in.readString();
        _firstName = in.readString();
        _lastName = in.readString();
        _organizationName = in.readString();
        _companyLogo = in.readString();
        _phone = in.readString();
        _stateCode = in.readString();
        _timeZone = in.readString();
        _website = in.readString();
        _organizationAddresses = in.createTypedArray(AccountAddress.CREATOR);
    }

    public static final Parcelable.Creator<AccountSummaryInformation> CREATOR = new Parcelable.Creator<AccountSummaryInformation>() {
        @Override
        public AccountSummaryInformation createFromParcel(Parcel source) {
            return new AccountSummaryInformation(source);
        }

        @Override
        public AccountSummaryInformation[] newArray(int size) {
            return new AccountSummaryInformation[size];
        }
    };
}
