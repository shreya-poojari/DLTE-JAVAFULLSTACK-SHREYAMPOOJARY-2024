package org.example;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Execute {
    public static void main(String[] args){
        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
        Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        GPay gpay=new GPay(987654323456L,678765.00,"shravya","9876");
        Scanner scanner=new Scanner(System.in);
        int count=0;
        while (count<5){
            System.out.println("Enter the biller name");
            String billerName=scanner.next();
            System.out.println("Enter the bill amount");
            Double billAmount = scanner.nextDouble();
            System.out.println("Enter the bill Type");
            String billType=scanner.next();
            try{
                System.out.println("Enter the pin number");
                String Pin=scanner.next();
                gpay.payBill(billerName,billAmount,billType,Pin);
                count=0;
                return;
            }catch (MyBankException exception){
                logger.log(Level.WARNING,exception.toString());
                count++;
                if (count>=5){
                    logger.log(Level.WARNING,"Account blocked.contact your bank");
                    break;
                }
            }
        }
        scanner.close();
    }
}
