package org.example;

import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AppTest
{
    static ArrayList<Loan> loans=new ArrayList<>();

    @Test
    public void testAddLoan() throws IOException, ClassNotFoundException {
        MainClass mainClass=new MainClass();

        Loan loan=new Loan(145236987456L,99999.00,"2024,07,8","open","shreya",8867146434L);
        mainClass.addLoan(loan);
        assertEquals("shreya",mainClass.loanInfo.get(0).getBorrowerName());
    }
    @Test
    public void testAvailability() throws IOException, ClassNotFoundException {
        MainClass mainClass=new MainClass();
        Loan loan=new Loan(145236987456L,99999.00,"2024,07,8","open","shreya",8867146434L);
        mainClass.addLoan(loan);
        mainClass.checkAvailableLoans();
        assertEquals("open",mainClass.loanInfo.get(0).getLoanStatus());
    }

    @Test
    public void testClosedLoan() throws IOException, ClassNotFoundException {
        MainClass mainClass=new MainClass();
        Loan loan=new Loan(456987412589L,99999.00,"2024,07,8","open","shreya",8867146434L);
        Loan loan1=new Loan(125478523698L,28765.00,"2024,04,2","close","snehal",97974984L);
        mainClass.addLoan(loan);
        mainClass.addLoan(loan1);
        mainClass.checkAvailableLoans();
        mainClass.getCheckClosedLoan();
        assertNotEquals("close",mainClass.loanInfo.get(0).getLoanStatus());
        assertEquals("close",mainClass.loanInfo.get(1).getLoanStatus());
    }
}