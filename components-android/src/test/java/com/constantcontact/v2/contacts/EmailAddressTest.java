package com.constantcontact.v2.contacts;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
 */
public class EmailAddressTest {
    private static final String ID = "123ABC";

    private static final String EMAIL = "null@dev.net";

    private static final ConfirmStatus CONFIRM_STATUS = ConfirmStatus.CONFIRMED;

    private static final Date DATE = new Date(0);

    private static final OptInSource OPT_IN_SOURCE = OptInSource.ACTION_BY_VISITOR;

    private static final ContactStatus STATUS = ContactStatus.ACTIVE;

    static EmailAddress createEmailAddress() {
        EmailAddress emailAddress = new EmailAddress();
        emailAddress.setId(ID);
        emailAddress.setEmailAddress(EMAIL);
        emailAddress.setConfirmStatus(CONFIRM_STATUS);
        emailAddress.setOptInDate(DATE);
        emailAddress.setOptInSource(OPT_IN_SOURCE);
        emailAddress.setOptOutDate(DATE);
        emailAddress.setStatus(STATUS);
        return emailAddress;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        EmailAddress emailAddress = new EmailAddress();

        emailAddress.setId(ID);
        emailAddress.setEmailAddress(EMAIL);
        emailAddress.setConfirmStatus(CONFIRM_STATUS);
        emailAddress.setOptInDate(DATE);
        emailAddress.setOptInSource(OPT_IN_SOURCE);
        emailAddress.setOptOutDate(DATE);
        emailAddress.setStatus(STATUS);

        runAssertions(emailAddress);
    }

    static void runAssertions(EmailAddress emailAddress) {
        assertThat(emailAddress.getId(), is(ID));
        assertThat(emailAddress.getEmailAddress(), is(EMAIL));
        assertThat(emailAddress.getConfirmStatus(), is(CONFIRM_STATUS));
        assertThat(emailAddress.getOptInDate(), is(DATE));
        assertThat(emailAddress.getOptInSource(), is(OPT_IN_SOURCE));
        assertThat(emailAddress.getOptOutDate(), is(DATE));
        assertThat(emailAddress.getStatus(), is(STATUS));
    }
}
