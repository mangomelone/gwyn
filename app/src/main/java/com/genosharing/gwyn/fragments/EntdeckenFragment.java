package com.genosharing.gwyn.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.genosharing.gwyn.activities.NavigatorActivity;
import com.genosharing.gwyn.R;
import com.genosharing.gwyn.data.DummyData;
import com.genosharing.gwyn.fragments.result.ErgebnisseFragment;
import com.genosharing.gwyn.model.Offer;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Corinna on 26.01.2017.
 */

public class EntdeckenFragment extends MenuItemFragment {

    private List<Offer> amBestenBewertet;

    private List<Offer> amHäufigstenVerliehen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.entdecken_fragment, container, false);

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.slogan);
        Bitmap resizedSlogan = Bitmap.createScaledBitmap(bm, (int) (bm.getWidth() * 0.75), (int) (bm.getHeight() * 0.75), true);
        ImageView sloganImage = (ImageView) view.findViewById(R.id.imageView);
        sloganImage.setImageBitmap(resizedSlogan);

        Bitmap bm2 = BitmapFactory.decodeResource(getResources(), R.drawable.logo);
        Bitmap resized = Bitmap.createScaledBitmap(bm2, (int) (bm2.getWidth() * 0.6), (int) (bm2.getHeight() * 0.6), true);
        ImageView logoImage = (ImageView) view.findViewById(R.id.logoImageView);
        logoImage.setImageBitmap(resized);

        Bitmap bm3 = BitmapFactory.decodeResource(getResources(), R.drawable.btnfinden);
        Bitmap resizedBtn = Bitmap.createScaledBitmap(bm3, (int) (bm3.getWidth() * 0.5), (int) (bm3.getHeight() * 0.5), true);
        ImageView buttonImage = (ImageView) view.findViewById(R.id.btnSearch);

        final EditText sucher = (EditText) view.findViewById(R.id.input_suche);

        buttonImage.setImageBitmap(resizedBtn);
        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigatorActivity activity = (NavigatorActivity) getActivity();
                ErgebnisseFragment ergebnisseFragment = new ErgebnisseFragment();
                String suche = sucher.getText().toString();
                final List<String> suchworte = Arrays.asList(suche.split(" "));
                ergebnisseFragment.setSuchworte(suchworte);
                activity.navigateTo(ergebnisseFragment);
            }
        });

        amHäufigstenVerliehen = DummyData.getOffers(getActivity());
        LinearLayout linearLayoutEntliehen = (LinearLayout) view.findViewById(R.id.linearLayoutEntliehen);
        createScrollableOfferList(linearLayoutEntliehen, amHäufigstenVerliehen);

        amBestenBewertet = DummyData.getOffers(getActivity());
        LinearLayout linearLayoutBewertet = (LinearLayout) view.findViewById(R.id.linearLayoutBewertet);
        createScrollableOfferList(linearLayoutBewertet, amBestenBewertet);

        return view;
    }

    private void createScrollableOfferList(LinearLayout linearLayout, List<Offer> offers) {
        for (final Offer offer : offers)
        {
            ImageView tempImageView = new ImageView(getActivity());
            tempImageView.setImageBitmap(offer.getProduct().getImages().get(0));
            tempImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(200, 200);
            layoutParams.setMargins(0, 0, 50, 0);
            tempImageView.setLayoutParams(layoutParams);
            tempImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showOffer(offer);
                }
            });
            linearLayout.addView(tempImageView);
        }
    }

    public void showOffer(Offer offer)
    {
        NavigatorActivity activity = (NavigatorActivity) getActivity();
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setAngebot(offer);
        activity.navigateTo(detailFragment);
    }

    @Override
    public String getBezeichnung() {
        return "Entdecken";
    }
}
