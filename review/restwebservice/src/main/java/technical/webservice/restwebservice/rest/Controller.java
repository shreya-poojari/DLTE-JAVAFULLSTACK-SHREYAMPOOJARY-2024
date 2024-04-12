package technical.webservice.restwebservice.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import technical.dao.employee.entity.Employee;
import technical.dao.employee.exception.EmployeeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import technical.webservice.restwebservice.services.Implementation;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class Controller {
    @Autowired
    private Implementation employeeRepository;

    @PostMapping("/create")
    public ResponseEntity<List<Employee>> createEmployees(@RequestBody List<Employee> employees) {
        try {
            List<Employee> createdEmployees = employeeRepository.create(employees);
            return new ResponseEntity<>(createdEmployees, HttpStatus.CREATED);
        } catch (EmployeeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("allEmployee")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        try {
            List<Employee> employees = employeeRepository.read();
            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (EmployeeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employeeId{employeeId}")
    public ResponseEntity<Employee> displayBasedOnEmployeeId(@PathVariable String employeeId) {
        try {
            Employee employee = employeeRepository.displayBasedOnEmployeeId(employeeId);
            if (employee == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (EmployeeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pincode/{pinCode}")
    public ResponseEntity<List<Employee>> displayBasedOnPinCode(@PathVariable int pinCode) {
        try {
            List<Employee> employees = employeeRepository.displayBasedOnPinCode(pinCode);
            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (EmployeeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
