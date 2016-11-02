package com.constantcontact.v2;

import com.constantcontact.v2.contacts.*;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Retrofit interface for Contacts and Contact List calls against the Constant Contact API.
 * <p>
 * See <a href="http://developer.constantcontact.com/docs/contacts-api/contacts-index.html">Working With Contacts</a>
 * on the Constant Contact Developer Website
 *
 * @author woogienoogie
 */
public interface ContactService {
    /**
     * Get a {@link Paged} collection of {@link Contact}
     *
     * @param limit  Size of page to return (1-500)
     * @param status Retrieve contacts with only the chosen {@link ContactStatus}
     * @return       an Observable that emits Paged Contacts
     */
    @GET("v2/contacts")
    Call<Paged<Contact>> getContacts(@Query("limit") int limit, @Query("status") ContactStatus status);

    /**
     * Get a {@link Paged} collection of {@link Contact}
     *
     * @param limit  Size of page to return (1-500)
     * @param date   Date to specify retrieval of contacts that have been modified since then, in ISO-8601 format
     * @param status Retrieve contacts with only the chosen {@link ContactStatus}
     * @return       an Observable that emits Paged Contacts
     */
    @GET("v2/contacts")
    Call<Paged<Contact>> getContacts(@Query("limit") int limit, @Query("modified_since") String date, @Query("status") ContactStatus status);

    /**
     * Get a {@link Paged} collection of {@link Contact} from a specific {@link ContactList}
     *
     * @param listId ID of the ContactList to get Contacts from
     * @param limit  Size of page to return (1-500)
     * @param date   Date to specify retrieval of contacts that have been modified since then, in ISO-8601 format
     * @return       an Observable that emits Paged Contacts
     */
    @GET("v2/lists/{listId}/contacts")
    Call<Paged<Contact>> getContacts(@Path("listId") String listId, @Query("limit") int limit, @Query("modified_since") String date);

    /**
     * Get a {@link Paged} collection of {@link Contact} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged Contacts
     * @see            Paged
     */
    @GET("v2/contacts?next={next}")
    Call<Paged<Contact>> getContacts(@Path("next") String nextLink);

    /**
     * Create an individual {@link Contact}
     *
     * @param contact     Contact
     * @param optInSource Specify who is creating this contact with {@link OptInSource}
     * @return            an Observable that emits a new Contact object, with changes by the server, such as adding an ID
     */
    @POST("v2/contacts")
    Call<Contact> createContact(@Body Contact contact, @Query("action_by") OptInSource optInSource);

    /**
     * Get an individual {@link Contact}
     *
     * @param contactId Contact's ID
     * @return          an Observable that emits a Contact
     */
    @GET("v2/contacts/{contactId}")
    Call<Contact> getContact(@Path("contactId") String contactId);

    /**
     * Update an individual {@link Contact}
     *
     * @param contact     Contact object with updated information
     * @param contactId   Contact's ID
     * @param optInSource Specify who is updating this contact with {@link OptInSource}
     * @return            an Observable that emits an updated Contact
     */
    @PUT("v2/contacts/{contactId")
    Call<Contact> updateContact(@Body Contact contact, @Path("contactId") String contactId, @Query("action_by") OptInSource optInSource);

    /**
     * Opt out an individual {@link Contact}
     *
     * @param contactId Contact's ID
     * @return          an Observable that emits a {@link retrofit2.Response}
     */
    @DELETE("v2/contacts/{contactId}")
    Call<Response> unsubscribeContact(@Path("contactId") String contactId);

    /**
     * Get all {@link ContactList} in the account
     *
     * @param date Date to specify retrieval of contact lists that have been modified since then, in ISO-8601 format
     * @return     an Observable that emits a List of ContactLists
     */
    @GET("v2/lists")
    Call<List<ContactList>> getContactLists(@Query("modified_since") String date);

    /**
     * Create a new {@link ContactList}
     *
     * @param contactList ContactList object (requires only name and status to create)
     * @return            an Observable that emits a new ContactList object, with changes by the server, such as adding an ID
     */
    @POST("v2/lists")
    Call<ContactList> createContactList(@Body ContactList contactList);

    /**
     * Get a specific {@link ContactList}
     *
     * @param listId ID of the list
     * @return       an Observable that emits a ContactList
     */
    @GET("v2/lists/{listId}")
    Call<ContactList> getContactList(@Path("listId") String listId);

    /**
     * Update a {@link ContactList}
     *
     * @param contactList ContactList
     * @param listId      ID of the list
     * @return            an Observable that emits an updated ContactList
     */
    @PUT("v2/lists/{listId}")
    Call<ContactList> updateContactList(@Body ContactList contactList, @Path("listId") String listId);

    /**
     * Delete a {@link ContactList}
     *
     * @param listId ID of the list
     * @return       an Observable that emits a {@link retrofit2.Response}
     */
    @DELETE("v2/lists/{listId}")
    Call<Response> deleteContactList(@Path("listId") String listId);

    /**
     * Create a custom signup form
     *
     * @param signupFormRequest object that contains params for the signup form
     * @return                  an Observable that emits a signup form response
     * @see                     <a href="http://developer.constantcontact.com/docs/signup-forms-tools/signup-form-creation.html">Signup Form Creation</a>
     */
    @POST("v2/signupform")
    Call<SignupFormResponse> createCustomSignupForm(@Body SignupFormRequest signupFormRequest);
}
