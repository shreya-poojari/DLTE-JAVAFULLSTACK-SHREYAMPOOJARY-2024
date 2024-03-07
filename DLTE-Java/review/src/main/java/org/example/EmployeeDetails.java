package org.example;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Scanner;

public class EmployeeDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        while (true) {
            System.out.println("Enter your Choice\n1.Enter employee details\n2. View employee details\n3. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    char answer;
                    do {
                        employeeArrayList.add(readDetails());
                        System.out.println("Do you want to add more? (Y/N)");
                        answer = scanner.next().charAt(0);
                    } while (answer=='Y' || answer=='y');
                    break;
                case 2:
                    displayDetails(employeeArrayList);
                    break;
                case 3: System.exit(0);
            }
            scanner.close();
        }
    }
    public static Employee readDetails() {
        Employee employee = new Employee();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the employee ID");
        employee.setEmployeeID(scanner.nextLong());
        System.out.println("Enter the name of the employee");
        employee.setEmployeeName(readName());
        System.out.println("Enter the mobile number");
        employee.setPhoneNo(scanner.nextLong());
        while (!isValidMobileNumber(employee.getPhoneNo().toString())) {
            System.out.println("Invalid mobile number! Enter again");
            employee.setPhoneNo(scanner.nextLong());
        }
        System.out.println("Enter the email ID");
        employee.setEmailID(scanner.next());
        while (!isValidEmail(employee.getEmailID())) {
            System.out.println("Invalid Email! Enter again");
            employee.setEmailID(scanner.next());
        }
        System.out.println("Enter the temporary address");
        employee.setTemporaryAddress(readAddress());
        System.out.println("Enter the permanent address");
        employee.setPermanentAddress(readAddress());
        return employee;
    }
    public static String readName() {
        String employeeFirstName, employeeMiddleName, employeeLastName;
        String name = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("First Name: ");
        employeeFirstName = scanner.nextLine();
        System.out.print("Middle Name: ");
        employeeMiddleName = scanner.nextLine();
        System.out.print("Last Name: ");
        employeeLastName = scanner.nextLine();
        name = employeeFirstName+" "+employeeMiddleName+" "+employeeLastName;
        return name;
    }
    public static Address readAddress() {
        Address addresses = new Address();
        Scanner scanner = new Scanner(System.in);
        System.out.print("House name: ");
        addresses.setHouseName(scanner.nextLine());
        System.out.print("Area: ");
        addresses.setAreaName(scanner.nextLine());
        System.out.print("City: ");
        addresses.setCity(scanner.nextLine());
        System.out.print("State: ");
        addresses.setState(scanner.nextLine());
        System.out.print("Pincode: ");
        addresses.setPincode(scanner.nextLong());
        return addresses;
    }


    public static void displayDetails(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println("Employee ID: "+employee.getEmployeeID());
            System.out.println("Employee Name: "+employee.getEmployeeName());
            System.out.println("Employee Email: "+employee.getEmailID());
            System.out.println("Employee Mobile No.: "+employee.getPhoneNo());
            System.out.println("Employee Temporary Address: "+employee.getTemporaryAddress());
            System.out.println("Employee Permanent Address: "+employee.getPermanentAddress());
        }
    }
    public static Boolean isValidEmail(String borrowerEmail) {
        String emailExpression = "^[A-Za-z0-9+_.-]+@[a-zA-Z]{3,}+\\.[a-z]{2,}";
        Pattern pattern = Pattern.compile(emailExpression);
        Matcher matcher = pattern.matcher(borrowerEmail);
        return matcher.matches();
    }
    public static Boolean isValidMobileNumber(String mobileNumber) {
        String mobileExpression = "\\d{10}";
        Pattern pattern = Pattern.compile(mobileExpression);
        Matcher matcher = pattern.matcher(mobileNumber);
        return matcher.matches();
    }
}