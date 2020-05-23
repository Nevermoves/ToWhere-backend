package com.zucc.edu.javen.tw.service;

import com.zucc.edu.javen.tw.entity.RankWeibo;
import com.zucc.edu.javen.tw.service.impl.NewsServiceImpl;
import com.zucc.edu.javen.tw.util.MyBatiesUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NewsService implements NewsServiceImpl {
    @Override
    public List<RankWeibo> getNewsList() {
        SqlSession session = MyBatiesUtil.getSession();
        List<RankWeibo> list = session.selectList("getNewsList");

        for(int i = 0;i < list.size()-1;i++){
            if(list.get(i).getRank() == 1){
                list = list.subList(0,i+1);
                break;
            }
        }
        list.sort(Comparator.comparing(RankWeibo::getRank));
        return list;
    }
}
