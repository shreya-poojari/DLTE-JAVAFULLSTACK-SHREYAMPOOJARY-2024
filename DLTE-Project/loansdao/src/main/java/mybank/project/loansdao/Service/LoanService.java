package mybank.project.loansdao.Service;

import mybank.project.loansdao.Entity.LoansAvailable;
import mybank.project.loansdao.Exception.NoLoanException;
import mybank.project.loansdao.Interface.LoanInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
@Service
public class LoanService implements LoanInterface {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    @Autowired
    private JdbcTemplate jdbcTemplate;
        //Rowmapper class
    public class LoansMapper implements RowMapper<LoansAvailable> {
        @Override
        public LoansAvailable mapRow(ResultSet rs, int rowNum) throws SQLException {
            LoansAvailable loansAvailable = new LoansAvailable();
            loansAvailable.setLoanNumber(rs.getInt(1));
            loansAvailable.setLoanType(rs.getString(2));
            loansAvailable.setLoanName(rs.getString(3));
            loansAvailable.setLoanDescription(rs.getString(4));
            loansAvailable.setLoanRoi(rs.getDouble(5));
            return loansAvailable;
        }
    }

    //method to find list of all available loans
    @Override
    public List<LoansAvailable> allAvailableLoans() {
        try {
            List<LoansAvailable> lists = jdbcTemplate.query("select * from MyBank_App_LoanAvailable", new LoansMapper());
            if (lists == null) {
                throw new NoLoanException(resourceBundle.getString("no.loansFound"));
            }
            //else {
            //System.out.println(lists);
            // }
            return lists;
        } catch (Exception exception) {
            // return null;
            throw new NoLoanException(resourceBundle.getString("no.loansFound"));
        }
            //System.out.println(lists.toString());
            //return lists;
    }

    //method to find list of loans by loan type
    @Override
    public List<LoansAvailable> findByLoanType(String loanType) {
        //by using select query
//        try {
//            List<LoansAvailable> lists = jdbcTemplate.query("SELECT * FROM MyBank_App_LoanAvailable WHERE loan_type = ?", new Object[]{loanType}, new LoansMapper());
//            //System.out.println("Loans found by type " + loanType + ": " + lists.toString());
//            //return lists;
//            if (lists == null || lists.isEmpty()) {
//                throw new NoLoanException(resourceBundle.getString("no.loanType"));
//            }
//            //   else {
//            //  System.out.println(lists);
//            // logger.info("Loans retrieved successfully for loan type {}: {}", loanType, loansByType);
//            // }
//            return lists;
//        } catch (NoLoanException exception) {
//            throw new NoLoanException(resourceBundle.getString("no.loanType") + loanType);
//            //  logger.warn("No loans found for the specified loan type: {}", loanType);
//        } catch (Exception exception) {
//            throw new NoLoanException(resourceBundle.getString("error.loanType") + exception.getMessage());
//            // logger.error("Error occurred while fetching loans by type: {}", e.getMessage());
//        }
//        // return null;
//    }

        // Method to find list of loans by loan type using streams
        try {
            List<LoansAvailable> lists = jdbcTemplate.query("SELECT * FROM MyBank_App_LoanAvailable ", new Object[]{loanType}, new LoansMapper());
            //List<LoansAvailable> lists = allAvailableLoans();
            if (lists == null || lists.isEmpty()) {
                throw new NoLoanException(resourceBundle.getString("error.loanType"));
            }
            List<LoansAvailable> filterByLoanType = lists.stream()
                    .filter(loan -> loan.getLoanType().equalsIgnoreCase(loanType))
                    .collect(Collectors.toList());
            //System.out.println("Loans found by type " + loanType + ": " + filterByLoansType.toString());
            //return filterByLoansType;
            if (lists.isEmpty()) {
                throw new NoLoanException(resourceBundle.getString("no.loanType")+loanType);
                //System.out.println("no loan");
            }
            //else {
            //System.out.println("retrived");
            //}
            return lists;
        } catch (NoLoanException exception) {
            throw new NoLoanException(resourceBundle.getString("no.loanType")+loanType);
            //System.out.println("no loan");
        } catch (Exception exception) {
            throw new NoLoanException(resourceBundle.getString("error.loanType")+exception.getMessage());
            //System.out.println("errror");
        }
        //return null;
    }

}
