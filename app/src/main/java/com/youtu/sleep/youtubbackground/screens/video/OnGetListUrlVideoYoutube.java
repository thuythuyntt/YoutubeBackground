package com.youtu.sleep.youtubbackground.screens.video;

import com.youtu.sleep.youtubbackground.data.model.popularvideo.Video;

import java.util.List;

/**
 * Created by DaiPhongPC on 8/9/2018.
 */

public interface OnGetListUrlVideoYoutube {
    void onSuccess(List<Video> videos);

    void onError(String mess);
}
