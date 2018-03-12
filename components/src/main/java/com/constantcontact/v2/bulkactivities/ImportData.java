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
import java.util.Date;

/**
 * REQUIRED. The minimum requirement is one array element containing one email address.  The remainder of fields are optional.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class ImportData implements Serializable {


    @JsonProperty("addresses")
    protected Address[] _addresses;

    @JsonProperty("anniversary")
    protected Date _anniversary;

    @JsonProperty("birthday_day")
    protected String _birthdayDay;

    @JsonProperty("birthday_month")
    protected String _birthdayMonth;

    @JsonProperty("company_name")
    protected String _companyName;

    @JsonProperty("custom_fields")
    protected CustomField[] _customFields;

    @JsonProperty("email_addresses")
    protected String[] _emailAddresses;

    @JsonProperty("first_name")
    protected String _firstName;

    @JsonProperty("last_name")
    protected String _lastName;

    @JsonProperty("home_phone")
    protected String _homePhone;

    @JsonProperty("job_title")
    protected String _jobTitle;

    @JsonProperty("work_phone")
    protected String _workPhone;

    /**
     * Class Creator
     */
    public ImportData() {
    }

    public Address[] getAddresses() {
        return _addresses;
    }

    public void setAddresses(Address[] addresses) {
        _addresses = addresses;
    }

    public Date getAnniversary() {
        return _anniversary;
    }

    public void setAnniversary(Date anniversary) {
        _anniversary = anniversary;
    }

    public String getBirthdayDay() {
        return _birthdayDay;
    }

    public void setBirthdayDay(String birthdayDay) {
        _birthdayDay = birthdayDay;
    }

    public String getBirthdayMonth() {
        return _birthdayMonth;
    }

    public void setBirthdayMonth(String birthdayMonth) {
        _birthdayMonth = birthdayMonth;
    }

    public String getCompanyName() {
        return _companyName;
    }

    public void setCompanyName(String companyName) {
        _companyName = companyName;
    }

    public CustomField[] getCustomFields() {
        return _customFields;
    }

    public void setCustomFields(CustomField[] customFields) {
        _customFields = customFields;
    }

    public String[] getEmailAddresses() {
        return _emailAddresses;
    }

    public void setEmailAddresses(String[] emailAddresses) {
        _emailAddresses = emailAddresses;
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

    public String getHomePhone() {
        return _homePhone;
    }

    public void setHomePhone(String homePhone) {
        _homePhone = homePhone;
    }

    public String getJobTitle() {
        return _jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        _jobTitle = jobTitle;
    }

    public String getWorkPhone() {
        return _workPhone;
    }

    public void setWorkPhone(String workPhone) {
        _workPhone = workPhone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ImportData)) {
            return false;
        } else {
            ImportData rhs = (ImportData) obj;
            return new EqualsBuilder()
                    .append(_addresses, rhs.getAddresses())
                    .append(_anniversary, rhs.getAnniversary())
                    .append(_birthdayDay, rhs.getBirthdayDay())
                    .append(_birthdayMonth, rhs.getBirthdayMonth())
                    .append(_companyName, rhs.getCompanyName())
                    .append(_customFields, rhs.getCustomFields())
                    .append(_emailAddresses, rhs.getEmailAddresses())
                    .append(_firstName, rhs.getFirstName())
                    .append(_lastName, rhs.getLastName())
                    .append(_homePhone, rhs.getHomePhone())
                    .append(_jobTitle, rhs.getJobTitle())
                    .append(_workPhone, rhs.getWorkPhone())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_addresses)
                .append(_anniversary)
                .append(_birthdayDay)
                .append(_birthdayMonth)
                .append(_companyName)
                .append(_customFields)
                .append(_emailAddresses)
                .append(_firstName)
                .append(_lastName)
                .append(_homePhone)
                .append(_jobTitle)
                .append(_workPhone)
                .hashCode();
    }
}
