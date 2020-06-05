package com.zucc.edu.javen.tw.frame;

import com.zucc.edu.javen.tw.entity.MediaEntity;
import com.zucc.edu.javen.tw.util.MyBatiesUtil;
import org.apache.ibatis.session.SqlSession;

public class GetLnquire {

    private static Lnquire getLnquire(String className) {
        try{
            Class clazz = Class.forName(className);
            Lnquire lnquire = (Lnquire) clazz.getAnnotation(Lnquire.class);
            return lnquire;
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }

    private static MediaEntity getMedia(String url){
        SqlSession session = MyBatiesUtil.getSession();
        MediaEntity entity = session.selectOne("getMedia",url);
        return entity;
    }

    public static NewsForm getform(String className){
//        Lnquire lnquire = getLnquire(className);
        MediaEntity entity = getMedia(className);
        NewsForm form = new NewsForm();
        form.setColumn("order by id desc");
        form.setDao("getNews");
        form.setLimit(entity.getRanknum()*2);
        form.setTable(entity.getTablename());
        return form;
    }

    public static NewsForm getHisForm(String className,String getdate){
//        Lnquire lnquire = getLnquire(className);
        MediaEntity entity = getMedia(className);
        NewsForm form = new NewsForm();
        form.setColumn("where get_date < '"+getdate+"' order by id desc");
        form.setDao("getNews");
        form.setLimit(entity.getRanknum()*2);
        form.setTable(entity.getTablename());
        return form;
    }
}
