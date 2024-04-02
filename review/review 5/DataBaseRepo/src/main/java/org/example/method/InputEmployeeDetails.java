package org.example.method;

import org.example.details.Employee;

import java.util.List;

public interface InputEmployeeDetails {
    void create(List<Employee> employee);
    Employee displayBasedOnEmployeeId(String employeeID);
    List<Employee> displayBasedOnPinCode(int pinCode);
    List<Employee> read();
    void closeConnections();
    boolean Validation(List<Employee> employee);

}





