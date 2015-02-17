import com.constantcontact.ConstantContact;
import com.constantcontact.components.eventspot.*;
import com.constantcontact.components.eventspot.Registrant.RegistrantDetails;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import mockup.EventSpotServiceTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by Cristiana on 2/11/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactEventSpotTest {

    ConstantContact constantContact;

    @Before
    public void beforeTests(){
        constantContact = Mockito.spy(new ConstantContact("", ""));
        constantContact.setEventSpotService(new EventSpotServiceTest());
    }

    /**
     * Tests the getEvent method from ConstantContact.class
     *
     */
    @Test
    public void getEventTest(){
        String eventId = "1";

        try {
            Event event = mock(Event.class);

            event = constantContact.getEvent(eventId);
            verify(constantContact).getEvent(eventId);

            assertNotNull(event);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getEvents method from ConstantContact.class
     *
     */
    @Test
    public void getEventsTest(){
        int limit = 1;

        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = constantContact.getEvents(limit);
            verify(constantContact).getEvents(limit);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the addEvent method from ConstantContact.class
     *
     */
    @Test
    public void addEventTest(){
        try {

            Event event = mock(Event.class);

            Event resultEvent = constantContact.addEvent(event);
            verify(constantContact).addEvent(event);

            assertNotNull(resultEvent);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the addEvent method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void addEventExceptionTest(){
        try {

            Event event =null;

            Event resultEvent = constantContact.addEvent(event);
            verify(constantContact).addEvent(event);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the updateEvent method from ConstantContact.class
     *
     */
    @Test
    public void updateEventTest(){


        try {

            Event event = mock(Event.class);

            Event resultEvent = constantContact.updateEvent(event);
            verify(constantContact).updateEvent(event);

            assertNotNull(resultEvent);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the updateEvent method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void updateEventExceptionTest(){
        try {

            Event event =null;

            Event resultEvent = constantContact.updateEvent(event);
            verify(constantContact).updateEvent(event);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the updateEventStatus method from ConstantContact.class
     *
     */
    @Test
    public void updateEventStatusTest(){
        String eventId = "1";
        String status = "test";

        try {

            boolean updated = constantContact.updateEventStatus(eventId, status);
            verify(constantContact).updateEventStatus(eventId, status);

            assertTrue(updated);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the updateEventStatus method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void updateEventStatusExpectedTest(){
        String eventId = null;
        String status = null;

        try {

            boolean updated = constantContact.updateEventStatus(eventId, status);
            verify(constantContact).updateEventStatus(eventId, status);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getEventFees method from ConstantContact.class
     *
     */
    @Test
    public void getEventFeesTest(){
        String eventId = "1";

        try {

            List list = mock(List.class);

            list = constantContact.getEventFees(eventId);
            verify(constantContact).getEventFees(eventId);

            assertNotNull(list);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getEventFees method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEventFeesExceptionTest(){
        String eventId = null;

        try {

            List list = mock(List.class);

            list = constantContact.getEventFees(eventId);
            verify(constantContact).getEventFees(eventId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the addEventFee method from ConstantContact.class
     *
     */
    @Test
    public void addEventFeeTest(){
        String eventId = "1";

        try {

            EventFee eventFee = mock(EventFee.class);

            EventFee resultEventFee = constantContact.addEventFee(eventId, eventFee);
            verify(constantContact).addEventFee(eventId, eventFee);

            assertNotNull(resultEventFee);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the updateEvent method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void addEventFeeExpectedTest(){
        String eventId = null;

        try {

            EventFee eventFee = null;

            EventFee resultEventFee = constantContact.addEventFee(eventId, eventFee);
            verify(constantContact).addEventFee(eventId, eventFee);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getEventFee method from ConstantContact.class
     *
     */
    @Test
    public void getEventFeeTest(){
        String eventId = "1";
        String eventFeeId = "1";
        EventFee eventFee = mock(EventFee.class);

        try {

            eventFee = constantContact.getEventFee(eventId, eventFeeId);
            verify(constantContact).getEventFee(eventId, eventFeeId);

            assertNotNull(eventFee);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getEventFee method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEventFeeExceptionTest(){
        String eventId = null;
        String eventFeeId = null;
        EventFee eventFee = mock(EventFee.class);

        try {

            eventFee = constantContact.getEventFee(eventId, eventFeeId);
            verify(constantContact).getEventFee(eventId, eventFeeId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the updateEventFee method from ConstantContact.class
     *
     */
    @Test
    public void updateEventFeeTest(){
        String eventId = "1";
        EventFee eventFee = new EventFee();
        eventFee.setId("1");

        try {

            EventFee resultEventFee = constantContact.updateEventFee(eventId, eventFee);
            verify(constantContact).updateEventFee(eventId, eventFee);

            assertNotNull(resultEventFee);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the updateEventFee method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void updateEventFeeExceptionTest(){
        String eventId = null;
        EventFee eventFee = null;

        try {

            EventFee resultEventFee = constantContact.updateEventFee(eventId, eventFee);
            verify(constantContact).updateEventFee(eventId, eventFee);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the deleteEventFee method from ConstantContact.class
     *
     */
    @Test
    public void  deleteEventFeeTest(){
        String eventId = "1";
        EventFee eventFee = new EventFee();
        String eventFeeId = "1";
        eventFee.setId(eventFeeId);

        try {

            boolean deleted = constantContact.deleteEventFee(eventId, eventFee);
            verify(constantContact).deleteEventFee(eventId, eventFee);

            assertTrue(deleted);

            deleted = constantContact.deleteEventFee(eventId, eventFeeId);
            verify(constantContact).deleteEventFee(eventId, eventFeeId);

            assertTrue(deleted);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the deleteEventFee method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void  deleteEventFeeExceptionTest(){
        String eventId = null;
        EventFee eventFee = null;

        try {

            boolean deleted = constantContact.deleteEventFee(eventId, eventFee);
            verify(constantContact).deleteEventFee(eventId, eventFee);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getEventPromocodes method from ConstantContact.class
     *
     */
    @Test
    public void getEventPromocodesTest(){
        String eventId = "1";
        List list = mock(List.class);

        try {

            list = constantContact.getEventPromocodes(eventId);
            verify(constantContact).getEventPromocodes(eventId);

            assertNotNull(list);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getEventPromocodes method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEventPromocodesExceptionTest(){
        String eventId = null;
        List list = mock(List.class);

        try {

            list = constantContact.getEventPromocodes(eventId);
            verify(constantContact).getEventPromocodes(eventId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the addEventPromocode method from ConstantContact.class
     *
     */
    @Test
    public void addEventPromocodeTest(){
        String eventId = "1";
        Promocode promocode = mock(Promocode.class);

        try {

            Promocode resultPromocode = constantContact.addEventPromocode(eventId, promocode);
            verify(constantContact).addEventPromocode(eventId, promocode);

            assertNotNull(resultPromocode);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the addEventPromocode method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void addEventPromocodeExceptionTest(){
        String eventId = null;
        Promocode promocode = null;

        try {

            Promocode resultPromocode = constantContact.addEventPromocode(eventId, promocode);
            verify(constantContact).addEventPromocode(eventId, promocode);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getEventPromocode method from ConstantContact.class
     *
     */
    @Test
    public void getEventPromocodeTest(){
        String eventId = "1";
        String promocodeId = "1";
        Promocode promocode = mock(Promocode.class);

        try {

            promocode = constantContact.getEventPromocode(eventId, promocodeId);
            verify(constantContact).getEventPromocode(eventId, promocodeId);

            assertNotNull(promocode);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getEventPromocode method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEventPromocodeExceptionTest(){
        String eventId = null;
        String promocodeId = null;
        Promocode promocode = mock(Promocode.class);

        try {

            promocode = constantContact.getEventPromocode(eventId, promocodeId);
            verify(constantContact).getEventPromocode(eventId, promocodeId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the updateEventPromocode method from ConstantContact.class
     *
     */
    @Test
    public  void updateEventPromocodeTest(){
        String eventId = "1";
        Promocode promocode = new Promocode();
        promocode.setId("1");

        try {

            Promocode resultPromocode = constantContact.updateEventPromocode(eventId, promocode);
            verify(constantContact).updateEventPromocode(eventId, promocode);

            assertNotNull(resultPromocode);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getEventPromocode method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public  void updateEventPromocodeExceptionTest(){
        String eventId = null;
        Promocode promocode =null;

        try {

            Promocode resultPromocode = constantContact.updateEventPromocode(eventId, promocode);
            verify(constantContact).updateEventPromocode(eventId, promocode);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the deleteEventPromocode method from ConstantContact.class
     *
     */
    @Test
    public void deleteEventPromocodeTest(){
        String eventId = "1";
        Promocode promocode = new Promocode();
        String promocodeId = "1";
        promocode.setId(promocodeId);

        try {

            boolean deleted = constantContact.deleteEventPromocode(eventId, promocodeId);
            verify(constantContact).deleteEventPromocode(eventId, promocodeId);

            assertTrue(deleted);

            deleted = constantContact.deleteEventPromocode(eventId, promocode);
            verify(constantContact).deleteEventPromocode(eventId, promocode);

            assertTrue(deleted);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the deleteEventPromocode method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void deleteEventPromocodeExceptionTest(){
        String eventId = null;
        String promocodeId = null;

        try {

            boolean deleted = constantContact.deleteEventPromocode(eventId, promocodeId);
            verify(constantContact).deleteEventPromocode(eventId, promocodeId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getEventRegistrants method from ConstantContact.class
     *
     */
    @Test
    public void getEventRegistrantsTest(){
        String eventId = "1";
        int limit = 1;

        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = constantContact.getEventRegistrants(eventId, limit);
            verify(constantContact).getEventRegistrants(eventId, limit);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getEventRegistrants method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEventRegistrantsExceptionTest(){
        String eventId = null;
        int limit = 0;

        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = constantContact.getEventRegistrants(eventId, limit);
            verify(constantContact).getEventRegistrants(eventId, limit);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getEventRegistrant method from ConstantContact.class
     *
     */
    @Test
    public void getEventRegistrantTest(){
        String eventId = "1";
        String eventRegistrantId = "1";

        try {

            RegistrantDetails registrantDetails = mock(RegistrantDetails.class);

            registrantDetails = constantContact.getEventRegistrant(eventId, eventRegistrantId);
            verify(constantContact).getEventRegistrant(eventId, eventRegistrantId);

            assertNotNull(registrantDetails);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getEventRegistrant method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEventRegistrantExceptionTest(){
        String eventId = null;
        String eventRegistrantId = null;

        try {

            RegistrantDetails registrantDetails = mock(RegistrantDetails.class);

            registrantDetails = constantContact.getEventRegistrant(eventId, eventRegistrantId);
            verify(constantContact).getEventRegistrant(eventId, eventRegistrantId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getEventItems method from ConstantContact.class
     *
     */
    @Test
    public void getEventItemsTest(){
        String eventId = "1";

        try {

            List list = mock(List.class);

            list = constantContact.getEventItems(eventId);
            verify(constantContact).getEventItems(eventId);

            assertNotNull(list);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getEventItems method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEventItemsExceptionTest(){
        String eventId = null;

        try {

            List list = mock(List.class);

            list = constantContact.getEventItems(eventId);
            verify(constantContact).getEventItems(eventId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getEventItem method from ConstantContact.class
     *
     */
    @Test
    public void getEventItemTest(){
        String eventId = "1";
        String itemId = "1";

        try {

            EventItem eventItem = mock(EventItem.class);

            eventItem = constantContact.getEventItem(eventId, itemId);
            verify(constantContact).getEventItem(eventId, itemId);

            assertNotNull(eventItem);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getEventItem method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEventItemExceptionTest(){
        String eventId = null;
        String itemId = null;

        try {

            EventItem eventItem = mock(EventItem.class);

            eventItem = constantContact.getEventItem(eventId, itemId);
            verify(constantContact).getEventItem(eventId, itemId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the addEventItem method from ConstantContact.class
     *
     */
    @Test
    public void addEventItemTest(){
        String eventId = "1";

        try {

            EventItem eventItem = mock(EventItem.class);

            EventItem resultEventItem = constantContact.addEventItem(eventId, eventItem);
            verify(constantContact).addEventItem(eventId, eventItem);

            assertNotNull(resultEventItem);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the addEventItem method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void addEventItemExceptionTest(){
        String eventId = null;

        try {

            EventItem eventItem = null;

            EventItem resultEventItem = constantContact.addEventItem(eventId, eventItem);
            verify(constantContact).addEventItem(eventId, eventItem);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the updateEventItem method from ConstantContact.class
     *
     */
    @Test
    public void updateEventItemTest(){
        String eventId = "1";

        try {

            EventItem eventItem = new EventItem();
            eventItem.setId("1");

            EventItem resultEventItem = constantContact.updateEventItem(eventId, eventItem);
            verify(constantContact).updateEventItem(eventId, eventItem);

            assertNotNull(resultEventItem);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the updateEventItem method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void updateEventItemExceptionTest(){
        String eventId = null;

        try {

            EventItem eventItem = null;

            EventItem resultEventItem = constantContact.updateEventItem(eventId, eventItem);
            verify(constantContact).updateEventItem(eventId, eventItem);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the deleteEventItem method from ConstantContact.class
     *
     */
    @Test
    public void deleteEventItemTest(){
        String eventId = "1";
        String eventItemId = "1";
        EventItem eventItem = new EventItem();
        eventItem.setId(eventItemId);

        try {

            boolean deleted = constantContact.deleteEventItem(eventId, eventItemId);
            verify(constantContact).deleteEventItem(eventId, eventItemId);

            assertTrue(deleted);

            deleted = constantContact.deleteEventItem(eventId, eventItem);
            verify(constantContact).deleteEventItem(eventId, eventItem);

            assertTrue(deleted);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the deleteEventItem method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void deleteEventItemExceptionTest(){
        String eventId = null;
        String eventItemId = null;
        EventItem eventItem = null;

        try {

            boolean deleted = constantContact.deleteEventItem(eventId, eventItemId);
            verify(constantContact).deleteEventItem(eventId, eventItemId);

            deleted = constantContact.deleteEventItem(eventId, eventItem);
            verify(constantContact).deleteEventItem(eventId, eventItem);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getEventItemAttributes method from ConstantContact.class
     *
     */
    @Test
    public void getEventItemAttributesTest(){
        String eventId = "1";
        String itemId = "1";
        List list = mock(List.class);

        try {

            list = constantContact.getEventItemAttributes(eventId, itemId);
            verify(constantContact).getEventItemAttributes(eventId, itemId);

            assertNotNull(list);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getEventItemAttributes method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEventItemAttributesExceptionTest(){
        String eventId = null;
        String itemId = null;
        List list = mock(List.class);

        try {

            list = constantContact.getEventItemAttributes(eventId, itemId);
            verify(constantContact).getEventItemAttributes(eventId, itemId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getEventItemAttribute method from ConstantContact.class
     *
     */
    @Test
    public void getEventItemAttributeTest(){
        String eventId = "1";
        String itemId = "1";
        String attributeId = "1";
        EventItemAttribute eventItemAttribute = mock(EventItemAttribute.class);

        try {

            eventItemAttribute = constantContact.getEventItemAttribute(eventId, itemId, attributeId);
            verify(constantContact).getEventItemAttribute(eventId, itemId, attributeId);

            assertNotNull(eventItemAttribute);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getEventItemAttribute method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEventItemAttributeExceptionTest(){
        String eventId = null;
        String itemId = null;
        String attributeId = null;
        EventItemAttribute eventItemAttribute = mock(EventItemAttribute.class);

        try {

            eventItemAttribute = constantContact.getEventItemAttribute(eventId, itemId, attributeId);
            verify(constantContact).getEventItemAttribute(eventId, itemId, attributeId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the addEventItemAttribute method from ConstantContact.class
     *
     */
    @Test
    public void addEventItemAttributeTest(){
        String eventId = "1";
        String itemId = "1";

        try {

            EventItemAttribute eventItemAttribute = mock(EventItemAttribute.class);

            EventItemAttribute resultEventItemAttribute = constantContact.addEventItemAttribute(eventId, itemId, eventItemAttribute);
            verify(constantContact).addEventItemAttribute(eventId, itemId, eventItemAttribute);

            assertNotNull(resultEventItemAttribute);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the addEventItemAttribute method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void addEventItemAttributeExceptionTest(){
        String eventId = null;
        String itemId = null;

        try {

            EventItemAttribute eventItemAttribute = null;

            EventItemAttribute resultEventItemAttribute = constantContact.addEventItemAttribute(eventId, itemId, eventItemAttribute);
            verify(constantContact).addEventItemAttribute(eventId, itemId, eventItemAttribute);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the updateEventItemAttribute method from ConstantContact.class
     *
     */
    @Test
    public void updateEventItemAttributeTest(){
        String eventId = "1";
        String itemId = "1";

        try {

            EventItemAttribute eventItemAttribute = mock(EventItemAttribute.class);

            EventItemAttribute resultEventItemAttribute = constantContact.updateEventItemAttribute(eventId, itemId, eventItemAttribute);
            verify(constantContact).updateEventItemAttribute(eventId, itemId, eventItemAttribute);

            assertNotNull(resultEventItemAttribute);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the addEventItemAttribute method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void updateEventItemAttributeExceptionTest(){
        String eventId = null;
        String itemId = null;

        try {

            EventItemAttribute eventItemAttribute = null;

            EventItemAttribute resultEventItemAttribute = constantContact.updateEventItemAttribute(eventId, itemId, eventItemAttribute);
            verify(constantContact).updateEventItemAttribute(eventId, itemId, eventItemAttribute);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the deleteEventItemAttribute method from ConstantContact.class
     *
     */
    @Test
    public void deleteEventItemAttributeTest(){
        String eventId = "1";
        String itemId = "1";
        String eventItemAttributeId = "1";

        try {

            boolean deleted = constantContact.deleteEventItemAttribute(eventId, itemId, eventItemAttributeId);
            verify(constantContact).deleteEventItemAttribute(eventId, itemId, eventItemAttributeId);

            assertTrue(deleted);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the addEventItemAttribute method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void deleteEventItemAttributeExceptionTest(){
        String eventId = null;
        String itemId = null;
        String eventItemAttributeId = null;

        try {

            boolean deleted = constantContact.deleteEventItemAttribute(eventId, itemId, eventItemAttributeId);
            verify(constantContact).deleteEventItemAttribute(eventId, itemId, eventItemAttributeId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

}
