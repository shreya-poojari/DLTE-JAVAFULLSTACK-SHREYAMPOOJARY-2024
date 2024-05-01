package mybank.project.webservice.security;

import mybank.project.loansdao.entity.MyBankCustomers;
import mybank.project.loansdao.service.MyBankCustomersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;
@CrossOrigin(origins = "*")
@Component
public class CustomersSuccesshandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    MyBankCustomersService myBankCustomersService;
    Logger logger= LoggerFactory.getLogger(CustomersFailureHandler.class);
    ResourceBundle resourceBundle= ResourceBundle.getBundle("webservice");
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        try {
            MyBankCustomers myBankCustomers = (MyBankCustomers) authentication.getPrincipal();
            if (!myBankCustomers.getCustomerStatus().equals("Inactive")) {
                if (myBankCustomers.getAttempts() > 1) {
                    myBankCustomers.setAttempts(1);
                    myBankCustomersService.updateAttempts(myBankCustomers);
                }
                //super.setDefaultTargetUrl("/loansrepo/loans.wsdl");
                super.setDefaultTargetUrl("/mybank/dashboard");
            } else {
                logger.warn(resourceBundle.getString("account.redeem"));
                super.setDefaultTargetUrl("/mybank/weblogin/");
            }
        }catch (UsernameNotFoundException e){
            logger.info(resourceBundle.getString("no.user"));
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
