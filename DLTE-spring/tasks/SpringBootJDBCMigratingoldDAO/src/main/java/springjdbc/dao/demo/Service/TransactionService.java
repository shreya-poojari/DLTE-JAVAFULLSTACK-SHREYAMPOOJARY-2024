package springjdbc.dao.demo.Service;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import springjdbc.dao.demo.Entity.Transactions;

import java.util.List;
@Service
public class TransactionService {
    private JdbcTemplate jdbcTemplate;
    public Transactions newTransaction(Transactions transactions){
        String sql = "INSERT INTO transaction (transaction_id, transaction_date, transaction_to, transaction_amount,transaction_remarks, transaction_by) VALUES (?, ?, ?, ?, ?,?)";
        jdbcTemplate.update(sql, transactions.getTransactionId(), transactions.getTransactionDate(), transactions.getTransactionTo(), transactions.getTransactionAmount(),transactions.getTransactionRemarks(), transactions.getTransactionBy());
        return transactions;
    }
    public List<Transactions> findBySender(String sender) {
        String sql = "SELECT * FROM transaction WHERE transaction_by = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Transactions.class), sender);
    }
    public List<Transactions> findByReceiver(String receiver) {
        String sql = "SELECT * FROM transaction WHERE transaction_to = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Transactions.class), receiver);
    }
    public List<Transactions> findByAmount(Long amount) {
        String sql = "SELECT * FROM transaction WHERE transaction_amount = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Transactions.class), amount);
    }
    public  List<Transactions> updateRemarks(Transactions transactions){
        jdbcTemplate.update("UPDATE transaction_entity SET remarks = ? WHERE transaction_id = ?",
                new Object[]{transactions.getTransactionRemarks(), transactions.getTransactionId()});
        return (List<Transactions>) transactions;
    }
}
