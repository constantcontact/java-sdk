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

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

class CCApiInterceptor implements Interceptor {
        private final String _apiKey;

        private final String _token;

        public CCApiInterceptor(String apiKey, String token) {
            _apiKey = apiKey;
            _token = token;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            final Request originalRequest = chain.request();
            final HttpUrl originalUrl = originalRequest.url();

            final HttpUrl newUrl = originalUrl.newBuilder().addQueryParameter("api_key", _apiKey).build();
            final Request
                    newRequest =
                    originalRequest.newBuilder()
                                   .url(newUrl)
                                   .addHeader("Authorization", "Bearer " + _token)
                                   .addHeader("Content-Type", "application/json")
                                   .addHeader("User-Agent", "Constant Contact Java Library v5.2.0") // TODO: Add version # dynamically
                                   .build();
            return chain.proceed(newRequest);
        }
    }
