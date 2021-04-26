package com.example.ypmusic.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ypmusic.pojo.Rank;
import com.example.ypmusic.R;
import com.example.ypmusic.adapter.RankListAdapter;

import java.util.ArrayList;
import java.util.List;

public class OnlineMusicFragment extends Fragment {
    private Context context;
    private RecyclerView recyclerView;

    public OnlineMusicFragment(){
        //skip
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.online_list_layout,container,false);
//        initRecyclerView();
//        initData();
        //初始化RecyclerView
        recyclerView = view.findViewById(R.id.onlineList);
        context = getContext();
        //初始化Data
        List<Rank> rankData = new ArrayList<Rank>();
        for (int i = 0; i < 10; i++) {
            Rank rank = new Rank();
            rank.setRankImgId(R.mipmap.default_cover);
            rank.setRankName1("放弃啦不肝啦");
            rank.setRankName2("当个码农累死啦") ;
            rank.setRankName3("你妈写个半天bug到底为了啥");
            rankData.add(rank);
        }
        RankListAdapter rankListAdapter = new RankListAdapter(context,rankData,R.layout.rank_layout);
        recyclerView.setAdapter(rankListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        //添加Android自带的分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        return view;
    }
}
