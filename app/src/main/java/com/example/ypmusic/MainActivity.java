package com.example.ypmusic;

import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    private LinearLayout localMusic, onlineMusic;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPager();
//        initTabView();

    }

//    private void initTabView() {
//        localMusic = findViewById(R.id.id_tab_localMusic);
//        onlineMusic = findViewById(R.id.id_tab_onlineMusic);
//
//    }

    private void initPager() {
        viewPager = findViewById(R.id.viewpager);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(BlankFragment.newInstance("本地音乐"));
        fragments.add(BlankFragment.newInstance("在线音乐"));
        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter
                (getSupportFragmentManager(), getLifecycle(), fragments);
        viewPager.setAdapter(pagerAdapter);
    }
}
