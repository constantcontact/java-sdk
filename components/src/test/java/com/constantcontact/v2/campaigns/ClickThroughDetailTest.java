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

    @Test
    public void testEqualsAndHash() {
        ClickThroughDetail clickThroughDetail1 = new ClickThroughDetail();
        clickThroughDetail1.setClickCount(COUNT);
        clickThroughDetail1.setUrl(URL);
        clickThroughDetail1.setUrlUid(URL_UUID);
        ClickThroughDetail clickThroughDetail2 = new ClickThroughDetail();
        clickThroughDetail2.setClickCount(COUNT);
        clickThroughDetail2.setUrl(URL);
        clickThroughDetail2.setUrlUid(URL_UUID);

        int hash1 = clickThroughDetail1.hashCode();
        int hash2 = clickThroughDetail2.hashCode();

        assertThat(clickThroughDetail1.equals(clickThroughDetail2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertions(ClickThroughDetail clickThroughDetail) {
        assertThat(clickThroughDetail.getClickCount(), is(COUNT));
        assertThat(clickThroughDetail.getUrl(), is(URL));
        assertThat(clickThroughDetail.getUrlUid(), is(URL_UUID));
    }
}
