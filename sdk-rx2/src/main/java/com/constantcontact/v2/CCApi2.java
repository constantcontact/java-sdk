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
import retrofit2.Retrofit;

/**
 */
public class CCApi2 {
    private final Retrofit _retrofit;

    protected AccountService _accountService;

    protected CampaignService _campaignService;

    protected ContactService _contactService;

    protected LibraryService _libraryService;

    protected CampaignTrackingService _campaignTrackingService;

    protected ContactTrackingService _contactTrackingService;

    protected BulkActivitiesService _bulkActivitiesService;

    /**
     * A convenience constructor that handles all initialization of api wrappers. Defaults to no logging.
     *
     * @param apiKey the api key
     * @param token  the logged in user's oauth2 token
     */
    public CCApi2(final String apiKey, final String token) {
        this(apiKey, token, HttpLoggingInterceptor.Level.NONE);
    }

    /**
     * A convenience constructor that handles all initialization of api wrappers.
     *
     * @param apiKey       the api key
     * @param token        the logged in user's oauth2 token
     * @param loggingLevel the logging level of the http layer
     */
    public CCApi2(final String apiKey, final String token, HttpLoggingInterceptor.Level loggingLevel) {
        DefaultOkHttpClientBuilderFactory okHttpClientBuilderFactory = new DefaultOkHttpClientBuilderFactory();
        OkHttpClient client = okHttpClientBuilderFactory.create(apiKey, token, loggingLevel).build();

        DefaultRetrofitBuilderFactory retrofitBuilderFactory = new DefaultRetrofitBuilderFactory(client);
        _retrofit = retrofitBuilderFactory.create().build();
    }

    /**
     * A simple constructor where all initialization is left up to the developer. Requires use of {@link DefaultOkHttpClientBuilderFactory}
     * and {@link DefaultRetrofitBuilderFactory} in order to assure that the {@link Retrofit} instance is set up with
     * the necessary minimal setup.
     *
     * @param retrofit an initialized instance
     */
    public CCApi2(Retrofit retrofit) {
        _retrofit = retrofit;
    }

    /**
     * Gets the rest adapter.
     *
     * @return the rest adapter
     */
    public Retrofit getRestAdapter() {
        return _retrofit;
    }

    /**
     * Gets the account service.
     *
     * @return the account service
     */
    public AccountService getAccountService() {
        if (_accountService == null) {
            synchronized (CCApi2.class) {
                if (_accountService == null) {
                    _accountService = _retrofit.create(AccountService.class);
                }
            }
        }

        return _accountService;
    }

    /**
     * Gets the campaign service.
     *
     * @return the campaign service
     */
    public CampaignService getCampaignService() {
        if (_campaignService == null) {
            synchronized (CCApi2.class) {
                if (_campaignService == null) {
                    _campaignService = _retrofit.create(CampaignService.class);
                }
            }
        }

        return _campaignService;
    }

    /**
     * Gets the contact service.
     *
     * @return the contact service
     */
    public ContactService getContactService() {
        if (_contactService == null) {
            synchronized (CCApi2.class) {
                if (_contactService == null) {
                    _contactService = _retrofit.create(ContactService.class);
                }
            }
        }

        return _contactService;
    }

    /**
     * Gets the library service.
     *
     * @return the library service
     */
    public LibraryService getLibraryService() {
        if (_libraryService == null) {
            synchronized (CCApi2.class) {
                if (_libraryService == null) {
                    _libraryService = _retrofit.create(LibraryService.class);
                }
            }
        }

        return _libraryService;
    }

    /**
     * Gets the campaign tracking service.
     *
     * @return the campaign tracking service
     */
    public CampaignTrackingService getCampaignTrackingService() {
        if (_campaignTrackingService == null) {
            synchronized (CCApi2.class) {
                if (_campaignTrackingService == null) {
                    _campaignTrackingService = _retrofit.create(CampaignTrackingService.class);
                }
            }
        }

        return _campaignTrackingService;
    }

    /**
     * Gets the contact tracking service.
     *
     * @return the contact tracking service
     */
    public ContactTrackingService getContactTrackingService() {
        if (_contactTrackingService == null) {
            synchronized (CCApi2.class) {
                if (_contactTrackingService == null) {
                    _contactTrackingService = _retrofit.create(ContactTrackingService.class);
                }
            }
        }

        return _contactTrackingService;
    }

    /**
     * Gets the bulk activities service.
     *
     * @return the bulk activities service
     */
    public BulkActivitiesService getBulkActivitiesService() {
        if (_bulkActivitiesService == null) {
            synchronized (CCApi2.class) {
                if (_bulkActivitiesService == null) {
                    _bulkActivitiesService = _retrofit.create(BulkActivitiesService.class);
                }
            }
        }

        return _bulkActivitiesService;
    }
}
