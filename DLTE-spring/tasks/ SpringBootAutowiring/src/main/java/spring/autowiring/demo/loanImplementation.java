package spring.autowiring.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("loanImplementation")
public class loanImplementation implements LoanService{
    @Override
    public List<Loan> findALL(){
        List<Loan> newList=new ArrayList<>();
        for (Loan each:loansList){
            if (each.getLoanType().equals("personal")){
                newList.add(each);
            }

        }
        return newList;
    }
}
