package com.zucc.edu.javen.tw.anno;

public class GetLnquire {

    public static Lnquire getLnquire(String className) {
        try{
            Class clazz = Class.forName(className);
            Lnquire lnquire = (Lnquire) clazz.getAnnotation(Lnquire.class);
            return lnquire;
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }
}
