package spring.jpa.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.jpa.demo.model.AccountDetails;
import spring.jpa.demo.services.Services;

import javax.xml.ws.Service;
import java.util.List;

@RestController
@RequestMapping("/account")
public class Account {
    @Autowired
    Services services;
    @PostMapping(value = "/")
    public AccountDetails apiSave(@RequestBody AccountDetails accountDetails){
        return services.callSave(accountDetails);
    }

    @PutMapping(value="/update",consumes = "application/json")
    public AccountDetails apiUpdate(@RequestBody AccountDetails accountDetails){
        return services.callSave(accountDetails);
    }

    @GetMapping(value = "/find")
    public List<AccountDetails> apiCallAll(){
        return services.callAll();
    }
}
