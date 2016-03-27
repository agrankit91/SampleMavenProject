package com.bawatech.testproject.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

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
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(String email) {
        method(email);
        return "Hello";
    }
    
    private void method(final String email) {
        User user = this.userService.getUserByEmail(email);
        
        if (user == null) {
            LOG.info("No user found with email: " + email);
        } else {
            LOG.info("User found with email: " + email);
            LOG.info("First Name: " + user.getFirstName());
            LOG.info("Last Name: " + user.getLastName());   
        }
    }
}
