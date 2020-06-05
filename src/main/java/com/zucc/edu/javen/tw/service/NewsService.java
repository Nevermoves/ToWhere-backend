package com.zucc.edu.javen.tw.service;

import com.alibaba.fastjson.JSONObject;
import com.zucc.edu.javen.tw.entity.RankWeibo;
import com.zucc.edu.javen.tw.service.impl.NewsServiceImpl;
import com.zucc.edu.javen.tw.util.DaoUtil;
import com.zucc.edu.javen.tw.util.MyBatiesUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NewsService implements NewsServiceImpl {
    @Override
    public JSONObject getNewsList() {
        SqlSession session = MyBatiesUtil.getSession();
        List<RankWeibo> list = session.selectList("getRankweiboNewsList");
        List<RankWeibo> last = null;
        for(int i = 0;i < list.size()-1;i++){
            if(list.get(i).getRank() == 1){
                last = list.subList(i+1,i*2+1);
                list = list.subList(0,i+1);
                break;
            }
        }
        list.sort(Comparator.comparing(RankWeibo::getRank));
        JSONObject jsonObject = new JSONObject();
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        for(RankWeibo weibo: list){
            JSONObject js = (JSONObject) JSONObject.toJSON(weibo);
            js.remove("url");
            js.put("url","https://www.anyknew.com/go/"+weibo.getUrl());
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

    @Override
    public JSONObject getAllNewsList(String name) {
        SqlSession session = MyBatiesUtil.getSession();
        JSONObject jsonObject = new JSONObject();
//        GetLnquire.getUrl(name);
        String daoName = DaoUtil.getDaoName(name);
        List<Object> entities = session.selectList(daoName);
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        List<JSONObject> list = null;
        List<JSONObject> last = null;
        for(Object o:entities){
            JSONObject js = (JSONObject) JSONObject.toJSON(o);
            String url = js.getString("url");
            js.remove("url");
            js.put("url","https://www.anyknew.com/go/"+url);
            js.remove("id");
            js.remove("getdate");
            js.remove("adddate");
            jsonObjects.add(js);
        }
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
    public JSONObject getAllHisNewsList(String name, String date){
        SqlSession session = MyBatiesUtil.getSession();
        JSONObject jsonObject = new JSONObject();
        String daoname = DaoUtil.getPastDaoName(name);
//        String datasdf = DaoUtil.getGetDate(date);
//        List<Object> entities = session.selectList(daoname,datasdf);
        List<Object> entities = session.selectList(daoname,date);
        List<JSONObject> list = new ArrayList<JSONObject>();
        for(Object o:entities){
            JSONObject js = (JSONObject) JSONObject.toJSON(o);
            String url = js.getString("url");
            js.remove("url");
            js.put("url","https://www.anyknew.com/go/"+url);
            js.remove("id");
            js.remove("getdate");
            js.remove("adddate");
            list.add(js);
            if(js.getInteger("rank") == 1)break;
        }
        Collections.sort(list,(a, b) -> Integer.compare(a.getInteger("rank"),b.getInteger("rank")));
        jsonObject.put("num",list.size());
        jsonObject.put("data",list);
        return jsonObject;
    }

}
