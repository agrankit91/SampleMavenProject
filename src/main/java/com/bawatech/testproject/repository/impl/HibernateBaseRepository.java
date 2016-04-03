package com.bawatech.testproject.repository.impl;

import com.bawatech.testproject.exception.DataAccessException;
import com.bawatech.testproject.repository.session.SessionProvider;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ankit on 4/2/2016.
 */
@Component("baseRepository")
public abstract class HibernateBaseRepository<T, PK extends Serializable> implements BaseRepository<T, PK> {
    private static final Logger LOG = Logger.getLogger(HibernateBaseRepository.class);

    @Autowired
    protected SessionProvider sessionProvider;

    protected Class<T> entityClass;

    public HibernateBaseRepository(final Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public PK save(final T newInstance) throws DataAccessException {
        PK result = (PK) getHibernateSession().save(newInstance);
        return result;
    }

    @Override
    @Transactional
    public void update(final T transientObject) throws DataAccessException {
        getHibernateSession().update(transientObject);
    }

    @Override
    @Transactional
    public void saveOrUpdate(final T transientObject) throws DataAccessException {
        getHibernateSession().saveOrUpdate(transientObject);
    }

    @Override
    @Transactional
    public void saveOrUpdateAll(final List<T> transientObjects) throws DataAccessException {
        transientObjects.forEach(transientObject -> getHibernateSession().saveOrUpdate(transientObject));
    }

    @Override
    @Transactional
    public void delete(final T persistentObject) throws DataAccessException {
        getHibernateSession().delete(persistentObject);
    }

    @Override
    @Transactional
    public void delete(final PK... id) throws DataAccessException {
        if (id.length == 1) {
            T entity = findById(id[0]);
            delete(entity);
        } else {
            for (PK pk : id) {
                T entity = findById(pk);
                delete(entity);
            }
        }
    }

    @Override
    @Transactional
    public T findById(final PK id) throws DataAccessException {
        T result = getHibernateSession().get(entityClass, id);
        return result;
    }

    @Override
    @Transactional
    public List<T> findAll() throws DataAccessException {
        Query query = getHibernateSession().createQuery("from " + getSimpleClassName());
        return query.list();
    }

    protected Session getHibernateSession() {
        return sessionProvider.getCurrentSession();
    }

    protected String getSimpleClassName() {
        return entityClass.getSimpleName();
    }
}
