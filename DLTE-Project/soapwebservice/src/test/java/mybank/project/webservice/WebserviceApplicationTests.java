package mybank.project.webservice;

import mybank.project.loansdao.Entity.LoansAvailable;
import mybank.project.loansdao.Exception.NoLoanData;
import mybank.project.loansdao.Exception.NoLoanException;
import mybank.project.loansdao.Interface.LoanInterface;
import mybank.project.webservice.Configs.SoapPhase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import services.loansavail.LoanAvailable;
import services.loansavail.ViewAllAvailableLoanRequest;
import services.loansavail.ViewAllAvailableLoanResponse;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class WebserviceApplicationTests {

    @Autowired
    private SoapPhase soapPhase;

    @MockBean
    private LoanInterface interfaceServices;

    @Test
    void viewAvailableLoanRequestSuccess() {
        // Arrange
        ViewAllAvailableLoanRequest request = new ViewAllAvailableLoanRequest();

        List<LoansAvailable> availableLoans = new ArrayList<>();

        availableLoans.add(new LoansAvailable());
        when(interfaceServices.allAvailableLoans()).thenReturn(availableLoans);

        // Act
        ViewAllAvailableLoanResponse response = soapPhase.viewAvailLoanRequest(request);

        // Assert
        assertNotNull(response);
        assertEquals(HttpServletResponse.SC_OK, response.getServiceStatus().getStatus());
        assertNotNull(response.getLoanAvailable());
        assertEquals(1, response.getLoanAvailable().size());
    }


    @Test
    void viewAvailableLoanRequestFailure() {
        // Arrange
        ViewAllAvailableLoanRequest request = new ViewAllAvailableLoanRequest();

        List<LoansAvailable> availableLoans = new ArrayList<>();

        availableLoans.add(new LoansAvailable());
        when(interfaceServices.allAvailableLoans()).thenReturn(availableLoans);

        // Act
        ViewAllAvailableLoanResponse response = soapPhase.viewAvailLoanRequest(request);

        // Assert
        assertNotNull(response);
        assertEquals(HttpServletResponse.SC_OK, response.getServiceStatus().getStatus());
        assertNotNull(response.getLoanAvailable());
        assertEquals(2, response.getLoanAvailable().size());
    }
}




