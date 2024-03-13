package org.example;
import oracle.jdbc.driver.OracleDriver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
public class DatabaseRepositoryImplementation implements InputEmployeeDetails {

    Connection connection;
    ResourceBundle resourceBundle= ResourceBundle.getBundle("Database");
    PreparedStatement preparedStatement;
    public DatabaseRepositoryImplementation() {
        try{
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            connection= DriverManager.getConnection(resourceBundle.getString("db.url"),resourceBundle.getString("db.user"),resourceBundle.getString("db.pass"));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public boolean isEstablished(){
        return connection!=null;
    }
    @Override
    public void create(List list) {
//        String employee = "INSERT INTO Employee (id, name) VALUES (?, ?)";
//        String permanentaddress = "INSERT INTO EmployeeAddress (employeeId,permanentAddress, permanentHouseNumber,permanentCity, permanentState,permanentPinCode) " +
//                "VALUES (?, ?, ?, ?, ?, ?, ?)";
//        String temporaryaddress = "INSERT INTO EmployeeTemporaryAddress(employeeId,temporaryAddress, temporaryHouseNumber,temporaryCity, temporaryState,temporaryPinCode) " +
//                "VALUES (?, ?, ?, ?, ?, ?, ?)";
//        String information = "INSERT INTO EmployeeInformation (employeeId, email, phoneNumber) VALUES (?, ?, ?)";
//        try (PreparedStatement employeeStatement = connection.prepareStatement(employee);
//             PreparedStatement PermanentAddressStatement = connection.prepareStatement(permanentaddress);
//             PreparedStatement temporaryaddressStatement = connection.prepareStatement(temporaryaddress);
//             PreparedStatement infoStatement = connection.prepareStatement(information)) {
//
//            for (Employee employees : list) {
//                // Insert employee data
//                employeeStatement.setInt(1, employee.getId());
//                employeeStatement.setString(2, employee.getName());
//                employeeStatement.executeUpdate();
//
//                // Insert address data
//                EmployeeAddress permanentAddress = employee.getPermanentAddress();
//                addressStatement.setInt(1, employee.getId());
//                addressStatement.setString(2, "permanent");
//                addressStatement.setString(3, permanentAddress.getHouseNumber());
//                addressStatement.setString(4, permanentAddress.getStreet());
//                addressStatement.setString(5, permanentAddress.getCity());
//                addressStatement.setString(6, permanentAddress.getState());
//                addressStatement.setString(7, permanentAddress.getZipCode());
//                addressStatement.executeUpdate();
//
//                EmployeeAddress temporaryAddress = employee.getTemporaryAddress();
//                addressStatement.setInt(1, employee.getId());
//                addressStatement.setString(2, "temporary");
//                addressStatement.setString(3, temporaryAddress.getHouseNumber());
//                addressStatement.setString(4, temporaryAddress.getStreet());
//                addressStatement.setString(5, temporaryAddress.getCity());
//                addressStatement.setString(6, temporaryAddress.getState());
//                addressStatement.setString(7, temporaryAddress.getZipCode());
//                addressStatement.executeUpdate();
//
//                // Insert information data
//                EmployeeInformation information = employee.getInformation();
//                infoStatement.setInt(1, employee.getId());
//                infoStatement.setString(2, information.getEmail());
//                infoStatement.setString(3, information.getPhoneNumber());
//                infoStatement.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        for(Employee employee:list){
            String employeeID=employee.getEmployeeId();
            try{
                String employees = "INSERT INTO Employee (id, name) VALUES (?, ?)";
                preparedStatement=connection.prepareStatement(employees);
                preparedStatement.setString(1,employeeID);
                preparedStatement.setString(2,employee.getEmployeeName());
                int resultBasic=preparedStatement.executeUpdate();
                String permanentaddress = "INSERT INTO EmployeeAddress (employeeId,permanentAddress, permanentHouseNumber,permanentCity, permanentState,permanentPinCode) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";
                preparedStatement=connection.prepareStatement(permanentaddress);
                preparedStatement.setString(1,employeeID);
                preparedStatement.setString(2,employee.getAddress().getPermanentAddress());
                preparedStatement.setString(3,employee.getAddress().getPermanentHouseNumber());
                preparedStatement.setString(4,employee.getAddress().getPermanentCity());
                preparedStatement.setString(5,employee.getAddress().getPermanentState());
                preparedStatement.setLong(6,employee.getAddress().getPermanentPinCode());
                int resultPermanent=preparedStatement.executeUpdate();
                String temporaryaddress = "INSERT INTO EmployeeTemporaryAddress(employeeId,temporaryAddress, temporaryHouseNumber,temporaryCity, temporaryState,temporaryPinCode) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";
                preparedStatement=connection.prepareStatement(temporaryaddress);
                preparedStatement.setString(1,employeeID);
                preparedStatement.setString(2,employee.getAddress().getTemporaryAddress());
                preparedStatement.setString(3,employee.getAddress().getTemporaryHouseNumber());
                preparedStatement.setString(4,employee.getAddress().getTemporaryCity());
                preparedStatement.setString(5,employee.getAddress().getTemporaryState());
                preparedStatement.setLong(6,employee.getAddress().getTemporaryPinCode());
                int resultTemporary=preparedStatement.executeUpdate();
                String information = "INSERT INTO EmployeeInformation (employeeId, email, phoneNumber) VALUES (?, ?, ?)";
                preparedStatement=connection.prepareStatement(information);
                preparedStatement.setString(1,employeeID);
                preparedStatement.setString(2,employee.getAdditionalInformation().getEmailId());
                preparedStatement.setLong(3,employee.getAdditionalInformation().getPhoneNumber());
                int resultInformation=preparedStatement.executeUpdate();
                connection.commit();
                if(resultBasic!=0){
                    System.out.println("Basic details inserted");
                }else{
                    System.out.println("failed");
                }
                if(resultTemporary!=0) System.out.println("Temporary address inserted");
                if(resultPermanent!=0) System.out.println("Permanent address inserted");
                if(resultInformation!=0) System.out.println("Additional information added");

            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public Employee displayBasedOnEmployeeId(String s) {
        return null;
    }
    @Override
    public Employee displayBasedOnPinCode(int i) {
        return null;
    }
    @Override
    public List read() {
        return null;
    }
}
