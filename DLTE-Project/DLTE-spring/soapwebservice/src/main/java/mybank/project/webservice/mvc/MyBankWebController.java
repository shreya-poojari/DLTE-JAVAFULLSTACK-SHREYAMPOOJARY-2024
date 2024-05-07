package mybank.project.webservice.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/web")
public class MyBankWebController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String myDashboard(){
        return "index";
    }
    @RequestMapping(value = "/viewLoans",method = RequestMethod.GET)
    public String viewLoans(){
        return "viewLoans.html";
    }
    @RequestMapping(value = "/viewByLoanType",method = RequestMethod.GET)
    public String viewByLoanType(){
        return "viewByLoanType.html";
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout() {
        return "index";
    }
}
