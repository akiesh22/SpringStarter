package com.spring.wc.service;

import com.spring.wc.model.User;


public interface UserService {
    public User login(User user);
    public void logout(User user);
}
