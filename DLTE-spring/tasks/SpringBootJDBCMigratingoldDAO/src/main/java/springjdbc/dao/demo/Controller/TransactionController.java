package springjdbc.dao.demo.Controller;


import org.springframework.web.bind.annotation.*;
import springjdbc.dao.demo.Entity.Transactions;
import springjdbc.dao.demo.Service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private TransactionService transactionService;
    @PostMapping("/addTransaction")
    //adding new transaction using http://localhost:1002/Transactions/addTransaction/
    public Transactions newTransaction(@RequestBody Transactions transactions) {
        return transactionService.newTransaction(transactions);
    }
    @GetMapping("/sender/{sender}")
    //retrieving list of transactions by entering sender's name using http://localhost:1002/Transactions/sender/{sender}
    public List<Transactions> findBySender(@PathVariable String sender) {
        return transactionService.findBySender(sender);
    }
    @GetMapping("/receiver/{receiver}")
    //retrieving list of transactions by entering receiver's name using http://localhost:1002/transactions/receiver/{receiver}
    public List<Transactions> findByReceiver(@PathVariable String receiver) {
        return transactionService.findByReceiver(receiver);
    }
    @GetMapping("/amount/{amount}")
    //retrieving list of transactions by entering amount using http://localhost:1002/Transactions/amount/{amount}
    public List<Transactions> findByAmount(@PathVariable Long amount) {
        return transactionService.findByAmount(amount);
    }
}
