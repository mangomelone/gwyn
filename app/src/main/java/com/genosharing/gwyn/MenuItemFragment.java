package com.genosharing.gwyn;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * Created by Blackrental on 07.12.2016.
 */

public class MenuItemFragment extends Fragment {

    public final static String ARG_MENU_ITEM_NUMBER = "itemNumber";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        savedInstanceState = getArguments();
        // Inflate the layout for this fragment
        if (EnumMenuItem.ENTDECKEN.equals(savedInstanceState.get(ARG_MENU_ITEM_NUMBER)))
        {
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
            buttonImage.setImageBitmap(resizedBtn);
            buttonImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavigatorActivity activity = (NavigatorActivity) getActivity();
                    activity.navigateTo(EnumMenuItem.ERGEBNISSE);
                }
            });

            return view;
        }
        if (EnumMenuItem.KATEGORIEN.equals(savedInstanceState.get(ARG_MENU_ITEM_NUMBER)))
        {
            return inflater.inflate(R.layout.categories, container, false);
        }
        if (EnumMenuItem.PROFIL.equals(savedInstanceState.get(ARG_MENU_ITEM_NUMBER)))
        {
            return inflater.inflate(R.layout.result_list, container, false);
        }
        if (EnumMenuItem.IMPRESSUM.equals(savedInstanceState.get(ARG_MENU_ITEM_NUMBER)))
        {
            return inflater.inflate(R.layout.result_list, container, false);
        }
        if (EnumMenuItem.HILFE.equals(savedInstanceState.get(ARG_MENU_ITEM_NUMBER)))
        {
            return inflater.inflate(R.layout.result_list, container, false);
        }
        if (EnumMenuItem.ERGEBNISSE.equals(savedInstanceState.get(ARG_MENU_ITEM_NUMBER)))
        {
            View view = inflater.inflate(R.layout.result_list, container, false);
            ResultListArrayAdapter adapter = new ResultListArrayAdapter(getActivity(),
                    R.layout.single_result, DummyData.getOffers(getActivity()));
            ListView listView = (ListView) view.findViewById(R.id.results);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                    NavigatorActivity activity = (NavigatorActivity) getActivity();
                                                    activity.navigateTo(EnumMenuItem.DETAIL);
                                                }
                                            });
            return view;
        }
        if (EnumMenuItem.DETAIL.equals(savedInstanceState.get(ARG_MENU_ITEM_NUMBER))) {
            View view = inflater.inflate(R.layout.activity_detail, container, false);
            ViewPager mViewPager = (ViewPager) view.findViewById(R.id.viewPageAndroid);
            AndroidImageAdapter adapterView = new AndroidImageAdapter(getActivity());
            mViewPager.setAdapter(adapterView);
            return view;
        }
        return null;
    }
}