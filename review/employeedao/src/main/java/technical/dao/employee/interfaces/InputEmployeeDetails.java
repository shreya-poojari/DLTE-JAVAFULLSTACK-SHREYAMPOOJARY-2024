package technical.dao.employee.interfaces;

import org.springframework.stereotype.Repository;
import technical.dao.employee.entity.Employee;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface InputEmployeeDetails {
    List<Employee> create(List<Employee> employee) throws SQLException;
    Employee displayBasedOnEmployeeId(String employeeID);
    List<Employee> displayBasedOnPinCode(int pinCode);
    List<Employee> read();
    void closeConnections() throws SQLException;
}
