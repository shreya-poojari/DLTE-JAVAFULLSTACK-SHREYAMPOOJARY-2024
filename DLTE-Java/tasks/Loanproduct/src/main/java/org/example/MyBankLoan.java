package org.example;

import java.util.Date;
import java.util.Scanner;

public class MyBankLoan implements MyBank {
    private static int numberOfLoans;
    public static void main(String[] args){
        MyBank mybank=new MyBankLoan();

        Scanner scanner= new Scanner(System.in);
        int choice;
        while (true){
            System.out.println("-------welcome---------");
            System.out.println("--------MENU-----------");
            System.out.println("1. add a new loan\n2.check available loans\n3.check closed loans\n4.exit");
            System.out.println("Enter your choice");
            choice = scanner.nextInt();
            switch (choice){
                case 1:

                    System.out.println("enter number of loans");
                    numberOfLoans= scanner.nextInt();
                    mybank.addNewLoan();

//                    Loan[] loans=new Loan[numberOfLoans];
//                    for (int loan=0;loan<numberOfLoans;loan++){
//                        MyBankLoan.addNewLoan();
//                    }
//                    break;
                case 2:
                    mybank.checkAvailableLoans();
                    break;
                case 3:
                    mybank.checkClosedLoans();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    @Override
    public Loan addNewLoan() {
        Loan loan=new Loan();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the Loan Number");
        loan.setLoanNumber(scanner.nextLong());
        System.out.println("Enter the Loan Amount");
        loan.setLoanAmount(scanner.nextDouble());
        System.out.println("Enter the Loan Date");
        loan.setLoanDate(new Date(scanner.next()));
        scanner.nextLine();
        System.out.println("enter the Loan Status (Closed/Open)");
        loan.setLoanStatus(scanner.nextLine());
        System.out.println("Enter the borrowerName");
        loan.setBorrowerName(scanner.nextLine());
        System.out.println("Enter the borrowerContact");
        loan.setBorrowerContact(scanner.nextLong());
        return loan;
    }

    @Override
    public void checkAvailableLoans() {
     for(Loan loan: loans ){
         if (loan.getLoanStatus().equalsIgnoreCase("open")){
             System.out.println(loan);
         }
     }
    }

    @Override
    public void checkClosedLoans() {
        for (Loan loan: loans){
            if (loan.getLoanStatus().equalsIgnoreCase("closed")){
                System.out.println(loan);
            }
        }
    }
}
