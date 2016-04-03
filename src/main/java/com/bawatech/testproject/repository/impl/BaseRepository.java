package com.bawatech.testproject.repository.impl;

import com.bawatech.testproject.exception.DataAccessException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ankit on 4/2/2016.
 */
public interface BaseRepository<T, PK extends Serializable> {
    PK save(T newInstance) throws DataAccessException;

    void update(T transientObject) throws DataAccessException;

    void saveOrUpdate(T transientObject) throws DataAccessException;

    void saveOrUpdateAll(List<T> transientObjects) throws DataAccessException;

    void delete(T persistentObject) throws DataAccessException;

    void delete(PK... id) throws DataAccessException;

    T findById(PK id) throws DataAccessException;

    List<T> findAll() throws DataAccessException;
}
