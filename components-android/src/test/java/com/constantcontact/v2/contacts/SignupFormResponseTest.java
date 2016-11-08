package com.constantcontact.v2.contacts;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
 */
public class SignupFormResponseTest {
    private static final String[] LISTS = new String[]{"123ABC"};

    private static final String NAME = "Interest General";

    private static final String SOURCE = "Website";

    private static final String URL = "http://constantcontact.com";

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        SignupFormResponse signupFormResponse = new SignupFormResponse();

        signupFormResponse.setContactLists(LISTS);
        signupFormResponse.setSource(SOURCE);
        signupFormResponse.setListName(NAME);
        signupFormResponse.setSignupFormUrl(URL);

        runAssertions(signupFormResponse);
    }

    static void runAssertions(SignupFormResponse signupFormResponse) {
        assertThat(signupFormResponse.getContactLists(), is(LISTS));
        assertThat(signupFormResponse.getSource(), is(SOURCE));
        assertThat(signupFormResponse.getListName(), is(NAME));
        assertThat(signupFormResponse.getSignupFormUrl(), is(URL));
    }
}
