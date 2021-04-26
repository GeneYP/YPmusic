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

import com.example.ypmusic.pojo.Music;
import com.example.ypmusic.R;
import com.example.ypmusic.adapter.MusicListAdapter;

import java.util.ArrayList;
import java.util.List;

public class LocalMusicFragment extends Fragment {

    private Context context;
    private RecyclerView recyclerView;

    public LocalMusicFragment(){
        //skip
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.local_list_layout,container,false);
//        initRecyclerView();
//        initData();
        //初始化RecyclerView
        recyclerView = view.findViewById(R.id.localList);
        context = getContext();
        //初始化Data
        List<Music> musicData = new ArrayList<Music>();
        for (int i = 0; i < 10; i++) {
            Music music = new Music();
            music.setCoverImgId(R.mipmap.default_cover);
            music.setMusicName("放弃啦不肝啦");
            music.setAuthorName("写个代码累死啦");
            musicData.add(music);
        }
        MusicListAdapter musicListAdapter = new MusicListAdapter(context,musicData,R.layout.music_layout);
        recyclerView.setAdapter(musicListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        //添加Android自带的分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        return view;
    }
//
//    private void initRecyclerView() {
//
//    }
//
//    private void initData(){
//
//    }
}
