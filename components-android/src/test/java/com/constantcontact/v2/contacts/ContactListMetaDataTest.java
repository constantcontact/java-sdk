package com.constantcontact.v2.contacts;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
 */
public class ContactListMetaDataTest {
    private static final String ID = "123ABC";

    private static final ContactListStatus STATUS = ContactListStatus.ACTIVE;

    static ContactListMetaData createContactListMetaData() {
        ContactListMetaData contactListMetaData = new ContactListMetaData();
        contactListMetaData.setId(ID);
        contactListMetaData.setStatus(STATUS);
        return contactListMetaData;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        ContactListMetaData contactListMetaData = new ContactListMetaData();

        contactListMetaData.setId(ID);
        contactListMetaData.setStatus(STATUS);

        runAssertions(contactListMetaData);
    }

    @Test
    public void expectThatEquals_ActsCorrectly() {
        ContactListMetaData contactListMetaData1 = new ContactListMetaData();
        contactListMetaData1.setId(ID);
        contactListMetaData1.setStatus(STATUS);
        ContactListMetaData contactListMetaData2 = new ContactListMetaData();
        contactListMetaData2.setId(ID);
        contactListMetaData2.setStatus(STATUS);

        boolean equals = contactListMetaData1.equals(contactListMetaData2);

        assertThat(equals, is(true));
    }

    static void runAssertions(ContactListMetaData contactListMetaData) {
        assertThat(contactListMetaData.getId(), is(ID));
        assertThat(contactListMetaData.getStatus(), is(STATUS));
    }
}
