package soap.webservice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Service;
import soap.webservice.demo.dao.Transactions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


@Service
public class TransactionService {
    @Autowired
    // private JdbcTemplate jdbcTemplate;
     private JdbcTemplate jdbcTemplate;
    // Method to insert a new transaction
    public Transactions newTransaction(Transactions transaction) {
        int acknowledge = jdbcTemplate.update("INSERT INTO transactions (transaction_id, transaction_date, transaction_to, transaction_amount, transaction_remarks, transaction_by) VALUES (?, ?, ?, ?, ?,?)",
                new Object[]{transaction.getTransactionId(), transaction.getTransactionDate(), transaction.getTransactionTo(), transaction.getTransactionAmount(), transaction.getTransactionRemarks(), transaction.getTransactionBy()});
        if (acknowledge != 0)
            return transaction;
        else
            return null; // Return null if insertion fails
    }

    // Method to find transactions by sender
    public List<Transactions> findBySender(String sender) {
        List<Transactions> transactions = jdbcTemplate.query("SELECT * FROM transactions WHERE transaction_by = ?", new Object[]{sender}, new TransactionMapper());
        return transactions;
    }

    // Method to find transactions by receiver
    public List<Transactions> findByReceiver(String receiver) {
        List<Transactions> transactions = jdbcTemplate.query("SELECT * FROM transactions WHERE transaction_to = ?", new Object[]{receiver}, new TransactionMapper());
        return transactions;
    }

    // Method to find transactions by amount
    public List<Transactions> findByAmount(double amount) {
        List<Transactions> transactions = jdbcTemplate.query("SELECT * FROM transactions WHERE transaction_amount = ?", new Object[]{amount}, new TransactionMapper());
        return transactions;
    }

    // Method to update remarks of a transaction
    public Transactions updateRemarks(Transactions transaction) {
        int acknowledge = jdbcTemplate.update("UPDATE transactions SET transaction_remarks = ? WHERE transaction_id = ?",
                new Object[]{transaction.getTransactionRemarks(), transaction.getTransactionId()});
        if (acknowledge != 0)
            return transaction;
        else
            return null; // Return null if update fails
    }

    // Method to remove transactions between given dates
    public String removeTransactionsBetweenDates(Date startDate,Date endDate){
        jdbcTemplate.update("delete from transactions where transaction_date between ? and ?",
                new Object[]{startDate,endDate});
        return "done";
    }

    protected class TransactionMapper implements RowMapper<Transactions> {
        @Override
        public Transactions mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Transactions transaction = new Transactions();
            transaction.setTransactionId(resultSet.getInt("transaction_id"));
            transaction.setTransactionDate(resultSet.getDate("transaction_date"));
            transaction.setTransactionTo(resultSet.getString("transaction_to"));
            transaction.setTransactionAmount(resultSet.getDouble("transaction_amount"));
            transaction.setTransactionRemarks(resultSet.getString("transaction_remarks"));
            transaction.setTransactionBy(resultSet.getString("transaction_by"));
            return transaction;
        }
    }
}
