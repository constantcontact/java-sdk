package com.constantcontact.v2.campaigns;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
 */
public class MessageFooterTest {
    private static final String LINE1 = "742 Evergreen Terrace";

    private static final String LINE2 = "Apt B2";

    private static final String LINE3 = "One More Line";

    private static final String CITY = "Springfield";

    private static final String STATE = "North Dakota";

    private static final String POSTAL_CODE = "58501";

    private static final String COUNTRY = "US";

    private static final String ORGANIZATION = "Nucular Power Plant";

    private static final boolean INCLUDE_FORWARD = true;

    private static final boolean INCLUDE_SUBSCRIBE = true;

    private static final String FORWARD_TEXT = "Forwarding";

    private static final String SUBSCRIBE_TEXT = "Sub";

    private static final String INTERNATIONAL_STATE = "Wat";

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        MessageFooter messageFooter = new MessageFooter();

        messageFooter.setAddressLine1(LINE1);
        messageFooter.setAddressLine2(LINE2);
        messageFooter.setAddressLine3(LINE3);
        messageFooter.setCity(CITY);
        messageFooter.setState(STATE);
        messageFooter.setPostalCode(POSTAL_CODE);
        messageFooter.setCountry(COUNTRY);
        messageFooter.setOrganizationName(ORGANIZATION);
        messageFooter.setIncludeForwardEmail(INCLUDE_FORWARD);
        messageFooter.setIncludeSubscribeLink(INCLUDE_SUBSCRIBE);
        messageFooter.setForwardEmailLinkText(FORWARD_TEXT);
        messageFooter.setSubscribeLinkText(SUBSCRIBE_TEXT);
        messageFooter.setInternationalState(INTERNATIONAL_STATE);

        runAssertions(messageFooter);
    }

    private void runAssertions(MessageFooter messageFooter) {
        assertThat(messageFooter.getAddressLine1(), is(LINE1));
        assertThat(messageFooter.getAddressLine2(), is(LINE2));
        assertThat(messageFooter.getAddressLine3(), is(LINE3));
        assertThat(messageFooter.getCity(), is(CITY));
        assertThat(messageFooter.getState(), is(STATE));
        assertThat(messageFooter.getPostalCode(), is(POSTAL_CODE));
        assertThat(messageFooter.getCountry(), is(COUNTRY));
        assertThat(messageFooter.getOrganizationName(), is(ORGANIZATION));
        assertThat(messageFooter.getIsIncludeForwardEmail(), is(INCLUDE_FORWARD));
        assertThat(messageFooter.getIsIncludeSubscribeLink(), is(INCLUDE_SUBSCRIBE));
        assertThat(messageFooter.getForwardEmailLinkText(), is(FORWARD_TEXT));
        assertThat(messageFooter.getSubscribeLinkText(), is(SUBSCRIBE_TEXT));
        assertThat(messageFooter.getInternationalState(), is(INTERNATIONAL_STATE));
    }
}
