package basics.service;

import java.util.Scanner;

public class GPay extends Account {
    private Integer upiPin;
    private String userName;

    public GPay(String accountHolder, Long accountNumber, Double accountBalance, Integer upiPin, String userName) {
        super(accountHolder, accountNumber, accountBalance);
        this.upiPin = upiPin;
        this.userName = userName;
    }
    public void payBills(String billerName, Double billAmount, String billType){
        Scanner scanner=new Scanner(System.in);
        Integer pin;
        int count = 0;
        while (count<5){
            System.out.println("enter the upi pin");
            pin = scanner.nextInt();
            if (pin.equals(upiPin)){
                accountBalance-=billAmount;
                System.out.println(billerName+", "+billType+" "+"bill paid successfully");
                System.out.println("Thankyou");
                break;
            }
            else{
                count++;
            }
        }
        if (count>=5){
            throw new MyCardException();
        }
    }
}
