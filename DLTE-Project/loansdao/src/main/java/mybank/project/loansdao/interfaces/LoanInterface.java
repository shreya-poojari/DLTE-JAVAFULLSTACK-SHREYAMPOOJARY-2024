package mybank.project.loansdao.interfaces;

import mybank.project.loansdao.entity.LoansAvailable;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface LoanInterface {
    public List<LoansAvailable> allAvailableLoans();
    public List<LoansAvailable> findByLoanType(String loanType);
}
