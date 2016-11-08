package com.constantcontact.v2.campaigns;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
 */
public class ClickThroughDetailTest {
    private static final int COUNT = 1;

    private static final String URL = "http://constantcontact.com";

    private static final String URL_UUID = "123ABC-789XYZ";

    static ClickThroughDetail createClickThroughDetail() {
        ClickThroughDetail clickThroughDetail = new ClickThroughDetail();
        clickThroughDetail.setClickCount(COUNT);
        clickThroughDetail.setUrl(URL);
        clickThroughDetail.setUrlUid(URL_UUID);
        return clickThroughDetail;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        ClickThroughDetail clickThroughDetail = new ClickThroughDetail();

        clickThroughDetail.setClickCount(COUNT);
        clickThroughDetail.setUrl(URL);
        clickThroughDetail.setUrlUid(URL_UUID);

        runAssertions(clickThroughDetail);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        ClickThroughDetail clickThroughDetail = new ClickThroughDetail();
        clickThroughDetail.setClickCount(COUNT);
        clickThroughDetail.setUrl(URL);
        clickThroughDetail.setUrlUid(URL_UUID);

        ClickThroughDetail out = SerializationUtils.roundtrip(clickThroughDetail);

        runAssertions(out);
    }

    static void runAssertions(ClickThroughDetail clickThroughDetail) {
        assertThat(clickThroughDetail.getClickCount(), is(COUNT));
        assertThat(clickThroughDetail.getUrl(), is(URL));
        assertThat(clickThroughDetail.getUrlUid(), is(URL_UUID));
    }
}
