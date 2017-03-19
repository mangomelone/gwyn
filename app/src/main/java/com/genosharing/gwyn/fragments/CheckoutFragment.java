package com.genosharing.gwyn.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.genosharing.gwyn.activities.NavigatorActivity;
import com.genosharing.gwyn.R;
import com.genosharing.gwyn.data.DummyData;
import com.genosharing.gwyn.model.Accessory;
import com.genosharing.gwyn.model.Inquiry;

import org.joda.time.Instant;
import org.joda.time.Interval;

import java.util.ArrayList;

/**
 * Created by Corinna on 26.01.2017.
 */

public class CheckoutFragment extends MenuItemFragment {

    private Inquiry inquiry;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.checkout_fragment, container, false);

        TextView header = (TextView) view.findViewById(R.id.checkout_header);
        header.setText(inquiry.getForOffer().getProduct().getName());

        addZusatzleistungen(view);

        Button buchen = (Button) view.findViewById(R.id.buchen_button);
        buchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigatorActivity activity = (NavigatorActivity) getActivity();
                BuchungAbgeschlossenFragment buchungAbgeschlossenFragment = new BuchungAbgeschlossenFragment();
                buchungAbgeschlossenFragment.setInquiry(getInquiry());
                activity.navigateTo(buchungAbgeschlossenFragment);
            }
        });
        return view;
    }

    private void addZusatzleistungen(View view)
    {
        LinearLayout checkboxenZusatzleistungen = (LinearLayout) view.findViewById(R.id.linearLayoutZusatzleistungen);
        for (Accessory zusatzleistung : getInquiry().getForOffer().getAccessories())
        {
            CheckBox checkboxZusatzleistung = new CheckBox(getActivity());
            checkboxZusatzleistung.setText(zusatzleistung.toString());
            checkboxenZusatzleistungen.addView(checkboxZusatzleistung);
        }
    }

    @Override
    public String getBezeichnung() {
        return "Checkout";
    }

    public void setInquiry(Inquiry anfrage) {
        this.inquiry = anfrage;
    }

    public Inquiry getInquiry() {
        if (inquiry == null)
        {
            return new Inquiry(DummyData.getOffers(getActivity()).get(2), new ArrayList<Accessory>(), null, null, new Interval(Instant.now(), Instant.now().plus(400000)));
        }
        return inquiry;
    }
}
