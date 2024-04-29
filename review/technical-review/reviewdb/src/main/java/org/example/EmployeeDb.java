//package org.example;
//
//import org.slf4j.Logger;
//
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//import java.util.Scanner;
//
//public class EmployeeDb {
//    static ArrayList<Object> employeeArray = new ArrayList<>();
//    static Logger logger = LoggerFactory.getLogger(EmployeeManagementApp.class);
//    ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
//    Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        EmployeeDb app = new EmployeeDb();
//      //  OperationOnEmployee operationOnEmployee = new OperationOnEmployee();
//
//        while (true) {
//            System.out.println(app.resourceBundle.getString("app.menu"));
//            int choice = app.scanner.nextInt();
//            app.scanner.nextLine();
//
//            switch (choice) {
//                case 1:
//                    try {
//                        EmployeePersonalDetails personalDetails = app.inputEmployeePersonalDetails();
//                        employeeArray.add(personalDetails);
//                        EmployeeAddressDetails addressDetails = app.inputEmployeeAddressDetails();
//                        employeeArray.add(addressDetails);
//                        operationOnEmployee.writeIntoFile(employeeArray);
//                        logger.info(app.resourceBundle.getString("write.ok"));
//                        System.out.println("Total employees: " + employeeArray.size());
//                    } catch (EmployeeException e) {
//                        throw new EmployeeException();
//                    }
//                    break;
//                case 2:
//                    System.out.println("Displaying the employee list:");
//                    try {
//                        ArrayList<Object> array = operationOnEmployee.readFromFile();
//                        logger.info(app.resourceBundle.getString("display.ok"));
//                        System.out.println("Total employees: " + array.size());
//                        // Display employee details here
//                    } catch (EmployeeException e) {
//                        throw new EmployeeException();
//                    }
//                    break;
//                // Add other menu options as needed
//                default:
//                    System.out.println("Invalid choice. Please select a valid option.");
//            }
//        }
//    }
//
//}
