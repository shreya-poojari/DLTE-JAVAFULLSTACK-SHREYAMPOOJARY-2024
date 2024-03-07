package org.example.exceptions;

import org.example.remotes.UserDetailRepository;

import java.util.ResourceBundle;

public class UserDetailException extends RuntimeException{
    public UserDetailException(){
        super(ResourceBundle.getBundle("userdetail").getString("detail.exception"));
    }
    public UserDetailException(String additionalinfo){
        super(ResourceBundle.getBundle("userdetail").getString("detail.exception")+" "+additionalinfo);
    }
}
