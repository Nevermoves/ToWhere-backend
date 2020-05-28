package com.zucc.edu.javen.tw.dao;

import com.zucc.edu.javen.tw.entity.RankTieba;

import java.util.List;

public interface RankTiebaDao {

    List<RankTieba> getRanktiebaNewsList();

    List<RankTieba> getHisRanktiebaNewsList(String getdate);
}
