package com.constantcontact;

import com.constantcontact.ConstantContact;
import com.constantcontact.components.emailcampaigns.EmailCampaignRequest;
import com.constantcontact.components.emailcampaigns.EmailCampaignResponse;
import com.constantcontact.components.emailcampaigns.schedules.EmailCampaignSchedule;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.mockup.EmailCampaignScheduleServiceMock;
import com.constantcontact.mockup.EmailCampaignServiceMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 * Constant Contact email campaigns and  schedules unit test class.<br/>
 *
 * @author ConstantContact
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactEmailCampaignTest {

    ConstantContact constantContact;

    @Before
    public void beforeTests(){
        constantContact = Mockito.spy(new ConstantContact("", ""));
        constantContact.setEmailCampaignService(new EmailCampaignServiceMock());
        constantContact.setEmailCampaignScheduleService(new EmailCampaignScheduleServiceMock());
    }

    /**
     * Tests the addEmailCampaign method from ConstantContact.class
     */
    @Test
    public void addEmailCampaignTest() {

        EmailCampaignRequest emailCampaignRequest = mock(EmailCampaignRequest.class);

        try {

            EmailCampaignResponse emailCampaignResponse = new EmailCampaignResponse();

            emailCampaignResponse = constantContact.addEmailCampaign(emailCampaignRequest);
            verify(constantContact).addEmailCampaign(emailCampaignRequest);

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

            emailCampaignResponse = constantContact.addEmailCampaign(emailCampaignRequest);
            verify(constantContact).addEmailCampaign(emailCampaignRequest);

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

            emailCampaignResponses = constantContact.getEmailCampaigns();
            verify(constantContact).getEmailCampaigns();

            assertNotNull(emailCampaignResponses);

            emailCampaignResponses = constantContact.getEmailCampaigns(1, null);
            verify(constantContact).getEmailCampaigns(1, null);

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
            EmailCampaignRequest emailCampaignRequest = constantContact.getEmailCampaign("1").toEmailCampaignRequest();

            EmailCampaignResponse emailCampaignResponse = new EmailCampaignResponse();

            emailCampaignResponse = constantContact.updateEmailCampaign(emailCampaignRequest);
            verify(constantContact).updateEmailCampaign(emailCampaignRequest);

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

            emailCampaignResponse = constantContact.updateEmailCampaign(emailCampaignRequest);
            verify(constantContact).updateEmailCampaign(emailCampaignRequest);

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

            emailCampaignResponse = constantContact.getEmailCampaign(emailCampaignId);
            verify(constantContact).getEmailCampaign(emailCampaignId);

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

            emailCampaignResponse = constantContact.getEmailCampaign(emailCampaignId);
            verify(constantContact).getEmailCampaign(emailCampaignId);

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

            boolean deleted = constantContact.deleteEmailCampaign(campaignId);
            verify(constantContact).deleteEmailCampaign(campaignId);

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
            emailCampaignSchedules = constantContact.getEmailCampaignSchedules(campaignId);
            verify(constantContact).getEmailCampaignSchedules(campaignId);

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
            emailCampaignSchedules = constantContact.getEmailCampaignSchedules(campaignId);
            verify(constantContact).getEmailCampaignSchedules(campaignId);

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

            resultEmailCampaignSchedule = constantContact.addEmailCampaignSchedule(campaignId, emailCampaignSchedule);
            verify(constantContact).addEmailCampaignSchedule(campaignId, emailCampaignSchedule);

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

            resultEmailCampaignSchedule = constantContact.addEmailCampaignSchedule(campaignId, emailCampaignSchedule);
            verify(constantContact).addEmailCampaignSchedule(campaignId, emailCampaignSchedule);

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

            boolean deleted = constantContact.deleteEmailCampaignSchedule(campaignId, scheduleId);
            verify(constantContact).deleteEmailCampaignSchedule(campaignId, scheduleId);

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

            boolean deleted = constantContact.deleteEmailCampaignSchedule(campaignId, scheduleId);
            verify(constantContact).deleteEmailCampaignSchedule(campaignId, scheduleId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }
}
