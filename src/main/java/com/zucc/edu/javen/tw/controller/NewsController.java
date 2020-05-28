package com.zucc.edu.javen.tw.controller;

import com.alibaba.fastjson.JSONObject;
import com.zucc.edu.javen.tw.entity.*;
import com.zucc.edu.javen.tw.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@RestController
public class NewsController {

    @Autowired
    private NewsService service;

    @GetMapping("/zonghe/wangyi")
    JSONObject getWangyixinwenNews(){

        JSONObject jsonObject = service.getAllNewsList(Rank163.class.getName());
        return jsonObject;
    }

//    @PostMapping("/keji/kr36")
//    JSONObject get36keNews(@RequestParam Date date){
//        JSONObject jsonObject = null;
//        if (date == null )jsonObject = service.getAllNewsList("36kr");
//        else jsonObject = service.getAllNewsList("36kr");
//        return jsonObject;
//    }

    @PostMapping("/keji/kr36")
    JSONObject get36keNews(@RequestBody String date){
        JSONObject jsonObject = null;
        if (date == " " ){
            System.out.println(1);
            jsonObject = service.getAllNewsList(Rank36kr.class.getName());
        }
        else {
            System.out.println(2);
            jsonObject = service.getAllHisNewsList(Rank36kr.class.getName(),date);
        }
        return jsonObject;
    }

    @GetMapping("/zonghe/baidu")
    JSONObject getBaiduNews(){
        JSONObject jsonObject = new JSONObject();
        JSONObject hotnews = service.getAllNewsList(RankBaidu.class.getName());
        JSONObject tiebanews = service.getAllNewsList(RankTieba.class.getName());
        hotnews.put("name","热点");
        tiebanews.put("name","贴吧");
        jsonObject.put("hot",hotnews);
        jsonObject.put("tieba",tiebanews);
        return jsonObject;
    }

    @GetMapping("/shipin/bilibili")
    JSONObject getBilibiliNews(){

        JSONObject jsonObject = service.getAllNewsList(RankBilibili.class.getName());
        return jsonObject;
    }

    @GetMapping("/keji/guokr")
    JSONObject getGuokeNews(){

        JSONObject jsonObject = service.getAllNewsList(RankGuoke.class.getName());
        return jsonObject;
    }

    @GetMapping("/shipin/pearvideo")
    JSONObject getPearvedioNews(){

        JSONObject jsonObject = service.getAllNewsList(RankPearvedio.class.getName());
        return jsonObject;
    }

    @GetMapping("/shipin/pengpai")
    JSONObject getPengpaiNews(){

        JSONObject jsonObject = service.getAllNewsList(RankPengpai.class.getName());
        return jsonObject;
    }

    @GetMapping("/zonghe/qdaily")
    JSONObject getQdailyNews(){

        JSONObject jsonObject = service.getAllNewsList(RankQdaily.class.getName());
        return jsonObject;
    }

    @GetMapping("/zonghe/toutiao")
    JSONObject getToutiaoNews(){

        JSONObject jsonObject = service.getAllNewsList(RankToutiao.class.getName());
        return jsonObject;
    }

    @GetMapping("/zonghe/weibo")
    JSONObject getWeiboNews(HttpServletRequest request){

        JSONObject jsonObject = service.getAllNewsList(RankWeibo.class.getName());
        return jsonObject;
    }

    @GetMapping("/keji/yc")
    JSONObject getYcNews(){

        JSONObject jsonObject = service.getAllNewsList(RankYc.class.getName());
        return jsonObject;
    }

    @GetMapping("/zonghe/zhihu")
    JSONObject getZhihuNews(){

        JSONObject jsonObject = new JSONObject();
        JSONObject zhihu = service.getAllNewsList(RankZhihu.class.getName());
        JSONObject word = service.getAllNewsList(RankZhihuword.class.getName());
        zhihu.put("name","热榜");
        word.put("name","热词");
        jsonObject.put("hot",zhihu);
        jsonObject.put("word",word);
        return jsonObject;
    }
}
