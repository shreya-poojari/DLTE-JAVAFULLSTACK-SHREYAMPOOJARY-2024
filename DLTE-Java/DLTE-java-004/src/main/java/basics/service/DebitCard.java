package basics.service;

import java.util.Scanner;

public class DebitCard extends Account {
    private Long cardNumber;
    private String cardPin;

    public DebitCard(String accountHolder, Long accountNumber, Double accountBalance, Long cardNumber, String cardPin) {
        super(accountHolder, accountNumber, accountBalance);
        this.cardNumber = cardNumber;
        this.cardPin = cardPin;
    }

    public DebitCard(String accountHolder, Long accountNumber, Double accountBalance) {
        super(accountHolder, accountNumber, accountBalance);
    }
    public void withdraw(Double amount){
        Scanner scanner= new Scanner(System.in);
        if (amount<accountBalance){
            System.out.println("enter the pin");
            String pin= scanner.next();
            if (pin.equals(cardPin)){
                accountBalance-= amount;
            }
        }
        System.out.println("remaining Balance after withdrawal is " +accountBalance);
    }
}


//    long CardNumber;
//    Integer CardPin;
//    Scanner scanner = new Scanner(System.in);
//
//    public DebitCard(long accountNumber, String accountHolder, Double accountBalance, long cardNumber, Integer cardPin) {
//        super(accountNumber, accountHolder, accountBalance);
//        CardNumber = cardNumber;
//        CardPin = cardPin;
//
//    }
//
//    public long getCardNumber() {
//        return CardNumber;
//    }
//
//    public void setCardNumber(long cardNumber) {
//        CardNumber = cardNumber;
//    }
//
//    public Integer getCardPin() {
//        return CardPin;
//    }
//
//    public void setCardPin(Integer cardPin) {
//        CardPin = cardPin;
//    }
//
//    public Scanner getScanner() {
//        return scanner;
//    }
//
//    public void setScanner(Scanner scanner) {
//        this.scanner = scanner;
//    }
//
//
//    public void amountWithdraw() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter credit card pin");
//        Integer pin = scanner.nextInt();
//        if(pin.equals(getCardPin())){
//            System.out.println("enter the withdrawal amount");
//            Double withDrawAmount = scanner.nextDouble();
//            Double remBalance = getAccountBalance() - withDrawAmount;
//            if (withDrawAmount <= getAccountBalance()){
//                System.out.println("sufficient amount exists");
//                System.out.println("the amount withdrawn successfully");
//                System.out.println("remaining balance"+ remBalance);
//            }
//            else{
//                System.out.println("Insufficient balance\nbalance "+getAccountBalance());
//            }
//        }else{
//            System.out.println("wrong credit card PIN");
//        }
//
//    }
//}