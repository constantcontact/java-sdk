package com.constantcontact.services.eventspot;

import com.constantcontact.components.eventspot.*;
import com.constantcontact.components.eventspot.Registrant.Registrant;
import com.constantcontact.components.eventspot.Registrant.RegistrantDetails;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.IBaseService;

import java.util.List;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public interface IEventSpotService extends IBaseService {

    //Todo documentation
    public Event getEvent(String accessToken, String eventId) throws ConstantContactServiceException;

    public ResultSet<Event> getEvents(String accessToken, Integer limit) throws ConstantContactServiceException;

    public Event addEvent(String accessToken, Event event) throws ConstantContactServiceException;

    public List<EventFee> getEventFees(String accessToken, String eventId) throws ConstantContactServiceException;

    public EventFee addEventFee(String accessToken, String eventId, EventFee eventFee) throws ConstantContactServiceException;

    public EventFee getEventFee(String accessToken, String eventId, String feeId) throws ConstantContactServiceException;

    public EventFee updateEventFee(String accessToken, String eventId, EventFee eventFee) throws ConstantContactServiceException;

    public boolean deleteEventFee(String accessToken, String eventId, String eventFeeId) throws ConstantContactServiceException;

    public List<Promocode> getEventPromocodes(String accessToken, String eventId) throws ConstantContactServiceException;

    public Promocode addEventPromocode(String accessToken, String eventId, Promocode promocode) throws ConstantContactServiceException;

    public Promocode getEventPromocode(String accessToken, String eventId, String promocodeId) throws ConstantContactServiceException;

    public Promocode updateEventPromocode(String accessToken, String eventId, Promocode promocode) throws ConstantContactServiceException;

    public boolean deleteEventPromocode(String accessToken, String eventId, String promocodeId) throws  ConstantContactServiceException;

    public ResultSet<Registrant> getEventRegistrants(String accessToken, String eventId, Integer limit) throws ConstantContactServiceException;

    public RegistrantDetails getEventRegistrant(String accessToken, String eventId, String registrantId) throws  ConstantContactServiceException;

    public List<EventItem> getEventItems(String accessToken, String eventId) throws  ConstantContactServiceException;

    public EventItem getEventItem(String accessToken, String eventId, String itemId) throws ConstantContactServiceException;

    public EventItem addEventItem(String accessToken, String eventId, EventItem eventItem) throws ConstantContactServiceException;

    public EventItem updateEventItem(String accessToken, String eventId, EventItem item) throws ConstantContactServiceException;

    public boolean deleteEventItem(String accessToken, String eventId, String itemId) throws  ConstantContactServiceException;

    public List<EventItemAttribute> getEventItemAttributes(String accessToken, String eventId, String itemId) throws  ConstantContactServiceException;

    public EventItemAttribute getEventItemAttribute(String accessToken, String eventId, String itemId, String itemAttributeId) throws ConstantContactServiceException;

    public EventItemAttribute updateEventItemAttribute(String accessToken, String eventId, String itemId,
                                                       EventItemAttribute itemAttribute) throws ConstantContactServiceException;

    public boolean deleteEventItemAttribute(String accessToken, String eventId, String itemId, String itemAttributeId) throws  ConstantContactServiceException;

    public Event updateEvent(String accessToken, Event event) throws ConstantContactServiceException;

    public boolean updateEventStatus(String accessToken, String eventId, String status) throws ConstantContactServiceException;
}
