package basics.service;

import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class creditCardMain {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        creditCard[] creditCards = {
                new creditCard(76512398769L, "divya", new Date(2024, 4, 25), 998, 45980, new Date(2024, 5, 5), new Date(2024, 5, 6), 9876),
                new creditCard(14569876254L, "kavya", new Date(2024, 4, 25), 675, 65248, new Date(2024, 3, 15), new Date(2024, 3, 16), 3485),
                new creditCard(45213687456L, "Ramya", new Date(2024, 4, 15), 564, 43486, new Date(2024, 6, 25), new Date(2024, 6, 26), 4352),
                new creditCard(54697312846L, "bhavya", new Date(2024, 4, 5), 908, 43214, new Date(2024, 7, 28), new Date(2024, 7, 29), 4569),
        };
        creditCardMain creditAnalysis = new creditCardMain();
        System.out.println("welcome");
        System.out.println(resourceBundle.getString("welcome.message"));
        System.out.println();

        //System.out.println("enter choice 1 for filter on limit & 2 for filter on date");
        Scanner scanner = new Scanner(System.in);

        System.out.println(resourceBundle.getString("menu.title"));
        System.out.println(resourceBundle.getString("menu.options"));
        System.out.println(resourceBundle.getString("choice.entry"));
        int choice;
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                try {
                    System.out.println(resourceBundle.getString("start.limit"));
                    int startlimit = scanner.nextInt();
                    System.out.println(resourceBundle.getString("end.limit"));
                    int endlimit = scanner.nextInt();
                    creditAnalysis.filterLimit(creditCards, startlimit, endlimit);
                } catch (MyCardDateException creditCardLimit) {
                    System.out.println("none");
                    logger.log(Level.WARNING, creditCardLimit.toString());
//                    creditAnalysis.filterLimit(creditCards, 4000, 130000);
                    break;
                }
            case 2:
                try {
                    System.out.println(resourceBundle.getString("start.date"));
                    int start = scanner.nextInt();
                    System.out.println(resourceBundle.getString("end.date"));
                    int end = scanner.nextInt();
                    creditAnalysis.filterLimit(creditCards, start, end);
                   // creditAnalysis.filterdateOfBillPayment(creditCards, new Date(2024, 5, 25), new Date(2024, 8, 17));
                    break;
                } catch (MyCardException dateOfBillPayment) {
                    System.out.println("none");
                    logger.log(Level.WARNING, dateOfBillPayment.toString());
                    // creditAnalysis.filterdateOfBillPayment(creditCards, new Date(2024, 5, 25), new Date(2024, 8, 7));

                }
                break;
            default:
                System.out.println("thankyou");
                scanner.close();
                System.exit(0);
        }
    }

    public void filterLimit(creditCard[] limit, int startlimit, int endlimit) {
        int flag = 0;
        System.out.println("customers having creditlimit between" + startlimit + " and " + endlimit);
        for (creditCard each : limit) {
            if (each.getCreditCardLimit() >= startlimit && each.getCreditCardLimit() <= endlimit) {
                flag = 1;
                System.out.println(each.getCreditCardHolder() + " " + each.getCreditCardLimit());
                System.out.println("the credit card holder " + each.getCreditCardHolder() + " is having the limit within the range of " + startlimit + " & " + endlimit + "the limit is " + each.getCreditCardLimit());
            }
        }
        if (flag == 0) {
            System.out.println("null");
            throw new MyCardException();
        }
    }

    //        else{
//            throw new MyCardException();
//
//        }
//        }
//}
    public void filterdateOfBillPayment(creditCard[] dateOfPayment, int start, int  end) {
        int flag = 0;
        System.out.println("customers who made payment between" + start + " and " + end);
        for (creditCard each : dateOfPayment) {
            if (each.getDateOfBillPayment().getDate() >= start && each.getDateOfBillPayment().getDate() <= end) {
                flag = 1;
                System.out.println(each.getCreditCardHolder() + " " + each.getDateOfBillPayment().getDate());
            }
        }
        if (flag == 1)
            throw new MyCardException();
    }
}
//        if(each.getDateOfBillPayment().before(end) && each.getDateOfBillPayment().after(start)){
//            System.out.println("\n the date of payment ranges from "+start.getDate()+" to "+end.getDate());
//            System.out.println("the credit card holder "+each.getCreditCardHolder()+" has made on time payment mentioned in the above range\nthe date of payment is "+each.getDateOfBillPayment().getDate());
//
//        }
//        else{
//            throw new MyCardDateException();
//        }
//    }
//    }
//}