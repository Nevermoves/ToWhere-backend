package com.zucc.edu.javen.tw.entity;

import com.zucc.edu.javen.tw.frame.Lnquire;

import java.util.Date;

@Lnquire(table = "rank_bilibili",limit = 100)
public class RankBilibili {

    private int id;
    private int url;
    private String title;
    private int adddate;
    private Date getdate;
    private int rank;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAdddate() {
        return adddate;
    }

    public void setAdddate(int adddate) {
        this.adddate = adddate;
    }

    public Date getGetdate() {
        return getdate;
    }

    public void setGetdate(Date getdate) {
        this.getdate = getdate;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
