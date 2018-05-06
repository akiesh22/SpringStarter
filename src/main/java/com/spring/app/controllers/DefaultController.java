package com.spring.app.controllers;

import com.spring.app.model.User;
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

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping(value = "/")
public class DefaultController {

    @Autowired
    SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String index(Locale locale, Model model) {
        User user = new User();
        user.setName("gg");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.save(user);

        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "index";
    }
}
