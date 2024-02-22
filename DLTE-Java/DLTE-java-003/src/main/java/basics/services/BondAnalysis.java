package basics.services;

public class BondAnalysis {
    public static void main(String[] args){
        Bonds BondArray[]={
                new Bonds(1500,8.33,"Payable","Divya",5),
                new Bonds(1500,5.22,"Payable","sowmya",5),
                new Bonds(1500,7.63,"Not-Payable","shruthi",5),
                new Bonds(1500,9.55,"Payable","bhavya",5),
                new Bonds(1500,6.28,"Not-Payable","Raksha",5),
        };
        BondAnalysis Bonds = new BondAnalysis();
        Bonds.sort(BondArray);
    }
    public void sort(Bonds[] BondArray){
        System.out.println("Before sorting Amount");
        for(Bonds each:BondArray){
            System.out.println(each.getInterestRate());
        }
        for( int select=0; select<BondArray.length;select++){
            for(int next=0; next<BondArray.length-select-1; next++){
                if (BondArray[next].getInterestRate().compareTo(BondArray[next+1].getInterestRate())<0){
                    Bonds backup=BondArray[next];
                    BondArray[next]=BondArray[next+1];
                    BondArray[next+1]=backup;
                }
            }
        }
        System.out.println("after sorting");
        for(Bonds each:BondArray){
            System.out.println(each.getInterestRate());
        }
    }
}
