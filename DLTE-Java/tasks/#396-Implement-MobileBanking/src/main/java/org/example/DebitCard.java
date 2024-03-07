package org.example;

import java.util.Scanner;

public class DebitCard extends AccountDetails {
    private Long CardNumber;
    private Integer CardPin;

    public DebitCard(Long accountNumber, Long accountBalance, String accountHolder, Long cardNumber, Integer cardPin) {
        super(accountNumber, accountBalance, accountHolder);
        CardNumber = cardNumber;
        CardPin = cardPin;
    }

    public Long getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        CardNumber = cardNumber;
    }

    public Integer getCardPin() {
        return CardPin;
    }

    public void setCardPin(Integer cardPin) {
        CardPin = cardPin;
    }
    public void withdraw(){
        Scanner scanner=new Scanner((System.in));
        int Pin=0;
        System.out.println("enter current pin");
        Pin= scanner.nextInt();
        long withdrawAmount=0L;
        if (Pin==getCardPin()){
            System.out.println("Enter the amount to be withdrawan");
            withdrawAmount=scanner.nextLong();
            if (withdrawAmount<=getAccountBalance()){
                System.out.println("Amount withdrawn");
                this.setAccountBalance(this.getAccountBalance()-withdrawAmount);
            }
            else{
                System.out.println("insufficient balance");
            }
        }
        else{
            System.out.println("Pin incorrect");
        }
    }
}
