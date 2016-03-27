package com.bawatech.testproject.repository;

import com.bawatech.testproject.model.User;

public interface UserRepository {
    public User getUserByEmail(final String email);
}