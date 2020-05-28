package com.zucc.edu.javen.tw.dao;

import com.zucc.edu.javen.tw.entity.RankWeibo;

import java.util.List;

public interface RankWeiboDao {

    List<RankWeibo> getRankweiboNewsList();

    List<RankWeibo> getHisRankweiboNewsList();

}
