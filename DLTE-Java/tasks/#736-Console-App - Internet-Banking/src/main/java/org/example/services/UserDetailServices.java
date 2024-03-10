package org.example.services;

import org.example.entity.userDetails;
import org.example.exceptions.UserDetailException;
import org.example.remotes.UserDetailRepository;
import org.example.remotes.StorageTarget;

public class UserDetailServices {
    UserDetailRepository userDetailRepository;
    StorageTarget storageTarget;
    public UserDetailServices(StorageTarget storageTarget){
        userDetailRepository=storageTarget.getUserDetailRepository();
    }
    public void callAddUsers(){
        try{
            userDetailRepository.addUsers();
        }catch(Exception exception){

        }
    }
    public void callSave(userDetails UserDetail){
        try{
            userDetailRepository.save(UserDetail);
        }catch (UserDetailException userDetailException){
            throw userDetailException;
        }
    }
    public void callUpdate(userDetails UserDetail){
        try{
            userDetailRepository.update(UserDetail);
        }catch (UserDetailException userDetailException){
            throw userDetailException;
        }
    }
    public userDetails callVerifyPassword(String username, String password){
        try{
            return (userDetails) userDetailRepository.verifyPassword(username, password);
        }catch(Exception exception){
            return null;
        }
    }
}
