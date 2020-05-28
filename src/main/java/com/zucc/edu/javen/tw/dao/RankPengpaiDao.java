package com.zucc.edu.javen.tw.dao;

import com.zucc.edu.javen.tw.entity.RankPengpai;

import java.util.List;

public interface RankPengpaiDao {
    List<RankPengpai> getRankpengpaiNewsList();

    List<RankPengpai> getHisRankpengpaiNewsList(String getdate);
}
