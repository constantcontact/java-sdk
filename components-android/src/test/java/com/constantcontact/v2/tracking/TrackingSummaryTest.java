package com.constantcontact.v2.tracking;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
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
