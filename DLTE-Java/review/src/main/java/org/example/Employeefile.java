package org.example;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.InflaterInputStream;
public interface Employeefile {
    public void readDetails();
    public void displayDetails();
    public void findEmployeeByPincode(Long pincode);

    EmployeeDetails collect();
    void Employee();
    void readName();
    void readAddress();
    void update(EmployeeDetails employeeDetails);
    void save (EmployeeDetails employeeDetails);

}
