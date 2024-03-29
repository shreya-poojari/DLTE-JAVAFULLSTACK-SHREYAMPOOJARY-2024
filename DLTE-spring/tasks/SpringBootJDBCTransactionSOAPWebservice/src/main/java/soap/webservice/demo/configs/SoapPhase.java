package soap.webservice.demo.configs;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import soap.webservice.demo.dao.TransactionService;
import soap.webservice.demo.dao.Transactions;
import services.transactions.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.*;

@Endpoint
public class SoapPhase {

    private final String url = "http://transactions.services";

    @Autowired
    private TransactionService transactionService;

    @PayloadRoot(namespace = url, localPart = "addTransactionRequest")
    @ResponsePayload
    public AddTransactionResponse addTransactionResponse(@RequestPayload AddTransactionRequest request) {
        AddTransactionResponse response = new AddTransactionResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        Transactions transactions = new Transactions();

        services.transactions.Transactions newTransaction = request.getTransaction();
        Date date=request.getTransaction().getTransactionDate().toGregorianCalendar().getTime();
        transactions.setTransactionDate(date);
        BeanUtils.copyProperties(newTransaction, transactions);
        Transactions savedTransaction = transactionService.newTransaction(transactions);

        if (savedTransaction != null) {
            serviceStatus.setStatus("SUCCESS");
            BeanUtils.copyProperties(transactions, newTransaction);
            response.setTransaction(newTransaction);
            serviceStatus.setMessage("Transaction added successfully");
        } else {
            serviceStatus.setStatus("FAILURE");
            serviceStatus.setMessage("Failed to add transaction");
        }
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = url, localPart = "senderRequest")
    @ResponsePayload
    public SenderResponse findBySender(@RequestPayload SenderRequest request) {
        SenderResponse response = new SenderResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        List<services.transactions.Transactions> transactionsList = new ArrayList<>();
        List<Transactions> transactions = transactionService.findBySender(request.getSender());

        Iterator<Transactions> iterator = transactions.iterator();
        while (iterator.hasNext()) {
            services.transactions.Transactions currentTransactions = new services.transactions.Transactions();
           // Transactions currentTransactions = new Transactions();
         //   XMLGregorianCalendar date=currentTransactions.getTransactionDate().toGregorianCalendar().getTime();

            BeanUtils.copyProperties(iterator.next(), currentTransactions);
            //Date date=currentTransactions.getTransactionDate().t;\
           // XMLGregorianCalendar date=currentTransactions.getTransactionDate().toGregorianCalendar().getTime();
//            GregorianCalendar gregorianCalendar = new GregorianCalendar();
//            gregorianCalendar.setTime(endDate);
//            XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
            //currentTransactions.setTransactionDate(date);
            transactionsList.add(currentTransactions);
        }
        if (transactions != null && !transactions.isEmpty()) {
            serviceStatus.setStatus("SUCCESS");
            serviceStatus.setMessage("transactions found for the sender");
            response.getTransaction().addAll(transactionsList);
        } else {
            serviceStatus.setStatus("FAILURE");
            serviceStatus.setMessage("No transactions found for sender: " + request.getSender());
        }
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = url, localPart = "receiverRequest")
    @ResponsePayload
    public ReceiverResponse findByReceiver(@RequestPayload ReceiverRequest request) {
        ReceiverResponse response = new ReceiverResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        List<services.transactions.Transactions> transactionsList = new ArrayList<>();
        List<Transactions> transactions = transactionService.findByReceiver(request.getReceiver());

        Iterator<Transactions> iterator = transactions.iterator();
        while (iterator.hasNext()) {
            services.transactions.Transactions currentTransactions = new services.transactions.Transactions();
            BeanUtils.copyProperties(iterator.next(), currentTransactions);
            transactionsList.add(currentTransactions);
        }
        if (transactions != null && !transactions.isEmpty()) {
            serviceStatus.setStatus("SUCCESS");
            serviceStatus.setMessage("transactions found for the receiver");
            response.getTransaction().addAll(transactionsList);
        } else {
            serviceStatus.setStatus("FAILURE");
            serviceStatus.setMessage("No transactions found for receiver: " + request.getReceiver());
        }
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = url, localPart = "amountRequest")
    @ResponsePayload
    public AmountResponse findByAmount(@RequestPayload AmountRequest request) {
        AmountResponse response = new AmountResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        List<services.transactions.Transactions> transactionsList = new ArrayList<>();
        List<Transactions> transactions = transactionService.findByAmount(request.getAmount());

        Iterator<Transactions> iterator = transactions.iterator();
        while (iterator.hasNext()) {
            services.transactions.Transactions currentTransactions = new services.transactions.Transactions();
            BeanUtils.copyProperties(iterator.next(), currentTransactions);
            transactionsList.add(currentTransactions);
        }
            if (transactions != null && !transactions.isEmpty()) {
                serviceStatus.setStatus("SUCCESS");
                serviceStatus.setMessage("transactions found for the amount");
                response.getTransaction().addAll(transactionsList);
            } else {
                serviceStatus.setStatus("FAILURE");
                serviceStatus.setMessage("No transactions found for amount: " + request.getAmount());
            }
            response.setServiceStatus(serviceStatus);
            return response;
    }
        @PayloadRoot(namespace = url, localPart = "updateRemarksRequest")
    @ResponsePayload
    public UpdateRemarksResponse updateRemarks(@RequestPayload UpdateRemarksRequest request) {
        UpdateRemarksResponse response = new UpdateRemarksResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        services.transactions.Transactions transactions=new services.transactions.Transactions();
        soap.webservice.demo.dao.Transactions message=new soap.webservice.demo.dao.Transactions();
            BeanUtils.copyProperties(request.getTransaction(),message);
            message = transactionService.updateRemarks(message);
        //String message = transactionService.updateRemarks(request.getTransactionId(), request.getRemarks());
        if (message != null) {
            serviceStatus.setStatus("SUCCESS");
            BeanUtils.copyProperties(message,transactions);
            serviceStatus.setMessage("updated remarks for transaction:" + message.getTransactionId());
        } else {
            serviceStatus.setStatus("FAILURE");
            serviceStatus.setMessage("Failed to update remarks for transaction: " + message.getTransactionId());
        }
        response.setTransaction(transactions);
        response.setServiceStatus(serviceStatus);
        return response;
    }
        @PayloadRoot(namespace = url, localPart = "deleteDatesRequest")
    @ResponsePayload
    public DeleteDatesResponse removeTransactionBetweenDates(@RequestPayload DeleteDatesRequest request) {
        DeleteDatesResponse response = new DeleteDatesResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        Date startDate = request.getStartDate().toGregorianCalendar().getTime();
        Date endDate = request.getEndDate().toGregorianCalendar().getTime();
        String message = transactionService.removeTransactionsBetweenDates(startDate, endDate);
        if (message.equals("done")) {
            serviceStatus.setStatus("SUCCESS");
            serviceStatus.setMessage(message);
        } else {
            serviceStatus.setStatus("FAILURE");
            serviceStatus.setMessage("Failed to remove transactions between dates");
        }
        response.setServiceStatus(serviceStatus);
        return response;
    }
}




