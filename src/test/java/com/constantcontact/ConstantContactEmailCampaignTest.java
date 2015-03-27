package com.constantcontact;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.constantcontact.components.emailcampaigns.EmailCampaignRequest;
import com.constantcontact.components.emailcampaigns.EmailCampaignResponse;
import com.constantcontact.components.emailcampaigns.schedules.EmailCampaignSchedule;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.mockup.ConstantContactFactoryMock;
import com.constantcontact.services.emailcampaigns.IEmailCampaignService;
import com.constantcontact.services.emailcampaigns.schedule.IEmailCampaignScheduleService;


/**
 * Constant Contact email campaigns and  schedules unit test class.<br/>
 *
 * @author ConstantContact
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactEmailCampaignTest {
    
    private ConstantContactFactoryMock constantContactFactory;
    private IEmailCampaignService emailCampaignService;
    private IEmailCampaignScheduleService emailCampaignScheduleService;

    @Before
    public void beforeTests(){
    	constantContactFactory = Mockito.spy(new ConstantContactFactoryMock("",""));
    	emailCampaignService = constantContactFactory.createEmailCampaignService();
    	emailCampaignScheduleService = constantContactFactory.createEmailCampaignScheduleService();
    }

    /**
     * Tests the addEmailCampaign method from ConstantContact.class
     */
    @Test
    public void addEmailCampaignTest() {

        EmailCampaignRequest emailCampaignRequest = mock(EmailCampaignRequest.class);

        try {

            EmailCampaignResponse emailCampaignResponse = new EmailCampaignResponse();

            emailCampaignResponse = emailCampaignService.addCampaign(emailCampaignRequest);
            verify(emailCampaignService).addCampaign(emailCampaignRequest);

            assertNotNull(emailCampaignResponse);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the addEmailCampaign method throws the proper exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void addEmailCampaignExceptionTest() {

        EmailCampaignRequest emailCampaignRequest = null;

        try {

            EmailCampaignResponse emailCampaignResponse = new EmailCampaignResponse();

            emailCampaignResponse = emailCampaignService.addCampaign(emailCampaignRequest);
            verify(emailCampaignService).addCampaign(emailCampaignRequest);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the retrieved email campaigns
     */
    @Test
    public void getEmailCampaignsTest() {
        int limit = 1;

        try {
            ResultSet emailCampaignResponses = mock(ResultSet.class);

            emailCampaignResponses = emailCampaignService.getCampaigns(null, null);
            verify(emailCampaignService).getCampaigns(null, null);

            assertNotNull(emailCampaignResponses);

            emailCampaignResponses = emailCampaignService.getCampaigns(1, null);
            verify(emailCampaignService).getCampaigns(1, null);
            
            assertNotNull(emailCampaignResponses);

            emailCampaignResponses = emailCampaignService.getCampaigns(null, "1");
            verify(emailCampaignService).getCampaigns(null, "1");

            assertNotNull(emailCampaignResponses);


        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
    }

    /**
     * Tests the update method for email campaigns
     *
     */
    @Test
    public void updateEmailCampaignTest() {

        try {
            EmailCampaignRequest emailCampaignRequest = emailCampaignService.getCampaign("1").toEmailCampaignRequest();

            EmailCampaignResponse emailCampaignResponse = new EmailCampaignResponse();

            emailCampaignResponse = emailCampaignService.updateCampaign(emailCampaignRequest);
            verify(emailCampaignService).updateCampaign(emailCampaignRequest);

            assertNotNull(emailCampaignResponse);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests that the updateEmailCampaign method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void updateEmailCampaignExceptionTest() {

        try {
            EmailCampaignRequest emailCampaignRequest = null;

            EmailCampaignResponse emailCampaignResponse = new EmailCampaignResponse();

            emailCampaignResponse = emailCampaignService.updateCampaign(emailCampaignRequest);
            verify(emailCampaignService).updateCampaign(emailCampaignRequest);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the getEmailCampaign method
     *
     */
    @Test
    public void getEmailCampaignTest() {
        String emailCampaignId = "1";

        try {

            EmailCampaignResponse emailCampaignResponse = new EmailCampaignResponse();

            emailCampaignResponse = emailCampaignService.getCampaign(emailCampaignId);
            verify(emailCampaignService).getCampaign(emailCampaignId);

            assertNotNull(emailCampaignResponse);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests that the getEmailCampaign method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEmailCampaignExceptionTest() {
        String emailCampaignId = null;

        try {

            EmailCampaignResponse emailCampaignResponse = new EmailCampaignResponse();

            emailCampaignResponse = emailCampaignService.getCampaign(emailCampaignId);
            verify(emailCampaignService).getCampaign(emailCampaignId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the email campaign delete functionality
     *
     */
    @Test
    public void deleteEmailCampaignTest() {
        String campaignId = "1";
        try {

            boolean deleted = emailCampaignService.deleteCampaign(campaignId);
            verify(emailCampaignService).deleteCampaign(campaignId);

            assertTrue(deleted);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the getEmailCampaignSchedules method
     *
     */
    @Test
    public void getEmailCampaignSchedulesTest() {
        String campaignId = "1";
        try {

            List<EmailCampaignSchedule> emailCampaignSchedules = new ArrayList<EmailCampaignSchedule>();
            emailCampaignSchedules = emailCampaignScheduleService.getSchedules(campaignId);
            verify(emailCampaignScheduleService).getSchedules(campaignId);

            assertNotNull(emailCampaignSchedules);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }

    /**
     * Tests that the getEmailCampaignSchedules method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEmailCampaignSchedulesExceptionTest() {
        String campaignId = null;
        try {

            List<EmailCampaignSchedule> emailCampaignSchedules = new ArrayList<EmailCampaignSchedule>();
            emailCampaignSchedules = emailCampaignScheduleService.getSchedules(campaignId);
            verify(emailCampaignScheduleService).getSchedules(campaignId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }


    /**
     * Tests the addEmailCampaignSchedule method
     *
     */
    @Test
    public void addEmailCampaignScheduleTest() {
        String campaignId = "1";
        EmailCampaignSchedule emailCampaignSchedule = mock(EmailCampaignSchedule.class);
        try {

            EmailCampaignSchedule resultEmailCampaignSchedule = new EmailCampaignSchedule();

            resultEmailCampaignSchedule = emailCampaignScheduleService.addSchedule(campaignId, emailCampaignSchedule);
            verify(emailCampaignScheduleService).addSchedule(campaignId, emailCampaignSchedule);

            assertNotNull(emailCampaignSchedule);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }

    /**
     * Tests that the addEmailCampaignSchedule method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void addEmailCampaignScheduleExceptionTest() {
        String campaignId = null;
        EmailCampaignSchedule emailCampaignSchedule = null;
        try {

            EmailCampaignSchedule resultEmailCampaignSchedule = new EmailCampaignSchedule();

            resultEmailCampaignSchedule = emailCampaignScheduleService.addSchedule(campaignId, emailCampaignSchedule);
            verify(emailCampaignScheduleService).addSchedule(campaignId, emailCampaignSchedule);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }

    /**
     * Tests the deleteEmailCampaignSchedule method
     *
     */
    @Test
    public void deleteEmailCampaignScheduleTest() {
        String campaignId = "1";
        String scheduleId = "1";
        try {

            boolean deleted = emailCampaignScheduleService.deleteSchedule(campaignId, scheduleId);
            verify(emailCampaignScheduleService).deleteSchedule(campaignId, scheduleId);

            assertTrue("The schedule delete encountered an error", deleted);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }

    /**
     * Tests that the deleteEmailCampaignSchedule method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void deleteEmailCampaignScheduleExceptionTest() {
        String campaignId = null;
        String scheduleId = null;
        try {

            boolean deleted = emailCampaignScheduleService.deleteSchedule(campaignId, scheduleId);
            verify(emailCampaignScheduleService).deleteSchedule(campaignId, scheduleId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }
}
