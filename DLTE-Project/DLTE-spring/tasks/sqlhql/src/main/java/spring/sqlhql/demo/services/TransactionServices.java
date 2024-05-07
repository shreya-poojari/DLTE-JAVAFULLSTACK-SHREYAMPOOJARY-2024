package spring.sqlhql.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.sqlhql.demo.model.TransactionDetails;
import spring.sqlhql.demo.remotes.TransactionRepo;

import java.util.List;
@Service
public class TransactionServices {
    @Autowired
    TransactionRepo transactionRepo;
    public TransactionDetails newTransactions(TransactionDetails transactions){
        return transactionRepo.save(transactions);
    }
    public List<TransactionDetails> findAllByUserAndType(String user, String type){
        return transactionRepo.findByUserAndType(user,type);
    }
    public List<TransactionDetails> findAllByRange(double amount1, double amount2){
        return transactionRepo.findByRangeOfTransactionAmount(amount1,amount2);
    }
}
