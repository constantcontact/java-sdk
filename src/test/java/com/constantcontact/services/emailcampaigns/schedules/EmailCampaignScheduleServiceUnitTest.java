package com.constantcontact.services.emailcampaigns.schedules;

import java.net.HttpURLConnection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.emailcampaigns.schedule.EmailCampaignScheduleService;
import com.constantcontact.util.RawApiResponse;
import com.constantcontact.util.RestClient;
import com.constantcontact.util.http.constants.ProcessorBase.HttpMethod;

/**
 * 
 * @author csciuto
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class EmailCampaignScheduleServiceUnitTest {

    EmailCampaignScheduleService svc;
    
    @Before
    public void setup() {
        svc = new EmailCampaignScheduleService("","");
    }

    @Test
    public void testDelete() throws ConstantContactServiceException {
        
        RestClient rc = new RestClient("",""){
            @Override
            protected RawApiResponse makeHttpRequest(String urlParam, HttpMethod method, String accessToken, String data) {
                
                RawApiResponse response = new RawApiResponse();
                
                if (method == HttpMethod.DELETE) {
                    response.setStatusCode(HttpURLConnection.HTTP_NO_CONTENT);
                }
                
                return response;
            }
                
        };
        svc.setRestClient(rc);
     
        Assert.assertTrue(svc.deleteSchedule("12345", "67890"));
        
    }
    
    @Test (expected=ConstantContactServiceException.class)
    public void testDeleteFail() throws ConstantContactServiceException {
        RestClient rc2 = new RestClient("",""){
            @Override
            protected RawApiResponse makeHttpRequest(String urlParam, HttpMethod method, String accessToken, String data) {
                
                RawApiResponse response = new RawApiResponse();
                
                if (method == HttpMethod.DELETE) {
                    response.setStatusCode(HttpURLConnection.HTTP_INTERNAL_ERROR);
                    response.setError(true);
                }
                
                return response;
            }
                
        };
        svc.setRestClient(rc2);
     
        svc.deleteSchedule("12345", "67890");
    }
    
    
}
