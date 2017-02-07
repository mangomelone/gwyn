package com.genosharing.gwyn.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.genosharing.gwyn.R;

/**
 * Created by Corinna on 26.01.2017.
 */

public class StationsFragment extends MenuItemFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.stations_fragments, container, false);
    }

    @Override
    public String getBezeichnung() {
        return "GWYN-Stations";
    }
}
