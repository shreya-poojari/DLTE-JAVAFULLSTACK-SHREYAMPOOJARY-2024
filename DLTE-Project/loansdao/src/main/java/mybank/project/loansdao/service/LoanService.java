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

import java.math.BigDecimal;
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

    //method to find list of all available loans
//    @Override
//    public List<LoansAvailable> allAvailableLoans() {
//        List<LoansAvailable> lists = new ArrayList<>();
//        try {
//            lists = jdbcTemplate.query("select * from MyBank_App_LoanAvailable", new LoansMapper());
//        } catch (DataAccessException exception) {
//            logger.error(resourceBundle.getString("data.fetch.error"));
//            throw new NoLoanData(resourceBundle.getString("no.loansFound"));
//        }
//        if (lists == null) {
//            logger.warn(resourceBundle.getString("no.loan.data"));
//            throw new NoLoanException(resourceBundle.getString("no.loansFound"));
//        }
//        logger.info(resourceBundle.getString("loan.fetch.success"));
//        return lists;
//    }

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

            //ResultSet rs = (ResultSet) returnedLoans.get("loans_cursor");

             ArrayList<LoansAvailable> result = (ArrayList<LoansAvailable>) returnedLoans.get("loans_cursor");
             //result.get(0);
            if (result != null) {

                if (result.equals("NO_LOAN_FOUND")) {
                    logger.warn(resourceBundle.getString("no.loanType"));
                    throw new NoLoanData(resourceBundle.getString("no.loanType") + loanType);

                } else if (result.equals("SQ001")) {
                    logger.warn(resourceBundle.getString("error.loanType"));
                    throw new NoLoanException(resourceBundle.getString("error.loanType"));
                }
//                else if (result.isEmpty()) {
//                throw new NoLoanData(resourceBundle.getString("no.loan.data"));
//            }
            }
//            if (result.isEmpty()) {
//                throw new NoLoanData(resourceBundle.getString("no.loan.data"));
//            }
            return result;
        } catch (Exception e) {
            throw new SQLException("Error occurred while fetching loans by type: " + e.getMessage());
        }
    }

}







