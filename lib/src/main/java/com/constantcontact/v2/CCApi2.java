package com.constantcontact.v2;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author woogienoogie
 */
public class CCApi2 {
    /**
     * The correct formatting of a Date using SimpleDateFormat
     */
    public final static String DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss.ss'Z'";

    public static OkHttpClient.Builder createDefaultOkHttpClientBuilder(final String apiKey, final String token) {
        return createDefaultOkHttpClientBuilder(apiKey, token, false);
    }

    public static OkHttpClient.Builder createDefaultOkHttpClientBuilder(final String apiKey, final String token,
                                                                        boolean debug) {
        OkHttpClient.Builder
                builder =
                new OkHttpClient().newBuilder()
                                  .readTimeout(10, TimeUnit.SECONDS)
                                  .connectTimeout(5, TimeUnit.SECONDS)
                                  .addInterceptor(createDefaultInterceptor(apiKey, token));

        if (debug) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(interceptor);
        }

        return builder;
    }

    public static Interceptor createDefaultInterceptor(final String apiKey, final String token) {
        return new CCApiInterceptor(apiKey, token);
    }

    public static Retrofit.Builder createDefaultRetrofitBuilder(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                                     .client(client)
                                     .addConverterFactory(JacksonConverterFactory.create());
    }

    private static final String BASE_URL = "https://api.constantcontact.com/";

    private final Retrofit _retrofit;

    protected AccountService _accountService;

    protected CampaignService _campaignService;

    protected ContactService _contactService;

    protected LibraryService _libraryService;

    protected TrackingService _trackingService;

    public CCApi2(final String apiKey, final String token) {
        OkHttpClient client = createDefaultOkHttpClientBuilder(apiKey, token).build();

        _retrofit = createDefaultRetrofitBuilder(client).build();

        _accountService = _retrofit.create(AccountService.class);
        _campaignService = _retrofit.create(CampaignService.class);
        _contactService = _retrofit.create(ContactService.class);
        _libraryService = _retrofit.create(LibraryService.class);
        _trackingService = _retrofit.create(TrackingService.class);
    }

    public CCApi2(Retrofit retrofit) {
        _retrofit = retrofit;

        _accountService = _retrofit.create(AccountService.class);
        _campaignService = _retrofit.create(CampaignService.class);
        _contactService = _retrofit.create(ContactService.class);
        _libraryService = _retrofit.create(LibraryService.class);
        _trackingService = _retrofit.create(TrackingService.class);
    }

    public Retrofit getRestAdapter() {
        return _retrofit;
    }

    public AccountService getAccountService() {
        return _accountService;
    }

    public CampaignService getCampaignService() {
        return _campaignService;
    }

    public ContactService getContactService() {
        return _contactService;
    }

    public LibraryService getLibraryService() {
        return _libraryService;
    }

    public TrackingService getTrackingService() {
        return _trackingService;
    }

}
