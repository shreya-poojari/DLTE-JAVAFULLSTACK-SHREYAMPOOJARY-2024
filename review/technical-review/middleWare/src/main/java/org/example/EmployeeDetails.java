package org.example;

import java.util.List;

public interface EmployeeDetails {
    static void create(List<Employee> employee);
    static Employee displayBasedOnPinCode(int pinCode);
    static List<Employee> read();
}
