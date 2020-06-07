package com.zucc.edu.javen.tw.controller;

import com.alibaba.fastjson.JSONObject;
import com.zucc.edu.javen.tw.service.NewsService;
import com.zucc.edu.javen.tw.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class NewsController {

    @Autowired
    private NewsService service;

    @PostMapping("/*/*")
    JSONObject getNews(HttpServletRequest request){
        String[] urls = request.getRequestURL().toString().split("/");
        String url = urls[urls.length-1];
        String date = JsonUtil.getBody(request);
        JSONObject jsonObject = null;
        String getDate = JsonUtil.getDate(date);
        if(getDate!=null)jsonObject = service.getAllHisNewsList(url,getDate);
        else jsonObject = service.getAllNewsList(url);
        return jsonObject;
    }

    JSONObject getNewstext(String url, Date date){
        NewsService service = new NewsService();
        JSONObject jsonObject = null;
        String getDate = JsonUtil.getDate(date);
        if(getDate!=null)jsonObject = service.getAllHisNewsList(url,getDate);
        else jsonObject = service.getAllNewsList(url);
        return jsonObject;
    }
//    @PostMapping("/zonghe/wangyi")
//    JSONObject getWangyixinwenNews(@RequestBody String date){
//        JSONObject jsonObject = null;
//        String getDate = JsonUtil.getDate(date);
//        if(getDate!=null)jsonObject = service.getAllHisNewsList("wangyi",getDate);
//        else jsonObject = service.getAllNewsList("wangyi");
//        return jsonObject;
//    }
//
//    @PostMapping("/keji/kr36")
//    JSONObject get36keNews(@RequestBody String date){
//        JSONObject jsonObject = null;
//        String getDate = JsonUtil.getDate(date);
//        if (date != null&&getDate!=null&&(!getDate.equals(""))){
//            jsonObject = service.getAllHisNewsList(Rank36kr.class.getName(),getDate);
//        }
//        else {
//            jsonObject = service.getAllNewsList(Rank36kr.class.getName());
//        }
//        return jsonObject;
//    }
//
//    @PostMapping("/zonghe/baidu")
//    JSONObject getBaiduNews(@RequestBody String date){
//        JSONObject jsonObject = new JSONObject();
//        String getDate = JsonUtil.getDate(date);
//        JSONObject hotnews = null;
//        JSONObject tiebanews = null;
//        if(date != null&&getDate!=null&&(!getDate.equals(""))){
//            hotnews = service.getAllHisNewsList(RankBaidu.class.getName(),getDate);
//            tiebanews = service.getAllHisNewsList(RankTieba.class.getName(),getDate);
//        }
//        else{
//            hotnews = service.getAllNewsList(RankBaidu.class.getName());
//            tiebanews = service.getAllNewsList(RankTieba.class.getName());
//        }
//        hotnews.put("name","热点");
//        tiebanews.put("name","贴吧");
//        jsonObject.put("hot",hotnews);
//        jsonObject.put("tieba",tiebanews);
//        return jsonObject;
//    }
//
//    @PostMapping("/shipin/bilibili")
//    JSONObject getBilibiliNews(@RequestBody String date){
//        JSONObject jsonObject = null;
//        String getDate = JsonUtil.getDate(date);
//        if (date != null&&getDate!=null&&(!getDate.equals(""))){
//            jsonObject = service.getAllHisNewsList(RankBilibili.class.getName(),getDate);
//        }
//        else {
//            jsonObject = service.getAllNewsList(RankBilibili.class.getName());
//        }
//        return jsonObject;
//    }
//
//    @PostMapping("/keji/guokr")
//    JSONObject getGuokeNews(@RequestBody String date){
//        JSONObject jsonObject = null;
//        String getDate = JsonUtil.getDate(date);
//        if (date != null&&getDate!=null&&(!getDate.equals(""))){
//            jsonObject = service.getAllHisNewsList(RankGuoke.class.getName(),getDate);
//        }
//        else {
//            jsonObject = service.getAllNewsList(RankGuoke.class.getName());
//        }
//        return jsonObject;
//    }
//
//    @PostMapping("/shipin/pearvideo")
//    JSONObject getPearvedioNews(@RequestBody String date){
//        JSONObject jsonObject = null;
//        String getDate = JsonUtil.getDate(date);
//        if (date != null&&getDate!=null&&(!getDate.equals(""))){
//            jsonObject = service.getAllHisNewsList(RankPearvedio.class.getName(),getDate);
//        }
//        else {
//            jsonObject = service.getAllNewsList(RankPearvedio.class.getName());
//        }
//        return jsonObject;
//    }
//
//    @PostMapping("/shipin/pengpai")
//    JSONObject getPengpaiNews(@RequestBody String date){
//        JSONObject jsonObject = null;
//        String getDate = JsonUtil.getDate(date);
//        if (date != null&&getDate!=null&&(!getDate.equals(""))){
//            jsonObject = service.getAllHisNewsList(RankPengpai.class.getName(),getDate);
//        }
//        else {
//            jsonObject = service.getAllNewsList(RankPengpai.class.getName());
//        }
//        return jsonObject;
//    }
//
//    @PostMapping("/zonghe/qdaily")
//    JSONObject getQdailyNews(@RequestBody String date){
//        JSONObject jsonObject = null;
//        String getDate = JsonUtil.getDate(date);
//        if (date != null&&getDate!=null&&(!getDate.equals(""))){
//            jsonObject = service.getAllHisNewsList(RankQdaily.class.getName(),getDate);
//        }
//        else {
//            jsonObject = service.getAllNewsList(RankQdaily.class.getName());
//        }
//        return jsonObject;
//    }
//
//    @PostMapping("/zonghe/toutiao")
//    JSONObject getToutiaoNews(@RequestBody String date){
//        JSONObject jsonObject = null;
//        String getDate = JsonUtil.getDate(date);
//        if (date != null&&getDate!=null&&(!getDate.equals(""))){
//            jsonObject = service.getAllHisNewsList(RankToutiao.class.getName(),getDate);
//        }
//        else {
//            jsonObject = service.getAllNewsList(RankToutiao.class.getName());
//        }
//        return jsonObject;
//    }
//
//    @PostMapping("/zonghe/weibo")
//    JSONObject getWeiboNews(@RequestBody String date){
//        JSONObject jsonObject = null;
//        String getDate = JsonUtil.getDate(date);
//        if (date != null&&getDate!=null&&(!getDate.equals(""))){
//            jsonObject = service.getAllHisNewsList(RankWeibo.class.getName(),getDate);
//        }
//        else {
//            jsonObject = service.getAllNewsList(RankWeibo.class.getName());
//        }
//        return jsonObject;
//    }
//
//    @PostMapping("/keji/yc")
//    JSONObject getYcNews(@RequestBody String date){
//        JSONObject jsonObject = null;
//        String getDate = JsonUtil.getDate(date);
//        if (date != null&&getDate!=null&&(!getDate.equals(""))){
//            jsonObject = service.getAllHisNewsList(RankYc.class.getName(),getDate);
//        }
//        else {
//            jsonObject = service.getAllNewsList(RankYc.class.getName());
//        }
//        return jsonObject;
//    }
//
//    @PostMapping("/zonghe/zhihu")
//    JSONObject getZhihuNews(@RequestBody String date){
//        JSONObject jsonObject = new JSONObject();
//        String getDate = JsonUtil.getDate(date);
//        JSONObject zhihu = null;
//        JSONObject word = null;
//        if (date != null&&getDate!=null&&(!getDate.equals(""))){
//            zhihu = service.getAllHisNewsList(RankZhihu.class.getName(),getDate);
//            word = service.getAllHisNewsList(RankZhihuword.class.getName(),getDate);
//        }
//        else{
//            zhihu = service.getAllNewsList(RankZhihu.class.getName());
//            word = service.getAllNewsList(RankZhihuword.class.getName());
//        }
//        zhihu.put("name","热榜");
//        word.put("name","热词");
//        jsonObject.put("hot",zhihu);
//        jsonObject.put("word",word);
//        return jsonObject;
//    }
}
