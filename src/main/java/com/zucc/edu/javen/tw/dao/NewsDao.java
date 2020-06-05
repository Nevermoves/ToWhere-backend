package com.zucc.edu.javen.tw.dao;

import com.zucc.edu.javen.tw.frame.NewsForm;
import com.zucc.edu.javen.tw.frame.NewsMoreResult;
import com.zucc.edu.javen.tw.frame.NewsResult;

import java.util.List;
import java.util.Map;

public interface NewsDao {
//property
    List<Map<String,Object> > getNews(NewsForm newsForm);

    Map<String,Object> getNewsMap(NewsForm newsForm);

}
