package org.example;


import org.example.entity.userDetails;
import org.example.exceptions.UserDetailException;
import org.example.middleware.FileStorageTarget;
import org.example.middleware.UserDetailFileRepository;
import org.example.remotes.StorageTarget;
import org.example.services.UserDetailServices;

import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

import static java.lang.System.exit;
//public static java.lang.System.exit;

public class App {
    private static StorageTarget storageTarget;
    private static UserDetailServices services;
    private static Scanner scanner = new Scanner(System.in);
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    private static userDetails UserDetail;
    private static Logger logger = Logger.getLogger(UserDetailFileRepository.class.getName());

    public static void main(String[] args) {
        int option;
        String username, password;
        storageTarget = new FileStorageTarget();
        services = new UserDetailServices(storageTarget);
        //menu
        System.out.println(resourceBundle.getString("app.login.menu"));
        option = scanner.nextInt();
        services.callAddUsers();
        if (option == 1) {
            //login
            System.out.println("Enter user name");
            username = scanner.next();
            System.out.println("enter password");
            password = scanner.next();
            UserDetail = services.callVerifyPassword(username, password);
            if (UserDetail != null) {
                while (true) {
                    System.out.println(resourceBundle.getString("app.dashboard.menu"));
                    option = scanner.nextInt();
                    switch (option) {
                        case 1:
                            updateUserDetails();
                            break;
                        case 6:
                            System.out.println("Thankyou for choosing us");
                            exit(0);
                        default:
                            System.out.println("Invalid option please try again");
                    }
                }
            } else {
                System.out.println("Login failed\n Exiting...");
            }
        }
    }


private static void updateUserDetails(){
    System.out.println("Enter the details you wish to update among\npassword\n address\nemail\nphone");
    String userInput=scanner.next();
    String[] properties = userInput.split(",");
    int size = properties.length;
    for (int index=0;index<size;index++){
        if (properties[index].equalsIgnoreCase("password")){
            System.out.println("enter old pasword");
            scanner.nextLine();
            if (UserDetail.getPassword().equals(scanner.nextLine())) {
                System.out.println("set new password");
                UserDetail.setPassword(scanner.nextLine());
            }else{
                System.out.println("password cant be set");
                logger.log(Level.WARNING,UserDetail.getUserName()+resourceBundle.getString("update.failed"));
                exit(0);
            }
        }
        if (properties[index].equalsIgnoreCase("address")){
            System.out.println("Enter the new address");
            scanner.nextLine();
            UserDetail.setAddress(scanner.nextLine());
        }
        if (properties[index].equalsIgnoreCase("email")){
            System.out.println("enter the email");
            UserDetail.setEmailId(scanner.nextLine());
        }
        try{
            if (properties[index].equalsIgnoreCase("phone")){
                System.out.println("enter new phone number");
                UserDetail.setPhoneNumber(scanner.nextLong());
            }
        }catch (NullPointerException exception){
            exception.printStackTrace();
        }
    }
    try{
        services.callUpdate(UserDetail);
        logger.log(Level.INFO,UserDetail.getUserName()+resourceBundle.getString("user.update.done"));
    }catch(UserDetailException exception){
        System.out.println("failed to update user details: "+exception.getMessage());
    }
}

}