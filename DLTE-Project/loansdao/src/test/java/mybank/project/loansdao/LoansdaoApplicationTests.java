//package mybank.project.loansdao;
//
//import mybank.project.loansdao.entity.LoansAvailable;
//import mybank.project.loansdao.service.LoanService;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.CallableStatementCreator;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.when;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//class LoansdaoApplicationTests {
//@Mock
//private JdbcTemplate jdbcTemplate;
//
//@InjectMocks
//private LoanService loanService;
//
//@Autowired
//private LoansdaoApplication loansdaoApplication;
//
//
//    @Test
//    void allAvailableLoan_Success() {
//        // Mocking
//        List<LoansAvailable> availableLoans = new ArrayList<>();
//        availableLoans.add(new LoansAvailable(101,"Gold","Gold Loan","education, medical expenses, travel or use for personal cases",9.75));
//        availableLoans.add(new LoansAvailable(102, "Home", "Home Loan", "to build home of dreams", 9.75));
//        when(jdbcTemplate.query(anyString(), any(LoanService.LoansMapper.class))).thenReturn(availableLoans);
//
//        // Calling the method of test
//        List<LoansAvailable> result = loanService.allAvailableLoans();
//
//        assertEquals(2, result.size());//pass
//
//        assertEquals("Gold", result.get(0).getLoanType());//pass
//
//        assertEquals("Home Loan", result.get(1).getLoanName());//pass
//    }
//
////    @Test
////    void allAvailableLoan_failure(){
////        // Mocking
////        List<LoansAvailable> availableLoans = new ArrayList<>();
////        availableLoans.add(new LoansAvailable(101,"Gold","Gold Loan","education, medical expenses, travel or use for personal cases",9.75));
////        availableLoans.add(new LoansAvailable(102, "Home", "Home Loan", "to build home of dreams", 9.75));
////        when(jdbcTemplate.query(anyString(), any(LoanService.LoansMapper.class))).thenReturn(availableLoans);
////
////        // Calling the method of test
////        List<LoansAvailable> result = loanService.allAvailableLoans();
////
////         assertEquals(1, result.size());//fail
////
////        //assertEquals("Home", result.get(0).getLoanType());//fail
////
////       // assertEquals("Gold Loan", result.get(1).getLoanName());//fail
////    }
//
//    @Test
//    public void testFindByLoanType_Success() {
//        // Arrange
//        String loanType = "home";
//        Map<String, Object> output = new HashMap<>();
//        output.put("loan_number", new BigDecimal(1));
//        output.put("loan_type_out", "home");
//        output.put("loan_name", "Home Loan");
//        output.put("loan_description", "Home Loan Description");
//        output.put("loan_roi", new BigDecimal("5.5"));
//        output.put("loan_info", null);
//
//        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList())).thenReturn(output);
//
//        // Act
//        List<LoansAvailable> loansList = loanService.findByLoanType(loanType);
//
//        // Assert
//        assertEquals(1, loansList.size());
////        LoansAvailable loan = loansList.get(0);
////        assertEquals(1, loan.getLoanNumber());
////        assertEquals("home", loan.getLoanType());
////        assertEquals("Home Loan", loan.getLoanName());
////        assertEquals("Home Loan Description", loan.getLoanDescription());
////        assertEquals(5.5, loan.getLoanRoi());
//    }
//
//    @Test
//    public void testFindByLoanType_Failure() {
//        // Arrange
//        String loanType = "home";
//        Map<String, Object> output = new HashMap<>();
//        output.put("loan_number", new BigDecimal(1));
//        output.put("loan_type_out", "home");
//        output.put("loan_name", "Home Loan");
//        output.put("loan_description", "Home Loan Description");
//        output.put("loan_roi", new BigDecimal("5.5"));
//        output.put("loan_info", null);
//
//        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList())).thenReturn(output);
//
//        // Act
//        List<LoansAvailable> loansList = loanService.findByLoanType(loanType);
//
//        // Assert
//        assertEquals(2, loansList.size());
//        LoansAvailable loan = loansList.get(0);
//      //  assertEquals(12, loan.getLoanNumber());
////        assertEquals("house", loan.getLoanType());
////        assertEquals("Home ", loan.getLoanName());
////        assertEquals("Loan Description", loan.getLoanDescription());
////        assertEquals(6.5, loan.getLoanRoi());
//    }
//}
