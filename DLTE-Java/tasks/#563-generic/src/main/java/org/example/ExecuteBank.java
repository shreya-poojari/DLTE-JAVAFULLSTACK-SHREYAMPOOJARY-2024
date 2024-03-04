package org.example;

import java.util.Arrays;
import java.util.Date;

public class ExecuteBank {
    public static void main(String[] args) {
        MyBankDatabase<CreditCard> storeCardData = new MyBankDatabase<>();
        storeCardData.bankDataBase = new CreditCard[20];
        CreditCard creditCardOne = new CreditCard(983425678L, "shreya", new Date(2024, 05, 25), 777, 70000, 9740);
        CreditCard creditCardTwo = new CreditCard(983425687L, "Divya", new Date(2024, 6, 5), 333, 50000, 4987);

            System.out.println(storeCardData.createNewData(creditCardOne));
            storeCardData.createNewData(creditCardTwo);
//        System.out.println(Arrays.toString(storeCardData.bankDataBase));
            System.out.println(storeCardData.readData(0).toString());
        System.out.println("Card hs been deleted " +storeCardData.deletedata(1));
            MyBankDatabase<Transaction> transactionData = new MyBankDatabase<>();
            Transaction transactionOne = new Transaction(new Date(2024, 05, 25), 2000, "bhavya", "friend");
        }
    }
