package mockup;

import com.constantcontact.components.Component;
import com.constantcontact.components.eventspot.*;
import com.constantcontact.components.eventspot.Registrant.Registrant;
import com.constantcontact.components.eventspot.Registrant.RegistrantDetails;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.eventspot.EventSpotService;

import java.util.List;

/**
 * {@link EventSpotServiceTest} class in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class EventSpotServiceTest extends EventSpotService {

	/**
	 * Gets all the Events.<br/>
	 * Implements the get Events operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param limit The limit
	 * @return A {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.eventspot.Event} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    @Override
    public ResultSet<Event> getEvents(String accessToken, Integer limit) throws ConstantContactServiceException {
        ResultSet<Event> events = null;
        try {
                events = Component.resultSetFromJSON(MockedServerResponses.getEventsEventSpotServiceData, Event.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return events;
    }
	
	/**
	 * Gets a single Event.<br/>
	 * Implements the get Event operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event to get
	 * @return An {@link com.constantcontact.components.eventspot.Event} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    @Override
    public Event getEvent(String accessToken, String eventId) throws
            ConstantContactServiceException {
        Event event = null;
        try {
                event = Component.fromJSON(MockedServerResponses.getEventEventSpotServiceData, Event.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return event;
    }
	/**
	 * Adds a single Event.<br/>
	 * Implements the add Event operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param event The Event to add
	 * @return An {@link com.constantcontact.components.eventspot.Event} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    @Override
    public Event addEvent(String accessToken, Event event) throws ConstantContactServiceException {
        Event newEvent = null;
        try {
                newEvent = Component.fromJSON(MockedServerResponses.addEventEventSpotServiceData, Event.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return newEvent;
    }
	
	/**
	 * Updates a single Event.<br/>
	 * Implements the update Event operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param event The event to update.
	 * @return An {@link com.constantcontact.components.eventspot.Event} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    @Override
    public Event updateEvent(String accessToken, Event event) throws ConstantContactServiceException {
        Event updatedEvent = null;
        try {
                updatedEvent = Component.fromJSON(MockedServerResponses.updateEventEventSpotServiceData, Event.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return updatedEvent;
    }
	
	/**
	 * Updates the Event status.<br/>
	 * Implements the update Event Status operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event to update.
	 * @param status The status of the event.
	 * @return true on success;<br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    @Override
    public boolean updateEventStatus(String accessToken, String eventId, String status) throws ConstantContactServiceException {

        return MockedServerResponses.updateEventStatusEventSpotServiceData;
    }
	
	/**
	 * Gets all the Event Fees.<br/>
	 * Implements the get Event Fees operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The event id.
	 * @return A {@link java.util.List} of {@link com.constantcontact.components.eventspot.EventFee} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    @Override
    public List<EventFee> getEventFees(String accessToken, String eventId) throws ConstantContactServiceException {
        List<EventFee> eventFees = null;
        try {
                eventFees = Component.listFromJSON(MockedServerResponses.gerEventFeesEventSpotServiceData, EventFee.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return eventFees;
    }

	/**
	 * Gets a single Event Fee.<br/>
	 * Implements the get Event Fee operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event.
	 * @param feeId The id of the event fee. 
	 * @return An {@link com.constantcontact.components.eventspot.EventFee} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public EventFee getEventFee(String accessToken, String eventId, String feeId) throws ConstantContactServiceException {
        EventFee eventFee = null;
        try {
                eventFee = Component.fromJSON(MockedServerResponses.getEventFeeEventSpotServiceData, EventFee.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return eventFee;
    }

	/**
	 * Adds a single Event Fee.<br/>
	 * Implements the add Event Fee operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event.
	 * @param eventFee The event fee to add.
	 * @return An {@link com.constantcontact.components.eventspot.EventFee} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public EventFee addEventFee(String accessToken, String eventId, EventFee eventFee) throws ConstantContactServiceException {
        EventFee newEventFee = null;
        try {
                newEventFee = Component.fromJSON(MockedServerResponses.addEventFeeEventSpotServiceData, EventFee.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return newEventFee;
    }

	/**
	 * Updates a single Event Fee.<br/>
	 * Implements the update Event Fee operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event.
	 * @param eventFee The event fee to update.
	 * @return An {@link com.constantcontact.components.eventspot.EventFee} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public EventFee updateEventFee(String accessToken, String eventId, EventFee eventFee) throws ConstantContactServiceException {
        EventFee newEventFee = null;
        try {
                newEventFee = Component.fromJSON(MockedServerResponses.updateEventFeeEventSpotServiceData, EventFee.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return newEventFee;
    }

	/**
	 * Deletes a single Event Fee.<br/>
	 * Implements the delete Event Fee operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event.
	 * @param eventFeeId The id of the event fee to delete.
	 * @return true on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public boolean deleteEventFee(String accessToken, String eventId, String eventFeeId) throws ConstantContactServiceException {

        return MockedServerResponses.deleteEventFeeEventSpotServiceData;
    }

	/**
	 * Gets all the Event Promocodes.<br/>
	 * Implements the get Event Promocodes operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The event id.
	 * @return A {@link java.util.List} of {@link com.constantcontact.components.eventspot.Promocode} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public List<Promocode> getEventPromocodes(String accessToken, String eventId) throws ConstantContactServiceException {
        List<Promocode> promocodes = null;
        try {
                promocodes = Component.listFromJSON(MockedServerResponses.getEventPromocodesEventSPotServiceData, Promocode.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return promocodes;
    }

	/**
	 * Gets a single Event Promocode.<br/>
	 * Implements the get Event Promocode operation of the EventSpot API by calling the ConstantContact server side.
	 *
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event.
	 * @param promocodeId The id of the event promocode.
	 * @return An {@link com.constantcontact.components.eventspot.Promocode} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public Promocode getEventPromocode(String accessToken, String eventId, String promocodeId) throws ConstantContactServiceException {
        Promocode promocode = null;
        try {
                promocode = Component.fromJSON(MockedServerResponses.getEventPromocodeEventSpotServiceData, Promocode.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return promocode;
    }	
	
	/**
	 * Adds a single Event Promocode.<br/>
	 * Implements the add Event Promocode operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event.
	 * @param promocode The event promocode to add.
	 * @return An {@link com.constantcontact.components.eventspot.Promocode} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public Promocode addEventPromocode(String accessToken, String eventId, Promocode promocode) throws ConstantContactServiceException {
        Promocode newPromocode = null;
        try {
                newPromocode = Component.fromJSON(MockedServerResponses.addEventPromocodeEventSpotServiceData, Promocode.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return newPromocode;
    }

	/**
	 * Updates a single Event Promocode.<br/>
	 * Implements the update Event Promocode operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event.
	 * @param promocode The event promocode to update.
	 * @return An {@link com.constantcontact.components.eventspot.Promocode} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public Promocode updateEventPromocode(String accessToken, String eventId, Promocode promocode) throws ConstantContactServiceException {
        Promocode newPromocode = null;
        try {
                newPromocode = Component.fromJSON(MockedServerResponses.updateEventPromocodeEventSpotServiceData, Promocode.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return newPromocode;
    }

	/**
	 * Deletes a single Event Promocode.<br/>
	 * Implements the delete Event Promocode operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event.
	 * @param promocodeId The id of the event promocode to delete.
	 * @return true on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public boolean deleteEventPromocode(String accessToken, String eventId, String promocodeId) throws ConstantContactServiceException {
        return MockedServerResponses.deleteEventPromocodeEventSpotServiceData;
    }
	
	/**
	 * Gets all the Event Registrants.<br/>
	 * Implements the get Event Registrants operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event.
	 * @param limit The limit.
	 * @return A {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.eventspot.Registrant.Registrant} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public ResultSet<Registrant> getEventRegistrants(String accessToken, String eventId, Integer limit) throws ConstantContactServiceException {
        ResultSet<Registrant> eventRegistrants = null;
        try {
                eventRegistrants = Component.resultSetFromJSON(MockedServerResponses.getEventRegistrantsEventSpotServiceData, Registrant.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return eventRegistrants;
    }
	
	/**
	 * Gets a single Event Registrant.<br/>
	 * Implements the get Event Registrant operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event.
	 * @param registrantId The id of the event registrant. 
	 * @return An {@link com.constantcontact.components.eventspot.Registrant.RegistrantDetails} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public RegistrantDetails getEventRegistrant(String accessToken,String eventId, String registrantId) throws ConstantContactServiceException {
        RegistrantDetails registrant = null;
        try {
                registrant = Component.fromJSON(MockedServerResponses.getEventRegistrantEventSpotServiceData, RegistrantDetails.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return registrant;
    }
	
	/**
	 * Gets all the Event Items.<br/>
	 * Implements the get Event Items operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The event id.
	 * @return A {@link java.util.List} of {@link com.constantcontact.components.eventspot.EventItem} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public List<EventItem> getEventItems(String accessToken, String eventId) throws ConstantContactServiceException {
        List<EventItem> eventItems = null;
        try {
                eventItems = Component.listFromJSON(MockedServerResponses.getEventItemsEventSpotServiceData, EventItem.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return eventItems;
    }

	/**
	 * Gets a single Event Item.<br/>
	 * Implements the get Event Item operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event.
	 * @param itemId The id of the event item to get. 
	 * @return An {@link com.constantcontact.components.eventspot.EventItem} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public EventItem getEventItem(String accessToken, String eventId, String itemId) throws ConstantContactServiceException {
        EventItem eventItem = null;
        try {
                eventItem = Component.fromJSON(MockedServerResponses.getEventItemEventSpotServiceData, EventItem.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return eventItem;
    }
	
	/**
	 * Adds a single Event Item.<br/>
	 * Implements the add Event Item operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event.
	 * @param eventItem The event item to add.
	 * @return An {@link com.constantcontact.components.eventspot.EventItem} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public EventItem addEventItem(String accessToken, String eventId, EventItem eventItem) throws ConstantContactServiceException {
        EventItem newEventItem = null;
            try {
                newEventItem = Component.fromJSON(MockedServerResponses.addEventItemEventSpotServiceData, EventItem.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return newEventItem;
    }

	/**
	 * Updates a single Event Item.<br/>
	 * Implements the update Event Item operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event.
	 * @param item The event item to update.
	 * @return An {@link com.constantcontact.components.eventspot.EventItem} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public EventItem updateEventItem(String accessToken, String eventId, EventItem item) throws ConstantContactServiceException {
        EventItem eventItem = null;
        try {
                eventItem = Component.fromJSON(MockedServerResponses.updateEventItemEventSpotServiceData, EventItem.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return eventItem;
    }

	/**
	 * Deletes a single Event Item.<br/>
	 * Implements the delete Event Item operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event.
	 * @param itemId The id of the event item to delete.
	 * @return true on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public boolean deleteEventItem(String accessToken, String eventId, String itemId) throws ConstantContactServiceException {
        return MockedServerResponses.deleteEventItemEventSpotServiceData;
    }

	/**
	 * Gets all the Event Item Attributes.<br/>
	 * Implements the get Event Item Attributes operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The event id.
	 * @param itemId The event item id.
	 * @return A {@link java.util.List} of {@link com.constantcontact.components.eventspot.EventItemAttribute} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public List<EventItemAttribute> getEventItemAttributes(String accessToken, String eventId, String itemId) throws ConstantContactServiceException {
        List<EventItemAttribute> eventItemAttributes = null;
        try {
                eventItemAttributes = Component.listFromJSON(MockedServerResponses.getEventItemAttributesEventSpotServiceData, EventItemAttribute.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return eventItemAttributes;
    }

	/**
	 * Gets a single Event Item Attribute.<br/>
	 * Implements the get Event Item Attribute operation of the EventSpot API by calling the ConstantContact server side.
	 *
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event.
	 * @param itemId The id of the event item.
	 * @param itemAttributeId The id of the event item attribute.
	 * @return An {@link com.constantcontact.components.eventspot.EventItemAttribute} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public EventItemAttribute getEventItemAttribute(String accessToken, String eventId, String itemId, String itemAttributeId) throws
            ConstantContactServiceException {
        EventItemAttribute eventItemAttribute = null;
        try {
                eventItemAttribute = Component.fromJSON(MockedServerResponses.getEventItemAttributeEventSpotServiceData, EventItemAttribute.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return eventItemAttribute;
    }

    /**
     * Adds a single Event Item Attribute.<br/>
     * Implements the add Event Item Attribute operation of the EventSpot API by calling the ConstantContact server side.
     *
     * @param accessToken Constant Contact OAuth2 access token.
     * @param eventId The id of the event.
     * @param itemId The event item id.
     * @param itemAttribute The event item attribute to add.
     * @return An {@link com.constantcontact.components.eventspot.EventItemAttribute} containing data as returned by the server on success; <br/>
     * An exception is thrown otherwise.
     * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */

    @Override
    public EventItemAttribute addEventItemAttribute(String accessToken, String eventId, String itemId, EventItemAttribute itemAttribute) throws
            ConstantContactServiceException {
        EventItemAttribute eventItemAttribute = null;
        try {
                eventItemAttribute = Component.fromJSON(MockedServerResponses.addEventItemAttributeEventSpotServiceData, EventItemAttribute.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return eventItemAttribute;
    }

    /**
	 * Updates a single Event Item Attribute.<br/>
	 * Implements the update Event Item Attribute operation of the EventSpot API by calling the ConstantContact server side.
	 *
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event.
	 * @param itemId The id of the event item.
	 * @param itemAttribute The event item attribute to update.
	 * @return An {@link com.constantcontact.components.eventspot.EventItemAttribute} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public EventItemAttribute updateEventItemAttribute(String accessToken, String eventId, String itemId, EventItemAttribute itemAttribute) throws
            ConstantContactServiceException {
        EventItemAttribute eventItemAttribute = null;
        try {
                eventItemAttribute = Component.fromJSON(MockedServerResponses.updateEventItemAttributeEventSpotServiceData, EventItemAttribute.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return eventItemAttribute;
    }
	
	/**
	 * Deletes a single Event Item Attribute.<br/>
	 * Implements the delete Event Item Attribute operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event.
	 * @param itemId The id of the event item.
	 * @param itemAttributeId The id of the event item attribute to delete.
	 * @return true on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
    public boolean deleteEventItemAttribute(String accessToken, String eventId, String itemId, String itemAttributeId) throws
            ConstantContactServiceException {
        return MockedServerResponses.deleteEventItemAttributeEventSpotServiceData;
    }

    /**
     * Default constructor.
     */
    public EventSpotServiceTest() {
        super();
    }
}
