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
	 * Implements the get Events operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param limit The limit
	 * @return A {@link ResultSet} of {@link Event} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public ResultSet<Event> getEvents(Integer limit) throws ConstantContactServiceException {
        ResultSet<Event> events = null;
        try {
            String url = paginateUrl(
                    String.format("%1$s%2$s", Config.instance().getBaseUrl(), Config.instance().getEvents()), limit);

            RawApiResponse response = getRestClient().get(url);

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
	 * .
	 * @param eventId The id of the event to get
	 * @return An {@link Event} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public Event getEvent(String eventId) throws
            ConstantContactServiceException {
        Event event = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventId(), eventId));

            RawApiResponse response = getRestClient().get(url);

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
	 * @param event The Event to add
	 * @return An {@link Event} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public Event addEvent(Event event) throws ConstantContactServiceException {
    	
        if (event == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEvent());
        }
        
        Event newEvent = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), Config.instance().getEvents());
            String json = event.toJSON();

            RawApiResponse response = getRestClient().post(url, json);
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
	 * @param event The event to update.
	 * @return An {@link Event} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public Event updateEvent(Event event) throws ConstantContactServiceException {
    	
        if(event == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEvent());
        }
        
        Event updatedEvent = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventId(), event.getId()));
            String json = event.toJSON();

            RawApiResponse response = getRestClient().put(url, json);
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
	 * @param eventId The id of the event to update.
	 * @param status The status of the event.
	 * @return true on success;<br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public boolean updateEventStatus(String eventId, String status) throws ConstantContactServiceException {
    	
    	if(eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
    	
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventId(), eventId));

            EventUpdateStatus eventUpdateStatus = new EventUpdateStatus(status);
            List<EventUpdateStatus> eventUpdateStatusRequestList = new ArrayList<EventUpdateStatus>();
            eventUpdateStatusRequestList.add(eventUpdateStatus);
            EventUpdateStatusRequest eventUpdateStatusRequest = new EventUpdateStatusRequest(eventUpdateStatusRequestList);
            String json = eventUpdateStatusRequest.toJSON();

            RawApiResponse response = getRestClient().patch(url, json);
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
	 * @param eventId The event id.
	 * @return A {@link List} of {@link EventFee} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */	
    public List<EventFee> getEventFees(String eventId) throws ConstantContactServiceException {
    	
    	if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
    	
        List<EventFee> eventFees = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventFees(), eventId));

            RawApiResponse response = getRestClient().get(url);

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
	 * @param eventId The id of the event.
	 * @param feeId The id of the event fee. 
	 * @return An {@link EventFee} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public EventFee getEventFee(String eventId, String feeId) throws ConstantContactServiceException {
    	
    	if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (feeId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventFeeId());
        }
        
        EventFee eventFee = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventFeeId(), eventId, feeId));

            RawApiResponse response = getRestClient().get(url);

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
	 * @param eventId The id of the event.
	 * @param eventFee The event fee to add.
	 * @return An {@link EventFee} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public EventFee addEventFee(String eventId, EventFee eventFee) throws ConstantContactServiceException {
    	
    	if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (eventFee == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventFee());
        }
         
        EventFee newEventFee = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventFees(), eventId));
            String json = eventFee.toJSON();

            RawApiResponse response = getRestClient().post(url, json);
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
	 * @param eventId The id of the event.
	 * @param eventFee The event fee to update.
	 * @return An {@link EventFee} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public EventFee updateEventFee(String eventId, EventFee eventFee) throws ConstantContactServiceException {
    	
    	 if (eventId == null) {
             throw new IllegalArgumentException(Config.instance().getErrorEventId());
         }
         if (eventFee == null || eventFee.getId() == null) {
             throw new IllegalArgumentException(Config.instance().getErrorEventFeeId());
         }
         
        EventFee newEventFee = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventFeeId(), eventId, eventFee.getId()));
            String json = eventFee.toJSON();

            RawApiResponse response = getRestClient().put(url, json);
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

	 * @param eventId The id of the event.
	 * @param eventFeeId The id of the event fee to delete.
	 * @return true on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public boolean deleteEventFee(String eventId, String eventFeeId) throws ConstantContactServiceException {
    	
    	if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (eventFeeId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventFeeId());
        }
        
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventFeeId(), eventId, eventFeeId));

            RawApiResponse response = getRestClient().delete(url);
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
	 * @param eventId The event id.
	 * @return A {@link List} of {@link Promocode} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public List<Promocode> getEventPromocodes(String eventId) throws ConstantContactServiceException {
    	
    	if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
    	
        List<Promocode> promocodes = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventPromocodes(), eventId));

            RawApiResponse response = getRestClient().get(url);

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
	 * @param eventId The id of the event.
	 * @param promocodeId The id of the event promocode.
	 * @return An {@link Promocode} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    public Promocode getEventPromocode(String eventId, String promocodeId) throws ConstantContactServiceException {
    	
    	 if (eventId == null) {
             throw new IllegalArgumentException(Config.instance().getErrorEventId());
         }
         if (promocodeId == null) {
             throw new IllegalArgumentException(Config.instance().getErrorPromocodeId());
         }
         
        Promocode promocode = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventPromocodeId(), eventId, promocodeId));

            RawApiResponse response = getRestClient().get(url);

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
	 * @param eventId The id of the event.
	 * @param promocode The event promocode to add.
	 * @return An {@link Promocode} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */	
    
    public Promocode addEventPromocode(String eventId, Promocode promocode) throws ConstantContactServiceException {
    	
    	if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (promocode == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPromocode());
        }
        
        Promocode newPromocode = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventPromocodes(), eventId));
            String json = promocode.toJSON();

            RawApiResponse response = getRestClient().post(url, json);
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
	 * @param eventId The id of the event.
	 * @param promocode The event promocode to update.
	 * @return An {@link Promocode} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public Promocode updateEventPromocode(String eventId, Promocode promocode) throws ConstantContactServiceException {
    	
    	if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (promocode == null || promocode.getId() == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPromocode());
        }
        
        Promocode newPromocode = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventPromocodeId(), eventId, promocode.getId()));
            String json = promocode.toJSON();

            RawApiResponse response = getRestClient().put(url, json);
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
	 * @param eventId The id of the event.
	 * @param promocodeId The id of the event promocode to delete.
	 * @return true on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public boolean deleteEventPromocode(String eventId, String promocodeId) throws ConstantContactServiceException {
    	
    	 if (eventId == null) {
             throw new IllegalArgumentException(Config.instance().getErrorEventId());
         }
         if (promocodeId == null) {
             throw new IllegalArgumentException(Config.instance().getErrorPromocodeId());
         }
         
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventPromocodeId(), eventId, promocodeId));

            RawApiResponse response = getRestClient().delete(url);
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
	 * @param eventId The id of the event.
	 * @param limit The limit.
	 * @return A {@link ResultSet} of {@link Registrant} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public ResultSet<Registrant> getEventRegistrants(String eventId, Integer limit) throws ConstantContactServiceException {
    	
    	if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
    	
        ResultSet<Registrant> eventRegistrants = null;
        try {
            String url = paginateUrl(
                    String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getEventRegistrants(), eventId)), limit);

            RawApiResponse response = getRestClient().get(url);

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
	 * @param eventId The id of the event.
	 * @param registrantId The id of the event registrant. 
	 * @return An {@link RegistrantDetails} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public RegistrantDetails getEventRegistrant(String eventId, String registrantId) throws ConstantContactServiceException {
    	
    	if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (registrantId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorRegistrantId());
        }
        
        RegistrantDetails registrant = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventRegistrantId(), eventId, registrantId));

            RawApiResponse response = getRestClient().get(url);

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
	 * @param eventId The event id.
	 * @return A {@link List} of {@link EventItem} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public List<EventItem> getEventItems(String eventId) throws ConstantContactServiceException {
    	
    	if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
    	
        List<EventItem> eventItems = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItems(), eventId));

            RawApiResponse response = getRestClient().get(url);

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
	 * @param eventId The id of the event.
	 * @param itemId The id of the event item to get. 
	 * @return An {@link EventItem} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public EventItem getEventItem(String eventId, String itemId) throws ConstantContactServiceException {
    	
    	 if (eventId == null) {
             throw new IllegalArgumentException(Config.instance().getErrorEventId());
         }
         if (itemId == null) {
             throw new IllegalArgumentException(Config.instance().getErrorEventItemId());
         }
         
        EventItem eventItem = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItemId(), eventId, itemId));

            RawApiResponse response = getRestClient().get(url);

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
	 * @param eventId The id of the event.
	 * @param eventItem The event item to add.
	 * @return An {@link EventItem} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public EventItem addEventItem(String eventId, EventItem eventItem) throws ConstantContactServiceException {
    	
    	if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (eventItem == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItem());
        }
        
        EventItem newEventItem = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItems(), eventId));
            String json = eventItem.toJSON();

            RawApiResponse response = getRestClient().post(url, json);
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
	 * @param eventId The id of the event.
	 * @param item The event item to update.
	 * @return An {@link EventItem} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public EventItem updateEventItem(String eventId, EventItem item) throws ConstantContactServiceException {
    	
    	 if (eventId == null) {
             throw new IllegalArgumentException(Config.instance().getErrorEventId());
         }
         if (item == null) {
             throw new IllegalArgumentException(Config.instance().getErrorEventItem());
         }
         if (item.getId() == null) {
             throw new IllegalArgumentException(Config.instance().getErrorEventId());
         }
         
        EventItem eventItem = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItemId(), eventId, item.getId()));
            String json = item.toJSON();

            RawApiResponse response = getRestClient().put(url, json);
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
	 * @param eventId The id of the event.
	 * @param itemId The id of the event item to delete.
	 * @return true on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public boolean deleteEventItem(String eventId, String itemId) throws ConstantContactServiceException {
    	
    	if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (itemId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItemId());
        }
        
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItemId(), eventId, itemId));

            RawApiResponse response = getRestClient().delete(url);
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
	 * @param eventId The event id.
	 * @param itemId The event item id.
	 * @return A {@link List} of {@link EventItemAttribute} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public List<EventItemAttribute> getEventItemAttributes(String eventId, String itemId) throws ConstantContactServiceException {
    	
    	if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (itemId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItemId());
        }
        
        List<EventItemAttribute> eventItemAttributes = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItemAttributes(), eventId, itemId));

            RawApiResponse response = getRestClient().get(url);

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
	 * @param eventId The id of the event.
	 * @param itemId The id of the event item.
	 * @param itemAttributeId The id of the event item attribute.
	 * @return An {@link EventItemAttribute} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    public EventItemAttribute getEventItemAttribute(String eventId, String itemId, String itemAttributeId) throws
            ConstantContactServiceException {
    	
    	 if (eventId == null) {
             throw new IllegalArgumentException(Config.instance().getErrorEventId());
         }
         if (itemId == null) {
             throw new IllegalArgumentException(Config.instance().getErrorEventItemId());
         }
         if (itemAttributeId == null) {
             throw new IllegalArgumentException(Config.instance().getErrorEventItemAttributeId());
         }
         
        EventItemAttribute eventItemAttribute = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItemAttributeId(), eventId, itemId, itemAttributeId));

            RawApiResponse response = getRestClient().get(url);

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
     * @param eventId The id of the event.
     * @param itemId The event item id.
     * @param itemAttribute The event item attribute to add.
     * @return An {@link EventItemAttribute} containing data as returned by the server on success; <br/>
     * An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    
    public EventItemAttribute addEventItemAttribute(String eventId, String itemId, EventItemAttribute itemAttribute) throws
            ConstantContactServiceException {
    	
    	 if (eventId == null) {
             throw new IllegalArgumentException(Config.instance().getErrorEventId());
         }
         if (itemId == null) {
             throw new IllegalArgumentException(Config.instance().getErrorEventItemId());
         }
         if (itemAttribute == null) {
             throw new IllegalArgumentException(Config.instance().getErrorEventItemAttribute());
         }
         
        EventItemAttribute eventItemAttribute = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItemAttributes(), eventId, itemId));
            String json = itemAttribute.toJSON();

            RawApiResponse response = getRestClient().post(url, json);
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
	 * @param eventId The id of the event.
	 * @param itemId The id of the event item.
	 * @param itemAttribute The event item attribute to update.
	 * @return An {@link EventItemAttribute} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    public EventItemAttribute updateEventItemAttribute(String eventId, String itemId, EventItemAttribute itemAttribute) throws
            ConstantContactServiceException {
    	
    	if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (itemId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItemId());
        }
        if (itemAttribute == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItemAttribute());
        }
        
        EventItemAttribute eventItemAttribute = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItemAttributeId(), eventId, itemId, itemAttribute.getId()));
            String json = itemAttribute.toJSON();

            RawApiResponse response = getRestClient().put(url, json);
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
	 * @param eventId The id of the event.
	 * @param itemId The id of the event item.
	 * @param itemAttributeId The id of the event item attribute to delete.
	 * @return true on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    
    public boolean deleteEventItemAttribute(String eventId, String itemId, String itemAttributeId) throws
            ConstantContactServiceException {
    	
    	if (eventId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventId());
        }
        if (itemId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItemId());
        }
        if (itemAttributeId == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEventItemAttributeId());
        }
        
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                    String.format(Config.instance().getEventItemAttributeId(), eventId, itemId, itemAttributeId));

            RawApiResponse response = getRestClient().delete(url);
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
    public EventSpotService(String accessToken, String apiKey) {
        super(accessToken, apiKey);
        this.setAccessToken(accessToken);
        this.setApiKey(apiKey);
    }
}
