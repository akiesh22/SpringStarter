package com.spring.wc.service.serviceImpl;

import com.spring.wc.dao.UserDao;
import com.spring.wc.model.User;
import com.spring.wc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User login(User user) {
       return userDao.login(user);
    }

    @Override
    public void logout(User user) {

    }
}
