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

package com.constantcontact.v2.contacts;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class NoteTest {
    private static final String ID = "123ABC";

    private static final Date DATE = new Date(0);

    private static final String NOTE = "Hi";

    static Note createNote() {
        Note note = new Note();
        note.setId(ID);
        note.setModifiedDate(DATE);
        note.setCreatedDate(DATE);
        note.setNote(NOTE);
        return note;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        Note note = new Note();

        note.setId(ID);
        note.setModifiedDate(DATE);
        note.setCreatedDate(DATE);
        note.setNote(NOTE);

        runAssertions(note);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        Note note = new Note();
        note.setId(ID);
        note.setModifiedDate(DATE);
        note.setCreatedDate(DATE);
        note.setNote(NOTE);

        Note out = SerializationUtils.roundtrip(note);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        Note note1 = new Note();
        note1.setId(ID);
        note1.setModifiedDate(DATE);
        note1.setCreatedDate(DATE);
        note1.setNote(NOTE);
        Note note2 = new Note();
        note2.setId(ID);
        note2.setModifiedDate(DATE);
        note2.setCreatedDate(DATE);
        note2.setNote(NOTE);

        int hash1 = note1.hashCode();
        int hash2 = note2.hashCode();

        assertThat(note1.equals(note2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertions(Note note) {
        assertThat(note.getId(), is(ID));
        assertThat(note.getModifiedDate(), is(DATE));
        assertThat(note.getCreatedDate(), is(DATE));
        assertThat(note.getNote(), is(NOTE));
    }
}
