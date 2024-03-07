package org.example;

import  java.util.Scanner;

public class Execute {
    public static void main(String[] args){
        DebitCard[] customers=new DebitCard[10];
        customers[0]=new DebitCard(9876543219L,98765L,"Shreya",87654L,6789);
        Gpay gpay[]=new Gpay[10];
        gpay[0]=new Gpay(87654321234L,8765432L,"snehal","snehal",6780);
        Scanner scanner=new Scanner(System.in);
        Scanner scanner1=new Scanner(System.in);
        while (true){
            System.out.println("1.withdrawal\n2.payBills\n3.Exit");
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                    customers[0].withdraw();
                    break;
                case 2:
                    gpay[0].payBill("kavya",980L,"Recharge");
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
