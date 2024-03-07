package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransactionAnalysis {
    static ArrayList<Transaction> TransactionList =new ArrayList<>();

    public static void main( String[] args ){
        TransactionAnalysis Analysis=new TransactionAnalysis();
        Transaction transaction1=new Transaction(new Date("25/5/2024"),656,"shreya","family");
        Transaction transaction2=new Transaction(new Date("3/4/2024"),987,"shravya","friend");
        Transaction transaction3=new Transaction(new Date("12/8/2024"),765,"shravan","food");
        Transaction transaction4=new Transaction(new Date("19/7/2024"),543,"savani","Education");
        TransactionList = (ArrayList<Transaction>) Stream.of(transaction1,transaction2,transaction3,transaction4).collect(Collectors.toList());
        int choice;
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("TRANSACTION_ANALYSIS");
            System.out.println("chooose 1 for Least amount transaction\nchoose 2 for maximum amount transaction\nchoose 3 forfiltering based on remark\nchoose 4 sort descending based on benificiary\n");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    leastAmountTransferred();
                    break;
                case 2:
                    maximumAmounttransferred();
                    break;
                case 3:
                    System.out.println("Enter the start date");
                    Date startDate=new Date(scanner.next());
                    System.out.println("Enter the end date");
                    Date endDate=new Date(scanner.next());
                    rangeOfDate(startDate,endDate);
                    break;
                case 4:
                    System.out.println("property->date,remark,amount\n order-ascending,descending");
                    System.out.println("to sort based on choice enter property:order");
                    String propertyOrder=scanner.next();
                    TransactionComparator compare=new TransactionComparator(propertyOrder);
                    Collections.sort(TransactionList,compare);
                    TransactionList.forEach(System.out::println);
                    break;
            }
        }
    }
    public static void leastAmountTransferred(){
        Transaction leastTransaction = TransactionList.stream().min(Comparator.comparingDouble(Transaction::getAmountInTransaction)).orElse(null);
        System.out.println("Least amount transferred = "+leastTransaction.getAmountInTransaction());
    }
    public static void maximumAmounttransferred(){
        Transaction leastTransaction = TransactionList.stream().max(Comparator.comparingDouble(Transaction::getAmountInTransaction)).orElse(null);
        System.out.println("Maximum amount transferred = "+leastTransaction.getAmountInTransaction());
    }
    public static void rangeOfDate(Date start,Date end ){
        Transaction leastTransaction = TransactionList.stream().max(Comparator.comparingDouble(Transaction::getAmountInTransaction)).orElse(null);
        System.out.println("Maximum amount transferred ="+leastTransaction.getAmountInTransaction());
        List<Transaction> rangeByDateList = TransactionList.stream().filter(each->each.getDateOfTransaction().after(start)&&each.getDateOfTransaction().before(end)).collect(Collectors.toList());
        rangeByDateList.forEach(Transaction->{
            System.out.println(Transaction.toString());
        });
    }
}
