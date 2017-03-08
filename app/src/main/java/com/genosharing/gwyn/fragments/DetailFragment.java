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

import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import com.genosharing.gwyn.ui.elements.AndroidImageAdapter;
import com.genosharing.gwyn.data.DummyData;
import com.genosharing.gwyn.ui.elements.ExpandableTextView;
import com.genosharing.gwyn.activities.NavigatorActivity;
import com.genosharing.gwyn.model.Offer;
import com.genosharing.gwyn.R;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Corinna on 26.01.2017.
 */

public class DetailFragment extends MenuItemFragment {

    private Offer angebot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_detail, container, false);

        TextView titel = (TextView) view.findViewById(R.id.detail_titel);
        titel.setText(getAngebot().getProduct().getName());

        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.viewPageAndroid);
        AndroidImageAdapter adapterView = new AndroidImageAdapter(getActivity());
        adapterView.setSliderImages(getAngebot().getProduct().getImages());
        mViewPager.setAdapter(adapterView);

        ExpandableTextView beschreibung = (ExpandableTextView) view.findViewById(R.id.txt_beschreibung);
        beschreibung.setText(getAngebot().getProduct().getDescription());

        TextView zubehoer = (TextView) view.findViewById(R.id.txt_zubehoer);
        StringBuilder builder = new StringBuilder();
        for (String zubehoerElement : getAngebot().getIncluded())
        {
            builder.append("- " + zubehoerElement + "\n");
        }
        zubehoer.setText(builder.toString());

        ImageView profilePic = (ImageView) view.findViewById(R.id.detail_profile_pic);
        profilePic.setImageBitmap(getAngebot().getVendor().getProfilePic());

        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.detail_rating);
        ratingBar.setRating(getAngebot().getVendor().getRating().getValue());

        TextView anbieter = (TextView) view.findViewById(R.id.lbl_anbieter);
        anbieter.setText("Anbieter: " + getAngebot().getVendor().getName());

        TextView anbieter_desc = (TextView) view.findViewById(R.id.detail_profile_description);
        anbieter_desc.setText(getAngebot().getVendor().getDescription());

        Button ausleihen = (Button) view.findViewById(R.id.ausleih_button);
        ausleihen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigatorActivity activity = (NavigatorActivity) getActivity();
                activity.navigateTo(new CheckoutFragment());
            }
        });

        final TextView verfuegbarkeit_txt = (TextView) view.findViewById(R.id.txt_verfuegbarkeit);
        final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
                DateTimeFormatter dateFormatter = DateTimeFormat.mediumDate().withLocale(Locale.GERMANY);
                // FIXME Month wird falsch übergeben -> +1
                DateTime from = new DateTime(year, monthOfYear + 1, dayOfMonth, 0, 0);
                DateTime until = new DateTime(yearEnd, monthOfYearEnd + 1, dayOfMonthEnd, 0, 0);
                verfuegbarkeit_txt.setText("Von " + dateFormatter.print(from) +
                        " bis " + dateFormatter.print(until));
            }
        };

        Button verfuegbarkeit = (Button) view.findViewById(R.id.verfuegbarkeit_button);
        verfuegbarkeit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        onDateSetListener,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });

        return view;
    }

    @Override
    public String getBezeichnung() {
        return "Detailansicht " + getAngebot().getProduct().getName();
    }

    public void setAngebot(Offer angebot) {
        this.angebot = angebot;
    }

    public Offer getAngebot() {
        if (angebot == null)
        {
            return DummyData.getOffers(getActivity()).get(2);
        }
        return angebot;
    }
}
