package com.constantcontact.mockup;

import org.mockito.Mockito;

import com.constantcontact.components.emailcampaigns.test.EmailCampaignTest;
import com.constantcontact.pagination.PaginationHelperService;
import com.constantcontact.services.accounts.IAccountService;
import com.constantcontact.services.activities.IBulkActivitiesService;
import com.constantcontact.services.contactlists.IContactListService;
import com.constantcontact.services.contacts.IContactService;
import com.constantcontact.services.contacts.tracking.IContactTrackingService;
import com.constantcontact.services.emailcampaigns.IEmailCampaignService;
import com.constantcontact.services.emailcampaigns.schedule.IEmailCampaignScheduleService;
import com.constantcontact.services.emailcampaigns.test.EmailCampaignTestService;
import com.constantcontact.services.emailcampaigns.test.IEmailCampaignTestService;
import com.constantcontact.services.emailcampaigns.tracking.IEmailCampaignTrackingService;
import com.constantcontact.services.eventspot.IEventSpotService;
import com.constantcontact.services.library.IMyLibraryService;

public class ConstantContactFactoryMock {

    private String accessToken;
    private String apiKey;

    public ConstantContactFactoryMock(String accessToken, String apiKey) {
        this.accessToken = accessToken;
        this.apiKey = apiKey;
    }

    public IContactService createContactService() {
        return Mockito.spy(new ContactServiceMock(accessToken, apiKey));
    }

    public IContactListService createContactListService() {
        return Mockito.spy(new ContactListServiceMock(accessToken, apiKey));
    }

    public IEmailCampaignService createEmailCampaignService() {
        return Mockito.spy(new EmailCampaignServiceMock(accessToken, apiKey));
    }

    public IAccountService createAccountService() {
        return Mockito.spy(new AccountServiceMock(accessToken, apiKey));
    }

    public IEmailCampaignScheduleService createEmailCampaignScheduleService() {
        return Mockito.spy(new EmailCampaignScheduleServiceMock(accessToken, apiKey));
    }

    public IEmailCampaignTrackingService createEmailCampaignTrackingService() {
        return Mockito.spy(new EmailCampaignTrackingServiceMock(accessToken, apiKey));
    }

    public IEmailCampaignTestService createEmailCampaignTestService() {
        return Mockito.spy(new EmailCampaignTestServiceMock(accessToken, apiKey));
    }

    public IContactTrackingService createContactTrackingService() {
        return Mockito.spy(new ContactTrackingServiceMock(accessToken, apiKey));
    }

    public IBulkActivitiesService createBulkActivitiesService() {
        return Mockito.spy(new BulkActivitiesServiceMock(accessToken, apiKey));
    }

    public IMyLibraryService createMyLibraryService() {
        return Mockito.spy(new MyLibraryServiceMock(accessToken, apiKey));
    }

    public IEventSpotService createEventSpotService() {
        return Mockito.spy(new EventSpotServiceMock(accessToken, apiKey));
    }

    public PaginationHelperService createPaginationHelperService() {
        return Mockito.spy(new PaginationHelperService(accessToken, apiKey));
    }
}
