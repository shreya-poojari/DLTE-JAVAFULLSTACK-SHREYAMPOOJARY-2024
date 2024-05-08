package mybank.project.loansdao;

import mybank.project.loansdao.entity.LoansAvailable;
import mybank.project.loansdao.exception.NoLoanData;
import mybank.project.loansdao.exception.NoLoanException;
import mybank.project.loansdao.service.LoanService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
    void allAvailableLoan_failure(){
        // Mocking
        List<LoansAvailable> availableLoans = new ArrayList<>();
        availableLoans.add(new LoansAvailable(101,"Gold","Gold Loan","education, medical expenses, travel or use for personal cases",9.75));
        availableLoans.add(new LoansAvailable(102, "Home", "Home Loan", "to build home of dreams", 9.75));
        when(jdbcTemplate.query(anyString(), any(LoanService.LoansMapper.class))).thenReturn(availableLoans);

        // Calling the method of test
        List<LoansAvailable> result = loanService.allAvailableLoans();

         assertNotEquals(1, result.size());//fail

         assertNotEquals("Home", result.get(0).getLoanType());//fail

         assertNotEquals("Gold Loan", result.get(1).getLoanName());//fail
    }

    private List<LoansAvailable> mockLoanList;

    @BeforeEach
    void setUp() {
        mockLoanList = new ArrayList<>();
        mockLoanList.add(new LoansAvailable(101, "Personal", "Personal loan", "personal expenses", 8.8));
    }

    @Test
    void testAllAvailableLoans_Success() {
        when(jdbcTemplate.query(anyString(), any(LoanService.LoansMapper.class))).thenReturn(mockLoanList);
        List<LoansAvailable> result = loanService.allAvailableLoans();
        assertEquals(1, result.size());
    }

    @Test
    void testAllAvailableLoans_Failure() {
        when(jdbcTemplate.query(anyString(), any(LoanService.LoansMapper.class))).thenReturn(mockLoanList);
        List<LoansAvailable> result = loanService.allAvailableLoans();
        assertNotEquals("Education", result.get(0).getLoanName());
    }

    @Test
    void testSetters() {
        LoansAvailable loan = new LoansAvailable();
        loan.setLoanNumber(102);
        loan.setLoanType("Home");
        loan.setLoanName("Home loan");
        loan.setLoanDescription("buying a home");
        loan.setLoanRoi(7.5);
        assertEquals(102, loan.getLoanNumber());
        assertEquals("Home", loan.getLoanType());
        assertEquals("Home loan", loan.getLoanName());
        assertEquals("buying a home", loan.getLoanDescription());
        assertEquals(7.5, loan.getLoanRoi());
    }



    @Test
    void allAvailableLoan_NoDataFound() {
        when(jdbcTemplate.query(anyString(), any(LoanService.LoansMapper.class))).thenReturn(new ArrayList<>());
        // Calling the method under test and expecting an exception
        assertThrows(NoLoanData.class, () -> loanService.allAvailableLoans());
    }

    @Test
    public void testFindByLoanType_NullResultFromStoredProcedure() throws SQLException {
        // Mocking
        String loanType = "ValidType";
        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList())).thenReturn(null);

        // Test
        assertThrows(NullPointerException.class, () -> loanService.findByLoanType(loanType));
    }

    @Test
    public void testFindByLoanType_ErrorInStoredProcedure() throws SQLException {
        // Mocking
        String loanType = "ValidType";
        Map<String, Object> output = new HashMap<>();
        output.put("loan_info", "SQ001");
        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList())).thenReturn(output);

        // Test
        assertThrows(NoLoanException.class, () -> loanService.findByLoanType(loanType));
    }
    @Test
    public void testFindByLoanType_EmptyLoanType() {
        // Test
        assertThrows(IllegalArgumentException.class, () -> loanService.findByLoanType(""));
    }

    @Test
    public void testFindByLoanType_NullLoanType() {
        // Test
        assertThrows(IllegalArgumentException.class, () -> loanService.findByLoanType(null));
    }


    @Test
    void testFindByLoanType_NoLoanFound() {
        // Mocking the response from the database to simulate no loan found
        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList())).thenReturn(Collections.emptyMap());
        assertThrows(NoLoanData.class, () -> loanService.findByLoanType("Gold"));
    }

    @Test
    public void testFindByLoanType_NoLoanFoundexception(){
        // Mocking
        String loanType = "NonExistingType";
        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList())).thenReturn(Collections.emptyMap());

        // Test
        assertThrows(NoLoanData.class, () -> loanService.findByLoanType(loanType));
    }

    private Map<String, Object> createMockReturn(List<LoansAvailable> loans) {
        Map<String, Object> mockReturn = new HashMap<>();
        mockReturn.put("loans_cursor", loans);
        mockReturn.put("loan_info", "");
        return mockReturn;
    }

    @Test
    void findByLoanType_ValidLoanType_ReturnsListOfLoans() throws SQLException {
        // Arrange
        String loanType = "Home Loan";
        List<LoansAvailable> expectedLoans = new ArrayList<>();
        expectedLoans.add(new LoansAvailable(/* provide loan details */));

        // Mock the behavior of jdbcTemplate
        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList()))
                .thenReturn(createMockReturn(expectedLoans));

        // Act
        List<LoansAvailable> actualLoans = loanService.findByLoanType(loanType);

        // Assert
        assertEquals(expectedLoans.size(), actualLoans.size());
        // Add more assertions as needed
    }

    @Test
    void findByLoanType_NullLoanType_ThrowsIllegalArgumentException() {
        // Arrange
        String loanType = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> loanService.findByLoanType(loanType));
    }

    @Test
    void findByLoanType_EmptyLoanType_ThrowsIllegalArgumentException() {
        // Arrange
        String loanType = "";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> loanService.findByLoanType(loanType));
    }

    private Map<String, Object> createMockReturn(List<LoansAvailable> loans, String loanInfo) {
        Map<String, Object> mockReturn = new HashMap<>();
        mockReturn.put("loans_cursor", loans);
        mockReturn.put("loan_info", loanInfo);
        return mockReturn;
    }
    @Test
    void findByLoanType_NoLoanFound_ThrowsNoLoanDataException() throws SQLException {
        // Arrange
        String loanType = "Car Loan";

        // Mock the behavior of jdbcTemplate to simulate "NO_LOAN_FOUND" scenario
        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList()))
                .thenReturn(createMockReturn(null, "NO_LOAN_FOUND"));

        // Act & Assert
        assertThrows(NoLoanData.class, () -> loanService.findByLoanType(loanType));
    }

    @Test
    void findByLoanType_DatabaseError_ThrowsSQLException() throws SQLException {
        // Arrange
        String loanType = "Education Loan";
        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList()))
                .thenThrow(new DataAccessException("Database error") {});

        // Act & Assert
        assertThrows(SQLException.class, () -> loanService.findByLoanType(loanType));
    }
    @Test
    void allAvailableLoan_NoDataFoundexception() {
        when(jdbcTemplate.query(anyString(), any(LoanService.LoansMapper.class))).thenReturn(new ArrayList<>());
        assertThrows(NoLoanData.class, () -> loanService.allAvailableLoans());
    }
}
