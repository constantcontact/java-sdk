package com.constantcontact.v2.library;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
 */
public class FileTest {
    private static final String ID = "123ABC";

    private static final Date DATE = new Date(0);

    private static final String DESCRIPTION = "It's pronounced 'jif'";

    private static final FileType TYPE = FileType.GIF;

    private static final String FOLDER = "Folder1";

    private static final String FOLDER_ID = "XYZ789";

    private static final int HEIGHT = 50;

    private static final int WIDTH = 51;

    private static final boolean IS_IMAGE = true;

    private static final int SIZE = 52;

    private static final String NAME = "GIFFY";

    private static final FileStatus STATUS = FileStatus.ACTIVE;

    private static final FileSource SOURCE = FileSource.MOBILE;

    private static final Thumbnail THUMBNAIL = ThumbnailTest.createThumbnail();

    private static final String URL = "http://constantcontact.com";

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        File file = new File();

        file.setId(ID);
        file.setCreatedDate(DATE);
        file.setModifiedDate(DATE);
        file.setDescription(DESCRIPTION);
        file.setFileType(TYPE);
        file.setFolder(FOLDER);
        file.setFolderId(FOLDER_ID);
        file.setHeight(HEIGHT);
        file.setWidth(WIDTH);
        file.setImage(IS_IMAGE);
        file.setSize(SIZE);
        file.setName(NAME);
        file.setSource(SOURCE);
        file.setStatus(STATUS);
        file.setThumbnail(THUMBNAIL);
        file.setUrl(URL);

        runAssertions(file);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        File file = new File();
        file.setId(ID);
        file.setCreatedDate(DATE);
        file.setModifiedDate(DATE);
        file.setDescription(DESCRIPTION);
        file.setFileType(TYPE);
        file.setFolder(FOLDER);
        file.setFolderId(FOLDER_ID);
        file.setHeight(HEIGHT);
        file.setWidth(WIDTH);
        file.setImage(IS_IMAGE);
        file.setSize(SIZE);
        file.setName(NAME);
        file.setSource(SOURCE);
        file.setStatus(STATUS);
        file.setThumbnail(THUMBNAIL);
        file.setUrl(URL);

        File out = SerializationUtils.roundtrip(file);

        runAssertions(out);
    }

    static void runAssertions(File file) {
        assertThat(file.getId(), is(ID));
        assertThat(file.getCreatedDate(), is(DATE));
        assertThat(file.getModifiedDate(), is(DATE));
        assertThat(file.getDescription(), is(DESCRIPTION));
        assertThat(file.getFileType(), is(TYPE));
        assertThat(file.getFolder(), is(FOLDER));
        assertThat(file.getFolderId(), is(FOLDER_ID));
        assertThat(file.getHeight(), is(HEIGHT));
        assertThat(file.getWidth(), is(WIDTH));
        assertThat(file.getSize(), is(SIZE));
        assertThat(file.isImage(), is(IS_IMAGE));
        assertThat(file.getName(), is(NAME));
        assertThat(file.getSource(), is(SOURCE));
        assertThat(file.getStatus(), is(STATUS));
        ThumbnailTest.runAssertions(file.getThumbnail());
        assertThat(file.getUrl(), is(URL));
    }
}
