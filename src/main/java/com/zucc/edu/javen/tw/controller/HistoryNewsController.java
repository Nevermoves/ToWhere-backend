package com.zucc.edu.javen.tw.controller;

import com.alibaba.fastjson.JSONObject;
import com.zucc.edu.javen.tw.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

@RestController
public class HistoryNewsController {

    @Autowired
    NewsService service;

//    @PostMapping("/his/kr36")
//    JSONObject getHisRank36krNews(@RequestParam Date date){
////        Date date = new Date();
//        JSONObject jsonObject = service.getAllHisNewsList("36kr","");
//        System.out.println(new Date());
//        return jsonObject;
//    }
}
