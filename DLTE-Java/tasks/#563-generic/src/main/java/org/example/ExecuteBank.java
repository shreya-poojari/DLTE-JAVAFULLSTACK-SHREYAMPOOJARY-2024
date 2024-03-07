package org.example;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class ExecuteBank {
    public static void main(String[] args) {
        MyBankDatabase<CreditCard> storeCardData = new MyBankDatabase<>();
        storeCardData.bankDataBase = new CreditCard[20];
        CreditCard creditCardOne = new CreditCard(983425678L, "shreya", new Date(2024, 05, 25), 777, 70000, 9740);
        CreditCard creditCardTwo = new CreditCard(983425687L, "Divya", new Date(2024, 6, 5), 333, 50000, 4987);
        MyBankDatabase<Transaction> transaction = new MyBankDatabase<>();
        Transaction transactionOne = new Transaction(new Date(2024, 05, 25), 4000, "vidya", "food");
        Transaction transactionTwo = new Transaction(new Date(2024, 07, 15), 6000, "vinay", "friend");
//            System.out.println(storeCardData.createNewData(creditCardOne));
//            storeCardData.createNewData(creditCardTwo);
////        System.out.println(Arrays.toString(storeCardData.bankDataBase));
//            System.out.println(storeCardData.readData(0).toString());
//        System.out.println("Card hs been deleted " +storeCardData.deletedata(1));
//            MyBankDatabase<Transaction> transactionData = new MyBankDatabase<>();
//            Transaction transactionOne = new Transaction(new Date(2024, 05, 25), 2000, "bhavya", "friend");
//        }
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("enter your choice");
            System.out.println("1.Add creditcard\n2.Read card\n3.Delete Card\n4.Update Card\n5.Insert new transaction\n6.Read transactions\n7.Delete transactions\n");
            int choice;
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println(storeCardData.createNewData(creditCardOne));
                    storeCardData.createNewData(creditCardTwo);
                    System.out.println("New credit Card has been added");
                    break;
                case 2:
                    System.out.println(storeCardData.readData(0).toString());
                    break;
                case 3:
                    storeCardData.deletedata(1);
                    System.out.println("Credit Card Deleted");
                    break;
                case 4:
                    creditCardOne.setCreditCardExpiry(new Date(2028,04,14));
                    storeCardData.updateData(0,creditCardOne);
                    System.out.println("Credit card Updated");
                    break;
                case 5:
                    System.out.println("transaction Database");
                    transaction.createNewData(transactionOne);
                    transaction.createNewData(transactionTwo);
                    System.out.println("Transaction Created");
                    break;
                case 6:
                    System.out.println("Transaction History: ");
                    System.out.println(transaction.readData(0).toString());
                    break;
                case 7:
                    transaction.deletedata(0);
                    System.out.println("Transaction Deleted");
                    break;

            }


        }
    }
}