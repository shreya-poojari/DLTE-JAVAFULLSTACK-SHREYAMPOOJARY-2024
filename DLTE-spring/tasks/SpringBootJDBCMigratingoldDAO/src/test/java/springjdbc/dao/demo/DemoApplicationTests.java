package springjdbc.dao.demo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import springjdbc.dao.demo.Entity.Transactions;
import springjdbc.dao.demo.Service.TransactionService;


import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
class DemoApplicationTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private TransactionService transactionService;

//    @Test
//    void testNewTransaction() {
//        // testing for adding transactions
//        Transactions transaction1 = new Transactions(101, Date.valueOf("2024-03-26"),"Akshatha", "Annapoorna",1001.0, "Friends");
//        when(jdbcTemplate.update(
//                eq("insert into transaction values(?,?,?,?,?,?)"), any(Long.class), any(Date.class),any(String.class), any(String.class), any(Integer.class), any(String.class)
//        )).thenReturn(1);
//        Transactions transactionActual = transactionService.newTransaction(transaction1);
//        assertEquals(transaction1.getTransactionBy(), transactionActual.getTransactionBy());
//    }

    @Test
    void testFindBySender() {
        // test for finding transactions by sender's name
        Transactions transaction1 = new Transactions(101, Date.valueOf("2024-03-26"),"ramya", 1000,"food", "rohit");
        Transactions transaction2 = new Transactions(102, Date.valueOf("2024-03-28"), "divya", 5000, "Hospital", "mohith");
        List<Transactions> expected = Stream.of(transaction1, transaction2).collect(Collectors.toList());
        when(jdbcTemplate.query(anyString(), any(Object[].class), any(BeanPropertyRowMapper.class))).thenReturn(expected);
        List<Transactions> actual = transactionService.findBySender("ramya");
        assertNotEquals(expected, actual);
    }

    @Test
    void testFindByReceiver() {
        // testing using receiver's name
        Transactions transaction1 = new Transactions(104, Date.valueOf("2024-03-26"), "dhanush", 2000, "food", "shreya");
        Transactions transaction2 = new Transactions(106, Date.valueOf("2024-03-28"), "sumanth", 300, "bill", "snehal");
        List<Transactions> expected = Stream.of(transaction1).collect(Collectors.toList());
        when(jdbcTemplate.query(anyString(), any(Object[].class), any(BeanPropertyRowMapper.class))).thenReturn(expected);
        List<Transactions> actual = transactionService.findByReceiver("sumanth");
        assertNotEquals(expected, actual);
    }

    @Test
    void testFindByAmount() {
        //testing using entering the amount
        Transactions transaction1 = new Transactions(107, Date.valueOf("2024-03-26"), "shreya", 200, "stationary", "seetha");
        Transactions transaction2 = new Transactions(108, Date.valueOf("2024-03-28"), "kavya", 500, "friend", "geetha");
        List<Transactions> expected = Stream.of(transaction1).collect(Collectors.toList());
        when(jdbcTemplate.query(anyString(), any(Object[].class), any(BeanPropertyRowMapper.class))).thenReturn(expected);
        List<Transactions> actual = transactionService.findByAmount((long) 1200);
        assertNotEquals(expected, actual);
    }
}
