package org.example;

import java.io.Serializable;

public class EmployeeAddressDetails implements Serializable {
    private Integer employeeId;
    private String permanentAddressHouseName;
    private String permanentAddressAreaNAme;
    private String permanentAddressStreetName;
    private String permanentAddressCity;
    private String permanentAddressState;
    private Integer permanentAddressPincode;

    private String temporaryAddressHouseName;
    private String temporaryAddressAreaNAme;
    private String temporaryAddressStreetName;
    private String temporaryAddressCity;
    private String temporaryAddressState;
    private Integer temporaryAddressPincode;

    public EmployeeAddressDetails(String permanent1, String permanent2, String permanentStreet, String permanentCity, String permanentState, Integer permanentPin) {
    }

    @Override
    public String toString() {
        return "EmployeeAddressDetails{" +
                "permanentAddressHouseName='" + permanentAddressHouseName + '\'' +
                ", permanentAddressAreaNAme='" + permanentAddressAreaNAme + '\'' +
                ", permanentAddressStreetName='" + permanentAddressStreetName + '\'' +
                ", permanentAddressCity='" + permanentAddressCity + '\'' +
                ", permanentAddressState='" + permanentAddressState + '\'' +
                ", permanentAddressPincode=" + permanentAddressPincode +
                ", temporaryAddressHouseName='" + temporaryAddressHouseName + '\'' +
                ", temporaryAddressAreaNAme='" + temporaryAddressAreaNAme+ '\'' +
                ", temporaryAddressStreetName='" + temporaryAddressStreetName + '\'' +
                ", temporaryAddressCity='" + temporaryAddressCity + '\'' +
                ", temporaryAddressState='" + temporaryAddressState + '\'' +
                ", temporaryAddressPincode=" + temporaryAddressPincode +
                '}';
    }

    public EmployeeAddressDetails(String permanentAddressHouseName, String permanentAddressAreaNAme, String permanentAddressStreetName, String permanentAddressCity, String permanentAddressState, Integer permanentAddressPincode, String temporaryAddressLane1, String temporaryAddressLane2, String temporaryAddressStreetName, String temporaryAddressCity, String temporaryAddressState, Integer temporaryAddressPincode) {
        this.permanentAddressHouseName = permanentAddressHouseName;
        this.permanentAddressAreaNAme = permanentAddressAreaNAme;
        this.permanentAddressStreetName = permanentAddressStreetName;
        this.permanentAddressCity = permanentAddressCity;
        this.permanentAddressState = permanentAddressState;
        this.permanentAddressPincode = permanentAddressPincode;
        this.temporaryAddressHouseName = temporaryAddressLane1;
        this.temporaryAddressAreaNAme = temporaryAddressAreaNAme;
        this.temporaryAddressStreetName = temporaryAddressStreetName;
        this.temporaryAddressCity = temporaryAddressCity;
        this.temporaryAddressState = temporaryAddressState;
        this.temporaryAddressPincode = temporaryAddressPincode;
    }

    public String getPermanentAddressHouseName() {
        return permanentAddressHouseName;
    }

    public void setPermanentAddressHouseName(String permanentAddressHouseName) {
        this.permanentAddressHouseName = permanentAddressHouseName;
    }

    public String getPermanentAddressAreaNAme() {
        return permanentAddressAreaNAme;
    }

    public void setPermanentAddressAreaNAme(String permanentAddressAreaNAme) {
        this.permanentAddressAreaNAme = permanentAddressAreaNAme;
    }

    public String getPermanentAddressStreetName() {
        return permanentAddressStreetName;
    }

    public void setPermanentAddressStreetName(String permanentAddressStreetName) {
        this.permanentAddressStreetName = permanentAddressStreetName;
    }

    public String getPermanentAddressCity() {
        return permanentAddressCity;
    }

    public void setPermanentAddressCity(String permanentAddressCity) {
        this.permanentAddressCity = permanentAddressCity;
    }

    public String getPermanentAddressState() {
        return permanentAddressState;
    }

    public void setPermanentAddressState(String permanentAddressState) {
        this.permanentAddressState = permanentAddressState;
    }

    public Integer getPermanentAddressPincode() {
        return permanentAddressPincode;
    }

    public void setPermanentAddressPincode(Integer permanentAddressPincode) {
        this.permanentAddressPincode = permanentAddressPincode;
    }

    public String getTemporaryAddressHouseName() {
        return temporaryAddressHouseName;
    }

    public void setTemporaryAddressHouseName(String temporaryAddressHouseName) {
        this.temporaryAddressHouseName = temporaryAddressHouseName;
    }

    public String getTemporaryAddressAreaNAme() {
        return temporaryAddressAreaNAme;
    }

    public void setTemporaryAddressAreaNAme(String temporaryAddressAreaNAme) {
        this.temporaryAddressAreaNAme = temporaryAddressAreaNAme;
    }

    public String getTemporaryAddressStreetName() {
        return temporaryAddressStreetName;
    }

    public void setTemporaryAddressStreetName(String temporaryAddressStreetName) {
        this.temporaryAddressStreetName = temporaryAddressStreetName;
    }

    public String getTemporaryAddressCity() {
        return temporaryAddressCity;
    }

    public void setTemporaryAddressCity(String temporaryAddressCity) {
        this.temporaryAddressCity = temporaryAddressCity;
    }

    public String getTemporaryAddressState() {
        return temporaryAddressState;
    }

    public void setTemporaryAddressState(String temporaryAddressState) {
        this.temporaryAddressState = temporaryAddressState;
    }

    public Integer getTemporaryAddressPincode() {
        return temporaryAddressPincode;
    }

    public void setTemporaryAddressPincode(Integer temporaryAddressPincode) {
        this.temporaryAddressPincode = temporaryAddressPincode;
    }
}
