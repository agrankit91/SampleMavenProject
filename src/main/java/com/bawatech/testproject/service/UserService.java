package com.bawatech.testproject.service;

import com.bawatech.testproject.model.User;

public interface UserService extends BaseService<User, Integer> {
    User getUserByEmail(final String email);
}