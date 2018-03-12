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

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class ImportDataTest {
    private static final Address[] ADDRESSES = new Address[]{AddressTest.createAddress()};

    private static final Date DATE = new Date(0);

    private static final String BIRTHDAY_DAY = "20";

    private static final String BIRTHDAY_MONTH = "10";

    private static final String COMPANY_NAME = "Constant Contact";

    private static final CustomField[] CUSTOM_FIELDS = new CustomField[]{CustomFieldTest.createCustomField()};

    private static final String[] EMAIL_ADDRESSES = new String[]{"nullmailer@constantcontact.com"};

    private static final String FIRST_NAME = "Anita";

    private static final String LAST_NAME = "Bath";

    private static final String HOME_PHONE = "617-867-5309";

    private static final String JOB_TITLE = "Professional Origami Folder";

    private static final String WORK_PHONE = "617-867-5309";

    static ImportData createImportData() {
        ImportData importData = new ImportData();
        importData.setAddresses(ADDRESSES);
        importData.setAnniversary(DATE);
        importData.setBirthdayDay(BIRTHDAY_DAY);
        importData.setBirthdayMonth(BIRTHDAY_MONTH);
        importData.setCompanyName(COMPANY_NAME);
        importData.setCustomFields(CUSTOM_FIELDS);
        importData.setEmailAddresses(EMAIL_ADDRESSES);
        importData.setFirstName(FIRST_NAME);
        importData.setLastName(LAST_NAME);
        importData.setHomePhone(HOME_PHONE);
        importData.setJobTitle(JOB_TITLE);
        importData.setWorkPhone(WORK_PHONE);
        return importData;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        ImportData importData = new ImportData();
        importData.setAddresses(ADDRESSES);
        importData.setAnniversary(DATE);
        importData.setBirthdayDay(BIRTHDAY_DAY);
        importData.setBirthdayMonth(BIRTHDAY_MONTH);
        importData.setCompanyName(COMPANY_NAME);
        importData.setCustomFields(CUSTOM_FIELDS);
        importData.setEmailAddresses(EMAIL_ADDRESSES);
        importData.setFirstName(FIRST_NAME);
        importData.setLastName(LAST_NAME);
        importData.setHomePhone(HOME_PHONE);
        importData.setJobTitle(JOB_TITLE);
        importData.setWorkPhone(WORK_PHONE);

        runAssertations(importData);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        ImportData importData = new ImportData();
        importData.setAddresses(ADDRESSES);
        importData.setAnniversary(DATE);
        importData.setBirthdayDay(BIRTHDAY_DAY);
        importData.setBirthdayMonth(BIRTHDAY_MONTH);
        importData.setCompanyName(COMPANY_NAME);
        importData.setCustomFields(CUSTOM_FIELDS);
        importData.setEmailAddresses(EMAIL_ADDRESSES);
        importData.setFirstName(FIRST_NAME);
        importData.setLastName(LAST_NAME);
        importData.setHomePhone(HOME_PHONE);
        importData.setJobTitle(JOB_TITLE);
        importData.setWorkPhone(WORK_PHONE);

        ImportData out = SerializationUtils.roundtrip(importData);

        runAssertations(out);
    }

    @Test
    public void testEqualsAndHash() {
        ImportData importData1 = new ImportData();
        importData1.setAddresses(ADDRESSES);
        importData1.setAnniversary(DATE);
        importData1.setBirthdayDay(BIRTHDAY_DAY);
        importData1.setBirthdayMonth(BIRTHDAY_MONTH);
        importData1.setCompanyName(COMPANY_NAME);
        importData1.setCustomFields(CUSTOM_FIELDS);
        importData1.setEmailAddresses(EMAIL_ADDRESSES);
        importData1.setFirstName(FIRST_NAME);
        importData1.setLastName(LAST_NAME);
        importData1.setHomePhone(HOME_PHONE);
        importData1.setJobTitle(JOB_TITLE);
        importData1.setWorkPhone(WORK_PHONE);

        ImportData importData2 = new ImportData();
        importData2.setAddresses(ADDRESSES);
        importData2.setAnniversary(DATE);
        importData2.setBirthdayDay(BIRTHDAY_DAY);
        importData2.setBirthdayMonth(BIRTHDAY_MONTH);
        importData2.setCompanyName(COMPANY_NAME);
        importData2.setCustomFields(CUSTOM_FIELDS);
        importData2.setEmailAddresses(EMAIL_ADDRESSES);
        importData2.setFirstName(FIRST_NAME);
        importData2.setLastName(LAST_NAME);
        importData2.setHomePhone(HOME_PHONE);
        importData2.setJobTitle(JOB_TITLE);
        importData2.setWorkPhone(WORK_PHONE);

        int hash1 = importData1.hashCode();
        int hash2 = importData2.hashCode();

        assertThat(importData1.equals(importData2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertations(ImportData importData) {
        assertThat(importData.getAddresses(), is(ADDRESSES));
        assertThat(importData.getAnniversary(), is(DATE));
        assertThat(importData.getBirthdayDay(), is(BIRTHDAY_DAY));
        assertThat(importData.getBirthdayMonth(), is(BIRTHDAY_MONTH));
        assertThat(importData.getCompanyName(), is(COMPANY_NAME));
        assertThat(importData.getCustomFields(), is(CUSTOM_FIELDS));
        assertThat(importData.getEmailAddresses(), is(EMAIL_ADDRESSES));
        assertThat(importData.getFirstName(), is(FIRST_NAME));
        assertThat(importData.getLastName(), is(LAST_NAME));
        assertThat(importData.getHomePhone(), is(HOME_PHONE));
        assertThat(importData.getJobTitle(), is(JOB_TITLE));
        assertThat(importData.getWorkPhone(), is(WORK_PHONE));
    }
}
