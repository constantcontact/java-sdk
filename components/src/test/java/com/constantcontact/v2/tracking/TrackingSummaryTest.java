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

package com.constantcontact.v2.tracking;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class TrackingSummaryTest {
    private static final int BOUNCE_COUNT = 1;

    private static final int CLICK_COUNT = 2;

    private static final int FORWARD_COUNT = 3;

    private static final int OPEN_COUNT = 4;

    private static final int SEND_COUNT = 5;

    private static final int UNSUBSCRIBE_COUNT = 6;

    private static final int SPAM_COUNT = 7;

    public static TrackingSummary createTrackingSummary() {
        TrackingSummary trackingSummary = new TrackingSummary();
        trackingSummary.setBounces(BOUNCE_COUNT);
        trackingSummary.setClicks(CLICK_COUNT);
        trackingSummary.setForwards(FORWARD_COUNT);
        trackingSummary.setOpens(OPEN_COUNT);
        trackingSummary.setSends(SEND_COUNT);
        trackingSummary.setUnsubscribes(UNSUBSCRIBE_COUNT);
        trackingSummary.setSpamCount(SPAM_COUNT);
        return trackingSummary;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        TrackingSummary trackingSummary = new TrackingSummary();

        trackingSummary.setBounces(BOUNCE_COUNT);
        trackingSummary.setClicks(CLICK_COUNT);
        trackingSummary.setForwards(FORWARD_COUNT);
        trackingSummary.setOpens(OPEN_COUNT);
        trackingSummary.setSends(SEND_COUNT);
        trackingSummary.setUnsubscribes(UNSUBSCRIBE_COUNT);
        trackingSummary.setSpamCount(SPAM_COUNT);

        runAssertions(trackingSummary);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        TrackingSummary trackingSummary = new TrackingSummary();
        trackingSummary.setBounces(BOUNCE_COUNT);
        trackingSummary.setClicks(CLICK_COUNT);
        trackingSummary.setForwards(FORWARD_COUNT);
        trackingSummary.setOpens(OPEN_COUNT);
        trackingSummary.setSends(SEND_COUNT);
        trackingSummary.setUnsubscribes(UNSUBSCRIBE_COUNT);
        trackingSummary.setSpamCount(SPAM_COUNT);

        TrackingSummary out = SerializationUtils.roundtrip(trackingSummary);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        TrackingSummary trackingSummary1 = new TrackingSummary();
        trackingSummary1.setBounces(BOUNCE_COUNT);
        trackingSummary1.setClicks(CLICK_COUNT);
        trackingSummary1.setForwards(FORWARD_COUNT);
        trackingSummary1.setOpens(OPEN_COUNT);
        trackingSummary1.setSends(SEND_COUNT);
        trackingSummary1.setUnsubscribes(UNSUBSCRIBE_COUNT);
        trackingSummary1.setSpamCount(SPAM_COUNT);
        TrackingSummary trackingSummary2 = new TrackingSummary();
        trackingSummary2.setBounces(BOUNCE_COUNT);
        trackingSummary2.setClicks(CLICK_COUNT);
        trackingSummary2.setForwards(FORWARD_COUNT);
        trackingSummary2.setOpens(OPEN_COUNT);
        trackingSummary2.setSends(SEND_COUNT);
        trackingSummary2.setUnsubscribes(UNSUBSCRIBE_COUNT);
        trackingSummary2.setSpamCount(SPAM_COUNT);

        int hash1 = trackingSummary1.hashCode();
        int hash2 = trackingSummary2.hashCode();

        assertThat(trackingSummary1.equals(trackingSummary2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    public static void runAssertions(TrackingSummary trackingSummary) {
        assertThat(trackingSummary.getBounces(), is(BOUNCE_COUNT));
        assertThat(trackingSummary.getClicks(), is(CLICK_COUNT));
        assertThat(trackingSummary.getForwards(), is(FORWARD_COUNT));
        assertThat(trackingSummary.getOpens(), is(OPEN_COUNT));
        assertThat(trackingSummary.getSends(), is(SEND_COUNT));
        assertThat(trackingSummary.getUnsubscribes(), is(UNSUBSCRIBE_COUNT));
        assertThat(trackingSummary.getSpamCount(), is(SPAM_COUNT));
    }
}
