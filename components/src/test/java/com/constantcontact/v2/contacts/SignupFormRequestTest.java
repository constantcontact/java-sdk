package com.constantcontact.v2.contacts;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
 */
public class SignupFormRequestTest {
    private static final String[] LISTS = new String[]{"123ABC"};

    private static final String NAME = "Interest General";

    private static final String SOURCE = "Website";

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        SignupFormRequest signupFormRequest = new SignupFormRequest();

        signupFormRequest.setContactLists(LISTS);
        signupFormRequest.setListName(NAME);
        signupFormRequest.setSource(SOURCE);

        runAssertions(signupFormRequest);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        SignupFormRequest signupFormRequest = new SignupFormRequest();
        signupFormRequest.setContactLists(LISTS);
        signupFormRequest.setListName(NAME);
        signupFormRequest.setSource(SOURCE);

        SignupFormRequest out = SerializationUtils.roundtrip(signupFormRequest);

        runAssertions(out);
    }

    static void runAssertions(SignupFormRequest signupFormRequest) {
        assertThat(signupFormRequest.getContactLists(), is(LISTS));
        assertThat(signupFormRequest.getListName(), is(NAME));
        assertThat(signupFormRequest.getSource(), is(SOURCE));
    }
}
