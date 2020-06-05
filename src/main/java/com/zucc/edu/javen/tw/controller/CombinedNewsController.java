package com.zucc.edu.javen.tw.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CombinedNewsController {
    NewsController dataController = new NewsController();


    @PostMapping("/combine/all")
    public JSONObject getAllNewsList() {
        JSONObject wangyi = dataController.getWangyixinwenNews("");
        JSONObject kr36 = dataController.get36keNews("");

        return wangyi;
    }

}