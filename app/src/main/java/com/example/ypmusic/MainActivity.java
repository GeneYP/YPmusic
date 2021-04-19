package com.example.ypmusic;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ViewPager2 viewPager;
    private TextView TvLocalMusic, TvOnlineMusic, TvCurrent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPager();
        initTabView();
    }

    private void initTabView() {
        TvLocalMusic = findViewById(R.id.id_tab_localMusic);
        TvLocalMusic.setOnClickListener(this);
        TvOnlineMusic = findViewById(R.id.id_tab_onlineMusic);
        TvOnlineMusic.setOnClickListener(this);

        TvLocalMusic.setSelected(true);
        TvCurrent = TvLocalMusic;
    }

    private void initPager() {
        viewPager = findViewById(R.id.viewpager);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(BlankFragment.newInstance("本地音乐"));
        fragments.add(BlankFragment.newInstance("在线音乐"));
        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter
                (getSupportFragmentManager(), getLifecycle(), fragments);
        viewPager.setAdapter(pagerAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled
                    (int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void changeTab(int position) {
        TvCurrent.setSelected(false);
        switch (position){
            case R.id.id_tab_localMusic:
                viewPager.setCurrentItem(0);
            case 0:
                TvLocalMusic.setSelected(true);
                TvCurrent = TvLocalMusic;
                break;
            case R.id.id_tab_onlineMusic:
                viewPager.setCurrentItem(1);
            case 1:
                TvOnlineMusic.setSelected(true);
                TvCurrent = TvOnlineMusic;
                break;
        }
    }

    @Override
    public void onClick(View v) {
        changeTab(v.getId());
    }
}
