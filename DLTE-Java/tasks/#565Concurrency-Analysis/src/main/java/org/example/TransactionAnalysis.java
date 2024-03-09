package org.example;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TransactionAnalysis implements Runnable {
    Lock lock = new ReentrantLock();
    Transaction[] transactions={
            new Transaction(new Date(2024,5,16),988,"shreya","food"),
            new Transaction(new Date(2024,8,23),845,"kavya","education"),
            new Transaction(new Date(2024,6,1),993,"snehal","emergency"),
            new Transaction(new Date(2024,5,30),234,"dhanush","family"),
            new Transaction(new Date(2024,4,25),123,"anith","bill"),
    };
    public void run(){
        lock.lock();
        TransactionAnalysis customerAnalysis = new TransactionAnalysis();
        int choice;
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.println("TRANSACTION ANALYSIS");
            System.out.println("enter your choice");
            System.out.println("1.Least amount transferred\n2.Transaction to particular benificiary\n3.filtering based on particular remarks\n4.sort in descending based on benificiary\n5.sort based on amount transferred ascending\n6.to identify the maximum transaction");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    customerAnalysis.leastAmountTransferred(transactions);
                    break;
                case 2:
                    customerAnalysis.transactionToParticulaeBenificiary(transactions);
                    break;
                case 3:
                    customerAnalysis.filteringBasedParticularRemarks(transactions);
                    break;
                case 4:
                    customerAnalysis.sortBenificiary(transactions);
                    break;
                case 5:
                    customerAnalysis.sortAmount(transactions);
                    break;
                case 6:
                    customerAnalysis.maxAmountTransferred(transactions);
                    break;
            }
        }
    }

    public void displayTransactionToWhom() {
        System.out.println("names To whom money is sent");
        for (Transaction each : transactions) {
            System.out.println(each.getToWhom());
        }
    }

    public void displayAllRemarks() {
        System.out.println("All remarks in the transaction");
        for (Transaction each : transactions) {
            System.out.println(each.getRemarks());
        }
    }

    public void displayAllAmount() {
        System.out.println("All amount transferred");
        for (Transaction each : transactions) {
            System.out.println(each.getAmountInTransaction());
        }
    }

    public void leastAmountTransferred(Transaction[] transactions) {
        int leastAmount = Integer.MAX_VALUE;
        for (Transaction each : transactions) {
            int compareAmount = each.getAmountInTransaction();
            if (compareAmount < leastAmount) {
                leastAmount = compareAmount;
            }
        }
        System.out.println("The least amount transferred is " + leastAmount);
    }

    public void maxAmountTransferred(Transaction[] transactions) {
        int MaxAmount = Integer.MIN_VALUE;
        for (Transaction each : transactions) {
            int compareAmount = each.getAmountInTransaction();
            if (compareAmount > MaxAmount) {
                MaxAmount = compareAmount;
            }
        }
        System.out.println("the maximum amount transferred is " + MaxAmount);
    }

    public void transactionToParticulaeBenificiary(Transaction[] transactions0) {
        Scanner scanner = new Scanner(System.in);
        String Beneficiary;
        System.out.println("Enter beneficiary name");
        Beneficiary = scanner.next();
        int NumberOfTransaction = 0;
        for (Transaction each : transactions) {
            if (each.getToWhom().equals(Beneficiary)) {
                NumberOfTransaction++;
            }
        }
        System.out.println("number of transaction to " + Beneficiary+"=" + NumberOfTransaction);
    }

    public void filteringBasedParticularRemarks(Transaction[] transactions) {
        Scanner scanner = new Scanner(System.in);
        String Remark;
        System.out.println("Enter Remarks");
        Remark = scanner.next();
        for (Transaction each : transactions) {
            if (each.getRemarks().equals(Remark)) {
                System.out.println(each.getAmountInTransaction() + " is the amount transferred to " + each.getToWhom() + " has Remark " + Remark);
            }
        }
    }

    public void sortBenificiary(Transaction[] transactions) {
        Transaction temporary = null;
        for (int index = 0; index < transactions.length - 1; index++) {
            int maximumIndex = index;
            String maximumString = transactions[index].getToWhom();
            for (int next = index + 1; next < transactions.length; next++) {
                if (transactions[next].getToWhom().compareTo(maximumString) > 0) {
                    maximumString = transactions[next].getToWhom();
                    maximumIndex = next;
                }
            }
            if (maximumIndex != index) {
                temporary = transactions[maximumIndex];
                transactions[maximumIndex] = transactions[index];
                transactions[index] = temporary;
            }
        }
    }

    public void sortAmount(Transaction[] transactions) {
        Transaction temporary = null;
        for (int index = 0; index < transactions.length - 1; index++) {
            int minimumIndex = index;
            int minimumAmount = transactions[index].getAmountInTransaction();
            for (int next = index + 1; next < transactions.length; next++) {
                if (transactions[next].getAmountInTransaction() < minimumAmount) {
                    minimumAmount = transactions[next].getAmountInTransaction();
                    minimumIndex = next;
                }
            }
            if (minimumIndex != index) {
                temporary = transactions[minimumIndex];
                transactions[minimumIndex] = transactions[index];
                transactions[index] = temporary;
            }
        }
    }
}
