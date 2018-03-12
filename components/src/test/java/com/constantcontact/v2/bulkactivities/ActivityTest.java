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

    private static final ActivityStatus ACTIVITY_STATUS = ActivityStatus.COMPLETE;

    private static final ActivityType ACTIVITY_TYPE = ActivityType.ADD_CONTACTS;

    static Activity createActivity() {
        Activity activity = new Activity();
        activity.setID(ID);
        activity.setContactCount(CONTACT_COUNT);
        activity.setErrorCount(ERROR_COUNT);
        activity.setFileName(FILE_NAME);
        activity.setCreatedDate(DATE);
        activity.setStartDate(DATE);
        activity.setFinishDate(DATE);
        activity.setActivityStatus(ACTIVITY_STATUS);
        activity.setActivityType(ACTIVITY_TYPE);
        return activity;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        Activity activity = new Activity();
        activity.setID(ID);
        activity.setContactCount(CONTACT_COUNT);
        activity.setErrorCount(ERROR_COUNT);
        activity.setFileName(FILE_NAME);
        activity.setCreatedDate(DATE);
        activity.setStartDate(DATE);
        activity.setFinishDate(DATE);
        activity.setActivityStatus(ACTIVITY_STATUS);
        activity.setActivityType(ACTIVITY_TYPE);

        runAssertations(activity);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        Activity activity = new Activity();
        activity.setID(ID);
        activity.setContactCount(CONTACT_COUNT);
        activity.setErrorCount(ERROR_COUNT);
        activity.setFileName(FILE_NAME);
        activity.setCreatedDate(DATE);
        activity.setStartDate(DATE);
        activity.setFinishDate(DATE);
        activity.setActivityStatus(ACTIVITY_STATUS);
        activity.setActivityType(ACTIVITY_TYPE);

        Activity out = SerializationUtils.roundtrip(activity);

        runAssertations(out);
    }

    @Test
    public void testEqualsAndHash() {
        Activity activity1 = new Activity();
        activity1.setID(ID);
        activity1.setContactCount(CONTACT_COUNT);
        activity1.setErrorCount(ERROR_COUNT);
        activity1.setFileName(FILE_NAME);
        activity1.setCreatedDate(DATE);
        activity1.setStartDate(DATE);
        activity1.setFinishDate(DATE);
        activity1.setActivityStatus(ACTIVITY_STATUS);
        activity1.setActivityType(ACTIVITY_TYPE);

        Activity activity2 = new Activity();
        activity2.setID(ID);
        activity2.setContactCount(CONTACT_COUNT);
        activity2.setErrorCount(ERROR_COUNT);
        activity2.setFileName(FILE_NAME);
        activity2.setCreatedDate(DATE);
        activity2.setStartDate(DATE);
        activity2.setFinishDate(DATE);
        activity2.setActivityStatus(ACTIVITY_STATUS);
        activity2.setActivityType(ACTIVITY_TYPE);

        int hash1 = activity1.hashCode();
        int hash2 = activity2.hashCode();

        assertThat(activity1.equals(activity2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertations(Activity activity) {
        assertThat(activity.getID(), is(ID));
        assertThat(activity.getContactCount(), is(CONTACT_COUNT));
        assertThat(activity.getErrorCount(), is(ERROR_COUNT));
        assertThat(activity.getFileName(), is(FILE_NAME));
        assertThat(activity.getCreatedDate(), is(DATE));
        assertThat(activity.getStartDate(), is(DATE));
        assertThat(activity.getFinishDate(), is(DATE));
        assertThat(activity.getActivityStatus(), is(ACTIVITY_STATUS));
        assertThat(activity.getActivityType(), is(ACTIVITY_TYPE));
    }
}
