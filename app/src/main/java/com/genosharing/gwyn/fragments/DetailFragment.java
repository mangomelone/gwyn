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
import com.genosharing.gwyn.model.Inquiry;
import com.genosharing.gwyn.ui.elements.AndroidImageAdapter;
import com.genosharing.gwyn.data.DummyData;
import com.genosharing.gwyn.ui.elements.ExpandableTextView;
import com.genosharing.gwyn.activities.NavigatorActivity;
import com.genosharing.gwyn.R;

import net.danlew.android.joda.DateUtils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Corinna on 26.01.2017.
 */

public class DetailFragment extends MenuItemFragment {

    private Inquiry inquiry;
    private DatePickerDialog dpd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_detail, container, false);

        TextView titel = (TextView) view.findViewById(R.id.detail_titel);
        titel.setText(inquiry.getForOffer().getProduct().getName());

        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.viewPageAndroid);
        AndroidImageAdapter adapterView = new AndroidImageAdapter(getActivity());
        adapterView.setSliderImages(inquiry.getForOffer().getProduct().getImages());
        mViewPager.setAdapter(adapterView);

        ExpandableTextView beschreibung = (ExpandableTextView) view.findViewById(R.id.txt_beschreibung);
        beschreibung.setText(inquiry.getForOffer().getProduct().getDescription());

        TextView zubehoer = (TextView) view.findViewById(R.id.txt_zubehoer);
        StringBuilder builder = new StringBuilder();
        for (String zubehoerElement : inquiry.getForOffer().getIncluded())
        {
            builder.append("- " + zubehoerElement + "\n");
        }
        zubehoer.setText(builder.toString());

        ImageView profilePic = (ImageView) view.findViewById(R.id.detail_profile_pic);
        profilePic.setImageBitmap(inquiry.getForOffer().getVendor().getProfilePic());

        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.detail_rating);
        ratingBar.setRating(inquiry.getForOffer().getVendor().getRating().getValue());

        TextView anbieter = (TextView) view.findViewById(R.id.lbl_anbieter);
        anbieter.setText("Anbieter: " + inquiry.getForOffer().getVendor().getName());

        TextView anbieter_desc = (TextView) view.findViewById(R.id.detail_profile_description);
        anbieter_desc.setText(inquiry.getForOffer().getVendor().getDescription());

        Button ausleihen = (Button) view.findViewById(R.id.ausleih_button);
        ausleihen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigatorActivity activity = (NavigatorActivity) getActivity();
                CheckoutFragment checkoutFragment = new CheckoutFragment();
                checkoutFragment.setInquiry(getInquiry());
                activity.navigateTo(checkoutFragment);
            }
        });

        final TextView verfuegbarkeit_txt = (TextView) view.findViewById(R.id.txt_verfuegbarkeit);
        final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
                DateTimeFormatter dateFormatter = DateTimeFormat.mediumDate().withLocale(Locale.GERMANY);
                // FIXME Month wird falsch übergeben -> +1
                DateTime start = new DateTime(year, monthOfYear + 1, dayOfMonth, 0, 0);
                DateTime end = new DateTime(yearEnd, monthOfYearEnd + 1, dayOfMonthEnd, 0, 0);
                DateTime from;
                DateTime until;
                if (start.isBefore(end))
                {
                    from = start;
                    until = end;
                }
                else
                {
                    from = end;
                    until = start;
                }
                inquiry.setRentingTime(new Interval(from, until));
                verfuegbarkeit_txt.setText("Von " + dateFormatter.print(from) +
                        " bis " + dateFormatter.print(until));
            }
        };

        Button verfuegbarkeit = (Button) view.findViewById(R.id.verfuegbarkeit_button);
        verfuegbarkeit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar start;
                Calendar end;
                Calendar now = Calendar.getInstance();
                if (inquiry.getRentingTime() != null
                        && DateTimeComparator.getDateOnlyInstance().compare(inquiry.getRentingTime().getStart(), now) >= 0)
                {
                    start = inquiry.getRentingTime().getStart().toCalendar(Locale.GERMANY);
                    end = inquiry.getRentingTime().getEnd().toCalendar(Locale.GERMANY);
                }
                else
                {
                    start = end = now;
                }

                dpd = DatePickerDialog.newInstance(
                        onDateSetListener,
                        start.get(Calendar.YEAR),
                        start.get(Calendar.MONTH),
                        start.get(Calendar.DAY_OF_MONTH),
                        end.get(Calendar.YEAR),
                        end.get(Calendar.MONTH),
                        end.get(Calendar.DAY_OF_MONTH)
                );
                dpd.setMinDate(now);
                dpd.setAutoHighlight(true);
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });

        return view;
    }

    @Override
    public String getBezeichnung() {
        return "Detailansicht " + inquiry.getForOffer().getProduct().getName();
    }

    public void setInquiry(Inquiry inquiry) {
        this.inquiry = inquiry;
    }

    public Inquiry getInquiry() {
        if (inquiry == null)
        {
            return new Inquiry(DummyData.getOffers(getActivity()).get(2));
        }
        return inquiry;
    }
}
