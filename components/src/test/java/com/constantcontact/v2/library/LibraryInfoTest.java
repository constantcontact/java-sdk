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

package com.constantcontact.v2.library;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class LibraryInfoTest {
    private static final String ROOT = "rooted";

    private static final int MAX_FREE_FILE = 5;

    private static final int MAX_PREMIUM_SPACE = 100;

    private static final int MAX_UPLOAD_SIZE = 1;

    private static final UsageSummary SUMMARY = UsageSummaryTest.createUsageSummary();

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        LibraryInfo libraryInfo = new LibraryInfo();

        libraryInfo.setImageRoot(ROOT);
        libraryInfo.setMaxFreeFileNum(MAX_FREE_FILE);
        libraryInfo.setMaxPremiumSpaceLimit(MAX_PREMIUM_SPACE);
        libraryInfo.setMaxUploadSizeLimit(MAX_UPLOAD_SIZE);
        libraryInfo.setUsageSummary(SUMMARY);

        runAssertions(libraryInfo);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        LibraryInfo libraryInfo = new LibraryInfo();
        libraryInfo.setImageRoot(ROOT);
        libraryInfo.setMaxFreeFileNum(MAX_FREE_FILE);
        libraryInfo.setMaxPremiumSpaceLimit(MAX_PREMIUM_SPACE);
        libraryInfo.setMaxUploadSizeLimit(MAX_UPLOAD_SIZE);
        libraryInfo.setUsageSummary(SUMMARY);

        LibraryInfo out = SerializationUtils.roundtrip(libraryInfo);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        LibraryInfo libraryInfo1 = new LibraryInfo();
        libraryInfo1.setImageRoot(ROOT);
        libraryInfo1.setMaxFreeFileNum(MAX_FREE_FILE);
        libraryInfo1.setMaxPremiumSpaceLimit(MAX_PREMIUM_SPACE);
        libraryInfo1.setMaxUploadSizeLimit(MAX_UPLOAD_SIZE);
        libraryInfo1.setUsageSummary(SUMMARY);
        LibraryInfo libraryInfo2 = new LibraryInfo();
        libraryInfo2.setImageRoot(ROOT);
        libraryInfo2.setMaxFreeFileNum(MAX_FREE_FILE);
        libraryInfo2.setMaxPremiumSpaceLimit(MAX_PREMIUM_SPACE);
        libraryInfo2.setMaxUploadSizeLimit(MAX_UPLOAD_SIZE);
        libraryInfo2.setUsageSummary(SUMMARY);

        int hash1 = libraryInfo1.hashCode();
        int hash2 = libraryInfo2.hashCode();

        assertThat(libraryInfo1.equals(libraryInfo2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertions(LibraryInfo libraryInfo) {
        assertThat(libraryInfo.getImageRoot(), is(ROOT));
        assertThat(libraryInfo.getMaxFreeFileNum(), is(MAX_FREE_FILE));
        assertThat(libraryInfo.getMaxPremiumSpaceLimit(), is(MAX_PREMIUM_SPACE));
        assertThat(libraryInfo.getMaxUploadSizeLimit(), is(MAX_UPLOAD_SIZE));
        UsageSummaryTest.runAssertions(libraryInfo.getUsageSummary());
    }
}
