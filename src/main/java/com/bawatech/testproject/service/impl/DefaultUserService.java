package com.bawatech.testproject.service.impl;

import com.bawatech.testproject.exception.DataAccessException;
import com.bawatech.testproject.model.User;
import com.bawatech.testproject.repository.impl.BaseRepository;
import com.bawatech.testproject.service.UserService;

import com.bawatech.testproject.repository.UserRepository;
import com.bawatech.testproject.repository.impl.DefaultUserRepository;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@Service
public class DefaultUserService extends DefaultBaseService<User, Integer> implements UserService {
    private static final Logger LOG = Logger.getLogger(DefaultUserService.class);

    @Autowired
    protected UserRepository userRepository;

    @Override
    public User getUserByEmail(final String email) {
        try {
            User user = this.userRepository.getUserByEmail(email);
            return user;
        } catch (DataAccessException e) {
            LOG.info("Exception occured while getting user.", e);
        }
        return null;
    }
}