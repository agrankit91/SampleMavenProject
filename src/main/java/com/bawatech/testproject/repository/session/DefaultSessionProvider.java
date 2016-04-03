package com.bawatech.testproject.repository.session;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ankit on 4/2/2016.
 */
@Component("sessionProvider")
public class DefaultSessionProvider implements SessionProvider {
    private static final Logger LOG = Logger.getLogger(DefaultSessionProvider.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getCurrentSession() {
        if (sessionFactory == null) {
            LOG.info("SessionFactory is null");
            return null;
        }
        LOG.info("SessionFactory is not null");
        return sessionFactory.getCurrentSession();
    }
}
