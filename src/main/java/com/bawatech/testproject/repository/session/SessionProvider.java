package com.bawatech.testproject.repository.session;


import org.hibernate.Session;

/**
 * Session provider for Repositories
 * Created by ankit on 4/2/2016.
 */
public interface SessionProvider {
    /**
     * Obtains the current session <br/>
     *
     * @return current {@link Session}
     */
    Session getCurrentSession();
}
