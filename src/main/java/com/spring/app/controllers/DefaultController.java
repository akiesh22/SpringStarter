package com.spring.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class DefaultController {
    @RequestMapping(method = RequestMethod.GET)
    public  String index(Model model){
        System.out.println("Finally");
    return "index";
    }
}
