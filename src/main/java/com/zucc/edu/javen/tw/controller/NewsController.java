package com.zucc.edu.javen.tw.controller;

import com.alibaba.fastjson.JSONObject;
import com.zucc.edu.javen.tw.entity.*;
import com.zucc.edu.javen.tw.service.NewsService;
import com.zucc.edu.javen.tw.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@RestController
public class NewsController {

    @Autowired
    private NewsService service;

    @PostMapping("/zonghe/wangyi")
    JSONObject getWangyixinwenNews(@RequestBody String date){

        JSONObject jsonObject = null;
        date = JsonUtil.getDate(date);
        if (date == null||date.equals("")){
            jsonObject = service.getAllNewsList(Rank163.class.getName());
        }
        else {
            jsonObject = service.getAllHisNewsList(Rank163.class.getName(),date);
        }
        return jsonObject;
    }

    @PostMapping("/keji/kr36")
    JSONObject get36keNews(@RequestBody String date){
        JSONObject jsonObject = null;
        date = JsonUtil.getDate(date);
        if (date == null||date.equals("")){
            jsonObject = service.getAllNewsList(Rank36kr.class.getName());
        }
        else {
            jsonObject = service.getAllHisNewsList(Rank36kr.class.getName(),date);
        }
        return jsonObject;
    }

    @PostMapping("/zonghe/baidu")
    JSONObject getBaiduNews(@RequestBody String date){
        JSONObject jsonObject = new JSONObject();
        date = JsonUtil.getDate(date);
        JSONObject hotnews = null;
        JSONObject tiebanews = null;
        if(date == null||date.equals("")){
            hotnews = service.getAllNewsList(RankBaidu.class.getName());
            tiebanews = service.getAllNewsList(RankTieba.class.getName());
        }
        else{
            hotnews = service.getAllHisNewsList(RankBaidu.class.getName(),date);
            tiebanews = service.getAllHisNewsList(RankTieba.class.getName(),date);
        }
        hotnews.put("name","热点");
        tiebanews.put("name","贴吧");
        jsonObject.put("hot",hotnews);
        jsonObject.put("tieba",tiebanews);
        return jsonObject;
    }

    @PostMapping("/shipin/bilibili")
    JSONObject getBilibiliNews(@RequestBody String date){
        JSONObject jsonObject = null;
        date = JsonUtil.getDate(date);
        if (date == null||date.equals("")){
            jsonObject = service.getAllNewsList(RankBilibili.class.getName());
        }
        else {
            jsonObject = service.getAllHisNewsList(RankBilibili.class.getName(),date);
        }
        return jsonObject;
    }

    @PostMapping("/keji/guokr")
    JSONObject getGuokeNews(@RequestBody String date){
        JSONObject jsonObject = null;
        date = JsonUtil.getDate(date);
        if (date == null||date.equals("")){
            jsonObject = service.getAllNewsList(RankGuoke.class.getName());
        }
        else {
            jsonObject = service.getAllHisNewsList(RankGuoke.class.getName(),date);
        }
        return jsonObject;
    }

    @PostMapping("/shipin/pearvideo")
    JSONObject getPearvedioNews(@RequestBody String date){
        JSONObject jsonObject = null;
        date = JsonUtil.getDate(date);
        if (date == null||date.equals("")){
            jsonObject = service.getAllNewsList(RankPearvedio.class.getName());
        }
        else {
            jsonObject = service.getAllHisNewsList(RankPearvedio.class.getName(),date);
        }
        return jsonObject;
    }

    @PostMapping("/shipin/pengpai")
    JSONObject getPengpaiNews(@RequestBody String date){
        JSONObject jsonObject = null;
        date = JsonUtil.getDate(date);
        if (date == null||date.equals("")){
            jsonObject = service.getAllNewsList(RankPengpai.class.getName());
        }
        else {
            jsonObject = service.getAllHisNewsList(RankPengpai.class.getName(),date);
        }
        return jsonObject;
    }

    @PostMapping("/zonghe/qdaily")
    JSONObject getQdailyNews(@RequestBody String date){
        JSONObject jsonObject = null;
        date = JsonUtil.getDate(date);
        if (date == null||date.equals("")){
            jsonObject = service.getAllNewsList(RankQdaily.class.getName());
        }
        else {
            jsonObject = service.getAllHisNewsList(RankQdaily.class.getName(),date);
        }
        return jsonObject;
    }

    @PostMapping("/zonghe/toutiao")
    JSONObject getToutiaoNews(@RequestBody String date){
        JSONObject jsonObject = null;
        date = JsonUtil.getDate(date);
        if (date == null||date.equals("")){
            jsonObject = service.getAllNewsList(RankToutiao.class.getName());
        }
        else {
            jsonObject = service.getAllHisNewsList(RankToutiao.class.getName(),date);
        }
        return jsonObject;
    }

    @PostMapping("/zonghe/weibo")
    JSONObject getWeiboNews(@RequestBody String date){
        JSONObject jsonObject = null;
        date = JsonUtil.getDate(date);
        if (date == null||date.equals("")){
            jsonObject = service.getAllNewsList(RankWeibo.class.getName());
        }
        else {
            jsonObject = service.getAllHisNewsList(RankWeibo.class.getName(),date);
        }
        return jsonObject;
    }

    @PostMapping("/keji/yc")
    JSONObject getYcNews(@RequestBody String date){
        JSONObject jsonObject = null;
        date = JsonUtil.getDate(date);
        if (date == null||date.equals("")){
            jsonObject = service.getAllNewsList(RankYc.class.getName());
        }
        else {
            jsonObject = service.getAllHisNewsList(RankYc.class.getName(),date);
        }
        return jsonObject;
    }

    @PostMapping("/zonghe/zhihu")
    JSONObject getZhihuNews(@RequestBody String date){
        JSONObject jsonObject = new JSONObject();
        date = JsonUtil.getDate(date);
        JSONObject zhihu = null;
        JSONObject word = null;
        if(date == null||date.equals("")){
            zhihu = service.getAllNewsList(RankZhihu.class.getName());
            word = service.getAllNewsList(RankZhihuword.class.getName());
        }
        else{
            zhihu = service.getAllHisNewsList(RankZhihu.class.getName(),date);
            word = service.getAllHisNewsList(RankZhihuword.class.getName(),date);
        }
        zhihu.put("name","热榜");
        word.put("name","热词");
        jsonObject.put("hot",zhihu);
        jsonObject.put("word",word);
        return jsonObject;
    }
}
