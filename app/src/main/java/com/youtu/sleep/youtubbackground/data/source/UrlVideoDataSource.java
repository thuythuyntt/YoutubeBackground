package com.youtu.sleep.youtubbackground.data.source;

import com.youtu.sleep.youtubbackground.data.model.popularvideo.Video;
import com.youtu.sleep.youtubbackground.screens.video.OnGetListUrlVideoYoutube;

import java.util.List;

/**
 * Created by DaiPhongPC on 8/8/2018.
 */

public interface UrlVideoDataSource {

    /**
     * local url video
     */
    interface LocalDataSource extends UrlVideoDataSource {

    }

    /**
     * remote url video
     */
    interface RemoteDataSource extends UrlVideoDataSource {
        void getListUrlVideo(List<Video> videos, OnGetListUrlVideoYoutube onListener);
    }
}
