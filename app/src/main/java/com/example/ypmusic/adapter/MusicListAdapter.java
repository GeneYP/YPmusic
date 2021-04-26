package com.example.ypmusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ypmusic.pojo.Music;
import com.example.ypmusic.R;

import java.util.List;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> {
    private Context context;
    private List<Music> musicList;
    private int resource;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder;
        View view;
        view = LayoutInflater.from(context).inflate(resource,parent,false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Music music = musicList.get(position);
        holder.mCoverImg.setImageResource(music.getCoverImgId());
        holder.mMusicName.setText(music.getMusicName());
        holder.mAuthorName.setText(music.getAuthorName());
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView mCoverImg;
        TextView mAuthorName;
        TextView mMusicName;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            mCoverImg = itemView.findViewById(R.id.coverImg);
            mMusicName = itemView.findViewById(R.id.musicName);
            mAuthorName = itemView.findViewById(R.id.authorName);
        }

    }

    public MusicListAdapter(Context context, List<Music> musicList, int resource) {
        this.context = context;
        this.musicList = musicList;
        this.resource = resource;
    }
}
