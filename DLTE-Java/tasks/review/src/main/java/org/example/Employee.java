package org.example;

public class Employee {
    private String firstName;
    private String middleName;
    private String lastName;
    private Long employeePhone;
    private  Integer employeeId;
    private String email;

    public Employee() {
    }

    public Employee(String firstName, String middleName, String lastName, Long employeePhone, Integer employeeId, String email) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.employeePhone = employeePhone;
        this.employeeId = employeeId;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(Long employeePhone) {
        this.employeePhone = employeePhone;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employeePhone=" + employeePhone +
                ", employeeId=" + employeeId +
                ", email='" + email + '\'' +
                '}';
    }
}
class Address{
    private String houseName;
    private String streetName;
    private String cityName;
    private String stateName;
    private String pinCode;

    public Address() {
    }

    public Address(String houseName, String streetName, String cityName, String stateName, String pinCode) {
        this.houseName = houseName;
        this.streetName = streetName;
        this.cityName = cityName;
        this.stateName = stateName;
        this.pinCode = pinCode;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseName='" + houseName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", stateName='" + stateName + '\'' +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }
}