package com.constantcontact.v2.campaigns;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
 */
public class TestSendTest {
    private static final String[] EMAILS = new String[]{"null@dev.net"};

    private static final EmailFormat FROMAT = EmailFormat.HTML_AND_TEXT;

    private static final String PERSONAL_MESSAGE = "hi";

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        TestSend testSend = new TestSend();

        testSend.setEmailAddresses(EMAILS);
        testSend.setFormat(FROMAT);
        testSend.setPersonalMessage(PERSONAL_MESSAGE);

        runAssertions(testSend);
    }

    private void runAssertions(TestSend testSend) {
        assertThat(testSend.getEmailAddresses(), is(EMAILS));
        assertThat(testSend.getFormat(), is(FROMAT));
        assertThat(testSend.getPersonalMessage(), is(PERSONAL_MESSAGE));
    }
}
