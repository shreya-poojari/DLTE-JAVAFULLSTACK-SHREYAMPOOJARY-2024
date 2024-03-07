package org.example;

import java.util.ResourceBundle;

public class BankException {
    public BankException(){
        System.out.println(ResourceBundle.getBundle("application").getString("bank.data"));
    }
}
