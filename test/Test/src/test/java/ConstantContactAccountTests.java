import com.constantcontact.ConstantContact;
import com.constantcontact.components.accounts.AccountInfo;
import com.constantcontact.components.accounts.VerifiedEmailAddress;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import mockup.AccountServiceTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Constant Contact Account unit test class.<br/>
 * Tests the retrieved Account information.<br/>
 *
 * @author ConstantContact
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactAccountTests {

    ConstantContact constantContact;

    @Before
    public void beforeTests(){
        constantContact = Mockito.spy(new ConstantContact("",""));
        constantContact.setAccountService(new AccountServiceTest());
    }

    /**
     * Tests that the account information is retrieved correctly
     *
     */
    @Test
    public void getAccountInfoTest(){
        try {

            AccountInfo accountInfo = mock(AccountInfo.class);

            accountInfo = constantContact.getAccountInfo();
            verify(constantContact).getAccountInfo();

            assertNotNull(accountInfo);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the verified email addresses are retrieved correctly
     *
     */
    @Test
    public void getVerifiedEmailAddressesTest(){
        try {

            List<VerifiedEmailAddress> verifiedEmailAddresses = new ArrayList<VerifiedEmailAddress>();

            verifiedEmailAddresses = constantContact.getVerifiedEmailAddresses( VerifiedEmailAddress.Status.CONFIRMED);
            verify(constantContact).getVerifiedEmailAddresses( VerifiedEmailAddress.Status.CONFIRMED);

            assertNotNull(verifiedEmailAddresses);

            verifiedEmailAddresses = constantContact.getVerifiedEmailAddresses(VerifiedEmailAddress.Status.UNCONFIRMED);
            verify(constantContact).getVerifiedEmailAddresses(VerifiedEmailAddress.Status.UNCONFIRMED);

            assertNotNull(verifiedEmailAddresses);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests if the getVerifiedEmailAddresses method throws the proper exception
     *
     */
    @Test(expected=IllegalArgumentException.class)
    public void getVerrifiedEmailAddressExceptionTest(){
        try {

            List<VerifiedEmailAddress> verifiedEmailAddresses = new ArrayList<VerifiedEmailAddress>();

            String s = "test";
            verifiedEmailAddresses = constantContact.getVerifiedEmailAddresses(s);
            verify(constantContact).getVerifiedEmailAddresses(s);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the update account info functionality works properly
     *
     */
    @Test
    public void updateAccountInfoTest(){
        try {

            AccountInfo accountInfo = mock(AccountInfo.class);
            AccountInfo resultAccountInfo = constantContact.updateAccountInfo( accountInfo);
            verify(constantContact).updateAccountInfo(accountInfo);

            assertNotNull(resultAccountInfo);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the updateAccountInfo method throws the proper exception
     *
     */
    @Test(expected=IllegalArgumentException.class)
    public void updateAccountInfoExceptionTest(){
        try {

            AccountInfo accountInfo = null;
            AccountInfo resultAccountInfo = constantContact.updateAccountInfo( accountInfo);
            verify(constantContact).updateAccountInfo(accountInfo);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }
}
