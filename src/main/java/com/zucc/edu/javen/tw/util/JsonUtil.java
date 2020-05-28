package com.zucc.edu.javen.tw.util;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

    public static String getDate(String date){
        JSONObject datejson = JSONObject.parseObject(date);
        date = datejson.getString("date");
        return date;
    }
}
