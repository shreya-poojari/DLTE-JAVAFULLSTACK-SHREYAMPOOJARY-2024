package org.example;

import java.util.Date;

public interface MyBank {
    Loan loans[]={
            new Loan(25645236975412L, 87098.00,new Date(2024, 05,25),"closed","Divya",9842687523L),
            new Loan(75123654789652L, 84236.00,new Date(2024, 04,5),"open","Ramya",5123647852L),
            new Loan(45213654789621L, 74315.00,new Date(2024, 03,15),"open","bhavya",7623485975L),
            new Loan(42533145625894L, 75123.00,new Date(2024, 02,20),"closed","suma",9754123654L),
    };




  public Loan addNewLoan();

    public void checkAvailableLoans();
    public void checkClosedLoans();
}
