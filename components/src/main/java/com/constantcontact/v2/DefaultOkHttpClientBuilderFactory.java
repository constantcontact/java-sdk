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
        return create(apiKey, token, false);
    }

    public OkHttpClient.Builder create(String apiKey, String token, boolean debug) {
        OkHttpClient.Builder
                builder =
                new OkHttpClient().newBuilder()
                        .readTimeout(10, TimeUnit.SECONDS)
                        .connectTimeout(5, TimeUnit.SECONDS)
                        .addInterceptor(new CCApiInterceptor(apiKey, token));

        if (debug) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(interceptor);
        }

        return builder;
    }
}
