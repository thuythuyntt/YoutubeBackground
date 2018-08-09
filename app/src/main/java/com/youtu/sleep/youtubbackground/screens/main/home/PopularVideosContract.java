package com.youtu.sleep.youtubbackground.screens.main.home;

import com.youtu.sleep.youtubbackground.data.model.popularvideo.Video;

import java.util.List;

/**
 * Created by thuy on 06/08/2018.
 */
public interface PopularVideosContract {
    interface View {
        void showPopularVideos(List<Video> videos);

        void showGetPopularVideosErrorMessage(String message);

        void insertVideoListSuccessfully();

        void insertVideoListUnsuccessfully();

        void removeVideoFromFavouriteListSuccessfully();

    }

    interface Presenter {
        void getPopularVideos();

        void insertVideoList(Video video);

        void removeVideoList(Video video);
    }
}
