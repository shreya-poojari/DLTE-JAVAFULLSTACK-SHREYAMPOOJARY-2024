package basics.services;

import  java.util.Date;
import java.util.Scanner;

public class transactionAnalysis {
public static void main(String[] args){

transaction[] MYBank = {
        new transaction(12345.90, "Divya",new Date(2024, 5,25), "emergency"),
        new transaction(34587.26, "bhavya",new Date(2024, 4,15), "food"),
        new transaction(76495.25, "sowmya",new Date(2024, 3,31), "family"),
        new transaction(34851.25, "ramya",new Date(2024, 7,12), "education"),
        new transaction(12875.23, "kavya",new Date(2024, 6,9), "bill"),
};
Scanner scanner = new Scanner(System.in);
transactionAnalysis analysis= new transactionAnalysis();
analysis.rangeDate(MYBank,new Date(2024,3,25),new Date(2024, 12, 25));
analysis.leastAmount(MYBank);
analysis.highestAmount(MYBank);
analysis.noOftxnOnBenificiary(MYBank, "education");
analysis.noOftxnOnBenificiary(MYBank, "emergency");
analysis.filterBasedOnRemark(MYBank, "emergency");


    System.out.println("------Before starting");
    analysis.printValue(MYBank);

    analysis.beneficiaryDecending(MYBank);
    System.out.println("------After Sorting--------");
    analysis.printValue(MYBank);

    System.out.println("------Before starting");
    analysis.printValue(MYBank);
    analysis.amountacending(MYBank);

    System.out.println("------After Sorting--------");
    analysis.printValue(MYBank);
}
public void rangeDate(transaction[] array, Date start,Date end){
    System.out.println("Transactions made in between"+start.getDate()+" and "+end.getDate());
    for (transaction each:array){
        if (each.getTransactionDate().getDate() >= start.getDate() && each.getTransactionDate().getDate()<=end.getDate()){
            System.out.println("the amount"+each.getTransactionAmount()+"rs was transferred to "+each.getTransactionTo()+" for the purpose "+each.getRemarks()+" on "+each.getTransactionDate());
        }
    }
}
public void leastAmount(transaction[] customer){
    transaction backup = null;
    for (int select = 0; select<customer.length; select++){
        for (int next= select+1; next<customer.length; next++){
            if (customer[select].getTransactionAmount().compareTo(customer[next].getTransactionAmount())>0){
                backup = customer[select];
                customer[select]=customer[next];
                customer[next]=backup;
            }
        }
    }
    System.out.println("the least amount transferred is "+customer[0].getTransactionAmount());
}
public void highestAmount(transaction[] customer){
    transaction backup= null;
    for (int select = 0; select<customer.length; select++){
    for (int next= select+1; next<customer.length; next++) {
        if (customer[select].getTransactionAmount().compareTo(customer[next].getTransactionAmount())>0){
            backup = customer[select];
            customer[select]=customer[next];
            customer[next]=backup;
        }
    }
    }
    System.out.println("the maximum amount tranasferred is "+customer[customer.length-1].getTransactionAmount());
}
public void noOftxnOnBenificiary(transaction[] array, String beneficiary){
    int countNoOfTransaction = 0;
    for (transaction each: array){
        if (each.getRemarks().equals(beneficiary)){
            countNoOfTransaction += 1;
        }
    }
    System.out.println("based on "+beneficiary+" "+countNoOfTransaction+" transactions performed");
}
public void  filterBasedOnRemark(transaction[] array, String beneficiary){
    for (transaction each: array){
        if (each.getRemarks().equals(beneficiary)){
            System.out.println("on "+each.getRemarks()+" beneficiary the following transactions made");
            for (transaction each1: array){
                if (each1.getRemarks().equals(beneficiary)){
                    System.out.println("transaction amount of "+each1.getTransactionTo()+" on "+each1.getTransactionDate());
                }
            }
            break;
        }
    }
}

public void printValue(transaction[] array){
    for (transaction each:array){
        System.out.println("\n");
        System.out.println(each);
    }
}
public void beneficiaryDecending(transaction[] array){
    transaction backup = null;
    for (int select = 0; select < array.length; select++){
        for (int next = 0; next <array.length-next-1; next++){
            if (array[next+1].getRemarks().compareTo(array[next].getRemarks())>0){
                backup= array[next];
                array[next] = array[next+1];
                array[next+1] = backup;
            }
        }
    }
}
public void amountacending(transaction[] array){
    transaction backup = null;
    for (int select = 0; select < array.length; select++){
        for (int next = 0; next <array.length-next-1; next++){
            if (array[next+1].getRemarks().compareTo(array[next].getRemarks())<0){
                backup = array[next];
                array[next] = array[next+1];
                array[next+1] = backup;
            }
        }
    }
}
}
