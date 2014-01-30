package com.constantcontact.services.eventspot;

import com.constantcontact.components.eventspot.Event;
import com.constantcontact.components.eventspot.EventFee;
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

    public EventFee addEventFee(String accessToken, String eventId, EventFee eventFee) throws
            ConstantContactServiceException;

    public boolean deleteEventFee(String accessToken, String eventId, String eventFeeId) throws
            ConstantContactServiceException;

    public EventFee updateEventFee(String accessToken, String eventId, EventFee eventFee) throws
            ConstantContactServiceException;
}
