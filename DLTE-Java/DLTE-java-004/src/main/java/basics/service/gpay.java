package basics.service;

import  java.util.Scanner;
public class gpay extends DebitCard{
    private String userName;
    private Integer upiPin;

    public gpay(String accountHolder, Long accountNumber, Double accountBalance, Long cardNumber, String cardPin, String userName, Integer upiPin) {
        super(accountHolder, accountNumber, accountBalance, cardNumber, cardPin);
        this.userName = userName;
        this.upiPin = upiPin;
    }

    public gpay(String accountHolder, Long accountNumber, Double accountBalance, String userName, Integer upiPin) {
        super(accountHolder, accountNumber, accountBalance);
        this.userName = userName;
        this.upiPin = upiPin;
    }

    //    public gpay(long accountNumber, String accountHolder, Double accountBalance, String userName, Integer upiPin) {
//        super(accountNumber, accountHolder, accountBalance);
//        this.userName = userName;
//        this.upiPin = upiPin;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public Integer getUpiPin() {
//        return upiPin;
//    }
//
//    public void setUpiPin(Integer upiPin) {
//        this.upiPin = upiPin;
//    }
    public void payBills(String billerName, Double billedAmount, String billType){
        Scanner scanner= new Scanner(System.in);
        System.out.println("enter upi pin");
        int pin = scanner.nextInt();
        if(pin==upiPin){
            accountBalance-= billedAmount;
            System.out.println(billerName+", "+billType+" "+"bill is paid successfully" );
            System.out.println("thank you");
        }
        else
        {
            System.out.println("Entered upi pin is invalid");
            System.out.println("try again");
        }



//        Integer checkpin = scanner.nextInt();
//        if (checkpin.equals(getUpiPin())){
//            if (billedAmount<= getAccountBalance()){
//                System.out.println("bill amount of "+billedAmount+" paid to "+billerName+ "\n Remark " +billerType+"\ntransaction complete");
//            }
//            else{
//                System.out.println("Insufficient balance");
//            }
//        }
//        else {
//            System.out.println("incorrect upi pin");
//        }
    }
}
