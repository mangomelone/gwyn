package com.genosharing.gwyn.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.genosharing.gwyn.R;

/**
 * Created by Corinna on 26.01.2017.
 */

public class ImpressumFragment extends MenuItemFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.impressum_fragment, container, false);
        Bitmap image = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.teambild);
        Bitmap imageResized = Bitmap.createScaledBitmap(image, (int) (image.getWidth() *  0.25), (int) (image.getHeight() * 0.25), true);
        ImageView profilePic = (ImageView) view.findViewById(R.id.teambild);
        profilePic.setImageBitmap(imageResized);
        return view;
    }

    @Override
    public String getBezeichnung() {
        return "Impressum";
    }
}
