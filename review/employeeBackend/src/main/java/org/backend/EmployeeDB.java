package org.backend;

import org.exception.ConnectionException;
import org.exception.NoDataException;
import org.exception.UserExist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeDB implements MyInterface {
    private Validation validation = new Validation();
    static Logger logger = LoggerFactory.getLogger(EmployeeDB.class);
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
    ResultSet resultSet;

    public EmployeeDB() {
    }

    @Override
    public String input(EmployeePersonalDetails employeePersonalDetails) throws SQLException {
        ResourceBundle resourceBundleOne = ResourceBundle.getBundle("database");
//        CREATE TABLE employees (employeeID NUMBER PRIMARY KEY,firstNameOfEmployee VARCHAR2(255),middleNameOfEmployee VARCHAR2(255),lastNameOfEmployee VARCHAR2(255),employeeContactNumber NUMBER,employeeEmail VARCHAR2(255));
//        create table EMPLOYEEPERMANENTADDRESS(HouseName varchar(255) not null, StreetName varchar(255) not null,City varchar(255) not null, StateName varchar(255) not null, Pincode number not null);
//        create table EMPLOYEETEMPORARYADDRESS(HouseName varchar(255) not null, StreetName varchar(255) not null,City varchar(255) not null, StateName varchar(255) not null, Pincode number not null);
//        ALTER TABLE EMPLOYEEPERMANENTADDRESS ADD EMPLOYEEID number;
//        ALTER TABLE EMPLOYEETEMPORARYADDRESS ADD EMPLOYEEID number;
//        alter table EMPLOYEETEMPORARYADDRESS add FOREIGN key(EMPLOYEEID) references EMPLOYEES(EMPLOYEEID);

        //     ALTER TABLE EMPLOYEEPERMANENTADDRESS
////        ADD FOREIGN KEY (EmployeeID)
////        REFERENCES EMPLOYEEPERSONAL(EmployeeID)
////        ON  DELETE CASCADE;
        //  System.out.println(employeePersonalDetails);
        try {
            DriverInitializer setConnection = new DriverInitializer();
            Connection connection = setConnection.makeConnection();
            try {
                String query = "insert into EMPLOYEES values(?,?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(2, employeePersonalDetails.getFirstNameOfEmployee());
                preparedStatement.setString(3, employeePersonalDetails.getMiddleNameOfEmployee());
                preparedStatement.setString(4, employeePersonalDetails.getLastNameOfEmployee());
                preparedStatement.setInt(1, employeePersonalDetails.getEmployeeID());
                preparedStatement.setLong(5, employeePersonalDetails.getEmployeeContactNumber());
                preparedStatement.setString(6, employeePersonalDetails.getEmployeeEmail());
                int record = preparedStatement.executeUpdate();
                //   System.out.println(employeePersonalDetails);

                String query1 = "insert into EMPLOYEEADDRESS values(?,?,?,?,?,?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(query1);
                preparedStatement.setString(1, employeePersonalDetails.getPermanentAddress().getHouseName());
                preparedStatement.setString(2, employeePersonalDetails.getPermanentAddress().getStreetName());
                preparedStatement.setString(3, employeePersonalDetails.getPermanentAddress().getCity());
                preparedStatement.setString(4, employeePersonalDetails.getPermanentAddress().getState());
                preparedStatement.setInt(5, employeePersonalDetails.getPermanentAddress().getPincode());
                preparedStatement.setInt(6, employeePersonalDetails.getEmployeeID());
                preparedStatement.setString(7, employeePersonalDetails.getTemporaryAddress().getHouseName());
                preparedStatement.setString(8, employeePersonalDetails.getTemporaryAddress().getStreetName());
                preparedStatement.setString(9, employeePersonalDetails.getTemporaryAddress().getCity());
                preparedStatement.setString(10, employeePersonalDetails.getTemporaryAddress().getState());
                preparedStatement.setInt(11, employeePersonalDetails.getTemporaryAddress().getPincode());
//                String query1 = "insert into EMPLOYEEPERMANENTADDRESS values(?,?,?,?,?,?)";
//                preparedStatement = connection.prepareStatement(query1);
//                preparedStatement.setString(1, employeePersonalDetails.getPermanentAddress().getHouseName());
//                preparedStatement.setString(2, employeePersonalDetails.getPermanentAddress().getStreetName());
//                preparedStatement.setString(3, employeePersonalDetails.getPermanentAddress().getCity());
//                preparedStatement.setString(4, employeePersonalDetails.getPermanentAddress().getState());
//                preparedStatement.setInt(5, employeePersonalDetails.getPermanentAddress().getPincode());
//                preparedStatement.setInt(6, employeePersonalDetails.getEmployeeID());
                int recordOne = preparedStatement.executeUpdate();
                //  System.out.println(employeePersonalDetails);
//                String query2 = "insert into EMPLOYEETEMPORARYADDRESS values(?,?,?,?,?,?)";
//                preparedStatement = connection.prepareStatement(query2);
//                preparedStatement.setString(1, employeePersonalDetails.getTemporaryAddress().getHouseName());
//                preparedStatement.setString(2, employeePersonalDetails.getTemporaryAddress().getStreetName());
//                preparedStatement.setString(3, employeePersonalDetails.getTemporaryAddress().getCity());
//                preparedStatement.setString(4, employeePersonalDetails.getTemporaryAddress().getState());
//                preparedStatement.setInt(5, employeePersonalDetails.getTemporaryAddress().getPincode());
//                preparedStatement.setInt(6, employeePersonalDetails.getEmployeeID());
//                int recordTwo = preparedStatement.executeUpdate();
                //  System.out.println(employeePersonalDetails);

                if (record != 0 && recordOne != 0) {
                    logger.info(resourceBundle.getString("employee.added"));
                    preparedStatement.close();
                    connection.close();
                    return "EXC000";
                }
                preparedStatement.close();
                connection.close();
                logger.info(resourceBundle.getString("employee.not.added"));
                return "EXC001";

            } catch (SQLIntegrityConstraintViolationException sql) {
                throw new UserExist();
            }
        } catch (ConnectionException exp) {
            throw new ConnectionException();
        }

    }

    public List<EmployeePersonalDetails> display() throws SQLException {
        List<EmployeePersonalDetails> employeeList = new ArrayList<>();
        try {
            DriverInitializer setConnection = new DriverInitializer();
            Connection connection = setConnection.makeConnection();
            String query = "select * from EMPLOYEES";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            String queryTwo = "select * from EMPLOYEEADDRESS where EMPLOYEEID=?";
            PreparedStatement preparedStatementTwo = connection.prepareStatement(queryTwo);
//            String query = "select * from EMPLOYEES";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            String queryTwo = "select * from EMPLOYEEPERMANENTADDRESS where EMPLOYEEID=?";
//            PreparedStatement preparedStatementTwo = connection.prepareStatement(queryTwo);
//            String queryThree = "select * from EMPLOYEETEMPORARYADDRESS where EMPLOYEEID=?";
//            PreparedStatement preparedStatementThree = connection.prepareStatement(queryThree);
            // ResultSet resultSetTwo;
            ResultSet resultSetOne;
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new NoDataException("Input employee data not found");
            }
            while (resultSet.next()) {
                EmployeePersonalDetails employee = new EmployeePersonalDetails();
                EmployeeAddressDetails permenantAddress = new EmployeeAddressDetails();
                EmployeeAddressDetails temporaryAddress = new EmployeeAddressDetails();
                preparedStatementTwo.setString(1, String.valueOf(resultSet.getInt(1)));
                resultSetOne = preparedStatementTwo.executeQuery();
                if (resultSetOne.next()) {
                    permenantAddress.setHouseName(resultSetOne.getString(1));
                    permenantAddress.setStreetName(resultSetOne.getString(2));
                    permenantAddress.setCity(resultSetOne.getString(3));
                    permenantAddress.setState(resultSetOne.getString(4));
                    permenantAddress.setPincode(resultSetOne.getInt(5));
                    temporaryAddress.setHouseName(resultSetOne.getString(1));
                    temporaryAddress.setStreetName(resultSetOne.getString(2));
                    temporaryAddress.setCity(resultSetOne.getString(3));
                    temporaryAddress.setState(resultSetOne.getString(4));
                    temporaryAddress.setPincode(resultSetOne.getInt(5));
                }
//                preparedStatementThree.setString(1, String.valueOf(resultSet.getInt(1)));
//                resultSetTwo = preparedStatementThree.executeQuery();
//                if (resultSetTwo.next()) {
//                    temporaryAddress.setHouseName(resultSetTwo.getString(1));
//                    temporaryAddress.setStreetName(resultSetTwo.getString(2));
//                    temporaryAddress.setCity(resultSetTwo.getString(3));
//                    temporaryAddress.setState(resultSetTwo.getString(4));
//                    temporaryAddress.setPincode(resultSetTwo.getInt(5));
//                }
                employee.setFirstNameOfEmployee(resultSet.getString(2));
                employee.setMiddleNameOfEmployee(resultSet.getString(3));
                employee.setLastNameOfEmployee(resultSet.getString(4));
                employee.setEmployeeID(resultSet.getInt(1));
                employee.setEmployeeContactNumber(resultSet.getLong(5));
                employee.setEmployeeEmail(resultSet.getString(6));
                employee.setPermanentAddress(permenantAddress);
                employee.setTemporaryAddress(temporaryAddress);
                employeeList.add(employee);
            }
            preparedStatement.close();
            preparedStatementTwo.close();
            //preparedStatementThree.close();
            connection.close();
            resultSet.close();


        } catch (ConnectionException exp) {
            throw new ConnectionException();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;

    }

    @Override
    public List<EmployeePersonalDetails> searchByPinCode(int pin) {
        List<EmployeePersonalDetails> employeeList = new ArrayList<>();
        try {
            DriverInitializer setConnection = new DriverInitializer();
            Connection connection = setConnection.makeConnection();
            ResultSet resultSet;
            try {
                // String query="SELECT * FROM EMPLOYEES emp INNER JOIN EMPLOYEEPERMANENTADDRESS permadd ON emp.EMPLOYEEID = permadd.EMPLOYEEID INNER JOIN EMPLOYEETEMPORARYADDRESS tempadd ON emp.EMPLOYEEID = tempadd.EMPLOYEEID  WHERE tempadd.pincode =?  or permadd.pincode = ?";
                String query = "select e.FIRSTNAMEOFEMPLOYEE,e.EMPLOYEEEMAIL,e.EMPLOYEEID,a.PERMANENTHOUSENAME,a.PERMANENTSTREETNAME,a.PERMANENTCITY,a.PERMANENTSTATENAME,a.PERMANENTPINCODE, a.TEMPORARYHOUSENAME,a.TEMPORARYSTREETNAME,a.TEMPORARYCITY,a.TEMPORARYSTATENAME,a.TEMPORARYPINCODE from EMPLOYEEPERSONAL e join EMPLOYEEADDRESS a on e.EMPLOYEEID=a.EMPLOYEEID where a.PERMANENTPINCODE=? or a.TEMPORARYPINCODE=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, pin);
                preparedStatement.setInt(2, pin);
                EmployeePersonalDetails employee = new EmployeePersonalDetails();
                EmployeeAddressDetails permenantAddress = new EmployeeAddressDetails();
                EmployeeAddressDetails temporaryAddress = new EmployeeAddressDetails();
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    employee.setFirstNameOfEmployee(resultSet.getString(1));
                    employee.setEmployeeEmail(resultSet.getString(2));
                    employee.setEmployeeID(resultSet.getInt(3));

                    permenantAddress.setHouseName(resultSet.getString(4));
                    permenantAddress.setStreetName(resultSet.getString(5));
                    permenantAddress.setCity(resultSet.getString(6));
                    permenantAddress.setState(resultSet.getString(7));
                    permenantAddress.setPincode(resultSet.getInt(8));

                    temporaryAddress.setHouseName(resultSet.getString(9));
                    temporaryAddress.setStreetName(resultSet.getString(10));
                    temporaryAddress.setCity(resultSet.getString(11));
                    temporaryAddress.setState(resultSet.getString(12));
                    temporaryAddress.setPincode(resultSet.getInt(13));
//                PreparedStatement preparedStatement = connection.prepareStatement(query);
//                preparedStatement.setInt(1, pin);
//                preparedStatement.setInt(2, pin);
//                EmployeePersonalDetails employee = new EmployeePersonalDetails();
//                EmployeeAddressDetails permenantAddress = new EmployeeAddressDetails();
//                EmployeeAddressDetails temporaryAddress = new EmployeeAddressDetails();
//                resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()) {
//                    employee.setFirstNameOfEmployee(resultSet.getString(1));
//                    employee.setMiddleNameOfEmployee(resultSet.getString(2));
//                    employee.setLastNameOfEmployee(resultSet.getString(3));
//                    employee.setEmployeeID(resultSet.getInt(4));
//                    employee.setEmployeeContactNumber(resultSet.getLong(5));
//                    employee.setEmployeeEmail(resultSet.getString(6));
//
//                    permenantAddress.setHouseName(resultSet.getString(7));
//                    permenantAddress.setStreetName(resultSet.getString(8));
//                    permenantAddress.setCity(resultSet.getString(9));
//                    permenantAddress.setState(resultSet.getString(10));
//                    permenantAddress.setPincode(resultSet.getInt(11));
//
//                    temporaryAddress.setHouseName(resultSet.getString(13));
//                    temporaryAddress.setStreetName(resultSet.getString(14));
//                    temporaryAddress.setCity(resultSet.getString(15));
//                    temporaryAddress.setState(resultSet.getString(16));
//                    temporaryAddress.setPincode(resultSet.getInt(17));

                    employee.setPermanentAddress(permenantAddress);
                    employee.setTemporaryAddress(temporaryAddress);
                    employeeList.add(employee);
                }
                preparedStatement.close();
                connection.close();
                resultSet.close();


            } catch (SQLException exp) {
                throw new SQLException();
            }
        } catch (ConnectionException | SQLException connectionExcp) {
            throw new ConnectionException();
        }
        return employeeList;
    }

    @Override
    public boolean delete(int EmployeeId) {
        try {
            DriverInitializer setConnection = new DriverInitializer();
            Connection connection = setConnection.makeConnection();
            String query = "DELETE FROM EMPLOYEES WHERE EMPLOYEEID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, EmployeeId);
            int ResultSet = preparedStatement.executeUpdate();
            if (ResultSet != 0) {
                return true;
            }
        } catch (SQLException | ConnectionException exp) {
            System.out.println(exp);
            logger.info(resourceBundle.getString("connection.failed"));
            ;
        }
        return false;
    }

    @Override
    public void writeIntoFile(EmployeePersonalDetails employeePersonalDetails) {

    }

    @Override
    public void writeIntoFileAdd(EmployeeAddressDetails employeeAddressDetails) {

    }

    @Override
    public ArrayList<Object> readFromFile() {
        return null;
    }

    @Override
    public ArrayList<Object> readFromFileAdd() {
        return null;
    }

}
