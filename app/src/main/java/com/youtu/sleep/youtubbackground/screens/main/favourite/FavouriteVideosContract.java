package com.youtu.sleep.youtubbackground.screens.main.favourite;

import com.youtu.sleep.youtubbackground.data.model.popularvideo.Video;

import java.util.List;

/**
 * Created by thuy on 09/08/2018.
 */
public interface FavouriteVideosContract {
    interface View {
        void showFavouriteVideos(List<Video> videos);
        void showFavouriteVideosErrorMessage();

    }

    interface Presenter {
        void getFavouriteVideos();
    }
}
