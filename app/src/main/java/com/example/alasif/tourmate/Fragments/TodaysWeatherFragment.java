package com.example.alasif.tourmate.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alasif.tourmate.R;

/**
 * Created by asif on 9/17/16.
 */
public class TodaysWeatherFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.todays_weather_fragment, container, false);
        //int currentLoggedInUserId = getIntent().getIntExtra("loggedInUser", 0);
    }
}
