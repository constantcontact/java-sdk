package com.constantcontact.services.eventspot;

import com.constantcontact.components.Component;
import com.constantcontact.components.eventspot.*;
import com.constantcontact.components.eventspot.Registrant.Registrant;
import com.constantcontact.components.eventspot.Registrant.RegistrantDetails;
import com.constantcontact.components.generic.response.Pagination;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.CUrlRequestError;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;

import java.net.HttpURLConnection;
import java.util.ArrayList;
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
        List<EventFee> eventFees = null;
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
    public EventFee addEventFee(String accessToken, String eventId, EventFee eventFee) throws ConstantContactServiceException {
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
    public EventFee getEventFee(String accessToken, String eventId, String feeId) throws ConstantContactServiceException {
        EventFee eventFee = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_FEE_ID, eventId, feeId));

            CUrlResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                eventFee = Component.fromJSON(response.getBody(), EventFee.class);
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
        return eventFee;
    }

    @Override
    public EventFee updateEventFee(String accessToken, String eventId, EventFee eventFee) throws ConstantContactServiceException {
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

    @Override
    public boolean deleteEventFee(String accessToken, String eventId, String eventFeeId) throws ConstantContactServiceException {
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
    public List<Promocode> getEventPromocodes(String accessToken, String eventId) throws ConstantContactServiceException {
        List<Promocode> promocodes = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_PROMOCODES, eventId));

            CUrlResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                promocodes = Component.listFromJSON(response.getBody(), Promocode.class);
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
        return promocodes;
    }

    @Override
    public Promocode addEventPromocode(String accessToken, String eventId, Promocode promocode) throws ConstantContactServiceException {
        Promocode newPromocode = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_PROMOCODES, eventId));
            String json = promocode.toJSON();

            CUrlResponse response = getRestClient().post(url, accessToken, json);
            if (response.hasData()) {
                newPromocode = Component.fromJSON(response.getBody(), Promocode.class);
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
        return newPromocode;
    }

    @Override
    public Promocode getEventPromocode(String accessToken, String eventId, String promocodeId) throws ConstantContactServiceException {
        Promocode promocode = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_PROMOCODE_ID, eventId, promocodeId));

            CUrlResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                promocode = Component.fromJSON(response.getBody(), Promocode.class);
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
        return promocode;
    }

    @Override
    public Promocode updateEventPromocode(String accessToken, String eventId, Promocode promocode) throws ConstantContactServiceException {
        Promocode newPromocode = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_PROMOCODE_ID, eventId, promocode.getId()));
            String json = promocode.toJSON();

            CUrlResponse response = getRestClient().put(url, accessToken, json);
            if (response.hasData()) {
                newPromocode = Component.fromJSON(response.getBody(), Promocode.class);
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
        return newPromocode;
    }

    @Override
    public boolean deleteEventPromocode(String accessToken, String eventId, String promocodeId) throws ConstantContactServiceException {
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_PROMOCODE_ID, eventId, promocodeId));

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
    public ResultSet<Registrant> getEventRegistrants(String accessToken, String eventId, Integer limit) throws ConstantContactServiceException {
        ResultSet<Registrant> eventRegistrants = null;
        try {
            String url = paginateUrl(
                    String.format("%1$s%2$s", Config.Endpoints.BASE_URL, String.format(Config.Endpoints.EVENT_REGISTRANTS, eventId)), limit);

            CUrlResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                eventRegistrants = Component.resultSetFromJSON(response.getBody(), Registrant.class);
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
        return eventRegistrants;
    }

    @Override
    public RegistrantDetails getEventRegistrant(String accessToken,String eventId, String registrantId) throws ConstantContactServiceException {
        RegistrantDetails registrant = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_REGISTRANT_ID, eventId, registrantId));

            CUrlResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                registrant = Component.fromJSON(response.getBody(), RegistrantDetails.class);
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
        return registrant;
    }

    @Override
    public List<EventItem> getEventItems(String accessToken, String eventId) throws ConstantContactServiceException {
        List<EventItem> eventItems = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_ITEMS, eventId));

            CUrlResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                eventItems = Component.listFromJSON(response.getBody(), EventItem.class);
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
        return eventItems;
    }

    @Override
    public EventItem getEventItem(String accessToken, String eventId, String itemId) throws ConstantContactServiceException {
        EventItem eventItem = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_ITEM_ID, eventId, itemId));

            CUrlResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                eventItem = Component.fromJSON(response.getBody(), EventItem.class);
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
        return eventItem;
    }

    @Override
    public EventItem addEventItem(String accessToken, String eventId, EventItem eventItem) throws ConstantContactServiceException {
        EventItem newEventItem = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_ITEMS, eventId));
            String json = eventItem.toJSON();

            CUrlResponse response = getRestClient().post(url, accessToken, json);
            if (response.hasData()) {
                newEventItem = Component.fromJSON(response.getBody(), EventItem.class);
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
        return newEventItem;

    }

    @Override
    public EventItem updateEventItem(String accessToken, String eventId, EventItem item) throws ConstantContactServiceException {
        EventItem eventItem = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_ITEM_ID, eventId, item.getId()));
            String json = item.toJSON();

            CUrlResponse response = getRestClient().put(url, accessToken, json);
            if (response.hasData()) {
                eventItem = Component.fromJSON(response.getBody(), EventItem.class);
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
        return eventItem;
    }

    @Override
    public boolean deleteEventItem(String accessToken, String eventId, String itemId) throws ConstantContactServiceException {
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_ITEM_ID, eventId, itemId));

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
    public List<EventItemAttribute> getEventItemAttributes(String accessToken, String eventId, String itemId) throws ConstantContactServiceException {
        List<EventItemAttribute> eventItemAttributes = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_ITEM_ATTRIBUTES, eventId, itemId));

            CUrlResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                eventItemAttributes = Component.listFromJSON(response.getBody(), EventItemAttribute.class);
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
        return eventItemAttributes;
    }

    @Override
    public EventItemAttribute getEventItemAttribute(String accessToken, String eventId, String itemId, String itemAttributeId) throws
            ConstantContactServiceException {
        EventItemAttribute eventItemAttribute = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_ITEM_ATTRIBUTE_ID, eventId, itemId, itemAttributeId));

            CUrlResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                eventItemAttribute = Component.fromJSON(response.getBody(), EventItemAttribute.class);
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
        return eventItemAttribute;
    }

    @Override
    public EventItemAttribute updateEventItemAttribute(String accessToken, String eventId, String itemId, EventItemAttribute itemAttribute) throws
            ConstantContactServiceException {
        EventItemAttribute eventItemAttribute = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_ITEM_ATTRIBUTE_ID, eventId, itemId, itemAttribute.getId()));
            String json = itemAttribute.toJSON();

            CUrlResponse response = getRestClient().put(url, accessToken, json);
            if (response.hasData()) {
                eventItemAttribute = Component.fromJSON(response.getBody(), EventItemAttribute.class);
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
        return eventItemAttribute;
    }

    @Override
    public boolean deleteEventItemAttribute(String accessToken, String eventId, String itemId, String itemAttributeId) throws
            ConstantContactServiceException {
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_ITEM_ATTRIBUTE_ID, eventId, itemId, itemAttributeId));

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
    public Event updateEvent(String accessToken, Event event) throws ConstantContactServiceException {
        Event updatedEvent = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_ID, event.getId()));
            String json = event.toJSON();

            CUrlResponse response = getRestClient().put(url, accessToken, json);
            if (response.hasData()) {
                updatedEvent = Component.fromJSON(response.getBody(), Event.class);
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
        return updatedEvent;
    }

    @Override
    public boolean updateEventStatus(String accessToken, String eventId, String status) throws ConstantContactServiceException {
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENT_ID, eventId));

            EventUpdateStatus eventUpdateStatus = new EventUpdateStatus(status);
            List<EventUpdateStatus> eventUpdateStatusRequestList = new ArrayList<EventUpdateStatus>();
            eventUpdateStatusRequestList.add(eventUpdateStatus);
            EventUpdateStatusRequest eventUpdateStatusRequest = new EventUpdateStatusRequest(eventUpdateStatusRequestList);
            String json = eventUpdateStatusRequest.toJSON();

            CUrlResponse response = getRestClient().patch(url, accessToken, json);
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

    /**
     * Default constructor.
     */
    public EventSpotService() {
        super();
    }
}
