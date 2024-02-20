package basics.service;
import java.util.Scanner;
public class Mobilebanking {
    public static void main(String[] args) {
        String UserPin = "", RecipientName = "", ReciepientAcc = "", ReciepientPh = "";
        Long  amount = 0L, UPIpin = 0L;
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------welcome to MobileBank----------");
        System.out.println("enter your Pin");
        UserPin = scanner.nextLine();
        System.out.println("--------Enter details----------");
        System.out.println("enter name/ account number/ phone number");
        RecipientName = scanner.nextLine();
        System.out.println("enter amount");
        amount = scanner.nextLong();
        System.out.println("enter upi pin");
        UPIpin = scanner.nextLong();
        System.out.println("the amount of RS=" + amount + " is transferred to " + RecipientName+ " succesfully");
    }
}
