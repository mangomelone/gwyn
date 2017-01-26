package com.genosharing.gwyn;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Corinna on 26.01.2017.
 */

public class EntdeckenFragment extends MenuItemFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ad_fragment, container, false);

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

        final EditText sucher = (EditText) view.findViewById(R.id.input_email);

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

        return view;
    }

    @Override
    public String getBezeichnung() {
        return "Entdecken";
    }
}
