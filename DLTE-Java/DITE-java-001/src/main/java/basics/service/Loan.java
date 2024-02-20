package basics.service;
import java.util.Scanner;

        //command line interaction:loan
/*
details:name, aadhaar, pan, address, mobile, email
income:salaried, self-employed:ITR
 */
public class Loan {
    public static void main(String[] args){
        String Name="", Pan="", Address="", Email="", IncomeTypes="";
        Long mobileNo=0L, aadhaar=0L, salary=0L;
        Scanner scanner=new Scanner(System.in);
        System.out.println("--------welcome to MYBank----------");
        System.out.println("enter your name");
        Name=scanner.nextLine();
        System.out.println("enter your aadhar number");
        aadhaar=scanner.nextLong();
        System.out.println("enter pan number");
        Pan=scanner.next();
        System.out.println("enter salary");
        salary=scanner.nextLong();
        System.out.println("tell your income type(Salaried/Self-employed)");
        IncomeTypes=scanner.next();
        System.out.println("enter mobile number");
        mobileNo=scanner.nextLong();
        System.out.println("enter the email address");
        Email=scanner.next();
        System.out.println("Dear "+Name+" Thanks for showing intrest on taking the personal Loan in MYBank.\n Your application has submitted.\n further details will be send mailed to "+Email+".\n SMS to "+mobileNo);
    }
}
