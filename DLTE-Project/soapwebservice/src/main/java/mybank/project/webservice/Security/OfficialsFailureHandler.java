package mybank.project.webservice.Security;

import mybank.project.loansdao.Security.MyBankOfficials;
import mybank.project.loansdao.Security.MyBankOfficialsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OfficialsFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    MyBankOfficialsService service;

    Logger logger= LoggerFactory.getLogger(OfficialsFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException, IOException, ServletException {
        String username = request.getParameter("username");
        MyBankOfficials myBankOfficials = service.findByUsername(username);
        if(myBankOfficials!=null){
            if(myBankOfficials.getCustomerStatus().equalsIgnoreCase("Active")){
                if(myBankOfficials.getAttempts()< myBankOfficials.getMaxAttempt()){
                    myBankOfficials.setAttempts(myBankOfficials.getAttempts()+1);
                    service.updateAttempts(myBankOfficials);
                    logger.warn("Invalid credentials and attempts taken");
                    exception=new LockedException("Attempts are taken");
                }
                else{
                    service.updateStatus(myBankOfficials);
                    logger.warn("Max Attempts reached account is suspended");
                    exception=new LockedException("Max Attempts reached account is suspended");
                }
            }
            else{
                logger.warn("Account suspended contact admin to redeem");
            }
        }
        super.setDefaultFailureUrl("/login?error=true");
        super.onAuthenticationFailure(request, response, exception);
    }
}
