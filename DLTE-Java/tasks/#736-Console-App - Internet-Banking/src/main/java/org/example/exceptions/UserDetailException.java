package org.example.exceptions;

import org.example.remotes.UserDetailRepository;

import java.util.ResourceBundle;

public class UserDetailException extends RuntimeException{
    public UserDetailException(){
        super(ResourceBundle.getBundle("userdetails").getString("detail.exception"));
    }
    public UserDetailException(String additionalinfo){
        super(ResourceBundle.getBundle("userdetails").getString("detail.exception")+" "+additionalinfo);
    }
}
