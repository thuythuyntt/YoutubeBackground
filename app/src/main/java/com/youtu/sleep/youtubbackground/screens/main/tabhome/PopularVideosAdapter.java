package com.youtu.sleep.youtubbackground.screens.main.tabhome;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.youtu.sleep.youtubbackground.R;
import com.youtu.sleep.youtubbackground.data.model.popularvideo.Item;

import java.util.List;

/**
 * Created by thuy on 01/08/2018.
 */
public class PopularVideosAdapter extends RecyclerView.Adapter<PopularVideosAdapter.MyViewHolder>{

    private Context mContext;
    private List<Item> mVideosList;

    public PopularVideosAdapter(Context context, List<Item> videosList) {
        this.mContext = context;
        this.mVideosList = videosList;
    }

    public void setList(List<Item> list){
        this.mVideosList.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindData(mVideosList.get(position));
    }

    @Override
    public int getItemCount() {
        return mVideosList == null ? 0 : mVideosList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageVideo;
        private TextView textDuration;
        private TextView textVideoName;
        private TextView textChannel;
        private TextView textDescription;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageVideo = itemView.findViewById(R.id.image_video);
            textDuration = itemView.findViewById(R.id.text_duration);
            textVideoName = itemView.findViewById(R.id.text_name);
            textChannel = itemView.findViewById(R.id.text_channel);
            textDescription = itemView.findViewById(R.id.text_description);
        }

        void bindData(Item video){
            Picasso.get().load(video.getSnippet().getThumbnails().getDefault().getUrl());
            textVideoName.setText(video.getSnippet().getTitle());
            textChannel.setText(video.getSnippet().getChannelTitle());
            textDescription.setText(video.getSnippet().getDescription());
        }
    }
}
