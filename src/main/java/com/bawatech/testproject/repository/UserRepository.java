package com.bawatech.testproject.repository;

import com.bawatech.testproject.exception.DataAccessException;
import com.bawatech.testproject.model.User;
import com.bawatech.testproject.repository.impl.BaseRepository;

public interface UserRepository extends BaseRepository<User, Integer> {
    public User getUserByEmail(final String email) throws DataAccessException;
}