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

import com.constantcontact.components.emailcampaigns.schedules.EmailCampaignSchedule;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.mockup.ConstantContactFactoryMock;
import com.constantcontact.services.emailcampaigns.schedule.IEmailCampaignScheduleService;


/**
 * Constant Contact email campaigns and  schedules unit test class.<br/>
 *
 * @author ConstantContact
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactEmailCampaignScheduleTest {

	private ConstantContactFactoryMock constantContactFactoryMock;
    private IEmailCampaignScheduleService emailCampaignScheduleServiceMock;

	private ConstantContactFactory constantContactFactory;
    private IEmailCampaignScheduleService emailCampaignScheduleService;
    
    @Before
    public void beforeTests(){
    	constantContactFactoryMock = Mockito.spy(new ConstantContactFactoryMock("",""));
    	emailCampaignScheduleServiceMock = constantContactFactoryMock.createEmailCampaignScheduleService();
    	
    	constantContactFactory = Mockito.spy(new ConstantContactFactory("",""));
    	emailCampaignScheduleService = constantContactFactory.createEmailCampaignScheduleService();
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
            emailCampaignSchedules = emailCampaignScheduleServiceMock.getSchedules(campaignId);
            verify(emailCampaignScheduleServiceMock).getSchedules(campaignId);

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
            emailCampaignSchedules = emailCampaignScheduleServiceMock.getSchedules(campaignId);
            verify(emailCampaignScheduleServiceMock).getSchedules(campaignId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }
    
    /**
     * Tests that the getEmailCampaignSchedules method throws the proper exception
     * @throws ConstantContactServiceException 
     *
     */
    @Test(expected = ConstantContactServiceException.class)
    public void getEmailCampaignSchedulesServiceExceptionTest() throws ConstantContactServiceException {
        String campaignId = "1";

        List<EmailCampaignSchedule> emailCampaignSchedules = new ArrayList<EmailCampaignSchedule>();
        emailCampaignSchedules = emailCampaignScheduleService.getSchedules(campaignId);
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

            EmailCampaignSchedule resultEmailCampaignSchedule = emailCampaignScheduleServiceMock.addSchedule(campaignId, emailCampaignSchedule);
            verify(emailCampaignScheduleServiceMock).addSchedule(campaignId, emailCampaignSchedule);

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
        String validCampaignId = "1";
        EmailCampaignSchedule validEmailCampaignSchedule = mock(EmailCampaignSchedule.class);
        try {

            EmailCampaignSchedule resultEmailCampaignSchedule = emailCampaignScheduleServiceMock.addSchedule(campaignId, emailCampaignSchedule);
            verify(emailCampaignScheduleServiceMock).addSchedule(campaignId, emailCampaignSchedule);
            
            resultEmailCampaignSchedule = emailCampaignScheduleServiceMock.addSchedule(validCampaignId, emailCampaignSchedule);
            verify(emailCampaignScheduleServiceMock).addSchedule(validCampaignId, emailCampaignSchedule);
            
            resultEmailCampaignSchedule = emailCampaignScheduleServiceMock.addSchedule(campaignId, validEmailCampaignSchedule);
            verify(emailCampaignScheduleServiceMock).addSchedule(campaignId, validEmailCampaignSchedule);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }

    /**
     * Tests that the addEmailCampaignSchedule method throws the proper exception
     * @throws ConstantContactServiceException 
     *
     */
    @Test(expected = ConstantContactServiceException.class)
    public void addEmailCampaignScheduleServiceExceptionTest() throws ConstantContactServiceException {
        String campaignId = "1";
        EmailCampaignSchedule emailCampaignSchedule = new EmailCampaignSchedule();

        EmailCampaignSchedule resultEmailCampaignSchedule = emailCampaignScheduleService.addSchedule(campaignId, emailCampaignSchedule);

    }
    
    /**
     * Tests the updateEmailCampaignSchedule method
     *
     */
    @Test
    public void updateEmailCampaignScheduleTest() {
        String campaignId = "1";
        String campaignScheduleId = "2";
        EmailCampaignSchedule emailCampaignSchedule = mock(EmailCampaignSchedule.class);
        try {

            EmailCampaignSchedule resultEmailCampaignSchedule = emailCampaignScheduleServiceMock.updateSchedule(campaignId, campaignScheduleId, emailCampaignSchedule);
            verify(emailCampaignScheduleServiceMock).updateSchedule(campaignId, campaignScheduleId, emailCampaignSchedule);

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
        EmailCampaignSchedule validEmailCampaignSchedule = mock(EmailCampaignSchedule.class);
        String validString = "1";
        try {

        	EmailCampaignSchedule resultEmailCampaignSchedule = emailCampaignScheduleServiceMock.updateSchedule(validString, campaignScheduleId, emailCampaignSchedule);
            verify(emailCampaignScheduleServiceMock).updateSchedule(validString, campaignScheduleId, emailCampaignSchedule);
            
            resultEmailCampaignSchedule = emailCampaignScheduleServiceMock.updateSchedule(campaignId, validString, emailCampaignSchedule);
            verify(emailCampaignScheduleServiceMock).updateSchedule(campaignId, validString, emailCampaignSchedule);
            
            resultEmailCampaignSchedule = emailCampaignScheduleServiceMock.updateSchedule(campaignId, campaignScheduleId, validEmailCampaignSchedule);
            verify(emailCampaignScheduleServiceMock).updateSchedule(campaignId, campaignScheduleId, validEmailCampaignSchedule);
            
            resultEmailCampaignSchedule = emailCampaignScheduleServiceMock.updateSchedule(validString, campaignScheduleId, validEmailCampaignSchedule);
            verify(emailCampaignScheduleServiceMock).updateSchedule(validString, campaignScheduleId, validEmailCampaignSchedule);

            resultEmailCampaignSchedule = emailCampaignScheduleServiceMock.updateSchedule(validString, validString, emailCampaignSchedule);
            verify(emailCampaignScheduleServiceMock).updateSchedule(validString, validString, emailCampaignSchedule);
            
            resultEmailCampaignSchedule = emailCampaignScheduleServiceMock.updateSchedule(campaignId, validString, validEmailCampaignSchedule);
            verify(emailCampaignScheduleServiceMock).updateSchedule(campaignId, validString, validEmailCampaignSchedule);
            
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }
    
    /**
     * Tests that the updateEmailCampaignSchedule method throws the proper exception
     * @throws ConstantContactServiceException 
     *
     */
    @Test(expected = ConstantContactServiceException.class)
    public void updateEmailCampaignScheduleServiceExceptionTest() throws ConstantContactServiceException {
        String campaignScheduleId = "1";
        EmailCampaignSchedule emailCampaignSchedule = new EmailCampaignSchedule();

        EmailCampaignSchedule resultEmailCampaignSchedule = emailCampaignScheduleService.updateSchedule(campaignScheduleId, campaignScheduleId, emailCampaignSchedule);
    }

    /**
     * Tests the deleteEmailCampaignSchedule method
     *
     */
    @Test
    public void deleteEmailCampaignScheduleTest() {
        String campaignId = "1";
        String scheduleId = "2";
        try {

            boolean deleted = emailCampaignScheduleServiceMock.deleteSchedule(campaignId, scheduleId);
            verify(emailCampaignScheduleServiceMock).deleteSchedule(campaignId, scheduleId);

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
        String validCampaignId = "1";
        String validScheduleId = "2";
        try {

            boolean deleted = emailCampaignScheduleServiceMock.deleteSchedule(campaignId, scheduleId);
            verify(emailCampaignScheduleServiceMock).deleteSchedule(campaignId, scheduleId);
            
            deleted = emailCampaignScheduleServiceMock.deleteSchedule(validCampaignId, scheduleId);
            verify(emailCampaignScheduleServiceMock).deleteSchedule(validCampaignId, scheduleId);
            
            deleted = emailCampaignScheduleServiceMock.deleteSchedule(campaignId, validScheduleId);
            verify(emailCampaignScheduleServiceMock).deleteSchedule(campaignId, validScheduleId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }
    
    /**
     * Tests that the deleteEmailCampaignSchedule method throws the proper exception
     *
     */
    @Test(expected = ConstantContactServiceException.class)
    public void deleteEmailCampaignScheduleServiceExceptionTest() throws ConstantContactServiceException{
        String campaignId = "1";
        String scheduleId = "2";

        boolean deleted = emailCampaignScheduleService.deleteSchedule(campaignId, scheduleId);
    }

    /**
     * Tests the updateEmailCampaignSchedule method
     *
     */
    @Test
    public void getEmailCampaignScheduleTest() {
        String campaignId = "1";
        String campaignScheduleId = "2";
        try {

            EmailCampaignSchedule emailCampaignSchedule = emailCampaignScheduleServiceMock.getSchedule(campaignId, campaignScheduleId);
            verify(emailCampaignScheduleServiceMock).getSchedule(campaignId, campaignScheduleId);

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
        String validCampaignId = "1";
        String validCampaignScheduleId = "2";
        try {

            EmailCampaignSchedule emailCampaignSchedule = emailCampaignScheduleServiceMock.getSchedule(campaignId, campaignScheduleId);
            verify(emailCampaignScheduleServiceMock).getSchedule(campaignId, campaignScheduleId);
            
            emailCampaignSchedule = emailCampaignScheduleServiceMock.getSchedule(validCampaignId, campaignScheduleId);
            verify(emailCampaignScheduleServiceMock).getSchedule(validCampaignId, campaignScheduleId);
            
            emailCampaignSchedule = emailCampaignScheduleServiceMock.getSchedule(campaignId, validCampaignScheduleId);
            verify(emailCampaignScheduleServiceMock).getSchedule(campaignId, validCampaignScheduleId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }
    
    /**
     * Tests that the updateEmailCampaignSchedule method throws the proper exception
     * @throws ConstantContactServiceException 
     *
     */
    @Test(expected = ConstantContactServiceException.class)
    public void getEmailCampaignScheduleServiceExceptionTest() throws ConstantContactServiceException {
        String campaignId = "1";
        String campaignScheduleId = "2";
        
        EmailCampaignSchedule emailCampaignSchedule = emailCampaignScheduleService.getSchedule(campaignId, campaignScheduleId);
    }
}
