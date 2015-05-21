package com.constantcontact;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.constantcontact.components.accounts.AccountInfo;
import com.constantcontact.components.accounts.VerifiedEmailAddress;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.mockup.ConstantContactFactoryMock;
import com.constantcontact.services.accounts.IAccountService;

/**
 * Constant Contact Account unit test class.<br/>
 * Tests the retrieved Account information.<br/>
 *
 * @author ConstantContact
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactAccountTest {

    private ConstantContactFactoryMock constantContactFactoryMock;
    private IAccountService accountServiceMock;
    
    private ConstantContactFactory constantContactFactory;
    private IAccountService accountService;

    @Before
    public void beforeTests(){
    	constantContactFactoryMock = Mockito.spy(new ConstantContactFactoryMock("",""));
    	accountServiceMock = constantContactFactoryMock.createAccountService();
    	
    	constantContactFactory = Mockito.spy(new ConstantContactFactory("TEST1","TEST2"));
    	accountService = constantContactFactory.createAccountService();
    }

    /**
     * Tests that the account information is retrieved correctly
     *
     */
    @Test
    public void getAccountInfoTest(){
        try {

            AccountInfo accountInfo = mock(AccountInfo.class);

            accountInfo = accountServiceMock.getAccountInfo();
            verify(accountServiceMock).getAccountInfo();

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

            verifiedEmailAddresses = accountServiceMock.getVerifiedEmailAddresses(VerifiedEmailAddress.Status.CONFIRMED);
            verify(accountServiceMock).getVerifiedEmailAddresses(VerifiedEmailAddress.Status.CONFIRMED);

            assertNotNull(verifiedEmailAddresses);

            verifiedEmailAddresses = accountServiceMock.getVerifiedEmailAddresses(VerifiedEmailAddress.Status.UNCONFIRMED);
            verify(accountServiceMock).getVerifiedEmailAddresses(VerifiedEmailAddress.Status.UNCONFIRMED);

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
            verifiedEmailAddresses = accountServiceMock.getVerifiedEmailAddresses(s);
            verify(accountServiceMock).getVerifiedEmailAddresses(s);
            
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Tests if the getVerifiedEmailAddresses method throws the proper exception
     * (main service)
     */
    @Test(expected=ConstantContactServiceException.class)
    public void getVerrifiedEmailAddressServiceExceptionTest() throws ConstantContactServiceException{
        
            List<VerifiedEmailAddress> verifiedEmailAddresses = new ArrayList<VerifiedEmailAddress>();

            verifiedEmailAddresses = accountService.getVerifiedEmailAddresses(VerifiedEmailAddress.Status.CONFIRMED);
            verify(accountService).getVerifiedEmailAddresses(VerifiedEmailAddress.Status.CONFIRMED);
            
            verifiedEmailAddresses = accountService.getVerifiedEmailAddresses(VerifiedEmailAddress.Status.UNCONFIRMED);
            verify(accountService).getVerifiedEmailAddresses(VerifiedEmailAddress.Status.UNCONFIRMED);
    }

    /**
     * Tests that the update account info functionality works properly
     *
     */
    @Test
    public void updateAccountInfoTest(){
        try {

            AccountInfo accountInfo = mock(AccountInfo.class);
            AccountInfo resultAccountInfo = accountServiceMock.updateAccountInfo(accountInfo);
            verify(accountServiceMock).updateAccountInfo(accountInfo);

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
            AccountInfo resultAccountInfo = accountServiceMock.updateAccountInfo(accountInfo);
            assertNull(resultAccountInfo);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }
}
