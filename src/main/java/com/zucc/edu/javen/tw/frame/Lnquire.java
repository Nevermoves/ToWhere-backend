package com.zucc.edu.javen.tw.frame;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Lnquire {

    String table();

    int limit();

    boolean isMore() default false;
}
