package com.constantcontact.services.eventspot;

import com.constantcontact.components.Component;
import com.constantcontact.components.eventspot.*;
import com.constantcontact.components.eventspot.Registrant.Registrant;
import com.constantcontact.components.eventspot.Registrant.RegistrantDetails;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.RawApiResponse;
import com.constantcontact.util.Config;
import com.constantcontact.util.ConstantContactExceptionFactory;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link EventSpotService} class in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class EventSpotService extends BaseService implements IEventSpotService {

	/**
	 * Gets all the Events.<br/>
	 * Implements the get Events operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param limit The limit
	 * @return A {@link ResultSet} of {@link Event} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public ResultSet<Event> getEvents(String accessToken, Integer limit) throws ConstantContactServiceException {
        ResultSet<Event> events = null;
        try {
            String url = paginateUrl(
                    String.format("%1$s%2$s", Config.instance().getBaseUrl(), Config.instance().getEvents()), limit);

            RawApiResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                events = Component.resultSetFromJSON(response.getBody(), Event.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @return An {@link Event} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public Event getEvent(String accessToken, String eventId) throws
            ConstantContactServiceException {
        Event event = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventId(), eventId));

            RawApiResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                event = Component.fromJSON(response.getBody(), Event.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @return An {@link Event} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public Event addEvent(String accessToken, Event event) throws ConstantContactServiceException {
        Event newEvent = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), Config.instance().getEvents());
            String json = event.toJSON();

            RawApiResponse response = getRestClient().post(url, accessToken, json);
            if (response.hasData()) {
                newEvent = Component.fromJSON(response.getBody(), Event.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @return An {@link Event} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public Event updateEvent(String accessToken, Event event) throws ConstantContactServiceException {
        Event updatedEvent = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventId(), event.getId()));
            String json = event.toJSON();

            RawApiResponse response = getRestClient().put(url, accessToken, json);
            if (response.hasData()) {
                updatedEvent = Component.fromJSON(response.getBody(), Event.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public boolean updateEventStatus(String accessToken, String eventId, String status) throws ConstantContactServiceException {
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventId(), eventId));

            EventUpdateStatus eventUpdateStatus = new EventUpdateStatus(status);
            List<EventUpdateStatus> eventUpdateStatusRequestList = new ArrayList<EventUpdateStatus>();
            eventUpdateStatusRequestList.add(eventUpdateStatus);
            EventUpdateStatusRequest eventUpdateStatusRequest = new EventUpdateStatusRequest(eventUpdateStatusRequestList);
            String json = eventUpdateStatusRequest.toJSON();

            RawApiResponse response = getRestClient().patch(url, accessToken, json);
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
            return response.getStatusCode() == HttpURLConnection.HTTP_NO_CONTENT;
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
    }
	
	/**
	 * Gets all the Event Fees.<br/>
	 * Implements the get Event Fees operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The event id.
	 * @return A {@link List} of {@link EventFee} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */	
    public List<EventFee> getEventFees(String accessToken, String eventId) throws ConstantContactServiceException {
        List<EventFee> eventFees = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventFees(), eventId));

            RawApiResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                eventFees = Component.listFromJSON(response.getBody(), EventFee.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @return An {@link EventFee} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public EventFee getEventFee(String accessToken, String eventId, String feeId) throws ConstantContactServiceException {
        EventFee eventFee = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventFeeId(), eventId, feeId));

            RawApiResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                eventFee = Component.fromJSON(response.getBody(), EventFee.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @return An {@link EventFee} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public EventFee addEventFee(String accessToken, String eventId, EventFee eventFee) throws ConstantContactServiceException {
        EventFee newEventFee = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventFees(), eventId));
            String json = eventFee.toJSON();

            RawApiResponse response = getRestClient().post(url, accessToken, json);
            if (response.hasData()) {
                newEventFee = Component.fromJSON(response.getBody(), EventFee.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @return An {@link EventFee} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public EventFee updateEventFee(String accessToken, String eventId, EventFee eventFee) throws ConstantContactServiceException {
        EventFee newEventFee = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventFeeId(), eventId, eventFee.getId()));
            String json = eventFee.toJSON();

            RawApiResponse response = getRestClient().put(url, accessToken, json);
            if (response.hasData()) {
                newEventFee = Component.fromJSON(response.getBody(), EventFee.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public boolean deleteEventFee(String accessToken, String eventId, String eventFeeId) throws ConstantContactServiceException {
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventFeeId(), eventId, eventFeeId));

            RawApiResponse response = getRestClient().delete(url, accessToken);
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
            return response.getStatusCode() == HttpURLConnection.HTTP_NO_CONTENT;
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
    }

	/**
	 * Gets all the Event Promocodes.<br/>
	 * Implements the get Event Promocodes operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The event id.
	 * @return A {@link List} of {@link Promocode} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public List<Promocode> getEventPromocodes(String accessToken, String eventId) throws ConstantContactServiceException {
        List<Promocode> promocodes = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventPromocodes(), eventId));

            RawApiResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                promocodes = Component.listFromJSON(response.getBody(), Promocode.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @return An {@link Promocode} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    public Promocode getEventPromocode(String accessToken, String eventId, String promocodeId) throws ConstantContactServiceException {
        Promocode promocode = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventPromocodeId(), eventId, promocodeId));

            RawApiResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                promocode = Component.fromJSON(response.getBody(), Promocode.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @return An {@link Promocode} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */	
    
    public Promocode addEventPromocode(String accessToken, String eventId, Promocode promocode) throws ConstantContactServiceException {
        Promocode newPromocode = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventPromocodes(), eventId));
            String json = promocode.toJSON();

            RawApiResponse response = getRestClient().post(url, accessToken, json);
            if (response.hasData()) {
                newPromocode = Component.fromJSON(response.getBody(), Promocode.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @return An {@link Promocode} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public Promocode updateEventPromocode(String accessToken, String eventId, Promocode promocode) throws ConstantContactServiceException {
        Promocode newPromocode = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventPromocodeId(), eventId, promocode.getId()));
            String json = promocode.toJSON();

            RawApiResponse response = getRestClient().put(url, accessToken, json);
            if (response.hasData()) {
                newPromocode = Component.fromJSON(response.getBody(), Promocode.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public boolean deleteEventPromocode(String accessToken, String eventId, String promocodeId) throws ConstantContactServiceException {
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventPromocodeId(), eventId, promocodeId));

            RawApiResponse response = getRestClient().delete(url, accessToken);
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
            return response.getStatusCode() == HttpURLConnection.HTTP_NO_CONTENT;
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
    }
	
	/**
	 * Gets all the Event Registrants.<br/>
	 * Implements the get Event Registrants operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The id of the event.
	 * @param limit The limit.
	 * @return A {@link ResultSet} of {@link Registrant} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public ResultSet<Registrant> getEventRegistrants(String accessToken, String eventId, Integer limit) throws ConstantContactServiceException {
        ResultSet<Registrant> eventRegistrants = null;
        try {
            String url = paginateUrl(
                    String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getEventRegistrants(), eventId)), limit);

            RawApiResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                eventRegistrants = Component.resultSetFromJSON(response.getBody(), Registrant.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @return An {@link RegistrantDetails} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public RegistrantDetails getEventRegistrant(String accessToken,String eventId, String registrantId) throws ConstantContactServiceException {
        RegistrantDetails registrant = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventRegistrantId(), eventId, registrantId));

            RawApiResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                registrant = Component.fromJSON(response.getBody(), RegistrantDetails.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @return A {@link List} of {@link EventItem} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public List<EventItem> getEventItems(String accessToken, String eventId) throws ConstantContactServiceException {
        List<EventItem> eventItems = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItems(), eventId));

            RawApiResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                eventItems = Component.listFromJSON(response.getBody(), EventItem.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @return An {@link EventItem} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public EventItem getEventItem(String accessToken, String eventId, String itemId) throws ConstantContactServiceException {
        EventItem eventItem = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItemId(), eventId, itemId));

            RawApiResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                eventItem = Component.fromJSON(response.getBody(), EventItem.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @return An {@link EventItem} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public EventItem addEventItem(String accessToken, String eventId, EventItem eventItem) throws ConstantContactServiceException {
        EventItem newEventItem = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItems(), eventId));
            String json = eventItem.toJSON();

            RawApiResponse response = getRestClient().post(url, accessToken, json);
            if (response.hasData()) {
                newEventItem = Component.fromJSON(response.getBody(), EventItem.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @return An {@link EventItem} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public EventItem updateEventItem(String accessToken, String eventId, EventItem item) throws ConstantContactServiceException {
        EventItem eventItem = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItemId(), eventId, item.getId()));
            String json = item.toJSON();

            RawApiResponse response = getRestClient().put(url, accessToken, json);
            if (response.hasData()) {
                eventItem = Component.fromJSON(response.getBody(), EventItem.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public boolean deleteEventItem(String accessToken, String eventId, String itemId) throws ConstantContactServiceException {
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItemId(), eventId, itemId));

            RawApiResponse response = getRestClient().delete(url, accessToken);
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
            return response.getStatusCode() == HttpURLConnection.HTTP_NO_CONTENT;
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
    }

	/**
	 * Gets all the Event Item Attributes.<br/>
	 * Implements the get Event Item Attributes operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param eventId The event id.
	 * @param itemId The event item id.
	 * @return A {@link List} of {@link EventItemAttribute} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public List<EventItemAttribute> getEventItemAttributes(String accessToken, String eventId, String itemId) throws ConstantContactServiceException {
        List<EventItemAttribute> eventItemAttributes = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItemAttributes(), eventId, itemId));

            RawApiResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                eventItemAttributes = Component.listFromJSON(response.getBody(), EventItemAttribute.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @return An {@link EventItemAttribute} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    public EventItemAttribute getEventItemAttribute(String accessToken, String eventId, String itemId, String itemAttributeId) throws
            ConstantContactServiceException {
        EventItemAttribute eventItemAttribute = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItemAttributeId(), eventId, itemId, itemAttributeId));

            RawApiResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                eventItemAttribute = Component.fromJSON(response.getBody(), EventItemAttribute.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
     * @return An {@link EventItemAttribute} containing data as returned by the server on success; <br/>
     * An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    
    public EventItemAttribute addEventItemAttribute(String accessToken, String eventId, String itemId, EventItemAttribute itemAttribute) throws
            ConstantContactServiceException {
        EventItemAttribute eventItemAttribute = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItemAttributes(), eventId, itemId));
            String json = itemAttribute.toJSON();

            RawApiResponse response = getRestClient().post(url, accessToken, json);
            if (response.hasData()) {
                eventItemAttribute = Component.fromJSON(response.getBody(), EventItemAttribute.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @return An {@link EventItemAttribute} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    public EventItemAttribute updateEventItemAttribute(String accessToken, String eventId, String itemId, EventItemAttribute itemAttribute) throws
            ConstantContactServiceException {
        EventItemAttribute eventItemAttribute = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItemAttributeId(), eventId, itemId, itemAttribute.getId()));
            String json = itemAttribute.toJSON();

            RawApiResponse response = getRestClient().put(url, accessToken, json);
            if (response.hasData()) {
                eventItemAttribute = Component.fromJSON(response.getBody(), EventItemAttribute.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public boolean deleteEventItemAttribute(String accessToken, String eventId, String itemId, String itemAttributeId) throws
            ConstantContactServiceException {
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItemAttributeId(), eventId, itemId, itemAttributeId));

            RawApiResponse response = getRestClient().delete(url, accessToken);
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
            return response.getStatusCode() == HttpURLConnection.HTTP_NO_CONTENT;
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
    }

    /**
     * Default constructor.
     */
    public EventSpotService() {
        super();
    }
}
