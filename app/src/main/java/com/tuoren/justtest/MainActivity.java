package com.tuoren.justtest;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tuoren.sqlite.BaseDao;
import com.tuoren.sqlite.BaseDaoFactory;

/**
 * Create by JDT on 2020-05-18.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void insert(View view) {
        User user = new User(20, "李三", "lisan", "123456");
        BaseDao<User> baseDao = BaseDaoFactory.getInstance().getBaseDao(User.class);
    }
}
