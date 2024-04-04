package htmltry;

import java.util.Date;

public class Transaction {
    private Date dateOfTransaction;
    private double amountInTransaction;
    private String transTo;
    private String remarks;

    public Transaction(Date dateOfTransaction, double amountInTransaction, String to, String remarks) {
        this.dateOfTransaction = dateOfTransaction;
        this.amountInTransaction = amountInTransaction;
        this.transTo = to;
        this.remarks = remarks;
    }

    public Transaction() {
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "dateOfTransaction=" + dateOfTransaction +
                ", amountInTransaction=" + amountInTransaction +
                ", to='" + transTo + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public double getAmountInTransaction() {
        return amountInTransaction;
    }

    public void setAmountInTransaction(double amountInTransaction) {
        this.amountInTransaction = amountInTransaction;
    }

    public String getTo() {
        return transTo;
    }

    public void setTo(String to) {
        this.transTo = to;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
