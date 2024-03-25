package springjdbc.dao.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import springjdbc.dao.demo.Controller.TransactionController;
import springjdbc.dao.demo.Entity.Transactions;
import springjdbc.dao.demo.Service.TransactionService;


import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(TransactionController.class)
@AutoConfigureMockMvc
public class EndpointTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TransactionService transactionService;

    @Test
    public void testNewTransactionEndpoint() throws Exception {
        Transactions transaction = new Transactions(104, java.sql.Date.valueOf("2024-03-26"), "dhanush", 2000, "food", "shreya");
        String request = "{\"transactionId\": 123456, \"transactionDate\": \"2024-03-25\", \"transactionTo\": \"Receiver\", \"transactionAmount\": 1000, \"transactionRemarks\": \"Test\", \"transactionBy\": \"Sender\"}";
        getMockMvc().perform(MockMvcRequestBuilders.post("/Transactions/addTransaction")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void testFindBySenderEndpoint() throws Exception {
        Transactions transaction = new Transactions(107, java.sql.Date.valueOf("2024-03-26"), "shreya", 200, "stationary", "seetha");
        List<Transactions> transactions = Arrays.asList(transaction);
        when(transactionService.findBySender("shreya")).thenReturn(transactions);

        getMockMvc().perform(MockMvcRequestBuilders.get("/transactions/sender/seetha")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].transactionBy").value("shreya")); //fail
                //.andExpect(MockMvcResultMatchers.jsonPath("$[0].transactionBy").value("seetha")); //pass
    }

    @Test
    public void testFindByReceiverEndpoint() throws Exception {
        Transactions transaction = new Transactions(108, java.sql.Date.valueOf("2024-03-28"), "kavya", 500, "friend", "geetha");
        List<Transactions> transactions = Arrays.asList(transaction);
        when(transactionService.findByReceiver("")).thenReturn(transactions);

        getMockMvc().perform(MockMvcRequestBuilders.get("/transactions/receiver/kavya")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].transactionTo").value("kavya")); //pass
        //.andExpect(MockMvcResultMatchers.jsonPath("$[0].transactionTo").value("geetha"));//fail
    }

    @Test
    public void testFindByAmountENdpoint() throws Exception {
        Transactions transaction = new Transactions(108, java.sql.Date.valueOf("2024-03-28"), "kavya", 50000, "friend", "geetha");
        List<Transactions> transactions = Arrays.asList(transaction);
        when(transactionService.findByAmount(500L)).thenReturn(transactions);

        getMockMvc().perform(MockMvcRequestBuilders.get("/transactions/amount/500")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].transactionAmount").value(300)); //fail
                //.andExpect(MockMvcResultMatchers.jsonPath("$[0].transactionAmount").value(50000)); //pass

    }

    public MockMvc getMockMvc() {
        return mockMvc;
    }

    public void setMockMvc(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }
}
