package com.zucc.edu.javen.tw.frame;

import com.alibaba.fastjson.JSONObject;
import com.zucc.edu.javen.tw.util.MyBatiesUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuildSession {
    public static List<JSONObject> getList(String className){
        SqlSession session = MyBatiesUtil.getSession();
        NewsForm form = GetLnquire.getform(className);
        List<Map<String,Object>> list = session.selectList(form.getDao(),form);
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        for(Object o:list){

            JSONObject js  = (JSONObject) JSONObject.toJSON(o);
            String url = js.getString("iid");
            js.remove("iid");
            js.put("url","https://www.anyknew.com/go/"+url);
            js.remove("add_date");
            js.remove("get_date");
            js.remove("id");
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
            String url = js.getString("iid");
            js.remove("iid");
            js.put("url","https://www.anyknew.com/go/"+url);
            js.remove("add_date");
            js.remove("get_date");
            js.remove("id");
            jsonObjects.add(js);
        }
        return jsonObjects;
    }
}
