package basics.service;

import java.util.Date;

public class loan {
    private Integer loanNumber;
    private Double loanAmount;
    private String Date;
    private String loanStatus;
    private String borrowerName;
    private Long phoneNumber;

    public loan(Integer loanNumber, Double loanAmount, String date, String loanStatus, String borrowerName, Long phoneNumber) {
        this.loanNumber = loanNumber;
        this.loanAmount = loanAmount;
        Date = date;
        this.loanStatus = loanStatus;
        this.borrowerName = borrowerName;
        this.phoneNumber = phoneNumber;
    }

    public loan() {
    }

    @Override
    public String toString() {
        return "loan{" +
                "loanNumber=" + loanNumber +
                ", loanAmount=" + loanAmount +
                ", Date='" + Date + '\'' +
                ", loanStatus='" + loanStatus + '\'' +
                ", borrowerName='" + borrowerName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public Integer getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(Integer loanNumber) {
        this.loanNumber = loanNumber;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
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

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}