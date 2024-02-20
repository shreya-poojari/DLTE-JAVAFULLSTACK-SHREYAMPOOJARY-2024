package basics.service;
import java.util.*;
public class numOfDebt {
    public static void main(String[] args) {
        double transaction, primaryBalance, CurrentBalance;
        int number = 10, n = 1, debit = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the balance:");
        primaryBalance = scanner.nextDouble();
        while (number != 0);
        {
            number -= 1;
            System.out.println("enter the new balance amount" + n);
            n += 1;
            CurrentBalance = scanner.nextDouble();
            if (CurrentBalance < primaryBalance) {
                debit += 1;
                CurrentBalance = primaryBalance;
            }
            primaryBalance = CurrentBalance;
        }
        System.out.println("the total number of debit transaction is" + debit);
    }
}