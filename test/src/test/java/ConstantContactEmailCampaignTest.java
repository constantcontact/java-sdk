import com.constantcontact.ConstantContact;
import com.constantcontact.components.emailcampaigns.EmailCampaignRequest;
import com.constantcontact.components.emailcampaigns.EmailCampaignResponse;
import com.constantcontact.components.emailcampaigns.schedules.EmailCampaignSchedule;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import customerMockData.EmailCampaignInfo;
import customerMockData.EmailScheduleInfo;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Constant Contact email campaigns and  schedules unit test class.<br/>
 *
 * @author ConstantContact
 */
public class ConstantContactEmailCampaignTest {

    private ConstantContact constantContact;
    private String apiKey;
    private String accessToken;


    @Before
    /**
     * Sets the apy key and the access token
     * Instantiates the ConstantContact object that contains tested methods
     *
     */
    public void setKeys() {
        this.apiKey = System.getProperty("apiKey");
        this.accessToken = System.getProperty("accessToken");
        constantContact = new ConstantContact(apiKey, accessToken);
    }

    @Test
    /**
     * Tests methods regarding email campaigns and schedules
     *
     */
    public void emailCampaignTests() {

        //add email campaign
        EmailCampaignResponse response = addEmailCampaignTest();

        //get email campaigns
        getEmailCampaignsTest();

        //update email campaign
        response = updateEmailCampaignTest(response.toEmailCampaignRequest());

        //get email campaign
        getEmailCampaignTest(response);

//        //add email campaign schedules
//        EmailCampaignSchedule emailCampaignSchedule = addEmailCampaignSchedule(response.getId());
//
//        //delete email campaign schedule
//        deleteEmailCampaignSchedule(response.getId(), emailCampaignSchedule.getId());

        //get email campaign schedules
        getEmailCampaignSchedules(response.getId());

        //delete email campaign
        deleteEmailCampaignTest(response.getId());

    }

    private EmailCampaignResponse addEmailCampaignTest() {

        EmailCampaignInfo emailCampaignInfo = new EmailCampaignInfo();
        EmailCampaignRequest emailCampaignRequest = emailCampaignInfo.getTestEmailCampaign();

        EmailCampaignResponse response = null;
        try {
            response = constantContact.addEmailCampaign(emailCampaignRequest);

            assertEquals("The expected email campaign name(" + emailCampaignRequest.getName() + ") does not correspond with the expected one (" +
                    response.getName() + ")", emailCampaignRequest.getName(), response.getName());
            assertEquals("The expected email campaign status(" + emailCampaignRequest.getStatus() + ") does not correspond with the expected one (" +
                    response.getStatus() + ")", emailCampaignRequest.getStatus(), response.getStatus());
            assertEquals("The expected email campaign content(" + emailCampaignRequest.getEmailContent() + ") does not correspond with the expected one (" +
                    response.getEmailContent() + ")", emailCampaignRequest.getEmailContent(), response.getEmailContent());
            assertEquals("The expected email campaign content format(" + emailCampaignRequest.getEmailContentFormat() + ") does not correspond with the expected one (" +
                    response.getEmailContentFormat() + ")", emailCampaignRequest.getEmailContentFormat(), response.getEmailContentFormat());
            assertEquals("The expected email campaign from email address(" + emailCampaignRequest.getFromEmail() + ") does not correspond with the expected one (" +
                    response.getFromEmail() + ")", emailCampaignRequest.getFromEmail(), response.getFromEmail());
            assertEquals("The expected email campaign from name(" + emailCampaignRequest.getFromName() + ") does not correspond with the expected one (" +
                    response.getFromName() + ")", emailCampaignRequest.getFromName(), response.getFromName());
            assertEquals("The expected email campaign greeting name(" + emailCampaignRequest.getGreetingName() + ") does not correspond with the expected one (" +
                    response.getGreetingName() + ")", emailCampaignRequest.getGreetingName(), response.getGreetingName());
            assertEquals("The expected email campaign greeting salutations(" + emailCampaignRequest.getGreetingSalutations() + ") does not correspond with the expected one (" +
                    response.getGreetingSalutations() + ")", emailCampaignRequest.getGreetingSalutations(), response.getGreetingSalutations());
            assertEquals("The expected email campaign greeting string(" + emailCampaignRequest.getGreetingString() + ") does not correspond with the expected one (" +
                    response.getGreetingString() + ")", emailCampaignRequest.getGreetingString(), response.getGreetingString());
            assertEquals("The expected email campaign reply to email(" + emailCampaignRequest.getReplyToEmail() + ") does not correspond with the expected one (" +
                    response.getReplyToEmail() + ")", emailCampaignRequest.getReplyToEmail(), response.getReplyToEmail());
            assertEquals("The expected email campaign subject(" + emailCampaignRequest.getSubject() + ") does not correspond with the expected one (" +
                    response.getSubject() + ")", emailCampaignRequest.getSubject(), response.getSubject());
            assertEquals("The expected email campaign template type(" + emailCampaignRequest.getTemplateType() + ") does not correspond with the expected one (" +
                    response.getTemplateType() + ")", emailCampaignRequest.getTemplateType(), response.getTemplateType());
            assertEquals("The expected email campaign text content(" + emailCampaignRequest.getTextContent() + ") does not correspond with the expected one (" +
                    response.getTextContent() + ")", emailCampaignRequest.getTextContent(), response.getTextContent());
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * Tests the retrieved email campaigns
     */
    public void getEmailCampaignsTest() {
        ResultSet<EmailCampaignResponse> emailCampaignResponses = null;
        try {
            emailCampaignResponses = constantContact.getEmailCampaigns();
            assertNotNull("There are no email campaigns.", emailCampaignResponses);
            //System.out.print(emailCampaignResponses.size());
        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
    }

    /**
     * Tests the update method for email campaigns
     *
     * @param campaignRequest The email campaign that requests an update
     * @return The update response email campaign
     */
    private EmailCampaignResponse updateEmailCampaignTest(EmailCampaignRequest campaignRequest) {
        EmailCampaignResponse response = null;
        try {
            campaignRequest.setSubject(campaignRequest.getSubject() + "(Updated)");
            response = constantContact.updateEmailCampaign(campaignRequest);

            assertEquals("The campaign's updated field(" + campaignRequest.getEmailContent() + ") does not have the expected value(" +
                    response.getEmailContent() + ").", campaignRequest.getEmailContent(), response.getEmailContent());

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
        return response;
    }

    /**
     * Tests the getEmailCampaign method and verifies if the retrieved email campaign is the one requested
     *
     * @param emailCampaignResponse The response representing the email campaign added previously
     * @return The get email campaign response
     */
    private EmailCampaignResponse getEmailCampaignTest(EmailCampaignResponse emailCampaignResponse) {
        EmailCampaignResponse response = null;
        try {
            response = constantContact.getEmailCampaign(emailCampaignResponse.getId());

            assertEquals("The expected email campaign name(" + emailCampaignResponse.getName() + ") does not correspond with the expected one (" +
                    response.getName() + ")", emailCampaignResponse.getName(), response.getName());
            assertEquals("The expected email campaign status(" + emailCampaignResponse.getStatus() + ") does not correspond with the expected one (" +
                    response.getStatus() + ")", emailCampaignResponse.getStatus(), response.getStatus());
            assertEquals("The expected email campaign content(" + emailCampaignResponse.getEmailContent() + ") does not correspond with the expected one (" +
                    response.getEmailContent() + ")", emailCampaignResponse.getEmailContent(), response.getEmailContent());
            assertEquals("The expected email campaign content format(" + emailCampaignResponse.getEmailContentFormat() + ") does not correspond with the expected one (" +
                    response.getEmailContentFormat() + ")", emailCampaignResponse.getEmailContentFormat(), response.getEmailContentFormat());
            assertEquals("The expected email campaign from email address(" + emailCampaignResponse.getFromEmail() + ") does not correspond with the expected one (" +
                    response.getFromEmail() + ")", emailCampaignResponse.getFromEmail(), response.getFromEmail());
            assertEquals("The expected email campaign from name(" + emailCampaignResponse.getFromName() + ") does not correspond with the expected one (" +
                    response.getFromName() + ")", emailCampaignResponse.getFromName(), response.getFromName());
            assertEquals("The expected email campaign greeting name(" + emailCampaignResponse.getGreetingName() + ") does not correspond with the expected one (" +
                    response.getGreetingName() + ")", emailCampaignResponse.getGreetingName(), response.getGreetingName());
            assertEquals("The expected email campaign greeting salutations(" + emailCampaignResponse.getGreetingSalutations() + ") does not correspond with the expected one (" +
                    response.getGreetingSalutations() + ")", emailCampaignResponse.getGreetingSalutations(), response.getGreetingSalutations());
            assertEquals("The expected email campaign greeting string(" + emailCampaignResponse.getGreetingString() + ") does not correspond with the expected one (" +
                    response.getGreetingString() + ")", emailCampaignResponse.getGreetingString(), response.getGreetingString());
            assertEquals("The expected email campaign reply to email(" + emailCampaignResponse.getReplyToEmail() + ") does not correspond with the expected one (" +
                    response.getReplyToEmail() + ")", emailCampaignResponse.getReplyToEmail(), response.getReplyToEmail());
            assertEquals("The expected email campaign subject(" + emailCampaignResponse.getSubject() + ") does not correspond with the expected one (" +
                    response.getSubject() + ")", emailCampaignResponse.getSubject(), response.getSubject());
            assertEquals("The expected email campaign template type(" + emailCampaignResponse.getTemplateType() + ") does not correspond with the expected one (" +
                    response.getTemplateType() + ")", emailCampaignResponse.getTemplateType(), response.getTemplateType());
            assertEquals("The expected email campaign text content(" + emailCampaignResponse.getTextContent() + ") does not correspond with the expected one (" +
                    response.getTextContent() + ")", emailCampaignResponse.getTextContent(), response.getTextContent());

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
        return response;
    }

    /**
     * Tests the email campaign delete functionality
     *
     * @param campaignId The id of the email campaign to be deleted
     */
    private void deleteEmailCampaignTest(String campaignId) {
        try {
            boolean deleted = constantContact.deleteEmailCampaign(campaignId);
            assertTrue(deleted);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the getEmailCampaignSchedules method
     *
     * @param campaignId The Id of the email campaign to be retrieved
     */
    private void getEmailCampaignSchedules(String campaignId) {
        EmailScheduleInfo emailScheduleInfo = new EmailScheduleInfo();
        try {
            List<EmailCampaignSchedule> emailCampaignSchedules = constantContact.getEmailCampaignSchedules(campaignId);
            assertEquals("There should be no email campaign schedule", emailCampaignSchedules.size(), 0);
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }


    /**
     * Tests the addEmailCampaignSchedule functionality
     * @param campaignId The Id of the campaign for which the schedule is added
     * @return The added email campaign schedule
     */
    private EmailCampaignSchedule addEmailCampaignSchedule(String campaignId) {
        EmailScheduleInfo emailScheduleInfo = new EmailScheduleInfo();
        EmailCampaignSchedule scheduleInfo = emailScheduleInfo.getEmailCampaignSchedule();
        EmailCampaignSchedule emailCampaignSchedule = null;
        try {
            emailCampaignSchedule = constantContact.addEmailCampaignSchedule(campaignId, scheduleInfo);
            assertEquals("The retrieved schedule date does not have the appropriate value.", scheduleInfo.getScheduledDate(), emailCampaignSchedule.getScheduledDate());
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
        return emailCampaignSchedule;
    }

    /**
     * Tests the deleteEmailCampaignSchedule functionality
     * @param campaignId The Id of the campaign from which the schedule is deleted
     * @param scheduleId The Id of the schedule to be deleted
     *
     */
    private void deleteEmailCampaignSchedule(String campaignId, String scheduleId) {
        try {
            boolean deleted = constantContact.deleteEmailCampaignSchedule(campaignId, scheduleId);
            assertFalse("The schedule delete encountered an error", deleted);
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }
}
