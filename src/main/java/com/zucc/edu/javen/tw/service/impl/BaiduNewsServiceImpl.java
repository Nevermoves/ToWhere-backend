package com.zucc.edu.javen.tw.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zucc.edu.javen.tw.entity.RankBaidu;
import com.zucc.edu.javen.tw.entity.RankTieba;

import java.util.List;

public interface BaiduNewsServiceImpl {

    JSONObject getRankbaiduNewsList();

    JSONObject getRanktiebaNewsList();
}
