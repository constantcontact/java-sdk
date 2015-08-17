package com.constantcontact;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.constantcontact.components.contacts.tracking.reports.summary.ContactTrackingSummaryReport;
import com.constantcontact.components.generic.response.Pagination;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.mockup.ConstantContactFactoryMock;
import com.constantcontact.services.contacts.tracking.IContactTrackingService;


/**
 * Constant Contact tracking unit test class.<br/>
 *
 * @author ConstantContact
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactTrackingTest {

    private ConstantContactFactoryMock constantContactFactory;
    private IContactTrackingService contactTrackingService;

    @Before
    public void beforeTests() {
        constantContactFactory = Mockito.spy(new ConstantContactFactoryMock("", ""));
        contactTrackingService = constantContactFactory.createContactTrackingService();
    }

    /**
     * Tests the getContactTrackingSummary from the ConstantContact.class
     */
    @Test
    public void getSummaryTest() {
        String contactId = "1";

        try {

            ContactTrackingSummaryReport trackingSummaryReport = mock(ContactTrackingSummaryReport.class);

            trackingSummaryReport = contactTrackingService.getSummary(contactId, null);
            verify(contactTrackingService).getSummary(contactId, null);

            assertNotNull(trackingSummaryReport);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests that the getContactTrackingSummary throws the proper exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void getSummaryExceptionTest() {
        String contactId = null;

        try {

            ContactTrackingSummaryReport trackingSummaryReport = mock(ContactTrackingSummaryReport.class);

            trackingSummaryReport = contactTrackingService.getSummary(contactId, null);
            verify(contactTrackingService).getSummary(contactId, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the getContactTrackingSummaryByCampaign from the ConstantContact.class
     */
    @Test
    public void getContactTrackingSummaryByCampaignTest() {
        String contactId = "1";

        try {

            List list = mock(List.class);

            list = contactTrackingService.getSummaryByCampaign(contactId);
            verify(contactTrackingService).getSummaryByCampaign(contactId);

            assertNotNull(list);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContactTrackingSummaryByCampaign throws the proper exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactTrackingSummaryByCampaignExceptionTest() {
        String contactId = null;

        try {

            List list = mock(List.class);

            list = contactTrackingService.getSummaryByCampaign(contactId);
            verify(contactTrackingService).getSummaryByCampaign(contactId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getContactTrackingActivities from the ConstantContact.class
     */
    @Test
    public void getContactTrackingActivitiesTest() {
        String contactId = "1";

        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = contactTrackingService.getActivities(contactId, 1, null);
            verify(contactTrackingService).getActivities(contactId, 1, null);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContactTrackingActivities throws the proper exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactTrackingActivitiesExceptionTest() {
        String contactId = null;

        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = contactTrackingService.getActivities(contactId, 1, null);
            verify(contactTrackingService).getActivities(contactId, 1, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getActivities(pagination) from the ConstantContact.class
     */
    @Test
    public void getContactTrackingPaginatedActivitiesTest() {
        String contactId = "1";
        Pagination pagination = new Pagination();
        pagination.setNextLink("link");
        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = contactTrackingService.getActivities(pagination);
            verify(contactTrackingService).getActivities(pagination);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getBounces(pagination) from the ConstantContact.class
     */
    @Test
    public void getContactTrackingPaginatedBouncesTest() {
        String contactId = "1";
        Pagination pagination = new Pagination();
        pagination.setNextLink("link");
        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = contactTrackingService.getBounces(pagination);
            verify(contactTrackingService).getBounces(pagination);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getClicks(pagination) from the ConstantContact.class
     */
    @Test
    public void getContactTrackingPaginatedClicksTest() {
        String contactId = "1";
        Pagination pagination = new Pagination();
        pagination.setNextLink("link");
        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = contactTrackingService.getClicks(pagination);
            verify(contactTrackingService).getClicks(pagination);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getForwards(pagination) from the ConstantContact.class
     */
    @Test
    public void getContactTrackingPaginatedForwardsTest() {
        String contactId = "1";
        Pagination pagination = new Pagination();
        pagination.setNextLink("link");
        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = contactTrackingService.getForwards(pagination);
            verify(contactTrackingService).getForwards(pagination);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getOpens(pagination) from the ConstantContact.class
     */
    @Test
    public void getContactTrackingPaginatedOpensTest() {
        String contactId = "1";
        Pagination pagination = new Pagination();
        pagination.setNextLink("link");
        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = contactTrackingService.getOpens(pagination);
            verify(contactTrackingService).getOpens(pagination);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getSends(pagination) from the ConstantContact.class
     */
    @Test
    public void getContactTrackingPaginatedSendsTest() {
        String contactId = "1";
        Pagination pagination = new Pagination();
        pagination.setNextLink("link");
        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = contactTrackingService.getSends(pagination);
            verify(contactTrackingService).getSends(pagination);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getUnsubscribes(pagination) from the ConstantContact.class
     */
    @Test
    public void getContactTrackingPaginatedUnsubscribesTest() {
        String contactId = "1";
        Pagination pagination = new Pagination();
        pagination.setNextLink("link");
        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = contactTrackingService.getUnsubscribes(pagination);
            verify(contactTrackingService).getUnsubscribes(pagination);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getContactTrackingBounces from the ConstantContact.class
     */
    @Test
    public void getContactTrackingBouncesTest() {
        String contactId = "1";

        try {

            ResultSet contactTrackingBounceResultSet = mock(ResultSet.class);

            contactTrackingBounceResultSet = contactTrackingService.getBounces(contactId, null);
            verify(contactTrackingService).getBounces(contactId, null);

            assertNotNull(contactTrackingBounceResultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContactTrackingBounces throws the proper exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactTrackingBouncesExceptionTest() {
        String contactId = null;

        try {

            ResultSet contactTrackingBounceResultSet = mock(ResultSet.class);

            contactTrackingBounceResultSet = contactTrackingService.getBounces(contactId, null);
            verify(contactTrackingService).getBounces(contactId, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getContactTrackingClicks from the ConstantContact.class
     */
    @Test
    public void getContactTrackingClicksTest() {
        String contactId = "1";
        int limit = 1;

        try {

            ResultSet contactTrackingClickResultSet = mock(ResultSet.class);

            contactTrackingClickResultSet = contactTrackingService.getClicks(contactId, limit, null);
            verify(contactTrackingService).getClicks(contactId, limit, null);

            assertNotNull(contactTrackingClickResultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContactTrackingClicks throws the proper exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactTrackingClicksExceptionTest() {
        String contactId = null;
        int limit = 0;

        try {

            ResultSet contactTrackingBounceResultSet = mock(ResultSet.class);

            contactTrackingBounceResultSet = contactTrackingService.getClicks(contactId, limit, null);
            verify(contactTrackingService).getClicks(contactId, limit, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getContactTrackingForwards from the ConstantContact.class
     */
    @Test
    public void getContactTrackingForwardsTest() {
        String contactId = "1";
        int limit = 1;

        try {

            ResultSet contactTrackingForwardResultSet = mock(ResultSet.class);

            contactTrackingForwardResultSet = contactTrackingService.getForwards(contactId, limit, null);
            verify(contactTrackingService).getForwards(contactId, limit, null);

            assertNotNull(contactTrackingForwardResultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContactTrackingForwards throws the proper exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactTrackingForwardsExceptionTest() {
        String contactId = null;
        int limit = 0;

        try {

            ResultSet contactTrackingBounceResultSet = mock(ResultSet.class);

            contactTrackingBounceResultSet = contactTrackingService.getForwards(contactId, limit, null);
            verify(contactTrackingService).getForwards(contactId, limit, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getContactTrackingOpens from the ConstantContact.class
     */
    @Test
    public void getContactTrackingOpensTest() {
        String contactId = "1";
        int limit = 1;

        try {

            ResultSet contactTrackingOpenResultSet = mock(ResultSet.class);

            contactTrackingOpenResultSet = contactTrackingService.getOpens(contactId, limit, null);
            verify(contactTrackingService).getOpens(contactId, limit, null);

            assertNotNull(contactTrackingOpenResultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContactTrackingOpens throws the proper exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactTrackingOpensExceptionTest() {
        String contactId = null;
        int limit = 0;

        try {

            ResultSet contactTrackingBounceResultSet = mock(ResultSet.class);

            contactTrackingBounceResultSet = contactTrackingService.getOpens(contactId, limit, null);
            verify(contactTrackingService).getOpens(contactId, limit, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getContactTrackingSends method from ConstantContact.class
     */
    @Test
    public void getContactTrackingSendsTest() {
        String contactId = "1";
        int limit = 1;

        try {

            ResultSet contactTrackingSendResultSet = mock(ResultSet.class);

            contactTrackingSendResultSet = contactTrackingService.getSends(contactId, limit, null);
            verify(contactTrackingService).getSends(contactId, limit, null);

            assertNotNull(contactTrackingSendResultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContactTrackingSends throws the proper exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactTrackingSendsExceptionTest() {
        String contactId = null;
        int limit = 0;

        try {

            ResultSet contactTrackingBounceResultSet = mock(ResultSet.class);

            contactTrackingBounceResultSet = contactTrackingService.getSends(contactId, limit, null);
            verify(contactTrackingService).getSends(contactId, limit, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getContactTrackingUnsubscribes method from ConstantContact.class
     */
    @Test
    public void getContactTrackingUnsubscribesTest() {
        String contactId = "1";
        int limit = 1;

        try {

            ResultSet contactTrackingUnsubscribeResultSet = mock(ResultSet.class);

            contactTrackingUnsubscribeResultSet = contactTrackingService.getUnsubscribes(contactId, limit, null);
            verify(contactTrackingService).getUnsubscribes(contactId, limit, null);

            assertNotNull(contactTrackingUnsubscribeResultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContactTrackingUnsubscribes throws the proper exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactTrackingUnsubscribesExceptionTest() {
        String contactId = null;
        int limit = 0;

        try {

            ResultSet contactTrackingBounceResultSet = mock(ResultSet.class);

            contactTrackingBounceResultSet = contactTrackingService.getUnsubscribes(contactId, limit, null);
            verify(contactTrackingService).getUnsubscribes(contactId, limit, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }
}
