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
public class FolderTest {
    private static final String ID = "123ABC";

    private static final Date DATE = new Date(0);

    private static final int COUNT = 5;

    private static final int LEVEL = 2;

    private static final String NAME = "Folder1";

    private static final String PARENT_ID = "XYZ789";

    static Folder createFolder() {
        Folder folder = new Folder();
        folder.setId(ID);
        folder.setChildren(new Folder[]{(createChildFolder())});
        folder.setCreatedDate(DATE);
        folder.setItemCount(COUNT);
        folder.setLevel(LEVEL);
        folder.setModifiedDate(DATE);
        folder.setName(NAME);
        folder.setParentId(PARENT_ID);
        return folder;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        Folder folder = new Folder();

        folder.setId(ID);
        folder.setChildren(new Folder[]{createChildFolder()});
        folder.setCreatedDate(DATE);
        folder.setItemCount(COUNT);
        folder.setLevel(LEVEL);
        folder.setModifiedDate(DATE);
        folder.setName(NAME);
        folder.setParentId(PARENT_ID);

        runAssertions(folder, folder.getChildren()[0]);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        Folder folder = new Folder();
        folder.setId(ID);
        folder.setChildren(new Folder[]{createChildFolder()});
        folder.setCreatedDate(DATE);
        folder.setItemCount(COUNT);
        folder.setLevel(LEVEL);
        folder.setModifiedDate(DATE);
        folder.setName(NAME);
        folder.setParentId(PARENT_ID);

        Folder out = SerializationUtils.roundtrip(folder);

        runAssertions(out, out.getChildren()[0]);
    }

    @Test
    public void testEqualsAndHash() {
        Folder folder1 = new Folder();
        folder1.setId(ID);
        folder1.setChildren(new Folder[]{createChildFolder()});
        folder1.setCreatedDate(DATE);
        folder1.setItemCount(COUNT);
        folder1.setLevel(LEVEL);
        folder1.setModifiedDate(DATE);
        folder1.setName(NAME);
        folder1.setParentId(PARENT_ID);
        Folder folder2 = new Folder();
        folder2.setId(ID);
        folder2.setChildren(new Folder[]{createChildFolder()});
        folder2.setCreatedDate(DATE);
        folder2.setItemCount(COUNT);
        folder2.setLevel(LEVEL);
        folder2.setModifiedDate(DATE);
        folder2.setName(NAME);
        folder2.setParentId(PARENT_ID);

        int hash1 = folder1.hashCode();
        int hash2 = folder2.hashCode();

        assertThat(folder1.equals(folder2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertions(Folder folder, Folder subfolder) {
        assertThat(folder.getId(), is(ID));
        assertThat(folder.getCreatedDate(), is(DATE));
        assertThat(folder.getModifiedDate(), is(DATE));
        assertThat(folder.getItemCount(), is(COUNT));
        assertThat(folder.getLevel(), is(LEVEL));
        assertThat(folder.getName(), is(NAME));
        assertThat(folder.getParentId(), is(PARENT_ID));

        assertThat(subfolder.getId(), is(ID));
        assertThat(subfolder.getCreatedDate(), is(DATE));
        assertThat(subfolder.getModifiedDate(), is(DATE));
        assertThat(subfolder.getItemCount(), is(COUNT));
        assertThat(subfolder.getLevel(), is(LEVEL));
        assertThat(subfolder.getName(), is(NAME));
        assertThat(subfolder.getParentId(), is(PARENT_ID));
    }

    private static Folder createChildFolder() {
        Folder folder = new Folder();
        folder.setId(ID);
        folder.setChildren(null);
        folder.setCreatedDate(DATE);
        folder.setItemCount(COUNT);
        folder.setLevel(LEVEL);
        folder.setModifiedDate(DATE);
        folder.setName(NAME);
        folder.setParentId(PARENT_ID);
        return folder;
    }
}
