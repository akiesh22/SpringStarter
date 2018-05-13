package com.spring.wc.controllers;

import com.google.common.hash.Hashing;
import com.spring.wc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping(value = "/")
public class DefaultController {

    private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String index(Locale locale, Model model) {

//        logger.info("Welcome home! The client locale is {}.", locale);
//
//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//
//        String formattedDate = dateFormat.format(date);s
//
//        model.addAttribute("serverTime", formattedDate);

        return "index";
    }
}
