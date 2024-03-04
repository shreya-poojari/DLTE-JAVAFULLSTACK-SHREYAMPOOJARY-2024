package org.example;

public class Account {
    public Long accountNumber;
    private Double accountBalance;
    private String accountHolder;

    public Account(Long accountNumber, Double accountBalance, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountHolder = accountHolder;
    }
}
