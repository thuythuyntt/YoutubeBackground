package com.youtu.sleep.youtubbackground.screens.main.tabrecent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youtu.sleep.youtubbackground.R;
import com.youtu.sleep.youtubbackground.screens.BaseFragment;

public class RecentFragment extends BaseFragment {

    public RecentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recent, container, false);
    }


}
