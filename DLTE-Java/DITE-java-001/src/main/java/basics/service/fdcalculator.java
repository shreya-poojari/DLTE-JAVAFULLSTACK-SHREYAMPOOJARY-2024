package basics.service;
import java.util.Scanner;
public class fdcalculator {
    public static void main(String[] args){
        Long amount=0L, intrestrate=0L;
        Integer year=0;
        Float interest, maturityAmount;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the principle amount");
        amount=scanner.nextLong();
        System.out.println("Enter the intrest rate");
        intrestrate= scanner.nextLong();
        System.out.println("Enter number of years");
        year=scanner.nextInt();
        float rate;
        rate= (float) intrestrate/100;
        interest=(float) amount* rate *year;
        maturityAmount= (float)amount+interest;
        System.out.println("interest earner:"+interest+" Total number of amount"+amount+" after "+year+" is Rs:"+maturityAmount);
    }
}
