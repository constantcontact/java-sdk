package com.constantcontact.v2.library;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
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
