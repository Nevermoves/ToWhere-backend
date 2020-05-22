package com.zucc.edu.javen.tw.service.impl;

import com.zucc.edu.javen.tw.entity.UserEntity;

public interface UserServiceImpl {

    String register(String username,String password);

    String login(String username,String password);

    UserEntity getUserByUsername(String username);

    UserEntity getUserById(int id);
}
