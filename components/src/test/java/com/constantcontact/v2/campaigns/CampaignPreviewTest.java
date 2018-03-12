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

package com.constantcontact.v2.campaigns;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class CampaignPreviewTest {
    private static final String SUBJECT = "MY TEST EMAIL WOAH";

    private static final String FROM_EMAIL = "null@dev.net";

    private static final String REPLY_TO_EMAIL = "null@dev.net";

    private static final String PREVIEW_HTML = "<html><body>hi</body></html>";

    private static final String PREVIEW_TEXT = "hi";

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        CampaignPreview campaignPreview = new CampaignPreview();

        campaignPreview.setSubject(SUBJECT);
        campaignPreview.setFromEmail(FROM_EMAIL);
        campaignPreview.setReplyTomail(REPLY_TO_EMAIL);
        campaignPreview.setPreviewHtml(PREVIEW_HTML);
        campaignPreview.setPreviewText(PREVIEW_TEXT);

        runAssertions(campaignPreview);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        CampaignPreview campaignPreview = new CampaignPreview();
        campaignPreview.setSubject(SUBJECT);
        campaignPreview.setFromEmail(FROM_EMAIL);
        campaignPreview.setReplyTomail(REPLY_TO_EMAIL);
        campaignPreview.setPreviewHtml(PREVIEW_HTML);
        campaignPreview.setPreviewText(PREVIEW_TEXT);

        CampaignPreview out = SerializationUtils.roundtrip(campaignPreview);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        CampaignPreview campaignPreview1 = new CampaignPreview();
        campaignPreview1.setSubject(SUBJECT);
        campaignPreview1.setFromEmail(FROM_EMAIL);
        campaignPreview1.setReplyTomail(REPLY_TO_EMAIL);
        campaignPreview1.setPreviewHtml(PREVIEW_HTML);
        campaignPreview1.setPreviewText(PREVIEW_TEXT);
        CampaignPreview campaignPreview2 = new CampaignPreview();
        campaignPreview2.setSubject(SUBJECT);
        campaignPreview2.setFromEmail(FROM_EMAIL);
        campaignPreview2.setReplyTomail(REPLY_TO_EMAIL);
        campaignPreview2.setPreviewHtml(PREVIEW_HTML);
        campaignPreview2.setPreviewText(PREVIEW_TEXT);

        int hash1 = campaignPreview1.hashCode();
        int hash2 = campaignPreview2.hashCode();

        assertThat(campaignPreview1.equals(campaignPreview2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    private void runAssertions(CampaignPreview campaignPreview) {
        assertThat(campaignPreview.getSubject(), is(SUBJECT));
        assertThat(campaignPreview.getFromEmail(), is(FROM_EMAIL));
        assertThat(campaignPreview.getReplyTomail(), is(REPLY_TO_EMAIL));
        assertThat(campaignPreview.getPreviewHtml(), is(PREVIEW_HTML));
        assertThat(campaignPreview.getPreviewText(), is(PREVIEW_TEXT));
    }
}
