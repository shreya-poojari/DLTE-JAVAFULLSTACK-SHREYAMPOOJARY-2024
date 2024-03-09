package org.example;

import java.util.ArrayList;
import java.io.IOException;
import java.security.acl.LastOwnerException;
import java.io.FileNotFoundException;

public interface MyBank {
    ArrayList<Loan> loan=new ArrayList<>(20);
    void  writeIntoFile() throws IOException;
    void readFromFile() throws IOException, ClassNotFoundException;

    void addNewLoan(Loan loan) throws IOException, ClassNotFoundException;
    void checkAvailability() throws IOException, ClassNotFoundException;
    void checkClosedLoan() throws IOException, ClassNotFoundException;
}
