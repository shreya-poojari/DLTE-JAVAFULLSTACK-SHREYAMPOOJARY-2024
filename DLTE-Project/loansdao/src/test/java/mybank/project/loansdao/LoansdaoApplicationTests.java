package mybank.project.loansdao;

import mybank.project.loansdao.Entity.LoansAvailable;
import mybank.project.loansdao.Service.LoanService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class LoansdaoApplicationTests {
@Mock
private JdbcTemplate jdbcTemplate;

@InjectMocks
private LoanService loanService;

@Autowired
private LoansdaoApplication loansdaoApplication;


    @Test
    void allAvailableLoan_Success() {
        // Mocking
        List<LoansAvailable> availableLoans = new ArrayList<>();
        availableLoans.add(new LoansAvailable(101,"Gold","Gold Loan","education, medical expenses, travel or use for personal cases",9.75));
        availableLoans.add(new LoansAvailable(102, "Home", "Home Loan", "to build home of dreams", 9.75));
        when(jdbcTemplate.query(anyString(), any(LoanService.LoansMapper.class))).thenReturn(availableLoans);

        // Calling the method of test
        List<LoansAvailable> result = loanService.allAvailableLoans();

        assertEquals(2, result.size());//pass

        assertEquals("Gold", result.get(0).getLoanType());//pass

        assertEquals("Home Loan", result.get(1).getLoanName());//pass
    }

//    @Test
//    void allAvailableLoan_failure(){
//        // Mocking
//        List<LoansAvailable> availableLoans = new ArrayList<>();
//        availableLoans.add(new LoansAvailable(101,"Gold","Gold Loan","education, medical expenses, travel or use for personal cases",9.75));
//        availableLoans.add(new LoansAvailable(102, "Home", "Home Loan", "to build home of dreams", 9.75));
//        when(jdbcTemplate.query(anyString(), any(LoanService.LoansMapper.class))).thenReturn(availableLoans);
//
//        // Calling the method of test
//        List<LoansAvailable> result = loanService.allAvailableLoans();
//
//         assertEquals(1, result.size());//fail
//
//        //assertEquals("Home", result.get(0).getLoanType());//fail
//
//       // assertEquals("Gold Loan", result.get(1).getLoanName());//fail
//    }
}
