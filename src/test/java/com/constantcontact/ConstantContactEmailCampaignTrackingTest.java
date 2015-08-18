package com.constantcontact;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.constantcontact.components.emailcampaigns.tracking.reports.summary.EmailCampaignTrackingSummary;
import com.constantcontact.components.generic.response.Pagination;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.mockup.ConstantContactFactoryMock;
import com.constantcontact.services.emailcampaigns.tracking.IEmailCampaignTrackingService;

/**
 * Constant Contact email campaign tracking unit test class.<br/>
 *
 * @author ConstantContact
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactEmailCampaignTrackingTest {

	private ConstantContactFactoryMock constantContactFactoryMock;
	private IEmailCampaignTrackingService emailCampaignTrackingServiceMock;

	private ConstantContactFactory constantContactFactory;
	private IEmailCampaignTrackingService emailCampaignTrackingService;

	@Before
	public void beforeTests() {
		constantContactFactoryMock = Mockito
				.spy(new ConstantContactFactoryMock("", ""));
		emailCampaignTrackingServiceMock = constantContactFactoryMock
				.createEmailCampaignTrackingService();

		constantContactFactory = Mockito
				.spy(new ConstantContactFactory("", ""));
		emailCampaignTrackingService = constantContactFactory
				.createEmailCampaignTrackingService();
	}

	/**
	 * Tests the retrieving of the email campaign tracking summary
	 */
	@Test
	public void getEmailCampaignTrackingSummaryTest() {

		String emailCampaignId = "1";
		try {
			EmailCampaignTrackingSummary emailCampaignTrackingSummary = new EmailCampaignTrackingSummary();

			emailCampaignTrackingSummary = emailCampaignTrackingServiceMock
					.getSummary(emailCampaignId, null);
			verify(emailCampaignTrackingServiceMock).getSummary(
					emailCampaignId, null);

			assertNotNull(emailCampaignTrackingSummary);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEmailCampaignTrackingSummary method throws the proper
	 * exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getEmailCampaignTrackingSummaryExceptionTest() {

		String emailCampaignId = null;
		try {
			EmailCampaignTrackingSummary emailCampaignTrackingSummary = null;

			emailCampaignTrackingSummary = emailCampaignTrackingServiceMock
					.getSummary(emailCampaignId, null);
			verify(emailCampaignTrackingServiceMock).getSummary(
					emailCampaignId, null);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEmailCampaignTrackingSummary method throws the proper
	 * exception
	 * 
	 * @throws ConstantContactServiceException
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void getEmailCampaignTrackingSummaryServiceExceptionTest()
			throws ConstantContactServiceException {

		String emailCampaignId = "1";

		EmailCampaignTrackingSummary emailCampaignTrackingSummary = new EmailCampaignTrackingSummary();

		emailCampaignTrackingSummary = emailCampaignTrackingService.getSummary(
				emailCampaignId, null);

	}

	/**
	 * Tests the retrieving of the email campaign bounces
	 */
	@Test
	public void getEmailCampaignTrackingBouncesTest() {
		String emailCampaignId = "1";

		try {

			ResultSet resultSet = new ResultSet();

			resultSet = emailCampaignTrackingServiceMock.getBounces(
					emailCampaignId, 1);
			verify(emailCampaignTrackingServiceMock).getBounces(
					emailCampaignId, 1);

			assertNotNull(resultSet);

		} catch (ConstantContactServiceException e) {
			System.out.println(e.getErrorInfo());
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEmailCampaignTrackingBounces method throws the proper
	 * exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getEmailCampaignTrackingBouncesExceptionTest() {
		String emailCampaignId = null;

		try {

			ResultSet resultSet = new ResultSet();

			resultSet = emailCampaignTrackingServiceMock.getBounces(
					emailCampaignId, 1);
			verify(emailCampaignTrackingServiceMock).getBounces(
					emailCampaignId, 1);

		} catch (ConstantContactServiceException e) {
			System.out.println(e.getErrorInfo());
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEmailCampaignTrackingBounces method throws the proper
	 * exception
	 * 
	 * @throws ConstantContactServiceException
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void getEmailCampaignTrackingBouncesServiceExceptionTest()
			throws ConstantContactServiceException {
		String emailCampaignId = "1";

		ResultSet resultSet = new ResultSet();

		resultSet = emailCampaignTrackingService.getBounces(emailCampaignId, 1);

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

			resultSet = emailCampaignTrackingServiceMock.getClicks(
					emailCampaignId, 1, null);
			verify(emailCampaignTrackingServiceMock).getClicks(emailCampaignId,
					1, null);

			assertNotNull(resultSet);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
			System.out.println(e.getErrorInfo());
		}
	}

	/**
	 * Tests that the getEmailCampaignTrackingClicks method throws the proper
	 * exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getEmailCampaignTrackingClicksExceptionTest() {
		String emailCampaignId = null;

		try {

			ResultSet resultSet = new ResultSet();

			resultSet = emailCampaignTrackingServiceMock.getClicks(
					emailCampaignId, 1, null);
			verify(emailCampaignTrackingServiceMock).getClicks(emailCampaignId,
					1, null);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
			System.out.println(e.getErrorInfo());
		}
	}

	/**
	 * Tests that the getEmailCampaignTrackingClicks method throws the proper
	 * exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void getEmailCampaignTrackingClicksServiceExceptionTest()
			throws ConstantContactServiceException {
		String emailCampaignId = "1";

		ResultSet resultSet = new ResultSet();

		resultSet = emailCampaignTrackingService.getClicks(emailCampaignId, 1,
				null);
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

			resultSet = emailCampaignTrackingServiceMock.getOpens(
					emailCampaignId, 1, null);
			verify(emailCampaignTrackingServiceMock).getOpens(emailCampaignId,
					1, null);

			assertNotNull(resultSet);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
			System.out.println(e.getErrorInfo());
		}
	}

	/**
	 * Tests that the getEmailCampaignTrackingOpens method throws the proper
	 * exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getEmailCampaignTrackingOpensExceptionTest() {
		String emailCampaignId = null;

		try {

			ResultSet resultSet = new ResultSet();

			resultSet = emailCampaignTrackingServiceMock.getOpens(
					emailCampaignId, 1, null);
			verify(emailCampaignTrackingServiceMock).getOpens(emailCampaignId,
					1, null);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
			System.out.println(e.getErrorInfo());
		}
	}

	/**
	 * Tests that the getEmailCampaignTrackingOpens method throws the proper
	 * exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void getEmailCampaignTrackingOpensServiceExceptionTest()
			throws ConstantContactServiceException {
		String emailCampaignId = "1";

		ResultSet resultSet = new ResultSet();

		resultSet = emailCampaignTrackingService.getOpens(emailCampaignId, 1,
				null);
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

			resultSet = emailCampaignTrackingServiceMock.getSends(
					emailCampaignId, 1, null);
			verify(emailCampaignTrackingServiceMock).getSends(emailCampaignId,
					1, null);

			assertNotNull(resultSet);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
			System.out.println(e.getErrorInfo());
		}
	}

	/**
	 * Tests that the getEmailCampaignTrackingSends method throws the proper
	 * exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getEmailCampaignTrackingSendsExceptionTest() {
		String emailCampaignId = null;

		try {

			ResultSet resultSet = new ResultSet();

			resultSet = emailCampaignTrackingServiceMock.getSends(
					emailCampaignId, 1, null);
			verify(emailCampaignTrackingServiceMock).getSends(emailCampaignId,
					1, null);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
			System.out.println(e.getErrorInfo());
		}
	}

	/**
	 * Tests that the getEmailCampaignTrackingSends method throws the proper
	 * exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void getEmailCampaignTrackingSendsServiceExceptionTest()
			throws ConstantContactServiceException {
		String emailCampaignId = "1";

		ResultSet resultSet = new ResultSet();

		resultSet = emailCampaignTrackingService.getSends(emailCampaignId, 1,
				null);
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

			resultSet = emailCampaignTrackingServiceMock.getForwards(
					emailCampaignId, 1, null);
			verify(emailCampaignTrackingServiceMock).getForwards(
					emailCampaignId, 1, null);

			assertNotNull(resultSet);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
			System.out.println(e.getErrorInfo());
		}
	}

	/**
	 * Tests that the getEmailCampaignTrackingForwards method throws the proper
	 * exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getEmailCampaignTrackingForwardsExceptionTest() {
		String emailCampaignId = null;

		try {

			ResultSet resultSet = new ResultSet();

			resultSet = emailCampaignTrackingServiceMock.getForwards(
					emailCampaignId, 1, null);
			verify(emailCampaignTrackingServiceMock).getForwards(
					emailCampaignId, 1, null);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
			System.out.println(e.getErrorInfo());
		}
	}

	/**
	 * Tests that the getEmailCampaignTrackingForwards method throws the proper
	 * exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void getEmailCampaignTrackingForwardsServiceExceptionTest()
			throws ConstantContactServiceException {
		String emailCampaignId = "1";

		ResultSet resultSet = new ResultSet();

		resultSet = emailCampaignTrackingService.getForwards(emailCampaignId,
				1, null);
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

			resultSet = emailCampaignTrackingServiceMock.getUnsubscribes(
					campaignId, 1, null);
			verify(emailCampaignTrackingServiceMock).getUnsubscribes(
					campaignId, 1, null);

			assertNotNull(resultSet);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
			System.out.print(e.getErrorInfo());
		}
	}

	/**
	 * Tests that the getEmailCampaignTrackingUnsubscribes method throws the
	 * proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getEmailCampaignTrackingUnsubscribesExceptionTest() {
		String emailCampaignId = null;

		try {

			ResultSet resultSet = new ResultSet();

			resultSet = emailCampaignTrackingServiceMock.getUnsubscribes(
					emailCampaignId, 1, null);
			verify(emailCampaignTrackingServiceMock).getUnsubscribes(
					emailCampaignId, 1, null);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
			System.out.println(e.getErrorInfo());
		}
	}

	/**
	 * Tests that the getEmailCampaignTrackingUnsubscribes method throws the
	 * proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void getEmailCampaignTrackingUnsubscribesServiceExceptionTest()
			throws ConstantContactServiceException {
		String emailCampaignId = "1";
		ResultSet resultSet = new ResultSet();

		resultSet = emailCampaignTrackingService.getUnsubscribes(
				emailCampaignId, 1, null);
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

			resultSet = emailCampaignTrackingServiceMock.getClicksByLinkId(
					campaignId, linkId, 1, null);
			verify(emailCampaignTrackingServiceMock).getClicksByLinkId(
					campaignId, linkId, 1, null);

			assertNotNull(resultSet);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
			System.out.print(e.getErrorInfo());
		}
	}

	/**
	 * Tests that the getEmailCampaignTrackingClicksByLink method throws the
	 * proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getEmailCampaignTrackingClicksByLinkExceptionTest() {
		String campaignId = null;
		String linkId = null;

		try {

			ResultSet resultSet = new ResultSet();

			resultSet = emailCampaignTrackingServiceMock.getClicksByLinkId(
					campaignId, linkId, 1, null);
			verify(emailCampaignTrackingServiceMock).getClicksByLinkId(
					campaignId, linkId, 1, null);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
			System.out.println(e.getErrorInfo());
		}
	}

	/**
	 * Tests that the getEmailCampaignTrackingClicksByLink method throws the
	 * proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void getEmailCampaignTrackingClicksByLinkServiceExceptionTest()
			throws ConstantContactServiceException {
		String campaignId = "1";
		String linkId = "2";

		ResultSet resultSet = new ResultSet();

		resultSet = emailCampaignTrackingService.getClicksByLinkId(campaignId,
				linkId, 1, null);

	}

    /**
     * Tests the retrieving of the email campaign pagination
     *
     */
    @Test
    public void getEmailCampaignTrackingPaginationTest() {
        String emailCampaignId = "1";
        Pagination pagination = new Pagination();
        pagination.setNextLink("link");

        try {

            ResultSet resultSet = new ResultSet();

            resultSet = emailCampaignTrackingServiceMock.getClicks(pagination);
            verify(emailCampaignTrackingServiceMock).getClicks(pagination);

            assertNotNull(resultSet);

            resultSet = emailCampaignTrackingServiceMock.getForwards(pagination);
            verify(emailCampaignTrackingServiceMock).getForwards(pagination);

            assertNotNull(resultSet);

            resultSet = emailCampaignTrackingServiceMock.getOpens(pagination);
            verify(emailCampaignTrackingServiceMock).getOpens(pagination);

            assertNotNull(resultSet);


            resultSet = emailCampaignTrackingServiceMock.getBounces(pagination);
            verify(emailCampaignTrackingServiceMock).getBounces(pagination);

            assertNotNull(resultSet);


            resultSet = emailCampaignTrackingServiceMock.getUnsubscribes(pagination);
            verify(emailCampaignTrackingServiceMock).getUnsubscribes(pagination);

            assertNotNull(resultSet);


            resultSet = emailCampaignTrackingServiceMock.getSends(pagination);
            verify(emailCampaignTrackingServiceMock).getSends(pagination);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the retrieving of the email campaign pagination
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEmailCampaignTrackingClicksPaginationTestException() throws ConstantContactServiceException {
        Pagination pagination = null;

        ResultSet resultSet = emailCampaignTrackingServiceMock.getClicks(pagination);
        verify(emailCampaignTrackingServiceMock).getClicks(pagination);

        assertNotNull(resultSet);
    }

    /**
     * Tests the retrieving of the email campaign pagination
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEmailCampaignTrackingForwardsPaginationTestException() throws ConstantContactServiceException {
        Pagination pagination = null;

        ResultSet resultSet = emailCampaignTrackingServiceMock.getForwards(pagination);
        verify(emailCampaignTrackingServiceMock).getForwards(pagination);

        assertNotNull(resultSet);
    }

    /**
     * Tests the retrieving of the email campaign pagination
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEmailCampaignTrackingOpensPaginationTestException() throws ConstantContactServiceException {
        Pagination pagination = null;

        ResultSet resultSet = emailCampaignTrackingServiceMock.getOpens(pagination);
        verify(emailCampaignTrackingServiceMock).getOpens(pagination);

        assertNotNull(resultSet);
    }

    /**
     * Tests the retrieving of the email campaign pagination
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEmailCampaignTrackingSendsPaginationTestException() throws ConstantContactServiceException {
        Pagination pagination = null;

        ResultSet resultSet = emailCampaignTrackingServiceMock.getSends(pagination);
        verify(emailCampaignTrackingServiceMock).getSends(pagination);

        assertNotNull(resultSet);
    }

    /**
     * Tests the retrieving of the email campaign pagination
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEmailCampaignTrackingBouncesPaginationTestException() throws ConstantContactServiceException {
        Pagination pagination = null;

        ResultSet resultSet = emailCampaignTrackingServiceMock.getBounces(pagination);
        verify(emailCampaignTrackingServiceMock).getBounces(pagination);

        assertNotNull(resultSet);
    }

    /**
     * Tests the retrieving of the email campaign pagination
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEmailCampaignTrackingUnsubscribesPaginationTestException() throws ConstantContactServiceException {
        Pagination pagination = null;

        ResultSet resultSet = emailCampaignTrackingServiceMock.getUnsubscribes(pagination);
        verify(emailCampaignTrackingServiceMock).getUnsubscribes(pagination);

        assertNotNull(resultSet);
    }

}
