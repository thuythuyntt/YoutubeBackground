package com.youtu.sleep.youtubbackground.screens.main.tabhome;

import com.youtu.sleep.youtubbackground.data.model.popularvideo.Item;
import com.youtu.sleep.youtubbackground.data.source.PopularVideosDataSource;
import com.youtu.sleep.youtubbackground.data.source.remote.PopularVideosRemoteDataSource;

import java.util.List;

/**
 * Created by thuy on 06/08/2018.
 */
public class PopularVideosPresenter implements PopularVideosContract.Presenter {

    private PopularVideosContract.View mView;
    private PopularVideosDataSource.RemoteDataSource mModel;

    public PopularVideosPresenter(PopularVideosContract.View mView) {
        this.mView = mView;
        this.mModel = new PopularVideosRemoteDataSource();
    }

    @Override
    public void getPopularVideos(String part, String chart) {
        mModel.getPopularVideos(part, chart, new PopularVideosDataSource.OnGetPopularVideosListener() {
            @Override
            public void onSuccess(List<Item> list) {
                mView.showPopularVideos(list);
            }

            @Override
            public void onFail(String message) {
                mView.showGetPopularVideosErrorMessage(message);
            }
        });
    }
}
