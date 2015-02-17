package com.constantcontact;

import com.constantcontact.ConstantContact;
import com.constantcontact.components.emailcampaigns.schedules.EmailCampaignSchedule;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.mockup.EmailCampaignScheduleServiceMock;
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
public class ConstantContactEmailCampaignScheduleTest {

    ConstantContact constantContact;

    @Before
    public void beforeTests(){
        constantContact = Mockito.spy(new ConstantContact("", ""));
        constantContact.setEmailCampaignScheduleService(new EmailCampaignScheduleServiceMock());
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

            EmailCampaignSchedule resultEmailCampaignSchedule = constantContact.addEmailCampaignSchedule(campaignId, emailCampaignSchedule);
            verify(constantContact).addEmailCampaignSchedule(campaignId, emailCampaignSchedule);

            assertNotNull(resultEmailCampaignSchedule);

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

            EmailCampaignSchedule resultEmailCampaignSchedule = constantContact.addEmailCampaignSchedule(campaignId, emailCampaignSchedule);
            verify(constantContact).addEmailCampaignSchedule(campaignId, emailCampaignSchedule);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }

    /**
     * Tests the updateEmailCampaignSchedule method
     *
     */
    @Test
    public void updateEmailCampaignScheduleTest() {
        String campaignId = "1";
        String campaignScheduleId = "1";
        EmailCampaignSchedule emailCampaignSchedule = mock(EmailCampaignSchedule.class);
        try {

            EmailCampaignSchedule resultEmailCampaignSchedule = constantContact.updateEmailCampaignSchedule(campaignId, campaignScheduleId, emailCampaignSchedule);
            verify(constantContact).updateEmailCampaignSchedule(campaignId, campaignScheduleId, emailCampaignSchedule);

            assertNotNull(resultEmailCampaignSchedule);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }

    /**
     * Tests that the updateEmailCampaignSchedule method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void updateEmailCampaignScheduleExceptionTest() {
        String campaignId = null;
        String campaignScheduleId = null;
        EmailCampaignSchedule emailCampaignSchedule = null;
        try {

            EmailCampaignSchedule resultEmailCampaignSchedule = constantContact.updateEmailCampaignSchedule(campaignId, campaignScheduleId, emailCampaignSchedule);
            verify(constantContact).updateEmailCampaignSchedule(campaignId, campaignScheduleId, emailCampaignSchedule);

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

    /**
     * Tests the updateEmailCampaignSchedule method
     *
     */
    @Test
    public void getEmailCampaignScheduleTest() {
        String campaignId = "1";
        String campaignScheduleId = "1";
        try {

            EmailCampaignSchedule emailCampaignSchedule = constantContact.getEmailCampaignSchedule(campaignId, campaignScheduleId);
            verify(constantContact).getEmailCampaignSchedule(campaignId, campaignScheduleId);

            assertNotNull(emailCampaignSchedule);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }

    /**
     * Tests that the updateEmailCampaignSchedule method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEmailCampaignScheduleExceptionTest() {
        String campaignId = null;
        String campaignScheduleId = null;
        try {

            EmailCampaignSchedule emailCampaignSchedule = constantContact.getEmailCampaignSchedule(campaignId, campaignScheduleId);
            verify(constantContact).getEmailCampaignSchedule(campaignId, campaignScheduleId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }
}
