package soap.webservice.demo;

import com.fasterxml.jackson.databind.ext.CoreXMLSerializers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import services.transactions.*;
import soap.webservice.demo.configs.SoapPhase;
import soap.webservice.demo.dao.Transactions;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import javax.xml.datatype.XMLGregorianCalendar;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EndPointTest {
    @MockBean
    private TransactionService transactionService;

    @InjectMocks
    private SoapPhase soapPhase;

    @Test
    public void testAddTransaction(){
        soap.webservice.demo.dao.Transactions mockTransaction = new soap.webservice.demo.dao.Transactions(15, new Date(), "shreya", 400.0, "food", "prabha");
        when(transactionService.newTransaction(any(soap.webservice.demo.dao.Transactions.class))).thenReturn(mockTransaction);

        AddTransactionRequest transactionRequest = new AddTransactionRequest();
        services.transactions.Transactions actual = new services.transactions.Transactions();
        transactionRequest.setTransaction(actual);

        actual.setTransactionId(15);
        actual.setTransactionDate(XMLGregorianCalendarImpl.createDate(2024,05,25,0));
        actual.setTransactionTo("shreya");
        actual.setTransactionAmount(400.0);
        actual.setTransactionRemarks("family");
        actual.setTransactionBy("prabha");
        AddTransactionResponse response = soapPhase.addTransactionResponse(transactionRequest);

        assertEquals("SUCCESS", response.getServiceStatus().getStatus());
        assertEquals(15, response.getTransaction().getTransactionId());
        assertEquals("shreya", response.getTransaction().getTransactionTo());
        assertEquals(400.0, response.getTransaction().getTransactionAmount());
        assertEquals("family", response.getTransaction().getTransactionRemarks());
        assertEquals("prabha", response.getTransaction().getTransactionBy());
          }

          @Test
    public void testfindBySender(){
              List<Transactions> mockTransactions = new ArrayList<>();
              mockTransactions.add(new Transactions(25, new Date(2024, 05, 25), "sumanth", 4000.0, "family", "kavya"));

              when(transactionService.findBySender("kavya")).thenReturn(mockTransactions);
              SenderRequest request = new SenderRequest();
              request.setSender("kavya");
              SenderResponse response = soapPhase.findBySender(request);
              assertEquals("SUCCESS", response.getServiceStatus().getStatus());
              assertEquals("transactions found for the sender", response.getServiceStatus().getMessage());
    }

    @Test
    public void testfindByReceiver(){
        List<Transactions> mockTransactions = new ArrayList<>();
        mockTransactions.add(new Transactions(25, new Date(2024, 05, 25), "sumanth", 4000.0, "family", "kavya"));

        when(transactionService.findByReceiver("sumanth")).thenReturn(mockTransactions);
        ReceiverRequest request = new ReceiverRequest();
        request.setReceiver("sumanth");
        ReceiverResponse response = soapPhase.findByReceiver(request);
        assertEquals("SUCCESS", response.getServiceStatus().getStatus());
        assertEquals("transactions found for the receiver", response.getServiceStatus().getMessage());
    }

    @Test
    public void testfindByAmount(){
        List<Transactions> mockTransactions = new ArrayList<>();
        mockTransactions.add(new Transactions(25, new Date(2024, 05, 25), "sumanth", 4000.0, "family", "kavya"));
        when(transactionService.findByAmount(4000.0)).thenReturn(mockTransactions);
        AmountRequest request = new AmountRequest();
        request.setAmount(4000.0);

        AmountResponse response = soapPhase.findByAmount(request);

        assertEquals("SUCCESS", response.getServiceStatus().getStatus());
        assertEquals("transactions found for the amount", response.getServiceStatus().getMessage());
        assertEquals(1, response.getTransaction().size());
    }

    @Test
    public void testUpdateRemaprks(){
       soap.webservice.demo.dao.Transactions updatedTransaction = new soap.webservice.demo.dao.Transactions();

        updatedTransaction.setTransactionId(15);
        updatedTransaction.setTransactionDate(new Date());
        updatedTransaction.setTransactionTo("shreya");
        updatedTransaction.setTransactionAmount(200.0);
        updatedTransaction.setTransactionRemarks("food");
        updatedTransaction.setTransactionBy("prabha");

        when(transactionService.updateRemarks(any(soap.webservice.demo.dao.Transactions.class))).thenReturn(updatedTransaction);

        UpdateRemarksRequest request = new UpdateRemarksRequest();
        services.transactions.Transactions transaction = new services.transactions.Transactions();
        transaction.setTransactionId(15);
       // transaction.setTransactionDate(XMLGregorianCalendarImpl.createDate(2024, 3, 28, 0));
        transaction.setTransactionTo("Shreya");
        transaction.setTransactionAmount(200.0);
        transaction.setTransactionRemarks("family");
        transaction.setTransactionBy("prabha");

        request.setTransaction(transaction);

        UpdateRemarksResponse response = soapPhase.updateRemarks(request);

        assertEquals("SUCCESS", response.getServiceStatus().getStatus());
        assertEquals("updated remarks for transaction:15", response.getServiceStatus().getMessage());
        assertEquals(15, response.getTransaction().getTransactionId());
        assertEquals("shreya", response.getTransaction().getTransactionTo());
        assertEquals("prabha", response.getTransaction().getTransactionBy());
        assertEquals(200.0, response.getTransaction().getTransactionAmount());
        assertEquals("food", response.getTransaction().getTransactionRemarks());
    }
    @Test
    public void testRemoveTransactionBetweenDates(){
        Date startDate = Date.from(Instant.parse("2024-05-19T00:00:00Z"));
        Date endDate = Date.from(Instant.parse("2024-02-25T24:00:00Z"));
//        String message = transactionService.removeTransactionsBetweenDates(startDate, endDate);
//        message.equals("done");
        when(transactionService.removeTransactionsBetweenDates(startDate, endDate)).thenReturn("done");

       DeleteDatesRequest request = new DeleteDatesRequest();
        XMLGregorianCalendar start = XMLGregorianCalendarImpl.createDateTime(2024, 5, 19, 0, 0, 0, 0, 0);
        XMLGregorianCalendar end = XMLGregorianCalendarImpl.createDateTime(2024, 5, 25, 24, 0, 0, 0, 0);
        request.setStartDate(start);
        request.setEndDate(end);

        DeleteDatesResponse response = soapPhase.removeTransactionBetweenDates(request);

        assertEquals("done", response.getServiceStatus().getStatus());
        assertEquals("done", response.getServiceStatus().getMessage());
    }
}
