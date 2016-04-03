package com.bawatech.testproject.service.impl;

import com.bawatech.testproject.exception.DataAccessException;
import com.bawatech.testproject.repository.impl.BaseRepository;
import com.bawatech.testproject.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ankit on 4/3/2016.
 */
public class DefaultBaseService<T, PK extends Serializable> implements BaseService<T, PK> {

    @Autowired
    private BaseRepository<T, PK> baseRepository;

    @Override
    public PK save(T newInstance) throws DataAccessException {
        return baseRepository.save(newInstance);
    }

    @Override
    public void update(T object) throws DataAccessException {
        baseRepository.update(object);
    }

    @Override
    public void saveOrUpdate(T object) throws DataAccessException {
        baseRepository.saveOrUpdate(object);
    }

    @Override
    public void saveOrUpdateAll(List<T> object) throws DataAccessException {
        baseRepository.saveOrUpdateAll(object);
    }

    @Override
    public void delete(T object) throws DataAccessException {
        baseRepository.delete(object);
    }

    @Override
    public T get(PK id) throws DataAccessException {
        return baseRepository.findById(id);
    }

    @Override
    public List<T> getAll() throws DataAccessException {
        return baseRepository.findAll();
    }
}
