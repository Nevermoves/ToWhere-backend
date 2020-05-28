package com.zucc.edu.javen.tw.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zucc.edu.javen.tw.entity.RankWeibo;

import java.util.Date;
import java.util.List;

public interface NewsServiceImpl {

    JSONObject getNewsList();

    JSONObject getAllNewsList(String name);

    JSONObject getAllHisNewsList(String name, String date);

}
