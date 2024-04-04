package org.console;

import org.backend.*;
import org.console.entity.EmployeepersonalDetails;
import org.console.exception.EmployeeException;
import org.console.validation.EmployeeValidation;
import org.exception.ConnectionException;
import org.exception.InvalidContactException;
import org.exception.InvalidUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class Console {
    static Logger logger = LoggerFactory.getLogger(Console.class);
    Scanner scanner = new Scanner(System.in);
    ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    static ArrayList<Object> employeeAllDetails = new ArrayList<>();
    Validation validation = new Validation();

    public static void main(String[] args) throws IOException, SQLException {
        MyInterface myInterface;
        myInterface = new EmployeeDB();
        Console employeeConsole = new Console();
        org.console.entity.EmployeepersonalDetails employee = new org.console.entity.EmployeepersonalDetails();
        EmployeePersonalDetails personalDetails2;
        EmployeePersonalDetails permanentAddress;
        EmployeeAddressDetails temporaryAddress;
        EmployeeAddressDetails employeePermanentAddress = new EmployeeAddressDetails();
        EmployeeAddressDetails employeeTemporaryAddress = new EmployeeAddressDetails();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        //Console
        List<EmployeePersonalDetails> myList = new ArrayList<>();
        List<EmployeePersonalDetails> myPinList = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(resourceBundle.getString("app.menu"));
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    do {
                        personalDetails2 = employeeConsole.inputPersonal(employee);
                        System.out.println(personalDetails2);
                        try {
                            String check = myInterface.input(personalDetails2);
                              // System.out.println(resourceBundle.getString(check));
                        } catch (EmployeeException | ConnectionException | InvalidContactException | InvalidUserException exception) {
                            System.out.println(exception);
                        }

                        System.out.println("Do you wish to add another record \n Enter\n yes\n no");
                    } while (scanner.next().equalsIgnoreCase("yes"));
                    break;

                case 2:

                    try {
                        myList = myInterface.display();
                    } catch (ConnectionException exp) {
                        System.out.println(exp);
                    }
                    logger.info(resourceBundle.getString("employee.details"));
                    List<org.console.entity.EmployeepersonalDetails> employeeList = new ArrayList<>();
                    employeeList = employeeConsole.translateList(myList);
                    employeeConsole.displayOutput(employeeList);
                    break;


                case 3: {
                    System.out.println("Enter Pin-code");
                    int pincode = scanner.nextInt();
                    try {
                        myPinList = myInterface.searchByPinCode(pincode);
//                           System.out.println("im here");
                    } catch (ConnectionException exp) {
                        System.out.println(exp);
                    }
                    List<org.console.entity.EmployeepersonalDetails> employeePinList = new ArrayList<>();
                    employeePinList = employeeConsole.translateList(myPinList);
                    employeeConsole.displayOutput(employeePinList);

                }
                default:
                    System.exit(0);
            }
        }
    }


    public EmployeePersonalDetails inputPersonal(org.console.entity.EmployeepersonalDetails employeePersonalDetails1) throws SQLException {
        EmployeePersonalDetails employeePersonalDetails2 = new EmployeePersonalDetails();
        //console entity initialization
        org.console.entity.EmployeeAddressDetails localPermenantAddress = new org.console.entity.EmployeeAddressDetails();
        org.console.entity.EmployeeAddressDetails localtemporaryAddress = new org.console.entity.EmployeeAddressDetails();

        //backend entity declaration
        EmployeeAddressDetails permenantAddress;
        EmployeeAddressDetails temporaryAddress;


        Console employeeConsole = new Console();
        System.out.println("Enter the first name of employee");
        employeePersonalDetails1.setFirstNameOfEmployee(scanner.nextLine());
//        employeePersonalDetails2.setFirstNameOfEmployee(employeePersonalDetails1.getFirstNameOfEmployee());
        while (!EmployeeValidation.isValidUsername(employeePersonalDetails1.getFirstNameOfEmployee())) {
            logger.warn(resourceBundle.getString("app.username.invalid"));
            employeePersonalDetails1.setFirstNameOfEmployee(scanner.nextLine());
//            employeePersonalDetails2.setFirstNameOfEmployee(employeePersonalDetails1.getFirstNameOfEmployee());
        }
        System.out.println("Enter the middle name of employee");
        employeePersonalDetails1.setMiddleNameOfEmployee(scanner.nextLine());
//        employeePersonalDetails2.setMiddleNameOfEmployee(employeePersonalDetails1.getMiddleNameOfEmployee());
        System.out.println("Enter the last name of employee");
        employeePersonalDetails1.setLastNameOfEmployee(scanner.nextLine());
//        employeePersonalDetails2.setLastNameOfEmployee(employeePersonalDetails1.getLastNameOfEmployee());
        while (!EmployeeValidation.isValidLastUsername(employeePersonalDetails1.getLastNameOfEmployee())) {
            logger.warn(resourceBundle.getString("app.username.invalid"));
            employeePersonalDetails1.setLastNameOfEmployee(scanner.nextLine());
//            employeePersonalDetails2.setLastNameOfEmployee(employeePersonalDetails1.getLastNameOfEmployee());
        }
        System.out.println("Please enter 5 digit Employee ID");
        employeePersonalDetails1.setEmployeeID(scanner.nextInt());
        employeePersonalDetails2.setEmployeeID(employeePersonalDetails1.getEmployeeID());
        while (!EmployeeValidation.isValidID(employeePersonalDetails1.getEmployeeID())) { //validating password
            System.out.println(resourceBundle.getString("app.id.invalid"));
            //invalid
            System.out.println(resourceBundle.getString("app.id.format"));
            employeePersonalDetails1.setEmployeeID(scanner.nextInt());
//            employeePersonalDetails2.setEmployeeID(employeePersonalDetails1.getEmployeeID());
        }
        System.out.println("Please enter employee mobile number");
        employeePersonalDetails1.setEmployeeContactNumber(scanner.nextLong());
//        employeePersonalDetails2.setEmployeeContactNumber(employeePersonalDetails1.getEmployeeContactNumber());
        while (!EmployeeValidation.isValidContactNumber(employeePersonalDetails1.getEmployeeContactNumber())) { //validating contact
            // if invalid
            System.out.println(resourceBundle.getString("app.contact.invalid"));
            employeePersonalDetails1.setEmployeeContactNumber(scanner.nextLong());
//            employeePersonalDetails2.setEmployeeContactNumber(employeePersonalDetails1.getEmployeeContactNumber());
        }
        System.out.println("Please enter employee Email Address");
        employeePersonalDetails1.setEmployeeEmail(scanner.next());
//        employeePersonalDetails2.setEmployeeEmail(employeePersonalDetails1.getEmployeeEmail());
        while (!EmployeeValidation.isValidEmail(employeePersonalDetails1.getEmployeeEmail())) {
            System.out.println(resourceBundle.getString("app.mail.invalid"));
            employeePersonalDetails1.setEmployeeEmail(scanner.next());
        }

        employeeConsole.inputAdd(localPermenantAddress);
        permenantAddress = new EmployeeAddressDetails(localPermenantAddress.getHouseName(), localPermenantAddress.getStreetName(), localPermenantAddress.getCity(), localPermenantAddress.getState(), localPermenantAddress.getPincode());
        employeeConsole.inputAdd(localtemporaryAddress);
        temporaryAddress = new EmployeeAddressDetails(localtemporaryAddress.getHouseName(), localtemporaryAddress.getStreetName(), localtemporaryAddress.getCity(), localtemporaryAddress.getState(), localtemporaryAddress.getPincode());
        logger.info(resourceBundle.getString("data.collected"));
        return new EmployeePersonalDetails(employeePersonalDetails1.getFirstNameOfEmployee(), employeePersonalDetails1.getMiddleNameOfEmployee(), employeePersonalDetails1.getLastNameOfEmployee(), employeePersonalDetails1.getEmployeeID(), employeePersonalDetails1.getEmployeeContactNumber(), employeePersonalDetails1.getEmployeeEmail(), permenantAddress, temporaryAddress);
    }

    public org.console.entity.EmployeeAddressDetails inputAdd(org.console.entity.EmployeeAddressDetails employeeAddressDetails1) throws SQLException {
        EmployeeAddressDetails employeeAddressDetails2 = new EmployeeAddressDetails();
        MyInterface myInterface = new EmployeeDB();
        System.out.println(scanner.nextLine());
        System.out.println("Enter Employee address");
        System.out.println("Enter the House Name");
        employeeAddressDetails1.setHouseName(scanner.next());
//        employeeAddressDetails2.setHouseName(employeeAddressDetails1.getHouseName());
        scanner.nextLine();
        System.out.println("Enter street name");
        employeeAddressDetails1.setStreetName(scanner.nextLine());
//        employeeAddressDetails2.setStreetName(employeeAddressDetails1.getStreetName());
        System.out.println("Enter city name");
        employeeAddressDetails1.setCity(scanner.nextLine());
//        employeeAddressDetails2.setCity(employeeAddressDetails1.getCity());
        System.out.println("Enter state name");
        employeeAddressDetails1.setState(scanner.nextLine());
//        employeeAddressDetails2.setState(employeeAddressDetails1.getState());
        System.out.println("Enter pin code");
        employeeAddressDetails1.setPincode(scanner.nextInt());
//        employeeAddressDetails2.setPincode(employeeAddressDetails1.getPincode());
        while (!EmployeeValidation.isValidPin(employeeAddressDetails1.getPincode())) { //validating contact
            // if invalid
            System.out.println(resourceBundle.getString("app.pin.invalid"));
            employeeAddressDetails1.setPincode(scanner.nextInt());
//            employeeAddressDetails2.setPincode(employeeAddressDetails1.getPincode());
        }
        return employeeAddressDetails1;
//        myInterface.(employeeAddressDetails2,value,id);

    }


    public List<EmployeepersonalDetails> translateList(List<EmployeePersonalDetails> detailsList) throws IOException {
        List<org.console.entity.EmployeepersonalDetails> employeeList = new ArrayList<>();
        int sizeEmp = detailsList.size();
        for (int index = 0; index < sizeEmp; index++) {
            employeeList.add(new org.console.entity.EmployeepersonalDetails());
            employeeList.get(index).setFirstNameOfEmployee(detailsList.get(index).getFirstNameOfEmployee());
            employeeList.get(index).setMiddleNameOfEmployee(detailsList.get(index).getMiddleNameOfEmployee());
            employeeList.get(index).setLastNameOfEmployee(detailsList.get(index).getLastNameOfEmployee());
            employeeList.get(index).setEmployeeID(detailsList.get(index).getEmployeeID());
            employeeList.get(index).setEmployeeContactNumber(detailsList.get(index).getEmployeeContactNumber());
            employeeList.get(index).setEmployeeEmail(detailsList.get(index).getEmployeeEmail());
            // employeeList.get(index).setPermenantAddress(empList.get(index).getPermenantAddress());

            org.console.entity.EmployeeAddressDetails address = new org.console.entity.EmployeeAddressDetails();
            address.setHouseName(detailsList.get(index).getPermanentAddress().getHouseName());
            address.setStreetName(detailsList.get(index).getPermanentAddress().getStreetName());
            address.setCity(detailsList.get(index).getPermanentAddress().getCity());
            address.setState(detailsList.get(index).getPermanentAddress().getState());
            address.setPincode(detailsList.get(index).getPermanentAddress().getPincode());

            employeeList.get(index).setPermanentAddress(address);

            org.console.entity.EmployeeAddressDetails tempAddress = new org.console.entity.EmployeeAddressDetails();
            tempAddress.setHouseName(detailsList.get(index).getTemporaryAddress().getHouseName());
            tempAddress.setStreetName(detailsList.get(index).getTemporaryAddress().getStreetName());
            tempAddress.setCity(detailsList.get(index).getTemporaryAddress().getCity());
            tempAddress.setState(detailsList.get(index).getTemporaryAddress().getState());
            tempAddress.setPincode(detailsList.get(index).getTemporaryAddress().getPincode());
            employeeList.get(index).setTemporaryAddress(tempAddress);
        }
        return employeeList;

    }

    public void displayOutput(List<EmployeepersonalDetails> employeeList) {
        int count = 1;
        for (org.console.entity.EmployeepersonalDetails each : employeeList) {
            System.out.println("\nList of Employee " + count);
            count++;
            System.out.println("Name : " + (each.getFirstNameOfEmployee() + each.getMiddleNameOfEmployee() + each.getLastNameOfEmployee()) + "\nEmployeeId " + each.getEmployeeID() + "\nContact Number " + each.getEmployeeContactNumber() + "\nEmail " + each.getEmployeeEmail());
            System.out.println("Permanent Address\n" + each.getPermanentAddress().getHouseName() + "," + each.getPermanentAddress().getStreetName() + "," + each.getPermanentAddress().getCity() + "," + each.getPermanentAddress().getState() + " - " + each.getPermanentAddress().getPincode());
            System.out.println("Temporary Address\n" + each.getTemporaryAddress().getHouseName() + "," + each.getTemporaryAddress().getStreetName() + "," + each.getTemporaryAddress().getCity() + "," + each.getTemporaryAddress().getState() + " - " + each.getTemporaryAddress().getPincode());

        }
    }
}
