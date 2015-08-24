package com.constantcontact.mockup;

import java.util.List;

import com.constantcontact.components.Component;
import com.constantcontact.components.eventspot.Event;
import com.constantcontact.components.eventspot.EventFee;
import com.constantcontact.components.eventspot.EventItem;
import com.constantcontact.components.eventspot.EventItemAttribute;
import com.constantcontact.components.eventspot.Promocode;
import com.constantcontact.components.eventspot.Registrant.Registrant;
import com.constantcontact.components.eventspot.Registrant.RegistrantDetails;
import com.constantcontact.components.generic.response.Pagination;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.eventspot.EventSpotService;
import com.constantcontact.util.Config;
import com.constantcontact.util.ConstantContactExceptionFactory;
import com.constantcontact.util.RawApiResponse;

/**
 * {@link EventSpotServiceMock} class in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class EventSpotServiceMock extends EventSpotService {

	private String accessToken;
	private String apiKey;
	
	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * @param apiKey the apiKey to set
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	/**
	 * Gets all the Events.<br/>
	 * Implements the get Events operation of the EventSpot API by calling the
	 * ConstantContact server side.
	 * 
	 * @param limit
	 *            The limit
	 * @return A
	 *         {@link com.constantcontact.components.generic.response.ResultSet}
	 *         of {@link com.constantcontact.components.eventspot.Event}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */
	@Override
	public ResultSet<Event> getEvents(Integer limit)
			throws ConstantContactServiceException {
		ResultSet<Event> events = null;
		try {
			events = Component.resultSetFromJSON(
					MockedServerResponses.getEventsEventSpotServiceData,
					Event.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return events;
	}

    /**
     * Gets all the Events.<br/>
     * Implements the get Events operation of the EventSpot API by calling the ConstantContact server side.
     *
     * @param pagination A {@link com.constantcontact.components.generic.response.Pagination} instance containing the link to the next page of results.
     *                   An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public ResultSet<Event> getEvents(Pagination pagination) throws ConstantContactServiceException {
        if (pagination == null || pagination.getNextLink() == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
        }

        ResultSet<Event> events = null;
        try {
            events = Component.resultSetFromJSON(
                    MockedServerResponses.getEventsEventSpotServiceData,
                    Event.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return events;
    }

	/**
	 * Gets a single Event.<br/>
	 * Implements the get Event operation of the EventSpot API by calling the
	 * ConstantContact server side.
	 * 
	 * @param eventId
	 *            The id of the event to get
	 * @return An {@link com.constantcontact.components.eventspot.Event}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */
	@Override
	public Event getEvent(String eventId)
			throws ConstantContactServiceException {
		Event event = null;
		try {
			event = Component.fromJSON(
					MockedServerResponses.getEventEventSpotServiceData,
					Event.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return event;
	}

	/**
	 * Adds a single Event.<br/>
	 * Implements the add Event operation of the EventSpot API by calling the
	 * ConstantContact server side.
	 * 
	 * @param event
	 *            The Event to add
	 * @return An {@link com.constantcontact.components.eventspot.Event}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */
	@Override
	public Event addEvent(Event event)
			throws ConstantContactServiceException {

		if (event == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEvent());
		}

		Event newEvent = null;
		try {
			newEvent = Component.fromJSON(
					MockedServerResponses.addEventEventSpotServiceData,
					Event.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return newEvent;
	}

	/**
	 * Updates a single Event.<br/>
	 * Implements the update Event operation of the EventSpot API by calling the
	 * ConstantContact server side.
	 * 
	 * @param event
	 *            The event to update.
	 * @return An {@link com.constantcontact.components.eventspot.Event}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */
	@Override
	public Event updateEvent(Event event)
			throws ConstantContactServiceException {
		if (event == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEvent());
		}
		Event updatedEvent = null;
		try {
			updatedEvent = Component.fromJSON(
					MockedServerResponses.updateEventEventSpotServiceData,
					Event.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return updatedEvent;
	}

	/**
	 * Updates the Event status.<br/>
	 * Implements the update Event Status operation of the EventSpot API by
	 * calling the ConstantContact server side.
	 * 
	 * @param eventId
	 *            The id of the event to update.
	 * @param status
	 *            The status of the event.
	 * @return true on success;<br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */
	@Override
	public boolean updateEventStatus(String eventId,
			String status) throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}

		return MockedServerResponses.updateEventStatusEventSpotServiceData;
	}

	/**
	 * Gets all the Event Fees.<br/>
	 * Implements the get Event Fees operation of the EventSpot API by calling
	 * the ConstantContact server side.
	 * 
	 * @param eventId
	 *            The event id.
	 * @return A {@link java.util.List} of
	 *         {@link com.constantcontact.components.eventspot.EventFee}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */
	@Override
	public List<EventFee> getEventFees(String eventId)
			throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}

		List<EventFee> eventFees = null;
		try {
			eventFees = Component.listFromJSON(
					MockedServerResponses.gerEventFeesEventSpotServiceData,
					EventFee.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return eventFees;
	}

	/**
	 * Gets a single Event Fee.<br/>
	 * Implements the get Event Fee operation of the EventSpot API by calling
	 * the ConstantContact server side.
	 * 
	 * @param eventId
	 *            The id of the event.
	 * @param feeId
	 *            The id of the event fee.
	 * @return An {@link com.constantcontact.components.eventspot.EventFee}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public EventFee getEventFee(String eventId, String feeId)
			throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}
		if (feeId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventFeeId());
		}

		EventFee eventFee = null;
		try {
			eventFee = Component.fromJSON(
					MockedServerResponses.getEventFeeEventSpotServiceData,
					EventFee.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return eventFee;
	}

	/**
	 * Adds a single Event Fee.<br/>
	 * Implements the add Event Fee operation of the EventSpot API by calling
	 * the ConstantContact server side.
	 * 
	 * @param eventId
	 *            The id of the event.
	 * @param eventFee
	 *            The event fee to add.
	 * @return An {@link com.constantcontact.components.eventspot.EventFee}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public EventFee addEventFee(String eventId,
			EventFee eventFee) throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}
		if (eventFee == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventFee());
		}

		EventFee newEventFee = null;
		try {
			newEventFee = Component.fromJSON(
					MockedServerResponses.addEventFeeEventSpotServiceData,
					EventFee.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return newEventFee;
	}

	/**
	 * Updates a single Event Fee.<br/>
	 * Implements the update Event Fee operation of the EventSpot API by calling
	 * the ConstantContact server side.
	 * 
	 * @param eventId
	 *            The id of the event.
	 * @param eventFee
	 *            The event fee to update.
	 * @return An {@link com.constantcontact.components.eventspot.EventFee}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public EventFee updateEventFee(String eventId,
			EventFee eventFee) throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}
		if (eventFee == null || eventFee.getId() == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventFeeId());
		}

		EventFee newEventFee = null;
		try {
			newEventFee = Component.fromJSON(
					MockedServerResponses.updateEventFeeEventSpotServiceData,
					EventFee.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return newEventFee;
	}

	/**
	 * Deletes a single Event Fee.<br/>
	 * Implements the delete Event Fee operation of the EventSpot API by calling
	 * the ConstantContact server side.
	 * 
	 * @param eventId
	 *            The id of the event.
	 * @param eventFeeId
	 *            The id of the event fee to delete.
	 * @return true on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public boolean deleteEventFee(String eventId,
			String eventFeeId) throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}
		if (eventFeeId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventFeeId());
		}

		return MockedServerResponses.deleteEventFeeEventSpotServiceData;
	}

	/**
	 * Gets all the Event Promocodes.<br/>
	 * Implements the get Event Promocodes operation of the EventSpot API by
	 * calling the ConstantContact server side.
	 * 
	 * @param eventId
	 *            The event id.
	 * @return A {@link java.util.List} of
	 *         {@link com.constantcontact.components.eventspot.Promocode}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public List<Promocode> getEventPromocodes(String eventId)
			throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}

		List<Promocode> promocodes = null;
		try {
			promocodes = Component
					.listFromJSON(
							MockedServerResponses.getEventPromocodesEventSPotServiceData,
							Promocode.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return promocodes;
	}

	/**
	 * Gets a single Event Promocode.<br/>
	 * Implements the get Event Promocode operation of the EventSpot API by
	 * calling the ConstantContact server side.
	 *
	 * @param eventId
	 *            The id of the event.
	 * @param promocodeId
	 *            The id of the event promocode.
	 * @return An {@link com.constantcontact.components.eventspot.Promocode}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public Promocode getEventPromocode(String eventId,
			String promocodeId) throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}
		if (promocodeId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorPromocodeId());
		}

		Promocode promocode = null;
		try {
			promocode = Component
					.fromJSON(
							MockedServerResponses.getEventPromocodeEventSpotServiceData,
							Promocode.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return promocode;
	}

	/**
	 * Adds a single Event Promocode.<br/>
	 * Implements the add Event Promocode operation of the EventSpot API by
	 * calling the ConstantContact server side.
	 * 
	 * @param eventId
	 *            The id of the event.
	 * @param promocode
	 *            The event promocode to add.
	 * @return An {@link com.constantcontact.components.eventspot.Promocode}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public Promocode addEventPromocode(String eventId,
			Promocode promocode) throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}
		if (promocode == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorPromocode());
		}

		Promocode newPromocode = null;
		try {
			newPromocode = Component
					.fromJSON(
							MockedServerResponses.addEventPromocodeEventSpotServiceData,
							Promocode.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return newPromocode;
	}

	/**
	 * Updates a single Event Promocode.<br/>
	 * Implements the update Event Promocode operation of the EventSpot API by
	 * calling the ConstantContact server side.
	 * 
	 * @param eventId
	 *            The id of the event.
	 * @param promocode
	 *            The event promocode to update.
	 * @return An {@link com.constantcontact.components.eventspot.Promocode}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public Promocode updateEventPromocode(String eventId,
			Promocode promocode) throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}
		if (promocode == null || promocode.getId() == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorPromocode());
		}

		Promocode newPromocode = null;
		try {
			newPromocode = Component
					.fromJSON(
							MockedServerResponses.updateEventPromocodeEventSpotServiceData,
							Promocode.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return newPromocode;
	}

	/**
	 * Deletes a single Event Promocode.<br/>
	 * Implements the delete Event Promocode operation of the EventSpot API by
	 * calling the ConstantContact server side.
	 * 
	 * @param eventId
	 *            The id of the event.
	 * @param promocodeId
	 *            The id of the event promocode to delete.
	 * @return true on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public boolean deleteEventPromocode(String eventId,
			String promocodeId) throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}
		if (promocodeId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorPromocodeId());
		}

		return MockedServerResponses.deleteEventPromocodeEventSpotServiceData;
	}

	/**
	 * Gets all the Event Registrants.<br/>
	 * Implements the get Event Registrants operation of the EventSpot API by
	 * calling the ConstantContact server side.
	 * 
	 * @param eventId
	 *            The id of the event.
	 * @param limit
	 *            The limit.
	 * @return A
	 *         {@link com.constantcontact.components.generic.response.ResultSet}
	 *         of
	 *         {@link com.constantcontact.components.eventspot.Registrant.Registrant}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public ResultSet<Registrant> getEventRegistrants(
			String eventId, Integer limit)
			throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}

		ResultSet<Registrant> eventRegistrants = null;
		try {
			eventRegistrants = Component
					.resultSetFromJSON(
							MockedServerResponses.getEventRegistrantsEventSpotServiceData,
							Registrant.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return eventRegistrants;
	}

    /**
     * Gets all the Event Registrants.<br/>
     * Implements the get Event Registrants operation of the EventSpot API by calling the ConstantContact server side.
     * @param pagination A {@link Pagination} instance containing the link to the next page of results.
     *                   An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public ResultSet<Registrant> getEventRegistrants(Pagination pagination) throws ConstantContactServiceException {
        if (pagination == null || pagination.getNextLink() == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
        }

        ResultSet<Registrant> eventRegistrants = null;
        try {
            eventRegistrants = Component
                    .resultSetFromJSON(
                            MockedServerResponses.getEventRegistrantsEventSpotServiceData,
                            Registrant.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return eventRegistrants;
    }

	/**
	 * Gets a single Event Registrant.<br/>
	 * Implements the get Event Registrant operation of the EventSpot API by
	 * calling the ConstantContact server side.
	 * @param eventId
	 *            The id of the event.
	 * @param registrantId
	 *            The id of the event registrant.
	 * @return An
	 *         {@link com.constantcontact.components.eventspot.Registrant.RegistrantDetails}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public RegistrantDetails getEventRegistrant(
			String eventId, String registrantId)
			throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}
		if (registrantId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorRegistrantId());
		}

		RegistrantDetails registrant = null;
		try {
			registrant = Component
					.fromJSON(
							MockedServerResponses.getEventRegistrantEventSpotServiceData,
							RegistrantDetails.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return registrant;
	}

	/**
	 * Gets all the Event Items.<br/>
	 * Implements the get Event Items operation of the EventSpot API by calling
	 * the ConstantContact server side.
	 * 
	 * @param eventId
	 *            The event id.
	 * @return A {@link java.util.List} of
	 *         {@link com.constantcontact.components.eventspot.EventItem}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public List<EventItem> getEventItems(String eventId)
			throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}

		List<EventItem> eventItems = null;
		try {
			eventItems = Component.listFromJSON(
					MockedServerResponses.getEventItemsEventSpotServiceData,
					EventItem.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return eventItems;
	}

	/**
	 * Gets a single Event Item.<br/>
	 * Implements the get Event Item operation of the EventSpot API by calling
	 * the ConstantContact server side.
	 * 
	 * @param eventId
	 *            The id of the event.
	 * @param itemId
	 *            The id of the event item to get.
	 * @return An {@link com.constantcontact.components.eventspot.EventItem}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public EventItem getEventItem(String eventId,
			String itemId) throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}
		if (itemId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventItemId());
		}

		EventItem eventItem = null;
		try {
			eventItem = Component.fromJSON(
					MockedServerResponses.getEventItemEventSpotServiceData,
					EventItem.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return eventItem;
	}

	/**
	 * Adds a single Event Item.<br/>
	 * Implements the add Event Item operation of the EventSpot API by calling
	 * the ConstantContact server side.
	 * 
	 * @param eventId
	 *            The id of the event.
	 * @param eventItem
	 *            The event item to add.
	 * @return An {@link com.constantcontact.components.eventspot.EventItem}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public EventItem addEventItem(String eventId,
			EventItem eventItem) throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}
		if (eventItem == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventItem());
		}

		EventItem newEventItem = null;
		try {
			newEventItem = Component.fromJSON(
					MockedServerResponses.addEventItemEventSpotServiceData,
					EventItem.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return newEventItem;
	}

	/**
	 * Updates a single Event Item.<br/>
	 * Implements the update Event Item operation of the EventSpot API by
	 * calling the ConstantContact server side.
	 * 
	 * @param eventId
	 *            The id of the event.
	 * @param item
	 *            The event item to update.
	 * @return An {@link com.constantcontact.components.eventspot.EventItem}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public EventItem updateEventItem(String eventId,
			EventItem item) throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}
		if (item == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventItem());
		}
		if (item.getId() == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}

		EventItem eventItem = null;
		try {
			eventItem = Component.fromJSON(
					MockedServerResponses.updateEventItemEventSpotServiceData,
					EventItem.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return eventItem;
	}

	/**
	 * Deletes a single Event Item.<br/>
	 * Implements the delete Event Item operation of the EventSpot API by
	 * calling the ConstantContact server side.
	 * @param eventId
	 *            The id of the event.
	 * @param itemId
	 *            The id of the event item to delete.
	 * @return true on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public boolean deleteEventItem(String eventId,
			String itemId) throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}
		if (itemId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventItemId());
		}

		return MockedServerResponses.deleteEventItemEventSpotServiceData;
	}

	/**
	 * Gets all the Event Item Attributes.<br/>
	 * Implements the get Event Item Attributes operation of the EventSpot API
	 * by calling the ConstantContact server side.
	 * 
	 * @param eventId
	 *            The event id.
	 * @param itemId
	 *            The event item id.
	 * @return A {@link java.util.List} of
	 *         {@link com.constantcontact.components.eventspot.EventItemAttribute}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public List<EventItemAttribute> getEventItemAttributes(
			String eventId, String itemId)
			throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}
		if (itemId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventItemId());
		}

		List<EventItemAttribute> eventItemAttributes = null;
		try {
			eventItemAttributes = Component
					.listFromJSON(
							MockedServerResponses.getEventItemAttributesEventSpotServiceData,
							EventItemAttribute.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return eventItemAttributes;
	}

	/**
	 * Gets a single Event Item Attribute.<br/>
	 * Implements the get Event Item Attribute operation of the EventSpot API by
	 * calling the ConstantContact server side.
	 *
	 * @param eventId
	 *            The id of the event.
	 * @param itemId
	 *            The id of the event item.
	 * @param itemAttributeId
	 *            The id of the event item attribute.
	 * @return An
	 *         {@link com.constantcontact.components.eventspot.EventItemAttribute}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public EventItemAttribute getEventItemAttribute(
			String eventId, String itemId, String itemAttributeId)
			throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}
		if (itemId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventItemId());
		}
		if (itemAttributeId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventItemAttributeId());
		}

		EventItemAttribute eventItemAttribute = null;
		try {
			eventItemAttribute = Component
					.fromJSON(
							MockedServerResponses.getEventItemAttributeEventSpotServiceData,
							EventItemAttribute.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return eventItemAttribute;
	}

	/**
	 * Adds a single Event Item Attribute.<br/>
	 * Implements the add Event Item Attribute operation of the EventSpot API by
	 * calling the ConstantContact server side.
	 *
	 * @param eventId
	 *            The id of the event.
	 * @param itemId
	 *            The event item id.
	 * @param itemAttribute
	 *            The event item attribute to add.
	 * @return An
	 *         {@link com.constantcontact.components.eventspot.EventItemAttribute}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public EventItemAttribute addEventItemAttribute(
			String eventId, String itemId, EventItemAttribute itemAttribute)
			throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}
		if (itemId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventItemId());
		}
		if (itemAttribute == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventItemAttribute());
		}

		EventItemAttribute eventItemAttribute = null;
		try {
			eventItemAttribute = Component
					.fromJSON(
							MockedServerResponses.addEventItemAttributeEventSpotServiceData,
							EventItemAttribute.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return eventItemAttribute;
	}

	/**
	 * Updates a single Event Item Attribute.<br/>
	 * Implements the update Event Item Attribute operation of the EventSpot API
	 * by calling the ConstantContact server side.
	 *
	 * @param eventId
	 *            The id of the event.
	 * @param itemId
	 *            The id of the event item.
	 * @param itemAttribute
	 *            The event item attribute to update.
	 * @return An
	 *         {@link com.constantcontact.components.eventspot.EventItemAttribute}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public EventItemAttribute updateEventItemAttribute(
			String eventId, String itemId, EventItemAttribute itemAttribute)
			throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}
		if (itemId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventItemId());
		}
		if (itemAttribute == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventItemAttribute());
		}

		EventItemAttribute eventItemAttribute = null;
		try {
			eventItemAttribute = Component
					.fromJSON(
							MockedServerResponses.updateEventItemAttributeEventSpotServiceData,
							EventItemAttribute.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return eventItemAttribute;
	}

	/**
	 * Deletes a single Event Item Attribute.<br/>
	 * Implements the delete Event Item Attribute operation of the EventSpot API
	 * by calling the ConstantContact server side.
	 * 
	 * @param eventId
	 *            The id of the event.
	 * @param itemId
	 *            The id of the event item.
	 * @param itemAttributeId
	 *            The id of the event item attribute to delete.
	 * @return true on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public boolean deleteEventItemAttribute(String eventId,
			String itemId, String itemAttributeId)
			throws ConstantContactServiceException {

		if (eventId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventId());
		}
		if (itemId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventItemId());
		}
		if (itemAttributeId == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEventItemAttributeId());
		}

		return MockedServerResponses.deleteEventItemAttributeEventSpotServiceData;
	}

	/**
	 * Default constructor.
	 */
	public EventSpotServiceMock(String accessToken, String apiKey) {
		super(accessToken, apiKey);
		this.setAccessToken(accessToken);
		this.setApiKey(apiKey);
	}
}
