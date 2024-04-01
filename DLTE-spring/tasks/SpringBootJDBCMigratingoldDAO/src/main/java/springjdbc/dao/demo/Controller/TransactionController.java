package springjdbc.dao.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springjdbc.dao.demo.Entity.Transactions;
import springjdbc.dao.demo.Service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @PostMapping("/addTransaction")
    //http://localhost:1002/Transactions/addTransaction/
    public Transactions newTransaction(@RequestBody Transactions transactions) {
        return transactionService.newTransaction(transactions);
    }
    @GetMapping("/sender/{sender}")
    //http://localhost:1002/Transactions/sender/{sender}
    public List<Transactions> findBySender(@PathVariable String sender) {
        return transactionService.findBySender(sender);
    }
    @GetMapping("/receiver/{receiver}")
    //http://localhost:1002/transactions/receiver/{receiver}
    public List<Transactions> findByReceiver(@PathVariable String receiver) {
        return transactionService.findByReceiver(receiver);
    }
    @GetMapping("/amount/{amount}")
    //http://localhost:1002/Transactions/amount/{amount}
    public List<Transactions> findByAmount(@PathVariable Long amount) {
        return transactionService.findByAmount(amount);
    }
    @PutMapping("/Update/*")
    public List<Transactions> updateRemarks(@RequestBody Transactions transactions){
        Transactions transactions1= (Transactions) transactionService.updateRemarks(transactions);
        return (List<Transactions>) transactions1;
    }
}
