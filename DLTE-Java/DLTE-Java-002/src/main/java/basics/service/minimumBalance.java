package basics.service;
import java.util.*;
public class minimumBalance {
    public static void main(String[] args) {
        //declare array customerbalance and initialize main method
        int[] customerBalance = new int[20];
        Scanner scanner = new Scanner(System.in);
        for (int index = 0; index < 20; index++) {
            System.out.println("enter " + (index + 1) + "user balance");
            customerBalance[index] = scanner.nextInt();
        }
        updatebalance(customerBalance);//call method update
        System.out.println("updated balances are");
        System.out.println(Arrays.toString(customerBalance));
    }
    //method update
    public static void updatebalance(int[] balance){
       for (int i=0;i<20;i++)
        {
            int currentBalance=balance[i];
            if( currentBalance>=5000 && currentBalance<10000){
                balance[i]-=currentBalance*0.03;
            }
            else if(currentBalance>=1000 && currentBalance<5000)
            {
                balance[i]-=currentBalance*0.05;
            }
        }
    }

}
//declare array customerbalance and initialize main method
//    int[] customerBalance
//        sout

