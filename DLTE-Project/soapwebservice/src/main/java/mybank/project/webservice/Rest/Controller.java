package mybank.project.webservice.Rest;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ResourceBundle;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/loans")
public class Controller {
    @Autowired
    private LoanInterface interfaceServices;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("application");// Loading resource bundle
    Logger logger = LoggerFactory.getLogger(LoanService.class);// Initializing logger

    @GetMapping("/{loanType}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",description = "There are no loans available for the selected loan type."),
            @ApiResponse(responseCode = "500",description = "Internal server error."),
            @ApiResponse(responseCode = "200",description = "loans are fetched"),
            @ApiResponse(responseCode = "404",description = "no loans found")
    })
    public ResponseEntity<Object> findByLoanType(@PathVariable String loanType, HttpServletResponse response) {
        try {
            List<LoansAvailable> loans = interfaceServices.findByLoanType(loanType);
            if (loans.isEmpty()) {
                return ResponseEntity.notFound().build();// If the list of loans is empty 404 Not Found
            } else {
                return ResponseEntity.ok(loans); // If loans found 200 OK
            }
        } catch (NoLoanData e) {
            //response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            logger.error(resourceBundle.getString("no.loanType"), e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());//for no loan data found 404
        } catch (NoLoanException e) {
            //response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(resourceBundle.getString("db.error"), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());//500 Internal Server Error
        }
    }
}