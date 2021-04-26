package com.example.ypmusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ypmusic.R;
import com.example.ypmusic.pojo.Rank;

import java.util.List;


public class RankListAdapter extends RecyclerView.Adapter<RankListAdapter.ViewHolder> {
    private Context context;
    private List<Rank> rankList;
    private int resource;

    @NonNull
    @Override
    public RankListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RankListAdapter.ViewHolder viewHolder;
        View view;
        view = LayoutInflater.from(context).inflate(resource,parent,false);
        viewHolder = new RankListAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Rank rank = rankList.get(position);
        holder.mRankImg.setImageResource(rank.getRankImgId());
        holder.mRankName1.setText(rank.getRankName1());
        holder.mRankName2.setText(rank.getRankName2());
        holder.mRankName3.setText(rank.getRankName3());
    }

    @Override
    public int getItemCount() {
        return rankList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView mRankImg;
        TextView mRankName1;
        TextView mRankName2;
        TextView mRankName3;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            mRankImg = itemView.findViewById(R.id.rankImg);
            mRankName1 = itemView.findViewById(R.id.rankName1);
            mRankName2 = itemView.findViewById(R.id.rankName2);
            mRankName3 = itemView.findViewById(R.id.rankName3);
        }

    }

    public RankListAdapter(Context context, List<Rank> rankList, int resource) {
        this.context = context;
        this.rankList = rankList;
        this.resource = resource;
    }
}
