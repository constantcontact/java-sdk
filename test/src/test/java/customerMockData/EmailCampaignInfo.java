package customerMockData;

import com.constantcontact.components.emailcampaigns.*;

import java.util.Date;

/**
 * Data used to test the email campaign functionality.<br/>
 *
 * @author ConstantContact
 */
public class EmailCampaignInfo {

    protected EmailCampaignRequest emailCampaignRequest;

    /**
     * Custom constructor that sets the fields of the EmailCampaignRequest object
     * used to test the email campaign related functionality
     *
     */
    public EmailCampaignInfo() {
        EmailCampaignRequest emailCampaignRequest1 = new EmailCampaignRequest();

        emailCampaignRequest1.setName("Campaign "+ (new Date()).toString());
        emailCampaignRequest1.setSubject("CampaignSubject");
        emailCampaignRequest1.setStatus(EmailCampaignBase.Status.DRAFT);
        emailCampaignRequest1.setFromName("From WSPI");
        emailCampaignRequest1.setFromEmail("stefan.halus@osf-global.com");
        emailCampaignRequest1.setReplyToEmail("stefan.halus@osf-global.com");
        emailCampaignRequest1.setTemplateType("CUSTOM");
        emailCampaignRequest1.setCreatedDate("2012-12-06T18:06:05.255Z");
        emailCampaignRequest1.setLastRunDate("2012-12-06T18:06:40.342Z");
        emailCampaignRequest1.setViewAsWebPageText("Having trouble viewing this email?");
        emailCampaignRequest1.setViewAsWebPageLinkText("Click here");
        emailCampaignRequest1.setGreetingSalutations("Hi");
        emailCampaignRequest1.setGreetingName("FIRST_NAME");
        emailCampaignRequest1.setGreetingString("");
        emailCampaignRequest1.setEmailContent("<html><body>Hi <a href=\'http://www.constantcontact.com\'>Visit ConstantContact.com!</a> </body></html>");
        emailCampaignRequest1.setTextContent("<text>Something to test</text>");
        emailCampaignRequest1.setEmailContentFormat("HTML");
        emailCampaignRequest1.setStyleSheet("");

        MessageFooter messageFooter = new MessageFooter();
        messageFooter.setCity("Waltham");
        messageFooter.setState("MA");
        messageFooter.setCountry("US");
        messageFooter.setOrganizationName("WSPIOrgName");
        messageFooter.setAddressLine1("1601 Trapelo RD");
        messageFooter.setAddressLine2("suite 2");
        messageFooter.setAddressLine3("box 4");
        messageFooter.setInternationalState("");
        messageFooter.setPostalCode("02451");
        messageFooter.setIncludeForwardEmail(true);
        messageFooter.setForwardEmailLinkText("WSPIForwardThisEmail");
        messageFooter.setSubscribeLinkText("WSPISubscribeLinkText");
        messageFooter.setIncludeSubscribeLink(true);

        emailCampaignRequest1.setMessageFooter(messageFooter);

        TrackingSummary trackingSummary = new TrackingSummary();

        emailCampaignRequest1.setTrackingSummary(trackingSummary);
        emailCampaignRequest1.setArchiveStatus("PENDING");

        this.emailCampaignRequest = emailCampaignRequest1;
    }

    /**
     * Gets the email campaign request
     * @return The EmailCampaignRequest object
     */
    public EmailCampaignRequest getTestEmailCampaign() {
        return emailCampaignRequest;
    }

    /**
     * Sets the email campaign request
     * @param testEmailCampaign The EmailCampaignRequest object to be set
     */
    public void setEmailCampaign(EmailCampaignRequest testEmailCampaign) {
        this.emailCampaignRequest = testEmailCampaign;
    }
}
