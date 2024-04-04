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

//    @Test
//    void testallAvailableLoans() {
//        LoansAvailable loansAvailable1=new LoansAvailable(101,"Gold","Gold Loan","education, medical expenses, travel or use for personal cases",9.75);
//        LoansAvailable loansAvailable2=new LoansAvailable(102,"Home","Home Loan","to build home of dreams",9.75);
//        List<LoansAvailable> expect= Stream.of(loansAvailable1,loansAvailable2).collect(Collectors.toList());
//        when(jdbcTemplate.query(anyString(),any(Object[].class),any(LoanService.LoansMapper.class))).thenReturn(expect);
//        List<LoansAvailable> actual=loanService.allAvailableLoans();
//        assertEquals(expect,actual);
//
//    }

//    @Before
//    public void setup() {
//        // Mocking behavior of jdbcTemplate.query method
//        LoansAvailable loansAvailable1 = new LoansAvailable(101, "Gold", "Gold Loan",
//                "education, medical expenses, travel or use for personal cases", 9.75);
//        LoansAvailable loansAvailable2 = new LoansAvailable(102, "Home", "Home Loan", "to build home of dreams", 9.75);
//        List<LoansAvailable> expect = Stream.of(loansAvailable1, loansAvailable2).collect(Collectors.toList());
//        when(jdbcTemplate.query(any(String.class), any(Object[].class), any(LoanService.LoansMapper.class)))
//                .thenReturn(expect);
//    }
//    @Test
//    public void testAllAvailableLoans() {
//        List<LoansAvailable> actual = loanService.allAvailableLoans();
//
//        // Verify that the expected list is equal to the actual list returned by the method
//        assertEquals(2, actual.size());
//        assertEquals(101, actual.get(0).getLoanNumber());
//        assertEquals("Gold", actual.get(0).getLoanType());
//        assertEquals("Gold Loan", actual.get(0).getLoanName());
//        assertEquals("education, medical expenses, travel or use for personal cases",actual.get(0).getLoanDescription());
//        assertEquals(9.75, actual.get(0).getLoanRoi(), 0.01);
//        assertEquals(102, actual.get(1).getLoanNumber());
//        assertEquals("Home", actual.get(1).getLoanType());
//        assertEquals("to build home of dreams",actual.get(1).getLoanDescription());
//        assertEquals("Home Loan", actual.get(1).getLoanName());
//        assertEquals(9.75, actual.get(1).getLoanRoi(), 0.01);
//    }

    @Test
    void allAvailableLoan_Success() {
        // Mocking
        List<LoansAvailable> availableLoans = new ArrayList<>();
        availableLoans.add(new LoansAvailable(101,"Gold","Gold Loan","education, medical expenses, travel or use for personal cases",9.75));
        availableLoans.add(new LoansAvailable(102, "Home", "Home Loan", "to build home of dreams", 9.75));
        when(jdbcTemplate.query(anyString(), any(LoanService.LoansMapper.class))).thenReturn(availableLoans);

        // Calling the method of test
        List<LoansAvailable> result = loanService.allAvailableLoans();

       // assertEquals(1, result.size());//fail

        assertEquals("Gold", result.get(0).getLoanType());//pass

        //   assertEquals("Home Loan", result.get(1).getLoanName());//pass
    }
}
