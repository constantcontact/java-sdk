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
public class UsageSummaryTest {
    private static final int DOCUMENTS_BYTES_USED = 5;

    private static final int DOCUMENT_COUNT = 6;

    private static final int FILE_COUNT = 7;

    private static final int FOLDER_COUNT = 8;

    private static final int FREE_FILES_REMAINING = 9;

    private static final int IMAGE_BYTES_USED = 10;

    private static final int IMAGE_COUNT = 11;

    private static final int TOTAL_BYTES_USED = 12;

    private static final int TOTAL_BYTES_REMAINING = 13;

    static UsageSummary createUsageSummary() {
        UsageSummary usageSummary = new UsageSummary();
        usageSummary.setDocumentBytesUsed(DOCUMENTS_BYTES_USED);
        usageSummary.setDocumentCount(DOCUMENT_COUNT);
        usageSummary.setFileCount(FILE_COUNT);
        usageSummary.setFolderCount(FOLDER_COUNT);
        usageSummary.setFreeFilesRemaining(FREE_FILES_REMAINING);
        usageSummary.setImageBytesUsed(IMAGE_BYTES_USED);
        usageSummary.setImageCount(IMAGE_COUNT);
        usageSummary.setTotalBytesUsed(TOTAL_BYTES_USED);
        usageSummary.setTotalBytesRemaining(TOTAL_BYTES_REMAINING);
        return usageSummary;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        UsageSummary usageSummary = new UsageSummary();

        usageSummary.setDocumentBytesUsed(DOCUMENTS_BYTES_USED);
        usageSummary.setDocumentCount(DOCUMENT_COUNT);
        usageSummary.setFileCount(FILE_COUNT);
        usageSummary.setFolderCount(FOLDER_COUNT);
        usageSummary.setFreeFilesRemaining(FREE_FILES_REMAINING);
        usageSummary.setImageBytesUsed(IMAGE_BYTES_USED);
        usageSummary.setImageCount(IMAGE_COUNT);
        usageSummary.setTotalBytesUsed(TOTAL_BYTES_USED);
        usageSummary.setTotalBytesRemaining(TOTAL_BYTES_REMAINING);

        runAssertions(usageSummary);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        UsageSummary usageSummary = new UsageSummary();
        usageSummary.setDocumentBytesUsed(DOCUMENTS_BYTES_USED);
        usageSummary.setDocumentCount(DOCUMENT_COUNT);
        usageSummary.setFileCount(FILE_COUNT);
        usageSummary.setFolderCount(FOLDER_COUNT);
        usageSummary.setFreeFilesRemaining(FREE_FILES_REMAINING);
        usageSummary.setImageBytesUsed(IMAGE_BYTES_USED);
        usageSummary.setImageCount(IMAGE_COUNT);
        usageSummary.setTotalBytesUsed(TOTAL_BYTES_USED);
        usageSummary.setTotalBytesRemaining(TOTAL_BYTES_REMAINING);

        UsageSummary out = SerializationUtils.roundtrip(usageSummary);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        UsageSummary usageSummary1 = new UsageSummary();
        usageSummary1.setDocumentBytesUsed(DOCUMENTS_BYTES_USED);
        usageSummary1.setDocumentCount(DOCUMENT_COUNT);
        usageSummary1.setFileCount(FILE_COUNT);
        usageSummary1.setFolderCount(FOLDER_COUNT);
        usageSummary1.setFreeFilesRemaining(FREE_FILES_REMAINING);
        usageSummary1.setImageBytesUsed(IMAGE_BYTES_USED);
        usageSummary1.setImageCount(IMAGE_COUNT);
        usageSummary1.setTotalBytesUsed(TOTAL_BYTES_USED);
        usageSummary1.setTotalBytesRemaining(TOTAL_BYTES_REMAINING);
        UsageSummary usageSummary2 = new UsageSummary();
        usageSummary2.setDocumentBytesUsed(DOCUMENTS_BYTES_USED);
        usageSummary2.setDocumentCount(DOCUMENT_COUNT);
        usageSummary2.setFileCount(FILE_COUNT);
        usageSummary2.setFolderCount(FOLDER_COUNT);
        usageSummary2.setFreeFilesRemaining(FREE_FILES_REMAINING);
        usageSummary2.setImageBytesUsed(IMAGE_BYTES_USED);
        usageSummary2.setImageCount(IMAGE_COUNT);
        usageSummary2.setTotalBytesUsed(TOTAL_BYTES_USED);
        usageSummary2.setTotalBytesRemaining(TOTAL_BYTES_REMAINING);

        int hash1 = usageSummary1.hashCode();
        int hash2 = usageSummary2.hashCode();

        assertThat(usageSummary1.equals(usageSummary2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertions(UsageSummary usageSummary) {
        assertThat(usageSummary.getDocumentBytesUsed(), is(DOCUMENTS_BYTES_USED));
        assertThat(usageSummary.getDocumentCount(), is(DOCUMENT_COUNT));
        assertThat(usageSummary.getFileCount(), is(FILE_COUNT));
        assertThat(usageSummary.getFolderCount(), is(FOLDER_COUNT));
        assertThat(usageSummary.getFreeFilesRemaining(), is(FREE_FILES_REMAINING));
        assertThat(usageSummary.getImageBytesUsed(), is(IMAGE_BYTES_USED));
        assertThat(usageSummary.getImageCount(), is(IMAGE_COUNT));
        assertThat(usageSummary.getTotalBytesUsed(), is(TOTAL_BYTES_USED));
        assertThat(usageSummary.getTotalBytesRemaining(), is(TOTAL_BYTES_REMAINING));
    }
}
