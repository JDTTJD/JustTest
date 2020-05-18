package com.tuoren.sqlite;

import android.database.sqlite.SQLiteDatabase;

import java.io.File;

/**
 * Create by JDT on 2020-05-18.
 * 创建数据库  生产表的操作对象
 */
public class BaseDaoFactory {
    private static BaseDaoFactory baseDaoFactory = new BaseDaoFactory();
    //数据库的存储位置
    private String dataPath;
    //数据库的操作引用
    private SQLiteDatabase sqLiteDatabase;

    private BaseDaoFactory() {
        dataPath = "/data/data/com.tuoren.justtest/databases/data.db";
        //判断当前的目录是否存在
        File file = new File(dataPath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        //创建数据库
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(dataPath, null);

    }

    public static BaseDaoFactory getInstance() {
        return baseDaoFactory;
    }

    /**
     * 生产表的操作对象
     * @param entityClass
     * @param <T>
     * @return
     */
    public<T> BaseDao<T> getBaseDao(Class<T> entityClass) {
        BaseDao baseDao = null;
        baseDao.init(sqLiteDatabase, entityClass);
        try {
            baseDao = BaseDao.class.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseDao;
    }


}
