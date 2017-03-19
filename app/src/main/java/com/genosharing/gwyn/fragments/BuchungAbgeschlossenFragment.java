package com.genosharing.gwyn.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.genosharing.gwyn.R;
import com.genosharing.gwyn.activities.NavigatorActivity;
import com.genosharing.gwyn.data.DummyData;
import com.genosharing.gwyn.model.Accessory;
import com.genosharing.gwyn.model.ExchangeType;
import com.genosharing.gwyn.model.Inquiry;
import com.genosharing.gwyn.model.InsuranceType;

import org.joda.time.Instant;
import org.joda.time.Interval;

import java.util.ArrayList;

/**
 * Created by Corinna on 26.01.2017.
 */

public class BuchungAbgeschlossenFragment extends MenuItemFragment {

    Inquiry inquiry;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.booking_fragment, container, false);

        ImageView image = (ImageView) view.findViewById(R.id.buchung_abgeschlossen_image);
        image.setImageBitmap(getInquiry().getForOffer().getProduct().getImages().get(0));

        TextView nachricht = (TextView) view.findViewById(R.id.buchung_abgeschlossen_text);
        nachricht.setText("Du hast \"" + getInquiry().getForOffer().getProduct().getName() + "\" gebucht - teile die frohe Botschaft mit deinen Freunden!");

        return view;
    }

    @Override
    public String getBezeichnung() {
        return "Buchung abgeschlossen";
    }

    public void setInquiry(Inquiry anfrage) {
        this.inquiry = anfrage;
    }

    public Inquiry getInquiry() {
        if (inquiry == null)
        {
            return new Inquiry(DummyData.getOffers(getActivity()).get(2), new ArrayList<Accessory>(), InsuranceType.SomeRisk, ExchangeType.GWYN, new Interval(Instant.now(), Instant.now().plus(400000)));
        }
        return inquiry;
    }
}
