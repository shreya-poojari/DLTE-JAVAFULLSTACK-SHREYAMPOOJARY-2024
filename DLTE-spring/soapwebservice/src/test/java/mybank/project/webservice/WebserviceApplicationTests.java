//package mybank.project.webservice;
//
//import mybank.project.loansdao.Entity.LoansAvailable;
//import mybank.project.loansdao.Exception.NoLoanData;
//import mybank.project.loansdao.Exception.NoLoanException;
//import mybank.project.loansdao.Interface.LoanInterface;
//import mybank.project.webservice.Configs.SoapPhase;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import services.loansavail.LoanAvailable;
//import services.loansavail.ViewAllAvailableLoanRequest;
//import services.loansavail.ViewAllAvailableLoanResponse;
//
//import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//@AutoConfigureMockMvc
//@SpringBootTest
//public class WebserviceApplicationTests {
//
//    @Autowired
//    private SoapPhase soapPhase;
//
//    @MockBean
//    private LoanInterface interfaceServices;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    void viewAvailableLoanRequestSuccess() {
//        // Arrange
//        ViewAllAvailableLoanRequest request = new ViewAllAvailableLoanRequest();
//
//        List<LoansAvailable> availableLoans = new ArrayList<>();
//
//        availableLoans.add(new LoansAvailable());
//        when(interfaceServices.allAvailableLoans()).thenReturn(availableLoans);
//
//        // Act
//        ViewAllAvailableLoanResponse response = soapPhase.viewAvailLoanRequest(request);
//
//        // Assert
//        assertNotNull(response);
//        assertEquals(HttpServletResponse.SC_OK, response.getServiceStatus().getStatus());
//        assertNotNull(response.getLoanAvailable());
//        assertEquals(1, response.getLoanAvailable().size());
//    }
//
//
//    @Test
//    void viewAvailableLoanRequestFailure() {
//        // Arrange
//        ViewAllAvailableLoanRequest request = new ViewAllAvailableLoanRequest();
//        List<LoansAvailable> availableLoans = new ArrayList<>();
//        availableLoans.add(new LoansAvailable());
//        when(interfaceServices.allAvailableLoans()).thenReturn(availableLoans);
//        // Act
//        ViewAllAvailableLoanResponse response = soapPhase.viewAvailLoanRequest(request);
//        // Assert
//        assertNotNull(response);
//        assertEquals(HttpServletResponse.SC_OK, response.getServiceStatus().getStatus());
//        assertNotNull(response.getLoanAvailable());
//        assertEquals(2, response.getLoanAvailable().size());
//    }
//    @Test
//    public void testFindByLoanType_Success() {
//        // Arrange
//        String loanType = "home";
//        HttpServletResponse response = null;
//        List<LoansAvailable> mockLoanList = new ArrayList<>();
//        mockLoanList.add(new LoansAvailable());
//        when(interfaceServices.findByLoanType(loanType)).thenReturn(mockLoanList);
//        // Act
//        List<LoansAvailable> result = interfaceServices.findByLoanType(loanType);
//        // Assert
//        assertNotNull(result);
//        assertEquals(1, result.size());
//
//    }
//
//    @Test
//    public void testFindByLoanType_Failure() {
//        // Arrange
//        String loanType = "home";
//        HttpServletResponse response = null;
//        List<LoansAvailable> mockLoanList = new ArrayList<>();
//        mockLoanList.add(new LoansAvailable());
//        mockLoanList.add(new LoansAvailable());
//        when(interfaceServices.findByLoanType(loanType)).thenReturn(mockLoanList);
//        // Act
//        List<LoansAvailable> result = interfaceServices.findByLoanType(loanType);
//        // Assert
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertTrue(result.isEmpty());
//    }
//
//    @Test
//    @WithMockUser(username = "shreya")
//    public void testingFindByLoanType_Success1() throws Exception {
//        String loanType = "Home"; // Adjust the loan type as needed
//
//        // Act & Assert
//        mockMvc.perform(get("/loans/{loanType}", loanType))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    @WithMockUser(username = "shreya")
//    public void testingFindByLoanType_Failure1() throws Exception {
//        String loanType = "Gold";
//
//        // Act & Assert
//        mockMvc.perform(get("http://localhost:3002/loans/{loanType}", loanType))
//                .andExpect(status().isOk());
//    }
//}
//
//
//
//
