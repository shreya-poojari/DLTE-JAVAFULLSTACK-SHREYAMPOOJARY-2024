package org.example;

import java.util.ResourceBundle;

public class AccoutNotFoundException extends RuntimeException {
    //    private static String message;
//    static {
//        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
//        message=resourceBundle.getString("exception.account");
//    }
    public AccoutNotFoundException(){
//        super(message);
        super(ResourceBundle.getBundle("application").getString("exception.account"));
    }
}
