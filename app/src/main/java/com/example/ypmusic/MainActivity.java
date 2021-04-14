package com.example.ypmusic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String[] CONTENT = new String[] {"本地音乐", "在线音乐"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置顶部菜单栏
        android.support.v4.app.ActionBar actionBar = getSupportActionBar();
    }
}
