package org.example;

import java.io.IOException;

public interface MyBank {
    void checkAvailableLoans() throws IOException, ClassNotFoundException;
    void getCheckClosedLoan() throws IOException, ClassNotFoundException;
    void addLoan(Loan loanInfo) throws ClassNotFoundException, IOException;
}
