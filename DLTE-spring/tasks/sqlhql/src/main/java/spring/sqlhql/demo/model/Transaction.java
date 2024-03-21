package spring.sqlhql.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Transaction")
public class Transaction implements Serializable {
    @Id
    private int transactionId;
    private String userName;
    @Temporal(TemporalType.DATE)
    private Date transactionDate;
    private String transactionType;
    private double transactionAmount;
    private double transactionBalance;

    public Transaction() {
    }

    public Transaction(int transactionId, String userName, Date transactionDate, String transactionType, double transactionAmount, double transactionBalance) {
        this.transactionId = transactionId;
        this.userName = userName;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionBalance = transactionBalance;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public double getTransactionBalance() {
        return transactionBalance;
    }

    public void setTransactionBalance(double transactionBalance) {
        this.transactionBalance = transactionBalance;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", userName='" + userName + '\'' +
                ", transactionDate=" + transactionDate +
                ", transactionType='" + transactionType + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", transactionBalance=" + transactionBalance +
                '}';
    }
}
