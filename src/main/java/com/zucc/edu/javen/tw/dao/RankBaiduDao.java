package com.zucc.edu.javen.tw.dao;

import com.zucc.edu.javen.tw.entity.RankBaidu;

import java.util.List;

public interface RankBaiduDao {

    List<RankBaidu> getRankbaiduNewsList();

    List<RankBaidu> getHisRankbaiduNewsList(String getdate);
}
