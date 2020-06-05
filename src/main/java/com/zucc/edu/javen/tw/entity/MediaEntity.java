package com.zucc.edu.javen.tw.entity;

public class MediaEntity {

    private int id;
    private int kindid;
    private String medianame;
    private String tablename;
    private String mediaurl;
    private int ranknum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKindid() {
        return kindid;
    }

    public void setKindid(int kindid) {
        this.kindid = kindid;
    }

    public String getMedianame() {
        return medianame;
    }

    public void setMedianame(String medianame) {
        this.medianame = medianame;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getMediaurl() {
        return mediaurl;
    }

    public void setMediaurl(String mediaurl) {
        this.mediaurl = mediaurl;
    }

    public int getRanknum() {
        return ranknum;
    }

    public void setRanknum(int ranknum) {
        this.ranknum = ranknum;
    }
}
