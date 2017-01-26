package com.genosharing.gwyn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Corinna on 26.01.2017.
 */

public class CheckoutFragment extends MenuItemFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.checkout_fragment, container, false);
        Button buchen = (Button) view.findViewById(R.id.buchen_button);
        buchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigatorActivity activity = (NavigatorActivity) getActivity();
                activity.navigateTo(new BuchungAbgeschlossenFragment());
            }
        });
        return view;
    }

    @Override
    public String getBezeichnung() {
        return "Checkout";
    }
}
