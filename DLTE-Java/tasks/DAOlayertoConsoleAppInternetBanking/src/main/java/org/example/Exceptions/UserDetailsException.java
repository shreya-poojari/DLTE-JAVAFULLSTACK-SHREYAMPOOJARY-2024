package org.example.Exceptions;

import java.util.ResourceBundle;

public class UserDetailsException extends Throwable {
    public UserDetailsException(){
        super(ResourceBundle.getBundle("userdetails").getString("user.exception"));
    }
    public UserDetailsException(String additionalInfo){
        super(ResourceBundle.getBundle("userdetails").getString("user.exception")+" "+additionalInfo);
    }
}
