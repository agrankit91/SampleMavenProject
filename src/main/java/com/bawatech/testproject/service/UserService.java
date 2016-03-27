package com.bawatech.testproject.service;

import com.bawatech.testproject.model.User;

public interface UserService {
    public User getUserByEmail(final String email);
}