package spring.sqlhql.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.sqlhql.demo.model.TransactionDetails;
import spring.sqlhql.demo.services.TransactionServices;

import java.util.List;

@RestController
@RequestMapping(name = "/transactions")
public class Transaction {
    @Autowired
    TransactionServices transactionServices;
    //New Transaction of POST mapping as XML request
    @PostMapping(value = "/create" ,consumes = "application/xml",produces = "application/xml")
    public TransactionDetails callNewTransaction(@RequestBody TransactionDetails transactions){
        return transactionServices.newTransactions(transactions);
    }
    //GetMapping using Native SQL query
    @GetMapping("/findByUserAndType/{name}/{type}")
    public List<TransactionDetails> callFindTransactions(@PathVariable("name") String name, @PathVariable("type") String type){
        return transactionServices.findAllByUserAndType(name, type);
    }
    //TransactionAmount by using HQL
    @GetMapping("/findByAmountRange/{amount1}/{amount2}")
    public List<TransactionDetails> callFindByAmountRange(@PathVariable("amount1") double amount1, @PathVariable("amount2") double amount2){
        return transactionServices.findAllByRange(amount1,amount2);
    }
}
