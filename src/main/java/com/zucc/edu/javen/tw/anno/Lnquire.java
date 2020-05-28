package com.zucc.edu.javen.tw.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Lnquire {

    String table();

    int limit();

    boolean isMore() default false;
}
