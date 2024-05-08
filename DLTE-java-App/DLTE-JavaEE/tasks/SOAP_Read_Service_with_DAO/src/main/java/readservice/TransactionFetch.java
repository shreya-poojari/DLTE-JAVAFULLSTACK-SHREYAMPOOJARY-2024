package readservice;

import org.example.Entity.Transactions;

import java.util.List;
public class TransactionFetch {
    private List<Transactions> transactionsList;

    public List<Transactions> getTransactionsList() {

        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }

    @Override
    public String toString() {
        return "GroupOfTransactions{" +
                "transactionsList=" + transactionsList +
                '}';
    }
}
