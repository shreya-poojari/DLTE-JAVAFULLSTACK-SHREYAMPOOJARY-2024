package basics.services;
import java.util.Date;

public class CustomerSupport {
    public static void main(String[] argd){
        //CreditCard[] MYBank= new CreditCard[10];

        CreditCard[] MYBank={
                new CreditCard(2348765098129L,"divya",new Date(2032,5,25),875,478456,new Date(2024,4,4),new Date(2024,4,10),3333),
                new CreditCard(9644582159745L,"Ramya",new Date(2026,4,15),576,648645,new Date(2024,5,7),new Date(2024,5,20),2222),
                new CreditCard(3541269752168L,"Sowmya",new Date(2036,3,5),842,169745,new Date(2024,6,24),new Date(2024,6,25),4563),
                new CreditCard(8436125794631L,"bhavya",new Date(2045,2,30),325,451975,new Date(2024,7,14),new Date(2024,7,30),8974),

        };
        CustomerSupport support=new CustomerSupport();
        support.findEarlyExpire(MYBank);
        support.findBillDate(MYBank,new Date(2024,3,5),new Date(2024,3,18));
        support.list(MYBank);
        support.sortingCustomers(MYBank);
        support.list(MYBank);


    }
    public void findEarlyExpire(CreditCard[] customers){
        for (CreditCard each:customers){
            if (each.getCreditCardExpiry().before(new Date(2030,01,01))){
                System.out.println(each.getCreditCardHolder()+"your credit card "+each.getCreditCardNumber()+"needs to be upgraded");
            }
        }
    }
    public void findBillDate(CreditCard[] customers, Date Start, Date end){
        System.out.println("customers those having bill date between " +Start.getDate()+" and "+end.getDate());
        for (CreditCard each:customers){
            if (each.getDateOfBillGeneration().getDate()>=Start.getDate()&&each.getDateOfBillGeneration().getDate()<=end.getDate()){
                System.out.println(each.getCreditCardHolder()+" "+each.getDateOfBillGeneration().getDate());
            }
        }
    }
    public void list(CreditCard[] customers){
        System.out.println("Available customers");
        for (CreditCard each:customers){
            System.out.println(each);
        }
    }
    public void sortingCustomers(CreditCard[] customers){
        CreditCard backup=null;
        for (int select=0; select<customers.length;select++){
            for (int next=select+1;next<customers.length;next++){
                if (customers[select].getCreditCardHolder().compareTo(customers[next].getCreditCardHolder())>0){
                    backup=customers[select];
                    customers[select]=customers[next];
                    customers[next]=backup;
                }
            }
        }
    }
}
