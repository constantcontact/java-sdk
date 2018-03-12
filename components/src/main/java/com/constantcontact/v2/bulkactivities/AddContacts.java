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
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class AddContacts implements Serializable {

    /// REQUIRED. Specifies the contact properties (column names) to include with each contact you're adding or updating.
    /// Valid column names listed here are not case sensitive:
    /// Note: The minimum requirement is an empty array.
    ///
    /// EMAIL
    /// FIRST NAME
    /// LAST NAME
    /// BIRTHDAY_DAY - 1 to 31
    /// BIRTHDAY_MONTH - 1 to 12
    /// ANNIVERSARY - Accepts the following formats MM/DD/YYYY, M/D/YYYY, YYYY/MM/DD, YYYY/M/D, YYYY-MM-DD,
    ///               YYYY-M-D,M-D-YYYY, M-DD-YYYY. The year must be greater than 1900 and cannot be more than
    ///               10 years in the future (with respect to the current year).
    /// JOB TITLE
    /// COMPANY NAME
    /// WORK PHONE
    /// HOME PHONE
    /// ADDRESS LINE 1,2
    /// CITY
    /// STATE
    /// COUNTRY
    /// ZIP/POSTAL CODE
    /// CUSTOM FIELD 1 (to 15)
    @JsonProperty("column_names")
    protected String[] _columnNames;

    /// REQUIRED. The contact data to be imported.  The minimum requirement is one array element containing one email address.
    @JsonProperty("import_data")
    protected ImportData[] _importData;

    /// REQUIRED. An array of listIds specifying to which lists to add the contacts.  The minimum requirement is one contact list ID.
    @JsonProperty("lists")
    protected String[] _lists;

    /**
     * Class Creator
     */
    public AddContacts() {
    }

    public String[] getColumnNames() {
        return _columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        _columnNames = columnNames;
    }

    public ImportData[] getImportData() {
        return _importData;
    }

    public void setImportData(ImportData[] importData) {
        _importData = importData;
    }

    public String[] getLists() {
        return _lists;
    }

    public void setLists(String[] lists) {
        _lists = lists;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AddContacts)) {
            return false;
        } else {
            AddContacts rhs = (AddContacts) obj;
            return new EqualsBuilder()
                    .append(_columnNames, rhs.getColumnNames())
                    .append(_importData, rhs.getImportData())
                    .append(_lists, rhs.getLists())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_columnNames)
                .append(_importData)
                .append(_lists)
                .hashCode();
    }
}
