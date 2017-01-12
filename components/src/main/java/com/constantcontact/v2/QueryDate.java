package com.constantcontact.v2;

import java.util.Date;

import static com.constantcontact.v2.converter.jackson.JacksonConverterFactory.ISO_8601_DATE_FORMAT;

/**
 * A date wrapper to Constant Contact API specific ISO-8601 date format for query parameters.
 */
public class QueryDate {
    private final Date date;

    public QueryDate() {
        date = new Date();
    }

    public QueryDate(long dateInMilliseconds) {
        date = new Date(dateInMilliseconds);
    }

    public QueryDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return ISO_8601_DATE_FORMAT.format(date);
    }
}
