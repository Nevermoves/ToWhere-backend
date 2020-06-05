package com.zucc.edu.javen.tw.frame;

import com.alibaba.fastjson.JSONObject;
import com.zucc.edu.javen.tw.util.MyBatiesUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class BuildSession {
    public static List<JSONObject> getList(String className){
        SqlSession session = MyBatiesUtil.getSession();
        NewsForm form = GetLnquire.getform(className);
        List<Object> list = session.selectList(form.getDao(),form);
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        for(Object o:list){
            JSONObject js  = (JSONObject) JSONObject.toJSON(o);
            String url = js.getString("url");
            js.remove("url");
            js.put("url","https://www.anyknew.com/go/"+url);
            jsonObjects.add(js);
        }
        return jsonObjects;
    }
    public static List<JSONObject> getHisList(String className,String getdate){
        SqlSession session = MyBatiesUtil.getSession();
        NewsForm form = GetLnquire.getHisForm(className,getdate);
        List<Object> list = session.selectList(form.getDao(),form);
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        for(Object o:list){
            JSONObject js  = (JSONObject) JSONObject.toJSON(o);
            String url = js.getString("url");
            js.remove("url");
            js.put("url","https://www.anyknew.com/go/"+url);
            jsonObjects.add(js);
        }
        return jsonObjects;
    }
}
