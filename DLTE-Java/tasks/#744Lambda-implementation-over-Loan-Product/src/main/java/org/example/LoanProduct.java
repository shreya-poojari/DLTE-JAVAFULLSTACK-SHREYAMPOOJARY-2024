package org.example;

import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.MyBank.loan;

public class LoanProduct {
        public static void main( String[] args ){
            org.example.LoanProduct customers=new org.example.LoanProduct();
            Loan loan1=new Loan(17654321234L,23456L,new Date(2024,05,6),"open","Shreya",8978654321L);
            Loan loan2=new Loan(29876543234L,67876L,new Date(2024,02,7),"closed","Divya",9876543212L);
            loan.addAll(Stream.of(loan1,loan2).collect(Collectors.toList()));
            MyBank filter=((startDate, endDate) -> {
                for (Loan each:loan){
                    if (each.getLoanDate().after(startDate) && each.getLoanDate().before(endDate)){

                        System.out.println(each);
                    }
                }
            });
            System.out.println("enter start date");
            Scanner scanner=new Scanner(System.in);
            Date start=new Date(scanner.next());
            System.out.println("enter end date");
            Date end=new Date(scanner.next());
            filter.filterDate(start,end);
        }

}

