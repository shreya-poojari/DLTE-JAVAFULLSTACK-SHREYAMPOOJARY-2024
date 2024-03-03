package basics.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class cardRecord {

        Lock lock = new ReentrantLock();
        private ArrayList<DebitCard> cardArrayList = new ArrayList<>();
        private Scanner scanner = new Scanner(System.in);

        public void veiwAll () {
            cardArrayList.forEach(System.out::println);
        }
        public void addNewCard (DebitCard card){
            cardArrayList.add(card);
            System.out.println(card + " has inserted into records");
        }
        public String removeExists ( long cardNumber){
            boolean acknowledge = cardArrayList.removeIf(each -> each.getDebitCardNumber().equals(cardNumber));
            return acknowledge ? cardNumber + " has deleted" : cardNumber + " has not deleted";
        }
        public void run () {
            lock.lock();
            System.out.println("welcome " + Thread.currentThread().getName());
            System.out.println("tell us what you wish to perform\n 1.insert\n 2.delete");
            String option = scanner.next();
            switch (option) {
                case "insert":
                    DebitCard debitCard = new DebitCard();
                    System.out.println("enter the card number");
                    debitCard.setDebitCardNumber(scanner.nextLong());
                    System.out.println("enter the card expiry");
                    debitCard.setDebitCardExpiry(new Date(scanner.next()));
                    System.out.println("enter the cvv number");
                    debitCard.setDebitCardCvv(scanner.nextInt());
                    System.out.println("enter the pin");
                    debitCard.setDebitCardPin(scanner.nextInt());
                    addNewCard(debitCard);
                    break;
                case "delete":
                    System.out.println("enter the card number to delete");
                    System.out.println(removeExists(scanner.nextLong()));
                    break;
            }
            veiwAll();
            lock.unlock();
        }


    }
