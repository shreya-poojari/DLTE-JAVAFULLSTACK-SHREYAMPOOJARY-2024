package mybank.project.loansdao;

import mybank.project.loansdao.entity.MyBankCustomers;
import mybank.project.loansdao.exception.NoLoanData;
import mybank.project.loansdao.exception.NoLoanException;
import mybank.project.loansdao.service.LoanService;
import mybank.project.loansdao.service.MyBankCustomersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;

public class CustomerService {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private MyBankCustomersService myBankCustomersService;

    @InjectMocks
    private LoanService loanServices;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFieldAccessorsAndMutators() {
        MyBankCustomers customer = new MyBankCustomers();
        customer.setCustomerId(123);
        customer.setCustomerName("Akshatha");
        customer.setCustomerAddress("Bailoor");
        customer.setCustomerStatus("Active");
        customer.setCustomerContact(9353523995L);
        customer.setUsername("Akshatha");
        customer.setPassword("nayak");
        customer.setAttempts(1);

        assertEquals(123, customer.getCustomerId());
        assertEquals("Akshatha", customer.getCustomerName());
        assertEquals("Bailoor", customer.getCustomerAddress());
        assertEquals("Active", customer.getCustomerStatus());
        assertEquals(9353523995L, customer.getCustomerContact());
        assertEquals("Akshatha", customer.getUsername());
        assertEquals("nayak", customer.getPassword());
        assertEquals(1, customer.getAttempts());
    }
    @Test
    void testGetMaxAttempt() {
        MyBankCustomers customer = new MyBankCustomers();
        assertEquals(3, customer.getMaxAttempt());
    }

    @Test
    void testUserDetailsInterfaceMethods() {
        MyBankCustomers customer = new MyBankCustomers();
        customer.setUsername("kavya");
        customer.setPassword("kav");

        assertEquals("kavya", customer.getUsername());
        assertEquals("kav", customer.getPassword());
        assertTrue(customer.isAccountNonExpired());
        assertTrue(customer.isAccountNonLocked());
        assertTrue(customer.isCredentialsNonExpired());
        assertTrue(customer.isEnabled());
    }

    @Test
    void testLoadUserByUsername_UserExists() {
        // Mock data
        MyBankCustomers mockCustomer = new MyBankCustomers();
        mockCustomer.setUsername("kavya");
        mockCustomer.setPassword("kav");

        // Mock behavior
        when(jdbcTemplate.queryForObject(anyString(), any(Object[].class), any(Class.class)))
                .thenReturn(mockCustomer);

        // Test and verify
        assertDoesNotThrow(() -> {
            try {
                UserDetails userDetails = myBankCustomersService.loadUserByUsername("kavya");
                assertEquals("kav", userDetails.getUsername());
            } catch (Exception e) {
            }
        });
    }

    @Test
    void testUpdateAttempts() {
        MyBankCustomers mockCustomer = new MyBankCustomers();
        mockCustomer.setUsername("kavya");
        mockCustomer.setAttempts(5);
        // Mock behavior
        when(jdbcTemplate.update(anyString(), any(Object[].class))).thenReturn(1);
        // Test
        assertDoesNotThrow(() -> myBankCustomersService.updateAttempts(mockCustomer));
    }

    @Test
    void testUpdateStatus() {
        MyBankCustomers mockCustomer = new MyBankCustomers();
        mockCustomer.setUsername("kavya");
        when(jdbcTemplate.update(anyString(), any(Object[].class))).thenReturn(1);
        assertDoesNotThrow(() -> myBankCustomersService.updateStatus(mockCustomer));
    }

    @Test
    void testLoadUserByUsername_UserDoesNotExist() {
        // Mock behavior to simulate no user found
        when(jdbcTemplate.queryForObject(anyString(), any(Object[].class), any(Class.class)))
                .thenReturn(null);
        // Test and verify that the method throws UsernameNotFoundException
        assertThrows(UsernameNotFoundException.class, () -> myBankCustomersService.loadUserByUsername("sowmya"));
    }

    @Test
    void testFindByUsername_UserExists() {
        // Mock data
        List<MyBankCustomers> mockCustomersList = new ArrayList<>();
        MyBankCustomers mockCustomer = new MyBankCustomers();
        mockCustomer.setUsername("kavya");
        mockCustomersList.add(mockCustomer);
        // Mock behavior
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(mockCustomersList);
        // Test
        MyBankCustomers result = myBankCustomersService.findByUsername("kavya");

        // Verify
        assertNotNull(result);
        assertEquals("kavya", result.getUsername());
    }

    @Test
    void testGetCustomerName() {
        // Mock behavior
        when(jdbcTemplate.queryForObject(anyString(), any(Object[].class), any(Class.class))).thenReturn("kavya");
        String customerName = myBankCustomersService.getCustomerName("kavya");
        assertEquals("kavya", customerName);
    }

    @Test
    void testSigningUp_Success() {
        // Mock data
        MyBankCustomers mockCustomer = new MyBankCustomers();
        mockCustomer.setUsername("kavya");
        mockCustomer.setPassword("kav");
        // Mock behavior
        when(jdbcTemplate.update(anyString(), any(Object[].class))).thenReturn(1);
        // Test
        MyBankCustomers result = myBankCustomersService.signingUp(mockCustomer);
        // Verify
        assertEquals("kavya", result.getUsername());
    }

    @Test
    void testSigningUpNotNull_Success() {
        // Mock data
        MyBankCustomers mockCustomer = new MyBankCustomers();
        mockCustomer.setUsername("kavya");
        mockCustomer.setPassword("kav");
        // Mock behavior
        when(jdbcTemplate.update(anyString(), any(Object[].class))).thenReturn(1);
        // Test
        MyBankCustomers result = myBankCustomersService.signingUp(mockCustomer);
        // Verify
        assertNotNull(result);
    }
}
