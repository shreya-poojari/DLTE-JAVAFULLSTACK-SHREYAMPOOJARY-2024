package org.example;

import java.io.Serializable;

public class EmployeeAddress implements Serializable {
    private String houseName;
    private String areaName;
    private String city;
    private  String state;
    private Long pincode;

    public EmployeeAddress() {
    }

    public EmployeeAddress(String houseName, String areaName, String city, String state, Long pincode) {
        this.houseName = houseName;
        this.areaName = areaName;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseName='" + houseName + '\'' +
                ", areaName='" + areaName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }


    public void displayAddress() {
        System.out.println("House Name: " + houseName);
        System.out.println("Area Name: " + areaName);
        System.out.println("city Name: " +city);
        System.out.println("Pincode : " + pincode);
    }
    }

