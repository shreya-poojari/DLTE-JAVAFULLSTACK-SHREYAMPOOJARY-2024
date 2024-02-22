package basics.services;
import java.util.Arrays;
import java.util.Date;

public class transaction {

    private Double transactionAmount;
    private String transactionTo;
    private Date TransactionDate;
    private String remarks="";

    @Override
    public String toString() {
        return "transaction{" +
                "transactionAmount=" + transactionAmount +
                ", transactionTo='" + transactionTo + '\'' +
                ", TransactionDate=" + TransactionDate +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionTo() {
        return transactionTo;
    }

    public void setTransactionTo(String transactionTo) {
        this.transactionTo = transactionTo;
    }

    public Date getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        TransactionDate = transactionDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public transaction(Double transactionAmount, String transactionTo, Date transactionDate, String remarks) {
        this.transactionAmount = transactionAmount;
        this.transactionTo = transactionTo;
        TransactionDate = transactionDate;
        this.remarks = remarks;
    }
}
