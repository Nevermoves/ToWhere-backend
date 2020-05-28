package com.zucc.edu.javen.tw.dao;

import com.zucc.edu.javen.tw.entity.RankBilibili;

import java.util.List;

public interface RankBiliBiliDao {
    List<RankBilibili> getRankbilibiliNewsList();

    List<RankBilibili> getHisRankbilibiliNewsList(String getdate);
}
