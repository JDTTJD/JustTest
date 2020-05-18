package com.tuoren.sqlite;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这个注解是标记需要创建表字段的成员变量
 * Create by JDT on 2020-05-18.
 */
@Target(ElementType.TYPE) //声明这个注解是放在成员变量上面的
@Retention(RetentionPolicy.RUNTIME) //声明注解的生命周期是运行期   源码期  编译期   运行期
public @interface DbTable {
    String value();
}

