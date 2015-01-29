import com.constantcontact.ConstantContact;
import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.contacts.tracking.bounces.ContactTrackingBounce;
import com.constantcontact.components.contacts.tracking.clicks.ContactTrackingClick;
import com.constantcontact.components.contacts.tracking.forwards.ContactTrackingForward;
import com.constantcontact.components.contacts.tracking.opens.ContactTrackingOpen;
import com.constantcontact.components.contacts.tracking.reports.summary.ContactTrackingSummaryReport;
import com.constantcontact.components.contacts.tracking.sends.ContactTrackingSend;
import com.constantcontact.components.contacts.tracking.unsubscribes.ContactTrackingUnsubscribe;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Constant Contact tracking unit test class.<br/>
 *
 * @author ConstantContact
 */
public class ConstantContactTrackingTest {

    ConstantContact constantContact;
    private String apiKey;
    private String accessToken;

    @Before
    /**
     * Sets the apy key and the access token
     * Instantiates the ConstantContact object that contains tested methods
     *
     */
    public void setKeys()
    {
        this.apiKey = System.getProperty("apiKey");
        this.accessToken = System.getProperty("accessToken");
        constantContact = new ConstantContact(apiKey, accessToken);
    }

    @Test
    /**
     * Tests the methods regarding contact tracking
     *
     */
    public void trackingTests(){

        try {
            ResultSet<Contact> resultSet = constantContact.getContacts(1, null, Contact.Status.ACTIVE);

            ContactTrackingSummaryReport trackingSummary = constantContact.getContactTrackingSummary(resultSet.get(0).getId(), null);

            ResultSet<ContactTrackingBounce> contactTrackingBounceResultSet = constantContact.getContactTrackingBounces(resultSet.get(0).getId(), 10);
            assertEquals("The number of contact tracking bounces("+contactTrackingBounceResultSet.size()+
                            ") does not correspond with the one from the contact tracking summary("+trackingSummary.getBounces()+")",
                    String.valueOf(contactTrackingBounceResultSet.size()), trackingSummary.getBounces());

            ResultSet<ContactTrackingClick> contactTrackingClickResultSet= constantContact.getContactTrackingClicks(resultSet.get(0).getId(), 10, null);
            assertEquals("The number of contact tracking clicks does not correspond with the one from the contact tracking summary",
                    String.valueOf(contactTrackingClickResultSet.size()), trackingSummary.getClicks());

            ResultSet<ContactTrackingForward> contactTrackingForwardResultSet = constantContact.getContactTrackingForwards(resultSet.get(0).getId(), 10, null);
            assertEquals("The number of contact tracking forwards does not correspond with the one from the contact tracking summary",
                    String.valueOf(contactTrackingForwardResultSet.size()), trackingSummary.getForwards());

            ResultSet<ContactTrackingOpen> contactTrackingOpenResultSet = constantContact.getContactTrackingOpens(resultSet.get(0).getId(), 10, null);
            assertEquals("The number of contact tracking opens does not correspond with the one from the contact tracking summary",
                    String.valueOf(contactTrackingOpenResultSet.size()), trackingSummary.getOpens());

            ResultSet<ContactTrackingSend> contactTrackingSendResultSet = constantContact.getContactTrackingSends(resultSet.get(0).getId(), 10, null);
            assertEquals("The number of contact tracking sends does not correspond with the one from the contact tracking summary",
                    String.valueOf(contactTrackingSendResultSet.size()), trackingSummary.getSends());

            ResultSet<ContactTrackingUnsubscribe> contactTrackingUnsubscribeResultSet= constantContact.getContactTrackingUnsubscribes(resultSet.get(0).getId(), 10, null);
            assertEquals("The number of contact tracking unsubscribes does not correspond with the one from the contact tracking summary",
                    String.valueOf(contactTrackingUnsubscribeResultSet.size()), trackingSummary.getUnsubscribes());

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }
}
