package mybank.project.webservice;

import mybank.project.loansdao.entity.LoansAvailable;
import mybank.project.loansdao.exception.NoLoanData;
import mybank.project.loansdao.exception.NoLoanException;
import mybank.project.loansdao.interfaces.LoanInterface;
import mybank.project.loansdao.service.LoanService;
import mybank.project.loansdao.service.MyBankCustomersService;
import mybank.project.webservice.rest.Controller;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class Controllertest {
    @InjectMocks
    private Controller controller;

    @Mock
    private LoanInterface loanService;

    @Mock
    private MyBankCustomersService myBankCustomersService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        //controller=new Controller();
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    @Test
    public void testFindByLoanType_Success() throws SQLException, NoLoanData, NoLoanException {
        // Mocking
        String loanType = "Home";
        List<LoansAvailable> loans = new ArrayList<>();
        loans.add(new LoansAvailable());
        when(loanService.findByLoanType(loanType)).thenReturn(loans);

        // Test
        HttpServletResponse response = mock(HttpServletResponse.class);
        ResponseEntity<Object> responseEntity = controller.findByLoanType(loanType, response);

        // Assertions
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(loans, responseEntity.getBody());
    }
    @Test
    public void testFindByLoanType_NoLoansFound() throws SQLException, NoLoanData, NoLoanException {
        // Mocking
        String loanType = "NonExistingType";
        when(loanService.findByLoanType(loanType)).thenReturn(new ArrayList<>());

        // Test
        HttpServletResponse response = mock(HttpServletResponse.class);
        ResponseEntity<Object> responseEntity = controller.findByLoanType(loanType, response);

        // Assertions
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
       // assertEquals("no.loanType", responseEntity.getBody());
         assertEquals("There are no loans available for the selected loan type.", responseEntity.getBody());

    }
    @Test
    public void testFindByLoanType_NoLoanData() throws SQLException, NoLoanData, NoLoanException {
        // Mocking
        String loanType = "InvalidType";
        when(loanService.findByLoanType(loanType)).thenThrow(new NoLoanData("Mocked exception"));

        // Test
        HttpServletResponse response = mock(HttpServletResponse.class);
        ResponseEntity<Object> responseEntity = controller.findByLoanType(loanType, response);

        // Assertions
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotEquals("Mocked exception", responseEntity.getBody());
    }

//    @Test
//    public void testFindByLoanType_InternalServerError() throws SQLException, NoLoanData, NoLoanException {
//        // Mocking
//        String loanType = "ServerErrorType";
//        when(loanService.findByLoanType(loanType)).thenThrow(new NoLoanException("Mocked exception"));
//        // Test
//        HttpServletResponse response = mock(HttpServletResponse.class);
//        ResponseEntity<Object> responseEntity = controller.findByLoanType(loanType, response);
//        // Assertions
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
//        assertEquals("Mocked exception", responseEntity.getBody());
//    }

    @Test
    public void testFindByLoanType_InvalidLoanType() throws SQLException, NoLoanData, NoLoanException {
        // Test
        String loanType = "Invalid123";
        HttpServletResponse response = mock(HttpServletResponse.class);
        ResponseEntity<Object> responseEntity = controller.findByLoanType(loanType, response);

        // Assertions
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
      //  assertEquals("enter.proper.loantype", responseEntity.getBody());
          assertEquals("enter valid loan type", responseEntity.getBody());
    }

    @Test
    public void testIsValidLoanType() {
       Controller controller = new Controller();

        assertTrue(controller.isValidLoanType("CarLoan"));
        assertTrue(controller.isValidLoanType("PersonalLoan"));
        assertFalse(controller.isValidLoanType(null));
        assertFalse(controller.isValidLoanType(""));
        assertFalse(controller.isValidLoanType("123"));
        assertFalse(controller.isValidLoanType("123abc"));
    }
    @Test
    public void testGetCustomerName() {
        // Mock SecurityContextHolder to return a mock Authentication object
        Authentication authentication = Mockito.mock(Authentication.class);
        Mockito.when(authentication.getName()).thenReturn("testUser");
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        Mockito.when(myBankCustomersService.getCustomerName(Mockito.anyString())).thenReturn("shreya");

        String result = controller.getCustomerName();
        Assertions.assertEquals("shreya", result);
    }



}
