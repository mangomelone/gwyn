package com.genosharing.gwyn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Corinna on 26.01.2017.
 */

public class VerfuegbarkeitFragment extends MenuItemFragment {

    private DetailFragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.verfuegbarkeit_fragment, container, false);
        Button auswahl = (Button) view.findViewById(R.id.auswahl_button);
        auswahl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigatorActivity activity = (NavigatorActivity) getActivity();
                activity.navigateTo(fragment);
            }
        });
        return view;
    }

    @Override
    public String getBezeichnung() {
        return "Verfügbarkeit prüfen";
    }

    public void setDetailFragment(DetailFragment fragment) {
        this.fragment = fragment;
    }
}
