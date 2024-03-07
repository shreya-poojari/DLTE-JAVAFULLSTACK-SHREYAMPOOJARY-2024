package org.example.services;

import org.example.entity.userDetails;
import org.example.exceptions.UserDetailException;
import org.example.middleware.UserDetailFileRepository;
import org.example.remotes.UserDetailRepository;
import org.example.remotes.StorageTarget;

import java.util.List;

public class UserDetailServices {
    UserDetailRepository userDetailRepository;
    public UserDetailServices(StorageTarget storageTarget){
        userDetailRepository=storageTarget.getUserDetailRepository();
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
}
