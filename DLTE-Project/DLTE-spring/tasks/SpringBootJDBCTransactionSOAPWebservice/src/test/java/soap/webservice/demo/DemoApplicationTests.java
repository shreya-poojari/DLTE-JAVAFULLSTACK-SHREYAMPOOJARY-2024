package soap.webservice.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import soap.webservice.demo.dao.Transactions;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class DemoApplicationTests {
@Mock
private JdbcTemplate jdbcTemplate;
@InjectMocks
private TransactionService transactionService;

List<Transactions> testBlock() {
    List<Transactions> newTransaction=new ArrayList<>();
    Transactions transaction1 = new Transactions(25, new Date(2024, 05, 25), "sumanth", 4000.0, "family", "kavya");
    Transactions transaction2 = new Transactions(20, new Date(2024, 02, 15), "snehal", 489.0, "bills", "anith");
    newTransaction.add(transaction1);
    newTransaction.add(transaction2);
    return newTransaction;
}
@Test
List<Transactions> testAddTransactionRequest(){
    List<Transactions> transactionsList=new ArrayList<>();
    Transactions transaction1 = new Transactions(25, new Date(String.valueOf(new Date("05/25/2024"))), "prabha", 500, "family", "chethan");
    Transactions transaction2 = new Transactions(20, new Date(String.valueOf(new Date("12/19/2024"))), "rushil", 489, "bills", "uttam");

//  // List<Transactions> transactionsList= Stream.of(transaction1,transaction2).collect(Collectors.toList());
    when(jdbcTemplate.update(String.valueOf(anyInt()), any(Date.class), anyString(), anyDouble(), anyString(), anyString())).thenReturn(1);
    Transactions result = transactionService.newTransaction(transaction1);
    assertEquals(transaction1, result);
    return transactionsList;
}

@Test
void testFindBySender(){
    Transactions transaction1 = new Transactions(25, new Date(2024, 05, 25), "sumanth", 4000.0, "family", "kavya");
    Transactions transaction2 = new Transactions(20, new Date(2024, 02, 15), "snehal", 489.0, "bills", "anith");
    List<Transactions> transactionsList= Stream.of(transaction1,transaction2).collect(Collectors.toList());
    when(jdbcTemplate.query(ArgumentMatchers.anyString(),ArgumentMatchers.any(Object[].class),ArgumentMatchers.any(TransactionService.TransactionMapper.class))).thenReturn(transactionsList);
    List<Transactions> result = transactionService.findBySender("Sender");
    assertEquals(transactionsList, result);
}

    //when(jdbcTemplate.query(anyString(),any(Object[].class),any(TransactionService.TransactionMapper.class))).thenReturn(transactionsList);
@Test
void testFindByReceiver(){
    Transactions transaction1 = new Transactions(25, new Date(2024, 05, 25), "sumanth", 4000.0, "family", "kavya");
    Transactions transaction2 = new Transactions(20, new Date(2024, 02, 15), "snehal", 489.0, "bills", "anith");
    List<Transactions> transactionsList= Stream.of(transaction1,transaction2).collect(Collectors.toList());
    when(jdbcTemplate.query(ArgumentMatchers.anyString(),ArgumentMatchers.any(Object[].class),ArgumentMatchers.any(TransactionService.TransactionMapper.class))).thenReturn(transactionsList);
    List<Transactions> transactionsresult = transactionService.findByReceiver("Reciever");
    assertEquals(transactionsList, transactionsresult);
}
    @Test
    void contextLoads() {
    }
@Test
    void testFindByAmount(){
    Transactions transaction1 = new Transactions(25, new Date(2024, 05, 25), "sumanth", 4000.0, "family", "kavya");
    Transactions transaction2 = new Transactions(20, new Date(2024, 02, 15), "snehal", 489.0, "bills", "anith");
    List<Transactions> transactionsList= Stream.of(transaction1,transaction2).collect(Collectors.toList());
    when(jdbcTemplate.query(ArgumentMatchers.anyString(),ArgumentMatchers.any(Object[].class),ArgumentMatchers.any(TransactionService.TransactionMapper.class))).thenReturn(transactionsList);
    List<Transactions> transactionsresult= transactionService.findByAmount(500.0);
    assertEquals(transactionsList,transactionsresult);
}
@Test
    void testUpdateRemarks(){
//    Transactions transaction1 = new Transactions(25, new Date(2024, 05, 25), "sumanth", 4000.0, "family", "kavya");
//    Transactions transaction2 = new Transactions(20, new Date(2024, 02, 15), "snehal", 489.0, "bills", "anith");
//    List<Transactions> transactionsList= Stream.of(transaction1,transaction2).collect(Collectors.toList());
        List<Transactions> testremarks=testBlock();
      //  when(jdbcTemplate.query(any(String.class), any(Object[].class), any(TransactionService.TransactionMapper.class))).thenReturn(testremarks);
    when(jdbcTemplate.query(ArgumentMatchers.anyString(),ArgumentMatchers.any(Object[].class),ArgumentMatchers.any(TransactionService.TransactionMapper.class))).thenReturn(testremarks);

    Transactions result=transactionService.updateRemarks(testremarks.get(0));
        assertEquals(testremarks.get(1).toString(),result.toString());
}
@Test
    void testremoveTransactionBetweenDates(){
    Date startDate = new Date("05/15/2024");
    Date endDate = new Date("05/19/2024");

    when(jdbcTemplate.update(any(String.class),any(),any())).thenReturn(1);
    String result = transactionService.removeTransactionsBetweenDates(startDate, endDate);
    assertEquals("removed", result);
    //assertNotEquals("removed",result);

}
}
