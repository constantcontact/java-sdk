package com.constantcontact.services;

import java.util.List;

import com.constantcontact.components.campaigns.Campaign;

/**
 * Interface for CampaignService class.
 * 
 * @author ConstantContact
 *
 */
public interface ICampaignService {
	/**
	 * Get a set of campaigns.
	 * @param accessToken Access token.
	 * @param offset Denotes the starting number for the result set.
	 * @param limit Denotes the number of results per set of result, limited to 50
	 * @return Returns a list of campaigns.
	 */
	List<Campaign> getCampaigns(String accessToken, Integer offset, Integer limit);
	
	/**
	 * Get campaign details for a specific campaign.
	 * @param accessToken Access token.
	 * @param campaignId Campaign id.
	 * @return Returns a campaign.
	 */
	Campaign getCampaign(String accessToken, String campaignId);
}
