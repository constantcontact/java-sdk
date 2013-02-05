package com.constantcontact.services;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import com.constantcontact.components.Component;
import com.constantcontact.components.campaigns.Campaign;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;

/**
 * Performs all actions pertaining to the Contacts Collection.
 * 
 * @author ConstantContact
 */
public class CampaignService extends BaseService implements ICampaignService {
	/**
	 * Get a set of campaigns.
	 * @param accessToken Access token.
	 * @param offset Denotes the starting number for the result set.
	 * @param limit Denotes the number of results per set of results, limited to 50.
	 * @return Returns a list of campaigns.
	 */
	@Override
	public List<Campaign> getCampaigns(String accessToken, Integer offset, Integer limit) {
		List<Campaign> campaigns = new ArrayList<Campaign>();
        String url = paginateUrl(Config.Endpoints.BASE_URL + Config.Endpoints.CAMPAIGNS, offset, limit);
        CUrlResponse response = getRestClient().get(url, accessToken);
        if (response.hasData()) {
            campaigns = Component.listFromJSON(response.getBody(), Campaign.class);
        }
        
        return campaigns;
	}

	/**
	 * Get campaign details for a specific campaign.
	 * @param accessToken Access token.
	 * @param campaignId Campaign id.
	 * @return Returns a campaign.
	 */
	@Override
	public Campaign getCampaign(String accessToken, String campaignId) {
		Campaign campaign = null;
		Formatter formatter = new Formatter();
        String url = Config.Endpoints.BASE_URL +  formatter.format(Config.Endpoints.CAMPAIGN_ID, campaignId);
        CUrlResponse response = getRestClient().get(url, accessToken);
        if (response.hasData()) {
            campaign = Component.fromJSON(response.getBody(), Campaign.class);
        }
        return campaign;
	}

}
