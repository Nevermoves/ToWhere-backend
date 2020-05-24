package com.zucc.edu.javen.tw.service;

import com.alibaba.fastjson.JSONObject;
import com.zucc.edu.javen.tw.entity.RankBaidu;
import com.zucc.edu.javen.tw.entity.RankTieba;
import com.zucc.edu.javen.tw.entity.RankWeibo;
import com.zucc.edu.javen.tw.service.impl.BaiduNewsServiceImpl;
import com.zucc.edu.javen.tw.util.MyBatiesUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RankbaiduNewsService implements BaiduNewsServiceImpl {
    @Override
    public JSONObject getRankbaiduNewsList() {
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
            js.put("url","www.anyknew.com/"+baidu.getUrl());
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
    public JSONObject getRanktiebaNewsList() {
        SqlSession session = MyBatiesUtil.getSession();
        List<RankTieba> list = session.selectList("getRanktiebaNewsList");
        List<RankTieba> last = null;
        for(int i = 0;i < list.size()-1;i++){
            if(list.get(i).getRank() == 1){
                last = list.subList(i+1,i*2+1);
                list = list.subList(0,i+1);
                break;
            }
        }
        list.sort(Comparator.comparing(RankTieba::getRank));
        last.sort(Comparator.comparing(RankTieba::getRank));
        JSONObject jsonObject = new JSONObject();
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        for(RankTieba entity: list){
            JSONObject js = (JSONObject) JSONObject.toJSON(entity);
            js.remove("url");
            js.put("url","www.anyknew.com/"+entity.getUrl());
            js.remove("id");
            js.remove("getdate");
            js.remove("adddate");
            boolean flag=true;
            for(RankTieba e:last){
                if(e.getTitle().equals(entity.getTitle())){
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
