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

public class ConstantContactFactory {

	private String accessToken;
	private String apiKey;

	public ConstantContactFactory(String accessToken, String apiKey) {
		this.accessToken = accessToken;
		this.apiKey = apiKey;
	}

	public IContactService createContactService() {
		return new ContactService(accessToken, apiKey);
	}

	public IContactListService createContactListService() {
		return new ContactListService(accessToken, apiKey);
	}

	public IEmailCampaignService createEmailCampaignService() {
		return new EmailCampaignService(accessToken, apiKey);
	}

	public IAccountService createAccountService() {
		return new AccountService(accessToken, apiKey);
	}

	public IEmailCampaignScheduleService createEmailCampaignScheduleService() {
		return new EmailCampaignScheduleService(accessToken, apiKey);
	}

	public IEmailCampaignTrackingService createEmailCampaignTrackingService() {
		return new EmailCampaignTrackingService(accessToken, apiKey);
	}

	public IContactTrackingService createContactTrackingService() {
		return new ContactTrackingService(accessToken, apiKey);
	}

	public IBulkActivitiesService createBulkActivitiesService() {
		return new BulkActivitiesService(accessToken, apiKey);
	}

	public IMyLibraryService createMyLibraryService() {
		return new MyLibraryService(accessToken, apiKey);
	}

	public IEventSpotService createEventSpotService() {
		return new EventSpotService(accessToken, apiKey);
	}

	public PaginationHelperService createPaginationHelperService() {
		return new PaginationHelperService(accessToken, apiKey);
	}
}
