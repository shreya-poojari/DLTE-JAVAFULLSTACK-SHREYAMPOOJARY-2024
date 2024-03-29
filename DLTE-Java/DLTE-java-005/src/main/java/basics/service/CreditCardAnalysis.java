package basics.service;

import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.exit;


public class CreditCardAnalysis {
    public static void main(String[] args) {
        creditCard[] MyBank = {
                new creditCard(8765432123L, "shreya", new Date(2024, 5, 23), 876, 19876, new Date(2024, 1, 30), new Date(2024, 9, 8), 8765),
                new creditCard(8981234567L, "shrava", new Date(2024, 9, 6), 654, 90000, new Date(2024, 3, 11), new Date(2024, 6, 6), 7654),
                new creditCard(9876542345L, "savani", new Date(2024, 6, 13), 687, 60000, new Date(2024, 5, 20), new Date(2024, 3, 23), 6534),
                new creditCard(1987654321L, "siri", new Date(2024, 2, 12), 234, 65432, new Date(2024, 7, 7), new Date(2024, 1, 17), 3245),
        };
        while (true) {
            System.out.println("USER FRIENDLY CREDIT CARD ANALYSIS");
            System.out.println("Choose any of the following:\n1.Find card limit\n2.Find date of bill payment\n3.Exit");
            int choice;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your choice");
            choice = scanner.nextInt();
            CreditCardAnalysis Analysis = new CreditCardAnalysis();
            Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
            switch (choice) {
                case 1:
                    try {
                        Analysis.findCardLimit(MyBank);
                        break;
                    }catch (MyBankCreditCardException cardLimit){
                        logger.log(Level.WARNING,cardLimit.toString());
                        Analysis.findCardLimit(MyBank);
                        break;
                    }
                case 2:
                    System.out.println("Enter the start date");
                    int startdate = scanner.nextInt();
                    System.out.println("Enter end date");
                    int startDate = scanner.nextInt();
                    System.out.println("Enter the end date");
                    int endDate = scanner.nextInt();
                    try{
                        Analysis.findDateOfBillPayment(MyBank, startDate, endDate);
                        break;
                    }
                    catch (MyBankCreditCardException cardLimit){
                        logger.log(Level.WARNING,cardLimit.toString());
                        Analysis.findDateOfBillPayment(MyBank,startdate,endDate);
                        break;
                    }
                case 3:
                  exit(0);
            }
        }
    }
    public void findCardLimit(creditCard[] customers){
        Long StartLimit, EndLimit;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Start Limit");
        StartLimit=scanner.nextLong();
        System.out.println("Enter End Limit");
        EndLimit=scanner.nextLong();
        boolean flag=true;
        for (creditCard each:customers){
            if (each.getCreditCardLimit()>= StartLimit && each.getCreditCardLimit()<=EndLimit){
                flag=false;
                System.out.println(each.getCreditCardHolder()+" has a limit of "+each.getCreditCardLimit()+" ");
            }
        }
        if (flag){
            throw new MyBankCreditCardException();
        }
    }
    public void findDateOfBillPayment(creditCard[] customers,int start,int end){
        System.out.println("customers who made bill payments between "+start+" end "+end);
        boolean flag=true;
        for (creditCard each: customers){
            if (each.getDateOfBilGeneration().getDate()>=start&& each.getDateOfBilGeneration().getDate()<=end){
                flag=false;
                System.out.println(each.getCreditCardHolder()+" "+each.getDateOfBilGeneration().getDate());
            }
        }
        if (flag){
            throw new MyBankCreditCardException();
        }
    }
}



