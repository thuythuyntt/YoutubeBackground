package com.youtu.sleep.youtubbackground.screens.main.tabfavourite;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youtu.sleep.youtubbackground.R;
import com.youtu.sleep.youtubbackground.screens.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteFragment extends BaseFragment {


    public FavouriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite, container, false);
    }

}
