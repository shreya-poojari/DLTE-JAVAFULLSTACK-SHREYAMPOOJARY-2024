package org.example.entity;

import org.example.details.EmployeeBasicDetails;

public class EmployeeBasicDetailsConsole extends EmployeeBasicDetails {
    private String employeeName;
    private String employeeId;
    private String emailId;
    private long phoneNumber;

    public EmployeeBasicDetailsConsole(String employeeName, String employeeId, String emailId, long phoneNumber) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public EmployeeBasicDetailsConsole() {
    }

    @Override
    public String toString() {
        return "EmployeebasicDetailsConsole{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
