package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestLoan implements MyBank {
    ArrayList<Loan> loans=loan;

    @Override
    public void writeIntoFile() throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream("LoanDB.doc");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(loans);
        fileOutputStream.close();
        objectOutputStream.close();
    }

    @Override
    public void readFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream=new FileInputStream("LoanDB.doc");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        loans= (ArrayList<Loan>) objectInputStream.readObject();

    }

    @Override
    public void addNewLoan(Loan loan) throws IOException, ClassNotFoundException {
        try{
            readFromFile();
        }catch (IOException|ClassNotFoundException Exception){
            System.out.println(Exception);
        }
        loans.add(loan);
        try{
            writeIntoFile();
        }catch (IOException Exception){
            System.out.println(Exception);
        }
    }

    @Override
    public void checkAvailability() throws IOException, ClassNotFoundException {
        try{
            readFromFile();
        }catch (IOException|ClassNotFoundException Exception){
            System.out.println(Exception);
        }
        List<Loan> avail=loans.stream().filter(each->each.getLoanStatus().equals("open")).collect(Collectors.toList());
        avail.forEach(Loan->{
            System.out.println(Loan.toString());
        });
    }

    @Override
    public void checkClosedLoan() throws IOException, ClassNotFoundException {
        try{
            readFromFile();
        }catch (IOException|ClassNotFoundException Exception){
            System.out.println(Exception);
        }
        List<Loan> notAvail=loans.stream().filter(each->each.getLoanStatus().equals("close")).collect(Collectors.toList());
        notAvail.forEach(Loan->{
            System.out.println(Loan.toString());
        });
    }
    public Loan getInputData(){
        System.out.println("Enter your data");
        Scanner scanner=new Scanner(System.in);
        long loanNumber;
        System.out.println("Enter loan number");
        loanNumber=scanner.nextLong();
        long loanAmount;
        System.out.println("Enter loan Amount");
        loanAmount=scanner.nextInt();
        Date loanDate=new Date();
        String loanStatus;
        System.out.println("Loan status");
        loanStatus=scanner.next();
        String borrowerName;
        System.out.println("enter borrower name");
        borrowerName=scanner.next();
        Long borrowerContact;
        System.out.println("Enter borrower contact");
        borrowerContact=scanner.nextLong();
        return new Loan(loanNumber,loanAmount,loanDate,loanStatus,borrowerName,borrowerContact);
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestLoan customers=new TestLoan();
        Loan loan1=new Loan(8765432123L,9876L,new Date(2024,05,25),"open","shreya",9876543212L);
        Loan loan2=new Loan(4569871253L,3456L,new Date(2024,07,12),"close","snehal",1354785698L);
        Loan loan3=new Loan(9514236578L,5236L,new Date(2024,02,9),"open","kavya",8564751236L);
    loan.addAll(Stream.of(loan1,loan2,loan3).collect(Collectors.toList()));
    try{
        customers.writeIntoFile();
    }catch (IOException Exception){
        System.out.println(Exception);
    }
    int choice=0;
    Scanner scanner=new Scanner(System.in);
    while (true){
        System.out.println("WELCOME");
        System.out.println("choose any of the following");
        System.out.println("1.Add loan details\n2.check available loan\n3.check closed loan");
        choice=scanner.nextInt();
        switch (choice){
            case 1:
                customers.addNewLoan(customers.getInputData());
                break;
            case 2:
                customers.checkAvailability();
                break;
            case 3:
                customers.checkClosedLoan();
                break;
        }

    }
    }
}
