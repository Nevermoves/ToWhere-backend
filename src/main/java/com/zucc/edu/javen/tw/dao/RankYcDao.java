package com.zucc.edu.javen.tw.dao;

import com.zucc.edu.javen.tw.entity.RankYc;

import java.util.List;

public interface RankYcDao {
    List<RankYc> getRankycNewsList();

    List<RankYc> getHisRankycNewsList();
}
