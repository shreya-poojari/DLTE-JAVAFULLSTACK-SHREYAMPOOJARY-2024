package basics.service;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarLoan {
public static void main(String[] args){
    String BorrowerName="", BorrowerPan="", BorrowerAddress="", BorrowerEmail="",BorrowerIncomeType="";
    Long MobileNumber=0L, Aadhaar=0L;
    Scanner scanner=new Scanner(System.in);
    System.out.println("----welcome----");
    System.out.println("enter your name");
    BorrowerName= scanner.nextLine();
    Pattern pattern=Pattern.compile("^[a-zA-Z]+\\s[A-Za-z]+$");
    Matcher matcher= pattern.matcher(BorrowerName);
    if(matcher.matches())
    {
        System.out.println("UserName" +BorrowerName+ " is VALID");
    }
    else{
        System.out.println("Username" +BorrowerName+ "is INVALID");
    }
    System.out.println("Fill your Aadhaar number");
    Aadhaar= scanner.nextLong();
    Pattern Aadhaarpattern=pattern.compile("^\\d{12}");
    String value= String.valueOf(Aadhaar);
    Matcher Aadhaarmatcher=Aadhaarpattern.matcher(value);
    if(Aadhaarmatcher.matches())
    {
        System.out.println("Aadhaar " +Aadhaar+ " is VALID");
    }
    else
    {
        System.out.println("Aadhaar "+Aadhaar+" is INVALID" );
    }
    System.out.println("enter your pan");
    BorrowerPan=scanner.next();
    Pattern panPattern=pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]$");
    Matcher panmatcher=pattern.matcher(BorrowerPan);
    if(panmatcher.matches())
    {
        System.out.println("Username" +BorrowerPan+ "is VALID");
    }
    else
    {
        System.out.println("Username" +BorrowerPan+ "is INVALID");
    }
    System.out.println("enter your email");
    BorrowerEmail=scanner.next();
    System.out.println("enter your mobile number");
    MobileNumber=scanner.nextLong();
    Pattern mobpattern=pattern.compile("^\\d{10}");
    String mobvalue=String.valueOf(MobileNumber);
    Matcher mobmatcher=mobpattern.matcher(mobvalue);
    if(mobmatcher.matches())
    {
        System.out.println("Mobile number "+MobileNumber+" is VALID");
    }
    else
    {
        System.out.println("Mobile number "+MobileNumber+" is INVALID" );
    }
    System.out.println("Dear "+BorrowerName+" thanks for having intrest in taking loan in MyBank futher details will be mailed to "+BorrowerEmail+" or sms to "+MobileNumber);
}
}

