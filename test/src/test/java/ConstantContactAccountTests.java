import com.constantcontact.ConstantContact;
import com.constantcontact.components.accounts.AccountInfo;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Constant Contact Account unit test class.<br/>
 * Tests the retrieved Account information.<br/>
 *
 * @author ConstantContact
 */
public class ConstantContactAccountTests {

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
     * Tests that the account information is retrieved correctly
     *
     */
    public void getAccountDataTest(){
        try {
            AccountInfo accountInfo =  constantContact.getAccountInfo();
            assertNotNull("The account first name is null", accountInfo.getFirstName());
            assertNotNull("The account email is null", accountInfo.getEmail());
            assertNotNull("The account last name is null", accountInfo.getLastName());
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }
}
