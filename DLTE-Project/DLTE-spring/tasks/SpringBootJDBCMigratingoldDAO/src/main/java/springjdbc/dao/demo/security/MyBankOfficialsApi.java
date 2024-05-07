package springjdbc.dao.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class MyBankOfficialsApi {
    @Autowired
    MyBankOfficialService myBankOfficialsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public MyBankOfficials save(@RequestBody MyBankOfficials myBankOfficials){
        myBankOfficials.setPassword(passwordEncoder.encode(myBankOfficials.getPassword()));
        return myBankOfficialsService.signingUp(myBankOfficials);
    }
}
