package com.zucc.edu.javen.tw.service;

import com.alibaba.fastjson.JSONObject;
import com.zucc.edu.javen.tw.entity.RankBaidu;
import com.zucc.edu.javen.tw.entity.RankTieba;
import com.zucc.edu.javen.tw.frame.BuildSession;
import com.zucc.edu.javen.tw.service.impl.NewsServiceImpl;
import com.zucc.edu.javen.tw.util.MyBatiesUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class TestService implements NewsServiceImpl {
    @Override
    public JSONObject getNewsList() {
        SqlSession session = MyBatiesUtil.getSession();
        List<RankBaidu> list = session.selectList("getRankbaiduNewsList");
        List<RankBaidu> last = null;
        for(int i = 0;i < list.size()-1;i++){
            if(list.get(i).getRank() == 1){
                last = list.subList(i+1,i*2+1);
                list = list.subList(0,i+1);
                break;
            }
        }
        list.sort(Comparator.comparing(RankBaidu::getRank));
        last.sort(Comparator.comparing(RankBaidu::getRank));
        JSONObject jsonObject = new JSONObject();
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        for(RankBaidu baidu: list){
            JSONObject js = (JSONObject) JSONObject.toJSON(baidu);
            js.remove("url");
            js.put("url","www.anyknew.com/go/"+baidu.getUrl());
            js.remove("id");
            js.remove("getdate");
            js.remove("adddate");
            boolean flag=true;
            for(RankBaidu b:last){
                if(b.getTitle().equals(baidu.getTitle())){
                    flag=false;
                    break;
                }
            }
            js.put("new_tag",flag);
            jsonObjects.add(js);
        }
        jsonObject.put("num",list.size());
        jsonObject.put("data",jsonObjects);
        return jsonObject;
    }

    @Override
    public JSONObject getAllNewsList(String name) {
        JSONObject jsonObject = new JSONObject();
        List<JSONObject> list = null;
        List<JSONObject> last = null;
        List<JSONObject> jsonObjects = BuildSession.getList(name);
        for(int i=0;i<jsonObjects.size();i++){
            if(jsonObjects.get(i).getInteger("rank")==1){
                list = jsonObjects.subList(0,i+1);
                last = jsonObjects.subList(i+1,i*2+1);
                break;
            }
        }
        for(JSONObject listjs:list){
            boolean flag = true;
            for(JSONObject lastjs:last){
                if(listjs.get("title").equals(lastjs.get("title"))){
                    flag = false;
                    break;
                }
            }
            listjs.put("new_tag",flag);
        }
        Collections.sort(list,(a, b) -> Integer.compare(a.getInteger("rank"),b.getInteger("rank")));
        jsonObject.put("num",list.size());
        jsonObject.put("data",list);
        return jsonObject;
    }

    @Override
    public JSONObject getAllHisNewsList(String name, String date) {
        JSONObject jsonObject = new JSONObject();
        List<JSONObject> list = BuildSession.getHisList(name,date);
        for(int i = 0;i < list.size();i ++){
            if(list.get(i).getInteger("rank") == 1){
                list = list.subList(0,i+1);
                break;
            }
        }
        Collections.sort(list,(a, b) -> Integer.compare(a.getInteger("rank"),b.getInteger("rank")));
        jsonObject.put("num",list.size());
        jsonObject.put("data",list);
        return jsonObject;
    }

}
