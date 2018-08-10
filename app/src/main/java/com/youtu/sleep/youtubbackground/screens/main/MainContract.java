package com.youtu.sleep.youtubbackground.screens.main;

import com.youtu.sleep.youtubbackground.data.model.popularvideo.Video;
import com.youtu.sleep.youtubbackground.screens.BasePresenter;

import java.util.List;

/**
 * Created by thuy on 01/08/2018.
 */
public interface MainContract {

    /*
     * View
     */
    interface View{
        void showResultSearch(List<Video> videos);
        void showFailedSearchMessage(String message);
    }

    /*
     * Presenter
     */

    interface Presenter extends BasePresenter<View>{
        void searchVideo(String query);
    }
}
