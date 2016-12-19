package com.constantcontact.v2.library;

import org.apache.commons.lang3.SerializationUtils;
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

    @Test
    public void expectThatSerializing_WillRetainValues() {
        FileUploadStatus fileUploadStatus = new FileUploadStatus();
        fileUploadStatus.setStatus(STATUS);
        fileUploadStatus.setDescription(DESCRIPTION);
        fileUploadStatus.setId(ID);

        FileUploadStatus out = SerializationUtils.roundtrip(fileUploadStatus);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        FileUploadStatus fileUploadStatus1 = new FileUploadStatus();
        fileUploadStatus1.setStatus(STATUS);
        fileUploadStatus1.setDescription(DESCRIPTION);
        fileUploadStatus1.setId(ID);
        FileUploadStatus fileUploadStatus2 = new FileUploadStatus();
        fileUploadStatus2.setStatus(STATUS);
        fileUploadStatus2.setDescription(DESCRIPTION);
        fileUploadStatus2.setId(ID);

        int hash1 = fileUploadStatus1.hashCode();
        int hash2 = fileUploadStatus2.hashCode();

        assertThat(fileUploadStatus1.equals(fileUploadStatus2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertions(FileUploadStatus fileUploadStatus) {
        assertThat(fileUploadStatus.getStatus(), is(STATUS));
        assertThat(fileUploadStatus.getDescription(), is(DESCRIPTION));
        assertThat(fileUploadStatus.getId(), is(ID));
    }
}
