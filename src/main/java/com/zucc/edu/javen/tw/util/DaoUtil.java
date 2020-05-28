package com.zucc.edu.javen.tw.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DaoUtil {

    public static String getDaoName(String daoname){
        String[] path = daoname.split("\\.");
        String name = path[path.length-1].replace("Rank","");
        name = name.toLowerCase();
        return "getRank" + name + "NewsList";
    }

    public static String getPastDaoName(String daoname){
        String[] path = daoname.split("\\.");
        String name = path[path.length-1].replace("Rank","");
        name = name.toLowerCase();
        return "getHisRank" + name + "NewsList";
    }

    public static String getGetDate(Date date){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(date);
    }
}
