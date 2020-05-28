package com.zucc.edu.javen.tw.dao;

import com.zucc.edu.javen.tw.entity.RankToutiao;

import java.util.List;

public interface RankToutiaoDao {
    List<RankToutiao> getRanktoutiaoNewsList();

    List<RankToutiao> getHisRanktoutiaoNewsList();
}
