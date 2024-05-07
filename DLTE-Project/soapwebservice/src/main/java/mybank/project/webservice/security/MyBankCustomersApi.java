
package mybank.project.webservice.security;

import mybank.project.loansdao.entity.MyBankCustomers;
import mybank.project.loansdao.service.MyBankCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class MyBankCustomersApi {
    @Autowired
    MyBankCustomersService service;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public MyBankCustomers save(@RequestBody MyBankCustomers myBankCustomers){
        myBankCustomers.setPassword(passwordEncoder.encode(myBankCustomers.getPassword()));
        return service.signingUp(myBankCustomers);
    }
}
