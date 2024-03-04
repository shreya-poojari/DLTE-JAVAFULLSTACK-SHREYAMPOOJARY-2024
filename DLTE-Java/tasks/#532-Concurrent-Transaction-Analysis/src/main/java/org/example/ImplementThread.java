package org.example;

public class ImplementThread {
    public static void main(String[] args) throws InterruptedException{
       TransactionAnalysis transactionAnalysis= new TransactionAnalysis();
       Thread thread1=new Thread(transactionAnalysis,"shreya");
       thread1.start();thread1.join();
       Thread thread2=new Thread(transactionAnalysis,"snehal");
       thread2.start();
       Thread thread3=new Thread(transactionAnalysis,"Divya");
       thread3.start();
       Thread thread4=new Thread(transactionAnalysis::displayAllRemarks,"Nandini");
       thread4.start();
        Thread thread5=new Thread(transactionAnalysis::displayAllAmount,"Kavya");
        thread4.start();
        Thread thread6=new Thread(transactionAnalysis::displayTransactionToWhom,"navya");
        thread4.start();
        Thread thread7=new Thread(transactionAnalysis,"sowmya");
        thread3.start();
        Thread thread8=new Thread(transactionAnalysis,"ram");
        thread3.start();
        Thread thread9=new Thread(transactionAnalysis,"ravi");
        thread3.start();
        Thread thread10=new Thread(transactionAnalysis,"Deeksha");
        thread3.start();
    }
}
