package com.tuoren.sqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Field;

/**
 * Create by JDT on 2020-05-18.
 */
public class BaseDao<T> implements IBaseDao {
    //数据库的操作引用
    private SQLiteDatabase sqLiteDatabase;
    //操作的表的对应的类对象
    private Class<T> entityClass;
    //要操作的表的表名
    private String tableName;

    protected void init(SQLiteDatabase sqLiteDatabase, Class<T> entityClass) {
        this.sqLiteDatabase = sqLiteDatabase;
        this.entityClass = entityClass;
        //首先要做的事情就是创建表
        tableName = entityClass.getAnnotation(DbTable.class).value();
        //获取到创建表的语句
        String tableCreateStr = getCreateTableStr();
        sqLiteDatabase.execSQL(tableCreateStr);
    }


    /**
     * 创建表的语句
     * @return
     */
    private String getCreateTableStr() {
        //创建表create table if not exists tableName(_id integer,name varchar(20),pwd varchar(20))
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("create table if not exists");
        stringBuffer.append(tableName + "(");
        //通过反射获取到当前传进来的类对象中的所有的成员变量
        Field[] declaredFields = entityClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            DbField annotation = declaredField.getAnnotation(DbField.class);
            if (annotation == null) {
                continue;
            }
            String fieldName = annotation.value();
            Class<?> type = declaredField.getType();
            //判断类型
            if (type == String.class) {
                stringBuffer.append(fieldName + "TEXT,");
            } else if (type == Integer.class) {
                stringBuffer.append(fieldName + "INTEGER,");
            }else if (type == long.class) {
                stringBuffer.append(fieldName + "LONG,");
            }else if (type == Double.class) {
                stringBuffer.append(fieldName + "DOUBLE,");
            } else if (type == byte[].class) {
                stringBuffer.append(fieldName + "BLOB,");
            } else {
                //不支持的类型
                continue;
            }
        }
        if (stringBuffer.charAt(stringBuffer.length() - 1) == ',') {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        stringBuffer.append(")");
        return stringBuffer.toString();

    }

    @Override
    public long insert(Object object) {
        ContentValues contentValues = new ContentValues();

        return 0;
    }

}
