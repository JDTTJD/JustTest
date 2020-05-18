package com.tuoren.justtest;

import com.tuoren.sqlite.DbField;
import com.tuoren.sqlite.DbTable;

/**
 * Create by JDT on 2020-05-18.
 */
@DbTable("tb_user")
public class User {

    Integer age;

    String name;
    @DbField("account")
    String account;
    @DbField("pwd")
    String password;

    public User(Integer age, String name, String account, String password) {
        this.age = age;
        this.name = name;
        this.account = account;
        this.password = password;
    }
}
