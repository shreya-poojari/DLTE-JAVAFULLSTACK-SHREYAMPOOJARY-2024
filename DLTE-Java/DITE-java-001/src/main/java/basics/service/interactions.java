package basics.service;

// command line interactions: car loan

/*
personal details:name, aadhaar, pan, address, mobile, email
income: salaried , self-employed:ITR
 */

import java.util.Scanner;

public class interactions {
    public static void main(String[] args){
        String borrowerName="", borrowerPan="", borrowerAddress="", borrowerEmail="", borrowerIncomeTypes="";
        Long mobileNumber=0L, aadhaar=0L;

        Scanner scanner=new Scanner(System.in);
        System.out.println("--------welcome to MYBank----------");
        System.out.println("fill your name");
        borrowerName=scanner.nextLine();
        System.out.println("fill your aadhar number");
        aadhaar=scanner.nextLong();
        System.out.println("enter the pan");
        borrowerPan=scanner.next();
        System.out.println("let us know income type(Salaried/Self-employed)");
        borrowerIncomeTypes=scanner.next();
        System.out.println("mention the mobile number");
        mobileNumber=scanner.nextLong();
        System.out.println("enter the email address");
        borrowerEmail=scanner.next();
        System.out.println("Dear "+borrowerName+"Thanks for showing intrest on taking the car Loan in my bank your application has submitted and further details will be send to your mailed to you "+borrowerEmail+" or SMS to "+mobileNumber);

    }
}
