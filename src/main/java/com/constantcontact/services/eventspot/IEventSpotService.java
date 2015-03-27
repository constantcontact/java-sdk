package com.constantcontact.services.eventspot;

import com.constantcontact.components.eventspot.*;
import com.constantcontact.components.eventspot.Registrant.Registrant;
import com.constantcontact.components.eventspot.Registrant.RegistrantDetails;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.IBaseService;

import java.util.List;

/**
 * Interface for {@link EventSpotService} class in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public interface IEventSpotService extends IBaseService {
    
	/**
	 * Gets all the Events.<br/>
	 * Implements the get Events operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param limit The limit
	 * @return A {@link ResultSet} of {@link Event} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public ResultSet<Event> getEvents(Integer limit) throws ConstantContactServiceException;
	
	/**
	 * Gets a single Event.<br/>
	 * Implements the get Event operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param eventId The id of the event to get
	 * @return An {@link Event} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public Event getEvent(String eventId) throws ConstantContactServiceException;

	/**
	 * Adds a single Event.<br/>
	 * Implements the add Event operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param event The Event to add
	 * @return An {@link Event} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public Event addEvent(Event event) throws ConstantContactServiceException;

	/**
	 * Updates a single Event.<br/>
	 * Implements the update Event operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param event The event to update.
	 * @return An {@link Event} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public Event updateEvent(Event event) throws ConstantContactServiceException;
	
	/**
	 * Updates a single Event status.<br/>
	 * Implements the update Event Status operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param eventId The id of the event to update.
	 * @param status The status of the event.
	 * @return true on success;<br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public boolean updateEventStatus(String eventId, String status) throws ConstantContactServiceException;
	/**
	 * Gets all the Event Fees.<br/>
	 * Implements the get Event Fees operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param eventId The event id.
	 * @return A {@link List} of {@link EventFee} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public List<EventFee> getEventFees(String eventId) throws ConstantContactServiceException;	

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
    public EventFee getEventFee(String eventId, String feeId) throws ConstantContactServiceException;

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
    public EventFee addEventFee(String eventId, EventFee eventFee) throws ConstantContactServiceException;

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
    public EventFee updateEventFee(String eventId, EventFee eventFee) throws ConstantContactServiceException;

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
    public boolean deleteEventFee(String eventId, String eventFeeId) throws ConstantContactServiceException;

	/**
	 * Gets all the Event Promocodes.<br/>
	 * Implements the get Event Promocodes operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param eventId The event id.
	 * @return A {@link List} of {@link Promocode} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public List<Promocode> getEventPromocodes(String eventId) throws ConstantContactServiceException;

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
    public Promocode getEventPromocode(String eventId, String promocodeId) throws ConstantContactServiceException;
	
	/**
	 * Adds a single Event Promocode.<br/>
	 * Implements the add Event Promocode operation of the EventSpot API by calling the ConstantContact server side.
	 * @param eventId The id of the event.
	 * @param promocode The event promocode to add.
	 * @return An {@link Promocode} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public Promocode addEventPromocode(String eventId, Promocode promocode) throws ConstantContactServiceException;

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
    public Promocode updateEventPromocode(String eventId, Promocode promocode) throws ConstantContactServiceException;
	
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
    public boolean deleteEventPromocode(String eventId, String promocodeId) throws  ConstantContactServiceException;

	/**
	 * Gets all the Event Registrants.<br/>
	 * Implements the get Event Registrants operation of the EventSpot API by calling the ConstantContact server side.
	 * @param eventId The id of the event.
	 * @param limit The limit.
	 * @return A {@link ResultSet} of {@link Registrant} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public ResultSet<Registrant> getEventRegistrants(String eventId, Integer limit) throws ConstantContactServiceException;
	
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
    public RegistrantDetails getEventRegistrant(String eventId, String registrantId) throws  ConstantContactServiceException;

	/**
	 * Gets all the Event Items.<br/>
	 * Implements the get Event Items operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param eventId The event id.
	 * @return A {@link List} of {@link EventItem} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public List<EventItem> getEventItems(String eventId) throws  ConstantContactServiceException;

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
    public EventItem getEventItem(String eventId, String itemId) throws ConstantContactServiceException;

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
    public EventItem addEventItem(String eventId, EventItem eventItem) throws ConstantContactServiceException;

	/**
	 * Updates a single Event Item.<br/>
	 * Implements the update Event Item operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param eventId The id of the event.
	 * @param eventItem The event item to update.
	 * @return An {@link EventItem} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public EventItem updateEventItem(String eventId, EventItem eventItem) throws ConstantContactServiceException;

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
    public boolean deleteEventItem(String eventId, String itemId) throws  ConstantContactServiceException;

	/**
	 * Gets all the Event Item Attributes.<br/>
	 * Implements the get Event Item Attributes operation of the EventSpot API by calling the ConstantContact server side.
	 * 
	 * @param eventId The event id.
	 * @param itemId The event item id.
	 * @return A {@link List} of {@link EventItemAttribute} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public List<EventItemAttribute> getEventItemAttributes(String eventId, String itemId) throws  ConstantContactServiceException;

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
    public EventItemAttribute getEventItemAttribute( String eventId, String itemId, String itemAttributeId) throws ConstantContactServiceException;

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
            ConstantContactServiceException;

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
    public EventItemAttribute updateEventItemAttribute(String eventId, String itemId,
                                                       EventItemAttribute itemAttribute) throws ConstantContactServiceException;
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
    public boolean deleteEventItemAttribute(String eventId, String itemId, String itemAttributeId) throws  ConstantContactServiceException;


}
