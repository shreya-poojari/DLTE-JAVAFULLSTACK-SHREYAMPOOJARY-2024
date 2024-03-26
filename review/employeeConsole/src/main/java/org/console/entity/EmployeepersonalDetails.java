package org.console.entity;



import java.io.Serializable;

public class EmployeepersonalDetails implements Serializable {
    private String firstNameOfEmployee;
    private String middleNameOfEmployee;
    private String lastNameOfEmployee;
    private Integer employeeID;
    private Long employeeContactNumber;
    private String employeeEmail;
    private EmployeeAddressDetails permanentAddress;
    private EmployeeAddressDetails temporaryAddress;
}
