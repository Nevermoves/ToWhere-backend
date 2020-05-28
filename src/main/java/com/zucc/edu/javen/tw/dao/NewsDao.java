package com.zucc.edu.javen.tw.dao;

import com.zucc.edu.javen.tw.anno.NewsForm;
import com.zucc.edu.javen.tw.anno.NewsResult;

import java.util.List;

public interface NewsDao {

    List<NewsResult> getNews(NewsForm newsForm);
}
