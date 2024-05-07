package mybank.project.loansdao.service;

import mybank.project.loansdao.entity.LoansAvailable;
import mybank.project.loansdao.exception.NoLoanData;
import mybank.project.loansdao.exception.NoLoanException;
import mybank.project.loansdao.interfaces.LoanInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Service;
import oracle.jdbc.internal.OracleTypes;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;

@Service
public class LoanService implements LoanInterface {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    @Autowired
    private JdbcTemplate jdbcTemplate;
    Logger logger = LoggerFactory.getLogger(LoanService.class);

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

    @Override
    public List<LoansAvailable> allAvailableLoans() {
        List<LoansAvailable> allAvailLoan;
        try {
            allAvailLoan = jdbcTemplate.query("select * from mybank_app_loanavailable", new LoansMapper());
            if (allAvailLoan == null) {
                throw new NoLoanData(resourceBundle.getString("no.loans"));
            }
        }//if any error encountered interms of database
        catch (DataAccessException dao) {
            logger.error(resourceBundle.getString("db.error"));
            throw new NoLoanException(resourceBundle.getString("db.error"));
        }//if any nullPointerException
        if(allAvailLoan.size()==0){
            logger.warn(resourceBundle.getString("no.loans"));
            throw new NoLoanData(resourceBundle.getString("no.loans"));
        }
        return allAvailLoan;
    }

    @Override
    public List<LoansAvailable> findByLoanType(String loanType) throws SQLException {
        if (loanType == null || loanType.isEmpty()) {
            throw new IllegalArgumentException("Loan type cannot be null or empty");
        }

        try {
            CallableStatementCreator creator = con -> {
                CallableStatement statement = con.prepareCall("{call read_loans_by_type(?,?,?)}");
                statement.setString(1, loanType);
                statement.registerOutParameter(2, OracleTypes.CURSOR);
                statement.registerOutParameter(3, Types.VARCHAR);
                return statement;
            };
            Map<String, Object> returnedLoans = jdbcTemplate.call(creator, Arrays.asList(
                    new SqlParameter(Types.VARCHAR),
                    new SqlOutParameter("loans_cursor", OracleTypes.CURSOR),
                    new SqlOutParameter("loan_info", Types.VARCHAR)
            ));

            // Get the loan information from the output parameters
            String loanInfo = (String) returnedLoans.get("loan_info");

            // Check if the loan information indicates an error
            if (loanInfo != null && !loanInfo.isEmpty()) {
                if (loanInfo.equals("NO_LOAN_FOUND")) {
                    logger.warn(resourceBundle.getString("no.loanType"));
                    throw new NoLoanData(resourceBundle.getString("no.loanType") + loanType);
                } else if (loanInfo.equals("SQ001")) {
                    logger.warn(resourceBundle.getString("error.loanType"));
                    throw new NoLoanException(resourceBundle.getString("error.loanType"));
                }
            }

            // If there was no error, return the list of loans
            ArrayList<LoansAvailable> result = (ArrayList<LoansAvailable>) returnedLoans.get("loans_cursor");

            // Check if the result is empty and throw NoLoanData exception if so
            if (result == null || result.isEmpty()) {
                logger.warn(resourceBundle.getString("no.loanType"));
                throw new NoLoanData(resourceBundle.getString("no.loanType") + loanType);
            }

            return result;
        } catch (DataAccessException e) {
            logger.error(resourceBundle.getString("db.error"), e);
            throw new SQLException("Error occurred while fetching loans by type: " + e.getMessage());
        }
    }



}







