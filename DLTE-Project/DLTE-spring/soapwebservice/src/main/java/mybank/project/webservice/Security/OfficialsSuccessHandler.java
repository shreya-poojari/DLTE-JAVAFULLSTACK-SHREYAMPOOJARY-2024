//package mybank.project.webservice.Security;
//
//import mybank.project.loansdao.Security.MyBankOfficials;
//import mybank.project.loansdao.Security.MyBankOfficialsService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class OfficialsSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
//    @Autowired
//    MyBankOfficialsService service;
//
//    Logger logger= LoggerFactory.getLogger(OfficialsSuccessHandler.class);
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        MyBankOfficials myBankOfficials= (MyBankOfficials) authentication.getPrincipal();
//        if(!myBankOfficials.getCustomerStatus().equals("Inactive")){
//            if(myBankOfficials.getAttempts()>1){
//                myBankOfficials.setAttempts(1);
//                service.updateAttempts(myBankOfficials);
//            }
//            super.setDefaultTargetUrl("/loansrepo/loans.wsdl");
//        }
//        else{
//            logger.warn("Max attempts reached contact admin");
//            super.setDefaultTargetUrl("/login");
//        }
//        super.onAuthenticationSuccess(request, response, authentication);
//    }
//}
