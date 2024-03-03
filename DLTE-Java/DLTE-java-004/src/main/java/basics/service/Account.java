package basics.service;

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

//    long AccountNumber;
//    String AccountHolder;
//    Double AccountBalance;
//
//    public Account(long accountNumber, String accountHolder, Double accountBalance) {
//        AccountNumber = accountNumber;
//        AccountHolder = accountHolder;
//        AccountBalance = accountBalance;
//    }
//
//    public long getAccountNumber() {
//        return AccountNumber;
//    }
//
//    public void setAccountNumber(long accountNumber) {
//        AccountNumber = accountNumber;
//    }
//
//    public String getAccountHolder() {
//        return AccountHolder;
//    }
//
//    public void setAccountHolder(String accountHolder) {
//        AccountHolder = accountHolder;
//    }
//
//    public Double getAccountBalance() {
//        return AccountBalance;
//    }
//
//    public void setAccountBalance(Double accountBalance) {
//        AccountBalance = accountBalance;
//    }
//}
