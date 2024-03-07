package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class LoanProduct {
    public static void main( String[] args ){
        List<Loan> loanList=new ArrayList<>();
        loanList.add(new Loan(1,23456.00,"2024-05-23","open","Shreya",8978654321L));
        loanList.add(new Loan(2,67876.00,"2024-12-25","closed","Divya",9876543212L));
        MyBank myBank=(loan, startDate, endDate) -> {
            List<Loan> filteredLoans = new ArrayList<>();
            Predicate<Loan> dateRangeFilter = loan
        };
    }
}
