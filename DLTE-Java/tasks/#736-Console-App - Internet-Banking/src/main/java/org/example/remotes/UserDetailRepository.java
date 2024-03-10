package org.example.remotes;

import org.example.entity.userDetails;
import java.util.List;

public interface UserDetailRepository {
    void save(userDetails UserDetail);
    void update(userDetails UserDetail);
    void addUsers();
    Object verifyPassword(String username, String password);

    List<userDetails> getAllUserDetails();
}
