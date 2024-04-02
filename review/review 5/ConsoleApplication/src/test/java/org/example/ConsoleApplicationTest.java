//package org.example;
//
//import org.mockito.Mock;
//import org.example.dbConnection.DataBaseRepositoryImplementation;
//import org.example.details.Employee;
//import org.example.details.EmployeeAddress;
//import org.example.exception.EmployeeNotFoundException;
//import org.junit.Test;
////import org.junit.jupiter.api.BeforeEach;
////import org.junit.jupiter.api.Test;
////import org.mockito.Mock;
////import org.mockito.MockitoAnnotations;
//import org.slf4j.Logger;
//
//import java.util.ArrayList;
//import java.util.List;
//
////import static org.junit.jupiter.api.Assertions.assertEquals;
////import static org.mockito.ArgumentMatchers.anyInt;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//public class ConsoleApplicationTest {
//    @Mock
//    DataBaseRepositoryImplementation databaseRepository;
//
//    @Mock
//    Logger logger;
//
//    @Test
//    public void testDisplayEmployeeById() throws EmployeeNotFoundException {
//        Employee expectedEmployee = new Employee("medhini","tyt","yty");
//        String employeeId = "123";
//
//        // Mocking behavior of databaseRepository
//        when(databaseRepository.displayBasedOnEmployeeId(employeeId)).thenReturn(expectedEmployee);
//
//        // Creating an instance of ConsoleAppNew
//        newConsole consoleApp = new newConsole();
//
//        // Invoking the method to test
//        Employee result = consoleApp.displayEmployeeById(employeeId, databaseRepository, logger);
//
//        // Verifying that the method was called with the correct argument
//        verify(databaseRepository).displayBasedOnEmployeeId(employeeId);
//
//        // Verifying that the logger was not used
//        verifyNoInteractions(logger);
//
//        // Asserting the result
//        assertEquals(expectedEmployee, result);
//    }
//
//    @Test
//    public void testDisplayAllEmployees() {
//        List<Employee> expectedEmployees = new ArrayList<>();
//        // Add expected employees to the list
//
//        // Mocking behavior of databaseRepository
//        when(databaseRepository.read()).thenReturn(expectedEmployees);
//
//        // Creating an instance of ConsoleAppNew
//        newConsole consoleApp = new newConsole();
//
//        // Invoking the method to test
//        List<Employee> result = consoleApp.displayAllEmployees(databaseRepository, logger);
//
//        // Verifying that the method was called
//        verify(databaseRepository).read();
//
//        // Verifying that the logger was not used
//        verifyNoInteractions(logger);
//
//        // Asserting the result
//        assertEquals(expectedEmployees, result);
//    }
//
//    @Test
//    public void testDisplayEmployeesByPincode() throws EmployeeNotFoundException {
//        Employee expectedEmployee = new Employee(/* Provide necessary constructor arguments */);
//        int pinCode = 7878;
//
//        // Mocking behavior of databaseRepository
//        when(databaseRepository.displayBasedOnPinCode(pinCode)).thenReturn(expectedEmployee);
//
//        // Creating an instance of ConsoleAppNew
//        newConsole consoleApp = new newConsole();
//
//        // Invoking the method to test
//        Employee result = consoleApp.displayEmployeesByPincode(pinCode, databaseRepository, logger);
//
//        // Verifying that the method was called with the correct argument
//        verify(databaseRepository).displayBasedOnPinCode(pinCode);
//
//        // Verifying that the logger was not used
//        verifyNoInteractions(logger);
//
//        // Asserting the result
//        assertEquals(expectedEmployee, result);
//    }
//}
//
//}
