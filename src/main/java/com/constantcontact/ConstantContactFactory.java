package com.constantcontact;

import com.constantcontact.pagination.PaginationHelperService;
import com.constantcontact.services.accounts.AccountService;
import com.constantcontact.services.accounts.IAccountService;
import com.constantcontact.services.activities.BulkActivitiesService;
import com.constantcontact.services.activities.IBulkActivitiesService;
import com.constantcontact.services.contactlists.ContactListService;
import com.constantcontact.services.contactlists.IContactListService;
import com.constantcontact.services.contacts.ContactService;
import com.constantcontact.services.contacts.IContactService;
import com.constantcontact.services.contacts.tracking.ContactTrackingService;
import com.constantcontact.services.contacts.tracking.IContactTrackingService;
import com.constantcontact.services.emailcampaigns.EmailCampaignService;
import com.constantcontact.services.emailcampaigns.IEmailCampaignService;
import com.constantcontact.services.emailcampaigns.schedule.EmailCampaignScheduleService;
import com.constantcontact.services.emailcampaigns.schedule.IEmailCampaignScheduleService;
import com.constantcontact.services.emailcampaigns.tracking.EmailCampaignTrackingService;
import com.constantcontact.services.emailcampaigns.tracking.IEmailCampaignTrackingService;
import com.constantcontact.services.eventspot.EventSpotService;
import com.constantcontact.services.eventspot.IEventSpotService;
import com.constantcontact.services.library.IMyLibraryService;
import com.constantcontact.services.library.MyLibraryService;

/**
 * Factory class that provides Constant Contact specific service instances.
 */

public class ConstantContactFactory {
    
    /**
     * The access token provided by Constant Contact Authentication workflow.
     */
    private String accessToken;
    
    /**
     * The API key provided by Constant Contact.
     */
    private String apiKey;
    
    /**
     * Custom Class constructor.<br/>
     *
     * @param accessToken The access token provided by Constant Contact Authentication workflow.
     * @param apiKey The API key provided by Constant Contact.
     */
    
    public ConstantContactFactory(String accessToken, String apiKey) {
        this.accessToken = accessToken;
        this.apiKey = apiKey;
    }
    
    /**
     * Creates a new {@link ContactService}
     *
     * @return A {@link ContactService} instance.
     */
    
    public IContactService createContactService() {
        return new ContactService(accessToken, apiKey);
    }
    
    /**
     * Creates a new {@link ContactListService}
     *
     * @return A {@link ContactListService} instance.
     */
    
    public IContactListService createContactListService() {
        return new ContactListService(accessToken, apiKey);
    }
    
    /**
     * Creates a new {@link EmailCampaignService}
     *
     * @return A {@link EmailCampaignService} instance.
     */
    
    public IEmailCampaignService createEmailCampaignService() {
        return new EmailCampaignService(accessToken, apiKey);
    }
    
    /**
     * Creates a new {@link AccountService}
     *
     * @return A {@link AccountService} instance.
     */
    
    public IAccountService createAccountService() {
        return new AccountService(accessToken, apiKey);
    }
    
    /**
     * Creates a new {@link EmailCampaignScheduleService}
     *
     * @return A {@link EmailCampaignScheduleService} instance.
     */
    
    public IEmailCampaignScheduleService createEmailCampaignScheduleService() {
        return new EmailCampaignScheduleService(accessToken, apiKey);
    }
    
    /**
     * Creates a new {@link EmailCampaignTrackingService}
     *
     * @return A {@link EmailCampaignTrackingService} instance.
     */
    
    public IEmailCampaignTrackingService createEmailCampaignTrackingService() {
        return new EmailCampaignTrackingService(accessToken, apiKey);
    }
    
    /**
     * Creates a new {@link ContactTrackingService}
     *
     * @return A {@link ContactTrackingService} instance.
     */
    
    public IContactTrackingService createContactTrackingService() {
        return new ContactTrackingService(accessToken, apiKey);
    }
    
    /**
     * Creates a new {@link BulkActivitiesService}
     *
     * @return A {@link BulkActivitiesService} instance.
     */
    
    public IBulkActivitiesService createBulkActivitiesService() {
        return new BulkActivitiesService(accessToken, apiKey);
    }
    
    /**
     * Creates a new {@link MyLibraryService}
     *
     * @return A {@link MyLibraryService} instance.
     */
    
    public IMyLibraryService createMyLibraryService() {
        return new MyLibraryService(accessToken, apiKey);
    }
    
    /**
     * Creates a new {@link EventSpotService}
     *
     * @return A {@link EventSpotService} instance.
     */
    
    public IEventSpotService createEventSpotService() {
        return new EventSpotService(accessToken, apiKey);
    }
    
    /**
     * Creates a new {@link PaginationHelperService}
     *
     * @return A {@link PaginationHelperService} instance.
     */
    
    public PaginationHelperService createPaginationHelperService() {
        return new PaginationHelperService(accessToken, apiKey);
    }
}
