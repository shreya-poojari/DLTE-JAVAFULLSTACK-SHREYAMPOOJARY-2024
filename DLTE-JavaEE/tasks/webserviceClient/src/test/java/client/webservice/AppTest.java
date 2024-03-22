package client.webservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import soap.dao.FetchAccount;
import soap.dao.SoapService;

/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
public class AppTest 
{
    @Mock
    private SoapService soapService;

    @Mock
    private FetchAccount fetchAccount;

    @Before
    public void setUp() {
        when(soapService.getSoapServicePort()).thenReturn(fetchAccount);
    }

    @Test
    public void testCreateUser() {
        // Mocking user input
        String username = "shreya";
        String password = "shre";
        String dateOfBirth = "2002-12-25";
        String address = "Mudbidri";
        String email = "shrey@gmail.com";
        long phoneNumber = 9886697394L;

        // Mocking service response
        doNothing().when(fetchAccount).create(username, password, dateOfBirth, address, email, phoneNumber);

        // Verifying service method invocation
        verify(fetchAccount).create(username, password, dateOfBirth, address, email, phoneNumber);
    }

    @Test
    public void testFindUser() {
        // Mocking user input
        String username = "shreya";

        // Mocking service response
        List<FetchAccount> accounts = new ArrayList<>();
        FetchAccount account = new FetchAccount();
        account.setuserName(username);
        accounts.add(account);
        when(fetchAccount.findUser(username)).thenReturn(fetchAccount);
        when(fetchAccount.getuserDetailsList()).thenReturn(accounts);

        // Verifying service method invocation and output
        verify(fetchAccount).findUser(username);
        assertEquals("Username: " + username + " Password: null", getConsoleOutput());
    }

    @Test
    public void update() {
        // Mocking user input
        String username = "shreya";

        // Mocking service response
        List<FetchAccount> accounts = new ArrayList<>();
        FetchAccount account = new FetchAccount();
        account.setuserName(username);
        accounts.add(account);
        when(fetchAccount.findUser(username)).thenReturn(fetchAccount);
        when(fetchAccount.getuserDetailsList()).thenReturn(accounts);

        // Verifying service method invocation and output
        verify(fetchAccount).findUser(username);
    }
    @Test
    public void testUpdateUser() {
        // Mocking user input
        String username = "testUser";

        // Mocking service response for finding user
        List<FetchAccount> accounts = new ArrayList<>();
        FetchAccount account = new FetchAccount();
        account.setuserName(username);
        accounts.add(account);
        when(fetchAccount.findUser(username)).thenReturn(fetchAccount);
        when(fetchAccount.getuserDetailsList()).thenReturn(accounts);

        // Mocking service response for update process
        String newPassword = "shre";
        String newAddress = "Mudbidri";
        String newEmail = "shrey@gmail.com";
        Long newPhoneNumber = 9876543210L;

        verify(fetchAccount).findUser(username);
        verify(fetchAccount).update(username, newPassword, new Date, newAddress, newEmail, newPhoneNumber);
    }


    // Helper method
    private String getConsoleOutput() {
        return null;
    }

}
