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

import com.constantcontact.components.eventspot.Event;
import com.constantcontact.components.eventspot.EventFee;
import com.constantcontact.components.eventspot.EventItem;
import com.constantcontact.components.eventspot.EventItemAttribute;
import com.constantcontact.components.eventspot.Promocode;
import com.constantcontact.components.eventspot.Registrant.RegistrantDetails;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.mockup.ConstantContactFactoryMock;
import com.constantcontact.services.eventspot.IEventSpotService;

/**
 * Created by Cristiana on 2/11/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactEventSpotTest {

	private ConstantContactFactoryMock constantContactFactoryMock;
	private IEventSpotService eventSpotServiceMock;

	private ConstantContactFactory constantContactFactory;
	private IEventSpotService eventSpotService;

	@Before
	public void beforeTests() {
		constantContactFactoryMock = Mockito
				.spy(new ConstantContactFactoryMock("", ""));
		eventSpotServiceMock = constantContactFactoryMock
				.createEventSpotService();

		constantContactFactory = Mockito
				.spy(new ConstantContactFactory("", ""));
		eventSpotService = constantContactFactory.createEventSpotService();
	}

	/**
	 * Tests the getEvent method from ConstantContact.class
	 *
	 */
	@Test
	public void getEventTest() {
		String eventId = "1";

		try {
			Event event = mock(Event.class);

			event = eventSpotServiceMock.getEvent(eventId);
			verify(eventSpotServiceMock).getEvent(eventId);

			assertNotNull(event);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests the getEvents method from ConstantContact.class
	 *
	 */
	@Test
	public void getEventsTest() {
		int limit = 1;

		try {

			ResultSet resultSet = mock(ResultSet.class);

			resultSet = eventSpotServiceMock.getEvents(limit);
			verify(eventSpotServiceMock).getEvents(limit);

			assertNotNull(resultSet);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests the addEvent method from ConstantContact.class
	 *
	 */
	@Test
	public void addEventTest() {
		try {

			Event event = mock(Event.class);

			Event resultEvent = eventSpotServiceMock.addEvent(event);
			verify(eventSpotServiceMock).addEvent(event);

			assertNotNull(resultEvent);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the addEvent method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void addEventExceptionTest() {
		try {

			Event event = null;

			Event resultEvent = eventSpotServiceMock.addEvent(event);
			verify(eventSpotServiceMock).addEvent(event);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the addEvent method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void addEventServiceExceptionTest()
			throws ConstantContactServiceException {
		Event event = new Event();

		Event resultEvent = eventSpotService.addEvent(event);

	}

	/**
	 * Tests the updateEvent method from ConstantContact.class
	 *
	 */
	@Test
	public void updateEventTest() {

		try {

			Event event = mock(Event.class);

			Event resultEvent = eventSpotServiceMock.updateEvent(event);
			verify(eventSpotServiceMock).updateEvent(event);

			assertNotNull(resultEvent);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the updateEvent method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void updateEventExceptionTest() {
		try {

			Event event = null;

			Event resultEvent = eventSpotServiceMock.updateEvent(event);
			verify(eventSpotServiceMock).updateEvent(event);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the updateEvent method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void updateExceptionTest() throws ConstantContactServiceException {

		Event event = new Event();

		Event resultEvent = eventSpotService.updateEvent(event);
	}

	/**
	 * Tests the updateEventStatus method from ConstantContact.class
	 *
	 */
	@Test
	public void updateEventStatusTest() {
		String eventId = "1";
		String status = "test";

		try {

			boolean updated = eventSpotServiceMock.updateEventStatus(eventId,
					status);
			verify(eventSpotServiceMock).updateEventStatus(eventId, status);

			assertTrue(updated);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the updateEventStatus method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void updateEventStatusExpectedTest() {
		String eventId = null;
		String status = null;

		try {

			boolean updated = eventSpotServiceMock.updateEventStatus(eventId,
					status);
			verify(eventSpotServiceMock).updateEventStatus(eventId, status);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the updateEventStatus method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void updateEventStatusServiceExpectedTest()
			throws ConstantContactServiceException {
		String eventId = "1";
		String status = "1";

		boolean updated = eventSpotService.updateEventStatus(eventId, status);
	}

	/**
	 * Tests the getEventFees method from ConstantContact.class
	 *
	 */
	@Test
	public void getEventFeesTest() {
		String eventId = "1";

		try {

			List list = mock(List.class);

			list = eventSpotServiceMock.getEventFees(eventId);
			verify(eventSpotServiceMock).getEventFees(eventId);

			assertNotNull(list);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventFees method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getEventFeesExceptionTest() {
		String eventId = null;

		try {

			List list = mock(List.class);

			list = eventSpotServiceMock.getEventFees(eventId);
			verify(eventSpotServiceMock).getEventFees(eventId);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventFees method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void getEventFeesServiceExceptionTest()
			throws ConstantContactServiceException {
		String eventId = "1";

		List list = new ArrayList<String>();

		list = eventSpotService.getEventFees(eventId);
	}

	/**
	 * Tests the addEventFee method from ConstantContact.class
	 *
	 */
	@Test
	public void addEventFeeTest() {
		String eventId = "1";

		try {

			EventFee eventFee = mock(EventFee.class);

			EventFee resultEventFee = eventSpotServiceMock.addEventFee(eventId,
					eventFee);
			verify(eventSpotServiceMock).addEventFee(eventId, eventFee);

			assertNotNull(resultEventFee);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the updateEvent method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void addEventFeeExpectedTest() {
		String eventId = null;

		try {

			EventFee eventFee = null;

			EventFee resultEventFee = eventSpotServiceMock.addEventFee(eventId,
					eventFee);
			verify(eventSpotServiceMock).addEventFee(eventId, eventFee);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the updateEvent method throws the proper exception
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void addEventFeeServiceExpectedTest()
			throws ConstantContactServiceException {
		String eventId = "1";
		EventFee eventFee = new EventFee();

		EventFee resultEventFee = eventSpotService.addEventFee(eventId,
				eventFee);
	}

	/**
	 * Tests the getEventFee method from ConstantContact.class
	 *
	 */
	@Test
	public void getEventFeeTest() {
		String eventId = "1";
		String eventFeeId = "1";
		EventFee eventFee = mock(EventFee.class);

		try {

			eventFee = eventSpotServiceMock.getEventFee(eventId, eventFeeId);
			verify(eventSpotServiceMock).getEventFee(eventId, eventFeeId);

			assertNotNull(eventFee);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventFee method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getEventFeeExceptionTest() {
		String eventId = null;
		String eventFeeId = null;
		EventFee eventFee = mock(EventFee.class);

		try {

			eventFee = eventSpotServiceMock.getEventFee(eventId, eventFeeId);
			verify(eventSpotServiceMock).getEventFee(eventId, eventFeeId);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventFee method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void getEventFeeServiceExceptionTest()
			throws ConstantContactServiceException {
		String eventId = "1";
		String eventFeeId = "1";

		EventFee eventFee = new EventFee();

		eventFee = eventSpotService.getEventFee(eventId, eventFeeId);

	}

	/**
	 * Tests the updateEventFee method from ConstantContact.class
	 *
	 */
	@Test
	public void updateEventFeeTest() {
		String eventId = "1";
		EventFee eventFee = new EventFee();
		eventFee.setId("1");

		try {

			EventFee resultEventFee = eventSpotServiceMock.updateEventFee(
					eventId, eventFee);
			verify(eventSpotServiceMock).updateEventFee(eventId, eventFee);

			assertNotNull(resultEventFee);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the updateEventFee method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void updateEventFeeExceptionTest() {
		String eventId = null;
		EventFee eventFee = null;

		try {

			EventFee resultEventFee = eventSpotServiceMock.updateEventFee(
					eventId, eventFee);
			verify(eventSpotServiceMock).updateEventFee(eventId, eventFee);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the updateEventFee method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void updateEventFeeServiceExceptionTest()
			throws ConstantContactServiceException {
		String eventId = "1";
		EventFee eventFee = new EventFee();
		eventFee.setId(eventId);

		EventFee resultEventFee = eventSpotService.updateEventFee(eventId,
				eventFee);
	}

	/**
	 * Tests the deleteEventFee method from ConstantContact.class
	 *
	 */
	@Test
	public void deleteEventFeeTest() {
		String eventId = "1";
		EventFee eventFee = new EventFee();
		String eventFeeId = "1";
		eventFee.setId(eventFeeId);

		try {

			boolean deleted = eventSpotServiceMock.deleteEventFee(eventId,
					eventFeeId);
			verify(eventSpotServiceMock).deleteEventFee(eventId, eventFeeId);

			assertTrue(deleted);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the deleteEventFee method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void deleteEventFeeExceptionTest() {
		String eventId = null;
		EventFee eventFee = mock(EventFee.class);

		try {

			boolean deleted = eventSpotServiceMock.deleteEventFee(eventId,
					eventFee.getId());
			verify(eventSpotServiceMock).deleteEventFee(eventId,
					eventFee.getId());

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the deleteEventFee method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void deleteEventFeeServiceExceptionTest()
			throws ConstantContactServiceException {
		String eventId = "1";
		EventFee eventFee = new EventFee();
		eventFee.setId(eventId);

		boolean deleted = eventSpotService.deleteEventFee(eventId,
				eventFee.getId());
	}

	/**
	 * Tests the getEventPromocodes method from ConstantContact.class
	 *
	 */
	@Test
	public void getEventPromocodesTest() {
		String eventId = "1";
		List list = mock(List.class);

		try {

			list = eventSpotServiceMock.getEventPromocodes(eventId);
			verify(eventSpotServiceMock).getEventPromocodes(eventId);

			assertNotNull(list);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventPromocodes method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getEventPromocodesExceptionTest() {
		String eventId = null;
		List list = mock(List.class);

		try {

			list = eventSpotServiceMock.getEventPromocodes(eventId);
			verify(eventSpotServiceMock).getEventPromocodes(eventId);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventPromocodes method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void getEventPromocodesServiceExceptionTest()
			throws ConstantContactServiceException {
		String eventId = "1";
		List list = new ArrayList<String>();

		list = eventSpotService.getEventPromocodes(eventId);

	}

	/**
	 * Tests the addEventPromocode method from ConstantContact.class
	 *
	 */
	@Test
	public void addEventPromocodeTest() {
		String eventId = "1";
		Promocode promocode = mock(Promocode.class);

		try {

			Promocode resultPromocode = eventSpotServiceMock.addEventPromocode(
					eventId, promocode);
			verify(eventSpotServiceMock).addEventPromocode(eventId, promocode);

			assertNotNull(resultPromocode);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the addEventPromocode method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void addEventPromocodeExceptionTest() {
		String eventId = null;
		Promocode promocode = null;

		try {

			Promocode resultPromocode = eventSpotServiceMock.addEventPromocode(
					eventId, promocode);
			verify(eventSpotServiceMock).addEventPromocode(eventId, promocode);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the addEventPromocode method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void addEventPromocodeServiceExceptionTest()
			throws ConstantContactServiceException {
		String eventId = "1";
		Promocode promocode = new Promocode();

		Promocode resultPromocode = eventSpotService.addEventPromocode(eventId,
				promocode);

	}

	/**
	 * Tests the getEventPromocode method from ConstantContact.class
	 *
	 */
	@Test
	public void getEventPromocodeTest() {
		String eventId = "1";
		String promocodeId = "1";
		Promocode promocode = mock(Promocode.class);

		try {

			promocode = eventSpotServiceMock.getEventPromocode(eventId,
					promocodeId);
			verify(eventSpotServiceMock)
					.getEventPromocode(eventId, promocodeId);

			assertNotNull(promocode);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventPromocode method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getEventPromocodeExceptionTest() {
		String eventId = null;
		String promocodeId = null;
		Promocode promocode = mock(Promocode.class);

		try {

			promocode = eventSpotServiceMock.getEventPromocode(eventId,
					promocodeId);
			verify(eventSpotServiceMock)
					.getEventPromocode(eventId, promocodeId);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventPromocode method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void getEventPromocodeServiceExceptionTest()
			throws ConstantContactServiceException {
		String eventId = "1";
		String promocodeId = "1";
		Promocode promocode = new Promocode();

		promocode = eventSpotService.getEventPromocode(eventId, promocodeId);

	}

	/**
	 * Tests the updateEventPromocode method from ConstantContact.class
	 *
	 */
	@Test
	public void updateEventPromocodeTest() {
		String eventId = "1";
		Promocode promocode = new Promocode();
		promocode.setId("1");

		try {

			Promocode resultPromocode = eventSpotServiceMock
					.updateEventPromocode(eventId, promocode);
			verify(eventSpotServiceMock).updateEventPromocode(eventId,
					promocode);

			assertNotNull(resultPromocode);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventPromocode method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void updateEventPromocodeExceptionTest() {
		String eventId = null;
		Promocode promocode = null;

		try {

			Promocode resultPromocode = eventSpotServiceMock
					.updateEventPromocode(eventId, promocode);
			verify(eventSpotServiceMock).updateEventPromocode(eventId,
					promocode);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventPromocode method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void updateEventPromocodeServiceExceptionTest()
			throws ConstantContactServiceException {
		String eventId = "1";
		Promocode promocode = new Promocode();
		promocode.setId(eventId);

		Promocode resultPromocode = eventSpotService.updateEventPromocode(
				eventId, promocode);

	}

	/**
	 * Tests the deleteEventPromocode method from ConstantContact.class
	 *
	 */
	@Test
	public void deleteEventPromocodeTest() {
		String eventId = "1";
		Promocode promocode = new Promocode();
		String promocodeId = "1";
		promocode.setId(promocodeId);

		try {

			boolean deleted = eventSpotServiceMock.deleteEventPromocode(
					eventId, promocodeId);
			verify(eventSpotServiceMock).deleteEventPromocode(eventId,
					promocodeId);

			assertTrue(deleted);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the deleteEventPromocode method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void deleteEventPromocodeExceptionTest() {
		String eventId = null;
		String promocodeId = null;

		try {

			boolean deleted = eventSpotServiceMock.deleteEventPromocode(
					eventId, promocodeId);
			verify(eventSpotServiceMock).deleteEventPromocode(eventId,
					promocodeId);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the deleteEventPromocode method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void deleteEventPromocodeServiceExceptionTest()
			throws ConstantContactServiceException {
		String eventId = "1";
		String promocodeId = "1";

		boolean deleted = eventSpotService.deleteEventPromocode(eventId,
				promocodeId);
	}

	/**
	 * Tests the getEventRegistrants method from ConstantContact.class
	 *
	 */
	@Test
	public void getEventRegistrantsTest() {
		String eventId = "1";
		int limit = 1;

		try {

			ResultSet resultSet = mock(ResultSet.class);

			resultSet = eventSpotServiceMock
					.getEventRegistrants(eventId, limit);
			verify(eventSpotServiceMock).getEventRegistrants(eventId, limit);

			assertNotNull(resultSet);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventRegistrants method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getEventRegistrantsExceptionTest() {
		String eventId = null;
		int limit = 0;

		try {

			ResultSet resultSet = mock(ResultSet.class);

			resultSet = eventSpotServiceMock
					.getEventRegistrants(eventId, limit);
			verify(eventSpotServiceMock).getEventRegistrants(eventId, limit);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventRegistrants method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void getEventRegistrantsServiceExceptionTest()
			throws ConstantContactServiceException {
		String eventId = "1";
		int limit = 1;

		ResultSet resultSet = mock(ResultSet.class);

		resultSet = eventSpotService.getEventRegistrants(eventId, limit);

	}

	/**
	 * Tests the getEventRegistrant method from ConstantContact.class
	 *
	 */
	@Test
	public void getEventRegistrantTest() {
		String eventId = "1";
		String eventRegistrantId = "1";

		try {

			RegistrantDetails registrantDetails = mock(RegistrantDetails.class);

			registrantDetails = eventSpotServiceMock.getEventRegistrant(
					eventId, eventRegistrantId);
			verify(eventSpotServiceMock).getEventRegistrant(eventId,
					eventRegistrantId);

			assertNotNull(registrantDetails);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventRegistrant method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getEventRegistrantExceptionTest() {
		String eventId = null;
		String eventRegistrantId = null;

		try {

			RegistrantDetails registrantDetails = mock(RegistrantDetails.class);

			registrantDetails = eventSpotServiceMock.getEventRegistrant(
					eventId, eventRegistrantId);
			verify(eventSpotServiceMock).getEventRegistrant(eventId,
					eventRegistrantId);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventRegistrant method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void getEventRegistrantServiceExceptionTest()
			throws ConstantContactServiceException {
		String eventId = "1";
		String eventRegistrantId = "1";

		RegistrantDetails registrantDetails = mock(RegistrantDetails.class);

		registrantDetails = eventSpotService.getEventRegistrant(eventId,
				eventRegistrantId);

	}

	/**
	 * Tests the getEventItems method from ConstantContact.class
	 *
	 */
	@Test
	public void getEventItemsTest() {
		String eventId = "1";

		try {

			List list = mock(List.class);

			list = eventSpotServiceMock.getEventItems(eventId);
			verify(eventSpotServiceMock).getEventItems(eventId);

			assertNotNull(list);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventItems method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getEventItemsExceptionTest() {
		String eventId = null;

		try {

			List list = mock(List.class);

			list = eventSpotServiceMock.getEventItems(eventId);
			verify(eventSpotServiceMock).getEventItems(eventId);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventItems method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void getEventItemsServiceExceptionTest()
			throws ConstantContactServiceException {
		String eventId = "1";

		List list = new ArrayList<String>();

		list = eventSpotService.getEventItems(eventId);
	}

	/**
	 * Tests the getEventItem method from ConstantContact.class
	 *
	 */
	@Test
	public void getEventItemTest() {
		String eventId = "1";
		String itemId = "1";

		try {

			EventItem eventItem = mock(EventItem.class);

			eventItem = eventSpotServiceMock.getEventItem(eventId, itemId);
			verify(eventSpotServiceMock).getEventItem(eventId, itemId);

			assertNotNull(eventItem);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventItem method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getEventItemExceptionTest() {
		String eventId = null;
		String itemId = null;

		try {

			EventItem eventItem = mock(EventItem.class);

			eventItem = eventSpotServiceMock.getEventItem(eventId, itemId);
			verify(eventSpotServiceMock).getEventItem(eventId, itemId);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests the addEventItem method from ConstantContact.class
	 *
	 */
	@Test
	public void addEventItemTest() {
		String eventId = "1";

		try {

			EventItem eventItem = mock(EventItem.class);

			EventItem resultEventItem = eventSpotServiceMock.addEventItem(
					eventId, eventItem);
			verify(eventSpotServiceMock).addEventItem(eventId, eventItem);

			assertNotNull(resultEventItem);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the addEventItem method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void addEventItemExceptionTest() {
		String eventId = null;

		try {

			EventItem eventItem = null;

			EventItem resultEventItem = eventSpotServiceMock.addEventItem(
					eventId, eventItem);
			verify(eventSpotServiceMock).addEventItem(eventId, eventItem);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests the updateEventItem method from ConstantContact.class
	 *
	 */
	@Test
	public void updateEventItemTest() {
		String eventId = "1";

		try {

			EventItem eventItem = new EventItem();
			eventItem.setId("1");

			EventItem resultEventItem = eventSpotServiceMock.updateEventItem(
					eventId, eventItem);
			verify(eventSpotServiceMock).updateEventItem(eventId, eventItem);

			assertNotNull(resultEventItem);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the updateEventItem method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void updateEventItemExceptionTest() {
		String eventId = null;

		try {

			EventItem eventItem = null;

			EventItem resultEventItem = eventSpotServiceMock.updateEventItem(
					eventId, eventItem);
			verify(eventSpotServiceMock).updateEventItem(eventId, eventItem);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the updateEventItem method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void updateEventItemServiceExceptionTest()
			throws ConstantContactServiceException {
		String eventId = "1";

		EventItem eventItem = new EventItem();
		eventItem.setId(eventId);

		EventItem resultEventItem = eventSpotService.updateEventItem(eventId,
				eventItem);

	}

	/**
	 * Tests the deleteEventItem method from ConstantContact.class
	 *
	 */
	@Test
	public void deleteEventItemTest() {
		String eventId = "1";
		String eventItemId = "1";
		EventItem eventItem = new EventItem();
		eventItem.setId(eventItemId);

		try {

			boolean deleted = eventSpotServiceMock.deleteEventItem(eventId,
					eventItemId);
			verify(eventSpotServiceMock).deleteEventItem(eventId, eventItemId);

			assertTrue(deleted);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the deleteEventItem method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void deleteEventItemExceptionTest() {
		String eventId = null;
		String eventItemId = null;
		EventItem eventItem = null;

		try {

			boolean deleted = eventSpotServiceMock.deleteEventItem(eventId,
					eventItemId);
			verify(eventSpotServiceMock).deleteEventItem(eventId, eventItemId);

			assertTrue(deleted);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the deleteEventItem method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void deleteEventItemServiceExceptionTest()
			throws ConstantContactServiceException {
		String eventId = "1";
		String eventItemId = "1";

		boolean deleted = eventSpotService
				.deleteEventItem(eventId, eventItemId);

	}

	/**
	 * Tests the getEventItemAttributes method from ConstantContact.class
	 *
	 */
	@Test
	public void getEventItemAttributesTest() {
		String eventId = "1";
		String itemId = "1";
		List list = mock(List.class);

		try {

			list = eventSpotServiceMock.getEventItemAttributes(eventId, itemId);
			verify(eventSpotServiceMock)
					.getEventItemAttributes(eventId, itemId);

			assertNotNull(list);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventItemAttributes method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getEventItemAttributesExceptionTest() {
		String eventId = null;
		String itemId = null;
		List list = mock(List.class);

		try {

			list = eventSpotServiceMock.getEventItemAttributes(eventId, itemId);
			verify(eventSpotServiceMock)
					.getEventItemAttributes(eventId, itemId);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventItemAttributes method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void getEventItemAttributesServiceExceptionTest()
			throws ConstantContactServiceException {
		String eventId = "1";
		String itemId = "1";
		List list = new ArrayList<String>();

		list = eventSpotService.getEventItemAttributes(eventId, itemId);

	}

	/**
	 * Tests the getEventItemAttribute method from ConstantContact.class
	 *
	 */
	@Test
	public void getEventItemAttributeTest() {
		String eventId = "1";
		String itemId = "1";
		String attributeId = "1";
		EventItemAttribute eventItemAttribute = mock(EventItemAttribute.class);

		try {

			eventItemAttribute = eventSpotServiceMock.getEventItemAttribute(
					eventId, itemId, attributeId);
			verify(eventSpotServiceMock).getEventItemAttribute(eventId, itemId,
					attributeId);

			assertNotNull(eventItemAttribute);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the getEventItemAttribute method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getEventItemAttributeExceptionTest() {
		String eventId = null;
		String itemId = null;
		String attributeId = null;
		EventItemAttribute eventItemAttribute = mock(EventItemAttribute.class);

		try {

			eventItemAttribute = eventSpotServiceMock.getEventItemAttribute(
					eventId, itemId, attributeId);
			verify(eventSpotServiceMock).getEventItemAttribute(eventId, itemId,
					attributeId);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests the addEventItemAttribute method from ConstantContact.class
	 *
	 */
	@Test
	public void addEventItemAttributeTest() {
		String eventId = "1";
		String itemId = "1";

		try {

			EventItemAttribute eventItemAttribute = mock(EventItemAttribute.class);

			EventItemAttribute resultEventItemAttribute = eventSpotServiceMock
					.addEventItemAttribute(eventId, itemId, eventItemAttribute);
			verify(eventSpotServiceMock).addEventItemAttribute(eventId, itemId,
					eventItemAttribute);

			assertNotNull(resultEventItemAttribute);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the addEventItemAttribute method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void addEventItemAttributeExceptionTest() {
		String eventId = null;
		String itemId = null;

		try {

			EventItemAttribute eventItemAttribute = null;

			EventItemAttribute resultEventItemAttribute = eventSpotServiceMock
					.addEventItemAttribute(eventId, itemId, eventItemAttribute);
			verify(eventSpotServiceMock).addEventItemAttribute(eventId, itemId,
					eventItemAttribute);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests the updateEventItemAttribute method from ConstantContact.class
	 *
	 */
	@Test
	public void updateEventItemAttributeTest() {
		String eventId = "1";
		String itemId = "1";

		try {

			EventItemAttribute eventItemAttribute = mock(EventItemAttribute.class);

			EventItemAttribute resultEventItemAttribute = eventSpotServiceMock
					.updateEventItemAttribute(eventId, itemId,
							eventItemAttribute);
			verify(eventSpotServiceMock).updateEventItemAttribute(eventId,
					itemId, eventItemAttribute);

			assertNotNull(resultEventItemAttribute);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the addEventItemAttribute method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void updateEventItemAttributeExceptionTest() {
		String eventId = null;
		String itemId = null;

		try {

			EventItemAttribute eventItemAttribute = null;

			EventItemAttribute resultEventItemAttribute = eventSpotServiceMock
					.updateEventItemAttribute(eventId, itemId,
							eventItemAttribute);
			verify(eventSpotServiceMock).updateEventItemAttribute(eventId,
					itemId, eventItemAttribute);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests the deleteEventItemAttribute method from ConstantContact.class
	 *
	 */
	@Test
	public void deleteEventItemAttributeTest() {
		String eventId = "1";
		String itemId = "1";
		String eventItemAttributeId = "1";

		try {

			boolean deleted = eventSpotServiceMock.deleteEventItemAttribute(
					eventId, itemId, eventItemAttributeId);
			verify(eventSpotServiceMock).deleteEventItemAttribute(eventId,
					itemId, eventItemAttributeId);

			assertTrue(deleted);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the addEventItemAttribute method throws the proper exception
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void deleteEventItemAttributeExceptionTest() {
		String eventId = null;
		String itemId = null;
		String eventItemAttributeId = null;

		try {

			boolean deleted = eventSpotServiceMock.deleteEventItemAttribute(
					eventId, itemId, eventItemAttributeId);
			verify(eventSpotServiceMock).deleteEventItemAttribute(eventId,
					itemId, eventItemAttributeId);

		} catch (ConstantContactServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests that the addEventItemAttribute method throws the proper exception
	 * 
	 * @throws ConstantContactServiceException
	 *
	 */
	@Test(expected = ConstantContactServiceException.class)
	public void deleteEventItemAttributeServiceExceptionTest()
			throws ConstantContactServiceException {
		String eventId = "1";
		String itemId = "1";
		String eventItemAttributeId = "1";

		boolean deleted = eventSpotService.deleteEventItemAttribute(eventId,
				itemId, eventItemAttributeId);
	}

}
