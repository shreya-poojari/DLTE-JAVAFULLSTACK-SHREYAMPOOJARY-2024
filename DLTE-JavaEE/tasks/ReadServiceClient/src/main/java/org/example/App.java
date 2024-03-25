package org.example;

import org.example.readservice.TransactionByName;
import org.example.readservice.Transactions;
import org.example.readservice.TransactionByNameService;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        TransactionByNameService transactionByUsernameService=new TransactionByNameService();
        TransactionByName transactionByUsername=transactionByUsernameService.getTransactionByNamePort();
        List<Transactions> transactions = (List<Transactions>) transactionByUsername.findAllByUsers("shreya");
        for (Transactions each : transactions) {
            System.out.println(each);
        }
    }
}
