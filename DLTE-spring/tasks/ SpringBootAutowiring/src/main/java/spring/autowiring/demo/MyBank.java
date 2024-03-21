package spring.autowiring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBank {
    @Autowired
    @Qualifier("loanImplementation")
    private LoanService loanService;
    public List<Loan> callFindAll(){
        List<Loan> injectedLoan=loanService.findALL();
        return injectedLoan;
    }

}
