package mybank.project.webservice.rest;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import mybank.project.loansdao.entity.LoansAvailable;
import mybank.project.loansdao.exception.NoLoanData;
import mybank.project.loansdao.exception.NoLoanException;
import mybank.project.loansdao.interfaces.LoanInterface;
import mybank.project.loansdao.service.LoanService;
import mybank.project.loansdao.service.MyBankCustomersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/loans")
public class Controller {
    @Autowired
    MyBankCustomersService myBankCustomersService;
    @Autowired
    private LoanInterface interfaceServices;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("apps");// Loading resource bundle
    Logger logger = LoggerFactory.getLogger(LoanService.class);// Initializing logger

    @GetMapping("/{loanType}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "There are no loans available for the selected loan type."),
            @ApiResponse(responseCode = "500", description = "Internal server error."),
            @ApiResponse(responseCode = "200", description = "loans are fetched"),
            @ApiResponse(responseCode = "404", description = "no loans found")
    })
    public ResponseEntity<Object> findByLoanType(@PathVariable String loanType, HttpServletResponse response) throws SQLException{
        try {
            loanType = loanType.toLowerCase();
            if (!isValidLoanType(loanType)) {
                return ResponseEntity.badRequest().body(resourceBundle.getString("enter.proper.loantype"));
            }
            List<LoansAvailable> loans = interfaceServices.findByLoanType(loanType);
            if (loanType == null || loans.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(resourceBundle.getString("no.loanType"));// If the list of loans is empty 404 Not Found
            } else {
                response.setStatus(HttpServletResponse.SC_OK);
                logger.info(resourceBundle.getString("loan.server.available"));
                return ResponseEntity.ok(loans); // If loans found 200 OK
            }
        } catch (NoLoanData e) {
            logger.error(resourceBundle.getString("error.one")+resourceBundle.getString("no.loanType"), e);
            return ResponseEntity.status(HttpStatus.OK).body(resourceBundle.getString("error.one")+e.getMessage());//for no loan data found 404 Not Found
        } catch (NoLoanException e) {
            logger.error(resourceBundle.getString("error.two")+resourceBundle.getString("error.loanType"), e);
            return ResponseEntity.status(HttpStatus.OK).body(resourceBundle.getString("error.two")+e.getMessage());//500 Internal Server Error
        }
    }

    public boolean isValidLoanType(String loanType) {
        return loanType != null && !loanType.isEmpty() && loanType.matches("[A-Za-z]+");
    }

    @GetMapping("/name")
    public String getCustomerName() {
        String name = getUser();
        String user = myBankCustomersService.getCustomerName(name);
        return user;
    }
    public String getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return name;
    }

}