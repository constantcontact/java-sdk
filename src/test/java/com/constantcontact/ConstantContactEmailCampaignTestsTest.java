package com.constantcontact;

import com.constantcontact.components.emailcampaigns.test.EmailCampaignPreview;
import com.constantcontact.components.emailcampaigns.test.EmailCampaignTest;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.mockup.ConstantContactFactoryMock;
import com.constantcontact.services.emailcampaigns.test.IEmailCampaignTestService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 * Constant Contact email campaigns tests unit test class.<br/>
 *
 * @author ConstantContact
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactEmailCampaignTestsTest {

    private ConstantContactFactoryMock constantContactFactoryMock;
    private IEmailCampaignTestService emailCampaignTestMock;

    private ConstantContactFactory constantContactFactory;
    private IEmailCampaignTestService emailCampaignTestService;

    @Before
    public void beforeTests() {
        constantContactFactoryMock = Mockito.spy(new ConstantContactFactoryMock("", ""));
        emailCampaignTestMock = constantContactFactoryMock.createEmailCampaignTestService();

        constantContactFactory = Mockito.spy(new ConstantContactFactory("", ""));
        emailCampaignTestService = constantContactFactory.createEmailCampaignTestService();
    }

    /**
     * Tests the getEmailCampaignPreview method
     */
    @Test
    public void getEmailCampaignPreviewTest() {
        String campaignId = "1";
        try {

            EmailCampaignPreview emailCampaignPreview = new EmailCampaignPreview();
            emailCampaignPreview = emailCampaignTestMock.getEmailCampaignPreview(campaignId);
            verify(emailCampaignTestMock).getEmailCampaignPreview(campaignId);

            assertNotNull(emailCampaignPreview);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }

    /**
     * Tests that the getEmailCampaignPreview method throws the proper exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEmailCampaignPreviewExceptionTest() {
        String campaignId = null;
        try {

            EmailCampaignPreview emailCampaignPreview = new EmailCampaignPreview();
            emailCampaignPreview = emailCampaignTestMock.getEmailCampaignPreview(campaignId);
            verify(emailCampaignTestMock).getEmailCampaignPreview(campaignId);


        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }

    /**
     * Tests that the getEmailCampaignSchedules method throws the proper exception
     *
     * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
     */
    @Test(expected = ConstantContactServiceException.class)
    public void getEmailCampaignPreviewServiceExceptionTest() throws ConstantContactServiceException {
        String campaignId = "1";

        EmailCampaignPreview emailCampaignPreview = new EmailCampaignPreview();
        emailCampaignPreview = emailCampaignTestService.getEmailCampaignPreview(campaignId);
    }


    /**
     * Tests the testEmailCampaignTest method
     */
    @Test
    public void testEmailCampaignTest() {
        String campaignId = "1";
        EmailCampaignTest emailCampaignTestRequest = mock(EmailCampaignTest.class);
        try {

            emailCampaignTestRequest.setEmailAddresses(new ArrayList<String>());
            emailCampaignTestRequest.setFormat(EmailCampaignTest.Format.HTML);
            emailCampaignTestRequest.setPersonalMessage("This is a test message");

            EmailCampaignTest emailCampaignTestResponse = emailCampaignTestMock.testEmailCampaign(campaignId, emailCampaignTestRequest);
            verify(emailCampaignTestMock).testEmailCampaign(campaignId, emailCampaignTestRequest);

            assertNotNull(emailCampaignTestResponse);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }

    /**
     * Tests that the testEmailCampaignTest method throws the proper exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEmailCampaignExceptionTest() {
        String campaignId = null;
        EmailCampaignTest emailCampaignTestRequest = null;
        try {

            emailCampaignTestMock.testEmailCampaign(campaignId, emailCampaignTestRequest);
            verify(emailCampaignTestMock).testEmailCampaign(campaignId, emailCampaignTestRequest);


        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }

    /**
     * Tests that the testEmailCampaignTest method throws the proper exception
     *
     * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
     */
    @Test(expected = ConstantContactServiceException.class)
    public void testEmailCampaignServiceExceptionTest() throws ConstantContactServiceException {
        String campaignId = "1";
        EmailCampaignTest emailCampaignTest = new EmailCampaignTest();
        emailCampaignTestService.testEmailCampaign(campaignId, emailCampaignTest);
    }

}