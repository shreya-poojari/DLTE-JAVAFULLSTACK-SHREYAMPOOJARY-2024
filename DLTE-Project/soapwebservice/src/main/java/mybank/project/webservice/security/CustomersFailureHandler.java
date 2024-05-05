package mybank.project.webservice.security;

import mybank.project.loansdao.entity.MyBankCustomers;
import mybank.project.loansdao.service.MyBankCustomersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@CrossOrigin(origins = "*")
@Component
public class CustomersFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    MyBankCustomersService myBankCustomersService;
    Logger logger= LoggerFactory.getLogger(CustomersFailureHandler.class);
    ResourceBundle resourceBundle= ResourceBundle.getBundle("webservice");
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String username = request.getParameter("username");
        try{
            MyBankCustomers myBankCustomers = myBankCustomersService.findByUsername(username);
            if(myBankCustomers!=null){
                if(!myBankCustomers.getCustomerStatus().equals("Inactive")){
                    if(myBankCustomers.getAttempts()< myBankCustomers.getMaxAttempt()){
                        myBankCustomers.setAttempts(myBankCustomers.getAttempts()+1);
                        myBankCustomersService.updateAttempts(myBankCustomers);
                        logger.warn(resourceBundle.getString("credentials.invalid"));
                        exception=new LockedException((4-myBankCustomers.getAttempts()) + " " +resourceBundle.getString("attempts.taken"));
                        String err = myBankCustomers.getAttempts() + " " + exception.getMessage();
                        logger.warn(err);
                        setDefaultFailureUrl("/mybank/weblogin/?error=" + exception.getMessage());
                    }
                    else{
                        myBankCustomersService.updateStatus(myBankCustomers);
                        logger.warn(resourceBundle.getString("attempts.suspend"));
                        exception=new LockedException(resourceBundle.getString("attempts.suspend"));
                        setDefaultFailureUrl("/mybank/weblogin/?error=" + exception.getMessage());
                    }
                }
            }else{
                logger.warn(resourceBundle.getString("account.suspend"));
                exception = new LockedException("no account");
                super.setDefaultFailureUrl("/mybank/weblogin/?error=" + exception.getMessage());
            }
        }catch (UsernameNotFoundException e){
            logger.warn(resourceBundle.getString("account.suspend"));
            exception = new LockedException(resourceBundle.getString("incorrect.username"));
            super.setDefaultFailureUrl("/mybank/weblogin/?error=" + exception.getMessage());
        }
        super.onAuthenticationFailure(request, response, exception);
    }
}