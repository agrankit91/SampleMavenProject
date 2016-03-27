package com.bawatech.testproject.repository.impl;

import com.bawatech.testproject.model.User;
import com.bawatech.testproject.repository.UserRepository;

import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultUserRepository implements UserRepository {
    private static final Logger LOG = Logger.getLogger(DefaultUserRepository.class);
    private List<User> userList;
    
    public DefaultUserRepository() {
        userList = new ArrayList<>();
        
        User user1 = new User();
        user1.setFirstName("Ankit");
        user1.setLastName("Agrawal");
        user1.setEmail("ankitagrawal1991@live.com");
        this.userList.add(user1);
        
        User user2 = new User();
        user2.setFirstName("Arpit");
        user2.setLastName("Agrawal");
        user2.setEmail("arpitagrawal92@yahoo.com");
        this.userList.add(user2);
    }
    
    @Override
    public User getUserByEmail(final String email) {
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}