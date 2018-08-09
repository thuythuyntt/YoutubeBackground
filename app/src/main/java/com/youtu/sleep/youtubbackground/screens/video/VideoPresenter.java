package com.youtu.sleep.youtubbackground.screens.video;

import com.youtu.sleep.youtubbackground.data.model.popularvideo.Video;
import com.youtu.sleep.youtubbackground.data.repository.UrlVideoRepository;

import java.util.List;

/**
 * Created by DaiPhongPC on 8/6/2018.
 */

public class VideoPresenter implements VideoContract.Presenter {
    private VideoContract.View mView;
    private UrlVideoRepository mUrlVideoRepository;

    public VideoPresenter(UrlVideoRepository mUrlVideoRepository) {
        this.mUrlVideoRepository = mUrlVideoRepository;
    }

    @Override
    public void setView(VideoContract.View view) {
        this.mView = view;
    }

    @Override
    public void onStart() {
        getListUrlVideo();
    }

    @Override
    public void onStop() {

    }

    @Override

    public void getListUrlVideo() {
        mUrlVideoRepository.getListUrlVideo(mView.getListVideo(), new OnGetListUrlVideoYoutube() {
            @Override
            public void onSuccess(List<Video> videos) {
                mView.showListVideo(videos);
            }

            @Override
            public void onError(String mess) {
                mView.showMessageErrorExtraUrlVideo(mess);
            }
        });
    }

    @Override
    public void updateVideoFavourite(Video video) {

    }

    @Override
    public void updateSettingLoopVideo() {

    }
}
