package org.example;

import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Scanner;

public class GPay {
    private int upiPin;
    private String userName;

    public GPay(int upiPin, String userName) {
        this.upiPin = upiPin;
        this.userName = userName;
    }
    public boolean isValidPin(int pin){
        return pin==upiPin;
    }
    public void payBill(String billerName, Double billedAmount, String billType){
        Scanner scanner=new Scanner(System.in);
        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
        System.out.println("Enter upi pin");
        int pin = scanner.nextInt();
        try {
            if (!isValidPin(pin)) {
                throw new MyBankException();
            }
        } catch (MyBankException exception){


        }
    }
}
