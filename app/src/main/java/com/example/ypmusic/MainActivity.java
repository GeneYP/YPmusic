package com.example.ypmusic;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.ypmusic.adapter.MusicListAdapter;
import com.example.ypmusic.adapter.TabFragmentPagerAdapter;
import com.example.ypmusic.fragment.LocalMusicFragment;
import com.example.ypmusic.fragment.OnlineMusicFragment;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Fragment> fragmentList;
    private ViewPager viewPager;
    private TabFragmentPagerAdapter adapter;
    private TextView tv_local;
    private TextView tv_online;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化页面
        initView();
        //初始化Fragment
//        initFragment();
    }

//    private void initFragment() {
//    }

    private void initView() {
        tv_local = findViewById(R.id.id_tab_localMusic);
        tv_local.setOnClickListener(this);
        tv_online = findViewById(R.id.id_tab_onlineMusic);
        tv_online.setOnClickListener(this);
        viewPager = findViewById(R.id.viewpager);
        //点击事件
        viewPager.setOnPageChangeListener(new MyPagerChangeListener());
        fragmentList = new ArrayList<>();
        fragmentList.add(new LocalMusicFragment());
        fragmentList.add(new OnlineMusicFragment());
        adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);    //初始化显示第一个页面
        tv_online.setTextColor(getResources().getColor(R.color.theme2));
    }

    @Override
    public void onClick(View v) {
        changeTab(v.getId());
    }

    private void changeTab(int id) {
        //状态改变
        switch (id){
            case R.id.id_tab_localMusic:
                viewPager.setCurrentItem(0);
            case 0:
                tv_local.setTextColor(getResources().getColor(R.color.white));
                tv_online.setTextColor(getResources().getColor(R.color.theme2));
                break;
            case R.id.id_tab_onlineMusic:
                viewPager.setCurrentItem(1);
            case 1:
                tv_local.setTextColor(getResources().getColor(R.color.theme2));
                tv_online.setTextColor(getResources().getColor(R.color.white));
                break;
        }
    }

    public class MyPagerChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //skip
        }

        @Override
        public void onPageSelected(int position) {
            changeTab(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            //skip
        }

    }
}
