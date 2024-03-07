package basics.service;

public class accountAnalysis {
    public static void main(String[] args){
        DebitCard[] debitCardCustomer = new DebitCard[5];
        debitCardCustomer[0]= new DebitCard(32145698745L,"shreya",98765.00,98736120841784L,7653);
        debitCardCustomer[0].amountWithdraw();

        System.out.println("UPI Bill Payment");
        gpay[] gpaycustomer= new gpay[5];
        gpaycustomer[0]= new gpay(983456987L,"ShreyaPoojary", 55998.00,"ShreyaM",8567);

        gpaycustomer[0].payBills("snehal",29876.00,"friend");
    }
}
