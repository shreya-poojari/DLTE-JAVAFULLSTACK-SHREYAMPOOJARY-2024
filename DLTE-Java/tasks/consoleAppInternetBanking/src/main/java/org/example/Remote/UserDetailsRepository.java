package org.example.Remote;

import org.example.Entity.UserDetails;
import org.example.Exceptions.UserDetailsException;

import java.util.List;

public interface UserDetailsRepository {
    //void save(UserDetails userDetails);
    void addUsers();
    void update(UserDetails userDetails) throws UserDetailsException;
    Object verifyPassword(String username, String password);
}
