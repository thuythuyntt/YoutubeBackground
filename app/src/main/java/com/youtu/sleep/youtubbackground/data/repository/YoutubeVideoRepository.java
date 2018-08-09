package com.youtu.sleep.youtubbackground.data.repository;

import android.content.Context;

import com.youtu.sleep.youtubbackground.data.model.popularvideo.Video;
import com.youtu.sleep.youtubbackground.data.source.YoutubeVideoDataSource;
import com.youtu.sleep.youtubbackground.data.source.local.YoutubeVideoLocalDataSource;
import com.youtu.sleep.youtubbackground.data.source.remote.YoutubeVideoRemoteDataSource;

/**
 * Created by thuy on 09/08/2018.
 */
public class YoutubeVideoRepository implements YoutubeVideoDataSource.RemoteDataSource, YoutubeVideoDataSource.LocalDataSource {

    private static YoutubeVideoRepository instance;

    private YoutubeVideoRemoteDataSource mYoutubeVideoRemoteDataSource;
    private YoutubeVideoLocalDataSource mYoutubeVideoLocalDataSource;

    private YoutubeVideoRepository(Context context){
        mYoutubeVideoRemoteDataSource = YoutubeVideoRemoteDataSource.getInstance();
        mYoutubeVideoLocalDataSource = YoutubeVideoLocalDataSource.getInstance(context);
    }

    public static YoutubeVideoRepository getInstance(Context context){
        if(instance == null){
            instance = new YoutubeVideoRepository(context);
        }
        return instance;
    }

    @Override
    public void addToFavouriteVideoList(Video video, OnActionLocalListener listener) {
        mYoutubeVideoLocalDataSource.addToFavouriteVideoList(video, listener);
    }

    @Override
    public void getFavouriteVideos(OnActionLocalListener listener) {
        mYoutubeVideoLocalDataSource.getFavouriteVideos(listener);
    }

    @Override
    public void getPopularVideos(OnGetPopularVideosListener listener) {
        mYoutubeVideoRemoteDataSource.getPopularVideos(listener);
    }

    @Override
    public void removeFromFavouriteVideoList(Video video, OnActionLocalListener listener) {
        mYoutubeVideoLocalDataSource.removeFromFavouriteVideoList(video, listener);
    }
}
