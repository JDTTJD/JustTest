package com.tuoren.sqlite;

/**
 * Create by JDT on 2020-05-18.
 * 数据库操作的顶层接口类
 */
public interface IBaseDao<T> {

    //增删改查
    long insert(T t);
}
