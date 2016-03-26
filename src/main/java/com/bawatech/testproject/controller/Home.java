package com.bawatech.testproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ankit on 2/20/2016.
 */
@Controller
public class Home {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello";
    }
    
    public void method() {
        int i, j;
        i = 2; j = 3;
        try {
            i = i/j;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
