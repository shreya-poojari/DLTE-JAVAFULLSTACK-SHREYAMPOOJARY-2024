package basics.service;
import java.util.Scanner;
public class Sip {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int years;
        long invest;
        double rate, totalAmount;
        System.out.println("enter investment per month");
        invest=scanner.nextLong();
        System.out.println("enter time duratiom");
        years=scanner.nextInt();
        System.out.println("enter intrest rate");
        rate=scanner.nextDouble();
        rate=rate/(12*100);
        years *=12;
        totalAmount= (invest*((Math.pow(1+rate,years)-1)/rate)*(1+rate));
        System.out.println("the output is "+totalAmount);
    }
}
