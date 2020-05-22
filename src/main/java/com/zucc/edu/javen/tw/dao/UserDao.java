package com.zucc.edu.javen.tw.dao;

import com.zucc.edu.javen.tw.entity.UserEntity;

public interface UserDao {

    public UserEntity getById(int id);

    public UserEntity getByUsername(String username);

    public void addUser(UserEntity entity);
}
