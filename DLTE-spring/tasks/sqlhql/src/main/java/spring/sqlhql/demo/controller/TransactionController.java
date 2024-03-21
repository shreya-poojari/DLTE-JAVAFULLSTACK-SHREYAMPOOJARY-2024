package spring.sqlhql.demo.controller;

import org.omg.IOP.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.sqlhql.demo.model.Transaction;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    //New Transaction of POST mapping as XML request
    @PostMapping(value = "/create" ,consumes = "application/xml",produces = "application/xml")
    public Transaction callNewTransaction(@RequestBody Transaction transactions){
        return transactionService.newTransactions(transactions);
    }
    //GetMapping using Native SQL query
    @GetMapping("/findByUserAndType/{name}/{type}")
    public List<Transaction> callFindTransactions(@PathVariable("name") String name,@PathVariable("type") String type){
        return transactionService.findAllByUserAndType(name, type);
    }
    //TransactionAmount by using HQL
    @GetMapping("/findByAmountRange/{amount1}/{amount2}")
    public List<Transaction> callFindByAmountRange(@PathVariable("amount1") double amount1, @PathVariable("amount2") double amount2){
        return transactionService.findAllByRange(amount1,amount2);
    }
}


