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
                                   .addHeader("User-Agent",
                                              "Constant Contact Java Library v5.1.6") // TODO: Add version # dynamically
                                   .build();
            return chain.proceed(newRequest);
        }
    }
