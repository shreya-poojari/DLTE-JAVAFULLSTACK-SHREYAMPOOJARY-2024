package mybank.project.loansdao;

import mybank.project.loansdao.entity.LoansAvailable;
import mybank.project.loansdao.interfaces.LoanInterface;
import mybank.project.loansdao.service.LoanService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class LoansdaoApplication {

    public static void main(String[] args) throws SQLException {

      //  SpringApplication.run(LoansdaoApplication.class, args);

    //    loanService.findByLoanType("Personal");
        ConfigurableApplicationContext context = SpringApplication.run(LoansdaoApplication.class, args);
//        LoanService loanServices = context.getBean(LoanService.class);
//
//        System.out.println(loanServices.findByLoanType("Personal"));
        //List<LoansAvailable> check = loanServices.allAvailableLoan();
        //LoanAvailed loan = new LoanAvailed(101, 121L, 5000L, 3.5, 6);
       //String info = loanServices.createNewLoan(loan);
       // System.out.println(info);
       // System.out.println(check);
    }

}
