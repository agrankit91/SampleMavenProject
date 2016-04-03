package com.bawatech.testproject.controller;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.bawatech.testproject.exception.DataAccessException;
import com.bawatech.testproject.model.User;
import com.bawatech.testproject.service.UserService;
import com.bawatech.testproject.service.impl.DefaultUserService;

/**
 * Created by ankit on 2/20/2016.
 */
@Controller
public class Home {
    private static final Logger LOG = Logger.getLogger(Home.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    public ModelAndView getUserByEmail(String email) {
        User user = method(email);
        if (user == null) {
            user = new User();
            user.setFirstName("Not found");
            return new ModelAndView("Hello", "user", user);
        }
        return new ModelAndView("Hello", "user", user);
    }

    @RequestMapping(value = "/user/save", method = RequestMethod.GET)
    public ModelAndView save(String email) {
        User user = new User("Puneet", "Agrawal", "puneetagrawal1991@gmail.com");
        try {
            this.userService.save(user);
            LOG.info("User saved.");
        } catch (DataAccessException e) {
            LOG.info("User not saved.");
            e.printStackTrace();
        }
        return new ModelAndView("Hello", "user", user);
    }

    private User method(final String email) {
        User user = this.userService.getUserByEmail(email);

        if (user == null) {
            LOG.info("No user found with email: " + email);
        } else {
            LOG.info("User found with email: " + email);
            LOG.info("First Name: " + user.getFirstName());
            LOG.info("Last Name: " + user.getLastName());
        }
        return user;
    }

}
