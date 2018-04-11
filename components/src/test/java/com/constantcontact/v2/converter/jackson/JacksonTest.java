/*
 * Copyright (c) 2018 Constant Contact, Inc. All Rights Reserved.
 * Boston, MA 02451, USA
 * Phone: (781) 472-8100
 * Fax: (781) 472-8101
 * This software is the confidential and proprietary information
 * of Constant Contact, Inc. created for Constant Contact, Inc.
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Constant Contact, Inc.
 */

package com.constantcontact.v2.converter.jackson;

import com.constantcontact.v2.campaigns.Campaign;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import java.util.Date;
import java.io.IOException;

import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class JacksonTest {
    private static final String ID = "123ABC";

    private static final Date DATE = new Date(0);

    private static final String CONTENT = "This is email content";

    private static final String FROM_EMAIL = "null@dev.net";

    private static final String FROM_NAME = "Me!";

    private static final String NAME = "My Campaign";

    private static final String REPLY_EMAIL = "null@dev.net";

    private static final String TEXT_CONTENT = "This is text content";

    private static final String SUBJECT = "READ ME";

    private static final String ALL_EMOTICONS = "\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A";

    private static final String DOUBLE_QUOTES = "\"Hello\"";

    private static final String SINGLE_QUOTES = "\'\'";

    private static final String EMOTICONS_AND_TEXT = "\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A Hello";

    private static final String URL = "http://constantcontact.com";

    private static final String PR_TEXT = "This is a reminder of permission";

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static final JacksonConverterFactory factory = JacksonConverterFactory.create(objectMapper);

    private static final Converter<Campaign, RequestBody> requestBodyConverter = (Converter<Campaign, RequestBody>)factory.requestBodyConverter(Campaign.class, null, null, null);

    @Test
    public void test_JacksonSerialization() throws IOException {
        testTrimmedRequest(SUBJECT, SUBJECT);
        // should weed out emoticons
        testTrimmedRequest(ALL_EMOTICONS, "");
        // should keep double quotes
        testTrimmedRequest(DOUBLE_QUOTES, DOUBLE_QUOTES);
        // should keep single quotes
        testTrimmedRequest(SINGLE_QUOTES, SINGLE_QUOTES);
        // emoticons and text
        testTrimmedRequest(EMOTICONS_AND_TEXT, " Hello");
    }

    private void testTrimmedRequest(String subject, String subject_test) throws IOException {
        Campaign campaign = new Campaign();
        campaign.setEmailContent(CONTENT);
        campaign.setFromEmail(FROM_EMAIL);
        campaign.setFromName(FROM_NAME);
        campaign.setName(NAME);
        campaign.setPermissionReminderText(PR_TEXT);
        campaign.setReplyToEmail(REPLY_EMAIL);
        campaign.setTextContent(TEXT_CONTENT);
        campaign.setSubject(subject);

        //Convert the campaign into the body that gets passed to a request
        RequestBody body = requestBodyConverter.convert(campaign);
        Buffer buffer = new Buffer();
        body.writeTo(buffer);
        Campaign result = objectMapper.readValue(new String(buffer.readByteArray()), Campaign.class);
        // test that the non-ascii characters were removed from the body of the request prior to sending
        runAssertions(result, subject_test);
    }


    private void runAssertions(Campaign campaign, String subject) {
        assertThat(campaign.getEmailContent(), is(CONTENT));
        assertThat(campaign.getFromEmail(), is(FROM_EMAIL));
        assertThat(campaign.getFromName(), is(FROM_NAME));
        assertThat(campaign.getPermissionReminderText(), is(PR_TEXT));
        assertThat(campaign.getName(), is(NAME));
        assertThat(campaign.getReplyToEmail(), is(REPLY_EMAIL));
        assertThat(campaign.getTextContent(), is(TEXT_CONTENT));
        assertThat(campaign.getSubject(), is(subject));
    }
}
