package com.spring.wc.service;

import com.spring.wc.model.User;


public interface UserService {
    public void login(User user);
    public void logout(User user);
}
