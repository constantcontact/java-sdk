package com.constantcontact.v2.contacts;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
 */
public class ContactListTest {
    private static final String ID = "123ABC";

    private static final int COUNT = 10;

    private static final Date DATE = new Date(0);

    private static final String NAME = "General Interest";

    private static final ContactListStatus STATUS = ContactListStatus.ACTIVE;

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        ContactList contactList = new ContactList();

        contactList.setId(ID);
        contactList.setContactCount(COUNT);
        contactList.setCreatedDate(DATE);
        contactList.setModifiedDate(DATE);
        contactList.setName(NAME);
        contactList.setStatus(STATUS);

        runAssertions(contactList);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        ContactList contactList = new ContactList();
        contactList.setId(ID);
        contactList.setContactCount(COUNT);
        contactList.setCreatedDate(DATE);
        contactList.setModifiedDate(DATE);
        contactList.setName(NAME);
        contactList.setStatus(STATUS);

        ContactList out = SerializationUtils.roundtrip(contactList);

        runAssertions(out);
    }

    static void runAssertions(ContactList contactList) {
        assertThat(contactList.getId(), is(ID));
        assertThat(contactList.getContactCount(), is(COUNT));
        assertThat(contactList.getCreatedDate(), is(DATE));
        assertThat(contactList.getModifiedDate(), is(DATE));
        assertThat(contactList.getName(), is(NAME));
        assertThat(contactList.getStatus(), is(STATUS));
    }
}
