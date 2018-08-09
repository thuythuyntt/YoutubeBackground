package com.youtu.sleep.youtubbackground.data.source.remote.listvideo;

import com.youtu.sleep.youtubbackground.data.source.YoutubeVideoDataSource;

/**
 * Created by thuy on 06/08/2018.
 */
public class HomeVideoRemoteDataSource implements YoutubeVideoDataSource.RemoteDataSource {

    private static final String MY_TAG = HomeVideoRemoteDataSource.class.getSimpleName();
    private OnActionRemoteListener mListener;

    private static HomeVideoRemoteDataSource instance;

    public static HomeVideoRemoteDataSource getInstance(){
        if(instance == null){
            instance = new HomeVideoRemoteDataSource();
        }
        return instance;
    }

    @Override
    public void getPopularVideos(OnActionRemoteListener listener) {
        this.mListener = listener;
        loadData();
    }

    @Override
    public void searchVideos(String query, OnActionRemoteListener listener) {
        this.mListener = listener;
        searchVideo(query);
    }

    private void searchVideo(String query) {
        SearchVideoAsyncTask myAsyncTask = new SearchVideoAsyncTask(mListener);
        myAsyncTask.execute(query);
    }

    private void loadData() {
        GetPopularVideoAsyncTask myAsyncTask = new GetPopularVideoAsyncTask(mListener);
        myAsyncTask.execute();
    }
}
