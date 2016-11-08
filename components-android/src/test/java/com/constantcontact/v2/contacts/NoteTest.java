package com.constantcontact.v2.contacts;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
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

    static void runAssertions(Note note) {
        assertThat(note.getId(), is(ID));
        assertThat(note.getModifiedDate(), is(DATE));
        assertThat(note.getCreatedDate(), is(DATE));
        assertThat(note.getNote(), is(NOTE));
    }
}
