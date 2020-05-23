package com.zucc.edu.javen.tw.controller;

import com.alibaba.fastjson.JSONObject;
import com.zucc.edu.javen.tw.entity.RankWeibo;
import com.zucc.edu.javen.tw.service.NewsService;
import com.zucc.edu.javen.tw.service.impl.NewsServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NewsController {

    @GetMapping("/zonghe/weibo")
    JSONObject getNews(){

        JSONObject jsonObject = new JSONObject();
        NewsServiceImpl service = new NewsService();
        List<RankWeibo> list = service.getNewsList();
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        for(RankWeibo weibo: list){
            JSONObject js = (JSONObject) JSONObject.toJSON(weibo);
            js.remove("id");
            js.remove("getdate");
            js.remove("adddate");
            jsonObjects.add(js);
        }
        jsonObject.put("num",list.size());
        jsonObject.put("data",jsonObjects);
        return jsonObject;
    }
}
