package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.example.readservice.FetchTransactions;
import org.example.readservice.TransactionByNameame;
import org.example.readservice.TransactionByNameService;
import org.example.readservice.Transactions;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AppTest 
{
    @Mock
    private TransactionByName transactionByName;

    @Mock
    private TransactionByNameService transactionByNameService;

    @Test
    public void testMain() {
        List<Transactions> mockTransactions = Arrays.asList(
                new Transactions("shreya", "transaction1"),
                new Transactions("shreya", "transaction2")
        );


        when(transactionByNameService.getTransactionByNamePort()).thenReturn(transactionByName);
        when(transactionByName.findAllByUsers("shreya")).thenReturn((FetchTransactions) mockTransactions);
        assertEquals("Expected transactions", mockTransactions, App.transactions);
    }
}
