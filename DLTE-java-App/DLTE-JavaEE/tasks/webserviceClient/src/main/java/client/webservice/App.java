package client.webservice;

import soap.dao.FetchAccount;
import soap.dao.SoapServiceService;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SoapServiceService soapServiceService=new SoapServiceService();
        FetchAccount fetchAccount= (FetchAccount) soapServiceService.getSoapServicePort();
        System.out.println("1->Create a user\n2->Find By UserName\n3->Update account");
        System.out.println("Enter your Choice");
        int choice = new Scanner(System.in).nextInt();
        switch(choice){
            case 1:
                System.out.println("Enter the Username");
                String username = scanner.next();
                System.out.println("Enter your Password");
                String password = scanner.next();
                System.out.println("Enter your date of birth");
                String date=scanner.next();
                System.out.println("Enter your Address");
                String Address = scanner.next();
                System.out.println("Enter your email");
                String email = scanner.next();
                System.out.println("Enter your phone number");
                long phoneNumber=scanner.nextLong();
                fetchAccount.createAccount(username,password,date,Address,email, phoneNumber);
                System.out.println("User Created");
                break;
            case 2:
                String user = "shreya";
                List<FetchAccount> accounts = fetchAccount.findUser(user).getuserDetailsList();
                if (accounts.get(0).getuserName() != null) {
                    for (FetchAccount each : accounts) {
                        System.out.println("Username: " + each.getuserName() + " Password: " + each.getpassword() );
                    }
                } else {
                    System.out.println("User Not Found");
                }

                break;
            case 3:
                String userToUpdate = "shreya";
                List<FetchAccount> accountsToUpdate = fetchAccount.findUser(userToUpdate).getuserDetailsList();
                if (!accountsToUpdate.isEmpty()) {
                    FetchAccount accountToUpdate = accountsToUpdate.get(0); // Assuming only one user with the username
                    // Display existing details
                    System.out.println("Existing Details:");
                    System.out.println("Username: " + accountToUpdate.getuserName());
                    System.out.println("Password: " + accountToUpdate.getpassword());

                    String newPassword = "shre";
                    String newAddress = "mudbidri";
                    String newEmailId = "shrey@gmail.com";
                    Long newPhoneNumber = 9886697394L;
                    // Update the account
                    update(
                            accountToUpdate.getuserName(),
                            accountToUpdate.getpassword(),
                            null,
                            accountToUpdate.getaddress(),
                            accountToUpdate.getemailId(),
                            accountToUpdate.getphoneNumber(),
                            newPassword,
                            newAddress,
                            newEmailId,
                            newPhoneNumber
                    );
                    System.out.println("Account updated successfully!");
                } else {
                    System.out.println("User Not Found");
                }
                break;
            default:
                System.out.println("Invalid Choice");
                return;
        }
    }
}