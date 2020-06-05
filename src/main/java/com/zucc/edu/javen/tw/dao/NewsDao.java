package com.zucc.edu.javen.tw.dao;

import com.zucc.edu.javen.tw.frame.NewsForm;
import com.zucc.edu.javen.tw.frame.NewsMoreResult;
import com.zucc.edu.javen.tw.frame.NewsResult;

import java.util.List;

public interface NewsDao {

    List<NewsResult> getNews(NewsForm newsForm);

    List<NewsMoreResult> getMoreNews(NewsForm newsForm);
}
