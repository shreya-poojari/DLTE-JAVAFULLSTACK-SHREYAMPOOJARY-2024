package spring.sqlhql.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.sqlhql.demo.model.Transaction;
import spring.sqlhql.demo.remotes.TransactionRepo;

import java.util.List;
@Service
public class TransactionService {
    @Autowired
    TransactionRepo transactionRepo;
    public Transaction newTransactions(Transaction transactions){
        return transactionRepo.save(transactions);
    }
    public List<Transaction> findAllByUserAndType(String user, String type){
        return transactionRepo.findByUserAndType(user,type);
    }
    public List<Transaction> findAllByRange(double amount1,double amount2){
        return transactionRepo.findByRangeOfTransactionAmount(amount1,amount2);
    }

}
