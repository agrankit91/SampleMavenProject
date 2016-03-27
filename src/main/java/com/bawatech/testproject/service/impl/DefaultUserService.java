package com.bawatech.testproject.service.impl;

import com.bawatech.testproject.model.User;
import com.bawatech.testproject.service.UserService;

import com.bawatech.testproject.repository.UserRepository;
import com.bawatech.testproject.repository.impl.DefaultUserRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DefaultUserService implements UserService {
    @Autowired
    protected UserRepository userRepository;
    
    @Override
    public User getUserByEmail(final String email) {
        return this.userRepository.getUserByEmail(email);
    }
}