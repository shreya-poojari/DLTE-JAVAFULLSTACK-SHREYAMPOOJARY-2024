package org.example;

import java.io.Serializable;

public class EmployeeAddress implements Serializable {
    private String permanentStreet;
    private String permanentHouseName;
    private String permanentState;
    private String permanentCity;
    private Integer permanentPinCode;
    private String temporaryStreet;
    private String temporaryHouseNumber;
    private String temporaryState;
    private String temporaryCity;
    private Integer temporaryPinCode;

    public EmployeeAddress() {
    }

    public EmployeeAddress(String permanentStreet, String permanentHouseName, String permanentState, String permanentCity, Integer permanentPinCode, String temporaryStreet, String temporaryHouseNumber, String temporaryState, String temporaryCity, Integer temporaryPinCode) {
        this.permanentStreet = permanentStreet;
        this.permanentHouseName = permanentHouseName;
        this.permanentState = permanentState;
        this.permanentCity = permanentCity;
        this.permanentPinCode = permanentPinCode;
        this.temporaryStreet = temporaryStreet;
        this.temporaryHouseNumber = temporaryHouseNumber;
        this.temporaryState = temporaryState;
        this.temporaryCity = temporaryCity;
        this.temporaryPinCode = temporaryPinCode;
    }

    public String getPermanentStreet() {
        return permanentStreet;
    }

    public void setPermanentStreet(String permanentStreet) {
        this.permanentStreet = permanentStreet;
    }

    public String getPermanentHouseName() {
        return permanentHouseName;
    }

    public void setPermanentHouseName(String permanentHouseName) {
        this.permanentHouseName = permanentHouseName;
    }

    public String getPermanentState() {
        return permanentState;
    }

    public void setPermanentState(String permanentState) {
        this.permanentState = permanentState;
    }

    public String getPermanentCity() {
        return permanentCity;
    }

    public void setPermanentCity(String permanentCity) {
        this.permanentCity = permanentCity;
    }
`
    public Integer getPermanentPinCode() {
        return permanentPinCode;
    }

    public void setPermanentPinCode(Integer permanentPinCode) {
        this.permanentPinCode = permanentPinCode;
    }

    public String getTemporaryStreet() {
        return temporaryStreet;
    }

    public void setTemporaryStreet(String temporaryStreet) {
        this.temporaryStreet = temporaryStreet;
    }

    public String getTemporaryHouseNumber() {
        return temporaryHouseNumber;
    }

    public void setTemporaryHouseNumber(String temporaryHouseNumber) {
        this.temporaryHouseNumber = temporaryHouseNumber;
    }

    public String getTemporaryState() {
        return temporaryState;
    }

    public void setTemporaryState(String temporaryState) {
        this.temporaryState = temporaryState;
    }

    public String getTemporaryCity() {
        return temporaryCity;
    }

    public void setTemporaryCity(String temporaryCity) {
        this.temporaryCity = temporaryCity;
    }

    public Integer getTemporaryPinCode() {
        return temporaryPinCode;
    }

    public void setTemporaryPinCode(Integer temporaryPinCode) {
        this.temporaryPinCode = temporaryPinCode;
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "permanentStreet='" + permanentStreet + '\'' +
                ", permanentHouseName='" + permanentHouseName + '\'' +
                ", permanentState='" + permanentState + '\'' +
                ", permanentCity='" + permanentCity + '\'' +
                ", permanentPinCode=" + permanentPinCode +
                ", temporaryStreet='" + temporaryStreet + '\'' +
                ", temporaryHouseNumber='" + temporaryHouseNumber + '\'' +
                ", temporaryState='" + temporaryState + '\'' +
                ", temporaryCity='" + temporaryCity + '\'' +
                ", temporaryPinCode=" + temporaryPinCode +
                '}';
    }
}
