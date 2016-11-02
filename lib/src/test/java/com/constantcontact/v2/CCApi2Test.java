package com.constantcontact.v2;

import com.constantcontact.v2.account.AccountEmailAddress;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CCApi2Test {

    private static final String API_KEY = "2nrezrs3wnc7kayk49k7dd2g";

    private static final String TOKEN = "3fa21079-9c6d-47c8-a8b0-f3b466d6385f";

    private Retrofit _retrofit;

    private CCApi2 _api;

    @Before
    public void setUp() throws Exception {
        final OkHttpClient.Builder httpClientBuilder = CCApi2.createDefaultOkHttpClientBuilder(API_KEY, TOKEN, true);
        final Retrofit.Builder retrofitBuilder = CCApi2.createDefaultRetrofitBuilder(httpClientBuilder.build()).baseUrl("https://api.constantcontact.com/");
        _retrofit = retrofitBuilder.build();
        _api = new CCApi2(_retrofit);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void doSomething() throws Exception {
        final Call<List<AccountEmailAddress>> call = _api.getAccountService().getAccountEmailAddresses();
        final Response<List<AccountEmailAddress>> response = call.execute();
        final List<AccountEmailAddress> addresses = response.body();
        System.out.println(addresses);
    }
}
