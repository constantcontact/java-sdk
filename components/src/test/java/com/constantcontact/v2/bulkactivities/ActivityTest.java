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

package com.constantcontact.v2.bulkactivities;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class ActivityTest {
    private static final String ID = "65a56890-0b48-11e8-860c-d4ae529a8786";

    private static final int CONTACT_COUNT = 1;

    private static final int ERROR_COUNT = 0;

    private static final String FILE_NAME = "upload_from_json.csv";

    private static final Date DATE = new Date(0);

    private static final Activity.Status ACTIVITY_STATUS = Activity.Status.COMPLETE;

    private static final Activity.Type ACTIVITY_TYPE = Activity.Type.ADD_CONTACTS;

    static Activity createActivity() {
        Activity activity = new Activity();
        activity.setId(ID);
        activity.setContactCount(CONTACT_COUNT);
        activity.setErrorCount(ERROR_COUNT);
        activity.setFileName(FILE_NAME);
        activity.setCreatedDate(DATE);
        activity.setStartDate(DATE);
        activity.setFinishDate(DATE);
        activity.setStatus(ACTIVITY_STATUS);
        activity.setType(ACTIVITY_TYPE);
        return activity;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        Activity activity = new Activity();
        activity.setId(ID);
        activity.setContactCount(CONTACT_COUNT);
        activity.setErrorCount(ERROR_COUNT);
        activity.setFileName(FILE_NAME);
        activity.setCreatedDate(DATE);
        activity.setStartDate(DATE);
        activity.setFinishDate(DATE);
        activity.setStatus(ACTIVITY_STATUS);
        activity.setType(ACTIVITY_TYPE);

        runAssertations(activity);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        Activity activity = new Activity();
        activity.setId(ID);
        activity.setContactCount(CONTACT_COUNT);
        activity.setErrorCount(ERROR_COUNT);
        activity.setFileName(FILE_NAME);
        activity.setCreatedDate(DATE);
        activity.setStartDate(DATE);
        activity.setFinishDate(DATE);
        activity.setStatus(ACTIVITY_STATUS);
        activity.setType(ACTIVITY_TYPE);

        Activity out = SerializationUtils.roundtrip(activity);

        runAssertations(out);
    }

    @Test
    public void testEqualsAndHash() {
        Activity activity1 = new Activity();
        activity1.setId(ID);
        activity1.setContactCount(CONTACT_COUNT);
        activity1.setErrorCount(ERROR_COUNT);
        activity1.setFileName(FILE_NAME);
        activity1.setCreatedDate(DATE);
        activity1.setStartDate(DATE);
        activity1.setFinishDate(DATE);
        activity1.setStatus(ACTIVITY_STATUS);
        activity1.setType(ACTIVITY_TYPE);

        Activity activity2 = new Activity();
        activity2.setId(ID);
        activity2.setContactCount(CONTACT_COUNT);
        activity2.setErrorCount(ERROR_COUNT);
        activity2.setFileName(FILE_NAME);
        activity2.setCreatedDate(DATE);
        activity2.setStartDate(DATE);
        activity2.setFinishDate(DATE);
        activity2.setStatus(ACTIVITY_STATUS);
        activity2.setType(ACTIVITY_TYPE);

        int hash1 = activity1.hashCode();
        int hash2 = activity2.hashCode();

        assertThat(activity1.equals(activity2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertations(Activity activity) {
        assertThat(activity.getId(), is(ID));
        assertThat(activity.getContactCount(), is(CONTACT_COUNT));
        assertThat(activity.getErrorCount(), is(ERROR_COUNT));
        assertThat(activity.getFileName(), is(FILE_NAME));
        assertThat(activity.getCreatedDate(), is(DATE));
        assertThat(activity.getStartDate(), is(DATE));
        assertThat(activity.getFinishDate(), is(DATE));
        assertThat(activity.getStatus(), is(ACTIVITY_STATUS));
        assertThat(activity.getType(), is(ACTIVITY_TYPE));
    }
}
