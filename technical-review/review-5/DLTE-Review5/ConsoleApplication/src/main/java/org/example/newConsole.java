package org.example;



import entity.EmployeeAddressConsole;
import entity.EmployeeBasicDetailsConsole;
import entity.EmployeeConsole;
import org.example.Details.Employee;
import org.example.Details.EmployeeAddress;
import org.example.Details.EmployeeBasicDetails;
import org.example.Details.InputEmployeeDetails;
import org.example.exception.EmployeeNotFoundException;


import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import java.util.*;

import static java.lang.System.exit;
public class newConsole {
        private static ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        public static void main(String[] args) {
            try (Scanner scanner = new Scanner(System.in)) {
                EmployeeConsole employeeConsole;
                EmployeeConsole employeeConsoleId;
                EmployeeConsole employeeConsolePin;
                EmployeeAddressConsole employeePermanentAddressConsole;
                EmployeeAddressConsole employeeTemporaryAddressConsole;
                EmployeeBasicDetailsConsole employeeBasicDetailsConsole;
                InputEmployeeDetails inputEmployeeDetails = new DataBaseRepositoryImplementation();
                Logger logger = LoggerFactory.getLogger(newConsole.class);
                Validation validation = new Validation();
                try {
                    //System.out.println(resourceBundle.getString("greet"));

                    List<Employee> employees = new ArrayList<>();
                    while (true) {
                        boolean validate = false;
                        System.out.println(resourceBundle.getString("menu.display"));
                        System.out.println(resourceBundle.getString("enter.choice"));
                        int choice = 0;
                        do {
                            try {
                                choice = scanner.nextInt();
                                validate = true;
                            }
                            // checking for input format
                            catch (InputMismatchException inputMismatchException) {
                                System.out.println(resourceBundle.getString("Enter.number1"));
                                scanner.nextLine();
                            }
                        } while (!validate);
                        switch (choice) {
                            case 1:
                                do {
                                    System.out.println(resourceBundle.getString("enter.employeeDetails"));
                                    System.out.print(resourceBundle.getString("Enter.name"));
                                    scanner.nextLine();
                                    String name = scanner.nextLine();
                                    System.out.print(resourceBundle.getString("enter.id"));
                                    String id = scanner.nextLine();
                                    System.out.print(resourceBundle.getString("enter.emailId"));
                                    String email = scanner.nextLine();
                                    if (!validation.isValidEmail(email)) {
                                        System.out.println(resourceBundle.getString("invalid.email"));
                                        break;
                                    }
                                    System.out.print(resourceBundle.getString("enter.phone"));
                                    long phoneNumber = Long.parseLong(scanner.nextLine());
                                    if (!validation.isValidPhoneNumber(phoneNumber)) {
                                        System.out.println(resourceBundle.getString("invalid.Phone"));
                                        break;
                                    }
                                    System.out.println(resourceBundle.getString("enter.permanentAddress"));
                                    System.out.print(resourceBundle.getString("enter.address"));
                                    String permanentAddress = scanner.nextLine();
                                    System.out.print(resourceBundle.getString("enter.HouseNumber"));
                                    String permanentHouseNumber = scanner.nextLine();
                                    System.out.print(resourceBundle.getString("enter.city"));
                                    String permanentCity = scanner.nextLine();
                                    System.out.print(resourceBundle.getString("enter.state"));
                                    String permanentState = scanner.nextLine();
                                    System.out.print(resourceBundle.getString("enter.pincode"));
                                    int permanentPinCode = Integer.parseInt(scanner.nextLine());
                                    if (!validation.isValidPin(permanentPinCode)) {
                                        System.out.println(resourceBundle.getString("invalid.Pin"));
                                        break;
                                    }
                                    System.out.println(resourceBundle.getString("enter.temporaryaddress"));
                                    System.out.print(resourceBundle.getString("enter.address"));
                                    String temporaryAddress = scanner.nextLine();
                                    System.out.print(resourceBundle.getString("enter.HouseNumber"));
                                    String temporaryHouseNumber = scanner.nextLine();
                                    System.out.print(resourceBundle.getString("enter.city"));
                                    String temporaryCity = scanner.nextLine();
                                    System.out.print(resourceBundle.getString("enter.state"));
                                    String temporaryState = scanner.nextLine();
                                    System.out.print(resourceBundle.getString("enter.pincode"));
                                    int temporaryPinCode = Integer.parseInt(scanner.nextLine());
                                    if (!validation.isValidPin(temporaryPinCode)) {
                                        System.out.println(resourceBundle.getString("invalid.Pin"));
                                        break;
                                    }
                                    // EmployeebasicDetails basicDetails;
                                    employeeBasicDetailsConsole = new EmployeeBasicDetailsConsole(name, id, email, phoneNumber);
                                    //  EmployeeAddress permanentAddr;
                                    employeePermanentAddressConsole = new EmployeeAddressConsole(permanentAddress, permanentHouseNumber, permanentState, permanentCity, permanentPinCode);
                                    //  EmployeeAddress temporaryAddr ;
                                    employeeTemporaryAddressConsole = new EmployeeAddressConsole(temporaryAddress, temporaryHouseNumber, temporaryState, temporaryCity, temporaryPinCode);
                                    //   basicDetails=translate(employeeBasicDetailsConsole);
                                    //  permanentAddr=translatePermanentAddress(employeePermanentAddressConsole);
                                    //   temporaryAddr=translateTemporaryAddress(employeeTemporaryAddressConsole);
                                    //    Employee employee = new Employee(basicDetails, permanentAddr, temporaryAddr);
                                    employeeConsole = new EmployeeConsole(employeeBasicDetailsConsole, employeePermanentAddressConsole, employeeTemporaryAddressConsole);
                                    //     Employee employee = new Employee(basicDetails, permanentAddr, temporaryAddr);
                                    Employee employee;
                                    employee = translateEmployee(employeeConsole);
                                    List<Employee> employeeInfo = new ArrayList<>();
                                    employeeInfo.add(employee);
                                    inputEmployeeDetails.create(employeeInfo);
                                    System.out.print(resourceBundle.getString("add.more"));
                                } while (scanner.next().equalsIgnoreCase(resourceBundle.getString("yes")));
                                break;
                            case 2:
                                System.out.println(resourceBundle.getString("enter.id"));
                                String employeeId = scanner.next();
                                try {
                                    Employee employee = inputEmployeeDetails.displayBasedOnEmployeeId(employeeId);
                                    employeeConsoleId = translateBack(employee);
                                    System.out.println(employeeConsoleId.displayEmployeeDetails());
                                } catch (EmployeeNotFoundException e) {
                                    System.out.println(e.getMessage());
                                    logger.warn(e.getMessage());
                                }
                                break;
                            case 3:
                                List<Employee> allEmployees = inputEmployeeDetails.read();
                                if (!allEmployees.isEmpty()) {
                                    for (Employee emp : allEmployees) {
                                        employeeConsole = translateBack(emp);
                                        System.out.println(employeeConsole.displayEmployeeDetails());
                                        System.out.println();
                                    }
                                } else {
                                    System.out.println(resourceBundle.getString("employee.not.found"));
                                    logger.warn(resourceBundle.getString("employee.not.found"));
                                }
                                break;
                            case 4:
                                System.out.println(resourceBundle.getString("enter.pincode"));
                                int pinCode = scanner.nextInt();
                                try {
                                    Employee employee = inputEmployeeDetails.displayBasedOnPinCode(pinCode);
                                    employeeConsolePin = translateBack(employee);
                                    System.out.println(employeeConsolePin.displayEmployeeDetails());
                                } catch (EmployeeNotFoundException e) {
                                    System.out.println(e.getMessage());
                                    logger.warn(e.getMessage());
                                }
                                break;
                            case 5:
                                exit(0);
                        }
                    }
                } finally {
                    // Close connections
                    inputEmployeeDetails.closeConnections();
                    scanner.close();
                }
            }
        }
        private static EmployeeConsole translateBack(Employee employee) {
            EmployeeBasicDetailsConsole employeeBasicDetailsConsole = new EmployeeBasicDetailsConsole();
            EmployeeAddressConsole tempAddress = new EmployeeAddressConsole();
            EmployeeAddressConsole permAddress = new EmployeeAddressConsole();
            employeeBasicDetailsConsole.setEmployeeName(employee.getEmployeebasicDetails().getEmployeeName());
            employeeBasicDetailsConsole.setEmployeeId(employee.getEmployeebasicDetails().getEmployeeId());
            employeeBasicDetailsConsole.setEmailId(employee.getEmployeebasicDetails().getEmailId());
            employeeBasicDetailsConsole.setPhoneNumber(employee.getEmployeebasicDetails().getPhoneNumber());
            permAddress.setAddress(employee.getEmployeePermanentAddress().getAddress());
            permAddress.setHouseNumber(employee.getEmployeePermanentAddress().getHouseNumber());
            permAddress.setCity(employee.getEmployeePermanentAddress().getCity());
            permAddress.setState(employee.getEmployeePermanentAddress().getState());
            permAddress.setPinCode(employee.getEmployeePermanentAddress().getPinCode());
            tempAddress.setAddress(employee.getEmployeeTemporaryAddress().getAddress());
            tempAddress.setHouseNumber(employee.getEmployeeTemporaryAddress().getHouseNumber());
            tempAddress.setCity(employee.getEmployeeTemporaryAddress().getCity());
            tempAddress.setState(employee.getEmployeeTemporaryAddress().getState());
            tempAddress.setPinCode(employee.getEmployeeTemporaryAddress().getPinCode());
            return new EmployeeConsole(employeeBasicDetailsConsole, permAddress, tempAddress);
        }

        private static Employee translateEmployee(EmployeeConsole employeeConsole) {
            EmployeeAddress employeeTemporaryAddress = new EmployeeAddress();
            EmployeeAddress employeePermanentAddress = new EmployeeAddress();
            EmployeeBasicDetails employeebasicDetails = new EmployeeBasicDetails();
            employeebasicDetails.setEmployeeName(employeeConsole.getEmployeebasicDetails().getEmployeeName());
            employeebasicDetails.setEmployeeId(employeeConsole.getEmployeebasicDetails().getEmployeeId());
            employeebasicDetails.setEmailId(employeeConsole.getEmployeebasicDetails().getEmailId());
            employeebasicDetails.setPhoneNumber(employeeConsole.getEmployeebasicDetails().getPhoneNumber());
            employeePermanentAddress.setAddress(employeeConsole.getEmployeePermanentAddress().getAddress());
            employeePermanentAddress.setHouseNumber(employeeConsole.getEmployeePermanentAddress().getHouseNumber());
            employeePermanentAddress.setCity(employeeConsole.getEmployeePermanentAddress().getCity());
            employeePermanentAddress.setState(employeeConsole.getEmployeePermanentAddress().getState());
            employeePermanentAddress.setPinCode(employeeConsole.getEmployeePermanentAddress().getPinCode());
            employeeTemporaryAddress.setAddress(employeeConsole.getEmployeeTemporaryAddress().getAddress());
            employeeTemporaryAddress.setHouseNumber(employeeConsole.getEmployeeTemporaryAddress().getHouseNumber());
            employeeTemporaryAddress.setCity(employeeConsole.getEmployeeTemporaryAddress().getCity());
            employeeTemporaryAddress.setState(employeeConsole.getEmployeeTemporaryAddress().getState());
            employeeTemporaryAddress.setPinCode(employeeConsole.getEmployeeTemporaryAddress().getPinCode());
            return new Employee(employeebasicDetails, employeePermanentAddress, employeeTemporaryAddress);
        }
    }