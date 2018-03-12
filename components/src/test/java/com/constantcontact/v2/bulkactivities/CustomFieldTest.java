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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class CustomFieldTest {
    private static final String NAME = "Name";

    private static final String VALUE = "Value";

    static CustomField createCustomField() {
        CustomField customField = new CustomField();
        customField.setName(NAME);
        customField.setValue(VALUE);
        return customField;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        CustomField customField = new CustomField();
        customField.setName(NAME);
        customField.setValue(VALUE);

        runAssertations(customField);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        CustomField customField = new CustomField();
        customField.setName(NAME);
        customField.setValue(VALUE);

        CustomField out = SerializationUtils.roundtrip(customField);

        runAssertations(out);
    }

    @Test
    public void testEqualsAndHash() {
        CustomField customField1 = new CustomField();
        customField1.setName(NAME);
        customField1.setValue(VALUE);

        CustomField customField2 = new CustomField();
        customField2.setName(NAME);
        customField2.setValue(VALUE);

        int hash1 = customField1.hashCode();
        int hash2 = customField2.hashCode();

        assertThat(customField1.equals(customField2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertations(CustomField customField) {
        assertThat(customField.getName(), is(NAME));
        assertThat(customField.getValue(), is(VALUE));
    }
}
