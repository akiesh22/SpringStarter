package com.spring.wc.controllers;

import com.google.common.hash.Hashing;
import com.spring.wc.model.User;
import com.spring.wc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpSession session, @ModelAttribute("user")User user){

        String sha256hex = Hashing.sha256().hashString(user.getPassword(), StandardCharsets.UTF_8).toString();
        System.out.println(sha256hex);

        System.out.println("I am here"+user);
        return "index";
    }

}
