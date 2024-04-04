package mybank.project.webservice.Configs;

import mybank.project.loansdao.Entity.LoansAvailable;
import mybank.project.loansdao.Interface.LoanInterface;
import mybank.project.loansdao.Service.LoanService;
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ComponentScan("mybank.project.loansdao")
@Endpoint
public class SoapPhase {
    @Autowired
    public LoanInterface interfaceServices;
    @Autowired
    public static LoanService loanServices;

    private final String url="http://loansavail.services";

    @PayloadRoot(namespace = url,localPart = "viewAllAvailableLoanRequest")
    @ResponsePayload
    public ViewAllAvailableLoanResponse viewAvailLoanRequest(@RequestPayload ViewAllAvailableLoanRequest request){
        ViewAllAvailableLoanResponse response=new ViewAllAvailableLoanResponse();
        ServiceStatus serviceStatus=new ServiceStatus();

        List<LoansAvailable> allDaoLoans=interfaceServices.allAvailableLoans();

        List<services.loansavail.LoanAvailable> allLoans=new ArrayList<>();

        Iterator<LoansAvailable> iterator=allDaoLoans.iterator();
        while (iterator.hasNext()){
            services.loansavail.LoanAvailable currentLoan=new services.loansavail.LoanAvailable();
            BeanUtils.copyProperties(iterator.next(),currentLoan);
            allLoans.add(currentLoan);

        }
        serviceStatus.setStatus("success");
        serviceStatus.setMessage("fetched.loans");
        response.getLoanAvailable().addAll(allLoans);
        response.setServiceStatus(serviceStatus);

        return response;
    }

}
