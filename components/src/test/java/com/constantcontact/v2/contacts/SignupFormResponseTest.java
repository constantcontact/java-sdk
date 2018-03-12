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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
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

    @Test
    public void expectThatSerializing_WillRetainValues() {
        SignupFormResponse signupFormResponse = new SignupFormResponse();
        signupFormResponse.setContactLists(LISTS);
        signupFormResponse.setSource(SOURCE);
        signupFormResponse.setListName(NAME);
        signupFormResponse.setSignupFormUrl(URL);

        SignupFormResponse out = SerializationUtils.roundtrip(signupFormResponse);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        SignupFormResponse signupFormResponse1 = new SignupFormResponse();
        signupFormResponse1.setContactLists(LISTS);
        signupFormResponse1.setSource(SOURCE);
        signupFormResponse1.setListName(NAME);
        signupFormResponse1.setSignupFormUrl(URL);
        SignupFormResponse signupFormResponse2 = new SignupFormResponse();
        signupFormResponse2.setContactLists(LISTS);
        signupFormResponse2.setSource(SOURCE);
        signupFormResponse2.setListName(NAME);
        signupFormResponse2.setSignupFormUrl(URL);

        int hash1 = signupFormResponse1.hashCode();
        int hash2 = signupFormResponse2.hashCode();

        assertThat(signupFormResponse1.equals(signupFormResponse2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertions(SignupFormResponse signupFormResponse) {
        assertThat(signupFormResponse.getContactLists(), is(LISTS));
        assertThat(signupFormResponse.getSource(), is(SOURCE));
        assertThat(signupFormResponse.getListName(), is(NAME));
        assertThat(signupFormResponse.getSignupFormUrl(), is(URL));
    }
}
