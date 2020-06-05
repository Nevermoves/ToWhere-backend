package com.zucc.edu.javen.tw.util;

import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JsonUtil {

    private  static String getDateFrpmJson(String date){
        JSONObject datejson = JSONObject.parseObject(date);
        date = datejson.getString("date");
        return date;
    }

    public static String getDate(String date){
        if(date==null||date.equals(""))return null;
        String getdate = getDateFrpmJson(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{
            if(getdate == null||getdate.equals(""))return null;
            sdf.parse(getdate);
            return getdate;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
