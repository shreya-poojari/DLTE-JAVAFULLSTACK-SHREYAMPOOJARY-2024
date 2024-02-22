package basics.services;
import java.util.Date;
import java.util.Scanner;

public class CreditCardAnalysis {
    public static void main(String[] args) {
        CreditCard[] MYBank = {
                new CreditCard(2348765098129L, "divya", new Date(2032, 5, 25), 875, 478456, new Date(2024, 4, 4), new Date(2024, 4, 10), 3333),
                new CreditCard(9644582159745L, "Ramya", new Date(2026, 4, 15), 576, 648645, new Date(2024, 5, 7), new Date(2024, 5, 20), 2222),
                new CreditCard(3541269752168L, "Sowmya", new Date(2036, 3, 5), 842, 169745, new Date(2024, 6, 24), new Date(2024, 6, 25), 4563),
                new CreditCard(8436125794631L, "bhavya", new Date(2045, 2, 30), 325, 451975, new Date(2024, 7, 14), new Date(2024, 7, 30), 8974),
        };
        CreditCardAnalysis Analysis = new CreditCardAnalysis();
        System.out.println("---------WELCOME---------");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------MENU----------");
            System.out.println("1. Filter Based on Given Limit\n 2.Filter based on date of bill payment\n 3. Update specific pin of customer\n 4. Update the limit of customers those date of bill generation is 5th");
            System.out.println("choose option");
            int choice;

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter the start limit");
                    int startLimit = scanner.nextInt();
                    System.out.println("enter the end limit");
                    int endLimit = scanner.nextInt();
                    CustomerSupport support = new CustomerSupport();
                    Analysis.filterLimit(MYBank, startLimit, endLimit);
                    break;
                case 2:
                    System.out.println("enter the start Date(enter only Date)");
                    int start = scanner.nextInt();
                    System.out.println("enter the to date");
                    int end = scanner.nextInt();
                    Analysis.filterBillPayments(MYBank, start, end);
                    break;
                case 3:
                    System.out.println("enter credit card number");
                    Long cardNumber = scanner.nextLong();
                    System.out.println("enter old pin");
                    Integer oldPin = scanner.nextInt();
                    Integer newPin;
                    for (CreditCard each : MYBank) {
                        if (oldPin.equals((each.getCreditCardPin()))) {
                            System.out.println("Enter New pin");
                            newPin = scanner.nextInt();
                            each.setCreditCardPin(newPin);
                            System.out.println(each.getCreditCardHolder() + " " + each.getCreditCardPin());
                        }
                    }
                    System.out.println("update successful");
                    break;
                case 4:
                    System.out.println("Name oldLimit newLimit");
                    for (CreditCard each : MYBank) {
                        if (each.getDateOfBillGeneration().getDate() == 5) {
                            System.out.println(each.getCreditCardHolder() + " " + each.getCreditCardLimit() + " ");
                            each.setCreditCardLimit((int)(each.getCreditCardLimit() + (each.getCreditCardLimit() * 0.5)));
                            System.out.println(each.getCreditCardLimit());
                        }
                    }
                    break;

                default:
                    System.out.println("-------Thankyou------");
                    System.exit(0);
            }

        }
    }
        public void filterLimit(CreditCard[] customer, int startLimit, int endLimit){
            System.out.println("customers having the creditLimit between" + startLimit + "and" + endLimit);
            for (CreditCard each : customer) {
                if (each.getCreditCardLimit() >= startLimit && each.getCreditCardLimit() <= endLimit)
                    System.out.println(each.getCreditCardHolder() + " " + each.getCreditCardLimit());
            }
        }
        public void filterBillPayments(CreditCard[] customers, int start, int end){
            System.out.println("customers those who made bill payments between" + start + " and " + end);
            for (CreditCard each : customers) {
                if (each.getDateOfBillGeneration().getDate() >= start && each.getDateOfBillPayment().getDate() <= end) {
                    System.out.println(each.getCreditCardHolder() + " " + each.getDateOfBillPayment().getDate());
                }
            }
        }

}
