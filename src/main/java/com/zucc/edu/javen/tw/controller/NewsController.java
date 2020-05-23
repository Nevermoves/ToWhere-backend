package com.zucc.edu.javen.tw.controller;

import com.alibaba.fastjson.JSONObject;
import com.zucc.edu.javen.tw.entity.RankBaidu;
import com.zucc.edu.javen.tw.entity.RankTieba;
import com.zucc.edu.javen.tw.entity.RankWeibo;
import com.zucc.edu.javen.tw.service.NewsService;
import com.zucc.edu.javen.tw.service.RankbaiduNewsService;
import com.zucc.edu.javen.tw.service.impl.BaiduNewsServiceImpl;
import com.zucc.edu.javen.tw.service.impl.NewsServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class NewsController {

    private List<JSONObject> diff(List<Object> list){
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        for(Object object:list){
            JSONObject js = (JSONObject) JSONObject.toJSON(object);
            js.remove("id");
            js.remove("getdata");
            js.remove("adddata");
            jsonObjects.add(js);
        }
        return jsonObjects;
    }

    @GetMapping("/zonghe/weibo")
    JSONObject getNews(HttpServletRequest request){

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

    @GetMapping("/zonghe/baidu")
    JSONObject getRankBaiduNews(){
        JSONObject jsonObject = new JSONObject();
        JSONObject hotnews = new JSONObject();
        JSONObject tiebanews = new JSONObject();
        BaiduNewsServiceImpl service = new RankbaiduNewsService();
        List<RankBaidu> baiduList = service.getRankbaiduNewsList();
        List<JSONObject> baidujslist = new ArrayList<JSONObject>();
        for(RankBaidu baidu:baiduList){
            JSONObject js = (JSONObject) JSONObject.toJSON(baidu);
            js.remove("id");
            js.remove("getdate");
            js.remove("adddate");
            baidujslist.add(js);
        }
        hotnews.put("0","热点");
        hotnews.put("num",baiduList.size());
        hotnews.put("data",baidujslist);
        List<RankTieba> tiebaList = service.getRanktiebaNewsList();
        List<JSONObject> tiebajslist = new ArrayList<JSONObject>();
        for(RankTieba tieba:tiebaList){
            JSONObject js = (JSONObject) JSONObject.toJSON(tieba);
            js.remove("id");
            js.remove("getdate");
            js.remove("adddate");
            tiebajslist.add(js);
        }
        tiebanews.put("1","贴吧");
        tiebanews.put("num",tiebaList.size());
        tiebanews.put("data",tiebajslist);
        jsonObject.put("hot",hotnews);
        jsonObject.put("tieba",tiebanews);
        return jsonObject;
    }
}
