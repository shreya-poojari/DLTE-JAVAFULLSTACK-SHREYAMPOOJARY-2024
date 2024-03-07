package org.example;

import  java.util.Scanner;

public class Gpay extends AccountDetails{
    String userName;
    Integer Pin;

    public Gpay(Long accountNumber, Long accountBalance, String accountHolder, String userName, Integer pin) {
        super(accountNumber, accountBalance, accountHolder);
        this.userName = userName;
        Pin = pin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPin() {
        return Pin;
    }

    public void setPin(Integer pin) {
        Pin = pin;
    }
    public void payBill(String billerName,Long billedAmount,String billType){
        int PinNumber=0;
        System.out.println("enter Pin");
        Scanner scanner=new Scanner(System.in);
        PinNumber=scanner.nextInt();
        if (PinNumber == getPin()){
            if (billedAmount<=getAccountBalance()){
                System.out.println("bill paid:"+"biller name: "+billerName+"bill amounnt:"+billedAmount+"bill type: "+billType);
                setAccountBalance(getAccountNumber()-billedAmount);
            }
            else {
                System.out.println("insufficient Balance");
            }
        }
        else{
            System.out.println("incorrect pin");
        }
        System.out.println(getAccountBalance());
    }
}
