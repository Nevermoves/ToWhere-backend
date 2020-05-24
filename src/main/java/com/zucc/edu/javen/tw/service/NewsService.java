package com.zucc.edu.javen.tw.service;

import com.alibaba.fastjson.JSONObject;
import com.zucc.edu.javen.tw.entity.RankWeibo;
import com.zucc.edu.javen.tw.service.impl.NewsServiceImpl;
import com.zucc.edu.javen.tw.util.MyBatiesUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NewsService implements NewsServiceImpl {
    @Override
    public JSONObject getNewsList() {
        SqlSession session = MyBatiesUtil.getSession();
        List<RankWeibo> list = session.selectList("getNewsList");
        List<RankWeibo> last = null;
        for(int i = 0;i < list.size()-1;i++){
            if(list.get(i).getRank() == 1){
                last = list.subList(i+1,i*2+1);
                list = list.subList(0,i+1);
                break;
            }
        }
        list.sort(Comparator.comparing(RankWeibo::getRank));
        last.sort(Comparator.comparing(RankWeibo::getRank));
        JSONObject jsonObject = new JSONObject();
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        for(RankWeibo weibo: list){
            JSONObject js = (JSONObject) JSONObject.toJSON(weibo);
            js.remove("url");
            js.put("url","www.anyknew.com/"+weibo.getUrl());
            js.remove("id");
            js.remove("getdate");
            js.remove("adddate");
            boolean flag=true;
            for(RankWeibo w:last){
                if(w.getTitle().equals(weibo.getTitle())){
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
}
