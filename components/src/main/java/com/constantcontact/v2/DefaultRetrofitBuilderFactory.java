package com.constantcontact.v2;

import com.constantcontact.v2.converter.jackson.JacksonConverterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * A factory for creating the default {@link Retrofit.Builder}.
 * <p>
 * NOTE: Can be used with dependency injection since the constructor
 * is marked with {@code @Inject}, and requires a {@link OkHttpClient} dependency named "ccapi2". If you aren't using DI
 * then the annotations will not affect you.
 */
public class DefaultRetrofitBuilderFactory {
    private static final String BASE_URL = "https://api.constantcontact.com/";

    private final OkHttpClient _okHttpClient;

    /**
     * Creates an instance of the factory.
     *
     * @param client the client used to initialize the created builder
     */
    @Inject
    public DefaultRetrofitBuilderFactory(@Named("ccapi2") OkHttpClient client) {
        _okHttpClient = client;
    }

    /**
     * Creates a new builder instance with the default base url. Initialized with a Jackson JSON converter.
     *
     * @return a builder instance initialized for use with service classes
     */
    public Retrofit.Builder create() {
        return create(BASE_URL);
    }

    /**
     * Creates a new builder instance with the provided base url. Initialized with a Jackson JSON converter.
     *
     * @param baseUrl the base url
     * @return a builder instance initialized for use with service classes
     */
    public Retrofit.Builder create(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(_okHttpClient)
                .addConverterFactory(JacksonConverterFactory.create());
    }
}
