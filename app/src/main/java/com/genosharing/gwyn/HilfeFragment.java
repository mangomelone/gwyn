package com.genosharing.gwyn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Corinna on 26.01.2017.
 */

public class HilfeFragment extends MenuItemFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.result_list, container, false);
    }

    @Override
    public String getBezeichnung() {
        return "Hilfe";
    }
}
