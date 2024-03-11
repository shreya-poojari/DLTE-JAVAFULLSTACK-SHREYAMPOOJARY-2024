package org.example;
import  java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;

public class Loan {
    private Long loannumber;
    private Double loanAmount;
    private String  loanDate;
    private String loanStatus;
    private String borrowerName;
    private Long borrowerContact;

    public Loan(Long loannumber, Double loanAmount, String  loanDate, String loanStatus, String borrowerName, Long borrowerContact) {
        this.loannumber = loannumber;
        this.loanAmount = loanAmount;
        this.loanDate = loanDate;
        this.loanStatus = loanStatus;
        this.borrowerName = borrowerName;
        this.borrowerContact = borrowerContact;
    }

    public Loan() {
    }

    public static void add(Loan loan) {
    }

    public Long getLoannumber() {
        return loannumber;
    }

    public void setLoannumber(Long loannumber) {
        this.loannumber = loannumber;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String  loanDate) {
        this.loanDate = loanDate;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public Long getBorrowerContact() {
        return borrowerContact;
    }

    public void setBorrowerContact(Long borrowerContact) {
        this.borrowerContact = borrowerContact;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loannumber=" + loannumber +
                ", loanAmount=" + loanAmount +
                ", loanDate='" + loanDate + '\'' +
                ", loanStatus='" + loanStatus + '\'' +
                ", borrowerName='" + borrowerName + '\'' +
                ", borrowerContact=" + borrowerContact +
                '}';
    }
}
