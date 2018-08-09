package com.youtu.sleep.youtubbackground.screens.main.tabhome;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.youtu.sleep.youtubbackground.R;
import com.youtu.sleep.youtubbackground.data.model.popularvideo.Item;
import com.youtu.sleep.youtubbackground.screens.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements PopularVideosContract.View{

    private static final String VALUE_PART = "snippet";
    private static final String VALUE_CHART = "mostPopular";
    private View view;
    private List<Item> mList;
    private RecyclerView recyclerVideos;
    private PopularVideosAdapter mAdapter;
    private PopularVideosPresenter mPresenter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initializationViews();
        return view;
    }

    private void initializationViews() {
        mList = new ArrayList<>();
        recyclerVideos = (RecyclerView) view.findViewById(R.id.recycler_most_popular_videos);
//        LinearLayoutManager llm = new LinearLayoutManager(getContext());
//        recyclerVideos.setLayoutManager(llm);
        mAdapter = new PopularVideosAdapter(getContext(), mList);
        recyclerVideos.setAdapter(mAdapter);

        mPresenter = new PopularVideosPresenter(this);
        mPresenter.getPopularVideos(VALUE_PART, VALUE_CHART);
    }

    @Override
    public void showPopularVideos(List<Item> videos) {
        mList.addAll(videos);
        mAdapter.setList(mList);
    }

    @Override
    public void showGetPopularVideosErrorMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
