package mybank.project.loansdao.Service;

import mybank.project.loansdao.Entity.LoansAvailable;
import mybank.project.loansdao.Exception.NoLoanData;
import mybank.project.loansdao.Exception.NoLoanException;
import mybank.project.loansdao.Interface.LoanInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;
import java.util.stream.Collectors;

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
    @Override
    public List<LoansAvailable> allAvailableLoans() {
        List<LoansAvailable> lists = new ArrayList<>();
        try {
            lists = jdbcTemplate.query("select * from MyBank_App_LoanAvailable", new LoansMapper());
        } catch (DataAccessException exception) {
            logger.error(resourceBundle.getString("data.fetch.error"));
            throw new NoLoanData(resourceBundle.getString("no.loansFound"));
        }
        if (lists == null) {
            logger.warn(resourceBundle.getString("no.loan.data"));
            throw new NoLoanException(resourceBundle.getString("no.loansFound"));
        }
        logger.info(resourceBundle.getString("loan.fetch.success"));
        return lists;
    }

    @Override
    public List<LoansAvailable> findByLoanType(String loanType) {
        // Initialize an empty list to hold the loans
        List<LoansAvailable> loansList = new ArrayList<>();
        try {
            // Create a CallableStatementCreator
            CallableStatementCreator creator = con -> {
                // Prepare the callable statement for the stored procedure
                CallableStatement statement = con.prepareCall("{call read_loans_by_type(?,?,?,?,?,?,?)}");
                statement.setString(1, loanType);
                statement.registerOutParameter(2, Types.VARCHAR);
                statement.registerOutParameter(3, Types.VARCHAR);
                statement.registerOutParameter(4, Types.NUMERIC);
                statement.registerOutParameter(5, Types.NUMERIC);
                statement.registerOutParameter(6, Types.VARCHAR);
                statement.registerOutParameter(7, Types.VARCHAR);
                return statement;
            };
            List<SqlParameter> sqlParameters = Arrays.asList(
                    new SqlParameter(Types.VARCHAR),
                    new SqlOutParameter("loan_name", Types.VARCHAR),
                    new SqlOutParameter("loan_description", Types.VARCHAR),
                    new SqlOutParameter("loan_roi", Types.NUMERIC),
                    new SqlOutParameter("loan_number", Types.NUMERIC),
                    new SqlOutParameter("loan_info", Types.VARCHAR),
                    new SqlOutParameter("loan_type_out", Types.VARCHAR)
            );
            Map<String, Object> returnedLoans = jdbcTemplate.call(creator, sqlParameters);

            String loanInfo = (String) returnedLoans.get("loan_info");
            if (loanInfo != null) {

                if (loanInfo.equals("NO_LOAN_FOUND")) {
                    logger.warn(resourceBundle.getString("no.loanType"));
                    throw new NoLoanData(resourceBundle.getString("no.loanType") + loanType);

                } else if (loanInfo.equals("SQ001")) {
                    logger.warn(resourceBundle.getString("error.loanType"));
                    throw new NoLoanException(resourceBundle.getString("error.loanType"));
                }
            }
            LoansAvailable loan = new LoansAvailable();
            loan.setLoanNumber(((BigDecimal) returnedLoans.get("loan_number")).intValue());
            loan.setLoanType((String) returnedLoans.get("loan_type_out"));
            loan.setLoanName((String) returnedLoans.get("loan_name"));
            loan.setLoanDescription((String) returnedLoans.get("loan_description"));
            BigDecimal loanRoi = (BigDecimal) returnedLoans.get("loan_roi");
            if (loanRoi != null) {
                loan.setLoanRoi(loanRoi.doubleValue());
            }
            loansList.add(loan);
        } catch (DataAccessException ex) {
            logger.warn(resourceBundle.getString("db.error"));
            throw new NoLoanException(resourceBundle.getString("db.error"));
        }
        logger.info(resourceBundle.getString("loan.server.available"));
        return loansList;
    }
    }



////method to find list of loans by loan type
////    @Override
////    public List<LoansAvailable> findByLoanType(String loanType) {
////        //by using select query
//////        try {
//////            List<LoansAvailable> lists = jdbcTemplate.query("SELECT * FROM MyBank_App_LoanAvailable WHERE loan_type = ?", new Object[]{loanType}, new LoansMapper());
//////            //System.out.println("Loans found by type " + loanType + ": " + lists.toString());
//////            //return lists;
//////            if (lists == null || lists.isEmpty()) {
//////                throw new NoLoanException(resourceBundle.getString("no.loanType"));
//////            }
//////            //   else {
//////            //  System.out.println(lists);
//////            // }
//////            return lists;
//////        } catch (NoLoanException exception) {
//////            throw new NoLoanException(resourceBundle.getString("no.loanType") + loanType);
//////        } catch (Exception exception) {
//////            throw new NoLoanException(resourceBundle.getString("error.loanType") + exception.getMessage());
//////        }
////
////



        // Method to find list of loans by loan type using streams
//        try {
//           List<LoansAvailable> lists = jdbcTemplate.query("SELECT * FROM MyBank_App_LoanAvailable ", new Object[]{loanType}, new LoansMapper());
//            //List<LoansAvailable> lists = allAvailableLoans();
//            if (lists == null || lists.isEmpty()) {
//                throw new NoLoanException(resourceBundle.getString("error.loanType"));
//            }
//            List<LoansAvailable> filterByLoanType = lists.stream()
//                    .filter(loan -> loan.getLoanType().equalsIgnoreCase(loanType))
//                    .collect(Collectors.toList());
//            //System.out.println("Loans found by type " + loanType + ": " + filterByLoansType.toString());
//            //return filterByLoansType;
//            if (lists.isEmpty()) {
//                throw new NoLoanException(resourceBundle.getString("no.loanType")+loanType);
//                //System.out.println("no loan");
//            }
//            //else {
//            //System.out.println("retrived");
//            //}
//            return lists;
//        } catch (NoLoanException exception) {
//            throw new NoLoanException(resourceBundle.getString("no.loanType")+loanType);
//            //System.out.println("no loan");
//        } catch (Exception exception) {
//            throw new NoLoanException(resourceBundle.getString("error.loanType")+exception.getMessage());
//            //System.out.println("errror");
//        }
//        //return null;
//    }
//   }
