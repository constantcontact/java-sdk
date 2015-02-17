import com.constantcontact.ConstantContact;
import com.constantcontact.components.contacts.tracking.reports.summary.ContactTrackingSummaryReport;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import mockup.ContactTrackingServiceTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;


/**
 * Constant Contact tracking unit test class.<br/>
 *
 * @author ConstantContact
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactTrackingTest {

    ConstantContact constantContact;

    @Before
    public void beforeTests(){
        constantContact = Mockito.spy(new ConstantContact("", ""));
        constantContact.setContactTrackingService(new ContactTrackingServiceTest());
    }

    /**
     * Tests the getContactTrackingSummary from the ConstantContact.class
     *
     */
    @Test
    public void getSummaryTest(){
        String contactId = "1";

        try {

            ContactTrackingSummaryReport trackingSummaryReport = mock(ContactTrackingSummaryReport.class);

            trackingSummaryReport =  constantContact.getContactTrackingSummary(contactId, null);
            verify(constantContact).getContactTrackingSummary(contactId, null);

            assertNotNull(trackingSummaryReport);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests that the getContactTrackingSummary throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getSummaryExceptionTest(){
        String contactId = null;

        try {

            ContactTrackingSummaryReport trackingSummaryReport = mock(ContactTrackingSummaryReport.class);

            trackingSummaryReport =  constantContact.getContactTrackingSummary(contactId, null);
            verify(constantContact).getContactTrackingSummary(contactId, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the getContactTrackingSummaryByCampaign from the ConstantContact.class
     *
     */
    @Test
    public void getContactTrackingSummaryByCampaignTest(){
        String contactId = "1";

        try {

            List list = mock(List.class);

            list = constantContact.getContactTrackingSummaryByCampaign(contactId);
            verify(constantContact).getContactTrackingSummaryByCampaign(contactId);

            assertNotNull(list);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContactTrackingSummaryByCampaign throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactTrackingSummaryByCampaignExceptionTest(){
        String contactId = null;

        try {

            List list = mock(List.class);

            list = constantContact.getContactTrackingSummaryByCampaign(contactId);
            verify(constantContact).getContactTrackingSummaryByCampaign(contactId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getContactTrackingActivities from the ConstantContact.class
     *
     */
    @Test
    public void getContactTrackingActivitiesTest(){
        String contactId = "1";

        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = constantContact.getContactTrackingActivities(contactId, 1, null);
            verify(constantContact).getContactTrackingActivities(contactId, 1, null);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContactTrackingActivities throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactTrackingActivitiesExceptionTest(){
        String contactId = null;

        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = constantContact.getContactTrackingActivities(contactId, 1, null);
            verify(constantContact).getContactTrackingActivities(contactId, 1, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getContactTrackingBounces from the ConstantContact.class
     *
     */
    @Test
    public void getContactTrackingBouncesTest(){
        String contactId = "1";

        try {

            ResultSet contactTrackingBounceResultSet = mock(ResultSet.class);

            contactTrackingBounceResultSet = constantContact.getContactTrackingBounces(contactId, null);
            verify(constantContact).getContactTrackingBounces(contactId, null);

            assertNotNull(contactTrackingBounceResultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContactTrackingBounces throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactTrackingBouncesExceptionTest(){
        String contactId = null;

        try {

            ResultSet contactTrackingBounceResultSet = mock(ResultSet.class);

            contactTrackingBounceResultSet = constantContact.getContactTrackingBounces(contactId, null);
            verify(constantContact).getContactTrackingBounces(contactId, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getContactTrackingClicks from the ConstantContact.class
     *
     */
    @Test
    public void getContactTrackingClicksTest(){
        String contactId = "1";
        int limit = 1;

        try {

            ResultSet contactTrackingClickResultSet = mock(ResultSet.class);

            contactTrackingClickResultSet = constantContact.getContactTrackingClicks(contactId, limit, null);
            verify(constantContact).getContactTrackingClicks(contactId, limit, null);

            assertNotNull(contactTrackingClickResultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContactTrackingClicks throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactTrackingClicksExceptionTest(){
        String contactId = null;
        int limit = 0;

        try {

            ResultSet contactTrackingBounceResultSet = mock(ResultSet.class);

            contactTrackingBounceResultSet = constantContact.getContactTrackingClicks(contactId, limit, null);
            verify(constantContact).getContactTrackingClicks(contactId, limit, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getContactTrackingForwards from the ConstantContact.class
     *
     */
    @Test
    public void getContactTrackingForwardsTest(){
        String contactId = "1";
        int limit = 1;

        try {

            ResultSet contactTrackingForwardResultSet = mock(ResultSet.class);

            contactTrackingForwardResultSet = constantContact.getContactTrackingForwards(contactId, limit, null);
            verify(constantContact).getContactTrackingForwards(contactId, limit, null);

            assertNotNull(contactTrackingForwardResultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContactTrackingForwards throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactTrackingForwardsExceptionTest(){
        String contactId = null;
        int limit = 0;

        try {

            ResultSet contactTrackingBounceResultSet = mock(ResultSet.class);

            contactTrackingBounceResultSet = constantContact.getContactTrackingForwards(contactId, limit, null);
            verify(constantContact).getContactTrackingForwards(contactId, limit, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getContactTrackingOpens from the ConstantContact.class
     *
     */
    @Test
    public void getContactTrackingOpensTest(){
        String contactId = "1";
        int limit = 1;

        try {

            ResultSet contactTrackingOpenResultSet = mock(ResultSet.class);

            contactTrackingOpenResultSet = constantContact.getContactTrackingOpens(contactId, limit, null);
            verify(constantContact).getContactTrackingOpens(contactId, limit, null);

            assertNotNull(contactTrackingOpenResultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContactTrackingOpens throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactTrackingOpensExceptionTest(){
        String contactId = null;
        int limit = 0;

        try {

            ResultSet contactTrackingBounceResultSet = mock(ResultSet.class);

            contactTrackingBounceResultSet = constantContact.getContactTrackingOpens(contactId, limit, null);
            verify(constantContact).getContactTrackingOpens(contactId, limit, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getContactTrackingSends method from ConstantContact.class
     *
     */
    @Test
    public void getContactTrackingSendsTest(){
        String contactId = "1";
        int limit = 1;

        try {

            ResultSet contactTrackingSendResultSet = mock(ResultSet.class);

            contactTrackingSendResultSet = constantContact.getContactTrackingSends(contactId, limit, null);
            verify(constantContact).getContactTrackingSends(contactId, limit, null);

            assertNotNull(contactTrackingSendResultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContactTrackingSends throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactTrackingSendsExceptionTest(){
        String contactId = null;
        int limit = 0;

        try {

            ResultSet contactTrackingBounceResultSet = mock(ResultSet.class);

            contactTrackingBounceResultSet = constantContact.getContactTrackingSends(contactId, limit, null);
            verify(constantContact).getContactTrackingSends(contactId, limit, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getContactTrackingUnsubscribes method from ConstantContact.class
     *
     */
    @Test
    public void getContactTrackingUnsubscribesTest(){
        String contactId = "1";
        int limit = 1;

        try {

            ResultSet contactTrackingUnsubscribeResultSet = mock(ResultSet.class);

            contactTrackingUnsubscribeResultSet = constantContact.getContactTrackingUnsubscribes(contactId, limit, null);
            verify(constantContact).getContactTrackingUnsubscribes(contactId, limit, null);

            assertNotNull(contactTrackingUnsubscribeResultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContactTrackingUnsubscribes throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactTrackingUnsubscribesExceptionTest(){
        String contactId = null;
        int limit = 0;

        try {

            ResultSet contactTrackingBounceResultSet = mock(ResultSet.class);

            contactTrackingBounceResultSet = constantContact.getContactTrackingUnsubscribes(contactId, limit, null);
            verify(constantContact).getContactTrackingUnsubscribes(contactId, limit, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }
}
