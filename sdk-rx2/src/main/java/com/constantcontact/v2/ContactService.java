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

import com.constantcontact.v2.contacts.*;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.*;

import java.util.List;

/**
 * Retrofit interface for Contacts and Contact List calls against the Constant Contact API.
 * <p>
 * See <a href="http://developer.constantcontact.com/docs/contacts-api/contacts-index.html">Working With Contacts</a>
 * on the Constant Contact Developer Website
 */
public interface ContactService {
    /**
     * The maximum page size for tracking queries.
     */
    int MAX_PAGE_LIMIT = 500;

    /**
     * The default page size for tracking queries.
     */
    int DEFAULT_PAGE_LIMIT = 50;

    /**
     * Get a {@link Paged} collection of {@link Contact}
     *
     * @param email Email to search for
     * @return an Observable that emits Paged Contacts
     */
    @GET("v2/contacts")
    Observable<Paged<Contact>> getContactsByEmail(@Query("email") String email);

    /**
     * Get a {@link Paged} collection of {@link Contact}
     *
     * @param limit  Size of page to return (1-500)
     * @param status Retrieve contacts with only the chosen {@link ContactStatus}
     * @return an Observable that emits Paged Contacts
     */
    @GET("v2/contacts")
    Observable<Paged<Contact>> getContacts(@Query("limit") int limit, @Query("status") ContactStatus status);

    /**
     * Get a {@link Paged} collection of {@link Contact}
     *
     * @param limit  Size of page to return (1-500)
     * @param date   Date to specify retrieval of contacts that have been modified since then, in ISO-8601 format
     * @param status Retrieve contacts with only the chosen {@link ContactStatus}
     * @return an Observable that emits Paged Contacts
     */
    @GET("v2/contacts")
    Observable<Paged<Contact>> getContacts(@Query("limit") int limit, @Query("modified_since") QueryDate date,
                                           @Query("status") ContactStatus status);

    /**
     * Get a {@link Paged} collection of {@link Contact} from a specific {@link ContactList}
     *
     * @param listId ID of the ContactList to get Contacts from
     * @param limit  Size of page to return (1-500)
     * @param date   Date to specify retrieval of contacts that have been modified since then, in ISO-8601 format
     * @return an Observable that emits Paged Contacts
     */
    @GET("v2/lists/{listId}/contacts")
    Observable<Paged<Contact>> getContacts(@Path("listId") String listId, @Query("limit") int limit, @Query("modified_since") QueryDate date);

    /**
     * Get a {@link Paged} collection of {@link Contact} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return an Observable that emits Paged Contacts
     * @see Paged
     */
    @GET
    Observable<Paged<Contact>> getContacts(@Url String nextLink);

    /**
     * Create an individual {@link Contact}
     *
     * @param contact     Contact
     * @param optInSource Specify who is creating this contact with {@link OptInSource}
     * @return an Observable that emits a new Contact object, with changes by the server, such as adding an ID
     */
    @POST("v2/contacts")
    Observable<Contact> createContact(@Body Contact contact, @Query("action_by") OptInSource optInSource);

    /**
     * Get an individual {@link Contact}
     *
     * @param contactId Contact's ID
     * @return an Observable that emits a Contact
     */
    @GET("v2/contacts/{contactId}")
    Observable<Contact> getContact(@Path("contactId") String contactId);

    /**
     * Update an individual {@link Contact}
     *
     * @param contact     Contact object with updated information
     * @param contactId   Contact's ID
     * @param optInSource Specify who is updating this contact with {@link OptInSource}
     * @return an Observable that emits an updated Contact
     */
    @PUT("v2/contacts/{contactId}")
    Observable<Contact> updateContact(@Body Contact contact, @Path("contactId") String contactId,
                                      @Query("action_by") OptInSource optInSource);

    /**
     * Opt out an individual {@link Contact}
     *
     * @param contactId Contact's ID
     * @return an Observable that emits a {@link retrofit2.Response}
     */
    @DELETE("v2/contacts/{contactId}")
    Observable<Response<Void>> unsubscribeContact(@Path("contactId") String contactId);

    /**
     * Get all {@link ContactList} in the account
     *
     * @param modifiedSince optional date to specify latest modified lists, or null for all lists
     * @return an Observable that emits a list of contact lists
     */
    @GET("v2/lists")
    Observable<List<ContactList>> getContactLists(@Query("modified_since") QueryDate modifiedSince);

    /**
     * Create a new {@link ContactList}
     *
     * @param contactList ContactList object (requires only name and status to create)
     * @return an Observable that emits a new ContactList object, with changes by the server, such as adding an ID
     */
    @POST("v2/lists")
    Observable<ContactList> createContactList(@Body ContactList contactList);

    /**
     * Get a specific {@link ContactList}
     *
     * @param listId ID of the list
     * @return an Observable that emits a ContactList
     */
    @GET("v2/lists/{listId}")
    Observable<ContactList> getContactList(@Path("listId") String listId);

    /**
     * Update a {@link ContactList}
     *
     * @param contactList ContactList
     * @param listId      ID of the list
     * @return an Observable that emits an updated ContactList
     */
    @PUT("v2/lists/{listId}")
    Observable<ContactList> updateContactList(@Body ContactList contactList, @Path("listId") String listId);

    /**
     * Delete a {@link ContactList}
     *
     * @param listId ID of the list
     * @return an Observable that emits a {@link retrofit2.Response}
     */
    @DELETE("v2/lists/{listId}")
    Observable<Response<Void>> deleteContactList(@Path("listId") String listId);

    /**
     * Create a custom signup form
     *
     * @param signupFormRequest object that contains params for the signup form
     * @return an Observable that emits a signup form response
     * @see <a href="http://developer.constantcontact.com/docs/signup-forms-tools/signup-form-creation.html">Signup Form Creation</a>
     */
    @POST("v2/signupform")
    Observable<SignupFormResponse> createCustomSignupForm(@Body SignupFormRequest signupFormRequest);
}
