package com.zucc.edu.javen.tw.entity;

import java.util.Date;

public class RankBaidu {

    int id;
    int url;
    String title;
    int adddate;
    Date getdate;
    int rank;
    String more;

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

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }
}
