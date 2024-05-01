package mybank.project.webservice.mvc;

import mybank.project.loansdao.interfaces.LoanInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/mybank")
public class WebController {
    @Autowired
    LoanInterface loanInterface;

    @GetMapping("/weblogin/")
    public String landing(){
        return "index";
    }
    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}

