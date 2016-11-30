package com.constantcontact.v2.campaigns;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
 */
public class SentToContactListTest {
    private static final String ID = "123";

    static SentToContactList createSentToContactList() {
        SentToContactList sentToContactList = new SentToContactList();
        sentToContactList.setId(ID);
        return sentToContactList;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        SentToContactList sentToContactList = new SentToContactList();

        sentToContactList.setId(ID);

        runAssertions(sentToContactList);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        SentToContactList sentToContactList = new SentToContactList();
        sentToContactList.setId(ID);

        SentToContactList out = SerializationUtils.roundtrip(sentToContactList);

        runAssertions(out);
    }

    static void runAssertions(SentToContactList sentToContactList) {
        assertThat(sentToContactList.getId(), is(ID));
    }
}
