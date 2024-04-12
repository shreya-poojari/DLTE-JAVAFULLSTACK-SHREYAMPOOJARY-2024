package backend.datarepo.details;

import java.util.List;

public interface InputEmployeeDetails {
    List<Employee> create(List<Employee> employee);
    Employee displayBasedOnEmployeeId(String employeeID);
    List<Employee> displayBasedOnPinCode(int pinCode);
    List<Employee> read();
    void closeConnections();
    boolean Validationofdata(List<Employee> employee);

}
