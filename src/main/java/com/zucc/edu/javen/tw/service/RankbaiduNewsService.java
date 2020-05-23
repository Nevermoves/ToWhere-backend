package com.zucc.edu.javen.tw.service;

import com.zucc.edu.javen.tw.entity.RankBaidu;
import com.zucc.edu.javen.tw.entity.RankTieba;
import com.zucc.edu.javen.tw.service.impl.BaiduNewsServiceImpl;
import com.zucc.edu.javen.tw.util.MyBatiesUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Comparator;
import java.util.List;

public class RankbaiduNewsService implements BaiduNewsServiceImpl {
    @Override
    public List<RankBaidu> getRankbaiduNewsList() {
        SqlSession session = MyBatiesUtil.getSession();
        List<RankBaidu> list = session.selectList("getRankbaiduNewsList");
        for(int i = 0;i < list.size()-1;i++){
            if(list.get(i).getRank() == 1){
                list = list.subList(0,i+1);
                break;
            }
        }
        list.sort(Comparator.comparing(RankBaidu::getRank));
        return list;
    }

    @Override
    public List<RankTieba> getRanktiebaNewsList() {
        SqlSession session = MyBatiesUtil.getSession();
        List<RankTieba> list = session.selectList("getRanktiebaNewsList");
        for(int i = 0;i < list.size()-1;i++){
            if(list.get(i).getRank() == 1){
                list = list.subList(0,i+1);
                break;
            }
        }
        list.sort(Comparator.comparing(RankTieba::getRank));
        return list;
    }
}
