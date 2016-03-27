package com.bawatech.testproject.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ankit on 2/20/2016.
 */
@Controller
public class Home {
    private static final Logger LOG = Logger.getLogger(Home.class);
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        method();
        return "Hello";
    }
    
    private void method() {
        LOG.info("Insite Home method");
    }
}
