package com.bawatech.testproject.service;

import com.bawatech.testproject.exception.DataAccessException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ankit on 4/3/2016.
 */
public interface BaseService<T, PK extends Serializable> {
    PK save(T newInstance) throws DataAccessException;

    void update(T object) throws DataAccessException;

    void saveOrUpdate(T object) throws DataAccessException;

    void saveOrUpdateAll(List<T> object) throws DataAccessException;

    void delete(T object) throws DataAccessException;

    T get(PK id) throws DataAccessException;

    List<T> getAll() throws DataAccessException;
}
