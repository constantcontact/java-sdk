package com.constantcontact.test;

import com.constantcontact.ConstantContact;
import com.constantcontact.components.eventspot.*;
import com.constantcontact.components.eventspot.Registrant.Registrant;
import com.constantcontact.components.eventspot.Registrant.RegistrantDetails;
import com.constantcontact.components.generic.response.Pagination;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.util.CUrlRequestError;

import java.util.Date;
import java.util.List;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class TestApi {
    static String apiKey = "3jcus43p8gjnds7esukcpfj9";
    static String accessToken = "66f0f8ca-1baa-426b-954f-394cc2826158";
    static ConstantContact constantContact = new ConstantContact(apiKey, accessToken);

    static Date date = new Date();

    public static void main(String[] args) {

        System.out.print("Hello world!");

        try {
            /**
             * Single event
             */
            //Event event = constantContact.getEvent("1116384459825");
            //System.out.println(event);

            /**
             * Events fetch
             */
            getEvents();

            /**
             * Create event
             */

            // createEvent(event);

            /**
             * Add event fees
             */

            // addEventFee(event.getId());

            /**
             * Update event
             */
            //updateEvent(event);

            /**
             * Change event status
             */
            changeEventStatus("a07e8uxb7ph0e2a1ac4");

            /**
             * Get event fees
             */
            //List<EventFee> eventFees = getEventFees(event.getId());

            /**
             * Delete eventFee
             */
            //deleteEventFee(event.getId(), eventFees.get(eventFees.size() - 1).getId());

            /**
             * Update eventFee
             */
            //updateEventFee(event.getId(), eventFees.get(eventFees.size() - 1));

            /**
             * Get eventFee
             */
            //getEventFee(event.getId(), eventFees.get(eventFees.size() - 1).getId());

            /**
             * Get event promocodes
             */

            //List<Promocode> promocodes = getEventPromocodes(event.getId());

            /**
             * Create new promocode
             */
            //createPromocode(event.getId());

            /**
             * Update promocode
             */
            //updatePromocode(event.getId(), promocodes.get(0));

            /**
             * Delete promocode
             */
            //deleteEventPromocode(event.getId(), promocodes.get(promocodes.size() - 1).getId());

            /**
             * Get event promocode
             */
            //getEventPromocode(event.getId(), promocodes.get(0).getId());

            /**
             * Get event registrants
             */
            //getEventRegistrants(event.getId());

            /**
             * Get event registrant
             */
        
           //getEventRegistrant(event.getId(), "001T65la4A0GRPXM35QZr7RyhleHRebJt8ltBqfdO4xyPRo_7Ujlsq0F_pInQP21iiQ");


            /**
             * Get event items
             */
        
            //getEventItems(event.getId());

            /**
             * Get event item
             */
            //EventItem eventItem = getEventItem(event.getId(), "ZKAA2drSaJvCFAzdDYAYyYPJUvBGM9P1V53KQcYO8Aw");

            /**
             * Post event item
             */
            //addEventItem(event.getId());

            /**
             * Update event item
             */
            //updateEventItem(event.getId(), eventItem);

            /**
             * Delete an event item
             */
            //deleteEventItem(event.getId(), "ZKAA2drSaJvCFAzdDYAYybIwqpZ7nzW2Y09fUs00t3Q");

            /**
             * Get event item attributes
             */
            //List<EventItemAttribute> eventItemAttributes = getEventItemAttributes(event.getId(), "ZKAA2drSaJvCFAzdDYAYyYPJUvBGM9P1V53KQcYO8Aw");

            /**
             * Get event item attribute
             */
            //getEventItemAttribute(event.getId(), "ZKAA2drSaJvCFAzdDYAYyYPJUvBGM9P1V53KQcYO8Aw", eventItemAttributes.get(0).getId());

            /**
             * Update event item attribute
             */
            //updateEventItemAttribute(event.getId(), "ZKAA2drSaJvCFAzdDYAYyYPJUvBGM9P1V53KQcYO8Aw", eventItemAttributes.get(0));

            /**
             * Delete an event item attribute
             */
            //deleteEventItemAttribute(event.getId(), "ZKAA2drSaJvCFAzdDYAYyYPJUvBGM9P1V53KQcYO8Aw", eventItemAttributes.get(1).getId());

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            for (CUrlRequestError error : e.getErrorInfo()) {
                System.out.println(error);
            }
        }
    }

    private static void changeEventStatus(String eventId) throws ConstantContactServiceException {
        System.out.println("\nchangeEventStatus\n");
        constantContact.updateEventStatus(eventId, Event.Status.ACTIVE);
    }

    private static Event updateEvent(Event event) throws ConstantContactServiceException {
        System.out.println("\nupdateEvent\n");
        event.setName("Updated at - " + date.toString());
        Event event1 = constantContact.updateEvent(event);
        System.out.println(event1);
        return event1;
    }

    private static void deleteEventItemAttribute(String eventId, String itemId, String itemAttributeId) throws ConstantContactServiceException {
        System.out.println("\ndeleteEventItemAttribute\n");
        System.out.println(constantContact.deleteEventItemAttribute(eventId, itemId, itemAttributeId));
    }

    private static EventItemAttribute updateEventItemAttribute(String eventId, String itemId, EventItemAttribute itemAttribute)  throws
            ConstantContactServiceException {
        System.out.println("\nupdateEventItemAttribute\n");
        itemAttribute.setName("Option2");
        itemAttribute.setQuantityAvailable(100);
        itemAttribute.setQuantityTotal(200);
        EventItemAttribute eventItemAttribute = constantContact.updateEventItemAttribute(eventId, itemId, itemAttribute);
        System.out.println(eventItemAttribute);
        return eventItemAttribute;
    }

    private static EventItemAttribute getEventItemAttribute(String eventId, String itemId,
                                                            String itemAttributeId) throws  ConstantContactServiceException {
        System.out.println("\ngetEventItemAttribute\n");
        EventItemAttribute eventItemAttribute = constantContact.getEventItemAttribute(eventId, itemId, itemAttributeId);
        System.out.println(eventItemAttribute);
        return eventItemAttribute;
    }

    private static List<EventItemAttribute> getEventItemAttributes(String eventId, String itemId) throws ConstantContactServiceException{
        System.out.println("\ngetEventItemAttributes\n");
        List<EventItemAttribute> eventItemAttributes = constantContact.getEventItemAttributes(eventId, itemId);
        System.out.println(eventItemAttributes);
        return eventItemAttributes;
    }

    private static void deleteEventItem(String eventId, String itemId) throws ConstantContactServiceException{
        System.out.println("\ndeleteEventItem\n");
        System.out.println(constantContact.deleteEventItem(eventId, itemId));
    }

    private static void updateEventItem(String eventId, EventItem item) throws ConstantContactServiceException {
        System.out.println("\nupdateEventItem\n");
        item.setDescription("This description was updated from the API");
        EventItem eventItem = constantContact.updateEventItem(eventId, item);
    }

    private static EventItem addEventItem(String eventId) throws ConstantContactServiceException {
        EventItem eventItem = new EventItem();
        eventItem.setName("FromAPI2");
        eventItem.setDefaultQuantityAvailable(20);
        eventItem.setDefaultQuantityTotal(100);
        eventItem.setDescription("This is an item created from java SDK");
        eventItem.setPerRegistrantLimit(5);
        eventItem.setPrice(0.00);
        eventItem.setShowQuantityAvailable(true);
        EventItem createdEventItem = constantContact.addEventItem(eventId, eventItem);
        System.out.println(createdEventItem);
        return createdEventItem;
    }

    private static EventItem getEventItem(String eventId, String itemId) throws  ConstantContactServiceException{
        System.out.println("\ngetEventItem\n");
        EventItem eventItem = constantContact.getEventItem(eventId, itemId);
        System.out.println(eventItem);
        return eventItem;
    }

    private static List<EventItem> getEventItems(String eventId) throws ConstantContactServiceException {
        System.out.println("\ngetEventItems\n");
        List<EventItem> eventItems = constantContact.getEventItems(eventId);
        System.out.println(eventItems);
        return eventItems;
    }

    private static RegistrantDetails getEventRegistrant(String eventId, String registrantId) throws ConstantContactServiceException{
        System.out.println("\ngetEventRegistrant\n");
        RegistrantDetails registrant = constantContact.getEventRegistrant(eventId, registrantId);
        System.out.println(registrant);

        return registrant;
    }

    private static ResultSet<Registrant> getEventRegistrants(String eventId) throws ConstantContactServiceException {
        System.out.println("\ngetEventRegistrats\n");

        ResultSet<Registrant> eventRegistrants = constantContact.getEventRegistrants(eventId, 50);

        for (Registrant eventRegistrant : eventRegistrants.getResults()) {
            System.out.println(eventRegistrant);
        }
       return eventRegistrants;
    }

    private static void getEventFee(String eventId, String feeId) throws ConstantContactServiceException {
        System.out.println("\ngetEventFee:\n");
        System.out.println(constantContact.getEventFee(eventId, feeId));
    }

    private static void getEventPromocode(String eventId, String promocodeId) throws ConstantContactServiceException {
        System.out.println("\ngetEventPromocode:\n");
        System.out.println(constantContact.getEventPromocode(eventId, promocodeId));
    }

    private static boolean deleteEventPromocode(String eventId, String promocodeId) throws ConstantContactServiceException {
        System.out.println("\ndeleteEventPromocode:\n");
        return constantContact.deleteEventPromocode(eventId, promocodeId);
    }

    private static Promocode updatePromocode(String eventId, Promocode promocode) throws ConstantContactServiceException {
        System.out.println("\nupdatePromocode:\n");
        promocode.setDiscountAmount(12.3);
        promocode.setCodeName(("UP" + date.getTime()).substring(0, 11));
        return constantContact.updateEventPromocode(eventId, promocode);
    }

    private static void createPromocode(String eventId) throws ConstantContactServiceException {
        System.out.println("\ncreatePromocode:\n");
        Promocode promocode = new Promocode();
        promocode.setCodeName(("CR_" + date.getTime()).substring(4, 12));
        promocode.setCodeType(Promocode.CodeType.DISCOUNT);
        promocode.setDiscountAmount(13.20);
        promocode.setDiscountScope(Promocode.DiscountScope.ORDER_TOTAL);
        promocode.setQuantityTotal(10);
        promocode.setStatus(Promocode.Status.LIVE);
        constantContact.addEventPromocode(eventId, promocode);
    }

    private static List<Promocode> getEventPromocodes(String eventId) throws ConstantContactServiceException {
        System.out.println("\ngetEventPromocodes\n");
        List<Promocode> promocodes = constantContact.getEventPromocodes(eventId);
        for (Promocode promocode : promocodes) {
            System.out.println(promocode);
        }
        return promocodes;
    }

    private static void updateEventFee(String eventId, EventFee eventFee) throws ConstantContactServiceException {
        System.out.println("\nupdateEventFee\n");
        eventFee.setLabel("Updated at - " + date.toString());
        constantContact.updateEventFee(eventId, eventFee);
    }

    private static void deleteEventFee(String eventId, String eventFeeId) throws ConstantContactServiceException {
        System.out.println("\ndeleteEventFee\n");
        constantContact.deleteEventFee(eventId, eventFeeId);
    }

    private static List<EventFee> getEventFees(String eventId) throws ConstantContactServiceException {
        System.out.println("\ngetEventFees:\n");
        List<EventFee> eventFees = constantContact.getEventFees(eventId);

        for (EventFee evFee : eventFees) {
            System.out.println(evFee);
        }
        return eventFees;
    }

    private static void addEventFee(String eventId) throws ConstantContactServiceException {
        System.out.println("\naddEventFee:\n");
        EventFee eventFee = new EventFee();

        eventFee.setLabel("My Fee Label - " + date.toString());
        eventFee.setFee(105.03);
        eventFee.setEarlyFee(54.32);
        eventFee.setLateFee(125.31);
        eventFee.setFeeScope(EventFee.Scopes.BOTH);
        System.out.println(constantContact.addEventFee(eventId, eventFee));
    }

    private static void getEvents() throws ConstantContactServiceException {
        System.out.println("\ngetEvents:\n");
        ResultSet<Event> events = constantContact.getEvents(50);

        //System.out.println(events.getMeta().getPagination().getNextLink());
        for (Event e : events.getResults()) {
            System.out.println(e);
        }

        Pagination pagination = events.getMeta().getPagination();
        while (pagination.getNextLink() != null) {
            events = constantContact.getEvents(pagination);
            pagination = events.getMeta().getPagination();
            for (Event e : events.getResults()) {
                System.out.println(e);
            }
        }
    }

    private static void createEvent(Event event) throws ConstantContactServiceException {
        System.out.println("\ncreateEvent:\n");
        event.setName("Event4");
        //event.setTimeZoneDescription("Help text!");
        event.setStartDate("2014-01-30T15:00:00.000Z");
        //event.setAddress(null);
//        System.out
//                .println("Timezone Description : " + event.getTimeZoneDescription());
        System.out.println("Name: " + event.getContact().getName());
        Event ev2 = constantContact.addEvent(event);
        System.out.println(ev2);
    }
}
