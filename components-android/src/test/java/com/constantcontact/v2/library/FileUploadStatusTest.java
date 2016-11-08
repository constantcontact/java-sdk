package com.constantcontact.v2.library;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
 */
public class FileUploadStatusTest {
    private static final long ID = 1L;

    private static final FileStatus STATUS = FileStatus.ACTIVE;

    private static final String DESCRIPTION = "A file has been uploaded";

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        FileUploadStatus fileUploadStatus = new FileUploadStatus();

        fileUploadStatus.setStatus(STATUS);
        fileUploadStatus.setDescription(DESCRIPTION);
        fileUploadStatus.setId(ID);

        runAssertions(fileUploadStatus);
    }

    static void runAssertions(FileUploadStatus fileUploadStatus) {
        assertThat(fileUploadStatus.getStatus(), is(STATUS));
        assertThat(fileUploadStatus.getDescription(), is(DESCRIPTION));
        assertThat(fileUploadStatus.getId(), is(ID));
    }
}
