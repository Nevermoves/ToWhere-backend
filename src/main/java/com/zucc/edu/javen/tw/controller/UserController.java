package com.zucc.edu.javen.tw.controller;

import com.alibaba.fastjson.JSONObject;
import com.zucc.edu.javen.tw.form.LoginForm;
import com.zucc.edu.javen.tw.service.TokenService;
import com.zucc.edu.javen.tw.service.UserService;
import com.zucc.edu.javen.tw.service.impl.UserServiceImpl;
import com.zucc.edu.javen.tw.token.UserLoginToken;
import com.zucc.edu.javen.tw.util.TokenUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
//https://blog.csdn.net/baidu_41881054/article/details/91991539
    @Autowired
    TokenService tokenService;

    @PostMapping("/register")
    JSONObject userRegister(@RequestBody LoginForm loginForm){
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        JSONObject jsonObject = new JSONObject();
        UserServiceImpl userService = new UserService();
        String ret = userService.register(username,password);
        JSONObject data = new JSONObject();
        if(ret.startsWith("ERROR_")){
            jsonObject.put("status_code",401);
            data.put("message",ret.substring(6));
        }
        else{
            jsonObject.put("status_code",200);
            data.put("username",ret);
        }
        jsonObject.put("data",data);
        return jsonObject;
    }

    @PostMapping("/login")
    JSONObject userLogin(@RequestBody LoginForm loginForm){
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        JSONObject jsonObject = new JSONObject();
        UserServiceImpl service = new UserService();
        String ret = service.login(username,password);
        JSONObject data = new JSONObject();
        if(ret.startsWith("ERROR_")){
            jsonObject.put("status_code",401);
            data.put("message",ret.substring(6));
        }
        else{
            jsonObject.put("status_code",200);
            String token = tokenService.getToken(service.getUserByUsername(username));
            data.put("token",token);
            data.put("username",ret);
        }
        jsonObject.put("data",data);
        return jsonObject;
    }

    @UserLoginToken
    @ApiOperation(value = "获取信息", notes = "获取信息")
    @RequestMapping(value = "/getMessage" ,method = RequestMethod.GET)
    public String getMessage() {

        // 取出token中带的用户username 进行操作
//        System.out.println(TokenUtil.getTokenUserId());

        return "您已通过验证";
    }
}
