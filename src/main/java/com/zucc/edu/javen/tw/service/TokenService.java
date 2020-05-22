package com.zucc.edu.javen.tw.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zucc.edu.javen.tw.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class TokenService {
    public String getToken(UserEntity user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60 * 60 * 1000 * 8;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(user.getUsername()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
