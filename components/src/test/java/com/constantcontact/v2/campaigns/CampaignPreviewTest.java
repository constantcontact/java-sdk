package com.constantcontact.v2.campaigns;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
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

    private void runAssertions(CampaignPreview campaignPreview) {
        assertThat(campaignPreview.getSubject(), is(SUBJECT));
        assertThat(campaignPreview.getFromEmail(), is(FROM_EMAIL));
        assertThat(campaignPreview.getReplyTomail(), is(REPLY_TO_EMAIL));
        assertThat(campaignPreview.getPreviewHtml(), is(PREVIEW_HTML));
        assertThat(campaignPreview.getPreviewText(), is(PREVIEW_TEXT));
    }
}
