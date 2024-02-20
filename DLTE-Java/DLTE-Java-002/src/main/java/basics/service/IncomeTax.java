package basics.service;
import java.util.Scanner;
public class IncomeTax {
    public static void main(String[] args){
        double salary=0.0, newtax, oldtax;
        Scanner scanner= new Scanner (System.in);
        System.out.println("Enter salary");
        salary= scanner.nextDouble();
        String choiceUser = "";
        System.out.println("Enter NewRegime or OldRegime");
        choiceUser= scanner.next();
        System.out.println("choiceUser");
        switch(choiceUser){
            case "NewRegime": case "or NewRegime":{
                if (salary <= 250000 && salary >= 0){
                    System.out.println("According to new tax slab no tax to be paid");
                }
                else if (salary <= 500000 && salary > 200000) {
                    newtax = 0.0;
                    oldtax = salary * (5.0 / 100.00);
                    System.out.println("according to new tax slab no tax should be paid is " + newtax);
                }
                else if (salary<=75000 && salary>50000){
                    newtax = salary * (10.00 / 100.00);
                    oldtax = salary * (20.00 / 100.00);
                    System.out.println("According to new tax slab tax should be paid is 10% that is " + newtax);
            }
                else if (salary <=1000000 && salary >750000){
                    newtax = salary * (15.00/100.00);
                    oldtax = salary * (20.00/100.00);
                    System.out.println("According to new tax slab tax should be paid is 15% that "+newtax);
                }
                else if (salary<=1250000 && salary>1000000){
                    newtax = salary * (20.00/100.00);
                    oldtax = salary * (30.00/100.00);
                    System.out.println("Accordimg to new tax slab tax should be paid is 20% that is" +newtax);
                }
                else {
                    newtax = salary * (30.00/100.00);
                    oldtax= salary * (30.00/100.00);
                    System.out.println("According to new tax slab tax should be paid is 30% that is "+newtax);
                }
                break;
            }
            case "OldRegime": case "or OldRegime":{
                if (salary <= 250000 && salary >= 0)
                {
                    System.out.println("According to old tax slab no tax to be paid");
                }
                else if (salary <= 500000 && salary > 200000) {
                    newtax = 0.0;
                    oldtax = salary * (5.0 / 100.00);
                    System.out.println("according to old tax slab tax should be paid is 5% that is " + oldtax);
                }
                else if (salary<=75000 && salary>50000){
                    newtax = salary * (10.00 / 100.00);
                    oldtax = salary * (20.00 / 100.00);
                    System.out.println("According to old tax slab tax should be paid is 20% that is " + oldtax);
                }
                else if (salary <=1000000 && salary >750000){
                    newtax = salary * (15.00/100.00);
                    oldtax = salary * (20.00/100.00);
                    System.out.println("According to old tax slab tax should be paid is 20% that "+oldtax);
                }
                else if (salary<=1250000 && salary>1000000){
                    newtax = salary * (20.00/100.00);
                    oldtax = salary * (30.00/100.00);
                    System.out.println("Accordimg to old tax slab tax should be paid is 30% that is" +oldtax);
                }
                else {
                    newtax = salary * (30.00/100.00);
                    oldtax= salary * (30.00/100.00);
                    System.out.println("According to old tax slab tax should be paid is 30% that is "+oldtax);
                }

            }
        }
    }
}
