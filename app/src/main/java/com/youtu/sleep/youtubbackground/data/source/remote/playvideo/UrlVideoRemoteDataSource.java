package com.youtu.sleep.youtubbackground.data.source.remote.playvideo;

import com.youtu.sleep.youtubbackground.data.model.popularvideo.Video;
import com.youtu.sleep.youtubbackground.data.source.UrlVideoDataSource;
import com.youtu.sleep.youtubbackground.screens.video.OnGetListUrlVideoYoutube;

import java.util.List;

/**
 * Created by DaiPhongPC on 8/8/2018.
 */

public class UrlVideoRemoteDataSource implements UrlVideoDataSource.RemoteDataSource {
    private static UrlVideoRemoteDataSource sInstance;

    private UrlVideoRemoteDataSource() {
    }

    public static UrlVideoRemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new UrlVideoRemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void getListUrlVideo(List<Video> videos, OnGetListUrlVideoYoutube onListener) {
        new GetUrlVideoAsyncTask(onListener).execute(videos);
    }
}
