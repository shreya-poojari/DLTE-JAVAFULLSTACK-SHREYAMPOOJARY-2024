package org.example;

public class Employee {


    private String employeeName;
    private Long phoneNo;
    private Long employeeID;
    private String emailID;
    private Address permanentAddress;
    private Address temporaryAddress;

    public Employee() {
    }

    public String getEmployeeName () {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Long  getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(Address permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Address getTemporaryAddress() {
        return temporaryAddress;
    }

    public void setTemporaryAddress(Address temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    public Employee(String employeeName, Long phoneNo, Long employeeID, String emailID, Address permanentAddress, Address temporaryAddress) {

        this.employeeName = employeeName;
        this.phoneNo = phoneNo;
        this.employeeID = employeeID;
        this.emailID = emailID;
        this.permanentAddress = permanentAddress;
        this.temporaryAddress = temporaryAddress;
    }
    public  void displayDetails(){

        System.out.println("Employee Name: "+employeeName);
        System.out.println("Phone No: "+phoneNo);
        System.out.println("Employee ID: "+employeeID);
        System.out.println("Email ID: "+emailID);
        System.out.println("Permanent Address: ");
        permanentAddress.displayAddress();
        System.out.println("Temporary Address: ");
        temporaryAddress.displayAddress();

    }

}