package com.zucc.edu.javen.tw.dao;

import com.zucc.edu.javen.tw.entity.RankWeibo;

import java.util.List;

public interface RankWeiboDao {

    List<RankWeiboDao> getNewsListByRank(int rank);

    List<Integer> getRankList();

    List<RankWeibo> getNewsList();
}
