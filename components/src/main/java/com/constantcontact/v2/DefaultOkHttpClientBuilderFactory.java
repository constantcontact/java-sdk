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

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

/**
 */
public class DefaultOkHttpClientBuilderFactory {

    @Inject
    public DefaultOkHttpClientBuilderFactory() {
    }

    public OkHttpClient.Builder create(String apiKey, String token) {
        return create(apiKey, token, HttpLoggingInterceptor.Level.NONE);
    }

    public OkHttpClient.Builder create(String apiKey, String token, HttpLoggingInterceptor.Level loggingLevel) {
        OkHttpClient.Builder
                builder =
                new OkHttpClient().newBuilder()
                        .readTimeout(10, TimeUnit.SECONDS)
                        .connectTimeout(5, TimeUnit.SECONDS)
                        .addInterceptor(new CCApiInterceptor(apiKey, token));

        if (loggingLevel != HttpLoggingInterceptor.Level.NONE) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(loggingLevel);
            builder.addInterceptor(interceptor);
        }

        return builder;
    }
}
