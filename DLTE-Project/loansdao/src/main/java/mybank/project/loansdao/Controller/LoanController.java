//package mybank.project.loansdao.Controller;
//
//import mybank.project.loansdao.Entity.LoansAvailable;
//import mybank.project.loansdao.Service.LoanService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//@RestController
//@RequestMapping("/loan")
//public class LoanController {
//
//    @Autowired
//    private LoanService loanService;
//
//    @GetMapping("/all")
//    public List<LoansAvailable> findBySender() {
//        List<LoansAvailable> loans=loanService.allAvailableLoans();
//        System.out.println(loans.toString());
//        return loans;
//
//    }
//}
