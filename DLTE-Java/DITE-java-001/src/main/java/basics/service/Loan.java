package basics.service;
import java.util.Scanner;

        //command line interaction:loan
/*
details:name, aadhaar, pan, address, mobile, email
income:salaried, self-employed:ITR
 */
public class Loan {
    public static void main(String[] args){
        String borrowerName="", borrowerPan="", borrowerAddress="", borrowerEmail="", borrowerIncomeTypes="";
        Long mobileNumber=0L, aadhaar=0L, salary=0L;
        Scanner scanner=new Scanner(System.in);
        System.out.println("--------welcome to MYBank----------");
        System.out.println("fill your name");
        borrowerName=scanner.nextLine();
        System.out.println("fill your aadhar number");
        aadhaar=scanner.nextLong();
        System.out.println("enter the pan");
        borrowerPan=scanner.next();
        System.out.println("enter your salary");
        salary=scanner.nextLong();
        System.out.println("let us know income type(Salaried/Self-employed)");
        borrowerIncomeTypes=scanner.next();
        System.out.println("mention the mobile number");
        mobileNumber=scanner.nextLong();
        System.out.println("enter the email address");
        borrowerEmail=scanner.next();
        System.out.println("Dear "+borrowerName+" Thanks for showing intrest on taking the personal Loan in MYBank your application has submitted and further details will be send mailed to "+borrowerEmail+" or SMS to "+mobileNumber);
    }
}
