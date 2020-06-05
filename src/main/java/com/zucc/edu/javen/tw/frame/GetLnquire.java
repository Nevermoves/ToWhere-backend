package com.zucc.edu.javen.tw.frame;

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

    public static NewsForm getform(String className){
        Lnquire lnquire = getLnquire(className);
        NewsForm form = new NewsForm();
        form.setColumn("order by id desc");
        if(lnquire.isMore())form.setDao("getMoreNews");
        else form.setDao("getNews");
        form.setLimit(lnquire.limit()*2);
        form.setTable(lnquire.table());
        return form;
    }

    public static NewsForm getHisForm(String className,String getdate){
        Lnquire lnquire = getLnquire(className);
        NewsForm form = new NewsForm();
        form.setColumn("where get_date < '"+getdate+"' order by id desc");
        if(lnquire.isMore())form.setDao("getMoreNews");
        else form.setDao("getNews");
        form.setLimit(lnquire.limit());
        form.setTable(lnquire.table());
        return form;
    }
}
