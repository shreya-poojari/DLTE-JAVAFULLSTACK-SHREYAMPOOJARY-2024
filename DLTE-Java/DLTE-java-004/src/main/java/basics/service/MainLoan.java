package basics.service;

import java.util.Scanner;

public class MainLoan implements MyBank {
    static int totalLoan;
    loan Loan[] = new loan[10];

    public static void main(String[] args) {
        MainLoan mainloan = new MainLoan();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Add loans\n2.CheckLoans\n3.check closed Loans");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("enter the number of loans");
                    totalLoan = scanner.nextInt();
                    mainloan.addNewLoan();
                    break;
                case 2:
                    mainloan.CheckAvailableLoans();
                    break;
                case 3:
                    mainloan.CheckOnlyClosedLoans();
                    break;
                default:
                    scanner.close();
                    System.exit(0);

            }
        }
    }

    @Override
    public void addNewLoan() {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        for (int index = 0; index < totalLoan; index++) {
            System.out.println("Enter the LoanNumber");
            int loanNumber = scanner.nextInt();
            System.out.println("Enter the loanAmount");
            double loanAmount = scanner.nextDouble();
            System.out.println("enter the loan status(open/closed)");
            String loanStatus = scanner1.next();
            System.out.println("enter the phone number");
            long phonenumber = scanner.nextLong();
            System.out.println("enter the name");
            String borrowerName = scanner1.next();
            System.out.println("enter the loan date");
            String date = scanner1.next();
            Loan[index] = new loan(loanNumber, loanAmount, date, loanStatus, borrowerName, phonenumber);
        }

   }

    @Override
    public void CheckAvailableLoans() {
        for (int index = 0; index < totalLoan; index++) {
            if (Loan[index] != null) {
                if (Loan[index].getLoanStatus().equalsIgnoreCase("open"))
                    System.out.println(Loan[index].toString());
            }
        }
    }

    @Override
    public void CheckOnlyClosedLoans() {
        for (int index = 0; index < totalLoan; index++) {
            if (Loan[index] != null) {
                if (Loan[index].getLoanStatus().equalsIgnoreCase("closed"))
                    System.out.println(Loan[index].toString());
            }
        }
    }

}



