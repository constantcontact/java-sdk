package com.constantcontact.services.emailcampaigns.schedules;

import java.net.HttpURLConnection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.emailcampaigns.schedule.EmailCampaignScheduleService;
import com.constantcontact.util.CUrlResponse;
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
        svc = new EmailCampaignScheduleService();
    }

    @Test
    public void testDelete() throws ConstantContactServiceException {
        
        RestClient rc = new RestClient(){
            @Override
            protected CUrlResponse makeHttpRequest(String urlParam, HttpMethod method, String accessToken, String data) {
                
                CUrlResponse response = new CUrlResponse();
                
                if (method == HttpMethod.DELETE) {
                    response.setStatusCode(HttpURLConnection.HTTP_NO_CONTENT);
                }
                
                return response;
            }
                
        };
        svc.setRestClient(rc);
     
        Assert.assertTrue(svc.deleteSchedule("foo", "12345", "67890"));
        
        RestClient rc2 = new RestClient(){
            @Override
            protected CUrlResponse makeHttpRequest(String urlParam, HttpMethod method, String accessToken, String data) {
                
                CUrlResponse response = new CUrlResponse();
                
                if (method == HttpMethod.DELETE) {
                    response.setStatusCode(HttpURLConnection.HTTP_INTERNAL_ERROR);
                }
                
                return response;
            }
                
        };
        svc.setRestClient(rc2);
     
        Assert.assertFalse(svc.deleteSchedule("foo", "12345", "67890"));
        
    }
    
    
}
