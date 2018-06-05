package com.constantcontact.v2;

import org.junit.Test;

import java.time.ZonedDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class QueryDateTests {

    @Test
    public void test24HourDateConversions() {
        ZonedDateTime date = ZonedDateTime.parse("2018-06-04T09:07:30-04:00");
        QueryDate qd = new QueryDate(date.toInstant().toEpochMilli());
        assertThat(qd.toString().indexOf("2018-06-04T13:07:30"), not(equalTo(-1)));
    }
}
