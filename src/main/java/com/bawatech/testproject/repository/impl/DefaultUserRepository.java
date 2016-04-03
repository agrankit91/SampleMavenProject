package com.bawatech.testproject.repository.impl;

import com.bawatech.testproject.exception.DataAccessException;
import com.bawatech.testproject.model.User;
import com.bawatech.testproject.repository.UserRepository;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DefaultUserRepository extends HibernateBaseRepository<User, Integer> implements UserRepository {
    private static final Logger LOG = Logger.getLogger(DefaultUserRepository.class);
    private List<User> userList;

    public DefaultUserRepository() {
        super(User.class);
    }

    public DefaultUserRepository(Class<User> userClass) {
        super(userClass);
    }

    @Override
    @Transactional
    public User getUserByEmail(final String email) throws DataAccessException {
        LOG.info("Getting user with email: " + email);
        try {
            Criteria criteria = getHibernateSession().createCriteria(entityClass);
            criteria.add(Restrictions.eq("email", email).ignoreCase());

            User user = (User) criteria.uniqueResult();
            LOG.info("User got: " + user.getFirstName());
            return user;
        } catch (Exception e) {
            throw new DataAccessException(e.getMessage(), e);
        }
    }
}