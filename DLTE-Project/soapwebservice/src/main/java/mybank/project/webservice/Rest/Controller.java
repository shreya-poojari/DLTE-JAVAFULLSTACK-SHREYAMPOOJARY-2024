package mybank.project.webservice.Rest;

import mybank.project.loansdao.Entity.LoansAvailable;
import mybank.project.loansdao.Exception.NoLoanData;
import mybank.project.loansdao.Exception.NoLoanException;
import mybank.project.loansdao.Interface.LoanInterface;
import mybank.project.loansdao.Service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ResourceBundle;


@RestController
@RequestMapping("/loans")
public class Controller {
    @Autowired
    private LoanInterface interfaceServices;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("application");// Loading resource bundle
    Logger logger = LoggerFactory.getLogger(LoanService.class);// Initializing logger
//    @GetMapping("/loans/{loanType}")
//    public List<LoansAvailable> findByLoanType(@PathVariable String loanType, HttpServletResponse response) throws LoanServiceException {
//        try {
//            List<LoansAvailable> loans = loanService.findByLoanType(loanType);
//            if (loans.isEmpty()) {
//                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//                logger.warn(resourceBundle.getString("no.loan.type"), loanType);
//                throw new NoLoanDataException(resourceBundle.getString("no.loan.type") + loanType);
//            }
//            return loans;
//        } catch (NoLoanDataException e) {
//            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//            logger.error(resourceBundle.getString("no.loan.type"), loanType, e);
//            throw e;
//        } catch (DataAccessException e) {
//            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            logger.error(resourceBundle.getString("loan.server.error"), e);
//            throw new LoanServiceException(resourceBundle.getString("loan.server.error"));
//        }
//    }

//    @GetMapping("/findByLoanType")
//    public ResponseEntity<List<LoansAvailable>> findByLoanType(@PathVariable String loanType) {
//        try {
//            List<LoansAvailable> loans = interfaceServices.findByLoanType(loanType);
//            return new ResponseEntity<>(loans, HttpStatus.OK);
//        } catch (NoLoanData e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } catch (NoLoanException e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/{loanType}")
    public ResponseEntity<Object> findByLoanType(@PathVariable String loanType, HttpServletResponse response) {
        try {
            List<LoansAvailable> loans = interfaceServices.findByLoanType(loanType);
            if (loans.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(loans);
            }
        } catch (NoLoanData e) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);//204 no content
            logger.error(resourceBundle.getString("no.loanType"), e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (NoLoanException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);//500 no content
            logger.error(resourceBundle.getString("db.error"), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}