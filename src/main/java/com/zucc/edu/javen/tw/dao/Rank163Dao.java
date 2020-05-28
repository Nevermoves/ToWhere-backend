package com.zucc.edu.javen.tw.dao;

import com.zucc.edu.javen.tw.entity.Rank163;

import java.util.List;

public interface Rank163Dao {
    List<Rank163> getRank163NewsList();

    List<Rank163> getHisRank163NewsList(String getdate);
}
