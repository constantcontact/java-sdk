import com.constantcontact.ConstantContact;
import com.constantcontact.components.emailcampaigns.tracking.reports.summary.EmailCampaignTrackingSummary;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import mockup.EmailCampaignTrackingServiceTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;


/**
 * Constant Contact email campaign tracking unit test class.<br/>
 *
 * @author ConstantContact
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactEmailCampaignTrackingTest {

    ConstantContact constantContact;

    @Before
    public void beforeTests(){
        constantContact = Mockito.spy(new ConstantContact("", ""));
        constantContact.setEmailCampaignTrackingService(new EmailCampaignTrackingServiceTest());
    }

    /**
     * Tests the retrieving of the email campaign tracking summary
     */
    @Test
    public void getEmailCampaignTrackingSummaryTest() {

        String emailCampaignId = "1";
        try {
            EmailCampaignTrackingSummary emailCampaignTrackingSummary = new EmailCampaignTrackingSummary();

            emailCampaignTrackingSummary = constantContact.getEmailCampaignTrackingSummary(emailCampaignId, null);
            verify(constantContact).getEmailCampaignTrackingSummary(emailCampaignId, null);

            assertNotNull(emailCampaignTrackingSummary);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getEmailCampaignTrackingSummary method throws the proper exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEmailCampaignTrackingSummaryExceptionTest() {

        String emailCampaignId = null;
        try {
            EmailCampaignTrackingSummary emailCampaignTrackingSummary = null;

            emailCampaignTrackingSummary = constantContact.getEmailCampaignTrackingSummary(emailCampaignId, null);
            verify(constantContact).getEmailCampaignTrackingSummary(emailCampaignId, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the retrieving of the email campaign bounces
     */
    @Test
    public void getEmailCampaignTrackingBouncesTest() {
        String emailCampaignId = "1";

        try {

            ResultSet resultSet = new ResultSet();

            resultSet = constantContact.getEmailCampaignTrackingBounces(emailCampaignId, 1);
            verify(constantContact).getEmailCampaignTrackingBounces(emailCampaignId, 1);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getEmailCampaignTrackingBounces method throws the proper exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEmailCampaignTrackingBouncesExceptionTest() {
        String emailCampaignId = null;

        try {

            ResultSet resultSet = new ResultSet();

            resultSet = constantContact.getEmailCampaignTrackingBounces(emailCampaignId, 1);
            verify(constantContact).getEmailCampaignTrackingBounces(emailCampaignId, 1);

        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
    }

    /**
     * Tests the retrieving of the email campaign clicks
     *
     */
    @Test
    public void getEmailCampaignTrackingClicksTest() {
        String emailCampaignId = "1";

        try {

            ResultSet resultSet = new ResultSet();

            resultSet = constantContact.getEmailCampaignTrackingClicks(emailCampaignId, 1, null);
            verify(constantContact).getEmailCampaignTrackingClicks(emailCampaignId, 1, null);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests that the getEmailCampaignTrackingClicks method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEmailCampaignTrackingClicksExceptionTest() {
        String emailCampaignId = null;

        try {

            ResultSet resultSet = new ResultSet();

            resultSet = constantContact.getEmailCampaignTrackingClicks(emailCampaignId, 1, null);
            verify(constantContact).getEmailCampaignTrackingClicks(emailCampaignId, 1, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the retrieving of the email campaign opens
     *
     */
    @Test
    public void getEmailCampaignTrackingOpensTest() {
        String emailCampaignId = "1";

        try {

            ResultSet resultSet = new ResultSet();

            resultSet = constantContact.getEmailCampaignTrackingOpens(emailCampaignId, 1, null);
            verify(constantContact).getEmailCampaignTrackingOpens(emailCampaignId, 1, null);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests that the getEmailCampaignTrackingOpens method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEmailCampaignTrackingOpensExceptionTest() {
        String emailCampaignId = null;

        try {

            ResultSet resultSet = new ResultSet();

            resultSet = constantContact.getEmailCampaignTrackingOpens(emailCampaignId, 1, null);
            verify(constantContact).getEmailCampaignTrackingOpens(emailCampaignId, 1, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the retrieving of the email campaign sends
     *
     */
    @Test
    public void getEmailCampaignTrackingSendsTest() {
        String emailCampaignId = "1";

        try {

            ResultSet resultSet = new ResultSet();

            resultSet = constantContact.getEmailCampaignTrackingSends(emailCampaignId, 1, null);
            verify(constantContact).getEmailCampaignTrackingSends(emailCampaignId, 1, null);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests that the getEmailCampaignTrackingSends method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEmailCampaignTrackingSendsExceptionTest() {
        String emailCampaignId = null;

        try {

            ResultSet resultSet = new ResultSet();

            resultSet = constantContact.getEmailCampaignTrackingSends(emailCampaignId, 1, null);
            verify(constantContact).getEmailCampaignTrackingSends(emailCampaignId, 1, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the retrieving of the email campaign forwards
     *
     */
    @Test
    public void getEmailCampaignTrackingForwardsTest() {
        String emailCampaignId = "1";

        try {

            ResultSet resultSet = new ResultSet();

            resultSet = constantContact.getEmailCampaignTrackingForwards(emailCampaignId, 1, null);
            verify(constantContact).getEmailCampaignTrackingForwards(emailCampaignId, 1, null);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests that the getEmailCampaignTrackingForwards method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEmailCampaignTrackingForwardsExceptionTest() {
        String emailCampaignId = null;

        try {

            ResultSet resultSet = new ResultSet();

            resultSet = constantContact.getEmailCampaignTrackingForwards(emailCampaignId, 1, null);
            verify(constantContact).getEmailCampaignTrackingForwards(emailCampaignId, 1, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the retrieving of the email campaign unsubscribes
     *
     */
    @Test
    public void getEmailCampaignTrackingUnsubscribesTest() {
        String campaignId = "1";

        try {

            ResultSet resultSet = new ResultSet();

            resultSet = constantContact.getEmailCampaignTrackingUnsubscribes(campaignId, 1, null);
            verify(constantContact).getEmailCampaignTrackingUnsubscribes(campaignId, 1, null);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }

    /**
     * Tests that the getEmailCampaignTrackingUnsubscribes method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEmailCampaignTrackingUnsubscribesExceptionTest() {
        String emailCampaignId = null;

        try {

            ResultSet resultSet = new ResultSet();

            resultSet = constantContact.getEmailCampaignTrackingUnsubscribes(emailCampaignId, 1, null);
            verify(constantContact).getEmailCampaignTrackingUnsubscribes(emailCampaignId, 1, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }


    /**
     * Tests the retrieving of the email campaign clicks by link
     *
     */
    @Test
    public void getEmailCampaignTrackingClicksByLinkTest() {
        String campaignId = "1";
        String linkId = "1";

        try {

            ResultSet resultSet = new ResultSet();

            resultSet = constantContact.getEmailCampaignTrackingClicksByLink(campaignId, linkId, 1, null);
            verify(constantContact).getEmailCampaignTrackingClicksByLink(campaignId, linkId, 1, null);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.print(e.getErrorInfo());
        }
    }

    /**
     * Tests that the getEmailCampaignTrackingClicksByLink method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEmailCampaignTrackingClicksByLinkExceptionTest() {
        String campaignId = null;
        String linkId = null;

        try {

            ResultSet resultSet = new ResultSet();

            resultSet = constantContact.getEmailCampaignTrackingClicksByLink(campaignId, linkId, 1, null);
            verify(constantContact).getEmailCampaignTrackingClicksByLink(campaignId, linkId, 1, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

}
