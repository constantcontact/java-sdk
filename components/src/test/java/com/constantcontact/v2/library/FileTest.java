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

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
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

    @Test
    public void testEqualsAndHash() {
        File file1 = new File();
        file1.setId(ID);
        file1.setCreatedDate(DATE);
        file1.setModifiedDate(DATE);
        file1.setDescription(DESCRIPTION);
        file1.setFileType(TYPE);
        file1.setFolder(FOLDER);
        file1.setFolderId(FOLDER_ID);
        file1.setHeight(HEIGHT);
        file1.setWidth(WIDTH);
        file1.setImage(IS_IMAGE);
        file1.setSize(SIZE);
        file1.setName(NAME);
        file1.setSource(SOURCE);
        file1.setStatus(STATUS);
        file1.setThumbnail(THUMBNAIL);
        file1.setUrl(URL);
        File file2 = new File();
        file2.setId(ID);
        file2.setCreatedDate(DATE);
        file2.setModifiedDate(DATE);
        file2.setDescription(DESCRIPTION);
        file2.setFileType(TYPE);
        file2.setFolder(FOLDER);
        file2.setFolderId(FOLDER_ID);
        file2.setHeight(HEIGHT);
        file2.setWidth(WIDTH);
        file2.setImage(IS_IMAGE);
        file2.setSize(SIZE);
        file2.setName(NAME);
        file2.setSource(SOURCE);
        file2.setStatus(STATUS);
        file2.setThumbnail(THUMBNAIL);
        file2.setUrl(URL);

        int hash1 = file1.hashCode();
        int hash2 = file2.hashCode();

        assertThat(file1.equals(file2), is(true));
        assertThat(hash1 == hash2, is(true));
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
