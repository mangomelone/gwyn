package com.genosharing.gwyn.fragments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.genosharing.gwyn.ui.elements.AndroidImageAdapter;
import com.genosharing.gwyn.data.DummyData;
import com.genosharing.gwyn.ui.elements.ExpandableTextView;
import com.genosharing.gwyn.activities.NavigatorActivity;
import com.genosharing.gwyn.model.Offer;
import com.genosharing.gwyn.R;

/**
 * Created by Corinna on 26.01.2017.
 */

public class DetailFragment extends MenuItemFragment {

    private Offer angebot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_detail, container, false);

        if (angebot == null)
        {
            angebot = DummyData.getOffers(getActivity()).get(2);
        }

        TextView titel = (TextView) view.findViewById(R.id.detail_titel);
        titel.setText(angebot.getProduct().getName());

        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.viewPageAndroid);
        AndroidImageAdapter adapterView = new AndroidImageAdapter(getActivity());
        adapterView.setSliderImages(angebot.getProduct().getImages());
        mViewPager.setAdapter(adapterView);

        ExpandableTextView beschreibung = (ExpandableTextView) view.findViewById(R.id.txt_beschreibung);
        beschreibung.setText(angebot.getProduct().getDescription());

        TextView zubehoer = (TextView) view.findViewById(R.id.txt_zubehoer);
        StringBuilder builder = new StringBuilder();
        for (String zubehoerElement : angebot.getIncluded())
        {
            builder.append("- " + zubehoerElement + "\n");
        }
        zubehoer.setText(builder.toString());

        ImageView profilePic = (ImageView) view.findViewById(R.id.detail_profile_pic);
        profilePic.setImageBitmap(angebot.getVendor().getProfilePic());

        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.detail_rating);
        ratingBar.setRating(angebot.getVendor().getRating().getValue());

        TextView anbieter = (TextView) view.findViewById(R.id.lbl_anbieter);
        anbieter.setText("Anbieter: " + angebot.getVendor().getName());

        TextView anbieter_desc = (TextView) view.findViewById(R.id.detail_profile_description);
        anbieter_desc.setText(angebot.getVendor().getDescription());

        Button ausleihen = (Button) view.findViewById(R.id.ausleih_button);
        ausleihen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigatorActivity activity = (NavigatorActivity) getActivity();
                activity.navigateTo(new CheckoutFragment());
            }
        });

        Button verfuegbarkeit = (Button) view.findViewById(R.id.verfuegbarkeit_button);
        verfuegbarkeit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigatorActivity activity = (NavigatorActivity) getActivity();
                VerfuegbarkeitFragment verfuegbarkeitFragment = new VerfuegbarkeitFragment();
                verfuegbarkeitFragment.setDetailFragment(DetailFragment.this);
                activity.navigateTo(verfuegbarkeitFragment);
            }
        });

        return view;
    }

    @Override
    public String getBezeichnung() {
        return "Detailansicht " + angebot.getProduct().getName();
    }

    public void setAngebot(Offer angebot) {
        this.angebot = angebot;
    }
}
