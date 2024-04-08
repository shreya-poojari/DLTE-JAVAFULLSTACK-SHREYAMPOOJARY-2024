package mybank.project.webservice.Configs;

import mybank.project.loansdao.Entity.LoansAvailable;
import mybank.project.loansdao.Exception.NoLoanData;
import mybank.project.loansdao.Exception.NoLoanException;
import mybank.project.loansdao.Interface.LoanInterface;
import mybank.project.loansdao.Service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import services.loansavail.LoanAvailable;
import services.loansavail.ServiceStatus;
import services.loansavail.ViewAllAvailableLoanRequest;
import services.loansavail.ViewAllAvailableLoanResponse;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

@ComponentScan("mybank.project.loansdao")
@Endpoint
public class SoapPhase {
    // Injecting LoanInterface bean
    @Autowired
    public LoanInterface interfaceServices;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("application");// Loading resource bundle
    Logger logger= LoggerFactory.getLogger(LoanService.class);// Initializing logger


    private final String url="http://loansavail.services";// URL

    @PayloadRoot(namespace = url,localPart = "viewAllAvailableLoanRequest")
    @ResponsePayload
    public ViewAllAvailableLoanResponse viewAvailLoanRequest(@RequestPayload ViewAllAvailableLoanRequest request){
        ViewAllAvailableLoanResponse response=new ViewAllAvailableLoanResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
    try{
        List<LoansAvailable> allDaoLoans=interfaceServices.allAvailableLoans();// Fetching all available loans

        List<services.loansavail.LoanAvailable> allLoans=new ArrayList<>();
        allDaoLoans.forEach(each->{
        services.loansavail.LoanAvailable currentLoan=new services.loansavail.LoanAvailable();
        BeanUtils.copyProperties(each,currentLoan);
        allLoans.add(currentLoan);

    });
    // Setting success status and adding loans to response
        serviceStatus.setStatus(HttpServletResponse.SC_OK);
        response.getLoanAvailable().addAll(allLoans);
        logger.info(resourceBundle.getString("loan.server.available"));

    }catch (NoLoanException exception){
        serviceStatus.setStatus(HttpServletResponse.SC_NO_CONTENT);
        serviceStatus.setMessage(exception.toString());
        logger.info(resourceBundle.getString("loan.server.error"));
    }
    catch (NoLoanData exception){
        serviceStatus.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        serviceStatus.setMessage(exception.toString());
        logger.info(resourceBundle.getString("loan.server.error"));
    }
    response.setServiceStatus(serviceStatus);
    return response;

   }

}
