package com.constantcontact.services.eventspot;

import com.constantcontact.components.Component;
import com.constantcontact.components.eventspot.Event;
import com.constantcontact.components.eventspot.EventFee;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.CUrlRequestError;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;

import java.net.HttpURLConnection;
import java.util.List;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class EventSpotService extends BaseService implements IEventSpotService {


    public Event getEvent(String accessToken, String eventId) throws
            ConstantContactServiceException {
        Event event = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_ID, eventId));

            CUrlResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                event = Component.fromJSON(response.getBody(), Event.class);
            }
            if (response.isError()) {
                ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                        ConstantContactServiceException.RESPONSE_ERR_SERVICE);
                response.getInfo().add(new CUrlRequestError("url", url));
                constantContactException.setErrorInfo(response.getInfo());
                throw constantContactException;
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return event;
    }

    @Override
    public ResultSet<Event> getEvents(String accessToken, Integer limit) throws ConstantContactServiceException {
            ResultSet<Event> events = null;
            try {
                String url = paginateUrl(
                        String.format("%1$s%2$s", Config.Endpoints.BASE_URL, Config.Endpoints.EVENTS), limit);

                CUrlResponse response = getRestClient().get(url, accessToken);

                if (response.hasData()) {
                    events = Component.resultSetFromJSON(response.getBody(), Event.class);
                }
                if (response.isError()) {
                    ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                            ConstantContactServiceException.RESPONSE_ERR_SERVICE);
                    response.getInfo().add(new CUrlRequestError("url", url));
                    constantContactException.setErrorInfo(response.getInfo());
                    throw constantContactException;
                }
            } catch (ConstantContactServiceException e) {
                throw new ConstantContactServiceException(e);
            } catch (Exception e) {
                throw new ConstantContactServiceException(e);
            }
            return events;
    }

    @Override
    public Event addEvent(String accessToken, Event event) throws ConstantContactServiceException {
        Event newEvent = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, Config.Endpoints.EVENTS);
            String json = event.toJSON();

            CUrlResponse response = getRestClient().post(url, accessToken, json);
            if (response.hasData()) {
                newEvent = Component.fromJSON(response.getBody(), Event.class);
            }
            if (response.isError()) {
                ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                        ConstantContactServiceException.RESPONSE_ERR_SERVICE);
                response.getInfo().add(new CUrlRequestError("url", url));
                constantContactException.setErrorInfo(response.getInfo());
                throw constantContactException;
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return newEvent;
    }

    @Override
    public List<EventFee> getEventFees(String accessToken, String eventId) throws ConstantContactServiceException {
        List<EventFee> eventFees= null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_FEES, eventId));

            CUrlResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                eventFees = Component.listFromJSON(response.getBody(), EventFee.class);
            }
            if (response.isError()) {
                ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                        ConstantContactServiceException.RESPONSE_ERR_SERVICE);
                response.getInfo().add(new CUrlRequestError("url", url));
                constantContactException.setErrorInfo(response.getInfo());
                throw constantContactException;
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return eventFees;
    }

    @Override
    public EventFee addEventFee(String accessToken, String eventId, EventFee eventFee) throws
            ConstantContactServiceException {
        EventFee newEventFee = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_FEES, eventId));
            String json = eventFee.toJSON();

            CUrlResponse response = getRestClient().post(url, accessToken, json);
            if (response.hasData()) {
                newEventFee = Component.fromJSON(response.getBody(), EventFee.class);
            }
            if (response.isError()) {
                ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                        ConstantContactServiceException.RESPONSE_ERR_SERVICE);
                response.getInfo().add(new CUrlRequestError("url", url));
                constantContactException.setErrorInfo(response.getInfo());
                throw constantContactException;
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return newEventFee;
    }

    @Override
    public boolean deleteEventFee(String accessToken, String eventId, String eventFeeId) throws
            ConstantContactServiceException {
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_FEE_ID, eventId, eventFeeId));

            CUrlResponse response = getRestClient().delete(url, accessToken);
            if (response.isError()) {
                ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                        ConstantContactServiceException.RESPONSE_ERR_SERVICE);
                response.getInfo().add(new CUrlRequestError("url", url));
                constantContactException.setErrorInfo(response.getInfo());
                throw constantContactException;
            }
            return response.getStatusCode() == HttpURLConnection.HTTP_NO_CONTENT;
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
    }

    @Override
    public EventFee updateEventFee(String accessToken, String eventId, EventFee eventFee) throws
            ConstantContactServiceException {
        EventFee newEventFee = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_FEE_ID, eventId, eventFee.getId()));
            String json = eventFee.toJSON();

            CUrlResponse response = getRestClient().put(url, accessToken, json);
            if (response.hasData()) {
                newEventFee = Component.fromJSON(response.getBody(), EventFee.class);
            }
            if (response.isError()) {
                ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                        ConstantContactServiceException.RESPONSE_ERR_SERVICE);
                response.getInfo().add(new CUrlRequestError("url", url));
                constantContactException.setErrorInfo(response.getInfo());
                throw constantContactException;
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return newEventFee;
    }

    /**
     * Default constructor.
     */
    public EventSpotService() {
        super();
    }
}
