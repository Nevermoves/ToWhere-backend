package com.zucc.edu.javen.tw.controller;

import com.alibaba.fastjson.JSONObject;
import com.zucc.edu.javen.tw.service.NewsService;
import com.zucc.edu.javen.tw.service.RankbaiduNewsService;
import com.zucc.edu.javen.tw.service.impl.BaiduNewsServiceImpl;
import com.zucc.edu.javen.tw.service.impl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private NewsService service;

    @GetMapping("/zonghe/wangyi")
    JSONObject getWangyixinwenNews(){

        JSONObject jsonObject = service.getAllNewsList("163");
        return jsonObject;
    }

    @GetMapping("/keji/kr36")
    JSONObject get36keNews(){

        JSONObject jsonObject = service.getAllNewsList("36kr");
        return jsonObject;
    }

    @GetMapping("/zonghe/baidu")
    JSONObject getBaiduNews(){

        JSONObject jsonObject = new JSONObject();
        JSONObject hotnews = service.getAllNewsList("baidu");
        JSONObject tiebanews = service.getAllNewsList("tieba");
        hotnews.put("name","热点");
        tiebanews.put("name","贴吧");
        jsonObject.put("hot",hotnews);
        jsonObject.put("tieba",tiebanews);
        return jsonObject;
    }

    @GetMapping("/shipin/bilibili")
    JSONObject getBilibiliNews(){

        JSONObject jsonObject = service.getAllNewsList("bilibili");
        return jsonObject;
    }

    @GetMapping("/keji/guokr")
    JSONObject getGuokeNews(){

        JSONObject jsonObject = service.getAllNewsList("guoke");
        return jsonObject;
    }

    @GetMapping("/shipin/pearvideo")
    JSONObject getPearvedioNews(){

        JSONObject jsonObject = service.getAllNewsList("pearvedio");
        return jsonObject;
    }

    @GetMapping("/shipin/pengpai")
    JSONObject getPengpaiNews(){

        JSONObject jsonObject = service.getAllNewsList("pengpai");
        return jsonObject;
    }

    @GetMapping("/zonghe/qdaily")
    JSONObject getQdailyNews(){

        JSONObject jsonObject = service.getAllNewsList("qdaily");
        return jsonObject;
    }

    @GetMapping("/zonghe/toutiao")
    JSONObject getToutiaoNews(){

        JSONObject jsonObject = service.getAllNewsList("toutiao");
        return jsonObject;
    }

    @GetMapping("/zonghe/weibo")
    JSONObject getWeiboNews(HttpServletRequest request){

        JSONObject jsonObject = service.getAllNewsList("weibo");
        return jsonObject;
    }

    @GetMapping("/keji/yc")
    JSONObject getYcNews(){

        JSONObject jsonObject = service.getAllNewsList("yc");
        return jsonObject;
    }

    @GetMapping("/zonghe/zhihu")
    JSONObject getZhihuNews(){

        JSONObject jsonObject = new JSONObject();
        JSONObject zhihu = service.getAllNewsList("zhihu");
        JSONObject word = service.getAllNewsList("zhihuword");
        zhihu.put("name","热榜");
        word.put("name","热词");
        jsonObject.put("hot",zhihu);
        jsonObject.put("word",word);
        return jsonObject;
    }
}
