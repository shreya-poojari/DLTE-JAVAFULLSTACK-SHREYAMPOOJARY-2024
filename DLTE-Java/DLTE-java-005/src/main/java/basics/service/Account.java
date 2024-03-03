package basics.service;

import java.util.Scanner;

public class Account {
protected String accountHolder;
protected Long accountNumber;
protected Double accountBalance;

    public Account(String accountHolder, Long accountNumber, Double accountBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }
}
