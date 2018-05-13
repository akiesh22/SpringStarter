package com.spring.wc.dao;

import com.spring.wc.model.User;
import org.springframework.stereotype.Repository;


public interface UserDao {
    public  User login(User user);
    public void logout(User user);
}
