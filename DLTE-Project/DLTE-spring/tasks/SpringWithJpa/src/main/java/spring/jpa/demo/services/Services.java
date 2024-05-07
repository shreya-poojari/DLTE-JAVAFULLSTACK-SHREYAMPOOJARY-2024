package spring.jpa.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.jpa.demo.model.AccountDetails;
import spring.jpa.demo.remotes.AccountRepo;

import java.util.List;

@Service
public class Services {
    @Autowired
    AccountRepo accountRepository;
    public AccountDetails callSave(AccountDetails account){
        return accountRepository.save(account);
    }
    public List<AccountDetails> callAll(){
        return (List<AccountDetails>) accountRepository.findAll();
    }
}
