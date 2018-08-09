package com.youtu.sleep.youtubbackground.screens.video;

import com.youtu.sleep.youtubbackground.data.model.popularvideo.Video;
import com.youtu.sleep.youtubbackground.screens.BasePresenter;

import java.util.List;

/**
 * Created by DaiPhongPC on 8/6/2018.
 */

public interface VideoContract {
    /**
     * View
     */
    interface View {
        int getCurrentPositionVideo();

        List<Video> getListVideo();

        String getIdVideo(int position);

        void showListVideo(List<Video> videos);

        void showMessageErrorExtraUrlVideo(String mess);

        void updateStatusFavouriteVideo(int status);
    }

    /**
     * Presenter
     */
    interface Presenter extends BasePresenter<View> {
        void getListUrlVideo();

        void updateVideoFavourite(Video video);

        void updateSettingLoopVideo();
    }

}
