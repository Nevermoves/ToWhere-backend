package com.zucc.edu.javen.tw.service;

import com.zucc.edu.javen.tw.dao.UserDao;
import com.zucc.edu.javen.tw.entity.UserEntity;
import com.zucc.edu.javen.tw.service.impl.UserServiceImpl;
import com.zucc.edu.javen.tw.util.EncryptUtil;
import com.zucc.edu.javen.tw.util.MyBatiesUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceImpl {

    @Override
    public String register(String username, String password) {
        if(username.equals(""))return "ERROR_用户名不得为空。";
        if(password.equals(""))return "ERROR_密码不得为空。";
        SqlSession session = MyBatiesUtil.getSession();
        UserEntity entity = session.selectOne("getByUsername",username);
        if(entity != null)return "ERROR_该用户名已被使用。";
        UserEntity userEntity = new UserEntity();
        String encryptPwd = EncryptUtil.getEncryptPassword(username,password);
        userEntity.setUsername(username);
        userEntity.setPassword(encryptPwd);
        session.insert("addUser",userEntity);
        session.commit();
        return username;
    }

    @Override
    public String login(String username, String password) {

        if(username.equals(""))return "ERROR_用户名不得为空。";
        if(password.equals(""))return "ERROR_密码不得为空。";
        SqlSession session= MyBatiesUtil.getSession();
        UserEntity entity = session.selectOne("getByUsername",username);
        String encryptPwd = EncryptUtil.getEncryptPassword(username,password);
        if(entity == null)return "ERROR_用户名不存在。";
        if(!entity.getPassword().equals(encryptPwd))return "ERROR_密码错误。";
        return username;
    }

    @Override
    public UserEntity getUserByUsername(String username){

        SqlSession session = MyBatiesUtil.getSession();
        UserEntity entity = session.selectOne("getByUsername",username);
        return entity;
    }

    @Override
    public UserEntity getUserById(int id) {

        SqlSession session = MyBatiesUtil.getSession();
        UserEntity entity = session.selectOne("getById",id);
        return entity;
    }


}
