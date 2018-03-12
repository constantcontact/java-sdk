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
public class AddContactsTest {
    private static final String[] COLUMN_NAMES = new String[]{"EMAIL"};

    private static final ImportData[] IMPORT_DATA = new ImportData[]{ImportDataTest.createImportData()};

    private static final String[] LISTS = new String[]{"09af5df0-06c2-11e8-aff8-d4ae52753a3b"};

    static AddContacts createAddContacts() {
        AddContacts addContacts = new AddContacts();
        addContacts.setColumnNames(COLUMN_NAMES);
        addContacts.setImportData(IMPORT_DATA);
        addContacts.setLists(LISTS);
        return addContacts;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        AddContacts addContacts = new AddContacts();
        addContacts.setColumnNames(COLUMN_NAMES);
        addContacts.setImportData(IMPORT_DATA);
        addContacts.setLists(LISTS);

        runAssertations(addContacts);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        AddContacts addContacts = new AddContacts();
        addContacts.setColumnNames(COLUMN_NAMES);
        addContacts.setImportData(IMPORT_DATA);
        addContacts.setLists(LISTS);

        AddContacts out = SerializationUtils.roundtrip(addContacts);

        runAssertations(out);
    }

    @Test
    public void testEqualsAndHash() {
        AddContacts addContacts1 = new AddContacts();
        addContacts1.setColumnNames(COLUMN_NAMES);
        addContacts1.setImportData(IMPORT_DATA);
        addContacts1.setLists(LISTS);

        AddContacts addContacts2 = new AddContacts();
        addContacts2.setColumnNames(COLUMN_NAMES);
        addContacts2.setImportData(IMPORT_DATA);
        addContacts2.setLists(LISTS);

        int hash1 = addContacts1.hashCode();
        int hash2 = addContacts2.hashCode();

        assertThat(addContacts1.equals(addContacts2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertations(AddContacts addContacts) {
        assertThat(addContacts.getColumnNames(), is(COLUMN_NAMES));
        assertThat(addContacts.getImportData(), is(IMPORT_DATA));
        assertThat(addContacts.getLists(), is(LISTS));
    }
}
