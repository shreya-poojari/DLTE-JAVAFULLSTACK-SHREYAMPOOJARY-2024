package basics.service;
import java.util.Scanner;
public class internetBanking {
    public static void main(String[] args) {
        String userName = "", userPass = "", userAuthCode = "", userEmail = "", destName = "", destAcc = "", destPh = "";
        Long userOtp = 0L, amount = 0L, transferOtp = 0L;
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------welcome to MYBank----------");
        System.out.println("fill your name");
        userName = scanner.nextLine();
        System.out.println("fill your Password");
        userPass = scanner.nextLine();
        System.out.println("fill your Email/Registered Phone number");
        userEmail = scanner.next();
        System.out.println("enter otp");
        userOtp = scanner.nextLong();
        System.out.println("Enter two step verification Authenticaltion code");
        userAuthCode = scanner.next();
        System.out.println("Dear " + userName + " thanks for showing intrest");
        System.out.println("---------enter recipients details-----------");
        System.out.println("fill recipients name");
        destName = scanner.nextLine();
        System.out.println("enter recipients account number");
        destAcc = scanner.nextLine();
        System.out.println("enter recipients phone number");
        destPh = scanner.next();
        System.out.println("enter amount");
        amount = scanner.nextLong();
        System.out.println("enter otp");
        transferOtp = scanner.nextLong();
        System.out.println("Dear " + userName +" the amount of RS=" + amount + "is transfered");
    }
}



