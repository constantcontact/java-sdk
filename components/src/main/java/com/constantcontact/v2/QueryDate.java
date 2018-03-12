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
