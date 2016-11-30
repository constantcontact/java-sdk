package com.constantcontact.v2.library;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
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

    static void runAssertions(LibraryInfo libraryInfo) {
        assertThat(libraryInfo.getImageRoot(), is(ROOT));
        assertThat(libraryInfo.getMaxFreeFileNum(), is(MAX_FREE_FILE));
        assertThat(libraryInfo.getMaxPremiumSpaceLimit(), is(MAX_PREMIUM_SPACE));
        assertThat(libraryInfo.getMaxUploadSizeLimit(), is(MAX_UPLOAD_SIZE));
        UsageSummaryTest.runAssertions(libraryInfo.getUsageSummary());
    }
}
