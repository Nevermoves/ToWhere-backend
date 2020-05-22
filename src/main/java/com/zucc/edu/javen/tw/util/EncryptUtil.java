package com.zucc.edu.javen.tw.util;

import org.springframework.util.DigestUtils;

public class EncryptUtil {

    public static String getEncryptPassword(String username,String password){
        String nameencrypt = DigestUtils.md5DigestAsHex(username.getBytes());
        String pwdencrypt = nameencrypt + password;
        String ret = DigestUtils.md5DigestAsHex(pwdencrypt.getBytes());
        return ret;
    }
}
