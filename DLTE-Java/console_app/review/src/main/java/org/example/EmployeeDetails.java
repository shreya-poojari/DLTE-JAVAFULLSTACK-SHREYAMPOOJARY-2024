//package org.example;
//import java.util.*;
//import java.util.logging.Logger;
//
//import java.util.Scanner;
//
//public class EmployeeDetails implements EmployeeInterface {
//    static ResourceBundle resourceBundle = ResourceBundle.getBundle("employee");
//    static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
//    static Scanner scanner = new Scanner(System.in);
//    static EmployeePersonalDetails employee;
//    static EmployeeAddressDetails employeePermanentAddress;
//    static EmployeeAddressDetails employeeTemporaryAddress;
//    public static ArrayList<EmployeePersonalDetails> arrayListEmployee = new ArrayList<>();
//    public static ArrayList<EmployeeAddressDetails> arrayListPermanentAddress = new ArrayList<>();
//    public static ArrayList<EmployeeAddressDetails> arrayListTemporaryAddress = new ArrayList<>();
//    public  List<Object> objects = new ArrayList<>();
//    public EmployeeAddressDetails permanentAddress,tempAddress;
//
//    FileRepository fileRepository = new FileRepository();
//    public static void main(String[] args) {
//        System.out.println("---Welcome to My Bank---");
//        EmployeeDetails employeeRecords = new EmployeeDetails();
//        while(true){
//
//            displayMenu();
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//            switch(choice){
//                case 1: employeeRecords.employeeDetails();
//                    break;
//                case 2: employeeRecords.employeeOutputDetails();
//                    System.out.println("Do you want to enter details for another employee?(Yes/No)");
//                    String outputChance = scanner.nextLine();
//                    if(outputChance.equalsIgnoreCase("yes")){
//                        continue;
//                    }else{
//                        return;
//                    }
//                case 3: System.out.println("Exited!!");
//                    return;
//
//                default:
//                    System.out.println("Invalid choice");
//                    return;
//
//            }
//        }
//
//    }
//    private  static void displayMenu(){
//        System.out.println("1->Insert  Employee Details");
//        System.out.println("2->View Employee");
//        System.out.println("3->Exit");
//        System.out.println("4->Read the file");
//        System.out.println("Enter Your choice");
//    }
//    @Override
//    public void employeeDetails(){
//        while(true){
//            System.out.println("Enter the Employee first Name");
//            String firstName = scanner.nextLine();
//            System.out.println("Enter the Employee middle Name");
//            String middleName = scanner.nextLine();
//            System.out.println("Enter the Employee last Name");
//            String lastName = scanner.nextLine();
//            System.out.println("Enter the Employee ID");
//            Integer empID = scanner.nextInt();
//            System.out.println("Enter the Employee Mobile Number");
//            Long mobileNumber = scanner.nextLong();
//            System.out.println("Enter the Employee email ID");
//            String emailID = scanner.next();
//            employee = new EmployeePersonalDetails(firstName,middleName,lastName,empID,mobileNumber,emailID);
//            arrayListEmployee.add(employee);
//
//            employeePermanentAddress();
//
//            employeeTemporaryAddress();
//
//
//
//            System.out.println("Do you want to enter details for another employee?(Yes/No)");
//            String chance = scanner.next();
//            scanner.nextLine();
//            if(!chance.equalsIgnoreCase("yes")){
//                return;
//            }
//            fileRepository.writeFileEmployee(arrayListEmployee);
//            fileRepository.writeFileAddress(arrayListPermanentAddress,arrayListTemporaryAddress);
//
//        }
//
//    }
//
//    @Override
//    public void employeePermanentAddress() {
//
//        scanner.nextLine();
//        System.out.println("Enter the Employee permanent address");
//        String permanentAddress = scanner.nextLine();
//        System.out.println("Enter the Employee permanent House Name");
//        String permanentHouse = scanner.nextLine();
//        System.out.println("Enter the Employee permanent Street Name");
//        String permanentStreet = scanner.nextLine();
//        System.out.println("Enter the Employee permanent city Name");
//        String permanentCity = scanner.nextLine();
//        System.out.println("Enter the Employee permanent State Name");
//        String permanentState = scanner.nextLine();
//        System.out.println("Enter the Employee permanent Pin Code");
//        Integer permanentPinCode = scanner.nextInt();
//        employeePermanentAddress = new EmployeeAddressDetails(permanentAddress,permanentHouse,permanentStreet,permanentCity,permanentState,permanentPinCode);
//        arrayListPermanentAddress.add(employeePermanentAddress);
//
//    }
//
//    @Override
//    public void employeeTemporaryAddress() {
//        scanner.nextLine();
//        System.out.println("Enter the Employee Temporary address");
//        String temporaryAddress = scanner.nextLine();
//        System.out.println("Enter the Employee Temporary House Name");
//        String temporaryHouse = scanner.nextLine();
//        System.out.println("Enter the Employee Temporary Street Name");
//        String temporaryStreet = scanner.nextLine();
//        System.out.println("Enter the Employee Temporary city Name");
//        String temporaryCity = scanner.nextLine();
//        System.out.println("Enter the Employee Temporary State Name");
//        String temporaryState = scanner.nextLine();
//        System.out.println("Enter the Employee Temporary Pin Code");
//        Integer temporaryPinCode = scanner.nextInt();
//        employeeTemporaryAddress = new EmployeeAddressDetails(temporaryAddress,temporaryHouse,temporaryStreet,temporaryCity,temporaryState,temporaryPinCode);
//        arrayListTemporaryAddress.add(employeeTemporaryAddress);
//    }
//
//    @Override
//    public void employeeOutputDetails() {
//        if (arrayListEmployee.isEmpty()) {
//            System.out.println("No Employees to display");
//            return;
//        } else {
//            int counter = 0;
//            ArrayList<EmployeePersonalDetails> employeeOutput= fileRepository.readEmployee();
//            ArrayList<EmployeeAddressDetails> employeePermanentOutput = fileRepository.readPermanentAddress();
//            ArrayList<EmployeeAddressDetails> employeeTemporaryOutput = fileRepository.readTemporaryAddress();
//
//            for (EmployeePersonalDetails each : employeeOutput) {
//                EmployeePersonalDetails emp = employeeOutput.get(counter);
////
//                System.out.println("\nThe Employee " + (counter + 1) + " details are: ");
//                System.out.println("Name: " + emp.getFirstName() + " " + emp.getMiddleName() + " " + emp.getLastName());
//                System.out.println("Employee ID: " + emp.getEmployeeID());
//                System.out.println("Employee Mobile Number: " + emp.getPhoneNo());
//                System.out.println("Employee Email ID : " + emp.getEmailID());
////                System.out.println("Name: " + each.getFirstName() + " " + each.getMiddleName() + " " + each.getLastName());
////                System.out.println("Employee ID: " + each.getEmpID());
////                System.out.println("Employee Mobile Number: " + each.getMobileNumber());
////                System.out.println("Employee Email ID : " + each.getEmailID());
//
//                System.out.println(employeeOutput);
//                System.out.println("\nEmployee " + (counter + 1) + " Permanent Details ");
//                System.out.println(employeePermanentOutput);
//                permanentAddress = employeePermanentOutput.get(counter);
//                System.out.println("Employee House Name: " + permanentAddress.getHouseName());
//                System.out.println("Employee Street Name: " + permanentAddress.getAreaName());
//                System.out.println("Employee City Name: " + permanentAddress.getCity());
//                System.out.println("Employee State Name: " + permanentAddress.getState());
//                System.out.println("Employee Pin Code :" + permanentAddress.getPincode());
////
////
//                System.out.println("\nEmployee " + (counter + 1) + " Temporary Details ");
//                tempAddress = employeeTemporaryOutput.get(counter);
//                System.out.println("Employee House Name: " + tempAddress.getHouseName());
//                System.out.println("Employee Street Name: " + tempAddress.getAreaName());
//                System.out.println("Employee City Name: " + tempAddress.getCity());
//                System.out.println("Employee State Name: " + tempAddress.getState());
//                System.out.println("Employee Pin Code :" + tempAddress.getPincode());
//                counter++;
//            }
//        }
//    }
//
//}