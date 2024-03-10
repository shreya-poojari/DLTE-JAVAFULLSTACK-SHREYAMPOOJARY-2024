package org.example;

import java.io.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass implements MyBank{
    ArrayList<Loan> loanInfo=new ArrayList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MainClass mainClass=new MainClass();

        while (true){
            System.out.println("Enter your choice\n1.Add loan\n2.List available loan\n3.List closed loan\n4.exit");
            Scanner scanner=new Scanner(System.in);
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("thanks for choosing MyBank\n provide following detail to create new account");
                    System.out.println("enter the loan amount");
                    Double amount=scanner.nextDouble();
                    System.out.println("enter the contact number");
                    Long contact=scanner.nextLong();
                    System.out.println("enter loan date");
                    String date=scanner.next();
                    System.out.println("enter the loan number");
                    Long loanNumber=scanner.nextLong();
                    System.out.println("enter borrowerName");
                    String borrowerName=scanner.next();
                    System.out.println(" enter status(open/closed)");
                    String status= scanner.next();
                    mainClass.addLoan(new Loan(loanNumber,amount,date,status,borrowerName,contact));
                    break;
                case 2:
                    mainClass.checkAvailableLoans();
                    break;
                case 3:
                    mainClass.getCheckClosedLoan();
                    break;
                case 4:
                    System.out.println("Thankyou for choosing MyBank\nExiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice\ntry again");

            }
        }

    }

    @Override
    public void addLoan(Loan loan) throws ClassNotFoundException, IOException {
        loanInfo.add(loan);
        System.out.println("loan added successfully");
    }

    @Override
    public void getCheckClosedLoan() throws IOException, ClassNotFoundException {
        System.out.println("closed loan");
        for (Loan each:loanInfo){
            if (each.getLoanStatus().equals("close")){
                System.out.println(each);
            }
        }
    }

    @Override
    public void checkAvailableLoans() throws IOException, ClassNotFoundException {
        System.out.println("availabe loan");
        for (Loan each:loanInfo){
            if (each.getLoanStatus().equals("open")){
                System.out.println(each);
            }
        }
    }
}
