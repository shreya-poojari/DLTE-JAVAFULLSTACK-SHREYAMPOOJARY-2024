package spring.sqlhql.demo.remotes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.sqlhql.demo.model.TransactionDetails;

import java.util.List;

public interface TransactionRepo extends JpaRepository<TransactionDetails,Integer> {
    //for sql(native) query
    @Query(value = "select * from transactions where user_name=:user and transaction_type=:type", nativeQuery = true)
    List<TransactionDetails> findByUserAndType(String user, String type);

    //for hql query
    @Query("from TransactionDetails where transactionAmount between :amount1 and :amount2")
    List<TransactionDetails> findByRangeOfTransactionAmount(double amount1, double amount2);

}