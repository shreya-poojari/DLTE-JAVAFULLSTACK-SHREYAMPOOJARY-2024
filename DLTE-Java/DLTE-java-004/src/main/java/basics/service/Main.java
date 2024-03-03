package basics.service;

import java.util.Scanner;

public class Main {
public static void main(String[] args){

    gpay gPay= new gpay("shreya", 987654321L, 76000D, 765432198L,"8867", "shreya",333 );

    Scanner scanner = new Scanner(System.in);
    Scanner scanner1= new Scanner(System.in);
    while (true){
        System.out.println("1.withdraw\n2. pay bills\n3. Exit");
        int choice= scanner.nextInt();
        switch(choice){
            case 1:
                System.out.println("enter the amount to withdrawal");
                double withdrawAmount = scanner.nextDouble();
                gPay.withdraw(withdrawAmount);
                break;
            case 2:
                System.out.println("enter the biller name");
                String billerName = scanner1.nextLine();
                System.out.println("enter the billtype");
                String billType = scanner1.nextLine();

                System.out.println("enter the bill Amount");
                Double billAmount = scanner1.nextDouble();

                gPay.payBills(billerName, billAmount,billType );
                break;

            default:scanner.close();
            scanner1.close();
            System.exit(0);
        }
    }
}
}
