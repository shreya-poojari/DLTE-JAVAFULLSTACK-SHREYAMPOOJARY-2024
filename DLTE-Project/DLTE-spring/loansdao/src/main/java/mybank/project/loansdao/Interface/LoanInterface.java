package mybank.project.loansdao.Interface;

import mybank.project.loansdao.Entity.LoansAvailable;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface LoanInterface {
    public List<LoansAvailable> allAvailableLoans();
    public List<LoansAvailable> findByLoanType(String loanType);
}
