package org.console.entity;

import java.io.Serializable;

public class EmployeeAddressDetails implements Serializable {
    private String houseName;
    private String streetName;
    private String city;
    private String state;
    private Integer pincode;

    public EmployeeAddressDetails() {
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "houseName='" + houseName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode=" + pincode +
                '}';
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public EmployeeAddressDetails(String houseName, String streetName, String city, String state, Integer pincode) {
        this.houseName = houseName;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

}
